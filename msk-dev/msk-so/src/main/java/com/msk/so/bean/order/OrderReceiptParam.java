package com.msk.so.bean.order;

import java.util.List;

/**
 * Created by wang_jianzhou on 2016/7/14.
 */
public class OrderReceiptParam extends BaseOrderStatusParam {

    /** 订单ID */
    private Long orderId;

    /** 发货单ID */
    private Long shipId;

    /** 多次配送单信息 */
    private List<OrderShipInfo> shipList;

    /** 多次配送单信息 */
    private List<PaymentInfo> paymentList;

    /** 明细状态 */
    private Integer detailStatus;

    /** 主订单状态 */
    private Integer orderStatus;

    /** 子订单状态 */
    private Integer orderChildStatus;

    @Override
    public Long getOrderId() {
        return orderId;
    }

    @Override
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public List<OrderShipInfo> getShipList() {
        return shipList;
    }

    public void setShipList(List<OrderShipInfo> shipList) {
        this.shipList = shipList;
    }

    public Integer getDetailStatus() {
        return detailStatus;
    }

    public void setDetailStatus(Integer detailStatus) {
        this.detailStatus = detailStatus;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderChildStatus() {
        return orderChildStatus;
    }

    public void setOrderChildStatus(Integer orderChildStatus) {
        this.orderChildStatus = orderChildStatus;
    }

    public List<PaymentInfo> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<PaymentInfo> paymentList) {
        this.paymentList = paymentList;
    }
}
