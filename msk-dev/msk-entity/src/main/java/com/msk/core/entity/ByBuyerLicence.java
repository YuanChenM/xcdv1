/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表by_buyer_licence对应的ByBuyerLicence。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class ByBuyerLicence extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** ID */
    private java.lang.Long id;
    /** 买家ID */
    private java.lang.String buyerId;
    /** 参考CONSTANT表 */
    private java.lang.String licName;
    /** 营业执照号码 */
    private java.lang.String licNumber;
    /** 法定代表人姓名 */
    private java.lang.String legalName;
    /** 法定代表人证件类型 */
    private java.lang.String legalLicType;
    /** 法定代表人证件号码 */
    private java.lang.String legalLicNumber;
    /**
     * <p>默认构造函数。</p>
     */
    public ByBuyerLicence() {

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
    public java.lang.String getLicName() {
        return licName;
    }

    /**
     * <p>参考CONSTANT表。</p>
     *
     * @param licName 参考CONSTANT表。
     */
    public void setLicName(java.lang.String licName) {
        this.licName = licName;
    }

    /**
     * <p>营业执照号码。</p>
     *
     * @return the 营业执照号码
     */
    public java.lang.String getLicNumber() {
        return licNumber;
    }

    /**
     * <p>营业执照号码。</p>
     *
     * @param licNumber 营业执照号码。
     */
    public void setLicNumber(java.lang.String licNumber) {
        this.licNumber = licNumber;
    }

    /**
     * <p>法定代表人姓名。</p>
     *
     * @return the 法定代表人姓名
     */
    public java.lang.String getLegalName() {
        return legalName;
    }

    /**
     * <p>法定代表人姓名。</p>
     *
     * @param legalName 法定代表人姓名。
     */
    public void setLegalName(java.lang.String legalName) {
        this.legalName = legalName;
    }

    /**
     * <p>法定代表人证件类型。</p>
     *
     * @return the 法定代表人证件类型
     */
    public java.lang.String getLegalLicType() {
        return legalLicType;
    }

    /**
     * <p>法定代表人证件类型。</p>
     *
     * @param legalLicType 法定代表人证件类型。
     */
    public void setLegalLicType(java.lang.String legalLicType) {
        this.legalLicType = legalLicType;
    }

    /**
     * <p>法定代表人证件号码。</p>
     *
     * @return the 法定代表人证件号码
     */
    public java.lang.String getLegalLicNumber() {
        return legalLicNumber;
    }

    /**
     * <p>法定代表人证件号码。</p>
     *
     * @param legalLicNumber 法定代表人证件号码。
     */
    public void setLegalLicNumber(java.lang.String legalLicNumber) {
        this.legalLicNumber = legalLicNumber;
    }

}
