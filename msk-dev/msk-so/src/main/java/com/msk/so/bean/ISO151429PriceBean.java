package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * Created by wang_shuai on 2016/6/27.
 */
public class ISO151429PriceBean extends BaseEntity {
    /*产品编码*/
    private String pdCode;

    /*箱价（元/箱）*/
    private BigDecimal wayGradePriceBox;

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public BigDecimal getWayGradePriceBox() {
        return wayGradePriceBox;
    }

    public void setWayGradePriceBox(BigDecimal wayGradePriceBox) {
        this.wayGradePriceBox = wayGradePriceBox;
    }
}
