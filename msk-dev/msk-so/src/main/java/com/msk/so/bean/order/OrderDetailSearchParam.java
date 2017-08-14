package com.msk.so.bean.order;

import com.msk.core.bean.BaseParam;

/**
 * *OrderDetailSearchParam
 * *@author jiang_nan
 * *@version 1.0
 **/
public class OrderDetailSearchParam extends BaseParam{
    /**订单编码*/
    private String orderId;
    /**订单Code*/
    private String orderCode;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}
