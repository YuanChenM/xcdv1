/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_order_detail_price对应的SoOrderDetailPrice。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoOrderDetailPrice extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 序列号 */
    private Long priceSn;
    /** 客户系统编码 */
    private String siteCode;
    /** 请求用户身份 */
    private String loginAuth;
    /** 请求用户ID */
    private String loginId;
    /** 查询时间 */
    private java.util.Date queryTime;
    /** 发货单ID */
    private Long shipId;
    /** 订单ID */
    private Long orderId;
    /** 支付规则 */
    private Integer paymentId;
    /** 订单明细ID */
    private Long orderDetailId;
    /** 发货日期 */
    private java.util.Date proDate;
    /** 产品编码 */
    private String pdCode;
    /** SKU编码 */
    private String skuCode;
    /** 订单明细数量 */
    private java.math.BigDecimal orderQty;
    /** 通道等级 */
    private Integer orderLevel;
    /** 通道开始箱数 */
    private Integer levelStart;
    /** 通道截止箱数 */
    private Integer levelEnd;
    /** 通道价格 */
    private java.math.BigDecimal levelPrice;
    /**
     * <p>默认构造函数。</p>
     */
    public SoOrderDetailPrice() {

    }

    /**
     * <p>序列号。</p>
     *
     * @return the 序列号
     */
    public Long getPriceSn() {
        return priceSn;
    }

    /**
     * <p>序列号。</p>
     *
     * @param priceSn 序列号。
     */
    public void setPriceSn(Long priceSn) {
        this.priceSn = priceSn;
    }

    /**
     * <p>客户系统编码。</p>
     *
     * @return the 客户系统编码
     */
    public String getSiteCode() {
        return siteCode;
    }

    /**
     * <p>客户系统编码。</p>
     *
     * @param siteCode 客户系统编码。
     */
    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    /**
     * <p>请求用户身份。</p>
     *
     * @return the 请求用户身份
     */
    public String getLoginAuth() {
        return loginAuth;
    }

    /**
     * <p>请求用户身份。</p>
     *
     * @param loginAuth 请求用户身份。
     */
    public void setLoginAuth(String loginAuth) {
        this.loginAuth = loginAuth;
    }

    /**
     * <p>请求用户ID。</p>
     *
     * @return the 请求用户ID
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * <p>请求用户ID。</p>
     *
     * @param loginId 请求用户ID。
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * <p>查询时间。</p>
     *
     * @return the 查询时间
     */
    public java.util.Date getQueryTime() {
        return queryTime;
    }

    /**
     * <p>查询时间。</p>
     *
     * @param queryTime 查询时间。
     */
    public void setQueryTime(java.util.Date queryTime) {
        this.queryTime = queryTime;
    }

    /**
     * <p>发货单ID。</p>
     *
     * @return the 发货单ID
     */
    public Long getShipId() {
        return shipId;
    }

    /**
     * <p>发货单ID。</p>
     *
     * @param shipId 发货单ID。
     */
    public void setShipId(Long shipId) {
        this.shipId = shipId;
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
     * <p>支付规则。</p>
     *
     * @return the 支付规则
     */
    public Integer getPaymentId() {
        return paymentId;
    }

    /**
     * <p>支付规则。</p>
     *
     * @param paymentId 支付规则。
     */
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * <p>订单明细ID。</p>
     *
     * @return the 订单明细ID
     */
    public Long getOrderDetailId() {
        return orderDetailId;
    }

    /**
     * <p>订单明细ID。</p>
     *
     * @param orderDetailId 订单明细ID。
     */
    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    /**
     * <p>发货日期。</p>
     *
     * @return the 发货日期
     */
    public java.util.Date getProDate() {
        return proDate;
    }

    /**
     * <p>发货日期。</p>
     *
     * @param proDate 发货日期。
     */
    public void setProDate(java.util.Date proDate) {
        this.proDate = proDate;
    }

    /**
     * <p>产品编码。</p>
     *
     * @return the 产品编码
     */
    public String getPdCode() {
        return pdCode;
    }

    /**
     * <p>产品编码。</p>
     *
     * @param pdCode 产品编码。
     */
    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    /**
     * <p>SKU编码。</p>
     *
     * @return the SKU编码
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * <p>SKU编码。</p>
     *
     * @param skuCode SKU编码。
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    /**
     * <p>订单明细数量。</p>
     *
     * @return the 订单明细数量
     */
    public java.math.BigDecimal getOrderQty() {
        return orderQty;
    }

    /**
     * <p>订单明细数量。</p>
     *
     * @param orderQty 订单明细数量。
     */
    public void setOrderQty(java.math.BigDecimal orderQty) {
        this.orderQty = orderQty;
    }

    /**
     * <p>通道等级。</p>
     *
     * @return the 通道等级
     */
    public Integer getOrderLevel() {
        return orderLevel;
    }

    /**
     * <p>通道等级。</p>
     *
     * @param orderLevel 通道等级。
     */
    public void setOrderLevel(Integer orderLevel) {
        this.orderLevel = orderLevel;
    }

    /**
     * <p>通道开始箱数。</p>
     *
     * @return the 通道开始箱数
     */
    public Integer getLevelStart() {
        return levelStart;
    }

    /**
     * <p>通道开始箱数。</p>
     *
     * @param levelStart 通道开始箱数。
     */
    public void setLevelStart(Integer levelStart) {
        this.levelStart = levelStart;
    }

    /**
     * <p>通道截止箱数。</p>
     *
     * @return the 通道截止箱数
     */
    public Integer getLevelEnd() {
        return levelEnd;
    }

    /**
     * <p>通道截止箱数。</p>
     *
     * @param elvelEnd 通道截止箱数。
     */
    public void setLevelEnd(Integer elvelEnd) {
        this.levelEnd = elvelEnd;
    }

    /**
     * <p>通道价格。</p>
     *
     * @return the 通道价格
     */
    public java.math.BigDecimal getLevelPrice() {
        return levelPrice;
    }

    /**
     * <p>通道价格。</p>
     *
     * @param levelPrice 通道价格。
     */
    public void setLevelPrice(java.math.BigDecimal levelPrice) {
        this.levelPrice = levelPrice;
    }

}
