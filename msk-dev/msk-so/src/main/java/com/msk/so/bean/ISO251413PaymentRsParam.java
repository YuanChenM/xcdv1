package com.msk.so.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 三合一接口  订单收货
 * 买家支付信息List
 * Created by zhang_qiang1 on 2016/11/7.
 */
public class ISO251413PaymentRsParam implements Serializable {

    private Integer paymentMode;//付款方式：1-现金；2-转账；3-支票；4-冲抵；5-POS刷卡；6-微信；7-支付宝

    private BigDecimal paymentMoney;//支付金额

    private String paymentCode;//支付凭证号


    public Integer getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(Integer paymentMode) {
        this.paymentMode = paymentMode;
    }

    public BigDecimal getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(BigDecimal paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }
}
