package com.msk.bp.bean;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * IBP11291IRsResult接口返回结果信息.
 *
 * @author xu_wei
 */
public class IBP11291IProducts extends BaseEntity {
    /**
     * 物流区编码
     */
    private String logiAreaCode;
    /**
     * 卖家编码
     */
    private String slCode;
    /**
     * 产品编码
     */
    private String productCode;
    /**
     * 产品列表
     */
    private List<IBP11291IProductsRsResult> pricelist;

    public String getLogiAreaCode() {
        return logiAreaCode;
    }

    public void setLogiAreaCode(String logiAreaCode) {
        this.logiAreaCode = logiAreaCode;
    }

    public String getSlCode() {
        return slCode;
    }

    public void setSlCode(String slCode) {
        this.slCode = slCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public List<IBP11291IProductsRsResult> getPricelist() {
        return pricelist;
    }

    public void setPricelist(List<IBP11291IProductsRsResult> pricelist) {
        this.pricelist = pricelist;
    }
}
