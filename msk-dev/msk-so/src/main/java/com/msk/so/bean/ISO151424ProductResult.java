package com.msk.so.bean;

import com.msk.core.bean.BaseBean;
import java.math.BigDecimal;

/**
 * Created by wang_jianzhou on 2016/4/18.
 */
public class ISO151424ProductResult extends BaseBean {

    private String productName;

    private BigDecimal stock;

    private String productCode;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
