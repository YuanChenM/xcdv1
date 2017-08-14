package com.msk.so.orderstatus;

import com.msk.so.bean.OrderStatusParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * OrderStatusPayment
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderStatusPayment extends BaseOrderStatus{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderStatusPayment.class);

    public OrderStatusPayment(OrderStatusParam orderStatusParam) {
        super(orderStatusParam);
    }

    @Override
    public void handle() {

    }
}
