package com.msk.so.bean.order;

import com.msk.core.bean.BaseParam;

/**
 * *OrderPrintParam
 * *@author sunjiaju
 * *@version 1.0
 **/
public class OrderPrintParam extends BaseParam{
    /**订单编码*/
    private Long orderId;
    /**订单编码*/
    private Long orderDetailId;
    /**订单Code*/
    private String orderCode;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }
}
