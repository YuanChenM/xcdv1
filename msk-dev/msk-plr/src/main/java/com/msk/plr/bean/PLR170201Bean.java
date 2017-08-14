package com.msk.plr.bean;

import com.msk.core.bean.BaseBean;

import java.math.BigDecimal;

/**
 * SL241101Bean
 *
 * @author gyh
 * @version 1.0
 **/
public class PLR170201Bean extends BaseBean {
    //合伙人id
    private Long partnerId;
    //合伙人
    private String partnerName;
    //配送站id
    private Long terminalId;
    //配送站
    private String terminalName;
    //买手编码
    private String bsCode;
    //买手
    private String bsName;
    //时间
    private String crtDate;
    //有效进货单数
    private int validInfo;
    //无效进货单数
    private int invalidInfo;
    //激励费用总金额
    private BigDecimal allFee;

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
     * Getter method for property <tt>partnerName</tt>.
     *
     * @return property value of partnerName
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * Setter method for property <tt>partnerName</tt>.
     *
     * @param partnerName value to be assigned to property partnerName
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
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
     * Getter method for property <tt>terminalName</tt>.
     *
     * @return property value of terminalName
     */
    public String getTerminalName() {
        return terminalName;
    }

    /**
     * Setter method for property <tt>terminalName</tt>.
     *
     * @param terminalName value to be assigned to property terminalName
     */
    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
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
     * Getter method for property <tt>bsName</tt>.
     *
     * @return property value of bsName
     */
    public String getBsName() {
        return bsName;
    }

    /**
     * Setter method for property <tt>bsName</tt>.
     *
     * @param bsName value to be assigned to property bsName
     */
    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    /**
     * Getter method for property <tt>crtDate</tt>.
     *
     * @return property value of crtDate
     */
    public String getCrtDate() {
        return crtDate;
    }

    /**
     * Setter method for property <tt>crtDate</tt>.
     *
     * @param crtDate value to be assigned to property crtDate
     */
    public void setCrtDate(String crtDate) {
        this.crtDate = crtDate;
    }

    /**
     * Getter method for property <tt>validInfo</tt>.
     *
     * @return property value of validInfo
     */
    public int getValidInfo() {
        return validInfo;
    }

    /**
     * Setter method for property <tt>validInfo</tt>.
     *
     * @param validInfo value to be assigned to property validInfo
     */
    public void setValidInfo(int validInfo) {
        this.validInfo = validInfo;
    }

    /**
     * Getter method for property <tt>invalidInfo</tt>.
     *
     * @return property value of invalidInfo
     */
    public int getInvalidInfo() {
        return invalidInfo;
    }

    /**
     * Setter method for property <tt>invalidInfo</tt>.
     *
     * @param invalidInfo value to be assigned to property invalidInfo
     */
    public void setInvalidInfo(int invalidInfo) {
        this.invalidInfo = invalidInfo;
    }

    /**
     * Getter method for property <tt>allFee</tt>.
     *
     * @return property value of allFee
     */
    public BigDecimal getAllFee() {
        return allFee;
    }

    /**
     * Setter method for property <tt>allFee</tt>.
     *
     * @param allFee value to be assigned to property allFee
     */
    public void setAllFee(BigDecimal allFee) {
        this.allFee = allFee;
    }
}
