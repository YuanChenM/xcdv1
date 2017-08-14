package com.msk.so.logic.order;

import com.msk.so.logic.order.BaseOrder;
import com.msk.so.logic.order.OrderBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单工厂,通过订单类型创建不同的订单类型数据
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderFactory {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderFactory.class);
    /**订单生产类*/
    private OrderBuilder orderBuilder;
    /**
     * 根据订单类型获得订单信息
     * @param orderType 订单类型
     * @return 订单信息
     */
    public BaseOrder createOrder(Integer orderType){
        logger.debug("订单类型:"+orderType);
        return this.orderBuilder.getOrder(orderType);
    }

    /**
     * Setter method for property <tt>orderBuilder</tt>.
     *
     * @param orderBuilder value to be assigned to property orderBuilder
     */
    public void setOrderBuilder(OrderBuilder orderBuilder) {
        this.orderBuilder = orderBuilder;
    }
}
