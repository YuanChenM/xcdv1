package com.msk.so.orderstatus;

import com.msk.so.bean.OrderStatusParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderStatusObligation extends BaseOrderStatus{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderStatusObligation.class);

    public OrderStatusObligation(OrderStatusParam orderStatusParam) {
        super(orderStatusParam);
    }

    @Override
    public void handle() {
        OrderStatusParam orderStatusParam = this.getOrderStatusParam();

    }
}
