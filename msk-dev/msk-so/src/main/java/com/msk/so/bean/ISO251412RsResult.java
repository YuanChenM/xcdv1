package com.msk.so.bean;

import java.util.Date;

/**
 * 
 * ISO2514012ReResult.
 *
 * @author pxg
 */
public class ISO251412RsResult {
    /** 订单ID*/
    private Long orderId;
    /** 需求订单编码*/
    private String requireOrderCode;
    /** 订单状态*/
    private Integer orderStatus;
    /** 更新时间*/
    private Date updTime;
    /** 版本号*/
    private Integer ver;
    /**
     * Get the requireOrderCode.
     *
     * @return requireOrderCode
     *
     * @author Administrator
     */
    public String getRequireOrderCode() {
        return this.requireOrderCode;
    }
    /**
     * Set the requireOrderCode.
     *
     * @param requireOrderCode requireOrderCode
     *
     * @author Administrator
     */
    public void setRequireOrderCode(String requireOrderCode) {
        this.requireOrderCode = requireOrderCode;
    }
    /**
     * Get the orderStatus.
     *
     * @return orderStatus
     *
     * @author Administrator
     */
    public Integer getOrderStatus() {
        return this.orderStatus;
    }
    /**
     * Set the orderStatus.
     *
     * @param orderStatus orderStatus
     *
     * @author Administrator
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
    /**
     * Get the updTime.
     *
     * @return updTime
     *
     * @author Administrator
     */
    public Date getUpdTime() {
        return this.updTime;
    }
    /**
     * Set the updTime.
     *
     * @param updTime updTime
     *
     * @author Administrator
     */
    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }
    /**
     * Get the ver.
     *
     * @return ver
     *
     * @author Administrator
     */
    public Integer getVer() {
        return this.ver;
    }
    /**
     * Set the ver.
     *
     * @param ver ver
     *
     * @author Administrator
     */
    public void setVer(Integer ver) {
        this.ver = ver;
    }
    /**
     * Get the orderId.
     *
     * @return orderId
     *
     * @author Administrator
     */
    public Long getOrderId() {
        return this.orderId;
    }
    /**
     * Set the orderId.
     *
     * @param orderId orderId
     *
     * @author Administrator
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
