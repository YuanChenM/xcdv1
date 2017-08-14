package com.msk.so.bean;

import com.msk.core.bean.BaseBean;

/**
 * Created by wang_shuai on 2016/6/23.
 */
public class ISO151427SoProduct extends BaseBean {
    //商品编码
    private String pdCode;
    //商品名称
    private String pdName;
    //商品数量
    private long pdCount;
    //单价
    private long unitPrice;

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

    public long getPdCount() {
        return pdCount;
    }

    public void setPdCount(long pdCount) {
        this.pdCount = pdCount;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }
}
