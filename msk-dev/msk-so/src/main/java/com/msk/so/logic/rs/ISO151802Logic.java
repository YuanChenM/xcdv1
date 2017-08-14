package com.msk.so.logic.rs;

import com.msk.common.consts.OrderConst;
import com.msk.common.consts.StatusConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.StringConst;
import com.msk.core.entity.SoOrder;
import com.msk.core.entity.SoReturn;
import com.msk.core.entity.SoReturnStatus;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.so.Order;
import com.msk.so.bean.ModifyStatusParam;
import com.msk.so.bean.order.OrderShipInfo;
import com.msk.so.bean.order.OrderShipProductInfo;
import com.msk.so.bean.order.SoReturnDetailInfo;
import com.msk.so.bean.rs.ISO151802RsParam;
import com.msk.so.bean.rs.ISO151802RsResult;
import com.msk.so.logic.OrderLogic;
import com.msk.so.logic.OrderStatusLogic;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by liu_tao2 on 2016/7/21.
 */
@Service
public class ISO151802Logic extends BaseLogic {

    private static Logger logger = LoggerFactory.getLogger(ISO151802Logic.class);

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private OrderLogic orderLogic;

    @Autowired
    private OrderStatusLogic orderStatusLogic;

    /**
     * 现场退货操作
     * @param param
     * @return
     */
    @Transactional
    public ISO151802RsResult doReceiverReject(ISO151802RsParam param){
        Date applyTime = DateTimeUtil.parseDate(param.getApplyTime(),DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS);
        if (applyTime == null){
            throw new BusinessException("申请时间传入格式错误！");
        }
        param.setCrtTime(DateTimeUtil.getCustomerDate());
        Integer returnMode = param.getReturnMode();

        SoOrder soOrder = this.findOne(SqlId.SQL_ID_GET_ORDER_INFO, param);
        if(null == soOrder){
            throw new BusinessException("没有对应的订单,请检验!!!");
        }

        param.setOrderId(soOrder.getOrderId());
        //遍历现场退货到退货表数据
        SoReturn soReturn = getReturnOrderInfo(param,soOrder);

        if(returnMode == null){
            throw new BusinessException("现场退货类型不能为空");
        }else if(returnMode == NumberConst.IntDef.INT_ONE){
            //全部现场退货
            allReceiverReject(param, soReturn);
        }else if(returnMode == NumberConst.IntDef.INT_TWO){
            //部分现场退货
            partReceiverReject(param, soReturn);
        }else{
            throw new BusinessException("现场退货类型填写不正确");
        }

        //记录现场退货履历
        saveReturnStatus(soReturn);

//        //更新订单状态操作
//        modifyOrderStatus(param);
//
//        //更新发货表状态
//        modifyOrderShipStatus(param);

        return this.findOne(SqlId.SQL_ID_GET_RESULT_INFO,soReturn);
    }

    /**
     * 更新订单状态操作
     * @param param
     */
    @Transactional
    public void modifyOrderShipStatus(ISO151802RsParam param){
        ModifyStatusParam modifyStatusParam = new ModifyStatusParam();
        modifyStatusParam.setShipId(param.getShipId());
        modifyStatusParam.setUpdId(param.getUpdId());
        orderStatusLogic.modifyShipStatus(modifyStatusParam);
    }

    /**
     * 更新订单状态操作
     * @param param
     */
    @Transactional
    public void modifyOrderStatus(ISO151802RsParam param){
        ModifyStatusParam modifyStatusParam = new ModifyStatusParam();
        modifyStatusParam.setOrderId(param.getOrderId());
        modifyStatusParam.setUpdId(param.getUpdId());
        orderStatusLogic.modifyOrderStatusByOrderId(modifyStatusParam);
    }

