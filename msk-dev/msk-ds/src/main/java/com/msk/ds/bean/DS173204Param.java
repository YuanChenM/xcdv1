package com.msk.ds.bean;

import java.math.BigDecimal;

/**
 * zhou_yajun on 2016/1/28.
 */
public class DS173204Param {
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
    private BigDecimal productOnWayQty_1;
    /**6-10号入库汇总量 */
    private BigDecimal productOnWayQty_2;
    /**11-15号入库汇总量 */
    private BigDecimal productOnWayQty_3;
    /**16-20号入库汇总量 */
    private BigDecimal productOnWayQty_4;
    /**21-25号入库汇总量 */
    private BigDecimal productOnWayQty_5;
    /**26-月底入库汇总量 */
    private BigDecimal productOnWayQty_6;
    /**本月合计入库汇总量 */
    private BigDecimal sumProductOnWayQty;

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

    public BigDecimal getProductOnWayQty_1() {
        return productOnWayQty_1;
    }

    public void setProductOnWayQty_1(BigDecimal productOnWayQty_1) {
        this.productOnWayQty_1 = productOnWayQty_1;
    }

    public BigDecimal getProductOnWayQty_2() {
        return productOnWayQty_2;
    }

    public void setProductOnWayQty_2(BigDecimal productOnWayQty_2) {
        this.productOnWayQty_2 = productOnWayQty_2;
    }

    public BigDecimal getProductOnWayQty_3() {
        return productOnWayQty_3;
    }

    public void setProductOnWayQty_3(BigDecimal productOnWayQty_3) {
        this.productOnWayQty_3 = productOnWayQty_3;
    }

    public BigDecimal getProductOnWayQty_4() {
        return productOnWayQty_4;
    }

    public void setProductOnWayQty_4(BigDecimal productOnWayQty_4) {
        this.productOnWayQty_4 = productOnWayQty_4;
    }

    public BigDecimal getProductOnWayQty_5() {
        return productOnWayQty_5;
    }

    public void setProductOnWayQty_5(BigDecimal productOnWayQty_5) {
        this.productOnWayQty_5 = productOnWayQty_5;
    }

    public BigDecimal getProductOnWayQty_6() {
        return productOnWayQty_6;
    }

    public void setProductOnWayQty_6(BigDecimal productOnWayQty_6) {
        this.productOnWayQty_6 = productOnWayQty_6;
    }

    public BigDecimal getSumProductOnWayQty() {
        return sumProductOnWayQty;
    }

    public void setSumProductOnWayQty(BigDecimal sumProductOnWayQty) {
        this.sumProductOnWayQty = sumProductOnWayQty;
    }
}
