package com.msk.so.orderstatus;

import com.msk.so.bean.OrderStatusParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * OrderStatusNew
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderStatusNew extends BaseOrderStatus{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderStatusNew.class);

    public OrderStatusNew(OrderStatusParam orderStatusParam) {
        super(orderStatusParam);
    }

    @Override
    public void handle() {

    }
}
