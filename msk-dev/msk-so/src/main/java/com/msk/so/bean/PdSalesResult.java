package com.msk.so.bean;

import com.msk.core.bean.BaseBean;


/**
 *
 * 产品销量信息.
 *
 * @author sjj
 */
public class PdSalesResult extends BaseBean {
    /** 产品编码*/
    private String pdCode;
    /** 销量Str*/
    private String salesVolumn;
    /** 销量*/
    private Long salesVolumnLong;

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getSalesVolumn() {
        return salesVolumn;
    }

    public void setSalesVolumn(String salesVolumn) {
        this.salesVolumn = salesVolumn;
    }

    public Long getSalesVolumnLong() {
        return salesVolumnLong;
    }

    public void setSalesVolumnLong(Long salesVolumnLong) {
        this.salesVolumnLong = salesVolumnLong;
    }
}