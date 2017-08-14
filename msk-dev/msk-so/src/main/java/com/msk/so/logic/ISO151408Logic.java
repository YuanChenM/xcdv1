package com.msk.so.logic;

import com.msk.common.consts.CapitalPoolConst;
import com.msk.common.consts.OrderConst;
import com.msk.common.consts.StatusConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.collections.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * ISO151408Logic.
 *
 * @author sjj
 */
@Service
public class ISO151408Logic extends BaseLogic {
    private static Logger logger = LoggerFactory.getLogger(ISO151408Logic.class);
    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private OrderLogic orderLogic;

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 创建标准分销退货单
     *
     * @param param
     * @author sjj
     */
    @Transactional
    public ISO151408RsResult returnOrder(RsRequest<ISO151408RsParam> param) {
        logger.debug("创建标准分销退货单");
        ISO151408RsResult result = new ISO151408RsResult();
        ISO151408RsParam iso151408RsParam = param.getParam();
        iso151408RsParam.setCrtId(param.getLoginId());

        Integer returnMode = iso151408RsParam.getReturnMode();
        SoOrder soOrder = super.findOne(SqlId.SQL_ID_FIND_SO_ORRDER, iso151408RsParam);
        if (null == soOrder) {
            throw new BusinessException("订单不存在，不能创建退货单");
        } else if (soOrder.getOrderStatus() != StatusConst.OrderStatusDef.ALL_RECEIPT
                && returnMode == OrderConst.ReturnMode.ALL) {
            throw new BusinessException("非全部收货，不能全部退货");
        } else if (!(soOrder.getOrderStatus() == StatusConst.OrderStatusDef.PARTIAL_RECEIPT
                || soOrder.getOrderStatus() == StatusConst.OrderStatusDef.ALL_RECEIPT)
                && returnMode == OrderConst.ReturnMode.APART) {
            throw new BusinessException("非收货状态，不能部分退货");
        } else {
            // 全部退货
            if (returnMode == OrderConst.ReturnMode.ALL) {
                Integer soReturnCount = super.getCount(SqlId.SQL_ID_FIND_SO_RETURN, iso151408RsParam);
                if (soReturnCount > NumberConst.IntDef.INT_ZERO) {
                    throw new BusinessException("该订单ID已有退货数据，不可全部退货！");
                }
                SoReturn soReturn = this.createSoReturn(soOrder, iso151408RsParam);
                // 查询退货单明细
                List<SoReturnDetail> soReturnDetailList = super.findList(SqlId.SQL_ID_FIND_SO_RETURN_DETAIL, iso151408RsParam);
                if (CollectionUtils.isNotEmpty(soReturnDetailList)) {
                    for (SoReturnDetail soReturnDetail : soReturnDetailList) {
                        Long returnDetailId = commonLogic.maxId("SO_RETURN_DETAIL", "DETAIL_ID");
                        soReturnDetail.setDetailId(returnDetailId);
                        soReturnDetail.setReturnId(soReturn.getReturnId());
                        soReturnDetail.setCrtId(iso151408RsParam.getCrtId());
                        soReturnDetail.setInboundBatch(soReturn.getReturnCode() + soReturn.getReturnId().toString());
                        soReturnDetail.setDetailReason(iso151408RsParam.getReturnReasonID());
                        soReturnDetail.setDetailStatus(StatusConst.SoReturnStatusDef.WAIT_PROCESS);
                        // add by wang_jianzhou for bug#3784 at 2016/11/24 start.
                        soReturnDetail.setWeight(soReturnDetail.getReturnQty().multiply(getPdInfo(soReturnDetail.getPdCode()).getNetweightOut()));
                        soReturnDetail.setVolume(soReturnDetail.getReturnQty().multiply(soReturnDetail.getPackingVolume()));
                        // add by wang_jianzhou for bug#3784 at 2016/11/24 end.
                        //保存订单详细到退货单详细
                        int saveSoReturnDetail = super.save(SqlId.SQL_ID_SAVE_SO_RETURN_DETAIL, soReturnDetail);
                        if (saveSoReturnDetail != NumberConst.IntDef.INT_ONE) {
                            throw new BusinessException("保存退货单明细表失败");
                        }
                    }
                }
                // 更新退货数量
                iso151408RsParam.setCrtTime(DateTimeUtil.getCustomerDate());
                super.modify(SqlId.SQL_ID_MODIFY_DETAIL_RETURN_QTY, iso151408RsParam);
                super.modify(SqlId.SQL_ID_MODIFY_DETAIL_AVAILABILITY_RETURN_QTY, iso151408RsParam);
                result.setReturnId(soReturn.getReturnId());
                result.setReturnCode(soReturn.getReturnCode());
                result.setCrtTime(soReturn.getCrtTime());
                result.setReturnStatus(soReturn.getReturnStatus());
                result.setVer(soReturn.getVer());
            } else {
                // 部分退货
                SoReturn soReturn = this.createSoReturn(soOrder, iso151408RsParam);
                for (ISO151408RsShipListParam shipParam : iso151408RsParam.getShipList()) {
                    for (ISO151408RsProductListParam productParam : shipParam.getProductList()) {
                        // check收货数量是否大于申请退货数量
                        SoOrderDetailAvailability soOrderDetailAvailability = super.findOne(SqlId.SQL_ID_FIND_AVAILABILITY, productParam);
                        if (soOrderDetailAvailability != null) {
                            if (DecimalUtil.isLess(soOrderDetailAvailability.getReceiveQty(), productParam.getReturnQty())) {
                                throw new BusinessException("退货数量超过收货数量！");
                            }
                        }
                        // 插入退货单明细
                        productParam.setFilterObject("shipId", shipParam.getShipId());
                        productParam.setCrtId(iso151408RsParam.getCrtId());
                        productParam.setCrtTime(DateTimeUtil.getCustomerDate());
                        this.createSoReturnDetail(soReturn.getReturnId(), soReturn.getReturnCode(), productParam);
                        // 更新退货数量
                        super.modify(SqlId.SQL_ID_MODIFY_DETAIL_RETURN_QTY_PARTIAL, productParam);
                        super.modify(SqlId.SQL_ID_MODIFY_DETAIL_AVAILABILITY_RETURN_QTY_PARTIAL, productParam);
                    }
                }
                result.setReturnId(soReturn.getReturnId());
                result.setReturnCode(soReturn.getReturnCode());
                result.setCrtTime(soReturn.getCrtTime());
                result.setReturnStatus(soReturn.getReturnStatus());
                result.setVer(soReturn.getVer());
            }
            // 更新order主表return_flg
            iso151408RsParam.setUpdTime(DateTimeUtil.getCustomerDate());
            super.modify(SqlId.SQL_ID_UPDATE_SO_ORDER, iso151408RsParam);
            SoOrderRelation relation = this.findOne(SqlId.SQL_ID_FIND_RELATION, iso151408RsParam);
            //  修改子订单
            if (relation != null) {
                iso151408RsParam.setOrderId(relation.getChildOrderId());
                super.modify(SqlId.SQL_ID_UPDATE_CHILD_ORDER, iso151408RsParam);
            }

        }
        return result;
    }

