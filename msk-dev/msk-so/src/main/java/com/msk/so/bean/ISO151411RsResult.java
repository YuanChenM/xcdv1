package com.msk.so.bean;

import com.msk.core.bean.BaseBean;

/**
 * 
 * ISO151411RsResult接口返回结果信息.
 *
 * @author sjj
 */
public class ISO151411RsResult extends BaseBean {
    // 订单id
    private Long orderId;
    // 支付交易流水号
    private String paymentOrderCode;
    // 支付结果
    private Integer paymentResult;

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

    public Integer getPaymentResult() {
        return paymentResult;
    }

    public void setPaymentResult(Integer paymentResult) {
        this.paymentResult = paymentResult;
    }
}
