/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_pro对应的SoPro。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoPro extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 意愿ID */
    private java.lang.Long proId;
    /** 意愿编码 */
    private java.lang.String proCode;
    /** 需求状态 */
    private java.lang.Integer status;
    /** 买家ID */
    private java.lang.String buyersId;
    /** 买家编码 */
    private java.lang.String buyersCode;
    /** 买家名称 */
    private java.lang.String buyersName;
    /** 买家类型 */
    private java.lang.Integer buyersType;
    /** 卖家编号 */
    private java.lang.String sellerCode;
    /** 卖家名称 */
    private java.lang.String sellerName;
    /** 订单来源 */
    private java.lang.Integer orderSource;
    /** 区域 */
    private java.lang.String districtCode;
    /** 购物意愿创建时间 */
    private java.util.Date proTime;
    /**
     * <p>默认构造函数。</p>
     */
    public SoPro() {

    }

    /**
     * <p>意愿ID。</p>
     *
     * @return the 意愿ID
     */
    public java.lang.Long getProId() {
        return proId;
    }

    /**
     * <p>意愿ID。</p>
     *
     * @param proId 意愿ID。
     */
    public void setProId(java.lang.Long proId) {
        this.proId = proId;
    }

    /**
     * <p>意愿编码。</p>
     *
     * @return the 意愿编码
     */
    public java.lang.String getProCode() {
        return proCode;
    }

    /**
     * <p>意愿编码。</p>
     *
     * @param proCode 意愿编码。
     */
    public void setProCode(java.lang.String proCode) {
        this.proCode = proCode;
    }

    /**
     * <p>需求状态。</p>
     *
     * @return the 需求状态
     */
    public java.lang.Integer getStatus() {
        return status;
    }

    /**
     * <p>需求状态。</p>
     *
     * @param status 需求状态。
     */
    public void setStatus(java.lang.Integer status) {
        this.status = status;
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
     * <p>买家类型。</p>
     *
     * @return the 买家类型
     */
    public java.lang.Integer getBuyersType() {
        return buyersType;
    }

    /**
     * <p>买家类型。</p>
     *
     * @param buyersType 买家类型。
     */
    public void setBuyersType(java.lang.Integer buyersType) {
        this.buyersType = buyersType;
    }

    /**
     * <p>卖家编号。</p>
     *
     * @return the 卖家编号
     */
    public java.lang.String getSellerCode() {
        return sellerCode;
    }

    /**
     * <p>卖家编号。</p>
     *
     * @param sellerCode 卖家编号。
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
     * <p>订单来源。</p>
     *
     * @return the 订单来源
     */
    public java.lang.Integer getOrderSource() {
        return orderSource;
    }

    /**
     * <p>订单来源。</p>
     *
     * @param orderSource 订单来源。
     */
    public void setOrderSource(java.lang.Integer orderSource) {
        this.orderSource = orderSource;
    }

    /**
     * <p>区域。</p>
     *
     * @return the 区域
     */
    public java.lang.String getDistrictCode() {
        return districtCode;
    }

    /**
     * <p>区域。</p>
     *
     * @param districtCode 区域。
     */
    public void setDistrictCode(java.lang.String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * <p>购物意愿创建时间。</p>
     *
     * @return the 购物意愿创建时间
     */
    public java.util.Date getProTime() {
        return proTime;
    }

    /**
     * <p>购物意愿创建时间。</p>
     *
     * @param proTime 购物意愿创建时间。
     */
    public void setProTime(java.util.Date proTime) {
        this.proTime = proTime;
    }

}
