/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表pd_qlt_std对应的PdQltStd。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class PdQltStd extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 产品标准ID */
    private java.lang.Long standardId;
    /** 质量标准项目ID */
    private java.lang.String qltStdItemId;
    /** 质量标准优良值 */
    private java.lang.String qltStdExcVal;
    /** 质量标准合格值 */
    private java.lang.String qltStdSuitVal;
    /** 质量标准不合格值 */
    private java.lang.String qltStdUnqualVal;
    /** 标准值单位 */
    private java.lang.String qltStdValUnit;
    /** 备注 */
    private java.lang.String remark;
    /**
     * <p>默认构造函数。</p>
     */
    public PdQltStd() {

    }

    /**
     * <p>产品标准ID。</p>
     *
     * @return the 产品标准ID
     */
    public java.lang.Long getStandardId() {
        return standardId;
    }

    /**
     * <p>产品标准ID。</p>
     *
     * @param standardId 产品标准ID。
     */
    public void setStandardId(java.lang.Long standardId) {
        this.standardId = standardId;
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
     * <p>质量标准优良值。</p>
     *
     * @return the 质量标准优良值
     */
    public java.lang.String getQltStdExcVal() {
        return qltStdExcVal;
    }

    /**
     * <p>质量标准优良值。</p>
     *
     * @param qltStdExcVal 质量标准优良值。
     */
    public void setQltStdExcVal(java.lang.String qltStdExcVal) {
        this.qltStdExcVal = qltStdExcVal;
    }

    /**
     * <p>质量标准合格值。</p>
     *
     * @return the 质量标准合格值
     */
    public java.lang.String getQltStdSuitVal() {
        return qltStdSuitVal;
    }

    /**
     * <p>质量标准合格值。</p>
     *
     * @param qltStdSuitVal 质量标准合格值。
     */
    public void setQltStdSuitVal(java.lang.String qltStdSuitVal) {
        this.qltStdSuitVal = qltStdSuitVal;
    }

    /**
     * <p>质量标准不合格值。</p>
     *
     * @return the 质量标准不合格值
     */
    public java.lang.String getQltStdUnqualVal() {
        return qltStdUnqualVal;
    }

    /**
     * <p>质量标准不合格值。</p>
     *
     * @param qltStdUnqualVal 质量标准不合格值。
     */
    public void setQltStdUnqualVal(java.lang.String qltStdUnqualVal) {
        this.qltStdUnqualVal = qltStdUnqualVal;
    }

    /**
     * <p>标准值单位。</p>
     *
     * @return the 标准值单位
     */
    public java.lang.String getQltStdValUnit() {
        return qltStdValUnit;
    }

    /**
     * <p>标准值单位。</p>
     *
     * @param qltStdValUnit 标准值单位。
     */
    public void setQltStdValUnit(java.lang.String qltStdValUnit) {
        this.qltStdValUnit = qltStdValUnit;
    }

    /**
     * <p>备注。</p>
     *
     * @return the 备注
     */
    public java.lang.String getRemark() {
        return remark;
    }

    /**
     * <p>备注。</p>
     *
     * @param remark 备注。
     */
    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

}
