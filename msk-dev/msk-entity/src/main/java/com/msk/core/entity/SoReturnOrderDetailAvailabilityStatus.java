/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_return_order_detail_availability_status对应的SoReturnOrderDetailAvailabilityStatus。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoReturnOrderDetailAvailabilityStatus extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** RETURN_ID */
    private java.lang.Long returnId;
    /** RETURN_CODE */
    private java.lang.String returnCode;
    /** ORDER_ID */
    private java.lang.Long orderId;
    /** ORDER_CODE */
    private java.lang.String orderCode;
    /** RETURN_DETAIL_AVAILABILITY_ID */
    private java.lang.Long returnDetailAvailabilityId;
    /** ID */
    private java.lang.Long id;
    /** STATUS */
    private java.lang.Integer status;
    /**
     * <p>默认构造函数。</p>
     */
    public SoReturnOrderDetailAvailabilityStatus() {

    }

    /**
     * <p>RETURN_ID。</p>
     *
     * @return the RETURN_ID
     */
    public java.lang.Long getReturnId() {
        return returnId;
    }

    /**
     * <p>RETURN_ID。</p>
     *
     * @param returnId RETURN_ID。
     */
    public void setReturnId(java.lang.Long returnId) {
        this.returnId = returnId;
    }

    /**
     * <p>RETURN_CODE。</p>
     *
     * @return the RETURN_CODE
     */
    public java.lang.String getReturnCode() {
        return returnCode;
    }

    /**
     * <p>RETURN_CODE。</p>
     *
     * @param returnCode RETURN_CODE。
     */
    public void setReturnCode(java.lang.String returnCode) {
        this.returnCode = returnCode;
    }

    /**
     * <p>ORDER_ID。</p>
     *
     * @return the ORDER_ID
     */
    public java.lang.Long getOrderId() {
        return orderId;
    }

    /**
     * <p>ORDER_ID。</p>
     *
     * @param orderId ORDER_ID。
     */
    public void setOrderId(java.lang.Long orderId) {
        this.orderId = orderId;
    }

    /**
     * <p>ORDER_CODE。</p>
     *
     * @return the ORDER_CODE
     */
    public java.lang.String getOrderCode() {
        return orderCode;
    }

    /**
     * <p>ORDER_CODE。</p>
     *
     * @param orderCode ORDER_CODE。
     */
    public void setOrderCode(java.lang.String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * <p>RETURN_DETAIL_AVAILABILITY_ID。</p>
     *
     * @return the RETURN_DETAIL_AVAILABILITY_ID
     */
    public java.lang.Long getReturnDetailAvailabilityId() {
        return returnDetailAvailabilityId;
    }

    /**
     * <p>RETURN_DETAIL_AVAILABILITY_ID。</p>
     *
     * @param returnDetailAvailabilityId RETURN_DETAIL_AVAILABILITY_ID。
     */
    public void setReturnDetailAvailabilityId(java.lang.Long returnDetailAvailabilityId) {
        this.returnDetailAvailabilityId = returnDetailAvailabilityId;
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
     * <p>STATUS。</p>
     *
     * @return the STATUS
     */
    public java.lang.Integer getStatus() {
        return status;
    }

    /**
     * <p>STATUS。</p>
     *
     * @param status STATUS。
     */
    public void setStatus(java.lang.Integer status) {
        this.status = status;
    }

}
