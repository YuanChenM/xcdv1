/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表org_dept_empl对应的OrgDeptEmpl。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class OrgDeptEmpl extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** DEPT_ID */
    private java.lang.Long deptId;
    /** EMPL_ID */
    private java.lang.Long emplId;
    /** DEPT_CODE */
    private java.lang.String deptCode;
    /** EMPL_CODE */
    private java.lang.String emplCode;
    /** 0:正常 */
    private java.lang.Integer status;
    /**
     * <p>默认构造函数。</p>
     */
    public OrgDeptEmpl() {

    }

    /**
     * <p>DEPT_ID。</p>
     *
     * @return the DEPT_ID
     */
    public java.lang.Long getDeptId() {
        return deptId;
    }

    /**
     * <p>DEPT_ID。</p>
     *
     * @param deptId DEPT_ID。
     */
    public void setDeptId(java.lang.Long deptId) {
        this.deptId = deptId;
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
     * <p>DEPT_CODE。</p>
     *
     * @return the DEPT_CODE
     */
    public java.lang.String getDeptCode() {
        return deptCode;
    }

    /**
     * <p>DEPT_CODE。</p>
     *
     * @param deptCode DEPT_CODE。
     */
    public void setDeptCode(java.lang.String deptCode) {
        this.deptCode = deptCode;
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
     * <p>0:正常。</p>
     *
     * @return the 0:正常
     */
    public java.lang.Integer getStatus() {
        return status;
    }

    /**
     * <p>0:正常。</p>
     *
     * @param status 0:正常。
     */
    public void setStatus(java.lang.Integer status) {
        this.status = status;
    }

}
