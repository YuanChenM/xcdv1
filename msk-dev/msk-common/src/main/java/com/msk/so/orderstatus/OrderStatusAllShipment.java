package com.msk.so.orderstatus;

import com.msk.so.bean.OrderStatusParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * OrderStatusAllShipment
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderStatusAllShipment extends BaseOrderStatus{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderStatusAllShipment.class);

    public OrderStatusAllShipment(OrderStatusParam orderStatusParam) {
        super(orderStatusParam);
    }

    @Override
    public void handle() {

    }
}
