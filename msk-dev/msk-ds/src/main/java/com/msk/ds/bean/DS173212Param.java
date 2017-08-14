package com.msk.ds.bean;

import java.math.BigDecimal;

/**
 * zhou_yajun on 2016/1/28.
 */
public class DS173212Param {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**产品名称 */
    private String productName;
    /**产品编码 */
    private String productCode;
    /**产品品种名称 */
    private String productTypeName;
    /**产品特征 */
    private String productFeature;
    /**产品等级 */
    private String productLevel;
    /**产品规格 */
    private String productSpecifical;
    /**净重 */
    private BigDecimal netWeight;
    /**包装编码 */
    private String packageCode;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(String productFeature) {
        this.productFeature = productFeature;
    }

    public String getProductLevel() {
        return productLevel;
    }

    public void setProductLevel(String productLevel) {
        this.productLevel = productLevel;
    }

    public String getProductSpecifical() {
        return productSpecifical;
    }

    public void setProductSpecifical(String productSpecifical) {
        this.productSpecifical = productSpecifical;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }
}
