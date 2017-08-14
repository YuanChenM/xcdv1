package com.msk.so.bean;

import java.io.Serializable;

/**
 * zhang_qiang1
 * 三合一  收货接口返回值
 */
public class ISO251413RsResult implements Serializable {


    private Long orderId;// 订单id

    private Long shipId;// 发货单id

    private Integer orderStatus;// 订单状态

    private Integer ver;//版本号

    private Integer paymentType;// 付款类型

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }
}
