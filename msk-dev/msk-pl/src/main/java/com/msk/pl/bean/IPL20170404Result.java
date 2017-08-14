package com.msk.pl.bean;

/**
 * Created by zhao_chen on 2017/4/18.
 */
public class IPL20170404Result extends PlDeclareInfo {

    private String status;

    private Long taskId;

    //task表里面的状态
    private String dtStatus;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getDtStatus() {
        return dtStatus;
    }

    public void setDtStatus(String dtStatus) {
        this.dtStatus = dtStatus;
    }
}
