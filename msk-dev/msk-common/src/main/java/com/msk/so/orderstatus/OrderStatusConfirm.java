package com.msk.so.orderstatus;

import com.msk.common.consts.StatusConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msk.so.bean.OrderStatusParam;
import com.msk.so.logic.OrderDetailStatusLogic;

/**
 * OrderStatusConfirm
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderStatusConfirm extends BaseOrderStatus{
    
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderStatusConfirm.class);
    
    private OrderDetailStatusLogic orderDetailStatusLogic;

    /**
     * 
     * The Constructors Method.
     *
     * @param orderStatusParam orderStatusParam
     *
     * @author zhou_ling
     */
    public OrderStatusConfirm(OrderStatusParam orderStatusParam) {
        super(orderStatusParam);
    }

    @Override
    public void handle() {
        
        logger.debug("订单已确认！");
        //更新订单主表和订单状态表
        super.saveStatus();
        OrderStatusParam orderStatusParam = this.getOrderStatusParam();
        Long orderId = orderStatusParam.getOrderId();
        this.orderDetailStatusLogic.modifyStatus(orderId,
                StatusConst.OrderDetailStatusDef.WAIT_DISTRIBUTION,
                StatusConst.OrderDetailStatusDef.CONFIRM,
                orderStatusParam.getUpdId(),
                orderStatusParam.getUpdTime()
        );
    }

    /**
     * Get the orderDetailStatusLogic.
     *
     * @return orderDetailStatusLogic
     *
     * @author zhou_ling
     */
    public OrderDetailStatusLogic getOrderDetailStatusLogic() {
        return this.orderDetailStatusLogic;
    }

    /**
     * Set the orderDetailStatusLogic.
     *
     * @param orderDetailStatusLogic orderDetailStatusLogic
     *
     * @author zhou_ling
     */
    public void setOrderDetailStatusLogic(OrderDetailStatusLogic orderDetailStatusLogic) {
        this.orderDetailStatusLogic = orderDetailStatusLogic;
    }
    
}

