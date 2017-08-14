package com.msk.so.orderstatus;

import com.msk.so.logic.OrderLogic;
import com.msk.so.bean.OrderStatusParam;
import com.msk.so.logic.OrderStatusLogic;

/**
 * Created by jiangnan on 16/1/11.
 */
public abstract class BaseOrderStatus {
    private OrderStatusParam orderStatusParam;
    private OrderStatusLogic orderStatusLogic;
    private OrderLogic orderLogic;
    /**
     * 构造函数
     * @param orderStatusParam 订单状态参数
     */
    public BaseOrderStatus(OrderStatusParam orderStatusParam) {
        this.orderStatusParam = orderStatusParam;
    }

    /**
     * 默认构造函数
     */
    public BaseOrderStatus() {
    }

    /**
     *
     */
    public abstract void handle();

    /**
     * 更新订单状态.<br/>
     * 1:订单主表订单状态<br/>
     * 2:更新订单状态表<br/>
     * 3:新增一条订单状态表数据
     */
    public void saveStatus(){
        this.orderLogic.modifyOrderStatus(this.orderStatusParam.getOrderId(),this.orderStatusParam.getNewStatus(),this.orderStatusParam.getUpdId(),this.orderStatusParam.getUpdTime());
        this.orderStatusLogic.modifyOrderStatus(this.orderStatusParam);
    }

    /**
     * Getter method for property <tt>orderStatusLogic</tt>.
     *
     * @return property value of orderStatusLogic
     */
    public OrderStatusLogic getOrderStatusLogic() {
        return orderStatusLogic;
    }

    /**
     * Setter method for property <tt>orderStatusLogic</tt>.
     *
     * @param orderStatusLogic value to be assigned to property orderStatusLogic
     */
    public void setOrderStatusLogic(OrderStatusLogic orderStatusLogic) {
        this.orderStatusLogic = orderStatusLogic;
    }

    /**
     * Getter method for property <tt>orderStatusParam</tt>.
     *
     * @return property value of orderStatusParam
     */
    public OrderStatusParam getOrderStatusParam() {
        return orderStatusParam;
    }

    /**
     * Setter method for property <tt>orderStatusParam</tt>.
     *
     * @param orderStatusParam value to be assigned to property orderStatusParam
     */
    public void setOrderStatusParam(OrderStatusParam orderStatusParam) {
        this.orderStatusParam = orderStatusParam;
    }

    /**
     * Getter method for property <tt>orderLogic</tt>.
     *
     * @return property value of orderLogic
     */
    public OrderLogic getOrderLogic() {
        return orderLogic;
    }

    /**
     * Setter method for property <tt>orderLogic</tt>.
     *
     * @param orderLogic value to be assigned to property orderLogic
     */
    public void setOrderLogic(OrderLogic orderLogic) {
        this.orderLogic = orderLogic;
    }
}
