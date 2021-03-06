/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_cp_transaction_detail对应的SoCpTransactionDetail。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoCpTransactionDetail extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 主键 */
    private java.lang.Integer transId;
    /** 业务主体，收款方编码 */
    private java.lang.String businessMain;
    /** 业务副体，付款方编码 */
    private java.lang.String businessAssistant;
    /** 业务主体角色 */
    private java.lang.String businessManRole;
    /** 业务副体角色 */
    private java.lang.String businessAssistantRole;
    /** SELECT_CODE */
    private java.lang.String selectCode;
    /** 0 主订单 1管理费用清单 */
    private java.lang.String selectType;
    /** 0结算 1没有结算 */
    private java.lang.Integer settlement;
    /** 支付流水号 */
    private java.lang.String paidSeq;
    /** 发生金额 */
    private java.math.BigDecimal orderAmount;
    /** 交易日期 */
    private java.util.Date tranTime;
    /** 0 神农客 1美食客 */
    private java.lang.Integer platformType;
    /** 0 买家付款 1平台付款 2卖家付款 */
    private java.lang.Integer amountType;
    /** 备注 */
    private java.lang.String remark;
    /**
     * <p>默认构造函数。</p>
     */
    public SoCpTransactionDetail() {

    }

    /**
     * <p>主键。</p>
     *
     * @return the 主键
     */
    public java.lang.Integer getTransId() {
        return transId;
    }

    /**
     * <p>主键。</p>
     *
     * @param transId 主键。
     */
    public void setTransId(java.lang.Integer transId) {
        this.transId = transId;
    }

    /**
     * <p>业务主体，收款方编码。</p>
     *
     * @return the 业务主体，收款方编码
     */
    public java.lang.String getBusinessMain() {
        return businessMain;
    }

    /**
     * <p>业务主体，收款方编码。</p>
     *
     * @param businessMain 业务主体，收款方编码。
     */
    public void setBusinessMain(java.lang.String businessMain) {
        this.businessMain = businessMain;
    }

    /**
     * <p>业务副体，付款方编码。</p>
     *
     * @return the 业务副体，付款方编码
     */
    public java.lang.String getBusinessAssistant() {
        return businessAssistant;
    }

    /**
     * <p>业务副体，付款方编码。</p>
     *
     * @param businessAssistant 业务副体，付款方编码。
     */
    public void setBusinessAssistant(java.lang.String businessAssistant) {
        this.businessAssistant = businessAssistant;
    }

    /**
     * <p>业务主体角色。</p>
     *
     * @return the 业务主体角色
     */
    public java.lang.String getBusinessManRole() {
        return businessManRole;
    }

    /**
     * <p>业务主体角色。</p>
     *
     * @param businessManRole 业务主体角色。
     */
    public void setBusinessManRole(java.lang.String businessManRole) {
        this.businessManRole = businessManRole;
    }

    /**
     * <p>业务副体角色。</p>
     *
     * @return the 业务副体角色
     */
    public java.lang.String getBusinessAssistantRole() {
        return businessAssistantRole;
    }

    /**
     * <p>业务副体角色。</p>
     *
     * @param businessAssistantRole 业务副体角色。
     */
    public void setBusinessAssistantRole(java.lang.String businessAssistantRole) {
        this.businessAssistantRole = businessAssistantRole;
    }

    /**
     * <p>SELECT_CODE。</p>
     *
     * @return the SELECT_CODE
     */
    public java.lang.String getSelectCode() {
        return selectCode;
    }

    /**
     * <p>SELECT_CODE。</p>
     *
     * @param selectCode SELECT_CODE。
     */
    public void setSelectCode(java.lang.String selectCode) {
        this.selectCode = selectCode;
    }

    /**
     * <p>0 主订单 1管理费用清单。</p>
     *
     * @return the 0 主订单 1管理费用清单
     */
    public java.lang.String getSelectType() {
        return selectType;
    }

    /**
     * <p>0 主订单 1管理费用清单。</p>
     *
     * @param selectType 0 主订单 1管理费用清单。
     */
    public void setSelectType(java.lang.String selectType) {
        this.selectType = selectType;
    }

    /**
     * <p>0结算 1没有结算。</p>
     *
     * @return the 0结算 1没有结算
     */
    public java.lang.Integer getSettlement() {
        return settlement;
    }

    /**
     * <p>0结算 1没有结算。</p>
     *
     * @param settlement 0结算 1没有结算。
     */
    public void setSettlement(java.lang.Integer settlement) {
        this.settlement = settlement;
    }

    /**
     * <p>支付流水号。</p>
     *
     * @return the 支付流水号
     */
    public java.lang.String getPaidSeq() {
        return paidSeq;
    }

    /**
     * <p>支付流水号。</p>
     *
     * @param paidSeq 支付流水号。
     */
    public void setPaidSeq(java.lang.String paidSeq) {
        this.paidSeq = paidSeq;
    }

    /**
     * <p>发生金额。</p>
     *
     * @return the 发生金额
     */
    public java.math.BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * <p>发生金额。</p>
     *
     * @param orderAmount 发生金额。
     */
    public void setOrderAmount(java.math.BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * <p>交易日期。</p>
     *
     * @return the 交易日期
     */
    public java.util.Date getTranTime() {
        return tranTime;
    }

    /**
     * <p>交易日期。</p>
     *
     * @param tranTime 交易日期。
     */
    public void setTranTime(java.util.Date tranTime) {
        this.tranTime = tranTime;
    }

    /**
     * <p>0 神农客 1美食客。</p>
     *
     * @return the 0 神农客 1美食客
     */
    public java.lang.Integer getPlatformType() {
        return platformType;
    }

    /**
     * <p>0 神农客 1美食客。</p>
     *
     * @param platformType 0 神农客 1美食客。
     */
    public void setPlatformType(java.lang.Integer platformType) {
        this.platformType = platformType;
    }

    /**
     * <p>0 买家付款 1平台付款 2卖家付款。</p>
     *
     * @return the 0 买家付款 1平台付款 2卖家付款
     */
    public java.lang.Integer getAmountType() {
        return amountType;
    }

    /**
     * <p>0 买家付款 1平台付款 2卖家付款。</p>
     *
     * @param amountType 0 买家付款 1平台付款 2卖家付款。
     */
    public void setAmountType(java.lang.Integer amountType) {
        this.amountType = amountType;
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
