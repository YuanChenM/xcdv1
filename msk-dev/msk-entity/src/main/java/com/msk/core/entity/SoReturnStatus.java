/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_return_status对应的SoReturnStatus。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoReturnStatus extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 退货状态编号 */
    private java.lang.Long statusId;
    /** 退货单ID */
    private java.lang.Long returnId;
    /** 退货单编码 */
    private java.lang.String returnCode;
    /** 退货状态 */
    private java.lang.Integer returnStatus;
    /**
     * <p>默认构造函数。</p>
     */
    public SoReturnStatus() {

    }

    /**
     * <p>退货状态编号。</p>
     *
     * @return the 退货状态编号
     */
    public java.lang.Long getStatusId() {
        return statusId;
    }

    /**
     * <p>退货状态编号。</p>
     *
     * @param statusId 退货状态编号。
     */
    public void setStatusId(java.lang.Long statusId) {
        this.statusId = statusId;
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
     * <p>退货状态。</p>
     *
     * @return the 退货状态
     */
    public java.lang.Integer getReturnStatus() {
        return returnStatus;
    }

    /**
     * <p>退货状态。</p>
     *
     * @param returnStatus 退货状态。
     */
    public void setReturnStatus(java.lang.Integer returnStatus) {
        this.returnStatus = returnStatus;
    }

}
