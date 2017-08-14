/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表org_dept对应的OrgDept。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class OrgDept extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** DEPT_ID */
    private java.lang.Long deptId;
    /** DEPT_CODE */
    private java.lang.String deptCode;
    /** DEPT_NAME */
    private java.lang.String deptName;
    /** PARENT_CODE */
    private java.lang.String parentCode;
    /** DEPT_LEVEL */
    private java.lang.Integer deptLevel;
    /** DEPT_MANAGER */
    private java.lang.String deptManager;
    /** 0:正常 */
    private java.lang.Integer status;
    /** DEPT_DESC */
    private java.lang.String deptDesc;
    /**
     * <p>默认构造函数。</p>
     */
    public OrgDept() {

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
     * <p>DEPT_NAME。</p>
     *
     * @return the DEPT_NAME
     */
    public java.lang.String getDeptName() {
        return deptName;
    }

    /**
     * <p>DEPT_NAME。</p>
     *
     * @param deptName DEPT_NAME。
     */
    public void setDeptName(java.lang.String deptName) {
        this.deptName = deptName;
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
     * <p>DEPT_LEVEL。</p>
     *
     * @return the DEPT_LEVEL
     */
    public java.lang.Integer getDeptLevel() {
        return deptLevel;
    }

    /**
     * <p>DEPT_LEVEL。</p>
     *
     * @param deptLevel DEPT_LEVEL。
     */
    public void setDeptLevel(java.lang.Integer deptLevel) {
        this.deptLevel = deptLevel;
    }

    /**
     * <p>DEPT_MANAGER。</p>
     *
     * @return the DEPT_MANAGER
     */
    public java.lang.String getDeptManager() {
        return deptManager;
    }

    /**
     * <p>DEPT_MANAGER。</p>
     *
     * @param deptManager DEPT_MANAGER。
     */
    public void setDeptManager(java.lang.String deptManager) {
        this.deptManager = deptManager;
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

    /**
     * <p>DEPT_DESC。</p>
     *
     * @return the DEPT_DESC
     */
    public java.lang.String getDeptDesc() {
        return deptDesc;
    }

    /**
     * <p>DEPT_DESC。</p>
     *
     * @param deptDesc DEPT_DESC。
     */
    public void setDeptDesc(java.lang.String deptDesc) {
        this.deptDesc = deptDesc;
    }

}
