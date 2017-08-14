package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

/**
 * Created by liutao on 2016/10/19.
 */
public class ISO151805SkuCodeResult extends BaseEntity {

    private Integer orderSource;

    private String sellerCode;

    private String supplierCode;

    private String pdCode;

    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }
}
