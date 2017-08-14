package com.msk.so.orderstatus;

import com.msk.so.bean.OrderStatusParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * OrderStatusPartialShipment
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderStatusPartialShipment extends BaseOrderStatus{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderStatusPartialShipment.class);

    public OrderStatusPartialShipment(OrderStatusParam orderStatusParam) {
        super(orderStatusParam);
    }

    @Override
    public void handle() {

    }
}
