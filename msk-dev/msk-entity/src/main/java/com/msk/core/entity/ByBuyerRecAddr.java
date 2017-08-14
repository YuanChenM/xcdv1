/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表by_buyer_rec_addr对应的ByBuyerRecAddr。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class ByBuyerRecAddr extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** ID */
    private java.lang.Long id;
    /** 买家ID */
    private java.lang.String buyerId;
    /** 收货地址 */
    private java.lang.String receiveAddr;
    /**
     * <p>默认构造函数。</p>
     */
    public ByBuyerRecAddr() {

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
     * <p>收货地址。</p>
     *
     * @return the 收货地址
     */
    public java.lang.String getReceiveAddr() {
        return receiveAddr;
    }

    /**
     * <p>收货地址。</p>
     *
     * @param receiveAddr 收货地址。
     */
    public void setReceiveAddr(java.lang.String receiveAddr) {
        this.receiveAddr = receiveAddr;
    }

}
