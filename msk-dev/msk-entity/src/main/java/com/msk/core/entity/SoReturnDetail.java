/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_return_detail对应的SoReturnDetail。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoReturnDetail extends BaseEntity{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /** 退货明细ID */
    private java.lang.Long detailId;
    /** 退货单ID */
    private java.lang.Long returnId;
    /** 发货单ID */
    private java.lang.Long shipId;
    /** 发货单编号 */
    private java.lang.String shipCode;
    /** 订单明细供货ID */
    private java.lang.Long orderDetailAvailabilityId;
    /** 配送单ID(预留) */
    private java.lang.Long deliverId;
    /** 供应商编码 */
    private java.lang.String supplierCode;
    /** 供应商名称 */
    private java.lang.String supplierName;
    /** 生产商编码（预留） */
    private java.lang.String manufactureCode;
    /** 生产商名称（预留） */
    private java.lang.String manufactureName;
    /** 产品类别编码 */
    private java.lang.String classesCode;
    /** 产品类别名称 */
    private java.lang.String classesName;
    /** 产品品种编码 */
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
    /** SKU编码 */
    private java.lang.String skuCode;
    /** 产品单位 */
    private java.lang.String unit;
    /** 单箱体积 */
    private java.math.BigDecimal packingVolume;
    /** 重量 */
    private java.math.BigDecimal weight;
    /** 体积 */
    private java.math.BigDecimal volume;
    /** 退货数量 */
    private java.math.BigDecimal returnQty;
    /** 退货原因ID */
    private java.lang.Integer detailReason;
    /** 退货明细状态 */
    private java.lang.Integer detailStatus;
    /** 退货入库数量 */
    private java.math.BigDecimal inboundQty;
    /** 退货入库批次 */
    private java.lang.String inboundBatch;
    /**
     * <p>默认构造函数。</p>
     */
    public SoReturnDetail() {

    }

    /**
     * <p>退货明细ID。</p>
     *
     * @return the 退货明细ID
     */
    public java.lang.Long getDetailId() {
        return detailId;
    }

    /**
     * <p>退货明细ID。</p>
     *
     * @param detailId 退货明细ID。
     */
    public void setDetailId(java.lang.Long detailId) {
        this.detailId = detailId;
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
     * <p>发货单ID。</p>
     *
     * @return the 发货单ID
     */
    public java.lang.Long getShipId() {
        return shipId;
    }

    /**
     * <p>发货单ID。</p>
     *
     * @param shipId 发货单ID。
     */
    public void setShipId(java.lang.Long shipId) {
        this.shipId = shipId;
    }

    /**
     * <p>发货单编号。</p>
     *
     * @return the 发货单编号
     */
    public java.lang.String getShipCode() {
        return shipCode;
    }

    /**
     * <p>发货单编号。</p>
     *
     * @param shipCode 发货单编号。
     */
    public void setShipCode(java.lang.String shipCode) {
        this.shipCode = shipCode;
    }

    /**
     * <p>订单明细供货ID。</p>
     *
     * @return the 订单明细供货ID
     */
    public java.lang.Long getOrderDetailAvailabilityId() {
        return orderDetailAvailabilityId;
    }

    /**
     * <p>订单明细供货ID。</p>
     *
     * @param orderDetailAvailabilityId 订单明细供货ID。
     */
    public void setOrderDetailAvailabilityId(java.lang.Long orderDetailAvailabilityId) {
        this.orderDetailAvailabilityId = orderDetailAvailabilityId;
    }

    /**
     * <p>配送单ID(预留)。</p>
     *
     * @return the 配送单ID(预留)
     */
    public java.lang.Long getDeliverId() {
        return deliverId;
    }

    /**
     * <p>配送单ID(预留)。</p>
     *
     * @param deliverId 配送单ID(预留)。
     */
    public void setDeliverId(java.lang.Long deliverId) {
        this.deliverId = deliverId;
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
     * <p>生产商编码（预留）。</p>
     *
     * @return the 生产商编码（预留）
     */
    public java.lang.String getManufactureCode() {
        return manufactureCode;
    }

    /**
     * <p>生产商编码（预留）。</p>
     *
     * @param manufactureCode 生产商编码（预留）。
     */
    public void setManufactureCode(java.lang.String manufactureCode) {
        this.manufactureCode = manufactureCode;
    }

    /**
     * <p>生产商名称（预留）。</p>
     *
     * @return the 生产商名称（预留）
     */
    public java.lang.String getManufactureName() {
        return manufactureName;
    }

    /**
     * <p>生产商名称（预留）。</p>
     *
     * @param manufactureName 生产商名称（预留）。
     */
    public void setManufactureName(java.lang.String manufactureName) {
        this.manufactureName = manufactureName;
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
     * <p>产品品种编码。</p>
     *
     * @return the 产品品种编码
     */
    public java.lang.String getBreedCode() {
        return breedCode;
    }

    /**
     * <p>产品品种编码。</p>
     *
     * @param breedCode 产品品种编码。
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
     * <p>SKU编码。</p>
     *
     * @return the SKU编码
     */
    public java.lang.String getSkuCode() {
        return skuCode;
    }

    /**
     * <p>SKU编码。</p>
     *
     * @param skuCode SKU编码。
     */
    public void setSkuCode(java.lang.String skuCode) {
        this.skuCode = skuCode;
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

    /**
     * <p>退货原因ID。</p>
     *
     * @return the 退货原因ID
     */
    public java.lang.Integer getDetailReason() {
        return detailReason;
    }

    /**
     * <p>退货原因ID。</p>
     *
     * @param detailReason 退货原因ID。
     */
    public void setDetailReason(java.lang.Integer detailReason) {
        this.detailReason = detailReason;
    }

    /**
     * <p>退货明细状态。</p>
     *
     * @return the 退货明细状态
     */
    public java.lang.Integer getDetailStatus() {
        return detailStatus;
    }

    /**
     * <p>退货明细状态。</p>
     *
     * @param detailStatus 退货明细状态。
     */
    public void setDetailStatus(java.lang.Integer detailStatus) {
        this.detailStatus = detailStatus;
    }

    /**
     * <p>退货入库数量。</p>
     *
     * @return the 退货入库数量
     */
    public java.math.BigDecimal getInboundQty() {
        return inboundQty;
    }

    /**
     * <p>退货入库数量。</p>
     *
     * @param inboundQty 退货入库数量。
     */
    public void setInboundQty(java.math.BigDecimal inboundQty) {
        this.inboundQty = inboundQty;
    }

    public String getInboundBatch() {
        return inboundBatch;
    }

    public void setInboundBatch(String inboundBatch) {
        this.inboundBatch = inboundBatch;
    }
}
