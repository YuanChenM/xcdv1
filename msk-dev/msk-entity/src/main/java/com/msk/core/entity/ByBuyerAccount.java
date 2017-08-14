/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表by_buyer_account对应的ByBuyerAccount。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class ByBuyerAccount extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** ID */
    private java.lang.Long id;
    /** 买家ID */
    private java.lang.String buyerId;
    /** 手机号码 */
    private java.lang.String telNo;
    /** 帐号名称 */
    private java.lang.String accountName;
    /** 帐号密码 */
    private java.lang.String accountPass;
    /**
     * <p>默认构造函数。</p>
     */
    public ByBuyerAccount() {

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
     * <p>手机号码。</p>
     *
     * @return the 手机号码
     */
    public java.lang.String getTelNo() {
        return telNo;
    }

    /**
     * <p>手机号码。</p>
     *
     * @param telNo 手机号码。
     */
    public void setTelNo(java.lang.String telNo) {
        this.telNo = telNo;
    }

    /**
     * <p>帐号名称。</p>
     *
     * @return the 帐号名称
     */
    public java.lang.String getAccountName() {
        return accountName;
    }

    /**
     * <p>帐号名称。</p>
     *
     * @param accountName 帐号名称。
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }

    /**
     * <p>帐号密码。</p>
     *
     * @return the 帐号密码
     */
    public java.lang.String getAccountPass() {
        return accountPass;
    }

    /**
     * <p>帐号密码。</p>
     *
     * @param accountPass 帐号密码。
     */
    public void setAccountPass(java.lang.String accountPass) {
        this.accountPass = accountPass;
    }

}
