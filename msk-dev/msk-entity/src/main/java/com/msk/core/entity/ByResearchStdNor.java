/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表by_research_std_nor对应的ByResearchStdNor。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class ByResearchStdNor extends BaseEntity{
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
    /** 包装规格编码 */
    private java.lang.String normsCode;
    /** 单个产品净重 */
    private java.lang.String normsSuttle;
    /** 单个产品规格净重误差范围 */
    private java.lang.String normsError;
    /** 内包装净重/个数 */
    private java.lang.String normsNumber;
    /** 内包装尺寸 */
    private java.lang.String normsSize;
    /** 内包装材质及技术标准 */
    private java.lang.String normsTexture;
    /** 外包装规格 */
    private java.lang.String normsOut;
    /** 外包装净重/毛重 */
    private java.lang.String normsKg;
    /** 外包装尺寸 */
    private java.lang.String normsOutSize;
    /** 外包装材质及技术标准 */
    private java.lang.String normsOutTexture;
    /** 单个产品净重调研值 */
    private java.lang.String normsSuttleR;
    /** 单个产品规格净重误差范围调研值 */
    private java.lang.String normsErrorR;
    /** 内包装净重/个数调研值 */
    private java.lang.String normsNumberR;
    /** 内包装尺寸调研值 */
    private java.lang.String normsSizeR;
    /** 内包装材质及技术标准调研值 */
    private java.lang.String normsTextureR;
    /** 外包装规格调研值 */
    private java.lang.String normsOutR;
    /** 外包装净重/毛重调研值 */
    private java.lang.String normsKgR;
    /** 外包装尺寸调研值 */
    private java.lang.String normsOutSizeR;
    /** 外包装材质及技术标准调研值 */
    private java.lang.String normsOutTextureR;
    /** 是否已调研 */
    private java.lang.String isResearch;
    /**
     * <p>默认构造函数。</p>
     */
    public ByResearchStdNor() {

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
     * <p>包装规格编码。</p>
     *
     * @return the 包装规格编码
     */
    public java.lang.String getNormsCode() {
        return normsCode;
    }

    /**
     * <p>包装规格编码。</p>
     *
     * @param normsCode 包装规格编码。
     */
    public void setNormsCode(java.lang.String normsCode) {
        this.normsCode = normsCode;
    }

    /**
     * <p>单个产品净重。</p>
     *
     * @return the 单个产品净重
     */
    public java.lang.String getNormsSuttle() {
        return normsSuttle;
    }

    /**
     * <p>单个产品净重。</p>
     *
     * @param normsSuttle 单个产品净重。
     */
    public void setNormsSuttle(java.lang.String normsSuttle) {
        this.normsSuttle = normsSuttle;
    }

    /**
     * <p>单个产品规格净重误差范围。</p>
     *
     * @return the 单个产品规格净重误差范围
     */
    public java.lang.String getNormsError() {
        return normsError;
    }

    /**
     * <p>单个产品规格净重误差范围。</p>
     *
     * @param normsError 单个产品规格净重误差范围。
     */
    public void setNormsError(java.lang.String normsError) {
        this.normsError = normsError;
    }

    /**
     * <p>内包装净重/个数。</p>
     *
     * @return the 内包装净重/个数
     */
    public java.lang.String getNormsNumber() {
        return normsNumber;
    }

    /**
     * <p>内包装净重/个数。</p>
     *
     * @param normsNumber 内包装净重/个数。
     */
    public void setNormsNumber(java.lang.String normsNumber) {
        this.normsNumber = normsNumber;
    }

    /**
     * <p>内包装尺寸。</p>
     *
     * @return the 内包装尺寸
     */
    public java.lang.String getNormsSize() {
        return normsSize;
    }

    /**
     * <p>内包装尺寸。</p>
     *
     * @param normsSize 内包装尺寸。
     */
    public void setNormsSize(java.lang.String normsSize) {
        this.normsSize = normsSize;
    }

    /**
     * <p>内包装材质及技术标准。</p>
     *
     * @return the 内包装材质及技术标准
     */
    public java.lang.String getNormsTexture() {
        return normsTexture;
    }

    /**
     * <p>内包装材质及技术标准。</p>
     *
     * @param normsTexture 内包装材质及技术标准。
     */
    public void setNormsTexture(java.lang.String normsTexture) {
        this.normsTexture = normsTexture;
    }

    /**
     * <p>外包装规格。</p>
     *
     * @return the 外包装规格
     */
    public java.lang.String getNormsOut() {
        return normsOut;
    }

    /**
     * <p>外包装规格。</p>
     *
     * @param normsOut 外包装规格。
     */
    public void setNormsOut(java.lang.String normsOut) {
        this.normsOut = normsOut;
    }

    /**
     * <p>外包装净重/毛重。</p>
     *
     * @return the 外包装净重/毛重
     */
    public java.lang.String getNormsKg() {
        return normsKg;
    }

    /**
     * <p>外包装净重/毛重。</p>
     *
     * @param normsKg 外包装净重/毛重。
     */
    public void setNormsKg(java.lang.String normsKg) {
        this.normsKg = normsKg;
    }

    /**
     * <p>外包装尺寸。</p>
     *
     * @return the 外包装尺寸
     */
    public java.lang.String getNormsOutSize() {
        return normsOutSize;
    }

    /**
     * <p>外包装尺寸。</p>
     *
     * @param normsOutSize 外包装尺寸。
     */
    public void setNormsOutSize(java.lang.String normsOutSize) {
        this.normsOutSize = normsOutSize;
    }

    /**
     * <p>外包装材质及技术标准。</p>
     *
     * @return the 外包装材质及技术标准
     */
    public java.lang.String getNormsOutTexture() {
        return normsOutTexture;
    }

    /**
     * <p>外包装材质及技术标准。</p>
     *
     * @param normsOutTexture 外包装材质及技术标准。
     */
    public void setNormsOutTexture(java.lang.String normsOutTexture) {
        this.normsOutTexture = normsOutTexture;
    }

    /**
     * <p>单个产品净重调研值。</p>
     *
     * @return the 单个产品净重调研值
     */
    public java.lang.String getNormsSuttleR() {
        return normsSuttleR;
    }

    /**
     * <p>单个产品净重调研值。</p>
     *
     * @param normsSuttleR 单个产品净重调研值。
     */
    public void setNormsSuttleR(java.lang.String normsSuttleR) {
        this.normsSuttleR = normsSuttleR;
    }

    /**
     * <p>单个产品规格净重误差范围调研值。</p>
     *
     * @return the 单个产品规格净重误差范围调研值
     */
    public java.lang.String getNormsErrorR() {
        return normsErrorR;
    }

    /**
     * <p>单个产品规格净重误差范围调研值。</p>
     *
     * @param normsErrorR 单个产品规格净重误差范围调研值。
     */
    public void setNormsErrorR(java.lang.String normsErrorR) {
        this.normsErrorR = normsErrorR;
    }

    /**
     * <p>内包装净重/个数调研值。</p>
     *
     * @return the 内包装净重/个数调研值
     */
    public java.lang.String getNormsNumberR() {
        return normsNumberR;
    }

    /**
     * <p>内包装净重/个数调研值。</p>
     *
     * @param normsNumberR 内包装净重/个数调研值。
     */
    public void setNormsNumberR(java.lang.String normsNumberR) {
        this.normsNumberR = normsNumberR;
    }

    /**
     * <p>内包装尺寸调研值。</p>
     *
     * @return the 内包装尺寸调研值
     */
    public java.lang.String getNormsSizeR() {
        return normsSizeR;
    }

    /**
     * <p>内包装尺寸调研值。</p>
     *
     * @param normsSizeR 内包装尺寸调研值。
     */
    public void setNormsSizeR(java.lang.String normsSizeR) {
        this.normsSizeR = normsSizeR;
    }

    /**
     * <p>内包装材质及技术标准调研值。</p>
     *
     * @return the 内包装材质及技术标准调研值
     */
    public java.lang.String getNormsTextureR() {
        return normsTextureR;
    }

    /**
     * <p>内包装材质及技术标准调研值。</p>
     *
     * @param normsTextureR 内包装材质及技术标准调研值。
     */
    public void setNormsTextureR(java.lang.String normsTextureR) {
        this.normsTextureR = normsTextureR;
    }

    /**
     * <p>外包装规格调研值。</p>
     *
     * @return the 外包装规格调研值
     */
    public java.lang.String getNormsOutR() {
        return normsOutR;
    }

    /**
     * <p>外包装规格调研值。</p>
     *
     * @param normsOutR 外包装规格调研值。
     */
    public void setNormsOutR(java.lang.String normsOutR) {
        this.normsOutR = normsOutR;
    }

    /**
     * <p>外包装净重/毛重调研值。</p>
     *
     * @return the 外包装净重/毛重调研值
     */
    public java.lang.String getNormsKgR() {
        return normsKgR;
    }

    /**
     * <p>外包装净重/毛重调研值。</p>
     *
     * @param normsKgR 外包装净重/毛重调研值。
     */
    public void setNormsKgR(java.lang.String normsKgR) {
        this.normsKgR = normsKgR;
    }

    /**
     * <p>外包装尺寸调研值。</p>
     *
     * @return the 外包装尺寸调研值
     */
    public java.lang.String getNormsOutSizeR() {
        return normsOutSizeR;
    }

    /**
     * <p>外包装尺寸调研值。</p>
     *
     * @param normsOutSizeR 外包装尺寸调研值。
     */
    public void setNormsOutSizeR(java.lang.String normsOutSizeR) {
        this.normsOutSizeR = normsOutSizeR;
    }

    /**
     * <p>外包装材质及技术标准调研值。</p>
     *
     * @return the 外包装材质及技术标准调研值
     */
    public java.lang.String getNormsOutTextureR() {
        return normsOutTextureR;
    }

    /**
     * <p>外包装材质及技术标准调研值。</p>
     *
     * @param normsOutTextureR 外包装材质及技术标准调研值。
     */
    public void setNormsOutTextureR(java.lang.String normsOutTextureR) {
        this.normsOutTextureR = normsOutTextureR;
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
