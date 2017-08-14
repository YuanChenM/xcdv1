/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.batch.wq.entity;

import com.msk.core.entity.BaseEntity;

/**
 * <p>表wq_order对应的WqOrder。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class WqOrder extends BaseEntity {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 表格ID */
    private Long tblId;
    /** 外勤超级表单ID */
    private String wqId;
    /** 订单ID */
    private Long orderId;
    /** 订单编码 */
    private String orderCode;
    /** 订单创建时间 */
    private String orderTime;
    /** 买家ID */
    private String buyerId;
    /** 买家名称 */
    private String buyerName;
    /** 卖家编码 */
    private String sellerCode;
    /** 卖家名称 */
    private String sellerName;
    /** 订单状态 */
    private String orderStauts;
    /** 订单总金额 */
    private java.math.BigDecimal orderAmount;
    /** 订单类型 */
    private String orderType;
    /** 订单物流区 */
    private String orderDistrict;
    /** 付款类型 */
    private String paymentType;
    /** 支付金额 */
    private java.math.BigDecimal paidAmount;
    /** 支付时间 */
    private String paidTime;
    /** 收货人名称 */
    private String receiverName;
    /** 收货人电话 */
    private String receiverTel;
    /** 收货人省份 */
    private String receiverProvince;
    /** 收货人城市 */
    private String receiverCity;
    /** 收货人区县 */
    private String receiverDistrict;
    /** 收货人详细地址 */
    private String receiverAddr;
    /** 习惯收货时间段 */
    private String receiverTime;
    /** 习惯最早收货时间段 */
    private String receiverEarly;
    /** 习惯最晚收货时间段 */
    private String receiverLast;
    /** 备注1 */
    private String memo1;
    /** 备注2 */
    private String memo2;
    /** 备注3 */
    private String memo3;
    /** 备注4 */
    private String memo4;
    /** 备注5 */
    private String memo5;
    /** 备注6 */
    private String memo6;
    /**
     * <p>默认构造函数。</p>
     */
    public WqOrder() {

    }

    /**
     * <p>表格ID。</p>
     *
     * @return the 表格ID
     */
    public Long getTblId() {
        return tblId;
    }

    /**
     * <p>表格ID。</p>
     *
     * @param tblId 表格ID。
     */
    public void setTblId(Long tblId) {
        this.tblId = tblId;
    }

    /**
     * <p>外勤超级表单ID。</p>
     *
     * @return the 外勤超级表单ID
     */
    public String getWqId() {
        return wqId;
    }

    /**
     * <p>外勤超级表单ID。</p>
     *
     * @param wqId 外勤超级表单ID。
     */
    public void setWqId(String wqId) {
        this.wqId = wqId;
    }

    /**
     * <p>订单ID。</p>
     *
     * @return the 订单ID
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * <p>订单ID。</p>
     *
     * @param orderId 订单ID。
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * <p>订单编码。</p>
     *
     * @return the 订单编码
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * <p>订单编码。</p>
     *
     * @param orderCode 订单编码。
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * <p>订单创建时间。</p>
     *
     * @return the 订单创建时间
     */
    public String getOrderTime() {
        return orderTime;
    }

    /**
     * <p>订单创建时间。</p>
     *
     * @param orderTime 订单创建时间。
     */
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * <p>买家ID。</p>
     *
     * @return the 买家ID
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * <p>买家ID。</p>
     *
     * @param buyerId 买家ID。
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * <p>买家名称。</p>
     *
     * @return the 买家名称
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * <p>买家名称。</p>
     *
     * @param buyerName 买家名称。
     */
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    /**
     * <p>卖家编码。</p>
     *
     * @return the 卖家编码
     */
    public String getSellerCode() {
        return sellerCode;
    }

    /**
     * <p>卖家编码。</p>
     *
     * @param sellerCode 卖家编码。
     */
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    /**
     * <p>卖家名称。</p>
     *
     * @return the 卖家名称
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * <p>卖家名称。</p>
     *
     * @param sellerName 卖家名称。
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    /**
     * <p>订单状态。</p>
     *
     * @return the 订单状态
     */
    public String getOrderStauts() {
        return orderStauts;
    }

    /**
     * <p>订单状态。</p>
     *
     * @param orderStauts 订单状态。
     */
    public void setOrderStauts(String orderStauts) {
        this.orderStauts = orderStauts;
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
     * <p>订单类型。</p>
     *
     * @return the 订单类型
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * <p>订单类型。</p>
     *
     * @param orderType 订单类型。
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * <p>订单物流区。</p>
     *
     * @return the 订单物流区
     */
    public String getOrderDistrict() {
        return orderDistrict;
    }

    /**
     * <p>订单物流区。</p>
     *
     * @param orderDistrict 订单物流区。
     */
    public void setOrderDistrict(String orderDistrict) {
        this.orderDistrict = orderDistrict;
    }

    /**
     * <p>付款类型。</p>
     *
     * @return the 付款类型
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * <p>付款类型。</p>
     *
     * @param paymentType 付款类型。
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * <p>支付金额。</p>
     *
     * @return the 支付金额
     */
    public java.math.BigDecimal getPaidAmount() {
        return paidAmount;
    }

    /**
     * <p>支付金额。</p>
     *
     * @param paidAmount 支付金额。
     */
    public void setPaidAmount(java.math.BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    /**
     * <p>支付时间。</p>
     *
     * @return the 支付时间
     */
    public String getPaidTime() {
        return paidTime;
    }

    /**
     * <p>支付时间。</p>
     *
     * @param paidTime 支付时间。
     */
    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
    }

    /**
     * <p>收货人名称。</p>
     *
     * @return the 收货人名称
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * <p>收货人名称。</p>
     *
     * @param receiverName 收货人名称。
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * <p>收货人电话。</p>
     *
     * @return the 收货人电话
     */
    public String getReceiverTel() {
        return receiverTel;
    }

    /**
     * <p>收货人电话。</p>
     *
     * @param receiverTel 收货人电话。
     */
    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }

    /**
     * <p>收货人省份。</p>
     *
     * @return the 收货人省份
     */
    public String getReceiverProvince() {
        return receiverProvince;
    }

    /**
     * <p>收货人省份。</p>
     *
     * @param receiverProvince 收货人省份。
     */
    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    /**
     * <p>收货人城市。</p>
     *
     * @return the 收货人城市
     */
    public String getReceiverCity() {
        return receiverCity;
    }

    /**
     * <p>收货人城市。</p>
     *
     * @param receiverCity 收货人城市。
     */
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    /**
     * <p>收货人区县。</p>
     *
     * @return the 收货人区县
     */
    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    /**
     * <p>收货人区县。</p>
     *
     * @param receiverDistrict 收货人区县。
     */
    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    /**
     * <p>收货人详细地址。</p>
     *
     * @return the 收货人详细地址
     */
    public String getReceiverAddr() {
        return receiverAddr;
    }

    /**
     * <p>收货人详细地址。</p>
     *
     * @param receiverAddr 收货人详细地址。
     */
    public void setReceiverAddr(String receiverAddr) {
        this.receiverAddr = receiverAddr;
    }

    /**
     * <p>习惯收货时间段。</p>
     *
     * @return the 习惯收货时间段
     */
    public String getReceiverTime() {
        return receiverTime;
    }

    /**
     * <p>习惯收货时间段。</p>
     *
     * @param receiverTime 习惯收货时间段。
     */
    public void setReceiverTime(String receiverTime) {
        this.receiverTime = receiverTime;
    }

    /**
     * <p>习惯最早收货时间段。</p>
     *
     * @return the 习惯最早收货时间段
     */
    public String getReceiverEarly() {
        return receiverEarly;
    }

    /**
     * <p>习惯最早收货时间段。</p>
     *
     * @param receiverEarly 习惯最早收货时间段。
     */
    public void setReceiverEarly(String receiverEarly) {
        this.receiverEarly = receiverEarly;
    }

    /**
     * <p>习惯最晚收货时间段。</p>
     *
     * @return the 习惯最晚收货时间段
     */
    public String getReceiverLast() {
        return receiverLast;
    }

    /**
     * <p>习惯最晚收货时间段。</p>
     *
     * @param receiverLast 习惯最晚收货时间段。
     */
    public void setReceiverLast(String receiverLast) {
        this.receiverLast = receiverLast;
    }

    /**
     * <p>备注1。</p>
     *
     * @return the 备注1
     */
    public String getMemo1() {
        return memo1;
    }

    /**
     * <p>备注1。</p>
     *
     * @param memo1 备注1。
     */
    public void setMemo1(String memo1) {
        this.memo1 = memo1;
    }

    /**
     * <p>备注2。</p>
     *
     * @return the 备注2
     */
    public String getMemo2() {
        return memo2;
    }

    /**
     * <p>备注2。</p>
     *
     * @param memo2 备注2。
     */
    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }

    /**
     * <p>备注3。</p>
     *
     * @return the 备注3
     */
    public String getMemo3() {
        return memo3;
    }

    /**
     * <p>备注3。</p>
     *
     * @param memo3 备注3。
     */
    public void setMemo3(String memo3) {
        this.memo3 = memo3;
    }

    /**
     * <p>备注4。</p>
     *
     * @return the 备注4
     */
    public String getMemo4() {
        return memo4;
    }

    /**
     * <p>备注4。</p>
     *
     * @param memo4 备注4。
     */
    public void setMemo4(String memo4) {
        this.memo4 = memo4;
    }

    /**
     * <p>备注5。</p>
     *
     * @return the 备注5
     */
    public String getMemo5() {
        return memo5;
    }

    /**
     * <p>备注5。</p>
     *
     * @param memo5 备注5。
     */
    public void setMemo5(String memo5) {
        this.memo5 = memo5;
    }

    /**
     * <p>备注6。</p>
     *
     * @return the 备注6
     */
    public String getMemo6() {
        return memo6;
    }

    /**
     * <p>备注6。</p>
     *
     * @param memo6 备注6。
     */
    public void setMemo6(String memo6) {
        this.memo6 = memo6;
    }

}
