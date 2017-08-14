/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_house_product对应的SlHouseProduct。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlHouseProduct extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 区划(6)+顺序码(4) */
    private java.lang.String slCode;
    /** 用于登录的卖家账号 */
    private java.lang.String houseCode;
    /** 管家管理产品ID */
    private java.lang.Long pdId;
    /** 产品类别 */
    private java.lang.String pdClassesCode;
    /** 产品二级分类编码 */
    private java.lang.String machiningCode;
    /** 产品品种 */
    private java.lang.String pdBreedCode;
    /** 产品特征 */
    private java.lang.String pdFeatureCode;
    /**
     * <p>默认构造函数。</p>
     */
    public SlHouseProduct() {

    }

    /**
     * <p>区划(6)+顺序码(4)。</p>
     *
     * @return the 区划(6)+顺序码(4)
     */
    public java.lang.String getSlCode() {
        return slCode;
    }

    /**
     * <p>区划(6)+顺序码(4)。</p>
     *
     * @param slCode 区划(6)+顺序码(4)。
     */
    public void setSlCode(java.lang.String slCode) {
        this.slCode = slCode;
    }

    /**
     * <p>用于登录的卖家账号。</p>
     *
     * @return the 用于登录的卖家账号
     */
    public java.lang.String getHouseCode() {
        return houseCode;
    }

    /**
     * <p>用于登录的卖家账号。</p>
     *
     * @param houseCode 用于登录的卖家账号。
     */
    public void setHouseCode(java.lang.String houseCode) {
        this.houseCode = houseCode;
    }

    /**
     * <p>管家管理产品ID。</p>
     *
     * @return the 管家管理产品ID
     */
    public java.lang.Long getPdId() {
        return pdId;
    }

    /**
     * <p>管家管理产品ID。</p>
     *
     * @param pdId 管家管理产品ID。
     */
    public void setPdId(java.lang.Long pdId) {
        this.pdId = pdId;
    }

    /**
     * <p>产品类别。</p>
     *
     * @return the 产品类别
     */
    public java.lang.String getPdClassesCode() {
        return pdClassesCode;
    }

    /**
     * <p>产品类别。</p>
     *
     * @param pdClassesCode 产品类别。
     */
    public void setPdClassesCode(java.lang.String pdClassesCode) {
        this.pdClassesCode = pdClassesCode;
    }

    /**
     * <p>产品二级分类编码。</p>
     *
     * @return the 产品二级分类编码
     */
    public java.lang.String getMachiningCode() {
        return machiningCode;
    }

    /**
     * <p>产品二级分类编码。</p>
     *
     * @param machiningCode 产品二级分类编码。
     */
    public void setMachiningCode(java.lang.String machiningCode) {
        this.machiningCode = machiningCode;
    }

    /**
     * <p>产品品种。</p>
     *
     * @return the 产品品种
     */
    public java.lang.String getPdBreedCode() {
        return pdBreedCode;
    }

    /**
     * <p>产品品种。</p>
     *
     * @param pdBreedCode 产品品种。
     */
    public void setPdBreedCode(java.lang.String pdBreedCode) {
        this.pdBreedCode = pdBreedCode;
    }

    /**
     * <p>产品特征。</p>
     *
     * @return the 产品特征
     */
    public java.lang.String getPdFeatureCode() {
        return pdFeatureCode;
    }

    /**
     * <p>产品特征。</p>
     *
     * @param pdFeatureCode 产品特征。
     */
    public void setPdFeatureCode(java.lang.String pdFeatureCode) {
        this.pdFeatureCode = pdFeatureCode;
    }

}
