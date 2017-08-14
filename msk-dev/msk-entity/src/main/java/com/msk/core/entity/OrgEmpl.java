/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表org_empl对应的OrgEmpl。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class OrgEmpl extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** EMPL_ID */
    private java.lang.Long emplId;
    /** EMPL_CODE */
    private java.lang.String emplCode;
    /** EMPL_NAME */
    private java.lang.String emplName;
    /** 0:其他,1:男,2:女 */
    private java.lang.String sex;
    /** BIRTH */
    private java.lang.String birth;
    /** ENTRY */
    private java.lang.String entry;
    /** MOBILE */
    private java.lang.String mobile;
    /** EMIAL */
    private java.lang.String emial;
    /** QQ */
    private java.lang.String qq;
    /** PWD */
    private java.lang.String pwd;
    /** STATUS */
    private java.lang.Integer status;
    /**
     * <p>默认构造函数。</p>
     */
    public OrgEmpl() {

    }

    /**
     * <p>EMPL_ID。</p>
     *
     * @return the EMPL_ID
     */
    public java.lang.Long getEmplId() {
        return emplId;
    }

    /**
     * <p>EMPL_ID。</p>
     *
     * @param emplId EMPL_ID。
     */
    public void setEmplId(java.lang.Long emplId) {
        this.emplId = emplId;
    }

    /**
     * <p>EMPL_CODE。</p>
     *
     * @return the EMPL_CODE
     */
    public java.lang.String getEmplCode() {
        return emplCode;
    }

    /**
     * <p>EMPL_CODE。</p>
     *
     * @param emplCode EMPL_CODE。
     */
    public void setEmplCode(java.lang.String emplCode) {
        this.emplCode = emplCode;
    }

    /**
     * <p>EMPL_NAME。</p>
     *
     * @return the EMPL_NAME
     */
    public java.lang.String getEmplName() {
        return emplName;
    }

    /**
     * <p>EMPL_NAME。</p>
     *
     * @param emplName EMPL_NAME。
     */
    public void setEmplName(java.lang.String emplName) {
        this.emplName = emplName;
    }

    /**
     * <p>0:其他,1:男,2:女。</p>
     *
     * @return the 0:其他,1:男,2:女
     */
    public java.lang.String getSex() {
        return sex;
    }

    /**
     * <p>0:其他,1:男,2:女。</p>
     *
     * @param sex 0:其他,1:男,2:女。
     */
    public void setSex(java.lang.String sex) {
        this.sex = sex;
    }

    /**
     * <p>BIRTH。</p>
     *
     * @return the BIRTH
     */
    public java.lang.String getBirth() {
        return birth;
    }

    /**
     * <p>BIRTH。</p>
     *
     * @param birth BIRTH。
     */
    public void setBirth(java.lang.String birth) {
        this.birth = birth;
    }

    /**
     * <p>ENTRY。</p>
     *
     * @return the ENTRY
     */
    public java.lang.String getEntry() {
        return entry;
    }

    /**
     * <p>ENTRY。</p>
     *
     * @param entry ENTRY。
     */
    public void setEntry(java.lang.String entry) {
        this.entry = entry;
    }

    /**
     * <p>MOBILE。</p>
     *
     * @return the MOBILE
     */
    public java.lang.String getMobile() {
        return mobile;
    }

    /**
     * <p>MOBILE。</p>
     *
     * @param mobile MOBILE。
     */
    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    /**
     * <p>EMIAL。</p>
     *
     * @return the EMIAL
     */
    public java.lang.String getEmial() {
        return emial;
    }

    /**
     * <p>EMIAL。</p>
     *
     * @param emial EMIAL。
     */
    public void setEmial(java.lang.String emial) {
        this.emial = emial;
    }

    /**
     * <p>QQ。</p>
     *
     * @return the QQ
     */
    public java.lang.String getQq() {
        return qq;
    }

    /**
     * <p>QQ。</p>
     *
     * @param qq QQ。
     */
    public void setQq(java.lang.String qq) {
        this.qq = qq;
    }

    /**
     * <p>PWD。</p>
     *
     * @return the PWD
     */
    public java.lang.String getPwd() {
        return pwd;
    }

    /**
     * <p>PWD。</p>
     *
     * @param pwd PWD。
     */
    public void setPwd(java.lang.String pwd) {
        this.pwd = pwd;
    }

    /**
     * <p>STATUS。</p>
     *
     * @return the STATUS
     */
    public java.lang.Integer getStatus() {
        return status;
    }

    /**
     * <p>STATUS。</p>
     *
     * @param status STATUS。
     */
    public void setStatus(java.lang.Integer status) {
        this.status = status;
    }

}
