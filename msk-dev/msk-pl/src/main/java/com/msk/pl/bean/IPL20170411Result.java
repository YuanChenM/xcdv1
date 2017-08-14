package com.msk.pl.bean;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhao_chen on 2017/5/4.
 */
public class IPL20170411Result extends BaseEntity {

    private String bsCode;
    private String bsName;
    private Long terminalId;
    private String terminalName;
    //计划完成数量
    private Integer needRecordNumber;
    //实际完成数量
    private Integer alreadyRecordNumber;
    //无效完成数量
    private Integer invalidInfo;
    //实际完成数量百分比
    private BigDecimal percent;
    private String crtDate;
    private Long partnerId;
    private Integer selectRule;
    private Long ppId;

    public String getBsCode() {
        return bsCode;
    }

    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }

    public String getBsName() {
        return bsName;
    }

    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public Integer getNeedRecordNumber() {
        return needRecordNumber;
    }

    public void setNeedRecordNumber(Integer needRecordNumber) {
        this.needRecordNumber = needRecordNumber;
    }

    public Integer getAlreadyRecordNumber() {
        return alreadyRecordNumber;
    }

    public void setAlreadyRecordNumber(Integer alreadyRecordNumber) {
        this.alreadyRecordNumber = alreadyRecordNumber;
    }

    public Integer getInvalidInfo() {
        return invalidInfo;
    }

    public void setInvalidInfo(Integer invalidInfo) {
        this.invalidInfo = invalidInfo;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public String getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(String crtDate) {
        this.crtDate = crtDate;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getSelectRule() {
        return selectRule;
    }

    public void setSelectRule(Integer selectRule) {
        this.selectRule = selectRule;
    }

    public Long getPpId() {
        return ppId;
    }

    public void setPpId(Long ppId) {
        this.ppId = ppId;
    }
}
