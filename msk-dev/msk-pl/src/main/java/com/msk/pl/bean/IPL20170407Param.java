package com.msk.pl.bean;

import com.msk.core.bean.BaseParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tao_zhifa on 2017/4/17.
 */
public class IPL20170407Param extends BaseParam {
    private Long ppId;
    private String bsCode;//用户外勤365实名
    private Long dtDetailId;
    private String pdCode;
    private String pdName;
    private String taskId;
    private BigDecimal declarePrice;
    private List<IPL20170407Param> detailList;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Long getPpId() {
        return ppId;
    }

    public Long getDtDetailId() {
        return dtDetailId;
    }

    public void setDtDetailId(Long dtDetailId) {
        this.dtDetailId = dtDetailId;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public BigDecimal getDeclarePrice() {
        return declarePrice;
    }

    public void setDeclarePrice(BigDecimal declarePrice) {
        this.declarePrice = declarePrice;
    }

    public List<IPL20170407Param> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<IPL20170407Param> detailList) {
        this.detailList = detailList;
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
