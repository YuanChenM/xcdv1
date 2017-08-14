package com.msk.batch.so.bean;

import com.msk.core.bean.BaseParam;

/**
 * BSO152402Param
 * @author yuan_chen
 */
public class BSO152402Param extends BaseParam {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 订单ID */
    private long orderId;

    /** 订单状态 */
    private int orderStatus;
    private String paymentType;

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * Getter method for property <tt>orderId</tt>.
     *
     * @return property value of orderId
     */
    public long getOrderId() {
        return orderId;
    }

    /**
     * Setter method for property <tt>orderId</tt>.
     *
     * @param orderId value to be assigned to property orderId
     */
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    /**
     * Getter method for property <tt>orderStatus</tt>.
     *
     * @return property value of orderStatus
     */
    public int getOrderStatus() {
        return orderStatus;
    }

    /**
     * Setter method for property <tt>orderStatus</tt>.
     *
     * @param orderStatus value to be assigned to property orderStatus
     */
    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
}
