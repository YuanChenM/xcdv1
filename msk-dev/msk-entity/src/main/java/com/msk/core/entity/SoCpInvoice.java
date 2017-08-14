/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_cp_invoice对应的SoCpInvoice。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoCpInvoice extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** INVOICE_REQ_ID */
    private String invoiceReqId;
    /** ORDER_ID */
    private Long orderId;
    /** ORDER_CODE */
    private String orderCode;
    /** 1:普通发票,2:增值税普通发票,3:增值税专用发票 */
    private Integer invoiceType;
    /** INVOICE_TITLE */
    private String invoiceTitle;
    /** VAT_INV_COMP */
    private String vatInvComp;
    /** VAT_TAXPAYER */
    private String vatTaxpayer;
    /** VAT_ADDR */
    private String vatAddr;
    /** VAT_TEL */
    private String vatTel;
    /** VAT_BANK */
    private String vatBank;
    /** VAT_ACCOUNT */
    private String vatAccount;
    /** INV_RECEIVER_TEL */
    private String invReceiverTel;
    /** INV_TIME_REQ */
    private java.util.Date invTimeReq;
    /** INV_RECEIVER_EMAIL */
    private String invReceiverEmail;
    /** INVOICE_CONTENT */
    private String invoiceContent;
    /** INV_RECEIVER_ADDR */
    private String invReceiverAddr;
    /** INVOICE_REQ */
    private String invoiceReq;
    /** INVOICE_STATUS */
    private Integer invoiceStatus;
    /** REMARK */
    private String remark;
    /** REMARK2 */
    private String remark2;
    /** REMARK3 */
    private String remark3;
    /** INV_TIME */
    private java.util.Date invTime;
    /**
     * <p>默认构造函数。</p>
     */
    public SoCpInvoice() {

    }

    /**
     * <p>INVOICE_REQ_ID。</p>
     *
     * @return the INVOICE_REQ_ID
     */
    public String getInvoiceReqId() {
        return invoiceReqId;
    }

    /**
     * <p>INVOICE_REQ_ID。</p>
     *
     * @param invoiceReqId INVOICE_REQ_ID。
     */
    public void setInvoiceReqId(String invoiceReqId) {
        this.invoiceReqId = invoiceReqId;
    }

    /**
     * <p>ORDER_ID。</p>
     *
     * @return the ORDER_ID
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * <p>ORDER_ID。</p>
     *
     * @param orderId ORDER_ID。
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * <p>ORDER_CODE。</p>
     *
     * @return the ORDER_CODE
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * <p>ORDER_CODE。</p>
     *
     * @param orderCode ORDER_CODE。
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * <p>1:普通发票,2:增值税普通发票,3:增值税专用发票。</p>
     *
     * @return the 1:普通发票,2:增值税普通发票,3:增值税专用发票
     */
    public Integer getInvoiceType() {
        return invoiceType;
    }

    /**
     * <p>1:普通发票,2:增值税普通发票,3:增值税专用发票。</p>
     *
     * @param invoiceType 1:普通发票,2:增值税普通发票,3:增值税专用发票。
     */
    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    /**
     * <p>INVOICE_TITLE。</p>
     *
     * @return the INVOICE_TITLE
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * <p>INVOICE_TITLE。</p>
     *
     * @param invoiceTitle INVOICE_TITLE。
     */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    /**
     * <p>VAT_INV_COMP。</p>
     *
     * @return the VAT_INV_COMP
     */
    public String getVatInvComp() {
        return vatInvComp;
    }

    /**
     * <p>VAT_INV_COMP。</p>
     *
     * @param vatInvComp VAT_INV_COMP。
     */
    public void setVatInvComp(String vatInvComp) {
        this.vatInvComp = vatInvComp;
    }

    /**
     * <p>VAT_TAXPAYER。</p>
     *
     * @return the VAT_TAXPAYER
     */
    public String getVatTaxpayer() {
        return vatTaxpayer;
    }

    /**
     * <p>VAT_TAXPAYER。</p>
     *
     * @param vatTaxpayer VAT_TAXPAYER。
     */
    public void setVatTaxpayer(String vatTaxpayer) {
        this.vatTaxpayer = vatTaxpayer;
    }

    /**
     * <p>VAT_ADDR。</p>
     *
     * @return the VAT_ADDR
     */
    public String getVatAddr() {
        return vatAddr;
    }

    /**
     * <p>VAT_ADDR。</p>
     *
     * @param vatAddr VAT_ADDR。
     */
    public void setVatAddr(String vatAddr) {
        this.vatAddr = vatAddr;
    }

    /**
     * <p>VAT_TEL。</p>
     *
     * @return the VAT_TEL
     */
    public String getVatTel() {
        return vatTel;
    }

    /**
     * <p>VAT_TEL。</p>
     *
     * @param vatTel VAT_TEL。
     */
    public void setVatTel(String vatTel) {
        this.vatTel = vatTel;
    }

    /**
     * <p>VAT_BANK。</p>
     *
     * @return the VAT_BANK
     */
    public String getVatBank() {
        return vatBank;
    }

    /**
     * <p>VAT_BANK。</p>
     *
     * @param vatBank VAT_BANK。
     */
    public void setVatBank(String vatBank) {
        this.vatBank = vatBank;
    }

    /**
     * <p>VAT_ACCOUNT。</p>
     *
     * @return the VAT_ACCOUNT
     */
    public String getVatAccount() {
        return vatAccount;
    }

    /**
     * <p>VAT_ACCOUNT。</p>
     *
     * @param vatAccount VAT_ACCOUNT。
     */
    public void setVatAccount(String vatAccount) {
        this.vatAccount = vatAccount;
    }

    /**
     * <p>INV_RECEIVER_TEL。</p>
     *
     * @return the INV_RECEIVER_TEL
     */
    public String getInvReceiverTel() {
        return invReceiverTel;
    }

    /**
     * <p>INV_RECEIVER_TEL。</p>
     *
     * @param invReceiverTel INV_RECEIVER_TEL。
     */
    public void setInvReceiverTel(String invReceiverTel) {
        this.invReceiverTel = invReceiverTel;
    }

    /**
     * <p>INV_TIME_REQ。</p>
     *
     * @return the INV_TIME_REQ
     */
    public java.util.Date getInvTimeReq() {
        return invTimeReq;
    }

    /**
     * <p>INV_TIME_REQ。</p>
     *
     * @param invTimeReq INV_TIME_REQ。
     */
    public void setInvTimeReq(java.util.Date invTimeReq) {
        this.invTimeReq = invTimeReq;
    }

    /**
     * <p>INV_RECEIVER_EMAIL。</p>
     *
     * @return the INV_RECEIVER_EMAIL
     */
    public String getInvReceiverEmail() {
        return invReceiverEmail;
    }

    /**
     * <p>INV_RECEIVER_EMAIL。</p>
     *
     * @param invReceiverEmail INV_RECEIVER_EMAIL。
     */
    public void setInvReceiverEmail(String invReceiverEmail) {
        this.invReceiverEmail = invReceiverEmail;
    }

    /**
     * <p>INVOICE_CONTENT。</p>
     *
     * @return the INVOICE_CONTENT
     */
    public String getInvoiceContent() {
        return invoiceContent;
    }

    /**
     * <p>INVOICE_CONTENT。</p>
     *
     * @param invoiceContent INVOICE_CONTENT。
     */
    public void setInvoiceContent(String invoiceContent) {
        this.invoiceContent = invoiceContent;
    }

    /**
     * <p>INV_RECEIVER_ADDR。</p>
     *
     * @return the INV_RECEIVER_ADDR
     */
    public String getInvReceiverAddr() {
        return invReceiverAddr;
    }

    /**
     * <p>INV_RECEIVER_ADDR。</p>
     *
     * @param invReceiverAddr INV_RECEIVER_ADDR。
     */
    public void setInvReceiverAddr(String invReceiverAddr) {
        this.invReceiverAddr = invReceiverAddr;
    }

    /**
     * <p>INVOICE_REQ。</p>
     *
     * @return the INVOICE_REQ
     */
    public String getInvoiceReq() {
        return invoiceReq;
    }

    /**
     * <p>INVOICE_REQ。</p>
     *
     * @param invoiceReq INVOICE_REQ。
     */
    public void setInvoiceReq(String invoiceReq) {
        this.invoiceReq = invoiceReq;
    }

    /**
     * <p>INVOICE_STATUS。</p>
     *
     * @return the INVOICE_STATUS
     */
    public Integer getInvoiceStatus() {
        return invoiceStatus;
    }

    /**
     * <p>INVOICE_STATUS。</p>
     *
     * @param invoiceStatus INVOICE_STATUS。
     */
    public void setInvoiceStatus(Integer invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * <p>REMARK。</p>
     *
     * @return the REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <p>REMARK。</p>
     *
     * @param remark REMARK。
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * <p>REMARK2。</p>
     *
     * @return the REMARK2
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * <p>REMARK2。</p>
     *
     * @param remark2 REMARK2。
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    /**
     * <p>REMARK3。</p>
     *
     * @return the REMARK3
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * <p>REMARK3。</p>
     *
     * @param remark3 REMARK3。
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    /**
     * <p>INV_TIME。</p>
     *
     * @return the INV_TIME
     */
    public java.util.Date getInvTime() {
        return invTime;
    }

    /**
     * <p>INV_TIME。</p>
     *
     * @param invTime INV_TIME。
     */
    public void setInvTime(java.util.Date invTime) {
        this.invTime = invTime;
    }

}
