/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表pd_logiarea对应的PdLogiarea。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class PdLogiarea extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 物流区ID */
    private java.lang.Long lgcsId;
    /** 物流区编码 */
    private java.lang.String lgcsCode;
    /** LGCS_NAME */
    private java.lang.String lgcsName;
    /** 类别编码 */
    private java.lang.String classesCode;
    /** 二级分类编码 */
    private java.lang.String machiningCode;
    /** 品种编码 */
    private java.lang.String breedCode;
    /** 特征编码 */
    private java.lang.String featureCode;
    /** 净重编码 */
    private java.lang.String weightCode;
    /** 产品包装编码 */
    private java.lang.String pkgCode;
    /** 产品等级编码 */
    private java.lang.String gradeCode;
    /** PD_MARKET_CODE */
    private java.lang.String pdMarketCode;
    /** 产品标签 */
    private java.lang.String pdLabel;
    /** 状态 0上架 1下架 9无状态 */
    private java.lang.String status;
    /**
     * <p>默认构造函数。</p>
     */
    public PdLogiarea() {

    }

    /**
     * <p>物流区ID。</p>
     *
     * @return the 物流区ID
     */
    public java.lang.Long getLgcsId() {
        return lgcsId;
    }

    /**
     * <p>物流区ID。</p>
     *
     * @param lgcsId 物流区ID。
     */
    public void setLgcsId(java.lang.Long lgcsId) {
        this.lgcsId = lgcsId;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @return the 物流区编码
     */
    public java.lang.String getLgcsCode() {
        return lgcsCode;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @param lgcsCode 物流区编码。
     */
    public void setLgcsCode(java.lang.String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    /**
     * <p>LGCS_NAME。</p>
     *
     * @return the LGCS_NAME
     */
    public java.lang.String getLgcsName() {
        return lgcsName;
    }

    /**
     * <p>LGCS_NAME。</p>
     *
     * @param lgcsName LGCS_NAME。
     */
    public void setLgcsName(java.lang.String lgcsName) {
        this.lgcsName = lgcsName;
    }

    /**
     * <p>类别编码。</p>
     *
     * @return the 类别编码
     */
    public java.lang.String getClassesCode() {
        return classesCode;
    }

    /**
     * <p>类别编码。</p>
     *
     * @param classesCode 类别编码。
     */
    public void setClassesCode(java.lang.String classesCode) {
        this.classesCode = classesCode;
    }

    /**
     * <p>二级分类编码。</p>
     *
     * @return the 二级分类编码
     */
    public java.lang.String getMachiningCode() {
        return machiningCode;
    }

    /**
     * <p>二级分类编码。</p>
     *
     * @param machiningCode 二级分类编码。
     */
    public void setMachiningCode(java.lang.String machiningCode) {
        this.machiningCode = machiningCode;
    }

    /**
     * <p>品种编码。</p>
     *
     * @return the 品种编码
     */
    public java.lang.String getBreedCode() {
        return breedCode;
    }

    /**
     * <p>品种编码。</p>
     *
     * @param breedCode 品种编码。
     */
    public void setBreedCode(java.lang.String breedCode) {
        this.breedCode = breedCode;
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
     * <p>净重编码。</p>
     *
     * @return the 净重编码
     */
    public java.lang.String getWeightCode() {
        return weightCode;
    }

    /**
     * <p>净重编码。</p>
     *
     * @param weightCode 净重编码。
     */
    public void setWeightCode(java.lang.String weightCode) {
        this.weightCode = weightCode;
    }

    /**
     * <p>产品包装编码。</p>
     *
     * @return the 产品包装编码
     */
    public java.lang.String getPkgCode() {
        return pkgCode;
    }

    /**
     * <p>产品包装编码。</p>
     *
     * @param pkgCode 产品包装编码。
     */
    public void setPkgCode(java.lang.String pkgCode) {
        this.pkgCode = pkgCode;
    }

    /**
     * <p>产品等级编码。</p>
     *
     * @return the 产品等级编码
     */
    public java.lang.String getGradeCode() {
        return gradeCode;
    }

    /**
     * <p>产品等级编码。</p>
     *
     * @param gradeCode 产品等级编码。
     */
    public void setGradeCode(java.lang.String gradeCode) {
        this.gradeCode = gradeCode;
    }

    /**
     * <p>PD_MARKET_CODE。</p>
     *
     * @return the PD_MARKET_CODE
     */
    public java.lang.String getPdMarketCode() {
        return pdMarketCode;
    }

    /**
     * <p>PD_MARKET_CODE。</p>
     *
     * @param pdMarketCode PD_MARKET_CODE。
     */
    public void setPdMarketCode(java.lang.String pdMarketCode) {
        this.pdMarketCode = pdMarketCode;
    }

    /**
     * <p>产品标签。</p>
     *
     * @return the 产品标签
     */
    public java.lang.String getPdLabel() {
        return pdLabel;
    }

    /**
     * <p>产品标签。</p>
     *
     * @param pdLabel 产品标签。
     */
    public void setPdLabel(java.lang.String pdLabel) {
        this.pdLabel = pdLabel;
    }

    /**
     * <p>状态 0上架 1下架 9无状态。</p>
     *
     * @return the 状态 0上架 1下架 9无状态
     */
    public java.lang.String getStatus() {
        return status;
    }

    /**
     * <p>状态 0上架 1下架 9无状态。</p>
     *
     * @param status 状态 0上架 1下架 9无状态。
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }

}
