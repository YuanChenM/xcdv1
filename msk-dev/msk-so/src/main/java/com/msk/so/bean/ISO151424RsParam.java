package com.msk.so.bean;

import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsPageParam;


/**
 * Created by wang_jianzhou on 2016/4/18.
 */
public class ISO151424RsParam extends RsPageParam {

    private String sellerCode;

    private Integer supplyPlatform;

    private String supplierCode;

    private String lgcsCode;

    private Integer status;

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public Integer getSupplyPlatform() {
        return supplyPlatform;
    }

    public void setSupplyPlatform(Integer supplyPlatform) {
        this.supplyPlatform = supplyPlatform;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getLgcsCode() {
        return lgcsCode;
    }

    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
