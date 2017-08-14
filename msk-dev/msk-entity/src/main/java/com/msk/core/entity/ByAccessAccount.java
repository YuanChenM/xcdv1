/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表by_access_account对应的ByAccessAccount。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class ByAccessAccount extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 帐号ID */
    private java.lang.Long accountId;
    /** 帐号名 */
    private java.lang.String accountName;
    /** 帐号密码 */
    private java.lang.String accountPwd;
    /** 手机号 */
    private java.lang.String telNo;
    /**
     * <p>默认构造函数。</p>
     */
    public ByAccessAccount() {

    }

    /**
     * <p>帐号ID。</p>
     *
     * @return the 帐号ID
     */
    public java.lang.Long getAccountId() {
        return accountId;
    }

    /**
     * <p>帐号ID。</p>
     *
     * @param accountId 帐号ID。
     */
    public void setAccountId(java.lang.Long accountId) {
        this.accountId = accountId;
    }

    /**
     * <p>帐号名。</p>
     *
     * @return the 帐号名
     */
    public java.lang.String getAccountName() {
        return accountName;
    }

    /**
     * <p>帐号名。</p>
     *
     * @param accountName 帐号名。
     */
    public void setAccountName(java.lang.String accountName) {
        this.accountName = accountName;
    }

    /**
     * <p>帐号密码。</p>
     *
     * @return the 帐号密码
     */
    public java.lang.String getAccountPwd() {
        return accountPwd;
    }

    /**
     * <p>帐号密码。</p>
     *
     * @param accountPwd 帐号密码。
     */
    public void setAccountPwd(java.lang.String accountPwd) {
        this.accountPwd = accountPwd;
    }

    /**
     * <p>手机号。</p>
     *
     * @return the 手机号
     */
    public java.lang.String getTelNo() {
        return telNo;
    }

    /**
     * <p>手机号。</p>
     *
     * @param telNo 手机号。
     */
    public void setTelNo(java.lang.String telNo) {
        this.telNo = telNo;
    }

}
