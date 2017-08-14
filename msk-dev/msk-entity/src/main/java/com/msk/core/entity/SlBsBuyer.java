/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_bs_buyer对应的SlBsBuyer。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlBsBuyer extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 区划(6)+顺序码(4) */
    private java.lang.String slCode;
    /** 用于登录的卖家账号 */
    private java.lang.String houseCode;
    /** 买家编码 */
    private java.lang.String buyerId;
    /** 开始日时 */
    private java.util.Date startTime;
    /** 结束日时 */
    private java.util.Date endTime;
    /** 1：买家 2：冻品管家 */
    private java.lang.String applySide;
    /** 1：申请中 2：专属会员 */
    private java.lang.String applyStatus;
    /** 申请日时 */
    private java.util.Date applyTime;
    /**
     * <p>默认构造函数。</p>
     */
    public SlBsBuyer() {

    }

    /**
     * <p>区划(6)+顺序码(4)。</p>
     *
     * @return the 区划(6)+顺序码(4)
     */
    public java.lang.String getSlCode() {
        return slCode;
    }

    /**
     * <p>区划(6)+顺序码(4)。</p>
     *
     * @param slCode 区划(6)+顺序码(4)。
     */
    public void setSlCode(java.lang.String slCode) {
        this.slCode = slCode;
    }

    /**
     * Getter method for property <tt>houseCode</tt>.
     *
     * @return property value of houseCode
     */
    public String getHouseCode() {
        return houseCode;
    }

    /**
     * Setter method for property <tt>houseCode</tt>.
     *
     * @param houseCode value to be assigned to property houseCode
     */
    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    /**
     * <p>买家编码。</p>
     *
     * @return the 买家编码
     */
    public java.lang.String getBuyerId() {
        return buyerId;
    }

    /**
     * <p>买家编码。</p>
     *
     * @param buyerId 买家编码。
     */
    public void setBuyerId(java.lang.String buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * <p>开始日时。</p>
     *
     * @return the 开始日时
     */
    public java.util.Date getStartTime() {
        return startTime;
    }

    /**
     * <p>开始日时。</p>
     *
     * @param startTime 开始日时。
     */
    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }

    /**
     * <p>结束日时。</p>
     *
     * @return the 结束日时
     */
    public java.util.Date getEndTime() {
        return endTime;
    }

    /**
     * <p>结束日时。</p>
     *
     * @param endTime 结束日时。
     */
    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }

    /**
     * <p>1：买家 2：冻品管家。</p>
     *
     * @return the 1：买家 2：冻品管家
     */
    public java.lang.String getApplySide() {
        return applySide;
    }

    /**
     * <p>1：买家 2：冻品管家。</p>
     *
     * @param applySide 1：买家 2：冻品管家。
     */
    public void setApplySide(java.lang.String applySide) {
        this.applySide = applySide;
    }

    /**
     * <p>1：申请中 2：专属会员。</p>
     *
     * @return the 1：申请中 2：专属会员
     */
    public java.lang.String getApplyStatus() {
        return applyStatus;
    }

    /**
     * <p>1：申请中 2：专属会员。</p>
     *
     * @param applyStatus 1：申请中 2：专属会员。
     */
    public void setApplyStatus(java.lang.String applyStatus) {
        this.applyStatus = applyStatus;
    }

    /**
     * <p>申请日时。</p>
     *
     * @return the 申请日时
     */
    public java.util.Date getApplyTime() {
        return applyTime;
    }

    /**
     * <p>申请日时。</p>
     *
     * @param applyTime 申请日时。
     */
    public void setApplyTime(java.util.Date applyTime) {
        this.applyTime = applyTime;
    }

}
