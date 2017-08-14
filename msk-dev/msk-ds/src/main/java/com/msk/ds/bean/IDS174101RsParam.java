package com.msk.ds.bean;

import com.msk.core.bean.RsPageParam;

import java.util.Date;

/**
 * IDS174101RsParam.
 * 查询批次产品信息
 *
 * @author yuan_chen
 */
public class IDS174101RsParam extends RsPageParam {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 生效日期，没有的话，查询全部产品，有的话，查询该日期以后有更新新增的产品信息 */
    private Date actTime;

    /**
     * Getter method for property <tt>actTime</tt>.
     *
     * @return property value of actTime
     */
    public Date getActTime() {
        return actTime;
    }

    /**
     * Setter method for property <tt>actTime</tt>.
     *
     * @param actTime value to be assigned to property actTime
     */
    public void setActTime(Date actTime) {
        this.actTime = actTime;
    }
}
