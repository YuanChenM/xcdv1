/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表by_buyer_employee对应的ByBuyerEmployee。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class ByBuyerEmployee extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** ID */
    private java.lang.Long id;
    /** 买家ID */
    private java.lang.String buyerId;
    /** 参考CONSTANT表 */
    private java.lang.String employeeType;
    /** 姓名 */
    private java.lang.String employeeName;
    /** 手机号 */
    private java.lang.String employeeTel;
    /** QQ号 */
    private java.lang.String employeeQq;
    /** 微信号 */
    private java.lang.String employeeWechat;
    /** 1：有 */
    private java.lang.String busCardFlg;
    /** 雇员名片照ID */
    private java.lang.String busCardId;
    /** 雇员名片后缀 */
    private java.lang.String busCardSuf;
    /** 0：否，1：是 */
    private java.lang.String contactPerson;
    /** 0：否，1：是 */
    private java.lang.String purchase;
    /** 0：否，1：是 */
    private java.lang.String receivePerson;
    /**
     * <p>默认构造函数。</p>
     */
    public ByBuyerEmployee() {

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
    public java.lang.String getEmployeeType() {
        return employeeType;
    }

    /**
     * <p>参考CONSTANT表。</p>
     *
     * @param employeeType 参考CONSTANT表。
     */
    public void setEmployeeType(java.lang.String employeeType) {
        this.employeeType = employeeType;
    }

    /**
     * <p>姓名。</p>
     *
     * @return the 姓名
     */
    public java.lang.String getEmployeeName() {
        return employeeName;
    }

    /**
     * <p>姓名。</p>
     *
     * @param employeeName 姓名。
     */
    public void setEmployeeName(java.lang.String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * <p>手机号。</p>
     *
     * @return the 手机号
     */
    public java.lang.String getEmployeeTel() {
        return employeeTel;
    }

    /**
     * <p>手机号。</p>
     *
     * @param employeeTel 手机号。
     */
    public void setEmployeeTel(java.lang.String employeeTel) {
        this.employeeTel = employeeTel;
    }

    /**
     * <p>QQ号。</p>
     *
     * @return the QQ号
     */
    public java.lang.String getEmployeeQq() {
        return employeeQq;
    }

    /**
     * <p>QQ号。</p>
     *
     * @param employeeQq QQ号。
     */
    public void setEmployeeQq(java.lang.String employeeQq) {
        this.employeeQq = employeeQq;
    }

    /**
     * <p>微信号。</p>
     *
     * @return the 微信号
     */
    public java.lang.String getEmployeeWechat() {
        return employeeWechat;
    }

    /**
     * <p>微信号。</p>
     *
     * @param employeeWechat 微信号。
     */
    public void setEmployeeWechat(java.lang.String employeeWechat) {
        this.employeeWechat = employeeWechat;
    }

    /**
     * <p>1：有。</p>
     *
     * @return the 1：有
     */
    public java.lang.String getBusCardFlg() {
        return busCardFlg;
    }

    /**
     * <p>1：有。</p>
     *
     * @param busCardFlg 1：有。
     */
    public void setBusCardFlg(java.lang.String busCardFlg) {
        this.busCardFlg = busCardFlg;
    }

    /**
     * <p>雇员名片照ID。</p>
     *
     * @return the 雇员名片照ID
     */
    public java.lang.String getBusCardId() {
        return busCardId;
    }

    /**
     * <p>雇员名片照ID。</p>
     *
     * @param busCardId 雇员名片照ID。
     */
    public void setBusCardId(java.lang.String busCardId) {
        this.busCardId = busCardId;
    }

    /**
     * <p>雇员名片后缀。</p>
     *
     * @return the 雇员名片后缀
     */
    public java.lang.String getBusCardSuf() {
        return busCardSuf;
    }

    /**
     * <p>雇员名片后缀。</p>
     *
     * @param busCardSuf 雇员名片后缀。
     */
    public void setBusCardSuf(java.lang.String busCardSuf) {
        this.busCardSuf = busCardSuf;
    }

    /**
     * <p>0：否，1：是。</p>
     *
     * @return the 0：否，1：是
     */
    public java.lang.String getContactPerson() {
        return contactPerson;
    }

    /**
     * <p>0：否，1：是。</p>
     *
     * @param contactPerson 0：否，1：是。
     */
    public void setContactPerson(java.lang.String contactPerson) {
        this.contactPerson = contactPerson;
    }

    /**
     * <p>0：否，1：是。</p>
     *
     * @return the 0：否，1：是
     */
    public java.lang.String getPurchase() {
        return purchase;
    }

    /**
     * <p>0：否，1：是。</p>
     *
     * @param purchase 0：否，1：是。
     */
    public void setPurchase(java.lang.String purchase) {
        this.purchase = purchase;
    }

    /**
     * <p>0：否，1：是。</p>
     *
     * @return the 0：否，1：是
     */
    public java.lang.String getReceivePerson() {
        return receivePerson;
    }

    /**
     * <p>0：否，1：是。</p>
     *
     * @param receivePerson 0：否，1：是。
     */
    public void setReceivePerson(java.lang.String receivePerson) {
        this.receivePerson = receivePerson;
    }

}
