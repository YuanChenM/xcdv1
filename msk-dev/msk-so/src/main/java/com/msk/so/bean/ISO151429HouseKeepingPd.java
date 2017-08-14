package com.msk.so.bean;

import com.msk.core.bean.BaseBean;

import java.math.BigDecimal;

/**
 * Created by wang_shuai on 2016/6/24.
 */
public class ISO151429HouseKeepingPd extends BaseBean {
    //买手code
    private String slCode;
    //商品编码
    private String pdCode;
    //商品名称
    private String pdName;
    //单价
    private BigDecimal unitPrice;
    //库存
    private long stockQty;

    public String getSlCode() {
        return slCode;
    }

    public void setSlCode(String slCode) {
        this.slCode = slCode;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public long getStockQty() {
        return stockQty;
    }

    public void setStockQty(long stockQty) {
        this.stockQty = stockQty;
    }
}
