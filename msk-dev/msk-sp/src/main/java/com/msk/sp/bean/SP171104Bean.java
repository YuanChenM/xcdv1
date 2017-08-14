package com.msk.sp.bean;

import com.msk.core.entity.BaseEntity;

/**
 * 神农客价盘磋商分配bean
 */
public class SP171104Bean extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**  */
    private String companyId;

    /**  */
    private String companyCode;

    /**  */
    private String companyName;

    /**  */
    private String showName;

    /**  */
    private String account;

    /**  */
    private String mobilePhone;

    /**  */
    private String allotNum;

    /**  */
    private String declareNum;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAllotNum() {
        return allotNum;
    }

    public void setAllotNum(String allotNum) {
        this.allotNum = allotNum;
    }

    public String getDeclareNum() {
        return declareNum;
    }

    public void setDeclareNum(String declareNum) {
        this.declareNum = declareNum;
    }

}
