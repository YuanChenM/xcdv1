package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * ISO151401RsResult.卖家产品库存查询
 *
 * @author sjj
 */
public class ISO151401RsResult extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String sellerCode;

    private Integer districtCode;

    private String districtName;

    private List<ISO151401RsProductsResult> products;

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
     * Getter method for property <tt>products</tt>.
     *
     * @return property value of products
     */
    public List<ISO151401RsProductsResult> getProducts() {
        return products;
    }

    /**
     * Setter method for property <tt>products</tt>.
     *
     * @param products value to be assigned to property products
     */
    public void setProducts(List<ISO151401RsProductsResult> products) {
        this.products = products;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}