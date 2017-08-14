package com.msk.ds.bean;

import java.math.BigDecimal;

/**
 * zhou_yajun on 2016/1/28.
 */
public class DS173211Param {
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
    /**1-5号入库汇总量 */
    private BigDecimal productStorageQty_1;
    /**6-10号入库汇总量 */
    private BigDecimal productStorageQty_2;
    /**11-15号入库汇总量 */
    private BigDecimal productStorageQty_3;
    /**16-20号入库汇总量 */
    private BigDecimal productStorageQty_4;
    /**21-25号入库汇总量 */
    private BigDecimal productStorageQty_5;
    /**26-月底入库汇总量 */
    private BigDecimal productStorageQty_6;
    /**本月合计入库汇总量 */
    private BigDecimal sumProductStorageQty;

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

    public BigDecimal getProductStorageQty_1() {
        return productStorageQty_1;
    }

    public void setProductStorageQty_1(BigDecimal productStorageQty_1) {
        this.productStorageQty_1 = productStorageQty_1;
    }

    public BigDecimal getProductStorageQty_2() {
        return productStorageQty_2;
    }

    public void setProductStorageQty_2(BigDecimal productStorageQty_2) {
        this.productStorageQty_2 = productStorageQty_2;
    }

    public BigDecimal getProductStorageQty_3() {
        return productStorageQty_3;
    }

    public void setProductStorageQty_3(BigDecimal productStorageQty_3) {
        this.productStorageQty_3 = productStorageQty_3;
    }

    public BigDecimal getProductStorageQty_4() {
        return productStorageQty_4;
    }

    public void setProductStorageQty_4(BigDecimal productStorageQty_4) {
        this.productStorageQty_4 = productStorageQty_4;
    }

    public BigDecimal getProductStorageQty_5() {
        return productStorageQty_5;
    }

    public void setProductStorageQty_5(BigDecimal productStorageQty_5) {
        this.productStorageQty_5 = productStorageQty_5;
    }

    public BigDecimal getProductStorageQty_6() {
        return productStorageQty_6;
    }

    public void setProductStorageQty_6(BigDecimal productStorageQty_6) {
        this.productStorageQty_6 = productStorageQty_6;
    }

    public BigDecimal getSumProductStorageQty() {
        return sumProductStorageQty;
    }

    public void setSumProductStorageQty(BigDecimal sumProductStorageQty) {
        this.sumProductStorageQty = sumProductStorageQty;
    }
}
