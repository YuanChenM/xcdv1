package com.msk.batch.so.bean;

import com.msk.core.bean.BaseParam;

import java.util.Date;

/**
 * BSO152403Param
 * @author xu_wei
 */
public class BSO152403Param extends BaseParam {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 订单ID */
    private long orderId;
    /** ORDER_CODE */
    private String orderCode;
    /** 订单状态 */
    private int orderStatus;

    /** 订单类型 */
    private int orderType1;

    /** 订单类型 */
    private int orderType2;

    /** RELATION_FLAG */
    private long relationFlag;

    /** 配送单编码*/
    private String deliveryCode;

    /** 系统时间*/
    private Date nowDate;

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public int getOrderType2() {
        return orderType2;
    }

    public void setOrderType2(int orderType2) {
        this.orderType2 = orderType2;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderType1() {
        return orderType1;
    }

    public void setOrderType1(int orderType1) {
        this.orderType1 = orderType1;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public long getRelationFlag() {
        return relationFlag;
    }

    public void setRelationFlag(long relationFlag) {
        this.relationFlag = relationFlag;
    }

    public Date getNowDate() {
        return nowDate;
    }

    public void setNowDate(Date nowDate) {
        this.nowDate = nowDate;
    }
}
