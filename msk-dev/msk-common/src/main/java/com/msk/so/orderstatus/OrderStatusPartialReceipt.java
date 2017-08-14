package com.msk.so.orderstatus;

import com.msk.so.bean.OrderStatusParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * OrderStatusPartialReceipt
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderStatusPartialReceipt extends BaseOrderStatus{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderStatusPartialReceipt.class);

    public OrderStatusPartialReceipt(OrderStatusParam orderStatusParam) {
        super(orderStatusParam);
    }

    @Override
    public void handle() {

    }
}
