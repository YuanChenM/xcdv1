package com.msk.sp.bean;

import com.msk.core.entity.BaseEntity;

/**
 * 神农客卖家产品价盘bean
 */
public class SP171128Bean extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String lgcsName;
    private String pdName;
    private String machining;
    private String feacherName;
    private String weightVal;
    private String pdLevel;
    private String pdCode;
    private String stockWeight;
    private String quotationStatus;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLgcsName() {
        return lgcsName;
    }

    public void setLgcsName(String lgcsName) {
        this.lgcsName = lgcsName;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getMachining() {
        return machining;
    }

    public void setMachining(String machining) {
        this.machining = machining;
    }

    public String getFeacherName() {
        return feacherName;
    }

    public void setFeacherName(String feacherName) {
        this.feacherName = feacherName;
    }

    public String getWeightVal() {
        return weightVal;
    }

    public void setWeightVal(String weightVal) {
        this.weightVal = weightVal;
    }

    public String getPdLevel() {
        return pdLevel;
    }

    public void setPdLevel(String pdLevel) {
        this.pdLevel = pdLevel;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getStockWeight() {
        return stockWeight;
    }

    public void setStockWeight(String stockWeight) {
        this.stockWeight = stockWeight;
    }

    public String getQuotationStatus() {
        return quotationStatus;
    }

    public void setQuotationStatus(String quotationStatus) {
        this.quotationStatus = quotationStatus;
    }
}
