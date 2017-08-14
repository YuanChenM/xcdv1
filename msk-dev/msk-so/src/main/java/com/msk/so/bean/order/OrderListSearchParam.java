package com.msk.so.bean.order;

import com.msk.core.utils.DateTimeUtil;

import java.math.BigDecimal;
import java.util.Date;

/**
 * *OrderListSearchParam
 * *@author jiang_nan
 * *@version 1.0
 **/
public class OrderListSearchParam extends BaseOrderSearchParam{

    /*订单类型 */
    private String orderType;
    /*买家code */
    private String sellerCode;
    /* 订单状态*/
    private String orderStatus;
    /* 订单开始时间*/
    private java.util.Date orderTimeFrom;
    /* 订单结束时间*/
    private java.util.Date orderTimeTo;
   /* *//* 删除标志*//*
    private Integer delFlg;*/
    /* 订单来源*/
    private String orderSource;
    /* 订单区域*/
    private String districtCode;
    /*付款类型*/
    private Integer paymentType;
    /*订单金额下限*/
    private BigDecimal orderAmountMin;
    /*订单金额上限*/
    private BigDecimal orderAmountMax;
    /*订单等级*/
    private String orderLevel;
    /*是否开票*/
    private Integer needInvoice;
    /*退货标志*/
    private String returnFlg;
    /*是否自配送*/
    private Integer selfDeliveryFlg;
    /*是否分批发货*/
    private Integer splitDeliveryFlg;
    /*直销员*/
    private String sellers;
    /*订单员*/
    private String orderTaker;
    /*收货人电话*/
    private String tel;
    //Modify for bug#1207 at 2016/07/13 by wang_jianzhou Start.
    /**接收分割后的状态数组*/
    private String [] statusArry;

    public String[] getStatusArry() {
        return statusArry;
    }

    public void setStatusArry(String[] statusArry) {
        this.statusArry = statusArry;
    }
    //Modify for bug#1207 at 2016/07/13 by wang_jianzhou end.
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderTimeFrom() { return orderTimeFrom; }

    public void setOrderTimeFrom(Date orderTimeFrom) { this.orderTimeFrom = orderTimeFrom; }

    public Date getOrderTimeTo() { return orderTimeTo; }

    public void setOrderTimeTo(Date orderTimeTo) { this.orderTimeTo = orderTimeTo; }

    /* @Override
    public Integer getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Integer delFlg) {
        this.delFlg = delFlg;
    }*/

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getOrderAmountMin() {
        return orderAmountMin;
    }

    public void setOrderAmountMin(BigDecimal orderAmountMin) {
        this.orderAmountMin = orderAmountMin;
    }

    public BigDecimal getOrderAmountMax() {
        return orderAmountMax;
    }

    public void setOrderAmountMax(BigDecimal orderAmountMax) {
        this.orderAmountMax = orderAmountMax;
    }

    public String getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(String orderLevel) {
        this.orderLevel = orderLevel;
    }

    public Integer getNeedInvoice() {
        return needInvoice;
    }

    public void setNeedInvoice(Integer needInvoice) {
        this.needInvoice = needInvoice;
    }

    public String getReturnFlg() {
        return returnFlg;
    }

    public void setReturnFlg(String returnFlg) {
        this.returnFlg = returnFlg;
    }

    public Integer getSelfDeliveryFlg() {
        return selfDeliveryFlg;
    }

    public void setSelfDeliveryFlg(Integer selfDeliveryFlg) {
        this.selfDeliveryFlg = selfDeliveryFlg;
    }

    public Integer getSplitDeliveryFlg() {
        return splitDeliveryFlg;
    }

    public void setSplitDeliveryFlg(Integer splitDeliveryFlg) {
        this.splitDeliveryFlg = splitDeliveryFlg;
    }

    public String getSellers() {
        return sellers;
    }

    public void setSellers(String sellers) {
        this.sellers = sellers;
    }

    public String getOrderTaker() {
        return orderTaker;
    }

    public void setOrderTaker(String orderTaker) {
        this.orderTaker = orderTaker;
    }
}
