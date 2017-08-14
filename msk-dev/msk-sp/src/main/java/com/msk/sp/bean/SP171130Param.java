package com.msk.sp.bean;

import com.msk.core.bean.BaseParam;

import java.math.BigDecimal;

/**
 * Created by wu_honglei
 */
public class SP171130Param extends BaseParam{

    /**供应商名称 */
    private String supperName;

    /** 供应商编码*/
    private String supperCode;

    /**供应商报价*/
    private BigDecimal supPriceOfKgTd;

    public String getSupperName() {
        return supperName;
    }

    public void setSupperName(String supperName) {
        this.supperName = supperName;
    }

    public String getSupperCode() {
        return supperCode;
    }

    public void setSupperCode(String supperCode) {
        this.supperCode = supperCode;
    }

    public BigDecimal getSupPriceOfKgTd() {
        return supPriceOfKgTd;
    }

    public void setSupPriceOfKgTd(BigDecimal supPriceOfKgTd) {
        this.supPriceOfKgTd = supPriceOfKgTd;
    }
}
