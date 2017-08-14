package com.msk.pl.bean;

import com.msk.core.bean.BaseParam;

/**
 * Created by xuhongyang on 2017/2/6.
 *
 * 外勤用户验证接口入参
 */
public class IPL20170225Param extends BaseParam {

    private String bsCode;//用户外勤365实名

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
}
