package com.msk.pl.bean;

import com.msk.core.bean.BaseParam;

/**
 * Created by xuhongyang on 2017/2/6.
 *
 * 进货单删除接口入参
 */
public class IPL20170203Param extends BaseParam {

    private Long plId;//进货单Id

    /**
     * Getter method for property <tt>plId</tt>.
     *
     * @return property value of plId
     */
    public Long getPlId() {
        return plId;
    }

    /**
     * Setter method for property <tt>plId</tt>.
     *
     * @param plId value to be assigned to property plId
     */
    public void setPlId(Long plId) {
        this.plId = plId;
    }
}
