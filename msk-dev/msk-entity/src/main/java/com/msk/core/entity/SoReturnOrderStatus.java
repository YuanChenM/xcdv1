/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_return_order_status对应的SoReturnOrderStatus。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoReturnOrderStatus extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 退货单ID */
    private java.lang.Long returnId;
    /** 编号 */
    private java.lang.Long id;
    /** 状态 */
    private java.lang.Integer status;
    /** RETURN_CODE */
    private java.lang.String returnCode;
    /**
     * <p>默认构造函数。</p>
     */
    public SoReturnOrderStatus() {

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
     * <p>编号。</p>
     *
     * @return the 编号
     */
    public java.lang.Long getId() {
        return id;
    }

    /**
     * <p>编号。</p>
     *
     * @param id 编号。
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    /**
     * <p>状态。</p>
     *
     * @return the 状态
     */
    public java.lang.Integer getStatus() {
        return status;
    }

    /**
     * <p>状态。</p>
     *
     * @param status 状态。
     */
    public void setStatus(java.lang.Integer status) {
        this.status = status;
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

}
