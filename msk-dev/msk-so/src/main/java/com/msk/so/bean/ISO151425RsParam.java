package com.msk.so.bean;

import com.msk.core.bean.RsPageParam;


/**
 * Created by sun_jiaju on 2016/10/11.
 */
public class ISO151425RsParam extends RsPageParam {
    // 订单ID
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