    /**
     * 保存退货单主表
     *
     * @param soOrder
     * @param iso151408RsParam
     * @author sjj
     */
    public SoReturn createSoReturn(SoOrder soOrder, ISO151408RsParam iso151408RsParam) {
        // 插入退货单主表
        SoReturn soReturn = new SoReturn();
        Long returnId = commonLogic.maxId("so_return", "RETURN_ID");
        soReturn.setReturnId(returnId);
        soReturn.setReturnCode(orderLogic.getReturnOrderCode(soReturn.getReturnId()));
        soReturn.setOrderId(iso151408RsParam.getOrderId());
        soReturn.setOrderCode(soOrder.getOrderCode());
        soReturn.setBuyersCode(soOrder.getBuyersCode());
        soReturn.setBuyersName(soOrder.getBuyersName());
        soReturn.setSellerCode(soOrder.getSellerCode());
        soReturn.setSellerName(soOrder.getSellerName());
        soReturn.setDistrictCode(soOrder.getDistrictCode());
        soReturn.setReturnSource(soOrder.getOrderSource());
        soReturn.setBuyersId(soOrder.getBuyersId());// 买家id
        soReturn.setRoleType(CapitalPoolConst.RoleType.ROLE_BIDDER);// 买家角色

        // 退货单类型 3-退货
        soReturn.setReturnType(OrderConst.ReturnType.RETURNED);
        soReturn.setReturnMode(StringUtil.toSafeString(iso151408RsParam.getReturnMode()));
        soReturn.setReturnReason(iso151408RsParam.getReturnReasonID());
        soReturn.setApplyMan(iso151408RsParam.getApplyMan());
        soReturn.setApplyTime(DateTimeUtil.parseDate(iso151408RsParam.getApplyTime(), DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS));
        soReturn.setApplyRemark(iso151408RsParam.getApplyRemark());
        soReturn.setReceiverName(iso151408RsParam.getReceiverName());
        soReturn.setReceiverTel(iso151408RsParam.getReceiverTel());
        soReturn.setIsPaid(StringUtil.toSafeString(iso151408RsParam.getIsPaid()));
        soReturn.setSellers(soOrder.getSellers());
        soReturn.setOrderTaker(soOrder.getOrderTaker());
        soReturn.setImage1(iso151408RsParam.getImage1());
        soReturn.setImage2(iso151408RsParam.getImage2());
        soReturn.setImage3(iso151408RsParam.getImage3());
        soReturn.setImage4(iso151408RsParam.getImage4());
        soReturn.setImage5(iso151408RsParam.getImage5());
        soReturn.setCrtId(iso151408RsParam.getCrtId());
        soReturn.setCrtTime(DateTimeUtil.getCustomerDate());
        soReturn.setVer(NumberConst.IntDef.INT_ONE);
        // 计算退货总金额
        BigDecimal returnAmountTotal = null;
        if (iso151408RsParam.getReturnMode() == OrderConst.ReturnMode.ALL) {
            // 全部退货计算退货总金额
            List<ISO151408Bean> iso151408Beans = super.findList(SqlId.SQL_ID_FIND_RETURN_AMOUNT, iso151408RsParam);
            for (ISO151408Bean iso151408Bean : iso151408Beans) {
                returnAmountTotal = DecimalUtil.add(returnAmountTotal, iso151408Bean.getReturnAmount());
            }
        } else {
            // 部分退货计算退货总金额
            for (ISO151408RsShipListParam shipParam : iso151408RsParam.getShipList()) {
                for (ISO151408RsProductListParam productParam : shipParam.getProductList()) {
                    BigDecimal PdPrice = (BigDecimal) super.findObject(SqlId.SQL_ID_FIND_PRICE, productParam);
                    returnAmountTotal = DecimalUtil.add(returnAmountTotal, DecimalUtil.multiply(PdPrice, productParam.getReturnQty()));
                }
            }
        }
        soReturn.setReturnAmount(returnAmountTotal);
        soReturn.setReturnStatus(StatusConst.SoReturnStatusDef.WAIT_PROCESS);
        soReturn.setCrtTime(DateTimeUtil.getCustomerDate());
        int save = super.save(SqlId.SQL_ID_SAVE_SO_RETURN, soReturn);
        if (save != NumberConst.IntDef.INT_ONE) {
            throw new BusinessException("保存退货单主表失败");
        }
        // 插入退货单状态表
        SoReturnStatus soReturnStatus = new SoReturnStatus();
        Long statusId = commonLogic.maxId("SO_RETURN_STATUS", "STATUS_ID");
        soReturnStatus.setStatusId(statusId);
        soReturnStatus.setReturnId(soReturn.getReturnId());
        soReturnStatus.setReturnCode(soReturn.getReturnCode());
        soReturnStatus.setReturnStatus(soReturn.getReturnStatus());
        soReturnStatus.setCrtId(soReturn.getCrtId());
        soReturnStatus.setCrtTime(DateTimeUtil.getCustomerDate());
        int saveStatus = super.save(SqlId.SQL_ID_SAVE_SO_RETURN_STATUS, soReturnStatus);
        if (saveStatus != NumberConst.IntDef.INT_ONE) {
            throw new BusinessException("保存退货单状态表失败");
        }
        return soReturn;
    }

