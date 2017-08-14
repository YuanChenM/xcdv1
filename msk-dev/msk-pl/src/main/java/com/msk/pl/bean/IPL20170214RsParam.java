package com.msk.pl.bean;

import com.msk.core.bean.BaseParam;

/**
 * Created by gyh on 2017/2/6.
 * 进货单填报规则参数
 */
public class IPL20170214RsParam extends BaseParam {
    //合伙人ID
    private Long partnerId;

    /**
     * Getter method for property <tt>partnerId</tt>.
     *
     * @return property value of partnerId
     */
    public Long getPartnerId() {
        return partnerId;
    }

    /**
     * Setter method for property <tt>partnerId</tt>.
     *
     * @param partnerId value to be assigned to property partnerId
     */
    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
}
