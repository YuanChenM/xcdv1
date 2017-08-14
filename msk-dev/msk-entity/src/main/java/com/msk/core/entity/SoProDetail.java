/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_pro_detail对应的SoProDetail。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoProDetail extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 意愿ID */
    private java.lang.Long proId;
    /** PRO_CODE */
    private java.lang.String proCode;
    /** PRO_DETAIL_ID */
    private java.lang.Long proDetailId;
    /** 产品类型 */
    private java.lang.String classesCode;
    /** 产品类型名称 */
    private java.lang.String classesName;
    /** 产品品种 */
    private java.lang.String breedCode;
    /** 产品品种名称 */
    private java.lang.String breedName;
    /** 特征编码 */
    private java.lang.String featureCode;
    /** 特征名称 */
    private java.lang.String featureName;
    /** 产品包装编码 */
    private java.lang.String normsCode;
    /** 产品包装名称 */
    private java.lang.String normsName;
    /** 产品编号 */
    private java.lang.String pdCode;
    /** 产品名称 */
    private java.lang.String pdName;
    /** 产品等级 */
    private java.lang.String pdLevel;
    /** 产品等级编码 */
    private java.lang.String pdGradeCode;
    /** 产品等级名称 */
    private java.lang.String pdGradeName;
    /** 产品单位 */
    private java.lang.String pdUnit;
    /** 单箱体积 */
    private java.math.BigDecimal packingVolume;
    /** 重量 */
    private java.math.BigDecimal pdWeight;
    /** 体积 */
    private java.math.BigDecimal pdVolume;
    /** 订单价格 */
    private java.math.BigDecimal orderPrice;
    /** 价盘周期 */
    private java.lang.String priceCycle;
    /** 订单数量 */
    private java.math.BigDecimal orderQty;
    /**
     * <p>默认构造函数。</p>
     */
    public SoProDetail() {

    }

    /**
     * <p>意愿ID。</p>
     *
     * @return the 意愿ID
     */
    public java.lang.Long getProId() {
        return proId;
    }

    /**
     * <p>意愿ID。</p>
     *
     * @param proId 意愿ID。
     */
    public void setProId(java.lang.Long proId) {
        this.proId = proId;
    }

    /**
     * <p>PRO_CODE。</p>
     *
     * @return the PRO_CODE
     */
    public java.lang.String getProCode() {
        return proCode;
    }

    /**
     * <p>PRO_CODE。</p>
     *
     * @param proCode PRO_CODE。
     */
    public void setProCode(java.lang.String proCode) {
        this.proCode = proCode;
    }

    /**
     * <p>PRO_DETAIL_ID。</p>
     *
     * @return the PRO_DETAIL_ID
     */
    public java.lang.Long getProDetailId() {
        return proDetailId;
    }

    /**
     * <p>意愿明细ID。</p>
     *
     * @param proDetailId 意愿明细ID。
     */
    public void setProDetailId(java.lang.Long proDetailId) {
        this.proDetailId = proDetailId;
    }

    /**
     * <p>产品类型。</p>
     *
     * @return the 产品类型
     */
    public java.lang.String getClassesCode() {
        return classesCode;
    }

    /**
     * <p>产品类型。</p>
     *
     * @param classesCode 产品类型。
     */
    public void setClassesCode(java.lang.String classesCode) {
        this.classesCode = classesCode;
    }

    /**
     * <p>产品类型名称。</p>
     *
     * @return the 产品类型名称
     */
    public java.lang.String getClassesName() {
        return classesName;
    }

    /**
     * <p>产品类型名称。</p>
     *
     * @param classesName 产品类型名称。
     */
    public void setClassesName(java.lang.String classesName) {
        this.classesName = classesName;
    }

    /**
     * <p>产品品种。</p>
     *
     * @return the 产品品种
     */
    public java.lang.String getBreedCode() {
        return breedCode;
    }

    /**
     * <p>产品品种。</p>
     *
     * @param breedCode 产品品种。
     */
    public void setBreedCode(java.lang.String breedCode) {
        this.breedCode = breedCode;
    }

    /**
     * <p>产品品种名称。</p>
     *
     * @return the 产品品种名称
     */
    public java.lang.String getBreedName() {
        return breedName;
    }

    /**
     * <p>产品品种名称。</p>
     *
     * @param breedName 产品品种名称。
     */
    public void setBreedName(java.lang.String breedName) {
        this.breedName = breedName;
    }

    /**
     * <p>特征编码。</p>
     *
     * @return the 特征编码
     */
    public java.lang.String getFeatureCode() {
        return featureCode;
    }

    /**
     * <p>特征编码。</p>
     *
     * @param featureCode 特征编码。
     */
    public void setFeatureCode(java.lang.String featureCode) {
        this.featureCode = featureCode;
    }

    /**
     * <p>特征名称。</p>
     *
     * @return the 特征名称
     */
    public java.lang.String getFeatureName() {
        return featureName;
    }

    /**
     * <p>特征名称。</p>
     *
     * @param featureName 特征名称。
     */
    public void setFeatureName(java.lang.String featureName) {
        this.featureName = featureName;
    }

    /**
     * <p>产品包装编码。</p>
     *
     * @return the 产品包装编码
     */
    public java.lang.String getNormsCode() {
        return normsCode;
    }

    /**
     * <p>产品包装编码。</p>
     *
     * @param normsCode 产品包装编码。
     */
    public void setNormsCode(java.lang.String normsCode) {
        this.normsCode = normsCode;
    }

    /**
     * <p>产品包装名称。</p>
     *
     * @return the 产品包装名称
     */
    public java.lang.String getNormsName() {
        return normsName;
    }

    /**
     * <p>产品包装名称。</p>
     *
     * @param normsName 产品包装名称。
     */
    public void setNormsName(java.lang.String normsName) {
        this.normsName = normsName;
    }

    /**
     * <p>产品编号。</p>
     *
     * @return the 产品编号
     */
    public java.lang.String getPdCode() {
        return pdCode;
    }

    /**
     * <p>产品编号。</p>
     *
     * @param pdCode 产品编号。
     */
    public void setPdCode(java.lang.String pdCode) {
        this.pdCode = pdCode;
    }

    /**
     * <p>产品名称。</p>
     *
     * @return the 产品名称
     */
    public java.lang.String getPdName() {
        return pdName;
    }

    /**
     * <p>产品名称。</p>
     *
     * @param pdName 产品名称。
     */
    public void setPdName(java.lang.String pdName) {
        this.pdName = pdName;
    }

    /**
     * <p>产品等级。</p>
     *
     * @return the 产品等级
     */
    public java.lang.String getPdLevel() {
        return pdLevel;
    }

    /**
     * <p>产品等级。</p>
     *
     * @param pdLevel 产品等级。
     */
    public void setPdLevel(java.lang.String pdLevel) {
        this.pdLevel = pdLevel;
    }

    /**
     * <p>产品等级编码。</p>
     *
     * @return the 产品等级编码
     */
    public java.lang.String getPdGradeCode() {
        return pdGradeCode;
    }

    /**
     * <p>产品等级编码。</p>
     *
     * @param pdGradeCode 产品等级编码。
     */
    public void setPdGradeCode(java.lang.String pdGradeCode) {
        this.pdGradeCode = pdGradeCode;
    }

    /**
     * <p>产品等级名称。</p>
     *
     * @return the 产品等级名称
     */
    public java.lang.String getPdGradeName() {
        return pdGradeName;
    }

    /**
     * <p>产品等级名称。</p>
     *
     * @param pdGradeName 产品等级名称。
     */
    public void setPdGradeName(java.lang.String pdGradeName) {
        this.pdGradeName = pdGradeName;
    }

    /**
     * <p>产品单位。</p>
     *
     * @return the 产品单位
     */
    public java.lang.String getPdUnit() {
        return pdUnit;
    }

    /**
     * <p>产品单位。</p>
     *
     * @param pdUnit 产品单位。
     */
    public void setPdUnit(java.lang.String pdUnit) {
        this.pdUnit = pdUnit;
    }

    /**
     * <p>单箱体积。</p>
     *
     * @return the 单箱体积
     */
    public java.math.BigDecimal getPackingVolume() {
        return packingVolume;
    }

    /**
     * <p>单箱体积。</p>
     *
     * @param packingVolume 单箱体积。
     */
    public void setPackingVolume(java.math.BigDecimal packingVolume) {
        this.packingVolume = packingVolume;
    }

    /**
     * <p>重量。</p>
     *
     * @return the 重量
     */
    public java.math.BigDecimal getPdWeight() {
        return pdWeight;
    }

    /**
     * <p>重量。</p>
     *
     * @param pdWeight 重量。
     */
    public void setPdWeight(java.math.BigDecimal pdWeight) {
        this.pdWeight = pdWeight;
    }

    /**
     * <p>体积。</p>
     *
     * @return the 体积
     */
    public java.math.BigDecimal getPdVolume() {
        return pdVolume;
    }

    /**
     * <p>体积。</p>
     *
     * @param pdVolume 体积。
     */
    public void setPdVolume(java.math.BigDecimal pdVolume) {
        this.pdVolume = pdVolume;
    }

    /**
     * <p>订单价格。</p>
     *
     * @return the 订单价格
     */
    public java.math.BigDecimal getOrderPrice() {
        return orderPrice;
    }

    /**
     * <p>订单价格。</p>
     *
     * @param orderPrice 订单价格。
     */
    public void setOrderPrice(java.math.BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * <p>价盘周期。</p>
     *
     * @return the 价盘周期
     */
    public java.lang.String getPriceCycle() {
        return priceCycle;
    }

    /**
     * <p>价盘周期。</p>
     *
     * @param priceCycle 价盘周期。
     */
    public void setPriceCycle(java.lang.String priceCycle) {
        this.priceCycle = priceCycle;
    }

    /**
     * <p>订单数量。</p>
     *
     * @return the 订单数量
     */
    public java.math.BigDecimal getOrderQty() {
        return orderQty;
    }

    /**
     * <p>订单数量。</p>
     *
     * @param orderQty 订单数量。
     */
    public void setOrderQty(java.math.BigDecimal orderQty) {
        this.orderQty = orderQty;
    }

}
