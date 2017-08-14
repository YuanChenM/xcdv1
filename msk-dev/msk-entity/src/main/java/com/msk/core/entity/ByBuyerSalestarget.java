/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表by_buyer_salestarget对应的ByBuyerSalestarget。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class ByBuyerSalestarget extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** ID */
    private java.lang.Long id;
    /** 买家ID */
    private java.lang.String buyerId;
    /** 参考CONSTANT表 */
    private java.lang.String salesTargetType;
    /** 参考CONSTANT表 */
    private java.lang.String salesTargetName;
    /**
     * <p>默认构造函数。</p>
     */
    public ByBuyerSalestarget() {

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
     * <p>买家ID。</p>
     *
     * @return the 买家ID
     */
    public java.lang.String getBuyerId() {
        return buyerId;
    }

    /**
     * <p>买家ID。</p>
     *
     * @param buyerId 买家ID。
     */
    public void setBuyerId(java.lang.String buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * <p>参考CONSTANT表。</p>
     *
     * @return the 参考CONSTANT表
     */
    public java.lang.String getSalesTargetType() {
        return salesTargetType;
    }

    /**
     * <p>参考CONSTANT表。</p>
     *
     * @param salesTargetType 参考CONSTANT表。
     */
    public void setSalesTargetType(java.lang.String salesTargetType) {
        this.salesTargetType = salesTargetType;
    }

    /**
     * <p>参考CONSTANT表。</p>
     *
     * @return the 参考CONSTANT表
     */
    public java.lang.String getSalesTargetName() {
        return salesTargetName;
    }

    /**
     * <p>参考CONSTANT表。</p>
     *
     * @param salesTargetName 参考CONSTANT表。
     */
    public void setSalesTargetName(java.lang.String salesTargetName) {
        this.salesTargetName = salesTargetName;
    }

}
