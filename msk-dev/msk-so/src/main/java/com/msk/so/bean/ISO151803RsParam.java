package com.msk.so.bean;

import com.msk.core.bean.BaseParam;
import com.msk.core.entity.BaseEntity;

/**
 * 可退货数据查询接口，根据订单编号等查询出当前可退货的订单详情信息
 */
public class ISO151803RsParam extends BaseParam{
    private String buyerId;//买家ID
    private String buyerTel;//买家电话
    private Long orderId;//订单Id
    private String orderCode;//订单编码
    private Long shipId;//发货单ID
    private String shipCode;//发货单编号

    private Integer returnDays;// 默认3天

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerTel() {
        return buyerTel;
    }

    public void setBuyerTel(String buyerTel) {
        this.buyerTel = buyerTel;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public String getShipCode() {
        return shipCode;
    }

    public void setShipCode(String shipCode) {
        this.shipCode = shipCode;
    }

    public Integer getReturnDays() {
        return returnDays;
    }

    public void setReturnDays(Integer returnDays) {
        this.returnDays = returnDays;
    }
}
