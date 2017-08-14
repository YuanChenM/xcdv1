package com.msk.pl.bean;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * Created by gyh on 2017/2/9.
 * 合伙人任务完成统计结果
 */
public class IPL20170223RsResultBean extends BaseEntity {
    //配送站ID
    private Long terminalId;
    //配送站名称
    private String terminalName;
    //买手编码
    private String bsCode;
    //买手名称
    private String bsName;
    //填报次数
    private int needRecordNumber;
    //已报次数
    private int alreadyRecordNumber;
    //无效数量
    private Integer invalidInfo;
    //实际完成占计划完成百分比
    private BigDecimal percent;

    /**
     * Getter method for property <tt>percent</tt>.
     *
     * @return property value of percent
     */
    public BigDecimal getPercent() {
        return percent;
    }

    /**
     * Setter method for property <tt>percent</tt>.
     *
     * @param percent value to be assigned to property percent
     */
    public void setPercent(BigDecimal percent) {
        this.percent = percent;
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
     * Getter method for property <tt>needRecordNumber</tt>.
     *
     * @return property value of needRecordNumber
     */
    public int getNeedRecordNumber() {
        return needRecordNumber;
    }

    /**
     * Setter method for property <tt>needRecordNumber</tt>.
     *
     * @param needRecordNumber value to be assigned to property needRecordNumber
     */
    public void setNeedRecordNumber(int needRecordNumber) {
        this.needRecordNumber = needRecordNumber;
    }

    /**
     * Getter method for property <tt>alreadyRecordNumber</tt>.
     *
     * @return property value of alreadyRecordNumber
     */
    public int getAlreadyRecordNumber() {
        return alreadyRecordNumber;
    }

    /**
     * Setter method for property <tt>alreadyRecordNumber</tt>.
     *
     * @param alreadyRecordNumber value to be assigned to property alreadyRecordNumber
     */
    public void setAlreadyRecordNumber(int alreadyRecordNumber) {
        this.alreadyRecordNumber = alreadyRecordNumber;
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
