package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

/**
 * ModifyStatusParam
 *
 * @author sunjiaju
 * @version 1.0
 **/
public class ModifyStatusParam extends BaseParam {
    // 订单ID
    private Long orderId;
    // 发货单ID
    private Long shipId;
    // 子订单ID
    private Long childId;
    // 订单状态
    private Integer orderStatus;
    // 发货单状态
    private Integer shipStatus;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(Integer shipStatus) {
        this.shipStatus = shipStatus;
    }
}
