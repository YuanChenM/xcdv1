/*
 * 2017/04/17 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.msk.pl.bean;


import com.msk.core.bean.BaseBean;

/**
 * <p>表pl_pd_mst对应的实体PlPdMst</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class PlPdMst  extends BaseBean {

    /** 产品ID */
    private Long pdId;
    /** 一级分类code */
    private String classesCode;
    /** 一级分类名称 */
    private String classesName;
    /** 二级分类code */
    private String machiningCode;
    /** 二级分类名称 */
    private String machiningName;
    /** 品种code */
    private String breedCode;
    /** 品种名称 */
    private String breedName;
    /** 特征code */
    private String featureCode;
    /** 特征名称 */
    private String featureName;
    /** 净重code */
    private String weightCode;
    /** 净重名称 */
    private String weightName;
    /** 等级code */
    private String gradeCode;
    /** 等级名称 */
    private String gradeName;
    /** 品牌code */
    private String brandCode;
    /** 品牌名称 */
    private String brandName;
    /** 产品code */
    private String pdCode;
    /** 产品名称 */
    private String pdName;
    /** SKU code */
    private String skuCode;
    /** sku名称 */
    private String skuName;
    /** COMMODITY_CODE */
    private String commodityCode;
    /** COMMODITY_NAME */
    private String commodityName;
    /** 产品需求等级code */
    private String needsGradeCode;
    /** 产品需求等级名称 */
    private String needsGradeName;
    /** 小包装特征 */
    private String smallPackFeature;
    /** 小包装件数 */
    private String smallPackNumber;
    /** 净重kg */
    private java.math.BigDecimal netweight;
    /** 毛重kg */
    private java.math.BigDecimal grossweight;
    /** 纸箱尺寸 */
    private String cartonSize;
    /** 产品等级 */
    private String pdGrade;
    /** 托盘堆码数 */
    private String palletNumber;
    /** 产品来源 */
    private String pdOrigin;
    /** 单位 */
    private String pdUom;
    /** 上架状态 */
    private String onShelfStatus;
    /** 供应商名称 */
    private String supplierName;
    /** 生产商名称 */
    private String manufactureName;
    /** 制造商名称 */
    private String factoryName;
    /** 代理商名称 */
    private String oemName;
    /** 是否有效 */
    private String validFlg;
    /** 版本号 */
    private Integer ver;

    /**
     * <p>默认构造函数</p>
     */
    public PlPdMst() {
    }

    /**
     * <p>产品ID</p>
     *
     * @return 产品ID
     */
    public Long getPdId() {
        return pdId;
    }

    /**
     * <p>产品ID</p>
     *
     * @param pdId 产品ID
     */
    public void setPdId(Long pdId) {
        this.pdId = pdId;
    }
    /**
     * <p>一级分类code</p>
     *
     * @return 一级分类code
     */
    public String getClassesCode() {
        return classesCode;
    }

    /**
     * <p>一级分类code</p>
     *
     * @param classesCode 一级分类code
     */
    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }
    /**
     * <p>一级分类名称</p>
     *
     * @return 一级分类名称
     */
    public String getClassesName() {
        return classesName;
    }

    /**
     * <p>一级分类名称</p>
     *
     * @param classesName 一级分类名称
     */
    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }
    /**
     * <p>二级分类code</p>
     *
     * @return 二级分类code
     */
    public String getMachiningCode() {
        return machiningCode;
    }

    /**
     * <p>二级分类code</p>
     *
     * @param machiningCode 二级分类code
     */
    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }
    /**
     * <p>二级分类名称</p>
     *
     * @return 二级分类名称
     */
    public String getMachiningName() {
        return machiningName;
    }

    /**
     * <p>二级分类名称</p>
     *
     * @param machiningName 二级分类名称
     */
    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }
    /**
     * <p>品种code</p>
     *
     * @return 品种code
     */
    public String getBreedCode() {
        return breedCode;
    }

    /**
     * <p>品种code</p>
     *
     * @param breedCode 品种code
     */
    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }
    /**
     * <p>品种名称</p>
     *
     * @return 品种名称
     */
    public String getBreedName() {
        return breedName;
    }

    /**
     * <p>品种名称</p>
     *
     * @param breedName 品种名称
     */
    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }
    /**
     * <p>特征code</p>
     *
     * @return 特征code
     */
    public String getFeatureCode() {
        return featureCode;
    }

    /**
     * <p>特征code</p>
     *
     * @param featureCode 特征code
     */
    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }
    /**
     * <p>特征名称</p>
     *
     * @return 特征名称
     */
    public String getFeatureName() {
        return featureName;
    }

    /**
     * <p>特征名称</p>
     *
     * @param featureName 特征名称
     */
    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }
    /**
     * <p>净重code</p>
     *
     * @return 净重code
     */
    public String getWeightCode() {
        return weightCode;
    }

    /**
     * <p>净重code</p>
     *
     * @param weightCode 净重code
     */
    public void setWeightCode(String weightCode) {
        this.weightCode = weightCode;
    }
    /**
     * <p>净重名称</p>
     *
     * @return 净重名称
     */
    public String getWeightName() {
        return weightName;
    }

    /**
     * <p>净重名称</p>
     *
     * @param weightName 净重名称
     */
    public void setWeightName(String weightName) {
        this.weightName = weightName;
    }
    /**
     * <p>等级code</p>
     *
     * @return 等级code
     */
    public String getGradeCode() {
        return gradeCode;
    }

    /**
     * <p>等级code</p>
     *
     * @param gradeCode 等级code
     */
    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }
    /**
     * <p>等级名称</p>
     *
     * @return 等级名称
     */
    public String getGradeName() {
        return gradeName;
    }

    /**
     * <p>等级名称</p>
     *
     * @param gradeName 等级名称
     */
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
    /**
     * <p>品牌code</p>
     *
     * @return 品牌code
     */
    public String getBrandCode() {
        return brandCode;
    }

    /**
     * <p>品牌code</p>
     *
     * @param brandCode 品牌code
     */
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }
    /**
     * <p>品牌名称</p>
     *
     * @return 品牌名称
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * <p>品牌名称</p>
     *
     * @param brandName 品牌名称
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    /**
     * <p>产品code</p>
     *
     * @return 产品code
     */
    public String getPdCode() {
        return pdCode;
    }

    /**
     * <p>产品code</p>
     *
     * @param pdCode 产品code
     */
    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }
    /**
     * <p>产品名称</p>
     *
     * @return 产品名称
     */
    public String getPdName() {
        return pdName;
    }

    /**
     * <p>产品名称</p>
     *
     * @param pdName 产品名称
     */
    public void setPdName(String pdName) {
        this.pdName = pdName;
    }
    /**
     * <p>SKU code</p>
     *
     * @return SKU code
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * <p>SKU code</p>
     *
     * @param skuCode SKU code
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
    /**
     * <p>sku名称</p>
     *
     * @return sku名称
     */
    public String getSkuName() {
        return skuName;
    }

    /**
     * <p>sku名称</p>
     *
     * @param skuName sku名称
     */
    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }
    /**
     * <p>COMMODITY_CODE</p>
     *
     * @return COMMODITY_CODE
     */
    public java.lang.String getCommodityCode() {
        return commodityCode;
    }

    /**
     * <p>COMMODITY_CODE</p>
     *
     * @param commodityCode COMMODITY_CODE
     */
    public void setCommodityCode(java.lang.String commodityCode) {
        this.commodityCode = commodityCode;
    }
    /**
     * <p>COMMODITY_NAME</p>
     *
     * @return COMMODITY_NAME
     */
    public java.lang.String getCommodityName() {
        return commodityName;
    }

    /**
     * <p>COMMODITY_NAME</p>
     *
     * @param commodityName COMMODITY_NAME
     */
    public void setCommodityName(java.lang.String commodityName) {
        this.commodityName = commodityName;
    }
    /**
     * <p>产品需求等级code</p>
     *
     * @return 产品需求等级code
     */
    public String getNeedsGradeCode() {
        return needsGradeCode;
    }

    /**
     * <p>产品需求等级code</p>
     *
     * @param needsGradeCode 产品需求等级code
     */
    public void setNeedsGradeCode(String needsGradeCode) {
        this.needsGradeCode = needsGradeCode;
    }
    /**
     * <p>产品需求等级名称</p>
     *
     * @return 产品需求等级名称
     */
    public String getNeedsGradeName() {
        return needsGradeName;
    }

    /**
     * <p>产品需求等级名称</p>
     *
     * @param needsGradeName 产品需求等级名称
     */
    public void setNeedsGradeName(String needsGradeName) {
        this.needsGradeName = needsGradeName;
    }
    /**
     * <p>小包装特征</p>
     *
     * @return 小包装特征
     */
    public String getSmallPackFeature() {
        return smallPackFeature;
    }

    /**
     * <p>小包装特征</p>
     *
     * @param smallPackFeature 小包装特征
     */
    public void setSmallPackFeature(String smallPackFeature) {
        this.smallPackFeature = smallPackFeature;
    }
    /**
     * <p>小包装件数</p>
     *
     * @return 小包装件数
     */
    public String getSmallPackNumber() {
        return smallPackNumber;
    }

    /**
     * <p>小包装件数</p>
     *
     * @param smallPackNumber 小包装件数
     */
    public void setSmallPackNumber(String smallPackNumber) {
        this.smallPackNumber = smallPackNumber;
    }
    /**
     * <p>净重kg</p>
     *
     * @return 净重kg
     */
    public java.math.BigDecimal getNetweight() {
        return netweight;
    }

    /**
     * <p>净重kg</p>
     *
     * @param netweight 净重kg
     */
    public void setNetweight(java.math.BigDecimal netweight) {
        this.netweight = netweight;
    }
    /**
     * <p>毛重kg</p>
     *
     * @return 毛重kg
     */
    public java.math.BigDecimal getGrossweight() {
        return grossweight;
    }

    /**
     * <p>毛重kg</p>
     *
     * @param grossweight 毛重kg
     */
    public void setGrossweight(java.math.BigDecimal grossweight) {
        this.grossweight = grossweight;
    }
    /**
     * <p>纸箱尺寸</p>
     *
     * @return 纸箱尺寸
     */
    public String getCartonSize() {
        return cartonSize;
    }

    /**
     * <p>纸箱尺寸</p>
     *
     * @param cartonSize 纸箱尺寸
     */
    public void setCartonSize(String cartonSize) {
        this.cartonSize = cartonSize;
    }
    /**
     * <p>产品等级</p>
     *
     * @return 产品等级
     */
    public String getPdGrade() {
        return pdGrade;
    }

    /**
     * <p>产品等级</p>
     *
     * @param pdGrade 产品等级
     */
    public void setPdGrade(String pdGrade) {
        this.pdGrade = pdGrade;
    }
    /**
     * <p>托盘堆码数</p>
     *
     * @return 托盘堆码数
     */
    public String getPalletNumber() {
        return palletNumber;
    }

    /**
     * <p>托盘堆码数</p>
     *
     * @param palletNumber 托盘堆码数
     */
    public void setPalletNumber(String palletNumber) {
        this.palletNumber = palletNumber;
    }
    /**
     * <p>产品来源</p>
     *
     * @return 产品来源
     */
    public String getPdOrigin() {
        return pdOrigin;
    }

    /**
     * <p>产品来源</p>
     *
     * @param pdOrigin 产品来源
     */
    public void setPdOrigin(String pdOrigin) {
        this.pdOrigin = pdOrigin;
    }
    /**
     * <p>单位</p>
     *
     * @return 单位
     */
    public String getPdUom() {
        return pdUom;
    }

    /**
     * <p>单位</p>
     *
     * @param pdUom 单位
     */
    public void setPdUom(String pdUom) {
        this.pdUom = pdUom;
    }
    /**
     * <p>上架状态</p>
     *
     * @return 上架状态
     */
    public String getOnShelfStatus() {
        return onShelfStatus;
    }

    /**
     * <p>上架状态</p>
     *
     * @param onShelfStatus 上架状态
     */
    public void setOnShelfStatus(String onShelfStatus) {
        this.onShelfStatus = onShelfStatus;
    }
    /**
     * <p>供应商名称</p>
     *
     * @return 供应商名称
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * <p>供应商名称</p>
     *
     * @param supplierName 供应商名称
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    /**
     * <p>生产商名称</p>
     *
     * @return 生产商名称
     */
    public String getManufactureName() {
        return manufactureName;
    }

    /**
     * <p>生产商名称</p>
     *
     * @param manufactureName 生产商名称
     */
    public void setManufactureName(String manufactureName) {
        this.manufactureName = manufactureName;
    }
    /**
     * <p>制造商名称</p>
     *
     * @return 制造商名称
     */
    public String getFactoryName() {
        return factoryName;
    }

    /**
     * <p>制造商名称</p>
     *
     * @param factoryName 制造商名称
     */
    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }
    /**
     * <p>代理商名称</p>
     *
     * @return 代理商名称
     */
    public String getOemName() {
        return oemName;
    }

    /**
     * <p>代理商名称</p>
     *
     * @param oemName 代理商名称
     */
    public void setOemName(String oemName) {
        this.oemName = oemName;
    }
    /**
     * <p>是否有效</p>
     *
     * @return 是否有效
     */
    public String getValidFlg() {
        return validFlg;
    }

    /**
     * <p>是否有效</p>
     *
     * @param validFlg 是否有效
     */
    public void setValidFlg(String validFlg) {
        this.validFlg = validFlg;
    }
    /**
     * <p>版本号</p>
     *
     * @return 版本号
     */
    public Integer getVer() {
        return ver;
    }

    /**
     * <p>版本号</p>
     *
     * @param ver 版本号
     */
    public void setVer(Integer ver) {
        this.ver = ver;
    }

}
