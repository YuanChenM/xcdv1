/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_order_status对应的SoOrderStatus。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoOrderStatus extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** ORDER_ID */
    private java.lang.Long orderId;
    /** ORDER_CODE */
    private java.lang.String orderCode;
    /** ID */
    private java.lang.Long id;
    /** ORDER_STATUS */
    private java.lang.Integer orderStatus;
    /**
     * <p>默认构造函数。</p>
     */
    public SoOrderStatus() {

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
     * <p>ORDER_STATUS。</p>
     *
     * @return the ORDER_STATUS
     */
    public java.lang.Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * <p>ORDER_STATUS。</p>
     *
     * @param orderStatus ORDER_STATUS。
     */
    public void setOrderStatus(java.lang.Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

}
