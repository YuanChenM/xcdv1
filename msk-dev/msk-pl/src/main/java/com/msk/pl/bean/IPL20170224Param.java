package com.msk.pl.bean;

import com.msk.core.bean.BaseParam;

import java.util.Date;

/**
 * Created by xuhongyang on 2017/2/6.
 *
 * 外勤用户验证接口入参
 */
public class IPL20170224Param extends BaseParam {

    private String bsCode;//任务编号

    private Date reportDate;//任务

    /**
     * Getter method for property <tt>bsCode</tt>.
     *
     * @return property value of bsCode
     */
    public String getBsCode() {
        return bsCode;
    }

    /**
     * Setter method for property <tt>bsCode</tt>.
     *
     * @param bsCode value to be assigned to property bsCode
     */
    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }

    /**
     * Getter method for property <tt>reportDate</tt>.
     *
     * @return property value of reportDate
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * Setter method for property <tt>reportDate</tt>.
     *
     * @param reportDate value to be assigned to property reportDate
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
}
