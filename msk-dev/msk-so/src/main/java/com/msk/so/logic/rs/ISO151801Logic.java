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
import com.msk.so.bean.ModifyStatusParam;
import com.msk.so.bean.order.OrderShipInfo;
import com.msk.so.bean.order.OrderShipProductInfo;
import com.msk.so.bean.order.SoReturnDetailInfo;
import com.msk.so.bean.rs.ISO151801RsParam;
import com.msk.so.bean.rs.ISO151801RsResult;
import com.msk.so.logic.OrderLogic;
import com.msk.so.logic.OrderStatusLogic;
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

/**
 * Created by liu_tao2 on 2016/7/18.
 */
@Service
public class ISO151801Logic extends BaseLogic{
    private static Logger logger = LoggerFactory.getLogger(ISO151801Logic.class);

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private OrderLogic orderLogic;

    @Autowired
    private OrderStatusLogic orderStatusLogic;

    /**
     * 迟收操作
     * @param param
     * @return
     */
    @Transactional
    public ISO151801RsResult doReceiverLater(ISO151801RsParam param){
        Date applyTime = DateTimeUtil.parseDate(param.getApplyTime(),DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS);
        if (applyTime == null){
            throw new BusinessException("申请时间传入格式错误！");
        }
        Date receiptDate = DateTimeUtil.parseDate(param.getReceiptDate(),DateTimeUtil.FORMAT_DATE_YYYYMMDD);
        if (receiptDate == null){
            throw new BusinessException("迟收再发送日期传入格式错误！");
        }
        param.setCrtTime(DateTimeUtil.getCustomerDate());
        Integer returnMode = param.getReturnMode();

        SoOrder soOrder = this.findOne(SqlId.SQL_ID_GET_ORDER_INFO, param);

        if(null == soOrder){
            throw new BusinessException("没有对应的订单,请检验!!!");
        }

        param.setOrderId(soOrder.getOrderId());
        //遍历迟收到退货表的数据
        SoReturn soReturn = getReturnOrderInfo(param,soOrder);

        if(returnMode == null){
            throw new BusinessException("迟收类型不能为空");
        }else if(returnMode == NumberConst.IntDef.INT_ONE){
            //全部迟收
            allReceiverLater(param,soReturn);
        }else if(returnMode == NumberConst.IntDef.INT_TWO){
            //部分迟收
            partReceiverLater(param,soReturn);
        }else {
            throw new BusinessException("迟收类型填写错误");
        }

        //记录迟收履历
        saveReturnStatus(soReturn);

        //更新订单状态操作
        modifyOrderStatus(param);

        //更新发货单状态
        modifyOrderShipStatus(param);

        return this.findOne(SqlId.SQL_ID_GET_RESULT_INFO,soReturn);
    }

    /**
     * 更新订单状态操作
     * @param param
     */
    @Transactional
    public void modifyOrderShipStatus(ISO151801RsParam param){
        param.setSuppStatus(StatusConst.OrderDetailAvailabilityStatusDef.CONFIRM);
        Integer count = super.getCount(SqlId.SQL_ID_GET_SUPP_COUNT, param);
        if (count == NumberConst.IntDef.INT_ZERO){
            // 更新状态为全部迟收
            super.modify(param);
        }
    }

    /**
     * 更新订单状态操作
     * @param param
     */
    @Transactional
    public void modifyOrderStatus(ISO151801RsParam param){
        ModifyStatusParam modifyStatusParam = new ModifyStatusParam();
        modifyStatusParam.setOrderId(param.getOrderId());
        modifyStatusParam.setUpdId(param.getUpdId());
        orderStatusLogic.modifyOrderStatusByOrderId(modifyStatusParam);
    }

    /**
     * 记录迟收履历
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
     * 遍历迟收到退货表中的数据
     * @param param
     * @param soOrder
     * @return
     */
    @Transactional
    public SoReturn getReturnOrderInfo(ISO151801RsParam param,SoOrder soOrder){
        SoReturn soReturn = new SoReturn();
        soReturn.setReturnId(commonLogic.maxId("so_return", "RETURN_ID"));
        soReturn.setReturnCode(orderLogic.getReturnOrderCode(soReturn.getReturnId()));
        soReturn.setOrderId(soOrder.getOrderId());
        soReturn.setOrderCode(soOrder.getOrderCode());
        soReturn.setBuyersCode(soOrder.getBuyersCode());
        soReturn.setBuyersName(soOrder.getBuyersName());
        soReturn.setSellerCode(soOrder.getSellerCode());
        soReturn.setSellerName(soOrder.getSellerName());
        soReturn.setDistrictCode(soOrder.getDistrictCode());
        soReturn.setReturnSource(OrderConst.ReturnSource.PDA);
        soReturn.setReturnType(OrderConst.ReturnType.LATER);
        soReturn.setReturnMode(param.getReturnMode().toString());
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
        soReturn.setCrtId(param.getCrtId());
        soReturn.setCrtTime(param.getCrtTime());
        return soReturn;
    }

