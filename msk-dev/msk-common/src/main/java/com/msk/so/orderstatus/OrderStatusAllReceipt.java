package com.msk.so.orderstatus;

import java.util.List;

import com.msk.common.consts.StatusConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.so.bean.OrderStatusParam;
import com.msk.so.logic.OrderDetailAvailabilityLogic;
import com.msk.so.logic.OrderDetailStatusLogic;
import com.msk.so.logic.OrderStatusAllReceiptLogic;

/**
 * OrderStatusAllReceipt
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderStatusAllReceipt extends BaseOrderStatus{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderStatusAllReceipt.class);
    //订单明细表状态变更logic
    private OrderDetailStatusLogic orderDetailStatusLogic;
    //订单明细供货表状态变更logic
    private OrderDetailAvailabilityLogic orderDetailAvailabilityLogic;
    //更新订单配送要求表,订单明细表,订单明细供货表的收货时间和收货数量logic
    private OrderStatusAllReceiptLogic orderStatusAllReceiptLogic;
    
    public OrderStatusAllReceipt(OrderStatusParam orderStatusParam) {
        super(orderStatusParam);
    }

    @Override
    public void handle() {
        logger.debug("订单全部收货操作");
        //更新订单主表和订单状态表
        super.saveStatus();
        //更新订单详细表和订单详细状态表
        OrderStatusParam param = this.getOrderStatusParam();
        Long orderId = param.getOrderId();
        this.orderDetailStatusLogic.modifyStatus(orderId,
                StatusConst.OrderDetailStatusDef.ALL_SHIPMENT,
                StatusConst.OrderDetailStatusDef.ALL_RECEIPT,
                param.getUpdId(),
                param.getUpdTime()
        );
        //更新订单明细供货表
        BaseParam availabilitieParam = new BaseParam();
        availabilitieParam.setFilter("orderId",String.valueOf(param.getOrderId()));
        List<SoOrderDetailAvailability> availabilitieList = this.orderDetailAvailabilityLogic.getOrderDetailAvailabilityList(availabilitieParam);
        if(!CollectionUtils.isEmpty(availabilitieList)){
            for (SoOrderDetailAvailability entity:availabilitieList) {
                this.orderDetailAvailabilityLogic.modifyOrderDetailAvailabilityStatus(entity.getOrderDetailAvailabilityId(), StatusConst.OrderDetailAvailabilityStatusDef.ALL_RECEIPT,param.getUpdId(),param.getUpdTime());
            } 
        }
        //更新订单配送要求表,订单明细表,订单明细供货表的收货时间和收货数量
        this.orderStatusAllReceiptLogic.modifyReceiveTimeQty(param);
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

    /**
     * Get the orderStatusAllReceiptLogic.
     *
     * @return orderStatusAllReceiptLogic
     *
     */
    public OrderStatusAllReceiptLogic getOrderStatusAllReceiptLogic() {
        return this.orderStatusAllReceiptLogic;
    }

    /**
     * Set the orderStatusAllReceiptLogic.
     *
     * @param orderStatusAllReceiptLogic orderStatusAllReceiptLogic
     *
     */
    public void setOrderStatusAllReceiptLogic(OrderStatusAllReceiptLogic orderStatusAllReceiptLogic) {
        this.orderStatusAllReceiptLogic = orderStatusAllReceiptLogic;
    }
}
