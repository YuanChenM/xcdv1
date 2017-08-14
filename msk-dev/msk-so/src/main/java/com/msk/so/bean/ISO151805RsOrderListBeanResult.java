package com.msk.so.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wang_jianzhou on 2016/12/6.
 */
public class ISO151805RsOrderListBeanResult implements Serializable {

    private Long shipId;

    private Long orderId;

    private Integer paymentRule;

    private List<ISO151805RsOrderDetailsBeanResult> orderDetail;

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getPaymentRule() {
        return paymentRule;
    }

    public void setPaymentRule(Integer paymentRule) {
        this.paymentRule = paymentRule;
    }

    public List<ISO151805RsOrderDetailsBeanResult> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<ISO151805RsOrderDetailsBeanResult> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
