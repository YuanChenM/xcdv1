package com.msk.pl.bean;

import com.msk.core.bean.RsPageParam;

/**
 * Created by tao_zhifa on 2017/4/17.
 */
public class IPL20170405Param extends RsPageParam {

    /** 一级分类code */
    private String classesCode;

    /** 二级分类code */
    private String machiningCode;

    private Long ppId;
    private String bsCode;//用户外勤365实名

    public String getClassesCode() {
        return classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    public String getMachiningCode() {
        return machiningCode;
    }

    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }

    public Long getPpId() {
        return ppId;
    }

    public void setPpId(Long ppId) {
        this.ppId = ppId;
    }

    public String getBsCode() {
        return bsCode;
    }

    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }
}
