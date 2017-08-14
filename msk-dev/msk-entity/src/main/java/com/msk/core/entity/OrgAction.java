/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表org_action对应的OrgAction。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class OrgAction extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** PAGE_CODE */
    private java.lang.String pageCode;
    /** ACTION_CODE */
    private java.lang.String actionCode;
    /** ACTION_NAME */
    private java.lang.String actionName;
    /** 1:按钮 */
    private java.lang.Integer actionType;
    /** ACTION_DESC */
    private java.lang.String actionDesc;
    /**
     * <p>默认构造函数。</p>
     */
    public OrgAction() {

    }

    /**
     * <p>PAGE_CODE。</p>
     *
     * @return the PAGE_CODE
     */
    public java.lang.String getPageCode() {
        return pageCode;
    }

    /**
     * <p>PAGE_CODE。</p>
     *
     * @param pageCode PAGE_CODE。
     */
    public void setPageCode(java.lang.String pageCode) {
        this.pageCode = pageCode;
    }

    /**
     * <p>ACTION_CODE。</p>
     *
     * @return the ACTION_CODE
     */
    public java.lang.String getActionCode() {
        return actionCode;
    }

    /**
     * <p>ACTION_CODE。</p>
     *
     * @param actionCode ACTION_CODE。
     */
    public void setActionCode(java.lang.String actionCode) {
        this.actionCode = actionCode;
    }

    /**
     * <p>ACTION_NAME。</p>
     *
     * @return the ACTION_NAME
     */
    public java.lang.String getActionName() {
        return actionName;
    }

    /**
     * <p>ACTION_NAME。</p>
     *
     * @param actionName ACTION_NAME。
     */
    public void setActionName(java.lang.String actionName) {
        this.actionName = actionName;
    }

    /**
     * <p>1:按钮。</p>
     *
     * @return the 1:按钮
     */
    public java.lang.Integer getActionType() {
        return actionType;
    }

    /**
     * <p>1:按钮。</p>
     *
     * @param actionType 1:按钮。
     */
    public void setActionType(java.lang.Integer actionType) {
        this.actionType = actionType;
    }

    /**
     * <p>ACTION_DESC。</p>
     *
     * @return the ACTION_DESC
     */
    public java.lang.String getActionDesc() {
        return actionDesc;
    }

    /**
     * <p>ACTION_DESC。</p>
     *
     * @param actionDesc ACTION_DESC。
     */
    public void setActionDesc(java.lang.String actionDesc) {
        this.actionDesc = actionDesc;
    }

}
