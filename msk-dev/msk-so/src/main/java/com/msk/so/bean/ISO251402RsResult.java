package com.msk.so.bean;

import java.util.Date;

/**
 * 
 * ISO251402RsResult.
 *
 * @author pxg
 */
public class ISO251402RsResult {

    /** 订单Id */
    private Long orderId;
    /** 需求订单编码*/
    private String requireOrderCode;
    /** 订单创建时间 */
    private Date orderTime;
    /** 订单状态 */
    private Integer orderStatus;
    /** 数据版本号 */
    private Integer ver;

    /**
     * Getter method for property <tt>orderId</tt>.
     *
     * @return property value of orderId
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * Setter method for property <tt>orderId</tt>.
     *
     * @param orderId value to be assigned to property orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

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
     * Get the orderTime.
     *
     * @return orderTime
     *
     * @author Administrator
     */
    public Date getOrderTime() {
        return this.orderTime;
    }
    /**
     * Set the orderTime.
     *
     * @param orderTime orderTime
     *
     * @author Administrator
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}
