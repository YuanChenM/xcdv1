package com.msk.so.bean;

import java.util.Date;

/**
 * ISO2514011ReResult.
 * 修改标准分销退货单状态
 * @author pxg
 */
public class ISO251407RsResult {
    /** 订单ID*/
    private Long orderId;
    /** 订单编码*/
    private String orderCode;
    /** 订单状态*/
    private Integer orderStatus;
    /** 更新时间*/
    private Date updTime;
    /** 版本号*/
    private Integer ver;

    /**
     * 获得orderId
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获得orderCode
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 设置orderCode
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * 获得orderStatus
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置orderStatus
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获得updTime
     */
    public Date getUpdTime() {
        return updTime;
    }

    /**
     * 设置updTime
     */
    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    /**
     * 获得ver
     */
    public Integer getVer() {
        return ver;
    }

    /**
     * 设置ver
     */
    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
