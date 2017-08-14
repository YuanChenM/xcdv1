package com.msk.so.bean;

import com.msk.common.bean.param.BaseParam;

/**
 * Created by liutao on 2016/10/18.
 */
public class ISO151805RsOrderListParam extends BaseParam {
    private Long shipId;

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }
}
