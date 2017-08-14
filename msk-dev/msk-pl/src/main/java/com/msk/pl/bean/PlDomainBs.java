package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

/**
 * Created by xuhongyang on 2017/2/4.
 * 领地买手信息
 */
public class PlDomainBs extends BaseBean {

    //领地买手ID
    private Long bsId;
    //领地ID
    private Long domainId;
    //领地编码
    private String domainCode;
    //领地名称
    private String domainName;
    //配送站ID
    private Long terminalId;
    //配送站名称
    private String terminalName;
    //买手编码
    private String bsCode;
    //买手名称
    private String bsName;

    /**
     * Getter method for property <tt>bsId</tt>.
     *
     * @return property value of bsId
     */
    public Long getBsId() {
        return bsId;
    }

    /**
     * Setter method for property <tt>bsId</tt>.
     *
     * @param bsId value to be assigned to property bsId
     */
    public void setBsId(Long bsId) {
        this.bsId = bsId;
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
}
