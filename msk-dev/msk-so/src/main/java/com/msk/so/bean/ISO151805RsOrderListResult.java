package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * Created by liutao on 2016/10/18.
 */
public class ISO151805RsOrderListResult extends BaseEntity {
    private Long shipId;

    private Long orderId;

    private Integer paymentRule;

    private List<ISO151805RsOrderDetailsResult> orderDetail;

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

    public List<ISO151805RsOrderDetailsResult> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<ISO151805RsOrderDetailsResult> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
