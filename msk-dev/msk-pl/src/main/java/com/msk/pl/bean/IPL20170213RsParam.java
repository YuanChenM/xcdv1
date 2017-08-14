package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

import java.util.Date;

/**
 * Created by gyh on 2017/2/16.
 * 进货单填报规则表
 */
public class IPL20170213RsParam extends BaseBean {

    //填报ID
    private Long statementId;
    //合伙人ID
    private Long partnerId;
    //配送站ID
    private Long terminalId;
    //买手编码
    private String bsCode;
    //使用对象 0.系统默认1合伙人,2.配送站.3.买手
    private byte userRole;
    //填报数量
    private int statementNumber;
    //补报天数
    private int repayDay;
    //生效时间
    private String effectiveTime;
    //生效时间
    private Date effectiveDate;
    //结束时间
    private Date overTime;
    //备注
    private String remark;


    /**
     * Getter method for property <tt>effectiveDate</tt>.
     *
     * @return property value of effectiveDate
     */
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Setter method for property <tt>effectiveDate</tt>.
     *
     * @param effectiveDate value to be assigned to property effectiveDate
     */
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * Getter method for property <tt>statementId</tt>.
     *
     * @return property value of statementId
     */
    public Long getStatementId() {
        return statementId;
    }

    /**
     * Setter method for property <tt>statementId</tt>.
     *
     * @param statementId value to be assigned to property statementId
     */
    public void setStatementId(Long statementId) {
        this.statementId = statementId;
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
     * Getter method for property <tt>userRole</tt>.
     *
     * @return property value of userRole
     */
    public byte getUserRole() {
        return userRole;
    }

    /**
     * Setter method for property <tt>userRole</tt>.
     *
     * @param userRole value to be assigned to property userRole
     */
    public void setUserRole(byte userRole) {
        this.userRole = userRole;
    }

    /**
     * Getter method for property <tt>statementNumber</tt>.
     *
     * @return property value of statementNumber
     */
    public int getStatementNumber() {
        return statementNumber;
    }

    /**
     * Setter method for property <tt>statementNumber</tt>.
     *
     * @param statementNumber value to be assigned to property statementNumber
     */
    public void setStatementNumber(int statementNumber) {
        this.statementNumber = statementNumber;
    }

    /**
     * Getter method for property <tt>repayDay</tt>.
     *
     * @return property value of repayDay
     */
    public int getRepayDay() {
        return repayDay;
    }

    /**
     * Setter method for property <tt>repayDay</tt>.
     *
     * @param repayDay value to be assigned to property repayDay
     */
    public void setRepayDay(int repayDay) {
        this.repayDay = repayDay;
    }

    /**
     * Getter method for property <tt>effectiveTime</tt>.
     *
     * @return property value of effectiveTime
     */
    public String getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * Setter method for property <tt>effectiveTime</tt>.
     *
     * @param effectiveTime value to be assigned to property effectiveTime
     */
    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    /**
     * Getter method for property <tt>overTime</tt>.
     *
     * @return property value of overTime
     */
    public Date getOverTime() {
        return overTime;
    }

    /**
     * Setter method for property <tt>overTime</tt>.
     *
     * @param overTime value to be assigned to property overTime
     */
    public void setOverTime(Date overTime) {
        this.overTime = overTime;
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
