package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

/**
 * Created by xuhongyang on 2017/2/4.
 * 领地
 */
public class PlDomain extends BaseBean {

    //领地ID
    private Long domainId;
    //配送站ID
    private Long terminalId;
    //配送站名称
    private String terminalName;
    //领地编码
    private String domainCode;
    //领地名称
    private String domainName;
    //邮编
    private String zipCode;

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
     * Getter method for property <tt>domainCode</tt>.
     *
     * @return property value of domainCode
     */
    public String getDomainCode() {
        return domainCode;
    }

    /**
     * Setter method for property <tt>domainCode</tt>.
     *
     * @param domainCode value to be assigned to property domainCode
     */
    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    /**
     * Getter method for property <tt>domainName</tt>.
     *
     * @return property value of domainName
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * Setter method for property <tt>domainName</tt>.
     *
     * @param domainName value to be assigned to property domainName
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    /**
     * Getter method for property <tt>zipCode</tt>.
     *
     * @return property value of zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Setter method for property <tt>zipCode</tt>.
     *
     * @param zipCode value to be assigned to property zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
