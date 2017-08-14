package com.msk.so.bean;

import com.msk.core.bean.BaseParam;


/**
 * 
 * ISO151411RsParam接受参数.
 *
 * @author sjj
 */
public class ISO151411RsParam extends BaseParam {
    // 订单ID
    private Long orderId;
    // 支付交易流水号
    private String paymentOrderCode;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPaymentOrderCode() {
        return paymentOrderCode;
    }

    public void setPaymentOrderCode(String paymentOrderCode) {
        this.paymentOrderCode = paymentOrderCode;
    }
}
