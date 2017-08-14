/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_pd_artno对应的SlPdArtno�?</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlPdArtno extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 表管理ID */
    private Long artnoId;
    /** 对应卖家表的SL_CODE */
    private String slCode;
    /** 5位顺�? */
    private String slPdArtno;
    /** 7位，分类�?1+区划�?3+顺番�?3 */
    private String slCodeDis;
    /** 2�? */
    private String classesCode;
    /** 保存1�? */
    private String machiningCode;
    /** 2�? */
    private String breedCode;
    /** 2�? */
    private String featureCode;
    /** 2�? */
    private String weightCode;
    /** 保存2�? */
    private String normsCode;
    /** 保存1�? */
    private String gradeCode;
    /** 1：神农客�?2美侍�? */
    private String salePlatform;
    /** 品牌商ID */
    private String brandEpId;
    /** 品牌ID */
    private String brandId;
    /** 生成商编�? */
    private String manufactureCode;
    /** 字段预留,当前无此概念 */
    private String factoryCode;
    /** 保存2�? */
    private String saleRegionCode;
    /** 1 申请�? 2论证�? 3禁止准入 4试销 5正式上线 6下线  7黑名�? 8:缺货�? */
    private String saleStatus;
    /** 国别 */
    private String pdCountry;
    /** 产地 */
    private String pdPlace;
    /** 预留,卖家自己输入 */
    private String pdStandard;
    /** 预留 */
    private String pdIngredient;
    /** 预留 */
    private String foodLicense;
    /** 预留 */
    private String shelfLife;
    /** 预留 */
    private String storageCondition;
    /** 预留 */
    private String normsSpecification;
    /**
     * <p>默认构�?�函数�??</p>
     */
    public SlPdArtno() {

    }

    /**
     * <p>表管理ID�?</p>
     *
     * @return the 表管理ID
     */
    public Long getArtnoId() {
        return artnoId;
    }

    /**
     * <p>表管理ID�?</p>
     *
     * @param artnoId 表管理ID�?
     */
    public void setArtnoId(Long artnoId) {
        this.artnoId = artnoId;
    }

    /**
     * <p>对应卖家表的SL_CODE�?</p>
     *
     * @return the 对应卖家表的SL_CODE
     */
    public String getSlCode() {
        return slCode;
    }

    /**
     * <p>对应卖家表的SL_CODE�?</p>
     *
     * @param slCode 对应卖家表的SL_CODE�?
     */
    public void setSlCode(String slCode) {
        this.slCode = slCode;
    }

    /**
     * <p>5位顺番�??</p>
     *
     * @return the 5位顺�?
     */
    public String getSlPdArtno() {
        return slPdArtno;
    }

    /**
     * <p>5位顺番�??</p>
     *
     * @param slPdArtno 5位顺番�??
     */
    public void setSlPdArtno(String slPdArtno) {
        this.slPdArtno = slPdArtno;
    }

    /**
     * <p>7位，分类�?1+区划�?3+顺番�?3�?</p>
     *
     * @return the 7位，分类�?1+区划�?3+顺番�?3
     */
    public String getSlCodeDis() {
        return slCodeDis;
    }

    /**
     * <p>7位，分类�?1+区划�?3+顺番�?3�?</p>
     *
     * @param slCodeDis 7位，分类�?1+区划�?3+顺番�?3�?
     */
    public void setSlCodeDis(String slCodeDis) {
        this.slCodeDis = slCodeDis;
    }

    /**
     * <p>2位�??</p>
     *
     * @return the 2�?
     */
    public String getClassesCode() {
        return classesCode;
    }

    /**
     * <p>2位�??</p>
     *
     * @param classesCode 2位�??
     */
    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    /**
     * <p>保存1位�??</p>
     *
     * @return the 保存1�?
     */
    public String getMachiningCode() {
        return machiningCode;
    }

    /**
     * <p>保存1位�??</p>
     *
     * @param machiningCode 保存1位�??
     */
    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }

    /**
     * <p>2位�??</p>
     *
     * @return the 2�?
     */
    public String getBreedCode() {
        return breedCode;
    }

    /**
     * <p>2位�??</p>
     *
     * @param breedCode 2位�??
     */
    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    /**
     * <p>2位�??</p>
     *
     * @return the 2�?
     */
    public String getFeatureCode() {
        return featureCode;
    }

    /**
     * <p>2位�??</p>
     *
     * @param featureCode 2位�??
     */
    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    /**
     * <p>2位�??</p>
     *
     * @return the 2�?
     */
    public String getWeightCode() {
        return weightCode;
    }

    /**
     * <p>2位�??</p>
     *
     * @param weightCode 2位�??
     */
    public void setWeightCode(String weightCode) {
        this.weightCode = weightCode;
    }

    /**
     * <p>保存2位�??</p>
     *
     * @return the 保存2�?
     */
    public String getNormsCode() {
        return normsCode;
    }

    /**
     * <p>保存2位�??</p>
     *
     * @param normsCode 保存2位�??
     */
    public void setNormsCode(String normsCode) {
        this.normsCode = normsCode;
    }

    /**
     * <p>保存1位�??</p>
     *
     * @return the 保存1�?
     */
    public String getGradeCode() {
        return gradeCode;
    }

    /**
     * <p>保存1位�??</p>
     *
     * @param gradeCode 保存1位�??
     */
    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    /**
     * <p>1：神农客�?2美侍客�??</p>
     *
     * @return the 1：神农客�?2美侍�?
     */
    public String getSalePlatform() {
        return salePlatform;
    }

    /**
     * <p>1：神农客�?2美侍客�??</p>
     *
     * @param salePlatform 1：神农客�?2美侍客�??
     */
    public void setSalePlatform(String salePlatform) {
        this.salePlatform = salePlatform;
    }

    /**
     * <p>品牌商ID�?</p>
     *
     * @return the 品牌商ID
     */
    public String getBrandEpId() {
        return brandEpId;
    }

    /**
     * <p>品牌商ID�?</p>
     *
     * @param brandEpId 品牌商ID�?
     */
    public void setBrandEpId(String brandEpId) {
        this.brandEpId = brandEpId;
    }

    /**
     * <p>品牌ID�?</p>
     *
     * @return the 品牌ID
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * <p>品牌ID�?</p>
     *
     * @param brandId 品牌ID�?
     */
    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    /**
     * <p>生成商编码�??</p>
     *
     * @return the 生成商编�?
     */
    public String getManufactureCode() {
        return manufactureCode;
    }

    /**
     * <p>生成商编码�??</p>
     *
     * @param manufactureCode 生成商编码�??
     */
    public void setManufactureCode(String manufactureCode) {
        this.manufactureCode = manufactureCode;
    }

    /**
     * <p>字段预留,当前无此概念�?</p>
     *
     * @return the 字段预留,当前无此概念
     */
    public String getFactoryCode() {
        return factoryCode;
    }

    /**
     * <p>字段预留,当前无此概念�?</p>
     *
     * @param factoryCode 字段预留,当前无此概念�?
     */
    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
    }

    /**
     * <p>保存2位�??</p>
     *
     * @return the 保存2�?
     */
    public String getSaleRegionCode() {
        return saleRegionCode;
    }

    /**
     * <p>保存2位�??</p>
     *
     * @param saleRegionCode 保存2位�??
     */
    public void setSaleRegionCode(String saleRegionCode) {
        this.saleRegionCode = saleRegionCode;
    }

    /**
     * <p>1 申请�? 2论证�? 3禁止准入 4试销 5正式上线 6下线  7黑名�? 8:缺货中�??</p>
     *
     * @return the 1 申请�? 2论证�? 3禁止准入 4试销 5正式上线 6下线  7黑名�? 8:缺货�?
     */
    public String getSaleStatus() {
        return saleStatus;
    }

    /**
     * <p>1 申请�? 2论证�? 3禁止准入 4试销 5正式上线 6下线  7黑名�? 8:缺货中�??</p>
     *
     * @param saleStatus 1 申请�? 2论证�? 3禁止准入 4试销 5正式上线 6下线  7黑名�? 8:缺货中�??
     */
    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    /**
     * <p>国别�?</p>
     *
     * @return the 国别
     */
    public String getPdCountry() {
        return pdCountry;
    }

    /**
     * <p>国别�?</p>
     *
     * @param pdCountry 国别�?
     */
    public void setPdCountry(String pdCountry) {
        this.pdCountry = pdCountry;
    }

    /**
     * <p>产地�?</p>
     *
     * @return the 产地
     */
    public String getPdPlace() {
        return pdPlace;
    }

    /**
     * <p>产地�?</p>
     *
     * @param pdPlace 产地�?
     */
    public void setPdPlace(String pdPlace) {
        this.pdPlace = pdPlace;
    }

    /**
     * <p>预留,卖家自己输入�?</p>
     *
     * @return the 预留,卖家自己输入
     */
    public String getPdStandard() {
        return pdStandard;
    }

    /**
     * <p>预留,卖家自己输入�?</p>
     *
     * @param pdStandard 预留,卖家自己输入�?
     */
    public void setPdStandard(String pdStandard) {
        this.pdStandard = pdStandard;
    }

    /**
     * <p>预留�?</p>
     *
     * @return the 预留
     */
    public String getPdIngredient() {
        return pdIngredient;
    }

    /**
     * <p>预留�?</p>
     *
     * @param pdIngredient 预留�?
     */
    public void setPdIngredient(String pdIngredient) {
        this.pdIngredient = pdIngredient;
    }

    /**
     * <p>预留�?</p>
     *
     * @return the 预留
     */
    public String getFoodLicense() {
        return foodLicense;
    }

    /**
     * <p>预留�?</p>
     *
     * @param foodLicense 预留�?
     */
    public void setFoodLicense(String foodLicense) {
        this.foodLicense = foodLicense;
    }

    /**
     * <p>预留�?</p>
     *
     * @return the 预留
     */
    public String getShelfLife() {
        return shelfLife;
    }

    /**
     * <p>预留�?</p>
     *
     * @param shelfLife 预留�?
     */
    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    /**
     * <p>预留�?</p>
     *
     * @return the 预留
     */
    public String getStorageCondition() {
        return storageCondition;
    }

    /**
     * <p>预留�?</p>
     *
     * @param storageCondition 预留�?
     */
    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }

    /**
     * <p>预留�?</p>
     *
     * @return the 预留
     */
    public String getNormsSpecification() {
        return normsSpecification;
    }

    /**
     * <p>预留�?</p>
     *
     * @param normsSpecification 预留�?
     */
    public void setNormsSpecification(String normsSpecification) {
        this.normsSpecification = normsSpecification;
    }

}
