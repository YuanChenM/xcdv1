package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * Created by liutao on 2016/10/18.
 */
public class ISO151805RsPriceProductResult extends BaseEntity{

    private String pdCode;

    private String priceCycle;

    private String orderLevel;

    private BigDecimal pdBoxPrice;

    private Integer startQty;

    private Integer endQty;

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPriceCycle() {
        return priceCycle;
    }

    public void setPriceCycle(String priceCycle) {
        this.priceCycle = priceCycle;
    }

    public String getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(String orderLevel) {
        this.orderLevel = orderLevel;
    }

    public BigDecimal getPdBoxPrice() {
        return pdBoxPrice;
    }

    public void setPdBoxPrice(BigDecimal pdBoxPrice) {
        this.pdBoxPrice = pdBoxPrice;
    }

    public Integer getStartQty() {
        return startQty;
    }

    public void setStartQty(Integer startQty) {
        this.startQty = startQty;
    }

    public Integer getEndQty() {
        return endQty;
    }

    public void setEndQty(Integer endQty) {
        this.endQty = endQty;
    }
}
