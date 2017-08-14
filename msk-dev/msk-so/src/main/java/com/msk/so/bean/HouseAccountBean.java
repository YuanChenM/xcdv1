package com.msk.so.bean;

import com.msk.core.bean.BaseParam;


/**
 *
 * 管家bean
 *
 * @author sjj
 */
public class HouseAccountBean extends BaseParam {
    // 管家ID
    private String houseCode;
    // 销售月份
    private String saleMonth;
    // 物流区编码
    private String lgcsAreaCode;
    // 产品一级分类
    private String pdClassCode;

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    public String getSaleMonth() {
        return saleMonth;
    }

    public void setSaleMonth(String saleMonth) {
        this.saleMonth = saleMonth;
    }

    public String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    public void setLgcsAreaCode(String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    public String getPdClassCode() {
        return pdClassCode;
    }

    public void setPdClassCode(String pdClassCode) {
        this.pdClassCode = pdClassCode;
    }
}