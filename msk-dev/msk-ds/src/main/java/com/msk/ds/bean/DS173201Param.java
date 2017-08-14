package com.msk.ds.bean;

import java.math.BigDecimal;
import java.util.List;

/**
 * zhou_yajun on 2016/1/28.
 */
public class DS173201Param {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private  String areaCode;

    private String sellerCode;

    private  String areaName;

    private String sellerName;

    private String distMonth;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getDistMonth() {
        return distMonth;
    }

    public void setDistMonth(String distMonth) {
        this.distMonth = distMonth;
    }
}
