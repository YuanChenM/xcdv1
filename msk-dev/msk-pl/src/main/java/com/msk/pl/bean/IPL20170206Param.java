package com.msk.pl.bean;

import com.msk.core.bean.BaseParam;

import java.util.Date;

/**
 * Created by xuhongyang on 2017/2/14.
 *
 * 产品查询接口入参
 */
public class IPL20170206Param extends BaseParam {

    private String  pdName ;//产品名称 包含特征

    /**
     * Getter method for property <tt>pdName</tt>.
     *
     * @return property value of pdName
     */
    public String getPdName() {
        return pdName;
    }

    /**
     * Setter method for property <tt>pdName</tt>.
     *
     * @param pdName value to be assigned to property pdName
     */
    public void setPdName(String pdName) {
        this.pdName = pdName;
    }
}
