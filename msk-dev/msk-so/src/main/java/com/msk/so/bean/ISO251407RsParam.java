package com.msk.so.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 修改标准分销退货单状态
 * @author pxg
 */
public class ISO251407RsParam {
    /** 订单ID*/
    private Long orderId;
    /** 订单编码*/
    private String orderCode;
    /** 订单状态*/
    private Integer orderStatus;
    /** 订单版本号*/
    private Integer ver;
    /** 支付时间*/
    private Date paidTime;
    /** 支付金额*/
    private BigDecimal paidAmount;
    /** 支付方式*/
    private Integer paymentType;
    /** 支付流水号*/
    private String paidSeq;
    /** 收货人*/
    private String receiver;
    /** 收货时间*/
    private Date receiveTime;
    /** 配送顺序，收货默认为1*/
    private Integer deliverySeq;

    /**
     * 获得orderId
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获得orderCode
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 设置orderCode
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * 获得orderStatus
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置orderStatus
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获得ver
     */
    public Integer getVer() {
        return ver;
    }

    /**
     * 设置ver
     */
    public void setVer(Integer ver) {
        this.ver = ver;
    }

    /**
     * 获得paidTime
     */
    public Date getPaidTime() {
        return paidTime;
    }

    /**
     * 设置paidTime
     */
    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    /**
     * 获得paidAmount
     */
    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    /**
     * 设置paidAmount
     */
    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    /**
     * 获得paymentType
     */
    public Integer getPaymentType() {
        return paymentType;
    }

    /**
     * 设置paymentType
     */
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 获得paidSeq
     */
    public String getPaidSeq() {
        return paidSeq;
    }

    /**
     * 设置paidSeq
     */
    public void setPaidSeq(String paidSeq) {
        this.paidSeq = paidSeq;
    }

    /**
     * 获得receiver
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * 设置receiver
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * 获得receiveTime
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * 设置receiveTime
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    /**
     * 获得deliverySeq
     */
    public Integer getDeliverySeq() {
        return deliverySeq;
    }

    /**
     * 设置deliverySeq
     */
    public void setDeliverySeq(Integer deliverySeq) {
        this.deliverySeq = deliverySeq;
    }


}
