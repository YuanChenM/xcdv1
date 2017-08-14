package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;
import com.msk.core.entity.SoOrder;

import javax.swing.text.html.parser.Entity;

/**
 * Created by liu_tao2 on 2016/4/18.
 */
public class ISO151423OrdersRsResult extends BaseEntity{

    private String orderStatus;

    private Integer statusQty;

    private Integer orderStatusNum;

    public Integer getOrderStatusNum() {
        return orderStatusNum;
    }

    public void setOrderStatusNum(Integer orderStatusNum) {
        this.orderStatusNum = orderStatusNum;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getStatusQty() {
        return statusQty;
    }

    public void setStatusQty(Integer statusQty) {
        this.statusQty = statusQty;
    }
}
