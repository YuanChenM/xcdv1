package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

import java.util.Date;

/**
 * Created by xuhongyang on 2017/2/3.
 * 买手每日进货单填报任务表
 */
public class PlBsTask extends BaseBean{



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
    //填报次数
    private int needRecordNumber;
    //已报次数
    private int alreadyRecordNumber;
    //当前时间
    private Date nowTime;
    //是否完成 0.未完成   1.完成
    private int status;


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
     * Getter method for property <tt>nowTime</tt>.
     *
     * @return property value of nowTime
     */
    public Date getNowTime() {
        return nowTime;
    }

    /**
     * Setter method for property <tt>nowTime</tt>.
     *
     * @param nowTime value to be assigned to property nowTime
     */
    public void setNowTime(Date nowTime) {
        this.nowTime = nowTime;
    }

    /**
     * Getter method for property <tt>status</tt>.
     *
     * @return property value of status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     *
     * @param status value to be assigned to property status
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
