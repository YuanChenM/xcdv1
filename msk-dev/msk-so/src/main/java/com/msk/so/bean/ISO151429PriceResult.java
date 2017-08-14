package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * Created by wang_shuai on 2016/6/24.
 */
public class ISO151429PriceResult extends BaseEntity {
    /*物流区编码*/
    private String lgcsCode;
    /*价盘周期*/
    private String pricePeriod;
    /*产品编码和箱价的list*/
    private List<ISO151429PriceBean> searchList ;



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

    public List<ISO151429PriceBean> getSearchList() {
        return searchList;
    }

    public void setSearchList(List<ISO151429PriceBean> searchList) {
        this.searchList = searchList;
    }
}
