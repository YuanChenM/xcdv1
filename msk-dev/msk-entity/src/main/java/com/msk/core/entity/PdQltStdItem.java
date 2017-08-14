/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表pd_qlt_std_item对应的PdQltStdItem。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class PdQltStdItem extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 质量标准分类ID */
    private java.lang.String qltStdClaId;
    /** 质量标准子分类ID */
    private java.lang.String qltStdSubId;
    /** 质量标准项目ID */
    private java.lang.String qltStdItemId;
    /** 质量标准项目名 */
    private java.lang.String qltStdItemName;
    /**
     * <p>默认构造函数。</p>
     */
    public PdQltStdItem() {

    }

    /**
     * <p>质量标准分类ID。</p>
     *
     * @return the 质量标准分类ID
     */
    public java.lang.String getQltStdClaId() {
        return qltStdClaId;
    }

    /**
     * <p>质量标准分类ID。</p>
     *
     * @param qltStdClaId 质量标准分类ID。
     */
    public void setQltStdClaId(java.lang.String qltStdClaId) {
        this.qltStdClaId = qltStdClaId;
    }

    /**
     * <p>质量标准子分类ID。</p>
     *
     * @return the 质量标准子分类ID
     */
    public java.lang.String getQltStdSubId() {
        return qltStdSubId;
    }

    /**
     * <p>质量标准子分类ID。</p>
     *
     * @param qltStdSubId 质量标准子分类ID。
     */
    public void setQltStdSubId(java.lang.String qltStdSubId) {
        this.qltStdSubId = qltStdSubId;
    }

    /**
     * <p>质量标准项目ID。</p>
     *
     * @return the 质量标准项目ID
     */
    public java.lang.String getQltStdItemId() {
        return qltStdItemId;
    }

    /**
     * <p>质量标准项目ID。</p>
     *
     * @param qltStdItemId 质量标准项目ID。
     */
    public void setQltStdItemId(java.lang.String qltStdItemId) {
        this.qltStdItemId = qltStdItemId;
    }

    /**
     * <p>质量标准项目名。</p>
     *
     * @return the 质量标准项目名
     */
    public java.lang.String getQltStdItemName() {
        return qltStdItemName;
    }

    /**
     * <p>质量标准项目名。</p>
     *
     * @param qltStdItemName 质量标准项目名。
     */
    public void setQltStdItemName(java.lang.String qltStdItemName) {
        this.qltStdItemName = qltStdItemName;
    }

}
