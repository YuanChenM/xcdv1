package com.msk.so.bean.order;

import com.msk.core.bean.BaseBean;

import java.util.Date;

/**
 * BaseOrderResult
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class BaseOrderResult extends BaseBean{
    /**订单ID*/
    private Long orderId;
    /**订单编码*/
    private String orderCode;
    /**订单创建时间*/
    private Date orderTime;
    /**订单状态*/
    private Integer orderStatus;
    /**数据版本号*/
    private Integer ver;

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

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public Integer getVer() {
        return ver;
    }

    @Override
    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
