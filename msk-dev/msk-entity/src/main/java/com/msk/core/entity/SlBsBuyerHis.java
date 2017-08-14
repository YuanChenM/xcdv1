/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_bs_buyer_his对应的SlBsBuyerHis。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlBsBuyerHis extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 履历ID */
    private java.lang.Long hisId;
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
    /** 买家解除关系原因 */
    private java.lang.String buyerReason;
    /** 买手店解除关系原因 */
    private java.lang.String buyershopReason;
    /**
     * <p>默认构造函数。</p>
     */
    public SlBsBuyerHis() {

    }

    /**
     * <p>履历ID。</p>
     *
     * @return the 履历ID
     */
    public java.lang.Long getHisId() {
        return hisId;
    }

    /**
     * <p>履历ID。</p>
     *
     * @param hisId 履历ID。
     */
    public void setHisId(java.lang.Long hisId) {
        this.hisId = hisId;
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
     * <p>用于登录的卖家账号。</p>
     *
     * @return the 用于登录的卖家账号
     */
   /* public java.lang.String getHouseAccount() {
        return houseCode;
    }*/
    public java.lang.String getHouseCode() {
        return houseCode;
    }

    /**
     * <p>用于登录的卖家账号。</p>
     *
     * @param houseCode 用于登录的卖家账号。
     */
    public void setHouseCode(java.lang.String houseCode) {
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

    /**
     * <p>买家解除关系原因。</p>
     *
     * @return the 买家解除关系原因
     */
    public java.lang.String getBuyerReason() {
        return buyerReason;
    }

    /**
     * <p>买家解除关系原因。</p>
     *
     * @param buyerReason 买家解除关系原因。
     */
    public void setBuyerReason(java.lang.String buyerReason) {
        this.buyerReason = buyerReason;
    }

    /**
     * <p>买手店解除关系原因。</p>
     *
     * @return the 买手店解除关系原因
     */
    public java.lang.String getBuyershopReason() {
        return buyershopReason;
    }

    /**
     * <p>买手店解除关系原因。</p>
     *
     * @param buyershopReason 买手店解除关系原因。
     */
    public void setBuyershopReason(java.lang.String buyershopReason) {
        this.buyershopReason = buyershopReason;
    }

}
