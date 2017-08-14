/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_cp_certificate_master对应的SoCpCertificateMaster。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoCpCertificateMaster extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 单据ID */
    private java.lang.Integer billId;
    /** 主键 */
    private java.lang.Integer transId;
    /** 记账 */
    private java.lang.String chargeAccount;
    /** 制单次数 */
    private java.lang.Integer makeNum;
    /** 订单编码 */
    private java.lang.String orderNo;
    /** 单据类型 0付款单据 1收款单据 2付款货款清单单据 3 收款货款单据 4付款管理费单据 5收款管理费单据 */
    private java.lang.Integer billType;
    /** 创建者ID */
    private java.lang.String creId;
    /** 创建日时 */
    private java.util.Date creTime;
    /**
     * <p>默认构造函数。</p>
     */
    public SoCpCertificateMaster() {

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
     * <p>记账。</p>
     *
     * @return the 记账
     */
    public java.lang.String getChargeAccount() {
        return chargeAccount;
    }

    /**
     * <p>记账。</p>
     *
     * @param chargeAccount 记账。
     */
    public void setChargeAccount(java.lang.String chargeAccount) {
        this.chargeAccount = chargeAccount;
    }

    /**
     * <p>制单次数。</p>
     *
     * @return the 制单次数
     */
    public java.lang.Integer getMakeNum() {
        return makeNum;
    }

    /**
     * <p>制单次数。</p>
     *
     * @param makeNum 制单次数。
     */
    public void setMakeNum(java.lang.Integer makeNum) {
        this.makeNum = makeNum;
    }

    /**
     * <p>订单编码。</p>
     *
     * @return the 订单编码
     */
    public java.lang.String getOrderNo() {
        return orderNo;
    }

    /**
     * <p>订单编码。</p>
     *
     * @param orderNo 订单编码。
     */
    public void setOrderNo(java.lang.String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * <p>单据类型 0付款单据 1收款单据 2付款货款清单单据 3 收款货款单据 4付款管理费单据 5收款管理费单据。</p>
     *
     * @return the 单据类型 0付款单据 1收款单据 2付款货款清单单据 3 收款货款单据 4付款管理费单据 5收款管理费单据
     */
    public java.lang.Integer getBillType() {
        return billType;
    }

    /**
     * <p>单据类型 0付款单据 1收款单据 2付款货款清单单据 3 收款货款单据 4付款管理费单据 5收款管理费单据。</p>
     *
     * @param billType 单据类型 0付款单据 1收款单据 2付款货款清单单据 3 收款货款单据 4付款管理费单据 5收款管理费单据。
     */
    public void setBillType(java.lang.Integer billType) {
        this.billType = billType;
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
