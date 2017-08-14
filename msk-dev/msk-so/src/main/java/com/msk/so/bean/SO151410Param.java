package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

/**
 * SO151410Param
 *
 * @author sunjiaju
 * @version 1.0
 **/
public class SO151410Param extends BaseParam{
    private Long shipId;
    private Long orderId;

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
