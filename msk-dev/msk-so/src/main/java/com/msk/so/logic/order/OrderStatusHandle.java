package com.msk.so.logic.order;

import com.fasterxml.jackson.core.Version;
import com.msk.common.consts.OrderConst;
import com.msk.common.consts.StatusConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.exception.SystemException;
import com.msk.core.mail.MailHandle;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.*;
import com.msk.so.bean.BaseOrder;
import com.msk.so.bean.order.*;
import com.msk.so.bean.order.BaseOrderParam;
import com.msk.so.bean.rs.ISO151415RsProductResult;
import com.msk.so.bean.rs.MailSendRsParam;
import com.msk.so.logic.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.beans.Transient;
import java.math.BigDecimal;
import java.util.*;

/**
 * 订单接口变更操作
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderStatusHandle {

    private static Logger logger = LoggerFactory.getLogger(OrderStatusHandle.class);

    @Autowired
    private OrderStatusLogic orderStatusLogic;
    @Autowired
    private ISO151415Logic ISO151415LOGIC;
    @Autowired
    private OrderLogic orderLogic;
    @Autowired
    private DeliverLogic deliverLogic;
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private OrderDetailAvailabilityLogic orderDetailAvailabilityLogic;
    @Autowired
    private SO151410Logic so151410Logic;
    /**
     * 整单取消
     * @param param web Service传入参数
     * @return web Service返回值
     */
    @Transactional
    public BaseOrderStatusResult modifyOrderCancel(BaseOrderStatusParam param){
        //Check 订单状态是否可以进行整单取消
        Integer [] statusArray = new Integer[]{
                StatusConst.OrderStatusDef.NEW
                ,StatusConst.OrderStatusDef.OBLIGATION
                ,StatusConst.OrderStatusDef.PAYMENT
                ,StatusConst.OrderStatusDef.PENDING_AUDIT
                ,StatusConst.OrderStatusDef.HAVE_AUDITED
                ,StatusConst.OrderStatusDef.WAIT_DISTRIBUTION
                ,StatusConst.OrderStatusDef.IN_DISTRIBUTION
                ,StatusConst.OrderStatusDef.CONFIRM
                ,StatusConst.OrderStatusDef.WAIT_SEND
        };
        param.setFilterObject("statusArray",statusArray);
        int count = this.ISO151415LOGIC.getPageCount(param);
        if(count== NumberConst.IntDef.INT_ZERO){
            throw new BusinessException("当前订单状态无法进行整单取消操作");
        }
        param.setFilterObject("cancelType", param.getCancelType());
        param.setFilterObject("cancelReason",param.getCancelReason());


//        SoOrder result = this.ISO151415LOGIC.findOne(param);
        SoOrder order = ISO151415LOGIC.findOne(param);

        if(order.getPaymentType() == OrderConst.PaymentType.PAYING_ONLINE
                && (order.getOrderStatus() == StatusConst.OrderStatusDef.PAYMENT)){

            //订单买家ID
            String buyersId = order.getBuyersId();
            //订单买家编码
            String buyersCode = order.getBuyersCode();
            //订单订单编码
            String orderCode = order.getOrderCode();
            //订单取消插入退款单
            SoOrder soOrderparam = new SoOrder();
            //订单编码
            soOrderparam.setOrderCode(orderCode);
            //订单类型
            soOrderparam.setOrderType(order.getOrderType());
            //订单总金额
            soOrderparam.setOrderAmount(order.getOrderAmount());
            //卖家编码:平台
            soOrderparam.setSellerCode(order.getSellerCode());
            //买家ID
            soOrderparam.setBuyersId(buyersId);
            //买家编码
            soOrderparam.setBuyersCode(buyersCode);

            //订单创建插入待付款单
            orderLogic.cancelPaymentOrder(soOrderparam);

        }

        this.orderStatusLogic.modifyOrderCancel(param);
        SoOrder orderInfo = ISO151415LOGIC.findOne(param);
        //调用发货单取消的方法
        List<SoOrderShip> soOrderShips = ISO151415LOGIC.getShipIdsByOrderId(orderInfo.getOrderId());
        for(SoOrderShip soOrderShip : soOrderShips){
            SO151410Param so151410Param = new SO151410Param();
            so151410Param.setShipId(soOrderShip.getShipId());
            so151410Param.setCrtId(param.getUpdId());
            so151410Logic.cancel(so151410Param);
        }
        BaseOrderStatusResult result =new BaseOrderStatusResult();
        result.setOrderId(orderInfo.getOrderId());
//        result.setOrderStatus(order.getOrderStatus());
//        result.setOrderAmount(order.getOrderAmount());
//        result.setPaymentType(order.getPaymentType());
//        result.setOrderSource(order.getOrderSource());
//        result.setOrderCode(order.getOrderCode());
        result.setVer(orderInfo.getVer());
        return result;
    }
    @Transactional
    public BaseOrderStatusResult modifyOrderStatus(String type,BaseOrderStatusParam param){
        if("payment".equals(type) ){
            //param.setFilterObject("orderAmount", param.getOrderAmount());
            BigDecimal orderAmount = param.getOrderAmount();
            Long orderId = param.getOrderId();
            Integer status = new Integer(StatusConst.OrderStatusDef.WAIT_DISTRIBUTION);
            Integer confirmStatus = new Integer(StatusConst.OrderStatusDef.CONFIRM);
            Integer beforePayStatus = new Integer(StatusConst.OrderStatusDef.OBLIGATION);
            String updId = param.getUpdId();
            Date customerDate = DateTimeUtil.getCustomerDate();
            param.setUpdTime(customerDate);
            SoOrder result = ISO151415LOGIC.findOne(param);
            if (result == null){
                throw new BusinessException("查无该订单ID，请确定");
            }
            Integer paymentType = result.getPaymentType();
            //设置订单信息
            SoOrder order = new SoOrder();
            order.setOrderCode(result.getOrderCode());
            order.setOrderAmount(result.getOrderAmount());
            order.setSellerCode(result.getSellerCode());
            order.setBuyersCode(result.getBuyersCode());
            order.setBuyersType(result.getBuyersType());
            order.setPaymentType(result.getPaymentType());
            order.setOrderType(result.getOrderType());
            order.setOrderSource(result.getOrderSource());

            BigDecimal oldOrderAmount = result.getOrderAmount();
            Integer oldStatus = result.getOrderStatus();
            Integer basePaymentType = new Integer(OrderConst.PaymentType.PAYING_ONLINE);
            Integer cashPaymentType = new Integer(OrderConst.PaymentType.CASH_ON_DELIVERY);
            String paymentOrderCode = param.getPaymentOrderCode();
            Integer ver1 = param.getVer();
            Integer ver2 = result.getVer();
            Integer orderSource = new Integer(OrderConst.OrderSource.SNK);
//          Integer mskOrderSource = new Integer(OrderConst.OrderSource.MSK);
            Integer newOrderSource = result.getOrderSource();
            Integer hasDetail = ISO151415LOGIC.findDetail(param);
            if(basePaymentType.equals(paymentType) && !StringUtil.isEmpty(paymentOrderCode)) {
                if (ver2.equals(ver1)){
                    if (beforePayStatus.equals(oldStatus)) {
                        if (orderAmount != null && orderAmount.compareTo(new BigDecimal(0)) > NumberConst.IntDef.INT_ZERO) {
                            //Modify by wang_jianzhou for bug#3802 at 2016/11/25 Start.
                            if(!newOrderSource.equals(OrderConst.OrderSource.MSK)){
                            //Modify by wang_jianzhou for bug#3802 at 2016/11/25 end.
                                //主定单有明细信息的时候，订单状态为待分销
                                if(hasDetail > 0){
                                    //orderLogic.modifyOrderStatus(orderId, confirmStatus, updId, customerDate);
                                    orderLogic.modifyOrderStatus(orderId, status, updId, customerDate);
                                    //主定单没有明细信息的时候，订单状态为已确认
                                }else{
                                    //orderLogic.modifyOrderStatus(orderId, status, updId, customerDate);
                                    //全部走买手，线上付款的时候判断首单
                                    if(checkForPendingAuditStatus(orderId)){
                                        BaseParam baseParam = new BaseParam();
                                        baseParam.setFilterObject("mainOrderId",orderId);
                                        SoOrderRelation soOrderRelation = ISO151415LOGIC.findOrderRelation(baseParam);
                                        //更新子订单
                                        ISO151415LOGIC.modifyOrderPendingAudit(soOrderRelation.getChildOrderId());
                                        //更新子订单明细
                                        ISO151415LOGIC.modifySubOrderDetailPendingAudit(soOrderRelation.getChildOrderId());
                                        //更新子订单供货明细
                                        ISO151415LOGIC.modifySubOrderDetailAvailabilityPendingAudit(soOrderRelation.getChildOrderId());
                                        //更新主订单
                                        ISO151415LOGIC.modifyOrderPendingAudit(orderId);
                                        sendMail(orderId,result.getOrderCode());
                                    }else {
                                        orderLogic.modifyOrderStatus(orderId, confirmStatus, updId, customerDate);
                                    }
                                }
                            }else {
                                orderLogic.modifyOrderStatus(orderId, confirmStatus, updId, customerDate);
                                ISO151415LOGIC.modifyOrderDetail(orderId, StatusConst.OrderDetailStatusDef.CONFIRM, updId, customerDate);
                            }
                        }else {
                            throw new BusinessException("请输入正确支付金额！");
                        }
                    }else {
                        throw new BusinessException("当前订单状态无法支付，请确定");
                    }
                }else {
                    throw new BusinessException("当前订单版本错误，请确定");
                }
            }else {
                throw new BusinessException("请确认支付方式或者支付单号");
            }
            // 保存支付记录
            ISO151415LOGIC.saveSoPayment(param, order);
        }

        SoOrder order = ISO151415LOGIC.findOne(param);
        BaseOrderStatusResult result =new BaseOrderStatusResult();
        result.setOrderId(order.getOrderId());
        result.setOrderStatus(order.getOrderStatus());
        result.setOrderAmount(order.getOrderAmount());
        result.setPaymentType(order.getPaymentType());
        result.setOrderSource(order.getOrderSource());
        result.setOrderCode(order.getOrderCode());
        result.setVer(order.getVer());
        return result;
    }

    /**
     * 判断首单
     * @param orderId 主订单ID
     * @return
     */
    @Transactional
    private boolean checkForPendingAuditStatus(Long orderId){
        BaseParam baseParam = new BaseParam();
        baseParam.setFilterObject("mainOrderId",orderId);
        //查询主子关联信息
        SoOrderRelation soOrderRelation = ISO151415LOGIC.findOrderRelation(baseParam);
        if(null == soOrderRelation){
            return false;
        }
        //子订单ID
        Long childOrderId = soOrderRelation.getChildOrderId();
        baseParam.setFilterObject("childOrderId",childOrderId);
        //查询子订单信息
        SoOrder soOrder = ISO151415LOGIC.findChildOrderInfo(baseParam);
        Date crtTime = DateTimeUtil.parseDate(DateTimeUtil.formatDate("yyyy-MM-dd HH:mm:ss",soOrder.getCrtTime()),
                "yyyy-MM-dd HH:mm:ss");
        if(null == soOrder){
            return false;
        }
        //查询子订单明细
        List<SoOrderDetail> childDetails = ISO151415LOGIC.findChildDetails(baseParam);
        //判断买家是否第一次下单
        baseParam.setFilterObject("buyersId", soOrder.getBuyersId());
        baseParam.setFilterObject("crtTime", crtTime);
        baseParam.setFilterObject("status", StatusConst.OrderStatusDef.PENDING_AUDIT);
        baseParam.setFilterObject("failStatus", StatusConst.OrderStatusDef.CANCEL);
        int buyersNum = ISO151415LOGIC.findBuyerCount(baseParam);
        if(buyersNum == 0){
            logger.debug("买家ID为 " + soOrder.getBuyersId() + " 的买家是第一次下单");
            return true;
        }

        //判断买家产品是否满足首单
        if(null != childDetails){
            for(SoOrderDetail soOrderDetail : childDetails){
                baseParam.setFilterObject("pdCode", soOrderDetail.getPdCode());
                int productNum = ISO151415LOGIC.findProductNum(baseParam);
                if(productNum == 0){
                    logger.debug("买家ID为 " + soOrder.getBuyersId() + " ,产品编码为"
                            + soOrderDetail.getPdCode() + " 的买家产品满足首单");
                    return true;
                }
            }

        }

        //判断下单产品的数量
        BigDecimal packageQty = ISO151415LOGIC.findPackageQty();
        if(null == packageQty){
            logger.debug("请设置PackageQty");
        }
        if(null != packageQty && null != childDetails){
            logger.debug("PackageQty为 " + String.valueOf(packageQty));
            for (SoOrderDetail orderDetail : childDetails) {
                BigDecimal orderQty = BigDecimal.ZERO;
                for(SoOrderDetail pd : childDetails){
                    if(pd.getPdCode().equals(orderDetail.getPdCode())){
                        orderQty = orderQty.add(pd.getOrderQty());
                    }
                    if (orderQty.compareTo(packageQty) > 0) {
                        logger.debug("产品编码为 " + orderDetail.getPdCode() + " 的下单数量满足首单");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 发送邮件
     */
    @Transactional
    private void sendMail(Long orderId, String orderCode) {
        MailSendRsParam param = setContent();
        String title = "买家订单审核通知";
        StringBuffer context = new StringBuffer();
        context.append("<p>此信为系统自动发送的买家订单审核通知，请不要回复 <br>");
        context.append("------------------------------------------------------------- <br>");
        context.append("<p>订单ID：" + orderId + "</p>");
        context.append("<p>订单编码：" + orderCode + "</p></p>");
        if (null != param) {
            try {
                logger.debug("邮件发送开始");
                for (String mailTo : param.getMailTo()) {
                    logger.debug("收件人:" + mailTo);
                }
                logger.debug("订单ID:" + orderId);
                logger.debug("订单编码:" + orderCode);
                MailHandle.sendHtmlEmail(title, context.toString(), param.getMailTo());
                logger.debug("邮件发送成功");
            } catch (Exception e) {
                logger.error("邮件发送失败", e);
            }
        }
    }

    @Transactional
    private MailSendRsParam setContent() {
        MailSendRsParam param = new MailSendRsParam();
        List<SoConstantBean> soConstantBeens = ISO151415LOGIC.findEmailTo();
        if (CollectionUtils.isEmpty(soConstantBeens)) {
            logger.debug("没有收件人，请配置收件人邮箱");
            return null;
        }
        List<String> mailToAddresses = new ArrayList<String>();
        for (SoConstantBean soConstantBean : soConstantBeens) {
            mailToAddresses.add(soConstantBean.getEmailAddress());
        }
        String[] arr = mailToAddresses.toArray(new String[0]);
        param.setMailTo(arr);
        for (String mailTo : arr) {
            logger.debug("将发送给:" + mailTo);
        }
        return param;
    }
}
