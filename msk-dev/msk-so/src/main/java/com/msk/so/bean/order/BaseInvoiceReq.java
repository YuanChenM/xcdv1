package com.msk.so.bean.order;

import java.util.Date;

import com.msk.core.bean.BaseParam;

/**
 * BaseInvoiceReq
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class BaseInvoiceReq extends BaseParam {
    /** 发票类型,1:普通发票,2:增值税普通发票,3:增值税专用发票 */
    private Integer invoiceType;
    /** 发票抬头 */
    private String invoiceTitle;
    /** 发票内容 */
    private String invoiceContent;
    /** 收发票人手机号码 */
    private String invReceiverTel;
    /** 开票时间要求 */
    private Date invTimeReq;
    /** 收发票人邮箱 */
    private String invReceiverEmail;
    /** 收发票人地址 */
    private String invReceiverAddr;
    /** 发票要求 */
    private String invoiceReq;
    /** 增票单位名称 */
    private String vatInvComp;
    /** 增票纳税人识别码 */
    private String vatTaxpayer;
    /** 增票注册地址 */
    private String vatAddr;
    /** 增票注册电话 */
    private String vatTel;
    /** 增票开户银行 */
    private String vatBank;
    /** 增票银行账号 */
    private String vatAccount;

    /**
     * Getter method for property <tt>invoiceType</tt>.
     *
     * @return property value of invoiceType
     */
    public Integer getInvoiceType() {
        return invoiceType;
    }

    /**
     * Setter method for property <tt>invoiceType</tt>.
     *
     * @param invoiceType value to be assigned to property invoiceType
     */
    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    /**
     * Getter method for property <tt>invoiceTitle</tt>.
     *
     * @return property value of invoiceTitle
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * Setter method for property <tt>invoiceTitle</tt>.
     *
     * @param invoiceTitle value to be assigned to property invoiceTitle
     */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    /**
     * Getter method for property <tt>invoiceContent</tt>.
     *
     * @return property value of invoiceContent
     */
    public String getInvoiceContent() {
        return invoiceContent;
    }

    /**
     * Setter method for property <tt>invoiceContent</tt>.
     *
     * @param invoiceContent value to be assigned to property invoiceContent
     */
    public void setInvoiceContent(String invoiceContent) {
        this.invoiceContent = invoiceContent;
    }

    /**
     * Getter method for property <tt>invReceiverTel</tt>.
     *
     * @return property value of invReceiverTel
     */
    public String getInvReceiverTel() {
        return invReceiverTel;
    }

    /**
     * Setter method for property <tt>invReceiverTel</tt>.
     *
     * @param invReceiverTel value to be assigned to property invReceiverTel
     */
    public void setInvReceiverTel(String invReceiverTel) {
        this.invReceiverTel = invReceiverTel;
    }

    /**
     * Getter method for property <tt>invTimeReq</tt>.
     *
     * @return property value of invTimeReq
     */
    public Date getInvTimeReq() {
        return invTimeReq;
    }

    /**
     * Setter method for property <tt>invTimeReq</tt>.
     *
     * @param invTimeReq value to be assigned to property invTimeReq
     */
    public void setInvTimeReq(Date invTimeReq) {
        this.invTimeReq = invTimeReq;
    }

    /**
     * Getter method for property <tt>invReceiverEmail</tt>.
     *
     * @return property value of invReceiverEmail
     */
    public String getInvReceiverEmail() {
        return invReceiverEmail;
    }

    /**
     * Setter method for property <tt>invReceiverEmail</tt>.
     *
     * @param invReceiverEmail value to be assigned to property invReceiverEmail
     */
    public void setInvReceiverEmail(String invReceiverEmail) {
        this.invReceiverEmail = invReceiverEmail;
    }

    /**
     * Getter method for property <tt>invReceiverAddr</tt>.
     *
     * @return property value of invReceiverAddr
     */
    public String getInvReceiverAddr() {
        return invReceiverAddr;
    }

    /**
     * Setter method for property <tt>invReceiverAddr</tt>.
     *
     * @param invReceiverAddr value to be assigned to property invReceiverAddr
     */
    public void setInvReceiverAddr(String invReceiverAddr) {
        this.invReceiverAddr = invReceiverAddr;
    }

    /**
     * Getter method for property <tt>invoiceReq</tt>.
     *
     * @return property value of invoiceReq
     */
    public String getInvoiceReq() {
        return invoiceReq;
    }

    /**
     * Setter method for property <tt>invoiceReq</tt>.
     *
     * @param invoiceReq value to be assigned to property invoiceReq
     */
    public void setInvoiceReq(String invoiceReq) {
        this.invoiceReq = invoiceReq;
    }

    /**
     * Getter method for property <tt>vatInvComp</tt>.
     *
     * @return property value of vatInvComp
     */
    public String getVatInvComp() {
        return vatInvComp;
    }

    /**
     * Setter method for property <tt>vatInvComp</tt>.
     *
     * @param vatInvComp value to be assigned to property vatInvComp
     */
    public void setVatInvComp(String vatInvComp) {
        this.vatInvComp = vatInvComp;
    }

    /**
     * Getter method for property <tt>vatTaxpayer</tt>.
     *
     * @return property value of vatTaxpayer
     */
    public String getVatTaxpayer() {
        return vatTaxpayer;
    }

    /**
     * Setter method for property <tt>vatTaxpayer</tt>.
     *
     * @param vatTaxpayer value to be assigned to property vatTaxpayer
     */
    public void setVatTaxpayer(String vatTaxpayer) {
        this.vatTaxpayer = vatTaxpayer;
    }

    /**
     * Getter method for property <tt>vatAddr</tt>.
     *
     * @return property value of vatAddr
     */
    public String getVatAddr() {
        return vatAddr;
    }

    /**
     * Setter method for property <tt>vatAddr</tt>.
     *
     * @param vatAddr value to be assigned to property vatAddr
     */
    public void setVatAddr(String vatAddr) {
        this.vatAddr = vatAddr;
    }

    /**
     * Getter method for property <tt>vatTel</tt>.
     *
     * @return property value of vatTel
     */
    public String getVatTel() {
        return vatTel;
    }

    /**
     * Setter method for property <tt>vatTel</tt>.
     *
     * @param vatTel value to be assigned to property vatTel
     */
    public void setVatTel(String vatTel) {
        this.vatTel = vatTel;
    }

    /**
     * Getter method for property <tt>vatBank</tt>.
     *
     * @return property value of vatBank
     */
    public String getVatBank() {
        return vatBank;
    }

    /**
     * Setter method for property <tt>vatBank</tt>.
     *
     * @param vatBank value to be assigned to property vatBank
     */
    public void setVatBank(String vatBank) {
        this.vatBank = vatBank;
    }

    /**
     * Getter method for property <tt>vatAccount</tt>.
     *
     * @return property value of vatAccount
     */
    public String getVatAccount() {
        return vatAccount;
    }

    /**
     * Setter method for property <tt>vatAccount</tt>.
     *
     * @param vatAccount value to be assigned to property vatAccount
     */
    public void setVatAccount(String vatAccount) {
        this.vatAccount = vatAccount;
    }
}
