package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * 卖家已卖出商品信息.
 *
 * @author zyj
 */
public class SellerProductListResult extends BaseEntity{
    /** 订单ID*/
    private Integer orderId;
    /** 订单编码*/
    private String orderCode;
    /** 订单创建时间*/
    private String orderTime;
    /** 订单状态*/
    private Integer orderStatus;
    /** 订单状态名称*/
    private String orderStatusName;

    private List<SellerProductResult> productResultList;

    /**
     * Getter method for property <tt>orderId</tt>.
     *
     * @return property value of orderId
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * Setter method for property <tt>orderId</tt>.
     *
     * @param orderId value to be assigned to property orderId
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * Getter method for property <tt>orderCode</tt>.
     *
     * @return property value of orderCode
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * Setter method for property <tt>orderCode</tt>.
     *
     * @param orderCode value to be assigned to property orderCode
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * Getter method for property <tt>orderTime</tt>.
     *
     * @return property value of orderTime
     */
    public String getOrderTime() {
        return orderTime;
    }

    /**
     * Setter method for property <tt>orderTime</tt>.
     *
     * @param orderTime value to be assigned to property orderTime
     */
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * Getter method for property <tt>orderStatus</tt>.
     *
     * @return property value of orderStatus
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * Setter method for property <tt>orderStatus</tt>.
     *
     * @param orderStatus value to be assigned to property orderStatus
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Getter method for property <tt>orderStatusName</tt>.
     *
     * @return property value of orderStatusName
     */
    public String getOrderStatusName() {
        return orderStatusName;
    }

    /**
     * Setter method for property <tt>orderStatusName</tt>.
     *
     * @param orderStatusName value to be assigned to property orderStatusName
     */
    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    /**
     * Getter method for property <tt>productResultList</tt>.
     *
     * @return property value of productResultList
     */
    public List<SellerProductResult> getProductResultList() {
        return productResultList;
    }

    /**
     * Setter method for property <tt>productResultList</tt>.
     *
     * @param productResultList value to be assigned to property productResultList
     */
    public void setProductResultList(List<SellerProductResult> productResultList) {
        this.productResultList = productResultList;
    }
}
