/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表pd_org_std_item对应的PdOrgStdItem。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class PdOrgStdItem extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 种源标准项目ID */
    private java.lang.String orgStdItemId;
    /** 种源标准项目名称 */
    private java.lang.String orgStdItemName;
    /** 层次ID */
    private java.lang.String levelId;
    /** 父节点ID */
    private java.lang.String parentId;
    /** 0:是目录节点,1:不是目录节点 */
    private java.lang.String isCatalog;
    /**
     * <p>默认构造函数。</p>
     */
    public PdOrgStdItem() {

    }

    /**
     * <p>种源标准项目ID。</p>
     *
     * @return the 种源标准项目ID
     */
    public java.lang.String getOrgStdItemId() {
        return orgStdItemId;
    }

    /**
     * <p>种源标准项目ID。</p>
     *
     * @param orgStdItemId 种源标准项目ID。
     */
    public void setOrgStdItemId(java.lang.String orgStdItemId) {
        this.orgStdItemId = orgStdItemId;
    }

    /**
     * <p>种源标准项目名称。</p>
     *
     * @return the 种源标准项目名称
     */
    public java.lang.String getOrgStdItemName() {
        return orgStdItemName;
    }

    /**
     * <p>种源标准项目名称。</p>
     *
     * @param orgStdItemName 种源标准项目名称。
     */
    public void setOrgStdItemName(java.lang.String orgStdItemName) {
        this.orgStdItemName = orgStdItemName;
    }

    /**
     * <p>层次ID。</p>
     *
     * @return the 层次ID
     */
    public java.lang.String getLevelId() {
        return levelId;
    }

    /**
     * <p>层次ID。</p>
     *
     * @param levelId 层次ID。
     */
    public void setLevelId(java.lang.String levelId) {
        this.levelId = levelId;
    }

    /**
     * <p>父节点ID。</p>
     *
     * @return the 父节点ID
     */
    public java.lang.String getParentId() {
        return parentId;
    }

    /**
     * <p>父节点ID。</p>
     *
     * @param parentId 父节点ID。
     */
    public void setParentId(java.lang.String parentId) {
        this.parentId = parentId;
    }

    /**
     * <p>0:是目录节点,1:不是目录节点。</p>
     *
     * @return the 0:是目录节点,1:不是目录节点
     */
    public java.lang.String getIsCatalog() {
        return isCatalog;
    }

    /**
     * <p>0:是目录节点,1:不是目录节点。</p>
     *
     * @param isCatalog 0:是目录节点,1:不是目录节点。
     */
    public void setIsCatalog(java.lang.String isCatalog) {
        this.isCatalog = isCatalog;
    }

}
