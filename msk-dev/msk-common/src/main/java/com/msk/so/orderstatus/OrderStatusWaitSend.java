package com.msk.so.orderstatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.msk.common.consts.StatusConst;
import com.msk.core.bean.BaseParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.so.bean.OrderStatusParam;
import com.msk.so.logic.OrderDetailAvailabilityLogic;
import com.msk.so.logic.OrderDetailStatusLogic;
import org.springframework.util.CollectionUtils;

/**
 * OrderStatusWaitSend
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderStatusWaitSend extends BaseOrderStatus{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderStatusWaitSend.class);

    //订单明细表状态变更logic
    private OrderDetailStatusLogic orderDetailStatusLogic;
    //订单明细供货表信息取得及状态变更logic
    private OrderDetailAvailabilityLogic orderDetailAvailabilityLogic;
    
    public OrderStatusWaitSend(OrderStatusParam orderStatusParam) {
        super(orderStatusParam);
    }

    @Override
    public void handle() {
        logger.debug("订单待发货操作");
        //更新订单主表和订单状态表
        super.saveStatus();
        OrderStatusParam param = this.getOrderStatusParam();
        //更新订单详细表和订单详细状态表
        Long orderId = param.getOrderId();
        this.orderDetailStatusLogic.modifyStatus(orderId,
                StatusConst.OrderDetailStatusDef.CONFIRM,
                StatusConst.OrderDetailStatusDef.WAIT_SEND,
                param.getUpdId(),
                param.getUpdTime()
        );
        //订单明细供货表信息取得
        BaseParam availabilityParam = new BaseParam();
        availabilityParam.setFilter("orderId",String.valueOf(param.getOrderId()));
        List<SoOrderDetailAvailability> orderDetailAvailabilityList = this.orderDetailAvailabilityLogic.getOrderDetailAvailabilityList(availabilityParam);
        if(!CollectionUtils.isEmpty(orderDetailAvailabilityList)){
            for (SoOrderDetailAvailability entity:orderDetailAvailabilityList) {
                //更新订单明细供货表
                this.orderDetailAvailabilityLogic.modifyOrderDetailAvailabilityStatus(entity.getOrderDetailAvailabilityId(), StatusConst.OrderDetailAvailabilityStatusDef.WAIT_SEND,param.getUpdId(),param.getUpdTime());
            }
        }
        //TODO 将取得信息发送给仓库
    }

    /**
     * Get the orderDetailStatusLogic.
     *
     * @return orderDetailStatusLogic
     *
     */
    public OrderDetailStatusLogic getOrderDetailStatusLogic() {
        return this.orderDetailStatusLogic;
    }

    /**
     * Set the orderDetailStatusLogic.
     *
     * @param orderDetailStatusLogic orderDetailStatusLogic
     *
     */
    public void setOrderDetailStatusLogic(OrderDetailStatusLogic orderDetailStatusLogic) {
        this.orderDetailStatusLogic = orderDetailStatusLogic;
    }

    /**
     * Get the orderDetailAvailabilityLogic.
     *
     * @return orderDetailAvailabilityLogic
     *
     */
    public OrderDetailAvailabilityLogic getOrderDetailAvailabilityLogic() {
        return this.orderDetailAvailabilityLogic;
    }

    /**
     * Set the orderDetailAvailabilityLogic.
     *
     * @param orderDetailAvailabilityLogic orderDetailAvailabilityLogic
     *
     */
    public void setOrderDetailAvailabilityLogic(OrderDetailAvailabilityLogic orderDetailAvailabilityLogic) {
        this.orderDetailAvailabilityLogic = orderDetailAvailabilityLogic;
    }
}
