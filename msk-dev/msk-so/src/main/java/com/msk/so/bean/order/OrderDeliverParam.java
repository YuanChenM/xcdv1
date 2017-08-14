package com.msk.so.bean.order;

import java.util.List;

/**
 * Created by liu_tao2 on 2016/7/12.
 */
public class OrderDeliverParam extends BaseOrderStatusParam {

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 订单编码
     */
    private String orderCode;

    /**
     * 发货单ID
     */
    private Long shipId;

    /**
     * 付款类型
     */
    private Integer paymentType;

    /**
     * 实际发货仓库Code
     */
    private String whCode;

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    /**
     * 实际发货仓库Name
     */
    private String whName;

    /**
     * 多次配送单信息
     */
    private List<OrderShipInfo> shipList;

    /**
     * 明细状态
     */
    private Integer detailStatus;

    /**
     * 主订单状态
     */
    private Integer orderStatus;

    /**
     * 子订单状态
     */
    private Integer orderChildStatus;

    public Integer getOrderChildStatus() {
        return orderChildStatus;
    }

    public void setOrderChildStatus(Integer orderChildStatus) {
        this.orderChildStatus = orderChildStatus;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getDetailStatus() {
        return detailStatus;
    }

    public void setDetailStatus(Integer detailStatus) {
        this.detailStatus = detailStatus;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

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

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public List<OrderShipInfo> getShipList() {
        return shipList;
    }

    public void setShipList(List<OrderShipInfo> shipList) {
        this.shipList = shipList;
    }
}
