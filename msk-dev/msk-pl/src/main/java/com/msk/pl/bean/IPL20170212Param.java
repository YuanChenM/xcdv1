package com.msk.pl.bean;

import com.msk.core.bean.BaseParam;

import java.util.Date;

/**
 * Created by xuhongyang on 2017/2/13.
 *
 * 买手计费查询接口入参
 */
public class IPL20170212Param extends BaseParam {

    private String bsCode;//买手编码

    private Date nowMonth;

    private String status;//进货单状态(1.有效 0.无效)


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
     * Getter method for property <tt>nowMonth</tt>.
     *
     * @return property value of nowMonth
     */
    public Date getNowMonth() {
        return nowMonth;
    }

    /**
     * Setter method for property <tt>nowMonth</tt>.
     *
     * @param nowMonth value to be assigned to property nowMonth
     */
    public void setNowMonth(Date nowMonth) {
        this.nowMonth = nowMonth;
    }

    /**
     * Getter method for property <tt>status</tt>.
     *
     * @return property value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     *
     * @param status value to be assigned to property status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
