package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by xuhongyang on 2017/2/3.
 * 进货单激励费用配置表
 */
public class PLIncentiveFeeSetting extends BaseBean {

    //激励费用ID
    private Long incentiveFeeId;
    //合伙人ID
    private Long partnerId;
    //配送站ID
    private Long terminalId;
    //买手编码
    private String bsCode;
    //使用对象 0.系统默认1合伙人,2.配送站.3.买手
    private byte userRole;
    //激励费用
    private BigDecimal incentiveFee;
    //生效时间
    private Date effectiveTime;
    //结束时间
    private Date overTime;

    /**
     * Getter method for property <tt>incentiveFeeId</tt>.
     *
     * @return property value of incentiveFeeId
     */
    public Long getIncentiveFeeId() {
        return incentiveFeeId;
    }

    /**
     * Setter method for property <tt>incentiveFeeId</tt>.
     *
     * @param incentiveFeeId value to be assigned to property incentiveFeeId
     */
    public void setIncentiveFeeId(Long incentiveFeeId) {
        this.incentiveFeeId = incentiveFeeId;
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
     * Getter method for property <tt>effectiveTime</tt>.
     *
     * @return property value of effectiveTime
     */
    public Date getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * Setter method for property <tt>effectiveTime</tt>.
     *
     * @param effectiveTime value to be assigned to property effectiveTime
     */
    public void setEffectiveTime(Date effectiveTime) {
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
}
