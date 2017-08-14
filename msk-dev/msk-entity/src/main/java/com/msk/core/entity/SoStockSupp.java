/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_stock_supp对应的SoStockSupp。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoStockSupp extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 库存ID */
    private java.lang.Long stockId;
    /** 物流区编号 */
    private java.lang.String lgcsCode;
    /** 物流区名称 */
    private java.lang.String lgcsName;
    /** 仓库编号 */
    private java.lang.String warehouseCode;
    /** 仓库名称 */
    private java.lang.String warehouseName;
    /** 1:神农客 2:美侍客 3:大促会 */
    private java.lang.Integer supplyPlatform;
    /** 1:正常仓别 2:非正常仓别 */
    private java.lang.Integer stockType;
    /** 卖家编号 */
    private java.lang.String slCode;
    /** 卖家名称 */
    private java.lang.String slName;
    /** 供应商编码 */
    private java.lang.String supplierCode;
    /** 供应商名称 */
    private java.lang.String supplierName;
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
    /** 产品单位 */
    private java.lang.String unit;
    /** 单箱体积 */
    private java.math.BigDecimal packingVolume;
    /** 重量 */
    private java.math.BigDecimal weight;
    /** 体积 */
    private java.math.BigDecimal volume;
    /** 库存数量 */
    private java.math.BigDecimal stockQty;
    /**
     * <p>默认构造函数。</p>
     */
    public SoStockSupp() {

    }

    /**
     * <p>库存ID。</p>
     *
     * @return the 库存ID
     */
    public java.lang.Long getStockId() {
        return stockId;
    }

    /**
     * <p>库存ID。</p>
     *
     * @param stockId 库存ID。
     */
    public void setStockId(java.lang.Long stockId) {
        this.stockId = stockId;
    }

    /**
     * <p>物流区编号。</p>
     *
     * @return the 物流区编号
     */
    public java.lang.String getLgcsCode() {
        return lgcsCode;
    }

    /**
     * <p>物流区编号。</p>
     *
     * @param lgcsCode 物流区编号。
     */
    public void setLgcsCode(java.lang.String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    /**
     * <p>物流区名称。</p>
     *
     * @return the 物流区名称
     */
    public java.lang.String getLgcsName() {
        return lgcsName;
    }

    /**
     * <p>物流区名称。</p>
     *
     * @param lgcsName 物流区名称。
     */
    public void setLgcsName(java.lang.String lgcsName) {
        this.lgcsName = lgcsName;
    }

    /**
     * <p>仓库编号。</p>
     *
     * @return the 仓库编号
     */
    public java.lang.String getWarehouseCode() {
        return warehouseCode;
    }

    /**
     * <p>仓库编号。</p>
     *
     * @param warehouseCode 仓库编号。
     */
    public void setWarehouseCode(java.lang.String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    /**
     * <p>仓库名称。</p>
     *
     * @return the 仓库名称
     */
    public java.lang.String getWarehouseName() {
        return warehouseName;
    }

    /**
     * <p>仓库名称。</p>
     *
     * @param warehouseName 仓库名称。
     */
    public void setWarehouseName(java.lang.String warehouseName) {
        this.warehouseName = warehouseName;
    }

    /**
     * <p>1:神农客 2:美侍客 3:大促会。</p>
     *
     * @return the 1:神农客 2:美侍客 3:大促会
     */
    public java.lang.Integer getSupplyPlatform() {
        return supplyPlatform;
    }

    /**
     * <p>1:神农客 2:美侍客 3:大促会。</p>
     *
     * @param supplyPlatform 1:神农客 2:美侍客 3:大促会。
     */
    public void setSupplyPlatform(java.lang.Integer supplyPlatform) {
        this.supplyPlatform = supplyPlatform;
    }

    /**
     * <p>1:正常仓别 2:非正常仓别。</p>
     *
     * @return the 1:正常仓别 2:非正常仓别
     */
    public java.lang.Integer getStockType() {
        return stockType;
    }

    /**
     * <p>1:正常仓别 2:非正常仓别。</p>
     *
     * @param stockType 1:正常仓别 2:非正常仓别。
     */
    public void setStockType(java.lang.Integer stockType) {
        this.stockType = stockType;
    }

    /**
     * <p>卖家编号。</p>
     *
     * @return the 卖家编号
     */
    public java.lang.String getSlCode() {
        return slCode;
    }

    /**
     * <p>卖家编号。</p>
     *
     * @param slCode 卖家编号。
     */
    public void setSlCode(java.lang.String slCode) {
        this.slCode = slCode;
    }

    /**
     * <p>卖家名称。</p>
     *
     * @return the 卖家名称
     */
    public java.lang.String getSlName() {
        return slName;
    }

    /**
     * <p>卖家名称。</p>
     *
     * @param slName 卖家名称。
     */
    public void setSlName(java.lang.String slName) {
        this.slName = slName;
    }

    /**
     * <p>供应商编码。</p>
     *
     * @return the 供应商编码
     */
    public java.lang.String getSupplierCode() {
        return supplierCode;
    }

    /**
     * <p>供应商编码。</p>
     *
     * @param supplierCode 供应商编码。
     */
    public void setSupplierCode(java.lang.String supplierCode) {
        this.supplierCode = supplierCode;
    }

    /**
     * <p>供应商名称。</p>
     *
     * @return the 供应商名称
     */
    public java.lang.String getSupplierName() {
        return supplierName;
    }

    /**
     * <p>供应商名称。</p>
     *
     * @param supplierName 供应商名称。
     */
    public void setSupplierName(java.lang.String supplierName) {
        this.supplierName = supplierName;
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
     * <p>产品单位。</p>
     *
     * @return the 产品单位
     */
    public java.lang.String getUnit() {
        return unit;
    }

    /**
     * <p>产品单位。</p>
     *
     * @param unit 产品单位。
     */
    public void setUnit(java.lang.String unit) {
        this.unit = unit;
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
    public java.math.BigDecimal getWeight() {
        return weight;
    }

    /**
     * <p>重量。</p>
     *
     * @param weight 重量。
     */
    public void setWeight(java.math.BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * <p>体积。</p>
     *
     * @return the 体积
     */
    public java.math.BigDecimal getVolume() {
        return volume;
    }

    /**
     * <p>体积。</p>
     *
     * @param volume 体积。
     */
    public void setVolume(java.math.BigDecimal volume) {
        this.volume = volume;
    }

    /**
     * <p>库存数量。</p>
     *
     * @return the 库存数量
     */
    public java.math.BigDecimal getStockQty() {
        return stockQty;
    }

    /**
     * <p>库存数量。</p>
     *
     * @param stockQty 库存数量。
     */
    public void setStockQty(java.math.BigDecimal stockQty) {
        this.stockQty = stockQty;
    }

}
