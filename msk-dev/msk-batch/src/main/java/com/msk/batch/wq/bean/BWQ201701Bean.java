package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.msk.core.bean.BaseBean;

import java.util.Date;

/**
 * Created by air on 2017/1/10.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BWQ201701Bean extends BaseBean{

    private Long tblId;
    private String cmId;
    private String cmName;
    private String cmCode;
    private String cmManager;
    private String cmManagerId;
    private String cmType;
    private String cmTypeCode;

    private String cmDistrict;
    private String cmMssProvince;
    private String cmMssCity;
    private String cmMssArea;
    private String cmAddr;
    private String cmDeliveryAddr;
    private String id;


    @Override
    public String toString() {
        return "BWQ201701Bean{" +
                "tblId=" + tblId +
                ", cmId='" + cmId + '\'' +
                ", cmName='" + cmName + '\'' +
                ", cmCode='" + cmCode + '\'' +
                ", cmManager='" + cmManager + '\'' +
                ", cmManagerId='" + cmManagerId + '\'' +
                ", cmType='" + cmType + '\'' +
                ", cmTypeCode='" + cmTypeCode + '\'' +
                ", cmDistrict='" + cmDistrict + '\'' +
                ", cmMssProvince='" + cmMssProvince + '\'' +
                ", cmMssCity='" + cmMssCity + '\'' +
                ", cmMssArea='" + cmMssArea + '\'' +
                ", cmAddr='" + cmAddr + '\'' +
                ", cmDeliveryAddr='" + cmDeliveryAddr + '\'' +
                '}';
    }

    public String getCmDistrict() {
        return cmDistrict;
    }

    public void setCmDistrict(String cmDistrict) {
        this.cmDistrict = cmDistrict;
    }

    public String getCmMssProvince() {
        return cmMssProvince;
    }

    public void setCmMssProvince(String cmMssProvince) {
        this.cmMssProvince = cmMssProvince;
    }

    public String getCmMssCity() {
        return cmMssCity;
    }

    public void setCmMssCity(String cmMssCity) {
        this.cmMssCity = cmMssCity;
    }

    public String getCmMssArea() {
        return cmMssArea;
    }

    public void setCmMssArea(String cmMssArea) {
        this.cmMssArea = cmMssArea;
    }

    public String getCmAddr() {
        return cmAddr;
    }

    public void setCmAddr(String cmAddr) {
        this.cmAddr = cmAddr;
    }

    public String getCmDeliveryAddr() {
        return cmDeliveryAddr;
    }

    public void setCmDeliveryAddr(String cmDeliveryAddr) {
        this.cmDeliveryAddr = cmDeliveryAddr;
    }





    public Long getTblId() {
        return tblId;
    }

    public void setTblId(Long tblId) {
        this.tblId = tblId;
    }
    public String getCmId() {
        return cmId;
    }

    public void setCmId(String cmId) {
        this.cmId = cmId;
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName;
    }

    public String getCmCode() {
        return cmCode;
    }

    public void setCmCode(String cmCode) {
        this.cmCode = cmCode;
    }

    public String getCmManager() {
        return cmManager;
    }

    public void setCmManager(String cmManager) {
        this.cmManager = cmManager;
    }

    public String getCmManagerId() {
        return cmManagerId;
    }

    public void setCmManagerId(String cmManagerId) {
        this.cmManagerId = cmManagerId;
    }

    public String getCmType() {
        return cmType;
    }

    public void setCmType(String cmType) {
        this.cmType = cmType;
    }

    public String getCmTypeCode() {
        return cmTypeCode;
    }

    public void setCmTypeCode(String cmTypeCode) {
        this.cmTypeCode = cmTypeCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
