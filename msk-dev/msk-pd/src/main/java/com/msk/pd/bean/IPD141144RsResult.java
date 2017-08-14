package com.msk.pd.bean;

import com.msk.core.bean.RsPageResult;
import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * IPD141144RsResult.卖家产品库存查询
 *
 * @author xhy 2016-4-8
 */
public class IPD141144RsResult extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String sellerCode;

    private Integer districtCode;

    private List<IPD141144RsProductsResult>  products;

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
    public List<IPD141144RsProductsResult> getProducts() {
        return products;
    }

    /**
     * Setter method for property <tt>products</tt>.
     *
     * @param products value to be assigned to property products
     */
    public void setProducts(List<IPD141144RsProductsResult> products) {
        this.products = products;
    }
}