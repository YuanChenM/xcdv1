/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_deliver_detail对应的SoDeliverDetail。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoDeliverDetail extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** DELIVER_ID */
    private Long deliverId;
    /** DELIVER_CODE */
    private String deliverCode;
    /** ORDER_ID */
    private Long orderId;
    /** ORDER_CODE */
    private String orderCode;
    /** ORDER_DETAIL_ID */
    private Long orderDetailId;
    /** ORDER_DETAIL_AVAILABILITY_ID */
    private Long orderDetailAvailabilityId;
    /** DELIVER_DETAIL_ID */
    private Long deliverDetailId;
    /** SUPPLIER_CODE */
    private String supplierCode;
    /** PD_CODE */
    private String pdCode;
    /** PD_NAME */
    private String pdName;
    /** DELIVER_QTY */
    private java.math.BigDecimal deliverQty;
    /** RECEIVE_QTY */
    private java.math.BigDecimal receiveQty;
    /**
     * <p>默认构造函数。</p>
     */
    public SoDeliverDetail() {

    }

    /**
     * <p>DELIVER_ID。</p>
     *
     * @return the DELIVER_ID
     */
    public Long getDeliverId() {
        return deliverId;
    }

    /**
     * <p>DELIVER_ID。</p>
     *
     * @param deliverId DELIVER_ID。
     */
    public void setDeliverId(Long deliverId) {
        this.deliverId = deliverId;
    }

    /**
     * <p>DELIVER_CODE。</p>
     *
     * @return the DELIVER_CODE
     */
    public String getDeliverCode() {
        return deliverCode;
    }

    /**
     * <p>DELIVER_CODE。</p>
     *
     * @param deliverCode DELIVER_CODE。
     */
    public void setDeliverCode(String deliverCode) {
        this.deliverCode = deliverCode;
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
     * <p>DELIVER_DETAIL_ID。</p>
     *
     * @return the DELIVER_DETAIL_ID
     */
    public Long getDeliverDetailId() {
        return deliverDetailId;
    }

    /**
     * <p>DELIVER_DETAIL_ID。</p>
     *
     * @param deliverDetailId DELIVER_DETAIL_ID。
     */
    public void setDeliverDetailId(Long deliverDetailId) {
        this.deliverDetailId = deliverDetailId;
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
     * <p>DELIVER_QTY。</p>
     *
     * @return the DELIVER_QTY
     */
    public java.math.BigDecimal getDeliverQty() {
        return deliverQty;
    }

    /**
     * <p>DELIVER_QTY。</p>
     *
     * @param deliverQty DELIVER_QTY。
     */
    public void setDeliverQty(java.math.BigDecimal deliverQty) {
        this.deliverQty = deliverQty;
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

}
