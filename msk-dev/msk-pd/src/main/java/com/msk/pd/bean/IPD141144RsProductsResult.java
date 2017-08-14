package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * IPD141144RsResult.卖家产品库存查询
 *
 * @author xhy 2016-4-8
 */
public class IPD141144RsProductsResult extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String slCode;

    private String pdCode;

    private BigDecimal stockCnt;

    private String sellerCode;

    private Integer districtCode;

    /**
     * Getter method for property <tt>slCode</tt>.
     *
     * @return property value of slCode
     */
    public String getSlCode() {
        return slCode;
    }

    /**
     * Setter method for property <tt>slCode</tt>.
     *
     * @param slCode value to be assigned to property slCode
     */
    public void setSlCode(String slCode) {
        this.slCode = slCode;
    }

    /**
     * Getter method for property <tt>sellerCode</tt>.
     *
     * @return property value of sellerCode
     */
    public String getSellerCode() {
        return sellerCode;
    }

    /**
     * Setter method for property <tt>sellerCode</tt>.
     *
     * @param sellerCode value to be assigned to property sellerCode
     */
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    /**
     * Getter method for property <tt>districtCode</tt>.
     *
     * @return property value of districtCode
     */
    public Integer getDistrictCode() {
        return districtCode;
    }

    /**
     * Setter method for property <tt>districtCode</tt>.
     *
     * @param districtCode value to be assigned to property districtCode
     */
    public void setDistrictCode(Integer districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * Getter method for property <tt>pdCode</tt>.
     *
     * @return property value of pdCode
     */
    public String getPdCode() {
        return pdCode;
    }

    /**
     * Setter method for property <tt>pdCode</tt>.
     *
     * @param pdCode value to be assigned to property pdCode
     */
    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    /**
     * Getter method for property <tt>stockCnt</tt>.
     *
     * @return property value of stockCnt
     */
    public BigDecimal getStockCnt() {
        return stockCnt;
    }

    /**
     * Setter method for property <tt>stockCnt</tt>.
     *
     * @param stockCnt value to be assigned to property stockCnt
     */
    public void setStockCnt(BigDecimal stockCnt) {
        this.stockCnt = stockCnt;
    }
}