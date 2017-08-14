package com.msk.pl.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.bean.BaseBean;

import java.math.BigDecimal;

/**
 * Created by gyh on 2017/2/7.
 * 合伙人进货单查看结果
 */
@JsonIgnoreProperties(value={"userRole","ver"})
public class IPL20170217RsResultBean extends BaseBean {
    //进货单ID
    private Long plId;
    //任务ID
    private Long taskId;
    //合伙人ID
    private Long partnerId;
    //配送站ID
    private Long terminalId;
    //领地ID
    private Long domainId;
    //买手编码
    private String bsCode;
    //买家ID
    private int buyerId;
    //买家名称
    private int buyerName;
    //激励费用
    private BigDecimal incentiveFee;
    //进货单金额
    private BigDecimal receiptAmount;
    //进货单状态 1.有效  0.无效
    private byte status;
    //图片上传路径
    private String ftpUrl;
    //备注
    private String remark;
    /** 创建日时 */
    private String reportDate;

    /**
     * Getter method for property <tt>reportDate</tt>.
     *
     * @return property value of reportDate
     */
    public String getReportDate() {
        return reportDate;
    }

    /**
     * Setter method for property <tt>reportDate</tt>.
     *
     * @param reportDate value to be assigned to property reportDate
     */
    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }


    /**
     * Getter method for property <tt>plId</tt>.
     *
     * @return property value of plId
     */
    public Long getPlId() {
        return plId;
    }

    /**
     * Setter method for property <tt>plId</tt>.
     *
     * @param plId value to be assigned to property plId
     */
    public void setPlId(Long plId) {
        this.plId = plId;
    }

    /**
     * Getter method for property <tt>taskId</tt>.
     *
     * @return property value of taskId
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * Setter method for property <tt>taskId</tt>.
     *
     * @param taskId value to be assigned to property taskId
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * Getter method for property <tt>partnerId</tt>.
     *
     * @return property value of partnerId
     */
    public Long getPartnerId() {
        return partnerId;
    }

    /**
     * Setter method for property <tt>partnerId</tt>.
     *
     * @param partnerId value to be assigned to property partnerId
     */
    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    /**
     * Getter method for property <tt>terminalId</tt>.
     *
     * @return property value of terminalId
     */
    public Long getTerminalId() {
        return terminalId;
    }

    /**
     * Setter method for property <tt>terminalId</tt>.
     *
     * @param terminalId value to be assigned to property terminalId
     */
    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    /**
     * Getter method for property <tt>domainId</tt>.
     *
     * @return property value of domainId
     */
    public Long getDomainId() {
        return domainId;
    }

    /**
     * Setter method for property <tt>domainId</tt>.
     *
     * @param domainId value to be assigned to property domainId
     */
    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    /**
     * Getter method for property <tt>bsCode</tt>.
     *
     * @return property value of bsCode
     */
    public String getBsCode() {
        return bsCode;
    }

    /**
     * Setter method for property <tt>bsCode</tt>.
     *
     * @param bsCode value to be assigned to property bsCode
     */
    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }

    /**
     * Getter method for property <tt>buyerId</tt>.
     *
     * @return property value of buyerId
     */
    public int getBuyerId() {
        return buyerId;
    }

    /**
     * Setter method for property <tt>buyerId</tt>.
     *
     * @param buyerId value to be assigned to property buyerId
     */
    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * Getter method for property <tt>buyerName</tt>.
     *
     * @return property value of buyerName
     */
    public int getBuyerName() {
        return buyerName;
    }

    /**
     * Setter method for property <tt>buyerName</tt>.
     *
     * @param buyerName value to be assigned to property buyerName
     */
    public void setBuyerName(int buyerName) {
        this.buyerName = buyerName;
    }

    /**
     * Getter method for property <tt>incentiveFee</tt>.
     *
     * @return property value of incentiveFee
     */
    public BigDecimal getIncentiveFee() {
        return incentiveFee;
    }

    /**
     * Setter method for property <tt>incentiveFee</tt>.
     *
     * @param incentiveFee value to be assigned to property incentiveFee
     */
    public void setIncentiveFee(BigDecimal incentiveFee) {
        this.incentiveFee = incentiveFee;
    }

    /**
     * Getter method for property <tt>receiptAmount</tt>.
     *
     * @return property value of receiptAmount
     */
    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    /**
     * Setter method for property <tt>receiptAmount</tt>.
     *
     * @param receiptAmount value to be assigned to property receiptAmount
     */
    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    /**
     * Getter method for property <tt>status</tt>.
     *
     * @return property value of status
     */
    public byte getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     *
     * @param status value to be assigned to property status
     */
    public void setStatus(byte status) {
        this.status = status;
    }

    /**
     * Getter method for property <tt>ftpUrl</tt>.
     *
     * @return property value of ftpUrl
     */
    public String getFtpUrl() {
        return ftpUrl;
    }

    /**
     * Setter method for property <tt>ftpUrl</tt>.
     *
     * @param ftpUrl value to be assigned to property ftpUrl
     */
    public void setFtpUrl(String ftpUrl) {
        this.ftpUrl = ftpUrl;
    }

    /**
     * Getter method for property <tt>remark</tt>.
     *
     * @return property value of remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Setter method for property <tt>remark</tt>.
     *
     * @param remark value to be assigned to property remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
