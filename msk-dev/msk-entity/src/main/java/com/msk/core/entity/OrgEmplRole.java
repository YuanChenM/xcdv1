/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表org_empl_role对应的OrgEmplRole。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class OrgEmplRole extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** EMPL_ID */
    private java.lang.Long emplId;
    /** ROLE_ID */
    private java.lang.Long roleId;
    /**
     * <p>默认构造函数。</p>
     */
    public OrgEmplRole() {

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

}