    /**
     * 处理全部迟收
     * @param param
     */
    @Transactional
    public void allReceiverLater(ISO151801RsParam param,SoReturn soReturn){
        if(!checkAllLater(param)){
            throw new BusinessException("已经进行过其他操作，不能进行全部迟收操作！！！");
        }

        param.setDetailStatus(StatusConst.OrderDetailStatusDef.CONFIRM);
        param.setSuppStatus(StatusConst.OrderDetailAvailabilityStatusDef.CONFIRM);
        soReturn.setReturnAmount((BigDecimal) super.findObject(SqlId.SQL_ID_GET_ALL_AMOUNT_BY_SHIP_ID, param));
        super.save(SqlId.SQL_ID_SAVE_RETURN_INFO, soReturn);
        addReturnDetails(param, soReturn);
        super.modify(SqlId.SQL_ID_MODIFY_ORDER_DETAIL_INFO_BY_SHIP_ID, param);
        super.modify(SqlId.SQL_ID_MODIFY_ORDER_SUPP_INFO_BY_SHIP_ID, param);
    }

    /**
     * 检验是否能够全部迟收
     * @param param
     * @return
     */
    @Transactional
    public boolean checkAllLater(ISO151801RsParam param){
        Integer count = (Integer)super.findObject(SqlId.SQL_ID_GET_ALL_LATER_COUNT_FLAG,param);
        if(count > NumberConst.IntDef.INT_ZERO){
            return true;
        }
        return false;
    }

    /**
     * 全部迟收时插入退货明细表中数据
     * @param param
     * @param soReturn
     */
    @Transactional
    public void addReturnDetails(ISO151801RsParam param,SoReturn soReturn){
        List<SoReturnDetailInfo> soReturnDetails = super.findList(SqlId.SQL_ID_GET_RETURN_DETAIL,param);

        if(CollectionUtils.isEmpty(soReturnDetails)){
            throw new BusinessException("全部迟收时没有迟收信息");
        }

        for (SoReturnDetailInfo soReturnDetail : soReturnDetails){
            soReturnDetail.setDetailId(commonLogic.maxId("so_return_detail", "DETAIL_ID"));
            soReturnDetail.setCrtId(param.getCrtId());
            soReturnDetail.setInboundBatch(soReturn.getReturnCode() + soReturn.getReturnId());
            soReturnDetail.setCrtTime(DateTimeUtil.getCustomerDate());
            soReturnDetail.setReturnId(soReturn.getReturnId());
            soReturnDetail.setRejectQty(soReturnDetail.getReturnQty());
            super.save(SqlId.SQL_ID_SAVE_RETURN_DETAIL, soReturnDetail);
        }
    }

