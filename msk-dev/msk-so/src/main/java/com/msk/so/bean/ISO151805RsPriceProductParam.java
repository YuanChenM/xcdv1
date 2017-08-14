package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

/**
 * Created by liutao on 2016/10/18.
 */
public class ISO151805RsPriceProductParam extends BaseEntity {

    private String pdCode;

    private String logiAreaCode;

    private Integer orderQty;

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getLogiAreaCode() {
        return logiAreaCode;
    }

    public void setLogiAreaCode(String logiAreaCode) {
        this.logiAreaCode = logiAreaCode;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }
}
