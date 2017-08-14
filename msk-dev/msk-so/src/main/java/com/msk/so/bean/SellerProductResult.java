package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 卖家已卖出商品信息.
 *
 * @author zyj
 */
public class SellerProductResult extends BaseEntity{
    /** 订单ID*/
    private Integer orderId;
    /** 订单创建时间*/
    private String orderTime;
    /** 订单编码*/
    private String orderCode;
    /** 产品CODE*/
    private String pdCode;
    /** 产品名称*/
    private String pdName;
    /** 产品单价*/
    private BigDecimal pdPrice;
    /** 订单数量*/
    private BigDecimal suppQty;
    /** 实付款*/
    private BigDecimal actualPay;
    /** 订单状态*/
    private Integer orderStatus;
    /** 订单状态名称*/
    private String orderStatusName;
    /** 付款方式*/
    private Integer paymentType;

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
     * Getter method for property <tt>pdName</tt>.
     *
     * @return property value of pdName
     */
    public String getPdName() {
        return pdName;
    }

    /**
     * Setter method for property <tt>pdName</tt>.
     *
     * @param pdName value to be assigned to property pdName
     */
    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    /**
     * Getter method for property <tt>pdPrice</tt>.
     *
     * @return property value of pdPrice
     */
    public BigDecimal getPdPrice() {
        return pdPrice;
    }

    /**
     * Setter method for property <tt>pdPrice</tt>.
     *
     * @param pdPrice value to be assigned to property pdPrice
     */
    public void setPdPrice(BigDecimal pdPrice) {
        this.pdPrice = pdPrice;
    }

    /**
     * Getter method for property <tt>suppQty</tt>.
     *
     * @return property value of suppQty
     */
    public BigDecimal getSuppQty() {
        return suppQty;
    }

    /**
     * Setter method for property <tt>suppQty</tt>.
     *
     * @param suppQty value to be assigned to property suppQty
     */
    public void setSuppQty(BigDecimal suppQty) {
        this.suppQty = suppQty;
    }

    /**
     * Getter method for property <tt>actualPay</tt>.
     *
     * @return property value of actualPay
     */
    public BigDecimal getActualPay() {
        return actualPay;
    }

    /**
     * Setter method for property <tt>actualPay</tt>.
     *
     * @param actualPay value to be assigned to property actualPay
     */
    public void setActualPay(BigDecimal actualPay) {
        this.actualPay = actualPay;
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
     * Getter method for property <tt>paymentType</tt>.
     *
     * @return property value of paymentType
     */
    public Integer getPaymentType() {
        return paymentType;
    }

    /**
     * Setter method for property <tt>paymentType</tt>.
     *
     * @param paymentType value to be assigned to property paymentType
     */
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }
}
