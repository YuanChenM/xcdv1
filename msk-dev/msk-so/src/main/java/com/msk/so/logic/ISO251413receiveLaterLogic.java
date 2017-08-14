package com.msk.so.logic;

import com.msk.common.consts.CapitalPoolConst;
import com.msk.common.consts.OrderConst;
import com.msk.common.consts.StatusConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO251413OrderShipInfoRsParam;
import com.msk.so.bean.ISO251413OrderShipProductRsParam;
import com.msk.so.bean.ISO251413RsParam;
import com.msk.so.bean.order.SoReturnDetailInfo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 迟收再配送
 * Created by zhang_qiang1 on 2016/11/7.
 */
@Service
public class ISO251413receiveLaterLogic extends BaseLogic {


    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO251413receiveLaterLogic.class);

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private OrderLogic orderLogic;

    /**
     * 迟收操作
     *
     * @param param
     * @return
     */
    @Transactional
    public void doReceiverLater(ISO251413RsParam param) {
        this.checkRequired(param);
        param.setCrtTime(DateTimeUtil.getCustomerDate());
        SoOrder soOrder = this.findOne(SqlId.SQL_ID_GET_ORDER_INFO, param);
        param.setOrderId(soOrder.getOrderId());
        SoReturn soReturn = this.getReturnOrderInfo(param, soOrder);// 创建退迟收货单
        if (this.isAllReturn(param)) {// 全部
            soReturn.setReturnMode(NumberConst.IntDef.INT_ONE + "");
        } else {// 部分
            soReturn.setReturnMode(NumberConst.IntDef.INT_TWO + "");
        }
        this.partReceiverLater(param, soReturn);
        saveReturnStatus(soReturn);   //记录迟收履历
    }


    /**
     * 拒收时验证
     *
     * @param param
     */
    private void checkRequired(ISO251413RsParam param) {
        String applyMan = param.getApplyMan();
        if (StringUtil.isEmpty(applyMan) || applyMan.trim().length() > 20) {
            throw new BusinessException("迟收操作 : 申请人名称不能为空且长度不能大于20");
        }
        String applyTime = param.getApplyTime();
        if (StringUtil.isEmpty(applyTime)) {
            throw new BusinessException("迟收操作 : 申请时间（YYYY-MM-DD HH:mm:ss） 不能为空");
        }
        if (!StringUtil.isEmpty(applyTime)) {
            Date adjustTime = DateTimeUtil.parseDate(applyTime, "yyyy-MM-dd HH:mm:ss");
            if (adjustTime == null) {
                throw new BusinessException("迟收操作 : 申请时间 格式为：YYYY-MM-DD HH:mm:ss");
            }
        }
        String buyerId = param.getBuyerId();
        if (StringUtil.isEmpty(buyerId) || buyerId.trim().length() > 200) {
            throw new BusinessException("迟收操作 : 买家ID不能为空且长度不能大于200");
        }

        String receiptDate = param.getReceiptDate();//  时间格式待定   配送时间
        if (StringUtil.isEmpty(receiptDate)) {
            throw new BusinessException("迟收操作 : 迟收再配送时间（YYYY-MM-DD） 不能为空");
        }

        if (!StringUtil.isEmpty(receiptDate)) {
            Date receiveTime = DateTimeUtil.parseDate(receiptDate, "yyyy-MM-dd");
            if (receiveTime == null) {
                throw new BusinessException("迟收操作：迟收再配送时间 格式为：YYYY-MM-DD ");
            }
        }
        Integer returnReasonID = param.getReturnReasonID();
        if (returnReasonID == null) {
            throw new BusinessException("迟收操作 : 迟收原因ID 不能为空");
        }
        String returnReasonName = param.getReturnReasonName();
        if (StringUtil.isEmpty(returnReasonName) || returnReasonName.trim().length() > 200) {
            throw new BusinessException("迟收操作 : 迟收原因名称不能为空且长度不能大于200");
        }

    }

    /**
     * 记录迟收履历
     *
     * @param soReturn
     */
    @Transactional
    private void saveReturnStatus(SoReturn soReturn) {
        SoReturnStatus soReturnStatus = new SoReturnStatus();
        soReturnStatus.setCrtTime(soReturn.getCrtTime());
        soReturnStatus.setCrtId(soReturn.getCrtId());
        soReturnStatus.setReturnCode(soReturn.getReturnCode());
        soReturnStatus.setReturnId(soReturn.getReturnId());
        soReturnStatus.setReturnStatus(soReturn.getReturnStatus());
        soReturnStatus.setStatusId(commonLogic.maxId("so_return_status", "STATUS_ID"));
        super.save(SqlId.SQL_ID_SAVE_RETURN_STATUS, soReturnStatus);
    }

    /**
     * 遍历迟收到退货表中的数据
     *
     * @param param
     * @param soOrder
     * @return
     */
    @Transactional
    private SoReturn getReturnOrderInfo(ISO251413RsParam param, SoOrder soOrder) {
        SoReturn soReturn = new SoReturn();
        soReturn.setReturnId(commonLogic.maxId("so_return", "RETURN_ID"));
        soReturn.setReturnCode(orderLogic.getReturnOrderCode(soReturn.getReturnId()));
        soReturn.setBuyersId(soOrder.getBuyersId());//  买家id
        soReturn.setRoleType(CapitalPoolConst.RoleType.ROLE_BIDDER);// 角色  迟收   当面迟收角色是 买家 ;
        soReturn.setOrderId(soOrder.getOrderId());
        soReturn.setOrderCode(soOrder.getOrderCode());
        soReturn.setBuyersCode(soOrder.getBuyersCode());
        soReturn.setBuyersName(soOrder.getBuyersName());
        soReturn.setSellerCode(soOrder.getSellerCode());
        soReturn.setSellerName(soOrder.getSellerName());
        soReturn.setDistrictCode(soOrder.getDistrictCode());
        soReturn.setReturnSource(OrderConst.ReturnSource.PDA);
        soReturn.setReturnType(OrderConst.ReturnType.LATER);
        soReturn.setReturnReason(param.getReturnReasonID());
        soReturn.setApplyMan(param.getApplyMan());
        soReturn.setApplyTime(DateTimeUtil.parseDate(param.getApplyTime(), DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS));
        soReturn.setApplyRemark(param.getApplyRemark());
        soReturn.setIsPaid(param.getIsPaid().toString());
        soReturn.setIsInvoice(soOrder.getNeedInvoice());
        soReturn.setReturnStatus(StatusConst.SoReturnStatusDef.LATE_RECEIPT);
        soReturn.setSellers(soOrder.getSellers());
        soReturn.setCancelReason(param.getReturnReasonName());
        soReturn.setImage1(param.getImage1());
        soReturn.setImage2(param.getImage2());
        soReturn.setImage3(param.getImage3());
        soReturn.setImage4(param.getImage4());
        soReturn.setImage5(param.getImage5());
        soReturn.setCrtId(param.getUpdId());
        soReturn.setCrtTime(param.getCrtTime());
        return soReturn;
    }


    /**
     * 处理部分迟收
     *
     * @param param
     */
    @Transactional
    private void partReceiverLater(ISO251413RsParam param, SoReturn soReturn) {
        List<ISO251413OrderShipInfoRsParam> shipList = param.getShipList();
        if (CollectionUtils.isEmpty(shipList)) {
            throw new BusinessException("迟收明细不能为空");
        }
        BigDecimal allAmount = new BigDecimal(NumberConst.IntDef.INT_ZERO);
        for (ISO251413OrderShipInfoRsParam orderShipInfo : shipList) {
            List<ISO251413OrderShipProductRsParam> orderShipProductInfoList = orderShipInfo.getProductList();
            if (CollectionUtils.isEmpty(orderShipProductInfoList)) {
                throw new BusinessException("迟收明细的产品信息不能为空");
            }
            List<ISO251413OrderShipProductRsParam> productInfos = this.getProductList(orderShipProductInfoList);// 合并 订单供货明细
            List<SoReturnDetailInfo> soReturnDetailInfos = new ArrayList<>();
            for (ISO251413OrderShipProductRsParam productInfo : productInfos) {
                BigDecimal delayQty = productInfo.getDelayQty();// 迟收数量有才执行
                if (delayQty != null && DecimalUtil.isGreater(delayQty, new BigDecimal(0))) {
                    productInfo.setDeliverCode(orderShipInfo.getDeliverCode());
                    productInfo.setShipId(param.getShipId());
                    productInfo.setOrderId(param.getOrderId());
                    SoReturnDetailInfo soReturnDetailInfo = this.getPartReceiveDetail(productInfo);
                    soReturnDetailInfo.setReceiptDate(DateTimeUtil.parseDate(param.getReceiptDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDD));
                    String normName = soReturnDetailInfo.getNormsName();
                    //Bug #3736 退货单详情中重量和体积展示的不是本次退货的重量和体积
                    String pdCode=soReturnDetailInfo.getPdCode();
                    if (!StringUtil.isEmpty(pdCode)) {
                        soReturnDetailInfo.setWeight(delayQty.multiply(getPdInfo(pdCode).getNetweightOut()));
                    }
                    BigDecimal packingVolume = soReturnDetailInfo.getPackingVolume();
                    if (packingVolume != null) {  //  重新计算  体积
                        BigDecimal volume = DecimalUtil.multiply(delayQty, packingVolume);
                        soReturnDetailInfo.setVolume(volume);
                    }
                    soReturnDetailInfo.setDetailReason(param.getReturnReasonID());
                    soReturnDetailInfo.setCrtTime(param.getCrtTime());
                    soReturnDetailInfo.setCrtId(param.getCrtId());
                    soReturnDetailInfo.setReceiptDate(DateTimeUtil.parseDate(param.getReceiptDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDD));
                    soReturnDetailInfos.add(soReturnDetailInfo);
                }
            }
            allAmount = DecimalUtil.add(allAmount, getSumLaterAmount(soReturnDetailInfos));
            this.modifyOrderDetail(soReturnDetailInfos);  //处理订单明细的数据
            this.saveReturnDetail(soReturnDetailInfos, soReturn);//插入退货明细表
        }
        soReturn.setReturnAmount(allAmount);
        super.save(SqlId.SQL_ID_SAVE_RETURN_INFO, soReturn);
    }

    /**
     * 插入退货明细数据
     *
     * @param soReturnDetailInfos
     * @param soReturn
     */
    @Transactional
    private void saveReturnDetail(List<SoReturnDetailInfo> soReturnDetailInfos, SoReturn soReturn) {
        for (SoReturnDetailInfo soReturnDetailInfo : soReturnDetailInfos) {
            soReturnDetailInfo.setDetailId(commonLogic.maxId("so_return_detail", "DETAIL_ID"));
            soReturnDetailInfo.setCrtTime(DateTimeUtil.getCustomerDate());
            soReturnDetailInfo.setReturnId(soReturn.getReturnId());
            soReturnDetailInfo.setInboundBatch(soReturn.getReturnCode() + soReturn.getReturnId());
            soReturnDetailInfo.setRejectQty(soReturnDetailInfo.getLaterQty());
            super.save(SqlId.SQL_ID_SAVE_RETURN_DETAIL, soReturnDetailInfo);
        }
    }

    /**
     * 得到迟收部分总金额
     *
     * @param soReturnDetailInfos
     * @return
     */
    @Transactional
    private BigDecimal getSumLaterAmount(List<SoReturnDetailInfo> soReturnDetailInfos) {
        BigDecimal sumAmount = new BigDecimal(NumberConst.IntDef.INT_ZERO);
        for (SoReturnDetailInfo soReturnDetailInfo : soReturnDetailInfos) {
            sumAmount = DecimalUtil.add(sumAmount, DecimalUtil.multiply(soReturnDetailInfo.getLaterQty(), soReturnDetailInfo.getPdPrice()));
        }
        return sumAmount;
    }

    /**
     * 处理订单明细的数据
     *
     * @param soReturnDetailInfos 迟收的供货明细数据
     */
    @Transactional
    private void modifyOrderDetail(List<SoReturnDetailInfo> soReturnDetailInfos) {
        List<SoReturnDetailInfo> soReturnDetails = this.getOrderDetailList(soReturnDetailInfos);
        BigDecimal decimal = new BigDecimal(NumberConst.IntDef.INT_ZERO);
        for (SoReturnDetailInfo detailInfo : soReturnDetails) {
            if (detailInfo.getLaterQty().compareTo(detailInfo.getDetailLaterQty()) > NumberConst.IntDef.INT_ZERO) {
                throw new BusinessException("迟收数量大于可迟收数量");
            } else if (detailInfo.getLaterQty().compareTo(detailInfo.getDetailLaterQty()) == NumberConst.IntDef.INT_ZERO// 第一次 发货全部 迟收
                    && detailInfo.getDetailCancelQty().compareTo(decimal) == NumberConst.IntDef.INT_ZERO
                    && detailInfo.getDetailReceiveQty().compareTo(decimal) == NumberConst.IntDef.INT_ZERO
                    && detailInfo.getDetailRejectionQty().compareTo(decimal) == NumberConst.IntDef.INT_ZERO
                    && detailInfo.getDetailReturnQty().compareTo(decimal) == NumberConst.IntDef.INT_ZERO) {
                this.backDetailAndSuppInfo(soReturnDetails);//这条明细回滚
            } else {
                this.subDetailAndSuppInfo(soReturnDetailInfos, soReturnDetails); //这条明细拆分
            }
        }
    }

    /**
     * 在部分迟收时这条明细是全部迟收的情况下回滚明细和供货明细数据
     * 不用拆分数据
     *
     * @param soReturnDetails
     */
    @Transactional
    private void backDetailAndSuppInfo(List<SoReturnDetailInfo> soReturnDetails) {
        for (SoReturnDetailInfo soReturnDetailInfo : soReturnDetails) {
            soReturnDetailInfo.setOrderDetailStatus(StatusConst.OrderDetailStatusDef.CONFIRM);
            soReturnDetailInfo.setSuppStatus(StatusConst.OrderDetailAvailabilityStatusDef.CONFIRM);
            super.modify(SqlId.SQL_ID_MODIFY_ORDER_DETAIL, soReturnDetailInfo);
            super.modify(SqlId.SQL_ID_MODIFY_ORDER_SUPP, soReturnDetailInfo);
        }
    }

    /**
     * 部分迟收时拆分订单明细数据和供货明细数据
     *
     * @param soReturnDetailInfos 合并过的供货明细
     * @param soReturnDetails     迟收的供货明细 （没有合并过）
     */
    @Transactional
    private void subDetailAndSuppInfo(List<SoReturnDetailInfo> soReturnDetailInfos, List<SoReturnDetailInfo> soReturnDetails) {
        Integer zero = NumberConst.IntDef.INT_ZERO;
        //拆分明细
        for (SoReturnDetailInfo soReturnDetail : soReturnDetails) {
            BigDecimal laterQty = soReturnDetail.getLaterQty();
            BigDecimal detailQty = soReturnDetail.getDetailLaterQty();
            if (laterQty.compareTo(detailQty) > zero) {
                throw new BusinessException("迟收数量大于可迟收数量");
            }
            soReturnDetail.setOrderDetailIdNew(commonLogic.maxId("so_order_detail", "ORDER_DETAIL_ID"));
            soReturnDetail.setOrderDetailStatusNew(StatusConst.OrderDetailStatusDef.CONFIRM);
            super.save(SqlId.SQL_ID_SAVE_DETAIL_INFO, soReturnDetail);
            super.modify(SqlId.SQL_ID_MODIFY_ORDER_DETAIL_BY_ID, soReturnDetail);
        }

        //拆分供货明细
        for (SoReturnDetailInfo soReturnDetailInfo : soReturnDetailInfos) {
            BigDecimal laterQty = soReturnDetailInfo.getLaterQty();
            BigDecimal suppQty = soReturnDetailInfo.getSuppLaterQty();
            if (laterQty.compareTo(suppQty) > NumberConst.IntDef.INT_ZERO) {
                throw new BusinessException("迟收数量大于可迟收数量");
            }
            soReturnDetailInfo.setOrderDetailIdNew(getOrderDetailNew(soReturnDetails, soReturnDetailInfo));
            soReturnDetailInfo.setSuppStatusNew(StatusConst.OrderDetailAvailabilityStatusDef.CONFIRM);
            soReturnDetailInfo.setSuppIdNew(commonLogic.maxId("so_order_detail_availability", "ORDER_DETAIL_AVAILABILITY_ID"));
            super.save(SqlId.SQL_ID_SAVE_SUPP_INFO, soReturnDetailInfo);
            super.modify(SqlId.SQL_ID_MODIFY_ORDER_SUPP_BY_ID, soReturnDetailInfo);
        }
    }

    /**
     * 拆分订单明细时产生明细ID
     *
     * @param soReturnDetailInfos
     * @param soReturnDetail
     * @return
     */
    @Transactional
    private Long getOrderDetailNew(List<SoReturnDetailInfo> soReturnDetailInfos, SoReturnDetailInfo soReturnDetail) {
        for (SoReturnDetailInfo soReturnDetailInfo : soReturnDetailInfos) {
            if (soReturnDetailInfo.getDetailId() == soReturnDetail.getDetailId()) {
                return soReturnDetailInfo.getOrderDetailIdNew();
            }
        }
        return null;
    }

    /**
     * 合并订单明细ID相同的数据，并且迟收数量累加
     * 有迟收的明细 通过订单明细id
     *
     * @param soReturnDetailInfos
     * @return
     */
    @Transactional
    private List<SoReturnDetailInfo> getOrderDetailList(List<SoReturnDetailInfo> soReturnDetailInfos) {
        List<SoReturnDetailInfo> soReturnDetails = new ArrayList();
        soReturnDetails.add(soReturnDetailInfos.get(NumberConst.IntDef.INT_ZERO));
        for (int i = NumberConst.IntDef.INT_ONE; i < soReturnDetailInfos.size(); i++) {
            boolean addFlg = true;
            for (SoReturnDetailInfo productInfo : soReturnDetails) {
                SoReturnDetailInfo soReturnDetailInfo = soReturnDetailInfos.get(i);
                if (productInfo.getOrderDetailId().equals(soReturnDetailInfo.getOrderDetailId())) {// 如果在迟收的供货明细中  有相同的 供货明细id 就合并
                    productInfo.setLaterQty(DecimalUtil.add(productInfo.getLaterQty(), soReturnDetailInfo.getLaterQty()));
                    addFlg = false;
                }
            }
            if (addFlg) {
                soReturnDetails.add(soReturnDetailInfos.get(i));
            }
        }
        return soReturnDetails;
    }

    /**
     * 合并产品信息到明细层次，用于拆分明细数据
     *
     * @param productInfo
     * @return
     */
    @Transactional
    private SoReturnDetailInfo getPartReceiveDetail(ISO251413OrderShipProductRsParam productInfo) {
        SoReturnDetailInfo soReturnDetailInfo = super.findOne(SqlId.SQL_ID_GET_RETURN_DETAIL_INFO, productInfo);
        if (null == soReturnDetailInfo) {
            throw new BusinessException("没有找到可迟收的数据，请检验！！！");
        }
        soReturnDetailInfo.setLaterQty(productInfo.getDelayQty());
        soReturnDetailInfo.setLaterAmount(DecimalUtil.multiply(soReturnDetailInfo.getPdPrice(), productInfo.getDelayQty()));
        return soReturnDetailInfo;
    }

    /**
     * 合并产品数据中只是迟收数量不一样其他都相同的迟收产品信息
     *
     * @param orderShipProductInfos
     * @return
     */
    @Transactional
    private List<ISO251413OrderShipProductRsParam> getProductList(List<ISO251413OrderShipProductRsParam> orderShipProductInfos) {
        List<ISO251413OrderShipProductRsParam> productInfos = new ArrayList<>();
        productInfos.add(orderShipProductInfos.get(NumberConst.IntDef.INT_ZERO));
        for (int i = NumberConst.IntDef.INT_ONE; i < orderShipProductInfos.size(); i++) {
            boolean addFlg = true;
            for (ISO251413OrderShipProductRsParam productInfo : productInfos) {
                ISO251413OrderShipProductRsParam orderShipProductInfo = orderShipProductInfos.get(i);
                if (productInfo.getSkuCode().equals(orderShipProductInfo.getSkuCode())
                        && productInfo.getShipDetailId().equals(orderShipProductInfo.getShipDetailId())) {
                    BigDecimal delayQty = productInfo.getDelayQty();
                    BigDecimal qty = orderShipProductInfo.getDelayQty();
                    productInfo.setDelayQty(DecimalUtil.add(qty, delayQty));
                    addFlg = false;
                }
            }
            if (addFlg) {
                productInfos.add(orderShipProductInfos.get(i));
            }
        }
        return productInfos;
    }

    /**
     * 判断是否 是全部退货
     *
     * @param param
     * @return
     */
    private boolean isAllReturn(ISO251413RsParam param) {
        boolean flag = false;
        BaseParam baseParam = new BaseParam();
        Map<String, Object> filterMap = baseParam.getFilterMap();
        filterMap.put("orderId", param.getOrderId());
        SoOrderRelation relation = (SoOrderRelation) this.findObject(SqlId.SQL_ID_FIND_RELATION, param);
        if (relation != null) {// 主子订单都有
            Long childOrderId = relation.getChildOrderId();
            filterMap.put("childOrderId", childOrderId);
        }
        BigDecimal orderQty = (BigDecimal) this.findObject(SqlId.SQL_ID_GET_ORDER_QTY, baseParam); // 订单数量
        BigDecimal returnQty = this.getDelayQtyByShip(param);// 迟收数量
        if (DecimalUtil.isEquals(orderQty, returnQty)) {
            flag = true;
        }
        return flag;
    }


    /**
     * 获取该发货单的总共迟收收数量
     *
     * @param param
     * @return
     */
    public BigDecimal getDelayQtyByShip(ISO251413RsParam param) {
        BigDecimal sumDelayQty = null;
        List<ISO251413OrderShipInfoRsParam> shipList = param.getShipList();
        for (ISO251413OrderShipInfoRsParam ship : shipList) {// 合并相同的shipDetailId
            List<ISO251413OrderShipProductRsParam> productList = ship.getProductList();
            for (ISO251413OrderShipProductRsParam product : productList) {
                sumDelayQty = DecimalUtil.add(sumDelayQty, product.getDelayQty());// 累加 迟收数量
            }
        }
        return sumDelayQty;
    }

    /**
     *  根据pdCode  获取 产品
     * @param pdCode
     * @return
     */
    public PdNormsStd getPdInfo(String pdCode) {
        BaseParam param = new BaseParam();
        param.setFilterObject("pdCode", pdCode);
        PdNormsStd pdNormsStd = super.findOne(SqlId.SQL_ID_FIND_PRODUCT_INFO, param);
        if (null == pdNormsStd) {
            throw new BusinessException("产品编码为：" + pdCode + " 的产品找不到对应的标准包装信息");
        }
        return pdNormsStd;
    }


    interface SqlId {
        static final String SQL_ID_GET_ORDER_INFO = "getOrderInfo";
        static final String SQL_ID_SAVE_RETURN_INFO = "saveReturnInfo";
        static final String SQL_ID_SAVE_RETURN_DETAIL = "saveReturnDetail";
        static final String SQL_ID_GET_RETURN_DETAIL_INFO = "getReturnDetailInfo";
        static final String SQL_ID_MODIFY_ORDER_SUPP = "modifyOrderSupp";
        static final String SQL_ID_MODIFY_ORDER_DETAIL = "modifyOrderDetail";
        static final String SQL_ID_SAVE_DETAIL_INFO = "saveDetailInfo";
        static final String SQL_ID_SAVE_SUPP_INFO = "saveSuppInfo";
        static final String SQL_ID_MODIFY_ORDER_DETAIL_BY_ID = "modifyOrderDetailById";
        static final String SQL_ID_MODIFY_ORDER_SUPP_BY_ID = "modifyOrderSuppById";
        static final String SQL_ID_SAVE_RETURN_STATUS = "saveReturnStatus";
        static final String SQL_ID_FIND_RELATION = "findOrderRelation";
        static final String SQL_ID_GET_ORDER_QTY = "getOrderQty";
        static final String SQL_ID_FIND_PRODUCT_INFO = "findProductInfo";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


}
