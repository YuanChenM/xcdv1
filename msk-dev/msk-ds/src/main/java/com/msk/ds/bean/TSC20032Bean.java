package com.msk.ds.bean;

import com.msk.core.entity.BaseEntity;

/**
 * Created by Administrator on 2016/6/12.
 */
public class TSC20032Bean extends BaseEntity {

    /** 订单编号*/
    private String orderNumber;
    /** 订单日期*/
    private String orderDate;
    /** 生产商*/
    private String production;
    /** 仓库地址*/
    private String address;

    /**
     * Getter method for property <tt>orderNumber</tt>.
     *
     * @return property value of orderNumber
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * Setter method for property <tt>orderNumber</tt>.
     *
     * @param orderNumber value to be assigned to property orderNumber
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Getter method for property <tt>orderDate</tt>.
     *
     * @return property value of orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * Setter method for property <tt>orderDate</tt>.
     *
     * @param orderDate value to be assigned to property orderDate
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Getter method for property <tt>production</tt>.
     *
     * @return property value of production
     */
    public String getProduction() {
        return production;
    }

    /**
     * Setter method for property <tt>production</tt>.
     *
     * @param production value to be assigned to property production
     */
    public void setProduction(String production) {
        this.production = production;
    }

    /**
     * Getter method for property <tt>address</tt>.
     *
     * @return property value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for property <tt>address</tt>.
     *
     * @param address value to be assigned to property address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
