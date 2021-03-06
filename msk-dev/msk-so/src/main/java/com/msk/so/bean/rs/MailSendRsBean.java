package com.msk.so.bean.rs;

import java.io.Serializable;

/**
 * Created by wang_jianzhou on 2017/2/7.
 */
public class MailSendRsBean implements Serializable {

    private Long orderId;

    private String orderCode;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @Override
    public String toString() {
        return "MailSendRsBean{" +
                "orderId=" + orderId +
                ", orderCode='" + orderCode + '\'' +
                '}';
    }
}
