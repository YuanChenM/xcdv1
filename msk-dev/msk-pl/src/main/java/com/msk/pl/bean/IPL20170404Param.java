package com.msk.pl.bean;

import com.msk.core.bean.RsPageParam;

/**
 * Created by zhao_chen on 2017/4/17.
 */
public class IPL20170404Param extends RsPageParam {

    private String bsCode;

    private String ppId;

    private String classesCode;

    private String machiningCode;

    private String status;

    public String getMachiningCode() {
        return machiningCode;
    }

    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }

    public String getBsCode() {
        return bsCode;
    }

    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getClassesCode() {
        return classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
