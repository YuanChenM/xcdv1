/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;

/**
 * <p>表so_return对应的SoReturn。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoReturn extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 退货单ID
     */
    private java.lang.Long returnId;
    /**
     * 退货单编码
     */
    private java.lang.String returnCode;
    /**
     * 订单ID
     */
    private java.lang.Long orderId;
    /**
     * 订单编码
     */
    private java.lang.String orderCode;
    /**
     * 买家编码冗余
     */
    private java.lang.String buyersCode;
    /**
     * 买家名称,冗余
     */
    private java.lang.String buyersName;
    /**
     * 卖家编码,冗余
     */
    private java.lang.String sellerCode;
    /**
     * 卖家名称,冗余
     */
    private java.lang.String sellerName;
    /**
     * 订单所属物流区域,冗余
     */
    private java.lang.String districtCode;
    /**
     * 退货单系统来源-CodeMaster
     * 1-司机PDA，2-云冻品平台，3-云冻品B2B平台
     */
    private java.lang.Integer returnSource;
    /**
     * 退货单类型-CodeMaster
     * 1-迟收；2-拒收；3-退货
     */
    private java.lang.String returnType;
    /**
     * 退货方式-CodeMaster，1：全部 2：部分
     */
    private java.lang.String returnMode;
    /**
     * 退货总金额
     */
    private java.math.BigDecimal returnAmount;
    /**
     * 退货原因ID
     */
    private java.lang.Integer returnReason;
    /**
     * 退货申请人
     */
    private java.lang.String applyMan;
    /**
     * 退货申请时间
     */
    private java.util.Date applyTime;
    /**
     * 退货备注
     */
    private java.lang.String applyRemark;
    /**
     * 收货人名称
     */
    private java.lang.String receiverName;
    /**
     * 收货人电话
     */
    private java.lang.String receiverTel;
    /**
     * 1:已付款
     */
    private java.lang.String isPaid;
    /**
     * 退款方式（暂留）
     */
    private java.lang.String refundMode;
    /**
     * 1:已开票（暂留）
     */
    private java.lang.String isInvoice;
    /**
     * 暂留
     */
    private java.lang.String returnActor;
    /**
     * 入库人ID
     */
    private java.lang.String inboundManId;
    /**
     * 入库人名称
     */
    private java.lang.String inboundManName;
    /**
     * 入库时间
     */
    private java.util.Date inboundTime;
    /**
     * 退货状态，CodeMaster
     */
    private java.lang.Integer returnStatus;
    /**
     * 直销员（暂留）
     */
    private java.lang.String sellers;
    /**
     * 订单员（暂留）
     */
    private java.lang.String orderTaker;
    /**
     * 取消原因
     */
    private java.lang.String cancelReason;
    /**
     * 退货原因照片1
     */
    private java.lang.String image1;
    /**
     * 退货原因照片2
     */
    private java.lang.String image2;
    /**
     * 退货原因照片3
     */
    private java.lang.String image3;
    /**
     * 退货原因照片4
     */
    private java.lang.String image4;
    /**
     * 退货原因照片5
     */
    private java.lang.String image5;
    /**
     * 退货角色
     */
    private java.lang.String roleType;
    /**
     * 退货买家ID
     */
    private java.lang.String buyersId;

    /**
     * <p>默认构造函数。</p>
     */
    public SoReturn() {

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
     * <p>订单编码。</p>
     *
     * @return the 订单编码
     */
    public java.lang.String getOrderCode() {
        return orderCode;
    }

    /**
     * <p>订单编码。</p>
     *
     * @param orderCode 订单编码。
     */
    public void setOrderCode(java.lang.String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * <p>买家编码冗余。</p>
     *
     * @return the 买家编码冗余
     */
    public java.lang.String getBuyersCode() {
        return buyersCode;
    }

    /**
     * <p>买家编码冗余。</p>
     *
     * @param buyersCode 买家编码冗余。
     */
    public void setBuyersCode(java.lang.String buyersCode) {
        this.buyersCode = buyersCode;
    }

    /**
     * <p>买家名称,冗余。</p>
     *
     * @return the 买家名称,冗余
     */
    public java.lang.String getBuyersName() {
        return buyersName;
    }

    /**
     * <p>买家名称,冗余。</p>
     *
     * @param buyersName 买家名称,冗余。
     */
    public void setBuyersName(java.lang.String buyersName) {
        this.buyersName = buyersName;
    }

    /**
     * <p>卖家编码,冗余。</p>
     *
     * @return the 卖家编码,冗余
     */
    public java.lang.String getSellerCode() {
        return sellerCode;
    }

    /**
     * <p>卖家编码,冗余。</p>
     *
     * @param sellerCode 卖家编码,冗余。
     */
    public void setSellerCode(java.lang.String sellerCode) {
        this.sellerCode = sellerCode;
    }

    /**
     * <p>卖家名称,冗余。</p>
     *
     * @return the 卖家名称,冗余
     */
    public java.lang.String getSellerName() {
        return sellerName;
    }

    /**
     * <p>卖家名称,冗余。</p>
     *
     * @param sellerName 卖家名称,冗余。
     */
    public void setSellerName(java.lang.String sellerName) {
        this.sellerName = sellerName;
    }

    /**
     * <p>订单所属物流区域,冗余。</p>
     *
     * @return the 订单所属物流区域,冗余
     */
    public java.lang.String getDistrictCode() {
        return districtCode;
    }

    /**
     * <p>订单所属物流区域,冗余。</p>
     *
     * @param districtCode 订单所属物流区域,冗余。
     */
    public void setDistrictCode(java.lang.String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * <p>退货单系统来源-CodeMaster
     * 1-司机PDA，2-云冻品平台，3-云冻品B2B平台。</p>
     *
     * @return the 退货单系统来源-CodeMaster
     * 1-司机PDA，2-云冻品平台，3-云冻品B2B平台
     */
    public java.lang.Integer getReturnSource() {
        return returnSource;
    }

    /**
     * <p>退货单系统来源-CodeMaster
     * 1-司机PDA，2-云冻品平台，3-云冻品B2B平台。</p>
     *
     * @param returnSource 退货单系统来源-CodeMaster
     *                     1-司机PDA，2-云冻品平台，3-云冻品B2B平台。
     */
    public void setReturnSource(java.lang.Integer returnSource) {
        this.returnSource = returnSource;
    }

    /**
     * <p>退货单类型-CodeMaster
     * 1-迟收；2-拒收；3-退货。</p>
     *
     * @return the 退货单类型-CodeMaster
     * 1-迟收；2-拒收；3-退货
     */
    public java.lang.String getReturnType() {
        return returnType;
    }

    /**
     * <p>退货单类型-CodeMaster
     * 1-迟收；2-拒收；3-退货。</p>
     *
     * @param returnType 退货单类型-CodeMaster
     *                   1-迟收；2-拒收；3-退货。
     */
    public void setReturnType(java.lang.String returnType) {
        this.returnType = returnType;
    }

    /**
     * <p>退货方式-CodeMaster，1：全部 2：部分。</p>
     *
     * @return the 退货方式-CodeMaster，1：全部 2：部分
     */
    public java.lang.String getReturnMode() {
        return returnMode;
    }

    /**
     * <p>退货方式-CodeMaster，1：全部 2：部分。</p>
     *
     * @param returnMode 退货方式-CodeMaster，1：全部 2：部分。
     */
    public void setReturnMode(java.lang.String returnMode) {
        this.returnMode = returnMode;
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
     * <p>退货原因ID。</p>
     *
     * @return the 退货原因ID
     */
    public java.lang.Integer getReturnReason() {
        return returnReason;
    }

    /**
     * <p>退货原因ID。</p>
     *
     * @param returnReason 退货原因ID。
     */
    public void setReturnReason(java.lang.Integer returnReason) {
        this.returnReason = returnReason;
    }

    /**
     * <p>退货申请人。</p>
     *
     * @return the 退货申请人
     */
    public java.lang.String getApplyMan() {
        return applyMan;
    }

    /**
     * <p>退货申请人。</p>
     *
     * @param applyMan 退货申请人。
     */
    public void setApplyMan(java.lang.String applyMan) {
        this.applyMan = applyMan;
    }

    /**
     * <p>退货申请时间。</p>
     *
     * @return the 退货申请时间
     */
    public java.util.Date getApplyTime() {
        return applyTime;
    }

    /**
     * <p>退货申请时间。</p>
     *
     * @param applyTime 退货申请时间。
     */
    public void setApplyTime(java.util.Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * <p>退货备注。</p>
     *
     * @return the 退货备注
     */
    public java.lang.String getApplyRemark() {
        return applyRemark;
    }

    /**
     * <p>退货备注。</p>
     *
     * @param applyRemark 退货备注。
     */
    public void setApplyRemark(java.lang.String applyRemark) {
        this.applyRemark = applyRemark;
    }

    /**
     * <p>收货人名称。</p>
     *
     * @return the 收货人名称
     */
    public java.lang.String getReceiverName() {
        return receiverName;
    }

    /**
     * <p>收货人名称。</p>
     *
     * @param receiverName 收货人名称。
     */
    public void setReceiverName(java.lang.String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * <p>收货人电话。</p>
     *
     * @return the 收货人电话
     */
    public java.lang.String getReceiverTel() {
        return receiverTel;
    }

    /**
     * <p>收货人电话。</p>
     *
     * @param receiverTel 收货人电话。
     */
    public void setReceiverTel(java.lang.String receiverTel) {
        this.receiverTel = receiverTel;
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
     * <p>退款方式（暂留）。</p>
     *
     * @return the 退款方式（暂留）
     */
    public java.lang.String getRefundMode() {
        return refundMode;
    }

    /**
     * <p>退款方式（暂留）。</p>
     *
     * @param refundMode 退款方式（暂留）。
     */
    public void setRefundMode(java.lang.String refundMode) {
        this.refundMode = refundMode;
    }

    /**
     * <p>1:已开票（暂留）。</p>
     *
     * @return the 1:已开票（暂留）
     */
    public java.lang.String getIsInvoice() {
        return isInvoice;
    }

    /**
     * <p>1:已开票（暂留）。</p>
     *
     * @param isInvoice 1:已开票（暂留）。
     */
    public void setIsInvoice(java.lang.String isInvoice) {
        this.isInvoice = isInvoice;
    }

    /**
     * <p>暂留。</p>
     *
     * @return the 暂留
     */
    public java.lang.String getReturnActor() {
        return returnActor;
    }

    /**
     * <p>暂留。</p>
     *
     * @param returnActor 暂留。
     */
    public void setReturnActor(java.lang.String returnActor) {
        this.returnActor = returnActor;
    }

    /**
     * <p>入库人ID。</p>
     *
     * @return the 入库人ID
     */
    public java.lang.String getInboundManId() {
        return inboundManId;
    }

    /**
     * <p>入库人ID。</p>
     *
     * @param inboundManId 入库人ID。
     */
    public void setInboundManId(java.lang.String inboundManId) {
        this.inboundManId = inboundManId;
    }

    /**
     * <p>入库人名称。</p>
     *
     * @return the 入库人名称
     */
    public java.lang.String getInboundManName() {
        return inboundManName;
    }

    /**
     * <p>入库人名称。</p>
     *
     * @param inboundManName 入库人名称。
     */
    public void setInboundManName(java.lang.String inboundManName) {
        this.inboundManName = inboundManName;
    }

    /**
     * <p>入库时间。</p>
     *
     * @return the 入库时间
     */
    public java.util.Date getInboundTime() {
        return inboundTime;
    }

    /**
     * <p>入库时间。</p>
     *
     * @param inboundTime 入库时间。
     */
    public void setInboundTime(java.util.Date inboundTime) {
        this.inboundTime = inboundTime;
    }

    /**
     * <p>退货状态，CodeMaster。</p>
     *
     * @return the 退货状态，CodeMaster
     */
    public java.lang.Integer getReturnStatus() {
        return returnStatus;
    }

    /**
     * <p>退货状态，CodeMaster。</p>
     *
     * @param returnStatus 退货状态，CodeMaster。
     */
    public void setReturnStatus(java.lang.Integer returnStatus) {
        this.returnStatus = returnStatus;
    }

    /**
     * <p>直销员（暂留）。</p>
     *
     * @return the 直销员（暂留）
     */
    public java.lang.String getSellers() {
        return sellers;
    }

    /**
     * <p>直销员（暂留）。</p>
     *
     * @param sellers 直销员（暂留）。
     */
    public void setSellers(java.lang.String sellers) {
        this.sellers = sellers;
    }

    /**
     * <p>订单员（暂留）。</p>
     *
     * @return the 订单员（暂留）
     */
    public java.lang.String getOrderTaker() {
        return orderTaker;
    }

    /**
     * <p>订单员（暂留）。</p>
     *
     * @param orderTaker 订单员（暂留）。
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
     * <p>退货原因照片1。</p>
     *
     * @return the 退货原因照片1
     */
    public java.lang.String getImage1() {
        return image1;
    }

    /**
     * <p>退货原因照片1。</p>
     *
     * @param image1 退货原因照片1。
     */
    public void setImage1(java.lang.String image1) {
        this.image1 = image1;
    }

    /**
     * <p>退货原因照片2。</p>
     *
     * @return the 退货原因照片2
     */
    public java.lang.String getImage2() {
        return image2;
    }

    /**
     * <p>退货原因照片2。</p>
     *
     * @param image2 退货原因照片2。
     */
    public void setImage2(java.lang.String image2) {
        this.image2 = image2;
    }

    /**
     * <p>退货原因照片3。</p>
     *
     * @return the 退货原因照片3
     */
    public java.lang.String getImage3() {
        return image3;
    }

    /**
     * <p>退货原因照片3。</p>
     *
     * @param image3 退货原因照片3。
     */
    public void setImage3(java.lang.String image3) {
        this.image3 = image3;
    }

    /**
     * <p>退货原因照片4。</p>
     *
     * @return the 退货原因照片4
     */
    public java.lang.String getImage4() {
        return image4;
    }

    /**
     * <p>退货原因照片4。</p>
     *
     * @param image4 退货原因照片4。
     */
    public void setImage4(java.lang.String image4) {
        this.image4 = image4;
    }

    /**
     * <p>退货原因照片5。</p>
     *
     * @return the 退货原因照片5
     */
    public java.lang.String getImage5() {
        return image5;
    }

    /**
     * <p>退货原因照片5。</p>
     *
     * @param image5 退货原因照片5。
     */
    public void setImage5(java.lang.String image5) {
        this.image5 = image5;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getBuyersId() {
        return buyersId;
    }

    public void setBuyersId(String buyersId) {
        this.buyersId = buyersId;
    }
}

