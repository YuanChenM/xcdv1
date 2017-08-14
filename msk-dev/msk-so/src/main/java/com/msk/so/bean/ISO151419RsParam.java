package com.msk.so.bean;


import com.msk.core.bean.BaseParam;

/**
 * Created by liutao on 2016/10/12.
 */
public class ISO151419RsParam extends BaseParam {
    private Long orderId;

    private String proDate;

    private String pdCode;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProDate() {
        return proDate;
    }

    public void setProDate(String proDate) {
        this.proDate = proDate;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }
}
