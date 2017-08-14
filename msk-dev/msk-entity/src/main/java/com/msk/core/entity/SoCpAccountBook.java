/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_cp_account_book对应的SoCpAccountBook。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoCpAccountBook extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 账套ID */
    private java.lang.Long accountBookId;
    /** 账套名称 */
    private java.lang.String accountBookName;
    /** 启用日期 */
    private java.util.Date commDate;
    /** 会计期间_始 */
    private java.util.Date periodBegin;
    /** 会计期间_末 */
    private java.util.Date periodEnd;
    /** 用户编号 */
    private java.lang.String userNo;
    /** 用户角色(0 神龙客,1 买家 2卖家) */
    private java.lang.String userRole;
    /** 余额方向 0支出 1收入 */
    private java.lang.String balanceDirection;
    /** 创建者ID */
    private java.lang.String creId;
    /** 创建日时 */
    private java.util.Date creTime;
    /** 余额 */
    private java.math.BigDecimal balance;
    /**
     * <p>默认构造函数。</p>
     */
    public SoCpAccountBook() {

    }

    /**
     * <p>账套ID。</p>
     *
     * @return the 账套ID
     */
    public java.lang.Long getAccountBookId() {
        return accountBookId;
    }

    /**
     * <p>账套ID。</p>
     *
     * @param accountBookId 账套ID。
     */
    public void setAccountBookId(java.lang.Long accountBookId) {
        this.accountBookId = accountBookId;
    }

    /**
     * <p>账套名称。</p>
     *
     * @return the 账套名称
     */
    public java.lang.String getAccountBookName() {
        return accountBookName;
    }

    /**
     * <p>账套名称。</p>
     *
     * @param accountBookName 账套名称。
     */
    public void setAccountBookName(java.lang.String accountBookName) {
        this.accountBookName = accountBookName;
    }

    /**
     * <p>启用日期。</p>
     *
     * @return the 启用日期
     */
    public java.util.Date getCommDate() {
        return commDate;
    }

    /**
     * <p>启用日期。</p>
     *
     * @param commDate 启用日期。
     */
    public void setCommDate(java.util.Date commDate) {
        this.commDate = commDate;
    }

    /**
     * <p>会计期间_始。</p>
     *
     * @return the 会计期间_始
     */
    public java.util.Date getPeriodBegin() {
        return periodBegin;
    }

    /**
     * <p>会计期间_始。</p>
     *
     * @param periodBegin 会计期间_始。
     */
    public void setPeriodBegin(java.util.Date periodBegin) {
        this.periodBegin = periodBegin;
    }

    /**
     * <p>会计期间_末。</p>
     *
     * @return the 会计期间_末
     */
    public java.util.Date getPeriodEnd() {
        return periodEnd;
    }

    /**
     * <p>会计期间_末。</p>
     *
     * @param periodEnd 会计期间_末。
     */
    public void setPeriodEnd(java.util.Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    /**
     * <p>用户编号。</p>
     *
     * @return the 用户编号
     */
    public java.lang.String getUserNo() {
        return userNo;
    }

    /**
     * <p>用户编号。</p>
     *
     * @param userNo 用户编号。
     */
    public void setUserNo(java.lang.String userNo) {
        this.userNo = userNo;
    }

    /**
     * <p>用户角色(0 神龙客,1 买家 2卖家)。</p>
     *
     * @return the 用户角色(0 神龙客,1 买家 2卖家)
     */
    public java.lang.String getUserRole() {
        return userRole;
    }

    /**
     * <p>用户角色(0 神龙客,1 买家 2卖家)。</p>
     *
     * @param userRole 用户角色(0 神龙客,1 买家 2卖家)。
     */
    public void setUserRole(java.lang.String userRole) {
        this.userRole = userRole;
    }

    /**
     * <p>余额方向 0支出 1收入。</p>
     *
     * @return the 余额方向 0支出 1收入
     */
    public java.lang.String getBalanceDirection() {
        return balanceDirection;
    }

    /**
     * <p>余额方向 0支出 1收入。</p>
     *
     * @param balanceDirection 余额方向 0支出 1收入。
     */
    public void setBalanceDirection(java.lang.String balanceDirection) {
        this.balanceDirection = balanceDirection;
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

    /**
     * <p>余额。</p>
     *
     * @return the 余额
     */
    public java.math.BigDecimal getBalance() {
        return balance;
    }

    /**
     * <p>余额。</p>
     *
     * @param balance 余额。
     */
    public void setBalance(java.math.BigDecimal balance) {
        this.balance = balance;
    }

}
