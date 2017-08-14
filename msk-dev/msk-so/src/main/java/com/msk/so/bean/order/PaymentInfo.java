package com.msk.so.bean.order;

import com.msk.core.bean.BaseParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by sun_jiaju on 2016/10/20.
 */
public class PaymentInfo extends BaseParam {

    private static final long serialVersionUID = 1L;

    /** 付款方式 */
    private Integer paymentMode;

    /** 支付金额 */
    private BigDecimal paymentMoney;

    /** 支付凭证号 */
    private String paymentCode;

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
