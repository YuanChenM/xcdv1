package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

import java.util.Date;

/**
 * Created by zhao_chen on 2017/4/17.
 */
public class IPL20170401Result extends BaseBean {

    private Long ppId;

    private String pricePeriod;

    private String pricePeriodCode;

    private String pricePeriodDate;

    private String declareYM;

    private String pricePeriodYear;

    private String pricePeriodMonth;

    private Date INPUT_START_DATE;

    private Date inputEndDate;

    public Long getPpId() {
        return ppId;
    }

    public void setPpId(Long ppId) {
        this.ppId = ppId;
    }

    public String getPricePeriod() {
        return pricePeriod;
    }

    public void setPricePeriod(String pricePeriod) {
        this.pricePeriod = pricePeriod;
    }

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

    public String getPricePeriodYear() {
        return pricePeriodYear;
    }

    public void setPricePeriodYear(String pricePeriodYear) {
        this.pricePeriodYear = pricePeriodYear;
    }

    public String getPricePeriodMonth() {
        return pricePeriodMonth;
    }

    public void setPricePeriodMonth(String pricePeriodMonth) {
        this.pricePeriodMonth = pricePeriodMonth;
    }

    public Date getINPUT_START_DATE() {
        return INPUT_START_DATE;
    }

    public void setINPUT_START_DATE(Date INPUT_START_DATE) {
        this.INPUT_START_DATE = INPUT_START_DATE;
    }

    public Date getInputEndDate() {
        return inputEndDate;
    }

    public void setInputEndDate(Date inputEndDate) {
        this.inputEndDate = inputEndDate;
    }
}
