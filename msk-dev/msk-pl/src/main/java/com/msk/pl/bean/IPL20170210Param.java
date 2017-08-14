package com.msk.pl.bean;

import com.msk.core.bean.BaseParam;

import java.util.Date;

/**
 * Created by xuhongyang on 2017/2/9
 *
 * 进货单产品查询接口入参
 */
public class IPL20170210Param extends BaseParam {

    private Long plPdId ;//进货单产品ID

    /**
     * Getter method for property <tt>plPdId</tt>.
     *
     * @return property value of plPdId
     */
    public Long getPlPdId() {
        return plPdId;
    }

    /**
     * Setter method for property <tt>plPdId</tt>.
     *
     * @param plPdId value to be assigned to property plPdId
     */
    public void setPlPdId(Long plPdId) {
        this.plPdId = plPdId;
    }
}
