/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表by_research_std_tsp对应的ByResearchStdTsp。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class ByResearchStdTsp extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** ID */
    private java.lang.Long id;
    /** 买家ID */
    private java.lang.String buyerId;
    /** 产品类别 */
    private java.lang.String classesCode;
    /** 产品加工类型 */
    private java.lang.String machiningCode;
    /** 产品品种 */
    private java.lang.String breedCode;
    /** 产品标准ID */
    private java.lang.Long standardId;
    /** 储存运输标准项目ID */
    private java.lang.String tspStdItemId;
    /** 储存运输标准项目名称 */
    private java.lang.String tspStdItemName;
    /** 合格值 */
    private java.lang.String okVal;
    /** 1:是 */
    private java.lang.String okValAgree;
    /** 不合格值 */
    private java.lang.String ngVal;
    /** 调研描述 */
    private java.lang.String description;
    /** 备注 */
    private java.lang.String remark;
    /** 是否已调研 */
    private java.lang.String isResearch;
    /**
     * <p>默认构造函数。</p>
     */
    public ByResearchStdTsp() {

    }

    /**
     * <p>ID。</p>
     *
     * @return the ID
     */
    public java.lang.Long getId() {
        return id;
    }

    /**
     * <p>ID。</p>
     *
     * @param id ID。
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    /**
     * <p>买家ID。</p>
     *
     * @return the 买家ID
     */
    public java.lang.String getBuyerId() {
        return buyerId;
    }

    /**
     * <p>买家ID。</p>
     *
     * @param buyerId 买家ID。
     */
    public void setBuyerId(java.lang.String buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * <p>产品类别。</p>
     *
     * @return the 产品类别
     */
    public java.lang.String getClassesCode() {
        return classesCode;
    }

    /**
     * <p>产品类别。</p>
     *
     * @param classesCode 产品类别。
     */
    public void setClassesCode(java.lang.String classesCode) {
        this.classesCode = classesCode;
    }

    /**
     * <p>产品加工类型。</p>
     *
     * @return the 产品加工类型
     */
    public java.lang.String getMachiningCode() {
        return machiningCode;
    }

    /**
     * <p>产品加工类型。</p>
     *
     * @param machiningCode 产品加工类型。
     */
    public void setMachiningCode(java.lang.String machiningCode) {
        this.machiningCode = machiningCode;
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
     * <p>产品标准ID。</p>
     *
     * @return the 产品标准ID
     */
    public java.lang.Long getStandardId() {
        return standardId;
    }

    /**
     * <p>产品标准ID。</p>
     *
     * @param standardId 产品标准ID。
     */
    public void setStandardId(java.lang.Long standardId) {
        this.standardId = standardId;
    }

    /**
     * <p>储存运输标准项目ID。</p>
     *
     * @return the 储存运输标准项目ID
     */
    public java.lang.String getTspStdItemId() {
        return tspStdItemId;
    }

    /**
     * <p>储存运输标准项目ID。</p>
     *
     * @param tspStdItemId 储存运输标准项目ID。
     */
    public void setTspStdItemId(java.lang.String tspStdItemId) {
        this.tspStdItemId = tspStdItemId;
    }

    /**
     * <p>储存运输标准项目名称。</p>
     *
     * @return the 储存运输标准项目名称
     */
    public java.lang.String getTspStdItemName() {
        return tspStdItemName;
    }

    /**
     * <p>储存运输标准项目名称。</p>
     *
     * @param tspStdItemName 储存运输标准项目名称。
     */
    public void setTspStdItemName(java.lang.String tspStdItemName) {
        this.tspStdItemName = tspStdItemName;
    }

    /**
     * <p>合格值。</p>
     *
     * @return the 合格值
     */
    public java.lang.String getOkVal() {
        return okVal;
    }

    /**
     * <p>合格值。</p>
     *
     * @param okVal 合格值。
     */
    public void setOkVal(java.lang.String okVal) {
        this.okVal = okVal;
    }

    /**
     * <p>1:是。</p>
     *
     * @return the 1:是
     */
    public java.lang.String getOkValAgree() {
        return okValAgree;
    }

    /**
     * <p>1:是。</p>
     *
     * @param okValAgree 1:是。
     */
    public void setOkValAgree(java.lang.String okValAgree) {
        this.okValAgree = okValAgree;
    }

    /**
     * <p>不合格值。</p>
     *
     * @return the 不合格值
     */
    public java.lang.String getNgVal() {
        return ngVal;
    }

    /**
     * <p>不合格值。</p>
     *
     * @param ngVal 不合格值。
     */
    public void setNgVal(java.lang.String ngVal) {
        this.ngVal = ngVal;
    }

    /**
     * <p>调研描述。</p>
     *
     * @return the 调研描述
     */
    public java.lang.String getDescription() {
        return description;
    }

    /**
     * <p>调研描述。</p>
     *
     * @param description 调研描述。
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
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

    /**
     * <p>是否已调研。</p>
     *
     * @return the 是否已调研
     */
    public java.lang.String getIsResearch() {
        return isResearch;
    }

    /**
     * <p>是否已调研。</p>
     *
     * @param isResearch 是否已调研。
     */
    public void setIsResearch(java.lang.String isResearch) {
        this.isResearch = isResearch;
    }

}
