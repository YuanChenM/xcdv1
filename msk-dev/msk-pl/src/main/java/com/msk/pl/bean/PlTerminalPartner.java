package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

/**
 * Created by xuhongyang on 2017/2/4.
 * 配送站合伙人信息
 */
public class PlTerminalPartner extends BaseBean {

    //配送站ID
    private Long terminalId;
    //配送站名称
    private String terminalName;
    //配送站所属合伙人ID
    private Long partnerId;
    //配送站所属合伙人名称
    private String partnerName;

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
}
