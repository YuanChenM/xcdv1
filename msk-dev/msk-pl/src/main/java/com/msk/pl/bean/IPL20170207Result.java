package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

/**
 * Created by xuhongyang on 2017/2/6.
 */
public class IPL20170207Result extends BaseBean {

    //买家ID
    private String buyerId;
    //买家名称
    private String buyerName;
    //买手编码
    private String bsCode;
    //买手名称
    private String bsName;
    //配送站ID
    private Long terminalId;
    //配送站名称
    private String terminalName;

    /**
     * Getter method for property <tt>buyerId</tt>.
     *
     * @return property value of buyerId
     */
    public String getBuyerId() {
        return buyerId;
    }

    /**
     * Setter method for property <tt>buyerId</tt>.
     *
     * @param buyerId value to be assigned to property buyerId
     */
    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * Getter method for property <tt>buyerName</tt>.
     *
     * @return property value of buyerName
     */
    public String getBuyerName() {
        return buyerName;
    }

    /**
     * Setter method for property <tt>buyerName</tt>.
     *
     * @param buyerName value to be assigned to property buyerName
     */
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
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
}
