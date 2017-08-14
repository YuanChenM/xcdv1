package com.msk.sp.bean;

import com.msk.core.entity.BaseEntity;

/**
 * 神农客价盘需求数量发布bean
 */
public class SP171103Bean extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**  */
    private String pdName;

    /**  */
    private String pdCode;

    /**  */
    private String pdBreed;

    /**  */
    private String pdFeature;

    /**  */
    private String pdWeight;

    /**  */
    private String pdPackage;

    /**  */
    private String needNum;

    /**  */
    private String isBid;

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdBreed() {
        return pdBreed;
    }

    public void setPdBreed(String pdBreed) {
        this.pdBreed = pdBreed;
    }

    public String getPdFeature() {
        return pdFeature;
    }

    public void setPdFeature(String pdFeature) {
        this.pdFeature = pdFeature;
    }

    public String getPdWeight() {
        return pdWeight;
    }

    public void setPdWeight(String pdWeight) {
        this.pdWeight = pdWeight;
    }

    public String getPdPackage() {
        return pdPackage;
    }

    public void setPdPackage(String pdPackage) {
        this.pdPackage = pdPackage;
    }

    public String getNeedNum() {
        return needNum;
    }

    public void setNeedNum(String needNum) {
        this.needNum = needNum;
    }

    public String getIsBid() {
        return isBid;
    }

    public void setIsBid(String isBid) {
        this.isBid = isBid;
    }
}
