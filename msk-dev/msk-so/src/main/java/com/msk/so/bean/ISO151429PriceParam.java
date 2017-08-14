package com.msk.so.bean;

import com.msk.core.bean.RsPageParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang_shuai on 2016/6/24.
 */
public class ISO151429PriceParam extends RsPageParam {
    /*产品编码*/
    private String pdCode;
    /*物流区编码*/
    private String lgcsCode;
    /*价盘周期*/
    private String pricePeriod;

    private List<String> pdCodes;

    private List<ISO151429PriceParam> params = new ArrayList<>();

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getLgcsCode() {
        return lgcsCode;
    }

    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    public String getPricePeriod() {
        return pricePeriod;
    }

    public void setPricePeriod(String pricePeriod) {
        this.pricePeriod = pricePeriod;
    }

    public List<String> getPdCodes() {
        return pdCodes;
    }

    public void setPdCodes(List<String> pdCodes) {
        this.pdCodes = pdCodes;
    }

    public List<ISO151429PriceParam> getParams() {
        return params;
    }

    public void setParams(List<ISO151429PriceParam> params) {
        this.params = params;
    }
}
