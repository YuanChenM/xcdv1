/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表by_research_cat_detail对应的ByResearchCatDetail。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class ByResearchCatDetail extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 明细ID */
    private java.lang.Long detailId;
    /** 品类和需求调研ID */
    private java.lang.Long categoryId;
    /** 产品特征 */
    private java.lang.String featureCode;
    /** 是否为标准目录产品(0:非标准目录产品,1:标准目录产品) */
    private java.lang.String isStandard;
    /** 需求规格 */
    private java.lang.String demandFeature;
    /** 是否有需求(0:无需求,1:有需求) */
    private java.lang.String hasDemand;
    /** 单位：箱 */
    private java.lang.Integer demandQty;
    /** 单位：箱 */
    private java.lang.Integer orderQty;
    /** 单位：元/箱 */
    private java.math.BigDecimal hopePrice;
    /** 配送时间 */
    private java.lang.String delivery;
    /** 备注 */
    private java.lang.String remark;
    /**
     * <p>默认构造函数。</p>
     */
    public ByResearchCatDetail() {

    }

    /**
     * <p>明细ID。</p>
     *
     * @return the 明细ID
     */
    public java.lang.Long getDetailId() {
        return detailId;
    }

    /**
     * <p>明细ID。</p>
     *
     * @param detailId 明细ID。
     */
    public void setDetailId(java.lang.Long detailId) {
        this.detailId = detailId;
    }

    /**
     * <p>品类和需求调研ID。</p>
     *
     * @return the 品类和需求调研ID
     */
    public java.lang.Long getCategoryId() {
        return categoryId;
    }

    /**
     * <p>品类和需求调研ID。</p>
     *
     * @param categoryId 品类和需求调研ID。
     */
    public void setCategoryId(java.lang.Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * <p>产品特征。</p>
     *
     * @return the 产品特征
     */
    public java.lang.String getFeatureCode() {
        return featureCode;
    }

    /**
     * <p>产品特征。</p>
     *
     * @param featureCode 产品特征。
     */
    public void setFeatureCode(java.lang.String featureCode) {
        this.featureCode = featureCode;
    }

    /**
     * <p>是否为标准目录产品(0:非标准目录产品,1:标准目录产品)。</p>
     *
     * @return the 是否为标准目录产品(0:非标准目录产品,1:标准目录产品)
     */
    public java.lang.String getIsStandard() {
        return isStandard;
    }

    /**
     * <p>是否为标准目录产品(0:非标准目录产品,1:标准目录产品)。</p>
     *
     * @param isStandard 是否为标准目录产品(0:非标准目录产品,1:标准目录产品)。
     */
    public void setIsStandard(java.lang.String isStandard) {
        this.isStandard = isStandard;
    }

    /**
     * <p>需求规格。</p>
     *
     * @return the 需求规格
     */
    public java.lang.String getDemandFeature() {
        return demandFeature;
    }

    /**
     * <p>需求规格。</p>
     *
     * @param demandFeature 需求规格。
     */
    public void setDemandFeature(java.lang.String demandFeature) {
        this.demandFeature = demandFeature;
    }

    /**
     * <p>是否有需求(0:无需求,1:有需求)。</p>
     *
     * @return the 是否有需求(0:无需求,1:有需求)
     */
    public java.lang.String getHasDemand() {
        return hasDemand;
    }

    /**
     * <p>是否有需求(0:无需求,1:有需求)。</p>
     *
     * @param hasDemand 是否有需求(0:无需求,1:有需求)。
     */
    public void setHasDemand(java.lang.String hasDemand) {
        this.hasDemand = hasDemand;
    }

    /**
     * <p>单位：箱。</p>
     *
     * @return the 单位：箱
     */
    public java.lang.Integer getDemandQty() {
        return demandQty;
    }

    /**
     * <p>单位：箱。</p>
     *
     * @param demandQty 单位：箱。
     */
    public void setDemandQty(java.lang.Integer demandQty) {
        this.demandQty = demandQty;
    }

    /**
     * <p>单位：箱。</p>
     *
     * @return the 单位：箱
     */
    public java.lang.Integer getOrderQty() {
        return orderQty;
    }

    /**
     * <p>单位：箱。</p>
     *
     * @param orderQty 单位：箱。
     */
    public void setOrderQty(java.lang.Integer orderQty) {
        this.orderQty = orderQty;
    }

    /**
     * <p>单位：元/箱。</p>
     *
     * @return the 单位：元/箱
     */
    public java.math.BigDecimal getHopePrice() {
        return hopePrice;
    }

    /**
     * <p>单位：元/箱。</p>
     *
     * @param hopePrice 单位：元/箱。
     */
    public void setHopePrice(java.math.BigDecimal hopePrice) {
        this.hopePrice = hopePrice;
    }

    /**
     * <p>配送时间。</p>
     *
     * @return the 配送时间
     */
    public java.lang.String getDelivery() {
        return delivery;
    }

    /**
     * <p>配送时间。</p>
     *
     * @param delivery 配送时间。
     */
    public void setDelivery(java.lang.String delivery) {
        this.delivery = delivery;
    }

    /**
     * <p>备注。</p>
     *
     * @return the 备注
     */
    public java.lang.String getRemark() {
        return remark;
    }

    /**
     * <p>备注。</p>
     *
     * @param remark 备注。
     */
    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

}
