package com.msk.pl.bean;

import com.msk.core.bean.BaseParam;

import java.util.Date;

/**
 * Created by tao_zhifa on 2017/4/21.
 */
public class IPL20170408Result extends BaseParam {

    /** 填报期数id */
    private Long ppId;
    /** 填报期数 */
    private String pricePeriod;
    /** 填报日期 */
    private java.util.Date dtDate;
    /** 状态 */
    private Integer dtStatus;
    /** 价盘期日期区间 */
    private String pricePeriodDate;

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

    public Date getDtDate() {
        return dtDate;
    }

    public void setDtDate(Date dtDate) {
        this.dtDate = dtDate;
    }

    public Integer getDtStatus() {
        return dtStatus;
    }

    public void setDtStatus(Integer dtStatus) {
        this.dtStatus = dtStatus;
    }

    public String getPricePeriodDate() {
        return pricePeriodDate;
    }

    public void setPricePeriodDate(String pricePeriodDate) {
        this.pricePeriodDate = pricePeriodDate;
    }
}
