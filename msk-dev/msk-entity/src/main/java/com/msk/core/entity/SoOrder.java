/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_order对应的SoOrder。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoOrder extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 订单ID */
    private java.lang.Long orderId;
    /** 订单编码 */
    private java.lang.String orderCode;
    /** 订单辅码（时间编码) */
    private java.lang.String orderViceCode;
    /** 购物意愿ID */
    private java.lang.Long proId;
    /** 购物意愿编码 */
    private java.lang.String proCode;
    /** 需求订单编码 */
    private java.lang.String requireOrderCode;
    /** 确认订单编码 */
    private java.lang.String confirmOrderCode;
    /** 配送订单编码 */
    private java.lang.String deliveryOrderCode;
    /** 卖家编码 */
    private java.lang.String sellerCode;
    /** 卖家名称 */
    private java.lang.String sellerName;
    /** 买家ID */
    private java.lang.String buyersId;
    /** 买家编码 */
    private java.lang.String buyersCode;
    /** 买家名称 */
    private java.lang.String buyersName;
    /** 1:分销买家,2:菜场买家,3:团膳买家,4:火锅买家,5:中餐买家,6:西餐买家,7:小吃烧烤买家,8:加工厂买家 */
    private java.lang.Integer buyersType;
    /** 是否开票 */
    private java.lang.String needInvoice;
    /** 订单所属区域 */
    private java.lang.String districtCode;
    /** 对应系统编码 */
    private java.lang.Integer orderSource;
    /** 1:分销,2:第三方,3:大促会 */
    private java.lang.Integer orderType;
    /** 订单创建时间 */
    private java.util.Date orderTime;
    /** 订单总金额 */
    private java.math.BigDecimal orderAmount;
    /** 1:在线支付,2:线下支付 */
    private java.lang.Integer paymentType;
    /** 直销员 */
    private java.lang.String sellers;
    /** 订单员 */
    private java.lang.String orderTaker;
    /** ORDER_TAKER_TYPE */
    private java.lang.Integer orderTakerType;
    /** 是否自配送 */
    private java.lang.String selfDeliveryFlg;
    /** 0:不分批,1:发生分批,2:买家同意分批,3:买家确认取消 */
    private java.lang.String splitDeliveryFlg;
    /** 回收站标志 */
    private java.lang.String dustbinFlg;
    /** 退货标志 */
    private java.lang.String returnFlg;
    /** 订单发货时间 */
    private java.util.Date orderSendTime;
    /** 订单收货时间 */
    private java.util.Date orderReceiveTime;
    /** 1.买家取消 2.不同意拼货的取消 3.不同意分批的取消 */
    private java.lang.Integer cancelType;
    /** 取消原因 */
    private java.lang.String cancelReason;
    /** 订单状态 */
    private java.lang.Integer orderStatus;
    /**
     * <p>默认构造函数。</p>
     */
    public SoOrder() {

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
     * <p>订单辅码（时间编码)。</p>
     *
     * @return the 订单辅码（时间编码)
     */
    public java.lang.String getOrderViceCode() {
        return orderViceCode;
    }

    /**
     * <p>订单辅码（时间编码)。</p>
     *
     * @param orderViceCode 订单辅码（时间编码)。
     */
    public void setOrderViceCode(java.lang.String orderViceCode) {
        this.orderViceCode = orderViceCode;
    }

    /**
     * <p>购物意愿ID。</p>
     *
     * @return the 购物意愿ID
     */
    public java.lang.Long getProId() {
        return proId;
    }

    /**
     * <p>购物意愿ID。</p>
     *
     * @param proId 购物意愿ID。
     */
    public void setProId(java.lang.Long proId) {
        this.proId = proId;
    }

    /**
     * <p>购物意愿编码。</p>
     *
     * @return the 购物意愿编码
     */
    public java.lang.String getProCode() {
        return proCode;
    }

    /**
     * <p>购物意愿编码。</p>
     *
     * @param proCode 购物意愿编码。
     */
    public void setProCode(java.lang.String proCode) {
        this.proCode = proCode;
    }

    /**
     * <p>需求订单编码。</p>
     *
     * @return the 需求订单编码
     */
    public java.lang.String getRequireOrderCode() {
        return requireOrderCode;
    }

    /**
     * <p>需求订单编码。</p>
     *
     * @param requireOrderCode 需求订单编码。
     */
    public void setRequireOrderCode(java.lang.String requireOrderCode) {
        this.requireOrderCode = requireOrderCode;
    }

    /**
     * <p>确认订单编码。</p>
     *
     * @return the 确认订单编码
     */
    public java.lang.String getConfirmOrderCode() {
        return confirmOrderCode;
    }

    /**
     * <p>确认订单编码。</p>
     *
     * @param confirmOrderCode 确认订单编码。
     */
    public void setConfirmOrderCode(java.lang.String confirmOrderCode) {
        this.confirmOrderCode = confirmOrderCode;
    }

    /**
     * <p>配送订单编码。</p>
     *
     * @return the 配送订单编码
     */
    public java.lang.String getDeliveryOrderCode() {
        return deliveryOrderCode;
    }

    /**
     * <p>配送订单编码。</p>
     *
     * @param deliveryOrderCode 配送订单编码。
     */
    public void setDeliveryOrderCode(java.lang.String deliveryOrderCode) {
        this.deliveryOrderCode = deliveryOrderCode;
    }

    /**
     * <p>卖家编码。</p>
     *
     * @return the 卖家编码
     */
    public java.lang.String getSellerCode() {
        return sellerCode;
    }

    /**
     * <p>卖家编码。</p>
     *
     * @param sellerCode 卖家编码。
     */
    public void setSellerCode(java.lang.String sellerCode) {
        this.sellerCode = sellerCode;
    }

    /**
     * <p>卖家名称。</p>
     *
     * @return the 卖家名称
     */
    public java.lang.String getSellerName() {
        return sellerName;
    }

    /**
     * <p>卖家名称。</p>
     *
     * @param sellerName 卖家名称。
     */
    public void setSellerName(java.lang.String sellerName) {
        this.sellerName = sellerName;
    }

    /**
     * <p>买家ID。</p>
     *
     * @return the 买家ID
     */
    public java.lang.String getBuyersId() {
        return buyersId;
    }

    /**
     * <p>买家ID。</p>
     *
     * @param buyersId 买家ID。
     */
    public void setBuyersId(java.lang.String buyersId) {
        this.buyersId = buyersId;
    }

    /**
     * <p>买家编码。</p>
     *
     * @return the 买家编码
     */
    public java.lang.String getBuyersCode() {
        return buyersCode;
    }

    /**
     * <p>买家编码。</p>
     *
     * @param buyersCode 买家编码。
     */
    public void setBuyersCode(java.lang.String buyersCode) {
        this.buyersCode = buyersCode;
    }

    /**
     * <p>买家名称。</p>
     *
     * @return the 买家名称
     */
    public java.lang.String getBuyersName() {
        return buyersName;
    }

    /**
     * <p>买家名称。</p>
     *
     * @param buyersName 买家名称。
     */
    public void setBuyersName(java.lang.String buyersName) {
        this.buyersName = buyersName;
    }

    /**
     * <p>1:分销买家,2:菜场买家,3:团膳买家,4:火锅买家,5:中餐买家,6:西餐买家,7:小吃烧烤买家,8:加工厂买家。</p>
     *
     * @return the 1:分销买家,2:菜场买家,3:团膳买家,4:火锅买家,5:中餐买家,6:西餐买家,7:小吃烧烤买家,8:加工厂买家
     */
    public java.lang.Integer getBuyersType() {
        return buyersType;
    }

    /**
     * <p>1:分销买家,2:菜场买家,3:团膳买家,4:火锅买家,5:中餐买家,6:西餐买家,7:小吃烧烤买家,8:加工厂买家。</p>
     *
     * @param buyersType 1:分销买家,2:菜场买家,3:团膳买家,4:火锅买家,5:中餐买家,6:西餐买家,7:小吃烧烤买家,8:加工厂买家。
     */
    public void setBuyersType(java.lang.Integer buyersType) {
        this.buyersType = buyersType;
    }

    /**
     * <p>是否开票。</p>
     *
     * @return the 是否开票
     */
    public java.lang.String getNeedInvoice() {
        return needInvoice;
    }

    /**
     * <p>是否开票。</p>
     *
     * @param needInvoice 是否开票。
     */
    public void setNeedInvoice(java.lang.String needInvoice) {
        this.needInvoice = needInvoice;
    }

    /**
     * <p>订单所属区域。</p>
     *
     * @return the 订单所属区域
     */
    public java.lang.String getDistrictCode() {
        return districtCode;
    }

    /**
     * <p>订单所属区域。</p>
     *
     * @param districtCode 订单所属区域。
     */
    public void setDistrictCode(java.lang.String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * <p>对应系统编码。</p>
     *
     * @return the 对应系统编码
     */
    public java.lang.Integer getOrderSource() {
        return orderSource;
    }

    /**
     * <p>对应系统编码。</p>
     *
     * @param orderSource 对应系统编码。
     */
    public void setOrderSource(java.lang.Integer orderSource) {
        this.orderSource = orderSource;
    }

    /**
     * <p>1:分销,2:第三方,3:大促会。</p>
     *
     * @return the 1:分销,2:第三方,3:大促会
     */
    public java.lang.Integer getOrderType() {
        return orderType;
    }

    /**
     * <p>1:分销,2:第三方,3:大促会。</p>
     *
     * @param orderType 1:分销,2:第三方,3:大促会。
     */
    public void setOrderType(java.lang.Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * <p>订单创建时间。</p>
     *
     * @return the 订单创建时间
     */
    public java.util.Date getOrderTime() {
        return orderTime;
    }

    /**
     * <p>订单创建时间。</p>
     *
     * @param orderTime 订单创建时间。
     */
    public void setOrderTime(java.util.Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * <p>订单总金额。</p>
     *
     * @return the 订单总金额
     */
    public java.math.BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * <p>订单总金额。</p>
     *
     * @param orderAmount 订单总金额。
     */
    public void setOrderAmount(java.math.BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * <p>1:在线支付,2:线下支付。</p>
     *
     * @return the 1:在线支付,2:线下支付
     */
    public java.lang.Integer getPaymentType() {
        return paymentType;
    }

    /**
     * <p>1:在线支付,2:线下支付。</p>
     *
     * @param paymentType 1:在线支付,2:线下支付。
     */
    public void setPaymentType(java.lang.Integer paymentType) {
        this.paymentType = paymentType;
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
     * <p>订单员。</p>
     *
     * @return the 订单员
     */
    public java.lang.String getOrderTaker() {
        return orderTaker;
    }

    /**
     * <p>订单员。</p>
     *
     * @param orderTaker 订单员。
     */
    public void setOrderTaker(java.lang.String orderTaker) {
        this.orderTaker = orderTaker;
    }

    /**
     * <p>ORDER_TAKER_TYPE。</p>
     *
     * @return the ORDER_TAKER_TYPE
     */
    public java.lang.Integer getOrderTakerType() {
        return orderTakerType;
    }

    /**
     * <p>ORDER_TAKER_TYPE。</p>
     *
     * @param orderTakerType ORDER_TAKER_TYPE。
     */
    public void setOrderTakerType(java.lang.Integer orderTakerType) {
        this.orderTakerType = orderTakerType;
    }

    /**
     * <p>是否自配送。</p>
     *
     * @return the 是否自配送
     */
    public java.lang.String getSelfDeliveryFlg() {
        return selfDeliveryFlg;
    }

    /**
     * <p>是否自配送。</p>
     *
     * @param selfDeliveryFlg 是否自配送。
     */
    public void setSelfDeliveryFlg(java.lang.String selfDeliveryFlg) {
        this.selfDeliveryFlg = selfDeliveryFlg;
    }

    /**
     * <p>0:不分批,1:发生分批,2:买家同意分批,3:买家确认取消。</p>
     *
     * @return the 0:不分批,1:发生分批,2:买家同意分批,3:买家确认取消
     */
    public java.lang.String getSplitDeliveryFlg() {
        return splitDeliveryFlg;
    }

    /**
     * <p>0:不分批,1:发生分批,2:买家同意分批,3:买家确认取消。</p>
     *
     * @param splitDeliveryFlg 0:不分批,1:发生分批,2:买家同意分批,3:买家确认取消。
     */
    public void setSplitDeliveryFlg(java.lang.String splitDeliveryFlg) {
        this.splitDeliveryFlg = splitDeliveryFlg;
    }

    /**
     * <p>回收站标志。</p>
     *
     * @return the 回收站标志
     */
    public java.lang.String getDustbinFlg() {
        return dustbinFlg;
    }

    /**
     * <p>回收站标志。</p>
     *
     * @param dustbinFlg 回收站标志。
     */
    public void setDustbinFlg(java.lang.String dustbinFlg) {
        this.dustbinFlg = dustbinFlg;
    }

    /**
     * <p>退货标志。</p>
     *
     * @return the 退货标志
     */
    public java.lang.String getReturnFlg() {
        return returnFlg;
    }

    /**
     * <p>退货标志。</p>
     *
     * @param returnFlg 退货标志。
     */
    public void setReturnFlg(java.lang.String returnFlg) {
        this.returnFlg = returnFlg;
    }

    /**
     * <p>订单发货时间。</p>
     *
     * @return the 订单发货时间
     */
    public java.util.Date getOrderSendTime() {
        return orderSendTime;
    }

    /**
     * <p>订单发货时间。</p>
     *
     * @param orderSendTime 订单发货时间。
     */
    public void setOrderSendTime(java.util.Date orderSendTime) {
        this.orderSendTime = orderSendTime;
    }

    /**
     * <p>订单收货时间。</p>
     *
     * @return the 订单收货时间
     */
    public java.util.Date getOrderReceiveTime() {
        return orderReceiveTime;
    }

    /**
     * <p>订单收货时间。</p>
     *
     * @param orderReceiveTime 订单收货时间。
     */
    public void setOrderReceiveTime(java.util.Date orderReceiveTime) {
        this.orderReceiveTime = orderReceiveTime;
    }

    /**
     * <p>1.买家取消 2.不同意拼货的取消 3.不同意分批的取消。</p>
     *
     * @return the 1.买家取消 2.不同意拼货的取消 3.不同意分批的取消
     */
    public java.lang.Integer getCancelType() {
        return cancelType;
    }

    /**
     * <p>1.买家取消 2.不同意拼货的取消 3.不同意分批的取消。</p>
     *
     * @param cancelType 1.买家取消 2.不同意拼货的取消 3.不同意分批的取消。
     */
    public void setCancelType(java.lang.Integer cancelType) {
        this.cancelType = cancelType;
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
     * <p>订单状态。</p>
     *
     * @return the 订单状态
     */
    public java.lang.Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * <p>订单状态。</p>
     *
     * @param orderStatus 订单状态。
     */
    public void setOrderStatus(java.lang.Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

}
