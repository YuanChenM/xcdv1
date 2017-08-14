/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表ds_sl_pd_lot对应的DsSlPdLot�?</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class DsSlPdLot extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 批次ID */
    private Long lotId;
    /** 产品类别01~99 */
    private String classesCode;
    /** 产品二级分类编码 */
    private String machiningCode;
    /** 产品品种01~99 */
    private String breedCode;
    /** 产品特征01~99 */
    private String featureCode;
    /** �?重编�? */
    private String weightCode;
    /** 2位自动翻番包装规格，01�?99，等同NORMS_CODE */
    private String pkgCode;
    /** 1：A1�?2：A2�?3：A3 */
    private String gradeCode;
    /** 10位卖家编号，�?5位地区编号，后两�?00001�?始翻�? */
    private String slCode;
    /** 卖家显示编码 */
    private String slCodeDis;
    /** SL_CODE_MANUFACTURE */
    private String slCodeManufacture;
    /** �?售平台，1：神农客（云冻品）；2：美侍客（云冻品B2B�? */
    private Integer salesPlatform;
    /** �?�?地的物流区编号，2位大区编�? */
    private String lgcsCode;
    /** 2位年份，2位月份，1位半旬号 */
    private String dateCode;
    /** 产品编码 */
    private String pdCode;
    /** 产品类别01~99 */
    private String classesName;
    /** 产品二级分类名称 */
    private String machiningName;
    /** 产品品种01~99 */
    private String breedName;
    /** 产品特征01~99 */
    private String featureName;
    /** 产品�?重名�? */
    private String weightName;
    /** 1：A1�?2：A2�?3：A3 */
    private String gradeName;
    /** 卖家名称 */
    private String slName;
    /** 物流区名�? */
    private String lgcsName;
    /** 产品名称 */
    private String pdName;
    /** 产品状�?? */
    private String pdStatus;
    /** 原产�? */
    private String origin;
    /** 产地 */
    private String prodcingarea;
    /** 厂家 */
    private String manufacturer;
    /** 品牌 */
    private String brand;
    /** �?�? */
    private String netweight;
    /** 包装规格 */
    private String pkgSpec;
    /** 包装方式 */
    private String pkgWay;
    /** 生产时间 */
    private String pdTime;
    /** 保质�? */
    private String shelfLife;
    /** 加工方式 */
    private String processingWay;
    /** 储存方式 */
    private String storageWay;
    /**
     * <p>默认构�?�函数�??</p>
     */
    public DsSlPdLot() {

    }

    /**
     * <p>批次ID�?</p>
     *
     * @return the 批次ID
     */
    public Long getLotId() {
        return lotId;
    }

    /**
     * <p>批次ID�?</p>
     *
     * @param lotId 批次ID�?
     */
    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    /**
     * <p>产品类别01~99�?</p>
     *
     * @return the 产品类别01~99
     */
    public String getClassesCode() {
        return classesCode;
    }

    /**
     * <p>产品类别01~99�?</p>
     *
     * @param classesCode 产品类别01~99�?
     */
    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    /**
     * <p>产品二级分类编码�?</p>
     *
     * @return the 产品二级分类编码
     */
    public String getMachiningCode() {
        return machiningCode;
    }

    /**
     * <p>产品二级分类编码�?</p>
     *
     * @param machiningCode 产品二级分类编码�?
     */
    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }

    /**
     * <p>产品品种01~99�?</p>
     *
     * @return the 产品品种01~99
     */
    public String getBreedCode() {
        return breedCode;
    }

    /**
     * <p>产品品种01~99�?</p>
     *
     * @param breedCode 产品品种01~99�?
     */
    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    /**
     * <p>产品特征01~99�?</p>
     *
     * @return the 产品特征01~99
     */
    public String getFeatureCode() {
        return featureCode;
    }

    /**
     * <p>产品特征01~99�?</p>
     *
     * @param featureCode 产品特征01~99�?
     */
    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    /**
     * <p>�?重编码�??</p>
     *
     * @return the �?重编�?
     */
    public String getWeightCode() {
        return weightCode;
    }

    /**
     * <p>�?重编码�??</p>
     *
     * @param weightCode �?重编码�??
     */
    public void setWeightCode(String weightCode) {
        this.weightCode = weightCode;
    }

    /**
     * <p>2位自动翻番包装规格，01�?99，等同NORMS_CODE�?</p>
     *
     * @return the 2位自动翻番包装规格，01�?99，等同NORMS_CODE
     */
    public String getPkgCode() {
        return pkgCode;
    }

    /**
     * <p>2位自动翻番包装规格，01�?99，等同NORMS_CODE�?</p>
     *
     * @param pkgCode 2位自动翻番包装规格，01�?99，等同NORMS_CODE�?
     */
    public void setPkgCode(String pkgCode) {
        this.pkgCode = pkgCode;
    }

    /**
     * <p>1：A1�?2：A2�?3：A3�?</p>
     *
     * @return the 1：A1�?2：A2�?3：A3
     */
    public String getGradeCode() {
        return gradeCode;
    }

    /**
     * <p>1：A1�?2：A2�?3：A3�?</p>
     *
     * @param gradeCode 1：A1�?2：A2�?3：A3�?
     */
    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    /**
     * <p>10位卖家编号，�?5位地区编号，后两�?00001�?始翻番�??</p>
     *
     * @return the 10位卖家编号，�?5位地区编号，后两�?00001�?始翻�?
     */
    public String getSlCode() {
        return slCode;
    }

    /**
     * <p>10位卖家编号，�?5位地区编号，后两�?00001�?始翻番�??</p>
     *
     * @param slCode 10位卖家编号，�?5位地区编号，后两�?00001�?始翻番�??
     */
    public void setSlCode(String slCode) {
        this.slCode = slCode;
    }

    /**
     * <p>卖家显示编码�?</p>
     *
     * @return the 卖家显示编码
     */
    public String getSlCodeDis() {
        return slCodeDis;
    }

    /**
     * <p>卖家显示编码�?</p>
     *
     * @param slCodeDis 卖家显示编码�?
     */
    public void setSlCodeDis(String slCodeDis) {
        this.slCodeDis = slCodeDis;
    }

    /**
     * <p>SL_CODE_MANUFACTURE�?</p>
     *
     * @return the SL_CODE_MANUFACTURE
     */
    public String getSlCodeManufacture() {
        return slCodeManufacture;
    }

    /**
     * <p>SL_CODE_MANUFACTURE�?</p>
     *
     * @param slCodeManufacture SL_CODE_MANUFACTURE�?
     */
    public void setSlCodeManufacture(String slCodeManufacture) {
        this.slCodeManufacture = slCodeManufacture;
    }

    /**
     * <p>�?售平台，1：神农客（云冻品）；2：美侍客（云冻品B2B）�??</p>
     *
     * @return the �?售平台，1：神农客（云冻品）；2：美侍客（云冻品B2B�?
     */
    public Integer getSalesPlatform() {
        return salesPlatform;
    }

    /**
     * <p>�?售平台，1：神农客（云冻品）；2：美侍客（云冻品B2B）�??</p>
     *
     * @param salesPlatform �?售平台，1：神农客（云冻品）；2：美侍客（云冻品B2B）�??
     */
    public void setSalesPlatform(Integer salesPlatform) {
        this.salesPlatform = salesPlatform;
    }

    /**
     * <p>�?�?地的物流区编号，2位大区编号�??</p>
     *
     * @return the �?�?地的物流区编号，2位大区编�?
     */
    public String getLgcsCode() {
        return lgcsCode;
    }

    /**
     * <p>�?�?地的物流区编号，2位大区编号�??</p>
     *
     * @param lgcsCode �?�?地的物流区编号，2位大区编号�??
     */
    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    /**
     * <p>2位年份，2位月份，1位半旬号�?</p>
     *
     * @return the 2位年份，2位月份，1位半旬号
     */
    public String getDateCode() {
        return dateCode;
    }

    /**
     * <p>2位年份，2位月份，1位半旬号�?</p>
     *
     * @param dateCode 2位年份，2位月份，1位半旬号�?
     */
    public void setDateCode(String dateCode) {
        this.dateCode = dateCode;
    }

    /**
     * <p>产品编码�?</p>
     *
     * @return the 产品编码
     */
    public String getPdCode() {
        return pdCode;
    }

    /**
     * <p>产品编码�?</p>
     *
     * @param pdCode 产品编码�?
     */
    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    /**
     * <p>产品类别01~99�?</p>
     *
     * @return the 产品类别01~99
     */
    public String getClassesName() {
        return classesName;
    }

    /**
     * <p>产品类别01~99�?</p>
     *
     * @param classesName 产品类别01~99�?
     */
    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    /**
     * <p>产品二级分类名称�?</p>
     *
     * @return the 产品二级分类名称
     */
    public String getMachiningName() {
        return machiningName;
    }

    /**
     * <p>产品二级分类名称�?</p>
     *
     * @param machiningName 产品二级分类名称�?
     */
    public void setMachiningName(String machiningName) {
        this.machiningName = machiningName;
    }

    /**
     * <p>产品品种01~99�?</p>
     *
     * @return the 产品品种01~99
     */
    public String getBreedName() {
        return breedName;
    }

    /**
     * <p>产品品种01~99�?</p>
     *
     * @param breedName 产品品种01~99�?
     */
    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    /**
     * <p>产品特征01~99�?</p>
     *
     * @return the 产品特征01~99
     */
    public String getFeatureName() {
        return featureName;
    }

    /**
     * <p>产品特征01~99�?</p>
     *
     * @param featureName 产品特征01~99�?
     */
    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    /**
     * <p>产品�?重名称�??</p>
     *
     * @return the 产品�?重名�?
     */
    public String getWeightName() {
        return weightName;
    }

    /**
     * <p>产品�?重名称�??</p>
     *
     * @param weightName 产品�?重名称�??
     */
    public void setWeightName(String weightName) {
        this.weightName = weightName;
    }

    /**
     * <p>1：A1�?2：A2�?3：A3�?</p>
     *
     * @return the 1：A1�?2：A2�?3：A3
     */
    public String getGradeName() {
        return gradeName;
    }

    /**
     * <p>1：A1�?2：A2�?3：A3�?</p>
     *
     * @param gradeName 1：A1�?2：A2�?3：A3�?
     */
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    /**
     * <p>卖家名称�?</p>
     *
     * @return the 卖家名称
     */
    public String getSlName() {
        return slName;
    }

    /**
     * <p>卖家名称�?</p>
     *
     * @param slName 卖家名称�?
     */
    public void setSlName(String slName) {
        this.slName = slName;
    }

    /**
     * <p>物流区名称�??</p>
     *
     * @return the 物流区名�?
     */
    public String getLgcsName() {
        return lgcsName;
    }

    /**
     * <p>物流区名称�??</p>
     *
     * @param lgcsName 物流区名称�??
     */
    public void setLgcsName(String lgcsName) {
        this.lgcsName = lgcsName;
    }

    /**
     * <p>产品名称�?</p>
     *
     * @return the 产品名称
     */
    public String getPdName() {
        return pdName;
    }

    /**
     * <p>产品名称�?</p>
     *
     * @param pdName 产品名称�?
     */
    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    /**
     * <p>产品状�?��??</p>
     *
     * @return the 产品状�??
     */
    public String getPdStatus() {
        return pdStatus;
    }

    /**
     * <p>产品状�?��??</p>
     *
     * @param pdStatus 产品状�?��??
     */
    public void setPdStatus(String pdStatus) {
        this.pdStatus = pdStatus;
    }

    /**
     * <p>原产地�??</p>
     *
     * @return the 原产�?
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * <p>原产地�??</p>
     *
     * @param origin 原产地�??
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * <p>产地�?</p>
     *
     * @return the 产地
     */
    public String getProdcingarea() {
        return prodcingarea;
    }

    /**
     * <p>产地�?</p>
     *
     * @param prodcingarea 产地�?
     */
    public void setProdcingarea(String prodcingarea) {
        this.prodcingarea = prodcingarea;
    }

    /**
     * <p>厂家�?</p>
     *
     * @return the 厂家
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * <p>厂家�?</p>
     *
     * @param manufacturer 厂家�?
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * <p>品牌�?</p>
     *
     * @return the 品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * <p>品牌�?</p>
     *
     * @param brand 品牌�?
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * <p>�?重�??</p>
     *
     * @return the �?�?
     */
    public String getNetweight() {
        return netweight;
    }

    /**
     * <p>�?重�??</p>
     *
     * @param netweight �?重�??
     */
    public void setNetweight(String netweight) {
        this.netweight = netweight;
    }

    /**
     * <p>包装规格�?</p>
     *
     * @return the 包装规格
     */
    public String getPkgSpec() {
        return pkgSpec;
    }

    /**
     * <p>包装规格�?</p>
     *
     * @param pkgSpec 包装规格�?
     */
    public void setPkgSpec(String pkgSpec) {
        this.pkgSpec = pkgSpec;
    }

    /**
     * <p>包装方式�?</p>
     *
     * @return the 包装方式
     */
    public String getPkgWay() {
        return pkgWay;
    }

    /**
     * <p>包装方式�?</p>
     *
     * @param pkgWay 包装方式�?
     */
    public void setPkgWay(String pkgWay) {
        this.pkgWay = pkgWay;
    }

    /**
     * <p>生产时间�?</p>
     *
     * @return the 生产时间
     */
    public String getPdTime() {
        return pdTime;
    }

    /**
     * <p>生产时间�?</p>
     *
     * @param pdTime 生产时间�?
     */
    public void setPdTime(String pdTime) {
        this.pdTime = pdTime;
    }

    /**
     * <p>保质期�??</p>
     *
     * @return the 保质�?
     */
    public String getShelfLife() {
        return shelfLife;
    }

    /**
     * <p>保质期�??</p>
     *
     * @param shelfLife 保质期�??
     */
    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    /**
     * <p>加工方式�?</p>
     *
     * @return the 加工方式
     */
    public String getProcessingWay() {
        return processingWay;
    }

    /**
     * <p>加工方式�?</p>
     *
     * @param processingWay 加工方式�?
     */
    public void setProcessingWay(String processingWay) {
        this.processingWay = processingWay;
    }

    /**
     * <p>储存方式�?</p>
     *
     * @return the 储存方式
     */
    public String getStorageWay() {
        return storageWay;
    }

    /**
     * <p>储存方式�?</p>
     *
     * @param storageWay 储存方式�?
     */
    public void setStorageWay(String storageWay) {
        this.storageWay = storageWay;
    }

}