    /**
     * 保存退货单明细表
     *
     * @param returnId
     * @param param
     * @param returnCode
     * @author sjj
     */
    public void createSoReturnDetail(Long returnId, String returnCode, ISO151408RsProductListParam param) {
        // 退货单明细表
        SoReturnDetail soReturnDetail = super.findOne(SqlId.SQL_ID_FIND_SO_RETURN_DETAIL_ONE, param);
        if (soReturnDetail == null) {
            throw new BusinessException("发货单号ID，发货明细ID不匹配！");
        }
        // Add by wang_jainzhou for bug#3736 at 2016/11/18 start.
        //查询产品包装信息
        PdNormsStd pdNormsStd = getPdInfo(param.getPdCode());
        if (null != pdNormsStd) {
            //本次退货重量
            soReturnDetail.setWeight((pdNormsStd.getNetweightOut().multiply(param.getReturnQty())));
        }
        //本次退货体积
        soReturnDetail.setVolume((soReturnDetail.getPackingVolume().multiply(param.getReturnQty())));
        // Add by wang_jainzhou for bug#3736 at 2016/11/18 end.
        Long detailId = commonLogic.maxId("SO_RETURN_DETAIL", "DETAIL_ID");
        soReturnDetail.setDetailId(detailId);
        soReturnDetail.setReturnId(returnId);
        soReturnDetail.setInboundBatch(returnCode + returnId.toString());
        soReturnDetail.setReturnQty(param.getReturnQty());
        soReturnDetail.setCrtId(param.getCrtId());
        soReturnDetail.setDetailReason(param.getDetailReasonID());
        soReturnDetail.setDetailStatus(StatusConst.SoReturnStatusDef.WAIT_PROCESS);
        soReturnDetail.setCrtTime(DateTimeUtil.getCustomerDate());
        int save = super.save(SqlId.SQL_ID_SAVE_SO_RETURN_DETAIL, soReturnDetail);
        if (save != NumberConst.IntDef.INT_ONE) {
            throw new BusinessException("保存退货单明细表失败");
        }
    }


