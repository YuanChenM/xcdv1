/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_cp_month_transaction_total对应的SoCpMonthTransactionTotal。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoCpMonthTransactionTotal extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 交易合计ID */
    private java.lang.Integer tranTotalNo;
    /** 买家确认金额 */
    private java.math.BigDecimal buyAmount;
    /** 供应商货款金额 */
    private java.math.BigDecimal supplierPaymentAmount;
    /** 平台仓储管理金额 */
    private java.math.BigDecimal warehousingAmount;
    /** 买家退款金额 */
    private java.math.BigDecimal refundAmount;
    /** 交易日期 */
    private java.util.Date tranTime;
    /**
     * <p>默认构造函数。</p>
     */
    public SoCpMonthTransactionTotal() {

    }

    /**
     * <p>交易合计ID。</p>
     *
     * @return the 交易合计ID
     */
    public java.lang.Integer getTranTotalNo() {
        return tranTotalNo;
    }

    /**
     * <p>交易合计ID。</p>
     *
     * @param tranTotalNo 交易合计ID。
     */
    public void setTranTotalNo(java.lang.Integer tranTotalNo) {
        this.tranTotalNo = tranTotalNo;
    }

    /**
     * <p>买家确认金额。</p>
     *
     * @return the 买家确认金额
     */
    public java.math.BigDecimal getBuyAmount() {
        return buyAmount;
    }

    /**
     * <p>买家确认金额。</p>
     *
     * @param buyAmount 买家确认金额。
     */
    public void setBuyAmount(java.math.BigDecimal buyAmount) {
        this.buyAmount = buyAmount;
    }

    /**
     * <p>供应商货款金额。</p>
     *
     * @return the 供应商货款金额
     */
    public java.math.BigDecimal getSupplierPaymentAmount() {
        return supplierPaymentAmount;
    }

    /**
     * <p>供应商货款金额。</p>
     *
     * @param supplierPaymentAmount 供应商货款金额。
     */
    public void setSupplierPaymentAmount(java.math.BigDecimal supplierPaymentAmount) {
        this.supplierPaymentAmount = supplierPaymentAmount;
    }

    /**
     * <p>平台仓储管理金额。</p>
     *
     * @return the 平台仓储管理金额
     */
    public java.math.BigDecimal getWarehousingAmount() {
        return warehousingAmount;
    }

    /**
     * <p>平台仓储管理金额。</p>
     *
     * @param warehousingAmount 平台仓储管理金额。
     */
    public void setWarehousingAmount(java.math.BigDecimal warehousingAmount) {
        this.warehousingAmount = warehousingAmount;
    }

    /**
     * <p>买家退款金额。</p>
     *
     * @return the 买家退款金额
     */
    public java.math.BigDecimal getRefundAmount() {
        return refundAmount;
    }

    /**
     * <p>买家退款金额。</p>
     *
     * @param refundAmount 买家退款金额。
     */
    public void setRefundAmount(java.math.BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
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

}
