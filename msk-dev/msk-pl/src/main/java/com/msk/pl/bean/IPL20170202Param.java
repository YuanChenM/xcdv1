package com.msk.pl.bean;

import com.msk.core.bean.BaseParam;

import java.util.Date;

/**
 * Created by xuhongyang on 2017/2/10.
 * <p/>
 * 任务单列表查询接口入参
 */
public class IPL20170202Param extends BaseParam {

    private String bsCode;//买手编码

    private Date nowMonth;

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
}