    @Transactional
    public PdNormsStd getPdInfo(String pdCode) {
        BaseParam param = new BaseParam();
        param.setFilterObject("pdCode", pdCode);
        PdNormsStd pdNormsStd = super.findOne(SqlId.SQL_ID_FIND_PRODUCT_INFO, param);
        //Add by wang_jianzhou for bug#3736 at 2016/11/25 Start.
        if (null == pdNormsStd) {
            throw new BusinessException("产品编码为：" + pdCode + " 的产品找不到对应的标准包装信息");
        }
        //Add by wang_jianzhou for bug#3736 at 2016/11/25 end.
        return pdNormsStd;
    }


    /**
     * SqlId.
     *
     * @author sjj
     */
    interface SqlId {
        static final String SQL_ID_FIND_SO_ORRDER = "findSoOrder";
        static final String SQL_ID_SAVE_SO_RETURN = "saveSoReturn";
        static final String SQL_ID_FIND_SO_RETURN_DETAIL = "findSoReturnDetail";
        static final String SQL_ID_MODIFY_DETAIL_RETURN_QTY = "modifySoOrderDetailReturnQty";
        static final String SQL_ID_MODIFY_DETAIL_AVAILABILITY_RETURN_QTY = "modifySoOrderDetailAvailabilityReturnQty";
        static final String SQL_ID_FIND_AVAILABILITY = "findAvailability";
        static final String SQL_ID_FIND_SO_RETURN_DETAIL_ONE = "findSoReturnDetailOne";
        static final String SQL_ID_SAVE_SO_RETURN_DETAIL = "saveSoReturnDetail";
        static final String SQL_ID_MODIFY_DETAIL_RETURN_QTY_PARTIAL = "modifySoOrderDetailReturnQtyPartial";
        static final String SQL_ID_MODIFY_DETAIL_AVAILABILITY_RETURN_QTY_PARTIAL = "modifySoOrderDetailAvailabilityReturnQtyPartial";
        static final String SQL_ID_FIND_RETURN_AMOUNT = "findReturnAmount";
        static final String SQL_ID_FIND_PRICE = "findPrice";
        static final String SQL_ID_FIND_SO_RETURN = "findSoReturn";
        static final String SQL_ID_SAVE_SO_RETURN_STATUS = "saveSoReturnStatus";
        static final String SQL_ID_UPDATE_SO_ORDER = "updateSoOrder";
        static final String SQL_ID_FIND_PRODUCT_INFO = "findProductInfo";
        static final String SQL_ID_FIND_RELATION = "findOrderRelation";
        static final String SQL_ID_UPDATE_CHILD_ORDER = "updateChildSoOrder";
    }
}