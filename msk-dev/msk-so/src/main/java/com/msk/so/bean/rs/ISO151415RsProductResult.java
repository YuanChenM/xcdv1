package com.msk.so.bean.rs;

import com.msk.pd.bean.BaseProductBean;

import java.math.BigDecimal;

/**
 * Created by yang_chunyan on 2016/3/23.
 */
public class ISO151415RsProductResult extends BaseProductBean {
    private Long orderId;
    //供货数
    private BigDecimal orderQty;
    //收货数
    private BigDecimal receiveQty;
    //总供货数
    private BigDecimal sumOrderQty;
    //总收货数
    private BigDecimal sumReceiveQty;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(BigDecimal orderQty) {
        this.orderQty = orderQty;
    }

    public BigDecimal getReceiveQty() {
        return receiveQty;
    }

    public void setReceiveQty(BigDecimal receiveQty) {
        this.receiveQty = receiveQty;
    }

    public BigDecimal getSumOrderQty() {
        return sumOrderQty;
    }

    public void setSumOrderQty(BigDecimal sumOrderQty) {
        this.sumOrderQty = sumOrderQty;
    }

    public BigDecimal getSumReceiveQty() {
        return sumReceiveQty;
    }

    public void setSumReceiveQty(BigDecimal sumReceiveQty) {
        this.sumReceiveQty = sumReceiveQty;
    }
}
