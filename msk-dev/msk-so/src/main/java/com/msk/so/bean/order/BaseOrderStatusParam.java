package com.msk.so.bean.order;

import com.msk.core.bean.BaseParam;
import com.msk.so.bean.*;

import java.math.BigDecimal;

/**
 * 订单状态变更WebService接口参数
 * *@author jiang_nan
 * *@version 1.0
 **/
public class BaseOrderStatusParam extends com.msk.so.bean.BaseOrderParam {
    /**订单ID*/
    private Long orderId;
    /**订单版本号*/
    private Integer ver;
    /**1.买家取消 2.不同意拼货的取消 3.不同意分批的取消神农客网站调用时默认是1.买家取消，CallCenter调用时有不同选择。*/
    private Integer cancelType;
    /**取消原因*/
    private String cancelReason;
    /**订单类型*/
    private Integer orderType;
    /**支付金额*/
    private BigDecimal orderAmount;
    /**支付单号*/
    private String paymentOrderCode;
    /**配送单号*/
    private String deliverCode;
    /**配送单信息*/
    private BaseOrderDelivery deliver;

    /**
     * 付款类型
     */
    private Integer paymentType;
    /**支付类型*/
    private String paymentMode;
    /**支付时间*/
    private String paymentTime;
    /**支付明细ID*/
    private Long paymentId;

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentOrderCode() {
        return paymentOrderCode;
    }

    public void setPaymentOrderCode(String paymentOrderCode) {
        this.paymentOrderCode = paymentOrderCode;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public Integer getVer() {
        return ver;
    }

    @Override
    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public Integer getCancelType() {
        return cancelType;
    }

    public void setCancelType(Integer cancelType) {
        this.cancelType = cancelType;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getDeliverCode() {
        return deliverCode;
    }

    public void setDeliverCode(String deliverCode) {
        this.deliverCode = deliverCode;
    }

    public BaseOrderDelivery getDeliver() {
        return deliver;
    }

    public void setDeliver(BaseOrderDelivery deliver) {
        this.deliver = deliver;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
}
