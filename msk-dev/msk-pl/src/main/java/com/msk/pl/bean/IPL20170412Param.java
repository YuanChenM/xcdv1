package com.msk.pl.bean;

import com.msk.core.bean.RsPageParam;

import java.util.Date;


public class IPL20170412Param extends RsPageParam {

    //合伙人ID
    private Long partnerId;
    //买手编码
    private String bsCode;
    //进货单创建时间
    private String crtDate;

    private Long taskId;

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getBsCode() {
        return bsCode;
    }

    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }

    public String getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(String crtDate) {
        this.crtDate = crtDate;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
