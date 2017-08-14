package com.msk.batch.so.bean;

import com.msk.core.bean.BaseParam;

/**
 * BSO152406Param
 * @author sunjiaju
 */
public class BSO152406Param extends BaseParam {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 订单ID */
    private long shipId;
    /** ORDER_CODE */
    private long orderId;
    /** 订单状态 */
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

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
