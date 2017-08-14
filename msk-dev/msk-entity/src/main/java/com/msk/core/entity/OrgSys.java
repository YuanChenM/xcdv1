/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表org_sys对应的OrgSys。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class OrgSys extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** SYS_CODE */
    private java.lang.String sysCode;
    /** SYS_NAME */
    private java.lang.String sysName;
    /** SYS_LEVEL */
    private java.lang.Integer sysLevel;
    /** PARENT_CODE */
    private java.lang.String parentCode;
    /** SYS_DESC */
    private java.lang.String sysDesc;
    /**
     * <p>默认构造函数。</p>
     */
    public OrgSys() {

    }

    /**
     * <p>SYS_CODE。</p>
     *
     * @return the SYS_CODE
     */
    public java.lang.String getSysCode() {
        return sysCode;
    }

    /**
     * <p>SYS_CODE。</p>
     *
     * @param sysCode SYS_CODE。
     */
    public void setSysCode(java.lang.String sysCode) {
        this.sysCode = sysCode;
    }

    /**
     * <p>SYS_NAME。</p>
     *
     * @return the SYS_NAME
     */
    public java.lang.String getSysName() {
        return sysName;
    }

    /**
     * <p>SYS_NAME。</p>
     *
     * @param sysName SYS_NAME。
     */
    public void setSysName(java.lang.String sysName) {
        this.sysName = sysName;
    }

    /**
     * <p>SYS_LEVEL。</p>
     *
     * @return the SYS_LEVEL
     */
    public java.lang.Integer getSysLevel() {
        return sysLevel;
    }

    /**
     * <p>SYS_LEVEL。</p>
     *
     * @param sysLevel SYS_LEVEL。
     */
    public void setSysLevel(java.lang.Integer sysLevel) {
        this.sysLevel = sysLevel;
    }

    /**
     * <p>PARENT_CODE。</p>
     *
     * @return the PARENT_CODE
     */
    public java.lang.String getParentCode() {
        return parentCode;
    }

    /**
     * <p>PARENT_CODE。</p>
     *
     * @param parentCode PARENT_CODE。
     */
    public void setParentCode(java.lang.String parentCode) {
        this.parentCode = parentCode;
    }

    /**
     * <p>SYS_DESC。</p>
     *
     * @return the SYS_DESC
     */
    public java.lang.String getSysDesc() {
        return sysDesc;
    }

    /**
     * <p>SYS_DESC。</p>
     *
     * @param sysDesc SYS_DESC。
     */
    public void setSysDesc(java.lang.String sysDesc) {
        this.sysDesc = sysDesc;
    }

}
