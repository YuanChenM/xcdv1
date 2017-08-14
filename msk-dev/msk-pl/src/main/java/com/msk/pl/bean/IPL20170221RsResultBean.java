package com.msk.pl.bean;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * Created by gyh on 2017/2/8.
 * 合伙人计费查询结果
 */
public class IPL20170221RsResultBean extends BaseEntity{
    //配送站ID
    private Long terminalId;
    //配送站名称
    private String terminalName;
    //买手编码
    private String bsCode;
    //买手名称
    private String bsName;
    //激励费用
    private BigDecimal allFee;
    //有效数量
    private Integer validInfo;
    //无效数量
    private Integer invalidInfo;

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

    /**
     * Getter method for property <tt>validInfo</tt>.
     *
     * @return property value of validInfo
     */
    public Integer getValidInfo() {
        return validInfo;
    }

    /**
     * Setter method for property <tt>validInfo</tt>.
     *
     * @param validInfo value to be assigned to property validInfo
     */
    public void setValidInfo(Integer validInfo) {
        this.validInfo = validInfo;
    }

    /**
     * Getter method for property <tt>invalidInfo</tt>.
     *
     * @return property value of invalidInfo
     */
    public Integer getInvalidInfo() {
        return invalidInfo;
    }

    /**
     * Setter method for property <tt>invalidInfo</tt>.
     *
     * @param invalidInfo value to be assigned to property invalidInfo
     */
    public void setInvalidInfo(Integer invalidInfo) {
        this.invalidInfo = invalidInfo;
    }
}
