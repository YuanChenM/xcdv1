package com.msk.so.bean;


import com.msk.core.bean.BaseBean;

/**
 * BaseOrderResult
 *
 * @author sunjiaju
 * @version 1.0
 **/
public class BaseCpResult extends BaseBean {

    /**交易编码*/
    private String transCode;

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

}
