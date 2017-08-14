package com.msk.pl.bean;

import com.msk.core.bean.BaseParam;

import java.util.List;

/**
 * Created by tao_zhifa on 2017/4/17.
 */
public class IPL20170406Param extends BaseParam {
    private Long ppId;
    private String bsCode;//用户外勤365实名
    private List<IPL20170406Param> pdCodeList;
    private String pdCode;

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

    public List<IPL20170406Param> getPdCodeList() {
        return pdCodeList;
    }

    public void setPdCodeList(List<IPL20170406Param> pdCodeList) {
        this.pdCodeList = pdCodeList;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }
}
