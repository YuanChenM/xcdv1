/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表org_role_auth对应的OrgRoleAuth。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class OrgRoleAuth extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** ROLE_ID */
    private java.lang.Long roleId;
    /** SYS_CODE */
    private java.lang.String sysCode;
    /** 页面编号为默认值时表示系统的权限 */
    private java.lang.String pageCode;
    /** 操作编号为默认值时表示页面的权限 */
    private java.lang.String actionCode;
    /** 0:无权限,1:有权限 */
    private java.lang.String isAvailable;
    /**
     * <p>默认构造函数。</p>
     */
    public OrgRoleAuth() {

    }

    /**
     * <p>ROLE_ID。</p>
     *
     * @return the ROLE_ID
     */
    public java.lang.Long getRoleId() {
        return roleId;
    }

    /**
     * <p>ROLE_ID。</p>
     *
     * @param roleId ROLE_ID。
     */
    public void setRoleId(java.lang.Long roleId) {
        this.roleId = roleId;
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
     * <p>页面编号为默认值时表示系统的权限。</p>
     *
     * @return the 页面编号为默认值时表示系统的权限
     */
    public java.lang.String getPageCode() {
        return pageCode;
    }

    /**
     * <p>页面编号为默认值时表示系统的权限。</p>
     *
     * @param pageCode 页面编号为默认值时表示系统的权限。
     */
    public void setPageCode(java.lang.String pageCode) {
        this.pageCode = pageCode;
    }

    /**
     * <p>操作编号为默认值时表示页面的权限。</p>
     *
     * @return the 操作编号为默认值时表示页面的权限
     */
    public java.lang.String getActionCode() {
        return actionCode;
    }

    /**
     * <p>操作编号为默认值时表示页面的权限。</p>
     *
     * @param actionCode 操作编号为默认值时表示页面的权限。
     */
    public void setActionCode(java.lang.String actionCode) {
        this.actionCode = actionCode;
    }

    /**
     * <p>0:无权限,1:有权限。</p>
     *
     * @return the 0:无权限,1:有权限
     */
    public java.lang.String getIsAvailable() {
        return isAvailable;
    }

    /**
     * <p>0:无权限,1:有权限。</p>
     *
     * @param isAvailable 0:无权限,1:有权限。
     */
    public void setIsAvailable(java.lang.String isAvailable) {
        this.isAvailable = isAvailable;
    }

}
