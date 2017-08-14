package com.msk.pl.bean;

import java.util.Date;

/**
 * Created by zhao_chen on 2017/4/17.
 */
public class IPL20170402Result extends PlDeclareTask {

    /**
     * 价盘编码
     */
    private String pricePeriodCode;
    /**
     * 价盘期日期区间
     */
    private String pricePeriodDate;
    /**
     * 价盘期对应年月
     */
    private String declareYM;
    /**
     * 价盘期对应月
     */
    private String pricePeriodMonth;
    /**
     * 可填报开始日期
     */
    private java.util.Date inputStartDate;
    /**
     * 可填报截止日期
     */
    private java.util.Date inputEndDate;

    private String status;

    public String getPricePeriodCode() {
        return pricePeriodCode;
    }

    public void setPricePeriodCode(String pricePeriodCode) {
        this.pricePeriodCode = pricePeriodCode;
    }

    public String getPricePeriodDate() {
        return pricePeriodDate;
    }

    public void setPricePeriodDate(String pricePeriodDate) {
        this.pricePeriodDate = pricePeriodDate;
    }

    public String getDeclareYM() {
        return declareYM;
    }

    public void setDeclareYM(String declareYM) {
        this.declareYM = declareYM;
    }

    public String getPricePeriodMonth() {
        return pricePeriodMonth;
    }

    public void setPricePeriodMonth(String pricePeriodMonth) {
        this.pricePeriodMonth = pricePeriodMonth;
    }

    public Date getInputStartDate() {
        return inputStartDate;
    }

    public void setInputStartDate(Date inputStartDate) {
        this.inputStartDate = inputStartDate;
    }

    public Date getInputEndDate() {
        return inputEndDate;
    }

    public void setInputEndDate(Date inputEndDate) {
        this.inputEndDate = inputEndDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
