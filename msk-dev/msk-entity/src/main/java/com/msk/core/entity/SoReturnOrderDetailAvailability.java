/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_return_order_detail_availability对应的SoReturnOrderDetailAvailability。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoReturnOrderDetailAvailability extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 退货单ID */
    private java.lang.Long returnId;
    /** 退货单编码 */
    private java.lang.String returnCode;
    /** 退货单明细ID */
    private java.lang.Long returnDetailId;
    /** 退货单明细供货ID */
    private java.lang.Long returnDetailAvailabilityId;
    /** 供应商编码 */
    private java.lang.String supplierCode;
    /** 供应商名称 */
    private java.lang.String supplierName;
    /** 产品类别编码 */
    private java.lang.String classesCode;
    /** 产品类别名称 */
    private java.lang.String classesName;
    /** 产品品种 */
    private java.lang.String breedCode;
    /** 产品品种名称 */
    private java.lang.String breedName;
    /** 产品特征编码 */
    private java.lang.String featureCode;
    /** 产品特征名称 */
    private java.lang.String featureName;
    /** 产品包装编码 */
    private java.lang.String normsCode;
    /** 产品包装名称 */
    private java.lang.String normsName;
    /** 产品编码 */
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
    private java.lang.String unit;
    /** 单箱体积 */
    private java.math.BigDecimal packingVolume;
    /** =产品外包装净重*退货数量 */
    private java.math.BigDecimal weight;
    /** =单箱体积*退货数量 */
    private java.math.BigDecimal volume;
    /** 供应数量 */
    private java.math.BigDecimal suppQty;
    /** 退货数量 */
    private java.math.BigDecimal returnQty;
    /**
     * <p>默认构造函数。</p>
     */
    public SoReturnOrderDetailAvailability() {

    }

    /**
     * <p>退货单ID。</p>
     *
     * @return the 退货单ID
     */
    public java.lang.Long getReturnId() {
        return returnId;
    }

    /**
     * <p>退货单ID。</p>
     *
     * @param returnId 退货单ID。
     */
    public void setReturnId(java.lang.Long returnId) {
        this.returnId = returnId;
    }

    /**
     * <p>退货单编码。</p>
     *
     * @return the 退货单编码
     */
    public java.lang.String getReturnCode() {
        return returnCode;
    }

    /**
     * <p>退货单编码。</p>
     *
     * @param returnCode 退货单编码。
     */
    public void setReturnCode(java.lang.String returnCode) {
        this.returnCode = returnCode;
    }

    /**
     * <p>退货单明细ID。</p>
     *
     * @return the 退货单明细ID
     */
    public java.lang.Long getReturnDetailId() {
        return returnDetailId;
    }

    /**
     * <p>退货单明细ID。</p>
     *
     * @param returnDetailId 退货单明细ID。
     */
    public void setReturnDetailId(java.lang.Long returnDetailId) {
        this.returnDetailId = returnDetailId;
    }

    /**
     * <p>退货单明细供货ID。</p>
     *
     * @return the 退货单明细供货ID
     */
    public java.lang.Long getReturnDetailAvailabilityId() {
        return returnDetailAvailabilityId;
    }

    /**
     * <p>退货单明细供货ID。</p>
     *
     * @param returnDetailAvailabilityId 退货单明细供货ID。
     */
    public void setReturnDetailAvailabilityId(java.lang.Long returnDetailAvailabilityId) {
        this.returnDetailAvailabilityId = returnDetailAvailabilityId;
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
     * <p>产品类别编码。</p>
     *
     * @return the 产品类别编码
     */
    public java.lang.String getClassesCode() {
        return classesCode;
    }

    /**
     * <p>产品类别编码。</p>
     *
     * @param classesCode 产品类别编码。
     */
    public void setClassesCode(java.lang.String classesCode) {
        this.classesCode = classesCode;
    }

    /**
     * <p>产品类别名称。</p>
     *
     * @return the 产品类别名称
     */
    public java.lang.String getClassesName() {
        return classesName;
    }

    /**
     * <p>产品类别名称。</p>
     *
     * @param classesName 产品类别名称。
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
     * <p>产品特征编码。</p>
     *
     * @return the 产品特征编码
     */
    public java.lang.String getFeatureCode() {
        return featureCode;
    }

    /**
     * <p>产品特征编码。</p>
     *
     * @param featureCode 产品特征编码。
     */
    public void setFeatureCode(java.lang.String featureCode) {
        this.featureCode = featureCode;
    }

    /**
     * <p>产品特征名称。</p>
     *
     * @return the 产品特征名称
     */
    public java.lang.String getFeatureName() {
        return featureName;
    }

    /**
     * <p>产品特征名称。</p>
     *
     * @param featureName 产品特征名称。
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
     * <p>产品编码。</p>
     *
     * @return the 产品编码
     */
    public java.lang.String getPdCode() {
        return pdCode;
    }

    /**
     * <p>产品编码。</p>
     *
     * @param pdCode 产品编码。
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
     * <p>=产品外包装净重*退货数量。</p>
     *
     * @return the =产品外包装净重*退货数量
     */
    public java.math.BigDecimal getWeight() {
        return weight;
    }

    /**
     * <p>=产品外包装净重*退货数量。</p>
     *
     * @param weight =产品外包装净重*退货数量。
     */
    public void setWeight(java.math.BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * <p>=单箱体积*退货数量。</p>
     *
     * @return the =单箱体积*退货数量
     */
    public java.math.BigDecimal getVolume() {
        return volume;
    }

    /**
     * <p>=单箱体积*退货数量。</p>
     *
     * @param volume =单箱体积*退货数量。
     */
    public void setVolume(java.math.BigDecimal volume) {
        this.volume = volume;
    }

    /**
     * <p>供应数量。</p>
     *
     * @return the 供应数量
     */
    public java.math.BigDecimal getSuppQty() {
        return suppQty;
    }

    /**
     * <p>供应数量。</p>
     *
     * @param suppQty 供应数量。
     */
    public void setSuppQty(java.math.BigDecimal suppQty) {
        this.suppQty = suppQty;
    }

    /**
     * <p>退货数量。</p>
     *
     * @return the 退货数量
     */
    public java.math.BigDecimal getReturnQty() {
        return returnQty;
    }

    /**
     * <p>退货数量。</p>
     *
     * @param returnQty 退货数量。
     */
    public void setReturnQty(java.math.BigDecimal returnQty) {
        this.returnQty = returnQty;
    }

}
