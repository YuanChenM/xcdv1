package com.msk.pl.bean;

import com.msk.core.bean.RsPageParam;

import java.util.Date;


public class IPL20170411Param extends RsPageParam {

    private Long partnerId;
    //0：全部 1.配送站 2.买手
    private Integer selectRule;

    private String crtDate;

    //0查询所有，1查询已完成
    private String countFlg;

    private String bsCode;

    private Long  terminalId;

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getSelectRule() {
        return selectRule;
    }

    public void setSelectRule(Integer selectRule) {
        this.selectRule = selectRule;
    }

    public String getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(String crtDate) {
        this.crtDate = crtDate;
    }

    public String getCountFlg() {
        return countFlg;
    }

    public void setCountFlg(String countFlg) {
        this.countFlg = countFlg;
    }

    public String getBsCode() {
        return bsCode;
    }

    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }
}
