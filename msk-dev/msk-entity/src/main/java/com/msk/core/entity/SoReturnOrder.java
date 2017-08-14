/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_return_order对应的SoReturnOrder。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoReturnOrder extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 订单ID */
    private java.lang.Long orderId;
    /** 退货单ID */
    private java.lang.Long returnId;
    /** 退货单编码 */
    private java.lang.String returnCode;
    /** 冗余 */
    private java.lang.String buyersName;
    /** 冗余 */
    private java.lang.String buyersCode;
    /** 冗余 */
    private java.lang.String sellerCode;
    /** 冗余 */
    private java.lang.String sellerName;
    /** 订单所属区域(冗余) */
    private java.lang.String districtCode;
    /** 1:平台 2:呼叫中心 3:手机客户端 */
    private java.lang.Integer returnSource;
    /** 1:分销,2:第三方,3:大促会 */
    private java.lang.String returnType;
    /** 退货单申请时间 */
    private java.util.Date returnTime;
    /** 退货总金额 */
    private java.math.BigDecimal returnAmount;
    /** 1：全退 2：部分退 */
    private java.lang.String returnMode;
    /** 退货原因 */
    private java.lang.String returnReasonCode;
    /** 退货原因描述 */
    private java.lang.String returnReasonDes;
    /** 1:已付款 */
    private java.lang.String isPaid;

    private java.lang.String returnMethod;
    /** 1:已开票 */
    private java.lang.String isInvoice;
    /** 退货处理人名称 */
    private java.lang.String returnActor;
    /** 退货状态 */
    private java.lang.Integer returnStatus;
    /** 直销员 */
    private java.lang.String sellers;
    /** 呼叫中心下单时候下单人名称 */
    private java.lang.String orderTaker;
    /** 取消原因 */
    private java.lang.String cancelReason;
    /** ORDER_CODE */
    private java.lang.String orderCode;
    /** 退款方式 */
    private java.lang.String refundMode;

    public String getRefundMode() {
        return refundMode;
    }

    public void setRefundMode(String refundMode) {
        this.refundMode = refundMode;
    }
    /**
     * <p>默认构造函数。</p>
     */
    public SoReturnOrder() {

    }

    /**
     * <p>订单ID。</p>
     *
     * @return the 订单ID
     */
    public java.lang.Long getOrderId() {
        return orderId;
    }

    /**
     * <p>订单ID。</p>
     *
     * @param orderId 订单ID。
     */
    public void setOrderId(java.lang.Long orderId) {
        this.orderId = orderId;
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
     * <p>冗余。</p>
     *
     * @return the 冗余
     */
    public java.lang.String getBuyersName() {
        return buyersName;
    }

    /**
     * <p>冗余。</p>
     *
     * @param buyersName 冗余。
     */
    public void setBuyersName(java.lang.String buyersName) {
        this.buyersName = buyersName;
    }

    /**
     * <p>冗余。</p>
     *
     * @return the 冗余
     */
    public java.lang.String getBuyersCode() {
        return buyersCode;
    }

    /**
     * <p>冗余。</p>
     *
     * @param buyersCode 冗余。
     */
    public void setBuyersCode(java.lang.String buyersCode) {
        this.buyersCode = buyersCode;
    }

    /**
     * <p>冗余。</p>
     *
     * @return the 冗余
     */
    public java.lang.String getSellerCode() {
        return sellerCode;
    }

    /**
     * <p>冗余。</p>
     *
     * @param sellerCode 冗余。
     */
    public void setSellerCode(java.lang.String sellerCode) {
        this.sellerCode = sellerCode;
    }

    /**
     * <p>冗余。</p>
     *
     * @return the 冗余
     */
    public java.lang.String getSellerName() {
        return sellerName;
    }

    /**
     * <p>冗余。</p>
     *
     * @param sellerName 冗余。
     */
    public void setSellerName(java.lang.String sellerName) {
        this.sellerName = sellerName;
    }

    /**
     * <p>订单所属区域(冗余)。</p>
     *
     * @return the 订单所属区域(冗余)
     */
    public java.lang.String getDistrictCode() {
        return districtCode;
    }

    /**
     * <p>订单所属区域(冗余)。</p>
     *
     * @param districtCode 订单所属区域(冗余)。
     */
    public void setDistrictCode(java.lang.String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * <p>1:平台 2:呼叫中心 3:手机客户端。</p>
     *
     * @return the 1:平台 2:呼叫中心 3:手机客户端
     */
    public java.lang.Integer getReturnSource() {
        return returnSource;
    }

    /**
     * <p>1:平台 2:呼叫中心 3:手机客户端。</p>
     *
     * @param returnSource 1:平台 2:呼叫中心 3:手机客户端。
     */
    public void setReturnSource(java.lang.Integer returnSource) {
        this.returnSource = returnSource;
    }

    /**
     * <p>1:分销,2:第三方,3:大促会。</p>
     *
     * @return the 1:分销,2:第三方,3:大促会
     */
    public java.lang.String getReturnType() {
        return returnType;
    }

    /**
     * <p>1:分销,2:第三方,3:大促会。</p>
     *
     * @param returnType 1:分销,2:第三方,3:大促会。
     */
    public void setReturnType(java.lang.String returnType) {
        this.returnType = returnType;
    }

    /**
     * <p>退货单申请时间。</p>
     *
     * @return the 退货单申请时间
     */
    public java.util.Date getReturnTime() {
        return returnTime;
    }

    /**
     * <p>退货单申请时间。</p>
     *
     * @param returnTime 退货单申请时间。
     */
    public void setReturnTime(java.util.Date returnTime) {
        this.returnTime = returnTime;
    }

    /**
     * <p>退货总金额。</p>
     *
     * @return the 退货总金额
     */
    public java.math.BigDecimal getReturnAmount() {
        return returnAmount;
    }

    /**
     * <p>退货总金额。</p>
     *
     * @param returnAmount 退货总金额。
     */
    public void setReturnAmount(java.math.BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    /**
     * <p>1：全退 2：部分退。</p>
     *
     * @return the 1：全退 2：部分退
     */
    public java.lang.String getReturnMode() {
        return returnMode;
    }

    /**
     * <p>1：全退 2：部分退。</p>
     *
     * @param returnMode 1：全退 2：部分退。
     */
    public void setReturnMode(java.lang.String returnMode) {
        this.returnMode = returnMode;
    }

    /**
     * <p>退货原因。</p>
     *
     * @return the 退货原因
     */
    public java.lang.String getReturnReasonCode() {
        return returnReasonCode;
    }

    /**
     * <p>退货原因。</p>
     *
     * @param returnReasonCode 退货原因。
     */
    public void setReturnReasonCode(java.lang.String returnReasonCode) {
        this.returnReasonCode = returnReasonCode;
    }

    /**
     * <p>退货原因描述。</p>
     *
     * @return the 退货原因描述
     */
    public java.lang.String getReturnReasonDes() {
        return returnReasonDes;
    }

    /**
     * <p>退货原因描述。</p>
     *
     * @param returnReasonDes 退货原因描述。
     */
    public void setReturnReasonDes(java.lang.String returnReasonDes) {
        this.returnReasonDes = returnReasonDes;
    }

    /**
     * <p>1:已付款。</p>
     *
     * @return the 1:已付款
     */
    public java.lang.String getIsPaid() {
        return isPaid;
    }

    /**
     * <p>1:已付款。</p>
     *
     * @param isPaid 1:已付款。
     */
    public void setIsPaid(java.lang.String isPaid) {
        this.isPaid = isPaid;
    }

    /**
     * <p>退款方式。</p>
     *
     * @return the 退款方式
     */
    public java.lang.String getReturnMethod() {
        return returnMethod;
    }

    /**
     * <p>退款方式。</p>
     *
     * @param returnMethod 退款方式。
     */
    public void setReturnMethod(java.lang.String returnMethod) {
        this.returnMethod = returnMethod;
    }

    /**
     * <p>1:已开票。</p>
     *
     * @return the 1:已开票
     */
    public java.lang.String getIsInvoice() {
        return isInvoice;
    }

    /**
     * <p>1:已开票。</p>
     *
     * @param isInvoice 1:已开票。
     */
    public void setIsInvoice(java.lang.String isInvoice) {
        this.isInvoice = isInvoice;
    }

    /**
     * <p>退货处理人名称。</p>
     *
     * @return the 退货处理人名称
     */
    public java.lang.String getReturnActor() {
        return returnActor;
    }

    /**
     * <p>退货处理人名称。</p>
     *
     * @param returnActor 退货处理人名称。
     */
    public void setReturnActor(java.lang.String returnActor) {
        this.returnActor = returnActor;
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

    /**
     * <p>直销员。</p>
     *
     * @return the 直销员
     */
    public java.lang.String getSellers() {
        return sellers;
    }

    /**
     * <p>直销员。</p>
     *
     * @param sellers 直销员。
     */
    public void setSellers(java.lang.String sellers) {
        this.sellers = sellers;
    }

    /**
     * <p>呼叫中心下单时候下单人名称。</p>
     *
     * @return the 呼叫中心下单时候下单人名称
     */
    public java.lang.String getOrderTaker() {
        return orderTaker;
    }

    /**
     * <p>呼叫中心下单时候下单人名称。</p>
     *
     * @param orderTaker 呼叫中心下单时候下单人名称。
     */
    public void setOrderTaker(java.lang.String orderTaker) {
        this.orderTaker = orderTaker;
    }

    /**
     * <p>取消原因。</p>
     *
     * @return the 取消原因
     */
    public java.lang.String getCancelReason() {
        return cancelReason;
    }

    /**
     * <p>取消原因。</p>
     *
     * @param cancelReason 取消原因。
     */
    public void setCancelReason(java.lang.String cancelReason) {
        this.cancelReason = cancelReason;
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

}
