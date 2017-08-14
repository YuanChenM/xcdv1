package com.msk.so.bean;

import com.msk.core.bean.RsPageParam;

/**
 * Created by liutao on 2016/10/11.
 */
public class ISO151418RsParam extends RsPageParam {

    private Long orderId;

    private String pdCode;

    private String proDate;

    private Integer pdSearchMode;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getProDate() {
        return proDate;
    }

    public void setProDate(String proDate) {
        this.proDate = proDate;
    }

    public Integer getPdSearchMode() {
        return pdSearchMode;
    }

    public void setPdSearchMode(Integer pdSearchMode) {
        this.pdSearchMode = pdSearchMode;
    }
}
