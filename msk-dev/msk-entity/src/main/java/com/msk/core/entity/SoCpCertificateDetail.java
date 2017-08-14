/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_cp_certificate_detail对应的SoCpCertificateDetail。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoCpCertificateDetail extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 单据明细ID */
    private java.lang.Integer billListId;
    /** 单据ID */
    private java.lang.Integer billId;
    /** 科目代码 */
    private java.lang.String subjectCodeNo;
    /** 摘要 */
    private java.lang.String summary;
    /** 借贷方向 */
    private java.lang.String lendingDirection;
    /** 金额 */
    private java.math.BigDecimal money;
    /** 创建者ID */
    private java.lang.String creId;
    /** 创建日时 */
    private java.util.Date creTime;
    /**
     * <p>默认构造函数。</p>
     */
    public SoCpCertificateDetail() {

    }

    /**
     * <p>单据明细ID。</p>
     *
     * @return the 单据明细ID
     */
    public java.lang.Integer getBillListId() {
        return billListId;
    }

    /**
     * <p>单据明细ID。</p>
     *
     * @param billListId 单据明细ID。
     */
    public void setBillListId(java.lang.Integer billListId) {
        this.billListId = billListId;
    }

    /**
     * <p>单据ID。</p>
     *
     * @return the 单据ID
     */
    public java.lang.Integer getBillId() {
        return billId;
    }

    /**
     * <p>单据ID。</p>
     *
     * @param billId 单据ID。
     */
    public void setBillId(java.lang.Integer billId) {
        this.billId = billId;
    }

    /**
     * <p>科目代码。</p>
     *
     * @return the 科目代码
     */
    public java.lang.String getSubjectCodeNo() {
        return subjectCodeNo;
    }

    /**
     * <p>科目代码。</p>
     *
     * @param subjectCodeNo 科目代码。
     */
    public void setSubjectCodeNo(java.lang.String subjectCodeNo) {
        this.subjectCodeNo = subjectCodeNo;
    }

    /**
     * <p>摘要。</p>
     *
     * @return the 摘要
     */
    public java.lang.String getSummary() {
        return summary;
    }

    /**
     * <p>摘要。</p>
     *
     * @param summary 摘要。
     */
    public void setSummary(java.lang.String summary) {
        this.summary = summary;
    }

    /**
     * <p>借贷方向。</p>
     *
     * @return the 借贷方向
     */
    public java.lang.String getLendingDirection() {
        return lendingDirection;
    }

    /**
     * <p>借贷方向。</p>
     *
     * @param lendingDirection 借贷方向。
     */
    public void setLendingDirection(java.lang.String lendingDirection) {
        this.lendingDirection = lendingDirection;
    }

    /**
     * <p>金额。</p>
     *
     * @return the 金额
     */
    public java.math.BigDecimal getMoney() {
        return money;
    }

    /**
     * <p>金额。</p>
     *
     * @param money 金额。
     */
    public void setMoney(java.math.BigDecimal money) {
        this.money = money;
    }

    /**
     * <p>创建者ID。</p>
     *
     * @return the 创建者ID
     */
    public java.lang.String getCreId() {
        return creId;
    }

    /**
     * <p>创建者ID。</p>
     *
     * @param creId 创建者ID。
     */
    public void setCreId(java.lang.String creId) {
        this.creId = creId;
    }

    /**
     * <p>创建日时。</p>
     *
     * @return the 创建日时
     */
    public java.util.Date getCreTime() {
        return creTime;
    }

    /**
     * <p>创建日时。</p>
     *
     * @param creTime 创建日时。
     */
    public void setCreTime(java.util.Date creTime) {
        this.creTime = creTime;
    }

}