    /**
     * 处理部分迟收
     * @param param
     */
    @Transactional
    public void partReceiverLater(ISO151801RsParam param,SoReturn soReturn){
        List<OrderShipInfo> shipList = param.getShipList();

        if(CollectionUtils.isEmpty(shipList)){
            throw new BusinessException("迟收明细不能为空");
        }

        BigDecimal allAmount = new BigDecimal(NumberConst.IntDef.INT_ZERO);

        for (OrderShipInfo orderShipInfo : shipList){
            List<OrderShipProductInfo> orderShipProductInfos = orderShipInfo.getProductList();

            if(CollectionUtils.isEmpty(orderShipProductInfos)){
                throw new BusinessException("迟收明细的产品信息不能为空");
            }
            List<OrderShipProductInfo> productInfos = getProductList(orderShipProductInfos);
            List<SoReturnDetailInfo> soReturnDetailInfos = new ArrayList<>();

            for(OrderShipProductInfo productInfo : productInfos){
                productInfo.setDeliverCode(orderShipInfo.getDeliverCode());
                productInfo.setShipId(param.getShipId());
                productInfo.setOrderId(param.getOrderId());
                productInfo.setReceiptDate(DateTimeUtil.parseDate(param.getReceiptDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDD));

                SoReturnDetailInfo soReturnDetailInfo = getPartReceiveDetail(productInfo, soReturn);
                soReturnDetailInfo.setCrtTime(param.getCrtTime());
                soReturnDetailInfo.setCrtId(param.getCrtId());
                soReturnDetailInfo.setReceiptDate(DateTimeUtil.parseDate(param.getReceiptDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDD));
                soReturnDetailInfos.add(soReturnDetailInfo);
            }
            allAmount = DecimalUtil.add(allAmount,getSumLaterAmount(soReturnDetailInfos));

            //处理订单明细的数据
            modifyOrderDetail(soReturnDetailInfos);

            //插入退货明细表
            saveReturnDetail(soReturnDetailInfos,soReturn);
        }

        soReturn.setReturnAmount(allAmount);
        super.save(SqlId.SQL_ID_SAVE_RETURN_INFO,soReturn);
    }

