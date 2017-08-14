/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表by_research_brand对应的ByResearchBrand。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class ByResearchBrand extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 产品照片ID */
    private String productId;
    /** 品类和需求调研ID */
    private Long categoryId;
    /** 产品照片后缀名 */
    private String productSuf;
    /** 品牌名称 */
    private String brandName;
    /**
     * <p>默认构造函数。</p>
     */
    public ByResearchBrand() {

    }

    /**
     * <p>产品照片ID。</p>
     *
     * @return the 产品照片ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * <p>产品照片ID。</p>
     *
     * @param productId 产品照片ID。
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * <p>品类和需求调研ID。</p>
     *
     * @return the 品类和需求调研ID
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * <p>品类和需求调研ID。</p>
     *
     * @param categoryId 品类和需求调研ID。
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * <p>产品照片后缀名。</p>
     *
     * @return the 产品照片后缀名
     */
    public String getProductSuf() {
        return productSuf;
    }

    /**
     * <p>产品照片后缀名。</p>
     *
     * @param productSuf 产品照片后缀名。
     */
    public void setProductSuf(String productSuf) {
        this.productSuf = productSuf;
    }

    /**
     * <p>品牌名称。</p>
     *
     * @return the 品牌名称
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * <p>品牌名称。</p>
     *
     * @param brandName 品牌名称。
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
