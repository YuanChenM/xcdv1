package com.msk.so.bean;

import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SoOrder;
import com.msk.core.entity.SoOrderDetail;
import com.msk.core.entity.SoOrderReceiveDemand;

import java.util.List;

/**
 * SO151408Param
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class SO151408Param extends BaseParam{
    private SoOrder order;
    private List<SO15140801Bean> orderDetailList;
    private SoOrderReceiveDemand orderReceiveDemand;

    /**
     * Getter method for property <tt>order</tt>.
     *
     * @return property value of order
     */
    public SoOrder getOrder() {
        return order;
    }

    /**
     * Setter method for property <tt>order</tt>.
     *
     * @param order value to be assigned to property order
     */
    public void setOrder(SoOrder order) {
        this.order = order;
    }

    /**
     * Getter method for property <tt>orderDetailList</tt>.
     *
     * @return property value of orderDetailList
     */
    public List<SO15140801Bean> getOrderDetailList() {
        return orderDetailList;
    }

    /**
     * Setter method for property <tt>orderDetailList</tt>.
     *
     * @param orderDetailList value to be assigned to property orderDetailList
     */
    public void setOrderDetailList(List<SO15140801Bean> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    /**
     * Getter method for property <tt>orderReceiveDemand</tt>.
     *
     * @return property value of orderReceiveDemand
     */
    public SoOrderReceiveDemand getOrderReceiveDemand() {
        return orderReceiveDemand;
    }

    /**
     * Setter method for property <tt>orderReceiveDemand</tt>.
     *
     * @param orderReceiveDemand value to be assigned to property orderReceiveDemand
     */
    public void setOrderReceiveDemand(SoOrderReceiveDemand orderReceiveDemand) {
        this.orderReceiveDemand = orderReceiveDemand;
    }
}
