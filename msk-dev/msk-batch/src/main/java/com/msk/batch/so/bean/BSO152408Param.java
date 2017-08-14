package com.msk.batch.so.bean;

import com.msk.core.bean.BaseParam;

import java.util.Date;

/**
 * BSO152408Param
 * @author xu_wei
 */
public class BSO152408Param extends BaseParam {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private long shipId;

    private int shipStatus;

    public long getShipId() {
        return shipId;
    }

    public void setShipId(long shipId) {
        this.shipId = shipId;
    }

    public int getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(int shipStatus) {
        this.shipStatus = shipStatus;
    }
}
