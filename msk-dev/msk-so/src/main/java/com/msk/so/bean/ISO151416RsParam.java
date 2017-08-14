package com.msk.so.bean;

import com.msk.core.bean.RsPageParam;

import java.util.Date;
import java.util.List;

/**
 * 
 * ISO151416RsParam接受参数.
 *
 * @author zyj
 */
public class ISO151416RsParam extends RsPageParam {
    /** 卖家编码*/
    private String sellerCode;
    /** 页面输入参数商品名称或订单编码*/
    private String inputParam;
    /** 订单开始时间*/
    private String orderStartTime;
    /** 订单结束时间*/
    private String orderEndTime;
    /** 订单状态*/
    private String orderStatus;

    /**
     * Getter method for property <tt>sellerCode</tt>.
     *
     * @return property value of sellerCode
     */
    public String getSellerCode() {
        return sellerCode;
    }

    /**
     * Setter method for property <tt>sellerCode</tt>.
     *
     * @param sellerCode value to be assigned to property sellerCode
     */
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    /**
     * Getter method for property <tt>inputParam</tt>.
     *
     * @return property value of inputParam
     */
    public String getInputParam() {
        return inputParam;
    }

    /**
     * Setter method for property <tt>inputParam</tt>.
     *
     * @param inputParam value to be assigned to property inputParam
     */
    public void setInputParam(String inputParam) {
        this.inputParam = inputParam;
    }

    /**
     * Getter method for property <tt>orderStartTime</tt>.
     *
     * @return property value of orderStartTime
     */
    public String getOrderStartTime() {
        return orderStartTime;
    }

    /**
     * Setter method for property <tt>orderStartTime</tt>.
     *
     * @param orderStartTime value to be assigned to property orderStartTime
     */
    public void setOrderStartTime(String orderStartTime) {
        this.orderStartTime = orderStartTime;
    }

    /**
     * Getter method for property <tt>orderEndTime</tt>.
     *
     * @return property value of orderEndTime
     */
    public String getOrderEndTime() {
        return orderEndTime;
    }

    /**
     * Setter method for property <tt>orderEndTime</tt>.
     *
     * @param orderEndTime value to be assigned to property orderEndTime
     */
    public void setOrderEndTime(String orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    /**
     * Getter method for property <tt>orderStatus</tt>.
     *
     * @return property value of orderStatus
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * Setter method for property <tt>orderStatus</tt>.
     *
     * @param orderStatus value to be assigned to property orderStatus
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
