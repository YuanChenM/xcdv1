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
import com.msk.so.bean.ModifyStatusParam;
import com.msk.so.bean.order.SoReturnDetailInfo;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * 拒收
 * Created by zhang_qiang1 on 2016/11/7.
 */
@Service
public class ISO251413receiveRejectLogic extends BaseLogic {


    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO251413receiveRejectLogic.class);

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private OrderLogic orderLogic;

    @Autowired
    private OrderStatusLogic orderStatusLogic;

    /**
     * 现场退货操作
     *
     * @param param
     * @return
     */
    @Transactional
    public void doReceiverReject(ISO251413RsParam param) {
        this.checkRequired(param);
        param.setCrtTime(DateTimeUtil.getCustomerDate());
        SoOrder soOrder = this.findOne(SqlId.SQL_ID_GET_ORDER_INFO, param);
        if (null == soOrder) {
            throw new BusinessException("没有对应的订单,请检验!!!");
        }
        param.setOrderId(soOrder.getOrderId());
        SoReturn soReturn = getReturnOrderInfo(param, soOrder);//创建拒收退货单
        if (this.isAllReturn(param)) {// 全部
            soReturn.setReturnMode(NumberConst.IntDef.INT_ONE + "");
        } else {// 部分
            soReturn.setReturnMode(NumberConst.IntDef.INT_TWO + "");
        }
        this.updateOrderReturnFlg(param, isAllReturn(param));// 设置 拒收 订单 详情显示 退货标识
        this.partReceiverReject(param, soReturn);
        this.saveReturnStatus(soReturn);//记录现场退货履历
    }


    /**
     * 拒收时验证
     *
     * @param param
     */
    private void checkRequired(ISO251413RsParam param) {
        String applyMan = param.getApplyMan();
        if (StringUtil.isEmpty(applyMan) || applyMan.trim().length() > 20) {
            throw new BusinessException("拒收操作 : 申请人名称不能为空且长度不能大于20");
        }
        String applyTime = param.getApplyTime();
        if (StringUtil.isEmpty(applyTime)) {
            throw new BusinessException("拒收操作 : 申请时间（YYYY-MM-DD HH:mm:ss） 不能为空");
        }
        if (!StringUtil.isEmpty(applyTime)) {
            Date adjustTime = DateTimeUtil.parseDate(applyTime, "yyyy-MM-dd HH:mm:ss");
            if (adjustTime == null) {
                throw new BusinessException("拒收操作 : 申请时间 格式为：YYYY-MM-DD HH:mm:ss");
            }
        }
        String buyerId = param.getBuyerId();
        if (StringUtil.isEmpty(buyerId) || buyerId.trim().length() > 200) {
            throw new BusinessException("拒收操作 : 买家ID不能为空且长度不能大于200");
        }

        Integer returnReasonID = param.getReturnReasonID();
        if (returnReasonID == null) {
            throw new BusinessException("拒收操作 : 退货原因ID 不能为空");
        }


        String returnReasonName = param.getReturnReasonName();
        if (StringUtil.isEmpty(returnReasonName) || returnReasonName.trim().length() > 200) {
            throw new BusinessException("拒收操作 : 退货原因名称不能为空且长度不能大于200");
        }
    }

    /**
     * 更新订单状态操作
     *
     * @param param
     */
    @Transactional
    public void modifyOrderStatus(ISO251413RsParam param) {
        ModifyStatusParam modifyStatusParam = new ModifyStatusParam();
        modifyStatusParam.setOrderId(param.getOrderId());
        modifyStatusParam.setUpdId(param.getUpdId());
        orderStatusLogic.modifyOrderStatusByOrderId(modifyStatusParam);
    }

    /**
     * 记录现场退货履历
     *
     * @param soReturn
     */
    @Transactional
    public void saveReturnStatus(SoReturn soReturn) {
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
     * 部分现场退货
     *
     * @param param
     * @param soReturn
     */
    @Transactional
    public void partReceiverReject(ISO251413RsParam param, SoReturn soReturn) {
        List<ISO251413OrderShipInfoRsParam> shipList = param.getShipList();
        if (CollectionUtils.isEmpty(shipList)) {
            throw new BusinessException("现场退货明细不能为空");
        }
        BigDecimal allAmount = new BigDecimal(NumberConst.IntDef.INT_ZERO);
        for (ISO251413OrderShipInfoRsParam orderShipInfo : shipList) {
            List<ISO251413OrderShipProductRsParam> productList = orderShipInfo.getProductList();
            if (CollectionUtils.isEmpty(productList)) {
                throw new BusinessException("现场退货产品明细不能为空");
            }
            orderShipInfo.setReturnId(soReturn.getReturnId());
            orderShipInfo.setReturnCode(soReturn.getReturnCode());
            BigDecimal amount = this.dealPartReceiverReject(orderShipInfo, productList, param);   //处理现场部分迟收数据导退货明细表中并且得到所有的拒收金额
            allAmount = DecimalUtil.add(allAmount, amount);
        }
        soReturn.setReturnAmount(allAmount);
        super.save(SqlId.SQL_ID_SAVE_RETURN_INFO, soReturn);
    }

    /**
     * 处理现场部分迟收数据导退货明细表中
     *
     * @param orderShipInfo
     * @param productList
     */
    public BigDecimal dealPartReceiverReject(ISO251413OrderShipInfoRsParam orderShipInfo, List<ISO251413OrderShipProductRsParam> productList, ISO251413RsParam param) {
        BigDecimal amount = new BigDecimal(NumberConst.IntDef.INT_ZERO);
        List<SoReturnDetailInfo> soReturnDetailInfoList = new ArrayList<>();
        for (ISO251413OrderShipProductRsParam productInfo : productList) {
            BigDecimal returnQty = productInfo.getReturnQty();
            if (returnQty != null && DecimalUtil.isGreater(returnQty, new BigDecimal(0))) {// 拒收有数量才执行
                productInfo.setShipId(param.getShipId());
                productInfo.setDeliverCode(orderShipInfo.getDeliverCode());
                SoReturnDetailInfo soReturnDetailInfo = super.findOne(SqlId.SQL_ID_GET_RETURN_DETAIL_INFO, productInfo);
                if (null == soReturnDetailInfo) {
                    throw new BusinessException("拒收没有对应的订单数据请检验！！！");
                }
                soReturnDetailInfo.setRejectQty(returnQty);
                soReturnDetailInfo.setDetailReason(param.getReturnReasonID());
                soReturnDetailInfo.setCrtId(param.getCrtId());
                soReturnDetailInfo.setCrtTime(DateTimeUtil.getCustomerDate());
                BigDecimal rejectQty = productInfo.getReturnQty();
                BigDecimal suppQty = soReturnDetailInfo.getSuppRejectQty();
                if (rejectQty.compareTo(suppQty) > NumberConst.IntDef.INT_ZERO) {
                    throw new BusinessException("可退货数量小于退货数量，请检验！！！");
                }
                super.modify(SqlId.SQL_ID_MODIFY_DETAIL_INFO, soReturnDetailInfo);// 修改 订单明细中 拒收数量
                super.modify(SqlId.SQL_ID_MODIFY_SUPP_INFO, soReturnDetailInfo);// 修改 供货明细中 拒收数量
                soReturnDetailInfo.setDetailId(commonLogic.maxId("so_return_detail", "DETAIL_ID"));
                //Bug #3736 退货单详情中重量和体积展示的不是本次退货的重量和体积
                String pdCode=soReturnDetailInfo.getPdCode();
                if (!StringUtil.isEmpty(pdCode)) {
                    soReturnDetailInfo.setWeight(rejectQty.multiply(getPdInfo(pdCode).getNetweightOut()));
                }
                BigDecimal packingVolume = soReturnDetailInfo.getPackingVolume();
                if (packingVolume != null) {  //  重新计算  体积
                    BigDecimal volume = DecimalUtil.multiply(rejectQty, packingVolume);
                    soReturnDetailInfo.setVolume(volume);
                }
                soReturnDetailInfo.setCrtTime(DateTimeUtil.getCustomerDate());
                soReturnDetailInfo.setReturnId(orderShipInfo.getReturnId());
                soReturnDetailInfo.setInboundBatch(orderShipInfo.getReturnCode() + orderShipInfo.getReturnId());
                soReturnDetailInfoList.add(soReturnDetailInfo);
                super.save(SqlId.SQL_ID_SAVE_RETURN_DETAIL, soReturnDetailInfo);
                amount = DecimalUtil.add(amount, DecimalUtil.multiply(soReturnDetailInfo.getRejectQty(), soReturnDetailInfo.getPdPrice()));

            }
        }
        return amount;
    }



    /**
     * 合并相同的pd 退货数量 并保存
     *
     * @param soReturnDetailInfoList
     */
    private void saveSoReturnDetailList(List<SoReturnDetailInfo> soReturnDetailInfoList) {
        Map<String, SoReturnDetailInfo> map = new HashMap<>();
        for (SoReturnDetailInfo returnDetail : soReturnDetailInfoList) {
            String pdCode = returnDetail.getPdCode();
            SoReturnDetailInfo mapReturnDetail = map.get(pdCode);
            if (mapReturnDetail != null) {// 已经在map
                BigDecimal listReturnDetailRejectQty = returnDetail.getRejectQty();
                BigDecimal mapReturnDetailRejectQty = mapReturnDetail.getRejectQty();
                mapReturnDetail.setRejectQty(DecimalUtil.add(listReturnDetailRejectQty, mapReturnDetailRejectQty));
            } else {
                map.put(pdCode, returnDetail);
            }
        }

        //  遍历保存 退货明细
        for (String pdCode : map.keySet()) {
            SoReturnDetailInfo returnDetailInfo = map.get(pdCode);
            returnDetailInfo.setDetailId(commonLogic.maxId("so_return_detail", "DETAIL_ID"));
            super.save(SqlId.SQL_ID_SAVE_RETURN_DETAIL, returnDetailInfo);

        }

    }


    /**
     * 遍历现场退货到退货表中的数据
     *
     * @param param
     * @param soOrder
     * @return
     */
    @Transactional
    public SoReturn getReturnOrderInfo(ISO251413RsParam param, SoOrder soOrder) {
        SoReturn soReturn = new SoReturn();
        soReturn.setReturnId(commonLogic.maxId("so_return", "RETURN_ID"));
        soReturn.setReturnCode(orderLogic.getReturnOrderCode(soReturn.getReturnId()));
        soReturn.setOrderId(param.getOrderId());
        soReturn.setBuyersId(soOrder.getBuyersId());//  买家id
        soReturn.setRoleType(CapitalPoolConst.RoleType.ROLE_BIDDER);// 角色   拒收  买家
        soReturn.setOrderCode(soOrder.getOrderCode());
        soReturn.setBuyersCode(soOrder.getBuyersCode());
        soReturn.setBuyersName(soOrder.getBuyersName());
        soReturn.setSellerCode(soOrder.getSellerCode());
        soReturn.setSellerName(soOrder.getSellerName());
        soReturn.setDistrictCode(soOrder.getDistrictCode());
        soReturn.setReturnSource(OrderConst.ReturnSource.PDA);
        soReturn.setReturnType(OrderConst.ReturnType.REJECT);
        soReturn.setReturnReason(param.getReturnReasonID());
        soReturn.setApplyMan(param.getApplyMan());
        soReturn.setApplyTime(DateTimeUtil.parseDate(param.getApplyTime(), DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS));
        soReturn.setApplyRemark(param.getApplyRemark());
        soReturn.setIsPaid(param.getIsPaid().toString());
        soReturn.setIsInvoice(soOrder.getNeedInvoice());
        soReturn.setReturnStatus(StatusConst.SoReturnStatusDef.WAIT_PROCESS);
        soReturn.setSellers(soOrder.getSellers());
        soReturn.setCancelReason(param.getReturnReasonName());
        soReturn.setImage1(param.getImage1());
        soReturn.setImage2(param.getImage2());
        soReturn.setImage3(param.getImage3());
        soReturn.setImage4(param.getImage4());
        soReturn.setImage5(param.getImage5());
        soReturn.setCrtId(param.getCrtId());
        soReturn.setCrtTime(param.getCrtTime());
        return soReturn;
    }


    /**
     * 修改主子订单   退货标志
     *
     * @param param
     */
    private void updateOrderReturnFlg(ISO251413RsParam param, boolean isAllReturn) {
        SoOrderRelation relation = (SoOrderRelation) this.findObject(SqlId.SQL_ID_FIND_RELATION, param);
        BaseParam baseParam = new BaseParam();
        Map<String, Object> filterMap = baseParam.getFilterMap();
        filterMap.put("updId", param.getUpdId());
        filterMap.put("updTime", DateTimeUtil.getCustomerDate());
        filterMap.put("orderId", param.getOrderId());
        if (isAllReturn) { // 全退
            if (relation != null) {// 主子订单都有
                Long childOrderId = relation.getChildOrderId();
                filterMap.put("childOrderId", childOrderId);
            }
            filterMap.put("returnFlg", 1);
            this.modify(SqlId.SQL_ID_UPDATE_ORDER_RETURN_FLG, baseParam);

        } else { // 部分退
            // 主订单
            filterMap.put("returnFlg", 2);
            this.modify(SqlId.SQL_ID_UPDATE_ORDER_RETURN_FLG, baseParam);
            if (relation != null) { // 子订单
                Long childOrderId = relation.getChildOrderId();
                filterMap.put("orderId", childOrderId);
                BigDecimal childQtyByShip = this.getChildOrderQtyByShip(childOrderId, param);   // 发货单订单量
                BigDecimal childQty = (BigDecimal) this.findObject(SqlId.SQL_ID_GET_ORDER_QTY, baseParam);      // 子订单可退货数量
                if (DecimalUtil.isEquals(childQty, childQtyByShip)) {
                    filterMap.put("returnFlg", 1);// 子订单全退
                } else {
                    filterMap.put("returnFlg", 2);// 部分退
                }
                this.modify(SqlId.SQL_ID_UPDATE_ORDER_RETURN_FLG, baseParam);
            }
        }
    }


    /**
     * 获取子订单在发货单中的量
     *
     * @param childOrderId
     * @param param
     * @return
     */
    private BigDecimal getChildOrderQtyByShip(Long childOrderId, ISO251413RsParam param) {
        BigDecimal childQtyByShip = null;
        BaseParam baseParam = new BaseParam();
        baseParam.getFilterMap().put("childOrderId", childOrderId);
        List<SoOrderDetailAvailability> avaList = this.findList(SqlId.SQL_ID_FIND_AVA_IDS, baseParam);
        List<Long> avaIds = new ArrayList<>();
        for (SoOrderDetailAvailability ava : avaList) {
            avaIds.add(ava.getOrderDetailAvailabilityId());
        }
        List<ISO251413OrderShipInfoRsParam> shipList = param.getShipList();
        for (ISO251413OrderShipInfoRsParam shipInfoRsParam : shipList) {
            for (ISO251413OrderShipProductRsParam product : shipInfoRsParam.getProductList()) {
                if (avaIds.contains(product.getShipDetailId())) {
                    childQtyByShip = DecimalUtil.add(childQtyByShip, product.getReturnQty());
                }
            }
        }
        return childQtyByShip;
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
        BigDecimal orderQty = (BigDecimal) this.findObject(SqlId.SQL_ID_GET_ORDER_QTY, baseParam); // 可拒收数量
        BigDecimal returnQty = this.getReturnQtyByShip(param);// 本次拒收数量
        if (DecimalUtil.isEquals(orderQty, returnQty)) {
            flag = true;
        }
        return flag;
    }


    /**
     * 获取该发货单的总共拒收数量
     *
     * @param param
     * @return
     */
    public BigDecimal getReturnQtyByShip(ISO251413RsParam param) {
        BigDecimal sumReturnQty = null;
        List<ISO251413OrderShipInfoRsParam> shipList = param.getShipList();
        for (ISO251413OrderShipInfoRsParam ship : shipList) {// 合并相同的shipDetailId
            List<ISO251413OrderShipProductRsParam> productList = ship.getProductList();
            for (ISO251413OrderShipProductRsParam product : productList) {
                sumReturnQty = DecimalUtil.add(sumReturnQty, product.getReturnQty());// 累加 拒收数量
            }
        }
        return sumReturnQty;
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
        static final String SQL_ID_MODIFY_DETAIL_INFO = "modifyDetailInfo";
        static final String SQL_ID_MODIFY_SUPP_INFO = "modifySuppInfo";
        static final String SQL_ID_SAVE_RETURN_STATUS = "saveReturnStatus";
        static final String SQL_ID_FIND_RELATION = "findOrderRelation";
        static final String SQL_ID_GET_ORDER_QTY = "getOrderQty";
        static final String SQL_ID_FIND_AVA_IDS = "findAvaIds";
        static final String SQL_ID_UPDATE_ORDER_RETURN_FLG = "updateOrderReturnFlg";
        static final String SQL_ID_FIND_PRODUCT_INFO = "findProductInfo";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
