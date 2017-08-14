/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.batch.so.bean;

import com.msk.core.entity.BaseEntity;

/**
 * <p>Batch</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class BSO152404Bean extends BaseEntity{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /** ORDER_ID */
    private Long orderId;
    /** ORDER_CODE */
    private String orderCode;
    /** ORDER_DETAIL_ID */
    private Long orderDetailId;
    /** ORDER_DETAIL_AVAILABILITY_ID */
    private Long orderDetailAvailabilityId;
    /** SELLER_CODE */
    private String sellerCode;
    /** SELLER_NAME */
    private String sellerName;
    /** SOURCE_SELLER_CODE */
    private String sourceSellerCode;
    /** SOURCE_SELLER_NAME */
    private String sourceSellerName;
    /** ORDER_SOURCE 订单来源*/
    private Integer orderSource;
    /** DISTRICT_CODE 物流区域*/
    private String districtCode;
    /** SUPPLIER_CODE */
    private String supplierCode;
    /** SUPPLIER_NAME */
    private String supplierName;
    /** CLASSES_CODE */
    private String classesCode;
    /** CLASSES_NAME */
    private String classesName;
    /** BREED_CODE */
    private String breedCode;
    /** BREED_NAME */
    private String breedName;
    /** FEATURE_CODE */
    private String featureCode;
    /** FEATURE_NAME */
    private String featureName;
    /** NORMS_CODE */
    private String normsCode;
    /** NORMS_NAME */
    private String normsName;
    /** PD_CODE */
    private String pdCode;
    /** PD_NAME */
    private String pdName;
    /** PD_GRADE_CODE */
    private String pdGradeCode;
    /** PD_GRADE_NAME */
    private String pdGradeName;
    /** PD_LEVEL */
    private String pdLevel;
    /** UNIT */
    private String unit;
    /** PACKING_VOLUME */
    private String packingVolume;
    /** WEIGHT */
    private String weight;
    /** VOLUME */
    private String volume;
    /** SUPP_QTY */
    private java.math.BigDecimal suppQty;
    /** SEND_QTY */
    private java.math.BigDecimal sendQty;
    /** RECEIVE_QTY */
    private java.math.BigDecimal receiveQty;
    /** CANCEL_QTY */
    private java.math.BigDecimal cancelQty;
    /** RETURN_QTY */
    private java.math.BigDecimal returnQty;
    /** SEND_TIME */
    private java.util.Date sendTime;
    /** RECEIVED_TIME */
    private java.util.Date receivedTime;

    /**STATUS 订单状态*/
    private String status;

    /**
     * <p>默认构造函数。</p>
     */
    public BSO152404Bean() {

    }

    /**
     * <p>ORDER_ID。</p>
     *
     * @return the ORDER_ID
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * <p>ORDER_ID。</p>
     *
     * @param orderId ORDER_ID。
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * <p>ORDER_CODE。</p>
     *
     * @return the ORDER_CODE
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * <p>ORDER_CODE。</p>
     *
     * @param orderCode ORDER_CODE。
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * <p>ORDER_DETAIL_ID。</p>
     *
     * @return the ORDER_DETAIL_ID
     */
    public Long getOrderDetailId() {
        return orderDetailId;
    }

    /**
     * <p>ORDER_DETAIL_ID。</p>
     *
     * @param orderDetailId ORDER_DETAIL_ID。
     */
    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    /**
     * <p>ORDER_DETAIL_AVAILABILITY_ID。</p>
     *
     * @return the ORDER_DETAIL_AVAILABILITY_ID
     */
    public Long getOrderDetailAvailabilityId() {
        return orderDetailAvailabilityId;
    }

    /**
     * <p>ORDER_DETAIL_AVAILABILITY_ID。</p>
     *
     * @param orderDetailAvailabilityId ORDER_DETAIL_AVAILABILITY_ID。
     */
    public void setOrderDetailAvailabilityId(Long orderDetailAvailabilityId) {
        this.orderDetailAvailabilityId = orderDetailAvailabilityId;
    }
    /**
     * <p>SELLER_CODE。</p>
     *
     * @return the SELLER_CODE
     */
    public String getSellerCode() {
        return sellerCode;
    }

    /**
     * <p>SELLER_CODE。</p>
     *
     * @param sellerCode SELLER_CODE。
     */
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    /**
     * <p>SELLER_NAME。</p>
     *
     * @return the SELLER_NAME
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * <p>SELLER_NAME。</p>
     *
     * @param sellerName SELLER_NAME。
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
    /**
     * <p>SOURCE_SELLER_CODE。</p>
     *
     * @return the SOURCE_SELLER_CODE
     */
    public String getSourceSellerCode() {
        return sourceSellerCode;
    }

    /**
     * <p>SOURCE_SELLER_CODE。</p>
     *
     * @param sourceSellerCode SOURCE_SELLER_CODE。
     */
    public void setSourceSellerCode(String sourceSellerCode) {
        this.sourceSellerCode = sourceSellerCode;
    }

    /**
     * <p>SOURCE_SELLER_NAME。</p>
     *
     * @return the SOURCE_SELLER_NAME
     */
    public String getSourceSellerName() {
        return sourceSellerName;
    }

    /**
     * <p>SOURCE_SELLER_NAME。</p>
     *
     * @param sourceSellerName SOURCE_SELLER_NAME。
     */
    public void setSourceSellerName(String sourceSellerName) {
        this.sourceSellerName = sourceSellerName;
    }

    /**
     * <p>ORDER_SOURCE。</p>
     *
     * @return the ORDER_SOURCE
     */
    public Integer getOrderSource() {
        return orderSource;
    }

    /**
     * <p>ORDER_SOURCE。</p>
     *
     * @param orderSource ORDER_SOURCE。
     */
    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }

    /**
     * <p>DISTRICT_CODE。</p>
     *
     * @return the DISTRICT_CODE
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * <p>DISTRICT_CODE。</p>
     *
     * @param districtCode DISTRICT_CODE。
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }
    /**
     * <p>SUPPLIER_CODE。</p>
     *
     * @return the SUPPLIER_CODE
     */
    public String getSupplierCode() {
        return supplierCode;
    }

    /**
     * <p>SUPPLIER_CODE。</p>
     *
     * @param supplierCode SUPPLIER_CODE。
     */
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    /**
     * <p>SUPPLIER_NAME。</p>
     *
     * @return the SUPPLIER_NAME
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * <p>SUPPLIER_NAME。</p>
     *
     * @param supplierName SUPPLIER_NAME。
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * <p>CLASSES_CODE。</p>
     *
     * @return the CLASSES_CODE
     */
    public String getClassesCode() {
        return classesCode;
    }

    /**
     * <p>CLASSES_CODE。</p>
     *
     * @param classesCode CLASSES_CODE。
     */
    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    /**
     * <p>CLASSES_NAME。</p>
     *
     * @return the CLASSES_NAME
     */
    public String getClassesName() {
        return classesName;
    }

    /**
     * <p>CLASSES_NAME。</p>
     *
     * @param classesName CLASSES_NAME。
     */
    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    /**
     * <p>BREED_CODE。</p>
     *
     * @return the BREED_CODE
     */
    public String getBreedCode() {
        return breedCode;
    }

    /**
     * <p>BREED_CODE。</p>
     *
     * @param breedCode BREED_CODE。
     */
    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    /**
     * <p>BREED_NAME。</p>
     *
     * @return the BREED_NAME
     */
    public String getBreedName() {
        return breedName;
    }

    /**
     * <p>BREED_NAME。</p>
     *
     * @param breedName BREED_NAME。
     */
    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    /**
     * <p>FEATURE_CODE。</p>
     *
     * @return the FEATURE_CODE
     */
    public String getFeatureCode() {
        return featureCode;
    }

    /**
     * <p>FEATURE_CODE。</p>
     *
     * @param featureCode FEATURE_CODE。
     */
    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    /**
     * <p>FEATURE_NAME。</p>
     *
     * @return the FEATURE_NAME
     */
    public String getFeatureName() {
        return featureName;
    }

    /**
     * <p>FEATURE_NAME。</p>
     *
     * @param featureName FEATURE_NAME。
     */
    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    /**
     * <p>NORMS_CODE。</p>
     *
     * @return the NORMS_CODE
     */
    public String getNormsCode() {
        return normsCode;
    }

    /**
     * <p>NORMS_CODE。</p>
     *
     * @param normsCode NORMS_CODE。
     */
    public void setNormsCode(String normsCode) {
        this.normsCode = normsCode;
    }

    /**
     * <p>NORMS_NAME。</p>
     *
     * @return the NORMS_NAME
     */
    public String getNormsName() {
        return normsName;
    }

    /**
     * <p>NORMS_NAME。</p>
     *
     * @param normsName NORMS_NAME。
     */
    public void setNormsName(String normsName) {
        this.normsName = normsName;
    }

    /**
     * <p>PD_CODE。</p>
     *
     * @return the PD_CODE
     */
    public String getPdCode() {
        return pdCode;
    }

    /**
     * <p>PD_CODE。</p>
     *
     * @param pdCode PD_CODE。
     */
    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    /**
     * <p>PD_NAME。</p>
     *
     * @return the PD_NAME
     */
    public String getPdName() {
        return pdName;
    }

    /**
     * <p>PD_NAME。</p>
     *
     * @param pdName PD_NAME。
     */
    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    /**
     * <p>PD_GRADE_CODE。</p>
     *
     * @return the PD_GRADE_CODE
     */
    public String getPdGradeCode() {
        return pdGradeCode;
    }

    /**
     * <p>PD_GRADE_CODE。</p>
     *
     * @param pdGradeCode PD_GRADE_CODE。
     */
    public void setPdGradeCode(String pdGradeCode) {
        this.pdGradeCode = pdGradeCode;
    }

    /**
     * <p>PD_GRADE_NAME。</p>
     *
     * @return the PD_GRADE_NAME
     */
    public String getPdGradeName() {
        return pdGradeName;
    }

    /**
     * <p>PD_GRADE_NAME。</p>
     *
     * @param pdGradeName PD_GRADE_NAME。
     */
    public void setPdGradeName(String pdGradeName) {
        this.pdGradeName = pdGradeName;
    }

    /**
     * <p>PD_LEVEL。</p>
     *
     * @return the PD_LEVEL
     */
    public String getPdLevel() {
        return pdLevel;
    }

    /**
     * <p>PD_LEVEL。</p>
     *
     * @param pdLevel PD_LEVEL。
     */
    public void setPdLevel(String pdLevel) {
        this.pdLevel = pdLevel;
    }

    /**
     * <p>UNIT。</p>
     *
     * @return the UNIT
     */
    public String getUnit() {
        return unit;
    }

    /**
     * <p>UNIT。</p>
     *
     * @param unit UNIT。
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * <p>PACKING_VOLUME。</p>
     *
     * @return the PACKING_VOLUME
     */
    public String getPackingVolume() {
        return packingVolume;
    }

    /**
     * <p>PACKING_VOLUME。</p>
     *
     * @param packingVolume PACKING_VOLUME。
     */
    public void setPackingVolume(String packingVolume) {
        this.packingVolume = packingVolume;
    }

    /**
     * <p>WEIGHT。</p>
     *
     * @return the WEIGHT
     */
    public String getWeight() {
        return weight;
    }

    /**
     * <p>WEIGHT。</p>
     *
     * @param weight WEIGHT。
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * <p>VOLUME。</p>
     *
     * @return the VOLUME
     */
    public String getVolume() {
        return volume;
    }

    /**
     * <p>VOLUME。</p>
     *
     * @param volume VOLUME。
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * <p>SUPP_QTY。</p>
     *
     * @return the SUPP_QTY
     */
    public java.math.BigDecimal getSuppQty() {
        return suppQty;
    }

    /**
     * <p>SUPP_QTY。</p>
     *
     * @param suppQty SUPP_QTY。
     */
    public void setSuppQty(java.math.BigDecimal suppQty) {
        this.suppQty = suppQty;
    }

    /**
     * <p>SEND_QTY。</p>
     *
     * @return the SEND_QTY
     */
    public java.math.BigDecimal getSendQty() {
        return sendQty;
    }

    /**
     * <p>SEND_QTY。</p>
     *
     * @param sendQty SEND_QTY。
     */
    public void setSendQty(java.math.BigDecimal sendQty) {
        this.sendQty = sendQty;
    }

    /**
     * <p>RECEIVE_QTY。</p>
     *
     * @return the RECEIVE_QTY
     */
    public java.math.BigDecimal getReceiveQty() {
        return receiveQty;
    }

    /**
     * <p>RECEIVE_QTY。</p>
     *
     * @param receiveQty RECEIVE_QTY。
     */
    public void setReceiveQty(java.math.BigDecimal receiveQty) {
        this.receiveQty = receiveQty;
    }

    /**
     * <p>CANCEL_QTY。</p>
     *
     * @return the CANCEL_QTY
     */
    public java.math.BigDecimal getCancelQty() {
        return cancelQty;
    }

    /**
     * <p>CANCEL_QTY。</p>
     *
     * @param cancelQty CANCEL_QTY。
     */
    public void setCancelQty(java.math.BigDecimal cancelQty) {
        this.cancelQty = cancelQty;
    }

    /**
     * <p>RETURN_QTY。</p>
     *
     * @return the RETURN_QTY
     */
    public java.math.BigDecimal getReturnQty() {
        return returnQty;
    }

    /**
     * <p>RETURN_QTY。</p>
     *
     * @param returnQty RETURN_QTY。
     */
    public void setReturnQty(java.math.BigDecimal returnQty) {
        this.returnQty = returnQty;
    }

    /**
     * <p>SEND_TIME。</p>
     *
     * @return the SEND_TIME
     */
    public java.util.Date getSendTime() {
        return sendTime;
    }

    /**
     * <p>SEND_TIME。</p>
     *
     * @param sendTime SEND_TIME。
     */
    public void setSendTime(java.util.Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * <p>RECEIVED_TIME。</p>
     *
     * @return the RECEIVED_TIME
     */
    public java.util.Date getReceivedTime() {
        return receivedTime;
    }

    /**
     * <p>RECEIVED_TIME。</p>
     *
     * @param receivedTime RECEIVED_TIME。
     */
    public void setReceivedTime(java.util.Date receivedTime) {
        this.receivedTime = receivedTime;
    }

    /**
     * <p>STATUS。</p>
     *
     * @return the STATUS
     */
    public String getStatus() {
        return status;
    }
    /**
     * <p>STATUS。</p>
     *
     * @param status STATUS。
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