    /**
     * 插入退货明细数据
     * @param soReturnDetailInfos
     * @param soReturn
     */
    @Transactional
    public void saveReturnDetail(List<SoReturnDetailInfo> soReturnDetailInfos,SoReturn soReturn){
        for (SoReturnDetailInfo soReturnDetailInfo : soReturnDetailInfos){
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
     * @param soReturnDetailInfos
     * @return
     */
    @Transactional
    public BigDecimal getSumLaterAmount(List<SoReturnDetailInfo> soReturnDetailInfos){
        BigDecimal sumAmount = new BigDecimal(NumberConst.IntDef.INT_ZERO);

        for (SoReturnDetailInfo soReturnDetailInfo : soReturnDetailInfos){
            sumAmount = DecimalUtil.add(sumAmount,DecimalUtil.multiply(soReturnDetailInfo.getLaterQty(), soReturnDetailInfo.getPdPrice()));
        }

        return sumAmount;
    }

    /**
     * 处理订单明细的数据
     * @param soReturnDetailInfos
     */
    @Transactional
    public void modifyOrderDetail(List<SoReturnDetailInfo> soReturnDetailInfos){

        List<SoReturnDetailInfo> soReturnDetails = getOrderDetailList(soReturnDetailInfos);

        BigDecimal decimal = new BigDecimal(NumberConst.IntDef.INT_ZERO);

        for(SoReturnDetailInfo detailInfo : soReturnDetails){
            if(detailInfo.getLaterQty().compareTo(detailInfo.getDetailLaterQty()) > NumberConst.IntDef.INT_ZERO){
                throw new BusinessException("迟收数量大于可迟收数量");
            }else if (detailInfo.getLaterQty().compareTo(detailInfo.getDetailLaterQty()) == NumberConst.IntDef.INT_ZERO
                    && detailInfo.getDetailCancelQty().compareTo(decimal) == NumberConst.IntDef.INT_ZERO
                    && detailInfo.getDetailReceiveQty().compareTo(decimal) == NumberConst.IntDef.INT_ZERO
                    && detailInfo.getDetailRejectionQty().compareTo(decimal) == NumberConst.IntDef.INT_ZERO
                    && detailInfo.getDetailReturnQty().compareTo(decimal) == NumberConst.IntDef.INT_ZERO){
                //这条明细回滚
                backDetailAndSuppInfo(soReturnDetails);
            }else if(detailInfo.getLaterQty().compareTo(detailInfo.getDetailLaterQty()) < NumberConst.IntDef.INT_ZERO){
                //这条明细拆分
                subDetailAndSuppInfo(soReturnDetailInfos,soReturnDetails);
            }
        }

    }

    /**
     * 在部分迟收时这条明细是全部迟收的情况下回滚明细和供货明细数据
     * @param soReturnDetails
     */
    @Transactional
    public void backDetailAndSuppInfo(List<SoReturnDetailInfo> soReturnDetails){

        for(SoReturnDetailInfo soReturnDetailInfo : soReturnDetails){

            soReturnDetailInfo.setOrderDetailStatus(StatusConst.OrderDetailStatusDef.CONFIRM);
            soReturnDetailInfo.setSuppStatus(StatusConst.OrderDetailAvailabilityStatusDef.CONFIRM);

            super.modify(SqlId.SQL_ID_MODIFY_ORDER_DETAIL,soReturnDetailInfo);

            super.modify(SqlId.SQL_ID_MODIFY_ORDER_SUPP,soReturnDetailInfo);
        }
    }

    /**
     * 部分迟收时拆分订单明细数据和供货明细数据
     * @param soReturnDetailInfos
     * @param soReturnDetails
     */
    @Transactional
    public void subDetailAndSuppInfo(List<SoReturnDetailInfo> soReturnDetailInfos,List<SoReturnDetailInfo> soReturnDetails){
        Integer zero = NumberConst.IntDef.INT_ZERO;

        //拆分明细
        for(SoReturnDetailInfo soReturnDetail : soReturnDetails){
            BigDecimal laterQty = soReturnDetail.getLaterQty();
            BigDecimal detailQty = soReturnDetail.getDetailLaterQty();
            if(laterQty.compareTo(detailQty) > zero){
                throw new BusinessException("迟收数量大于可迟收数量");
            }
            soReturnDetail.setOrderDetailIdNew(commonLogic.maxId("so_order_detail","ORDER_DETAIL_ID"));
            soReturnDetail.setOrderDetailStatusNew(StatusConst.OrderDetailStatusDef.CONFIRM);
            super.save(SqlId.SQL_ID_SAVE_DETAIL_INFO, soReturnDetail);
            super.modify(SqlId.SQL_ID_MODIFY_ORDER_DETAIL_BY_ID,soReturnDetail);
        }

        //拆分供货明细
        for(SoReturnDetailInfo soReturnDetailInfo : soReturnDetailInfos){
            BigDecimal laterQty = soReturnDetailInfo.getLaterQty();
            BigDecimal suppQty = soReturnDetailInfo.getSuppLaterQty();
            if(laterQty.compareTo(suppQty) > NumberConst.IntDef.INT_ZERO){
                throw new BusinessException("迟收数量大于可迟收数量");
            }
            soReturnDetailInfo.setOrderDetailIdNew(getOrderDetailNew(soReturnDetails, soReturnDetailInfo));
            soReturnDetailInfo.setSuppStatusNew(StatusConst.OrderDetailAvailabilityStatusDef.CONFIRM);
            soReturnDetailInfo.setSuppIdNew(commonLogic.maxId("so_order_detail_availability", "ORDER_DETAIL_AVAILABILITY_ID"));
            super.save(SqlId.SQL_ID_SAVE_SUPP_INFO,soReturnDetailInfo);
            super.modify(SqlId.SQL_ID_MODIFY_ORDER_SUPP_BY_ID,soReturnDetailInfo);
        }
    }

    /**
     * 拆分订单明细时产生明细ID
     * @param soReturnDetailInfos
     * @param soReturnDetail
     * @return
     */
    @Transactional
    public Long getOrderDetailNew(List<SoReturnDetailInfo> soReturnDetailInfos,SoReturnDetailInfo soReturnDetail){

        for (SoReturnDetailInfo soReturnDetailInfo : soReturnDetailInfos){
            if(soReturnDetailInfo.getDetailId() == soReturnDetail.getDetailId()){
                return soReturnDetailInfo.getOrderDetailIdNew();
            }
        }

        return null;
    }

    /**
     * 合并订单明细ID相同的数据，并且迟收数量累加
     * @param soReturnDetailInfos
     * @return
     */
    @Transactional
    public List<SoReturnDetailInfo> getOrderDetailList(List<SoReturnDetailInfo> soReturnDetailInfos){
        List<SoReturnDetailInfo> soReturnDetails = new ArrayList();
        soReturnDetails.add(soReturnDetailInfos.get(NumberConst.IntDef.INT_ZERO));
        for(int i = NumberConst.IntDef.INT_ONE;i<soReturnDetailInfos.size();i++){
            boolean addFlg = true;
            for(SoReturnDetailInfo productInfo : soReturnDetails){
                SoReturnDetailInfo soReturnDetailInfo = soReturnDetailInfos.get(i);
                if(productInfo.getDetailId().equals(soReturnDetailInfo.getDetailId())){
                    //算出一个明细下面的迟收数量
                    productInfo.setLaterQty(DecimalUtil.add(productInfo.getLaterQty(),soReturnDetailInfo.getLaterQty()));
                    addFlg = false;
                }
            }
            if(addFlg){
                soReturnDetails.add(soReturnDetailInfos.get(i));
            }
        }
        return soReturnDetails;
    }

    /**
     * 合并产品信息到明细层次，用于拆分明细数据
     * @param productInfo
     * @param soReturn
     * @return
     */
    @Transactional
    public SoReturnDetailInfo getPartReceiveDetail(OrderShipProductInfo productInfo,SoReturn soReturn){
        SoReturnDetailInfo soReturnDetailInfo = super.findOne(SqlId.SQL_ID_GET_RETURN_DETAIL_INFO,productInfo);

        if(null == soReturnDetailInfo){
            throw new BusinessException("没有找到可迟收的数据，请检验！！！");
        }

        soReturnDetailInfo.setLaterQty(productInfo.getReturnQty());
        soReturnDetailInfo.setDetailReason(productInfo.getDetailReasonID());
        soReturnDetailInfo.setLaterAmount(DecimalUtil.multiply(soReturnDetailInfo.getPdPrice(),productInfo.getReturnQty()));
        return soReturnDetailInfo;
    }

    /**
     * 合并产品数据中只是迟收数量不一样其他都相同的迟收产品信息
     * @param orderShipProductInfos
     * @return
     */
    @Transactional
    public List<OrderShipProductInfo> getProductList(List<OrderShipProductInfo> orderShipProductInfos){
        List<OrderShipProductInfo> productInfos = new ArrayList<>();
        productInfos.add(orderShipProductInfos.get(NumberConst.IntDef.INT_ZERO));

        for(int i = NumberConst.IntDef.INT_ONE;i<orderShipProductInfos.size();i++){
            boolean addFlg = true;
            for(OrderShipProductInfo productInfo : productInfos){
                OrderShipProductInfo orderShipProductInfo = orderShipProductInfos.get(i);
                if(productInfo.getSkuCode().equals(orderShipProductInfo.getSkuCode())
                        && productInfo.getShipDetailId().equals(orderShipProductInfo.getShipDetailId())){
                    BigDecimal returnQty = productInfo.getReturnQty();
                    BigDecimal qty = orderShipProductInfo.getReturnQty();
                    productInfo.setReturnQty(DecimalUtil.add(qty,returnQty));
                    addFlg = false;
                }
            }
            if(addFlg){
                productInfos.add(orderShipProductInfos.get(i));
            }
        }

        return productInfos;
    }

    interface SqlId{
        static final String SQL_ID_GET_ORDER_INFO = "getOrderInfo";
        static final String SQL_ID_SAVE_RETURN_INFO = "saveReturnInfo";
        static final String SQL_ID_GET_ALL_AMOUNT_BY_SHIP_ID = "getAllAmountByShipId";
        static final String SQL_ID_GET_RETURN_DETAIL = "getReturnDetail";
        static final String SQL_ID_SAVE_RETURN_DETAIL = "saveReturnDetail";
        static final String SQL_ID_GET_RETURN_DETAIL_INFO = "getReturnDetailInfo";
        static final String SQL_ID_MODIFY_ORDER_SUPP = "modifyOrderSupp";
        static final String SQL_ID_MODIFY_ORDER_DETAIL = "modifyOrderDetail";
        static final String SQL_ID_SAVE_DETAIL_INFO = "saveDetailInfo";
        static final String SQL_ID_SAVE_SUPP_INFO = "saveSuppInfo";
        static final String SQL_ID_MODIFY_ORDER_DETAIL_BY_ID = "modifyOrderDetailById";
        static final String SQL_ID_MODIFY_ORDER_SUPP_BY_ID = "modifyOrderSuppById";
        static final String SQL_ID_SAVE_RETURN_STATUS = "saveReturnStatus";
        static final String SQL_ID_GET_RESULT_INFO = "getResultInfo";
        static final String SQL_ID_MODIFY_ORDER_DETAIL_INFO_BY_SHIP_ID = "modifyOrderDetailInfoByShipId";
        static final String SQL_ID_MODIFY_ORDER_SUPP_INFO_BY_SHIP_ID = "modifyOrderSuppInfoByShipId";
        static final String SQL_ID_GET_ALL_LATER_COUNT_FLAG = "getAllLaterCountFlag";
        static final String SQL_ID_GET_SUPP_COUNT = "getSuppCount";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