    /**
     * 记录现场退货履历
     * @param soReturn
     */
    @Transactional
    public void saveReturnStatus(SoReturn soReturn){
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
     * 全部现场退货
     * @param param
     * @param soReturn
     */
    @Transactional
    public void allReceiverReject(ISO151802RsParam param,SoReturn soReturn){
        if(!checkAllReject(param)){
            throw new BusinessException("已经进行过其他操作，不能进行全部现场退货操作！！！");
        }

        soReturn.setReturnAmount((BigDecimal) super.findObject(SqlId.SQL_ID_GET_ALL_AMOUNT_BY_SHIP_ID, param));
        super.save(SqlId.SQL_ID_SAVE_RETURN_INFO, soReturn);
        addReturnDetails(param, soReturn);

        super.modify(SqlId.SQL_ID_MODIFY_ORDER_DETAIL_INFO_BY_SHIP_ID, param);
        super.modify(SqlId.SQL_ID_MODIFY_ORDER_SUPP_INFO_BY_SHIP_ID,param);
    }

    /**
     * 检验是否能够全部拒收
     * @param param
     * @return
     */
    @Transactional
    public boolean checkAllReject(ISO151802RsParam param){
        Integer count = (Integer)super.findObject(SqlId.SQL_ID_GET_ALL_REJECT_COUNT_FLAG,param);
        if(count > NumberConst.IntDef.INT_ZERO){
            return true;
        }
        return false;
    }

    /**
     * 全部现场退货时插入退货明细表中数据
     * @param param
     * @param soReturn
     */
    @Transactional
    public void addReturnDetails(ISO151802RsParam param,SoReturn soReturn){
        List<SoReturnDetailInfo> soReturnDetails = super.findList(SqlId.SQL_ID_GET_RETURN_DETAIL,param);

        if(CollectionUtils.isEmpty(soReturnDetails)){
            throw new BusinessException("全部现场退货时没有退货信息");
        }

        for (SoReturnDetailInfo soReturnDetail : soReturnDetails){
            soReturnDetail.setDetailId(commonLogic.maxId("so_return_detail", "DETAIL_ID"));
            soReturnDetail.setInboundBatch(soReturn.getReturnCode() + soReturn.getReturnId());
            soReturnDetail.setCrtId(param.getCrtId());
            soReturnDetail.setCrtTime(DateTimeUtil.getCustomerDate());
            soReturnDetail.setReturnId(soReturn.getReturnId());
            soReturnDetail.setRejectQty(soReturnDetail.getReturnQty());
            super.save(SqlId.SQL_ID_SAVE_RETURN_DETAIL, soReturnDetail);
        }
    }

    /**
     * 部分现场退货
     * @param param
     * @param soReturn
     */
    @Transactional
    public void partReceiverReject(ISO151802RsParam param,SoReturn soReturn){
        List<OrderShipInfo> shipList = param.getShipList();
        if(CollectionUtils.isEmpty(shipList)){
            throw new BusinessException("现场退货明细不能为空");
        }

        BigDecimal allAmount = new BigDecimal(NumberConst.IntDef.INT_ZERO);

        for(OrderShipInfo orderShipInfo : shipList){
            List<OrderShipProductInfo> productList = orderShipInfo.getProductList();

            if(CollectionUtils.isEmpty(productList)){
                throw new BusinessException("现场退货产品明细不能为空");
            }

            orderShipInfo.setReturnId(soReturn.getReturnId());
            orderShipInfo.setReturnCode(soReturn.getReturnCode());

            //处理现场部分迟收数据导退货明细表中并且得到所有的拒收金额
            BigDecimal amount = dealPartReceiverReject(orderShipInfo, productList, param);
            allAmount = DecimalUtil.add(allAmount,amount);
        }

        soReturn.setReturnAmount(allAmount);

        super.save(SqlId.SQL_ID_SAVE_RETURN_INFO,soReturn);
    }

    /**
     * 处理现场部分迟收数据导退货明细表中
     * @param orderShipInfo
     * @param productList
     */
    public BigDecimal dealPartReceiverReject(OrderShipInfo orderShipInfo,List<OrderShipProductInfo> productList,ISO151802RsParam param){

        BigDecimal amount = new BigDecimal(NumberConst.IntDef.INT_ZERO);

        for(OrderShipProductInfo productInfo : productList){
            productInfo.setShipId(param.getShipId());
            productInfo.setDeliverCode(orderShipInfo.getDeliverCode());
            SoReturnDetailInfo soReturnDetailInfo = super.findOne(SqlId.SQL_ID_GET_RETURN_DETAIL_INFO,productInfo);

            if(null == soReturnDetailInfo){
                throw new BusinessException("没有对应的订单数据请检验！！！");
            }

            soReturnDetailInfo.setRejectQty(productInfo.getReturnQty());
            soReturnDetailInfo.setDetailReason(productInfo.getDetailReasonID());
            soReturnDetailInfo.setCrtId(param.getCrtId());
            soReturnDetailInfo.setCrtTime(DateTimeUtil.getCustomerDate());

            BigDecimal rejectQty = productInfo.getReturnQty();
            BigDecimal suppQty = soReturnDetailInfo.getSuppRejectQty();
            BigDecimal detailQty = soReturnDetailInfo.getDetailRejectQty();

            if(rejectQty.compareTo(suppQty) > NumberConst.IntDef.INT_ZERO){
                throw new BusinessException("可退货数量小于退货数量，请检验！！！");
            }

            //判断供货明细状态
            if(soReturnDetailInfo.getSuppStatus() == StatusConst.OrderDetailAvailabilityStatusDef.PARTIAL_RECEIPT){
                if(rejectQty.compareTo(suppQty) == NumberConst.IntDef.INT_ZERO
                        && soReturnDetailInfo.getSuppQty().compareTo(soReturnDetailInfo.getSuppSendQty()) == NumberConst.IntDef.INT_ZERO){
                    soReturnDetailInfo.setSuppStatus(StatusConst.OrderDetailAvailabilityStatusDef.ALL_RECEIPT);
                }
            }

            //判断明细状态
            if(soReturnDetailInfo.getOrderDetailStatus() == StatusConst.OrderDetailStatusDef.PARTIAL_RECEIPT){
                if(rejectQty.compareTo(detailQty) == NumberConst.IntDef.INT_ZERO
                        && soReturnDetailInfo.getOrderQty().compareTo(soReturnDetailInfo.getDetailSendQty()) == NumberConst.IntDef.INT_ZERO){
                    soReturnDetailInfo.setOrderDetailStatus(StatusConst.OrderDetailStatusDef.ALL_RECEIPT);
                }
            }

            super.modify(SqlId.SQL_ID_MODIFY_DETAIL_INFO,soReturnDetailInfo);
            super.modify(SqlId.SQL_ID_MODIFY_SUPP_INFO,soReturnDetailInfo);

            soReturnDetailInfo.setDetailId(commonLogic.maxId("so_return_detail", "DETAIL_ID"));
            soReturnDetailInfo.setCrtTime(DateTimeUtil.getCustomerDate());
            soReturnDetailInfo.setReturnId(orderShipInfo.getReturnId());
            soReturnDetailInfo.setInboundBatch(orderShipInfo.getReturnCode() + orderShipInfo.getReturnId());
            super.save(SqlId.SQL_ID_SAVE_RETURN_DETAIL, soReturnDetailInfo);

            amount = DecimalUtil.add(amount,DecimalUtil.multiply(soReturnDetailInfo.getRejectQty(),soReturnDetailInfo.getPdPrice()));
        }

        return amount;
    }

    /**
     * 遍历现场退货到退货表中的数据
     * @param param
     * @param soOrder
     * @return
     */
    @Transactional
    public SoReturn getReturnOrderInfo(ISO151802RsParam param,SoOrder soOrder){
        SoReturn soReturn = new SoReturn();
        soReturn.setReturnId(commonLogic.maxId("so_return", "RETURN_ID"));
        soReturn.setReturnCode(orderLogic.getReturnOrderCode(soReturn.getReturnId()));
        soReturn.setOrderId(param.getOrderId());
        soReturn.setOrderCode(soOrder.getOrderCode());
        soReturn.setBuyersCode(param.getBuyerCode());
        soReturn.setBuyersName(soOrder.getBuyersName());
        soReturn.setSellerCode(soOrder.getSellerCode());
        soReturn.setSellerName(soOrder.getSellerName());
        soReturn.setDistrictCode(soOrder.getDistrictCode());
        soReturn.setReturnSource(OrderConst.ReturnSource.PDA);
        soReturn.setReturnType(OrderConst.ReturnType.REJECT);
        soReturn.setReturnMode(param.getReturnMode().toString());
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

    interface SqlId {
        static final String SQL_ID_GET_ORDER_INFO = "getOrderInfo";
        static final String SQL_ID_SAVE_RETURN_INFO = "saveReturnInfo";
        static final String SQL_ID_GET_ALL_AMOUNT_BY_SHIP_ID = "getAllAmountByShipId";
        static final String SQL_ID_GET_RETURN_DETAIL = "getReturnDetail";
        static final String SQL_ID_SAVE_RETURN_DETAIL = "saveReturnDetail";
        static final String SQL_ID_GET_RETURN_DETAIL_INFO = "getReturnDetailInfo";
        static final String SQL_ID_MODIFY_DETAIL_INFO = "modifyDetailInfo";
        static final String SQL_ID_MODIFY_SUPP_INFO = "modifySuppInfo";
        static final String SQL_ID_SAVE_RETURN_STATUS = "saveReturnStatus";
        static final String SQL_ID_GET_RESULT_INFO = "getResultInfo";
        static final String SQL_ID_MODIFY_ORDER_DETAIL_INFO_BY_SHIP_ID = "modifyOrderDetailInfoByShipId";
        static final String SQL_ID_MODIFY_ORDER_SUPP_INFO_BY_SHIP_ID = "modifyOrderSuppInfoByShipId";
        static final String SQL_ID_GET_ALL_REJECT_COUNT_FLAG = "getAllRejectCountFlag";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
