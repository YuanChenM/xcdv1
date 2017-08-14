package com.msk.pl.bean;

import com.msk.core.bean.BaseParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tao_zhifa on 2017/4/17.
 */
public class IPL20170408Param extends BaseParam {

    private Long ppId;
    private String bsCode;//用户外勤365实名
    private String isChecked;
    private String bsName;
    private String pricePeriodYm;

    public String getPricePeriodYm() {
        return pricePeriodYm;
    }

    public void setPricePeriodYm(String pricePeriodYm) {
        this.pricePeriodYm = pricePeriodYm;
    }

    public String getBsName() {
        return bsName;
    }

    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    public String getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }

    public Long getPpId() {
        return ppId;
    }

    public void setPpId(Long ppId) {
        this.ppId = ppId;
    }

    public String getBsCode() {
        return bsCode;
    }

    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }
}
