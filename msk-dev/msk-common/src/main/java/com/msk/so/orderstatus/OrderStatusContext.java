package com.msk.so.orderstatus;

import com.msk.common.consts.StatusConst;
import com.msk.so.logic.OrderLogic;
import com.msk.so.bean.OrderStatusParam;
import com.msk.so.logic.OrderDetailAvailabilityLogic;
import com.msk.so.logic.OrderDetailStatusLogic;
import com.msk.so.logic.OrderStatusAllReceiptLogic;
import com.msk.so.logic.OrderStatusLogic;
import com.msk.core.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.msk.so.logic.StockLogic;
/**
 * OrderStatusContext
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Component
public class OrderStatusContext {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderStatusContext.class);
    @Autowired
    private OrderStatusLogic orderStatusLogic;
    @Autowired
    private OrderDetailStatusLogic orderDetailStatusLogic;
    @Autowired
    private OrderDetailAvailabilityLogic orderDetailAvailabilityLogic;
    @Autowired
    private OrderStatusAllReceiptLogic orderStatusAllReceiptLogic;
    private BaseOrderStatus orderStatus;
    @Autowired
    private StockLogic stockLogic;
    @Autowired
    private OrderLogic orderLogic;
    /**
     *
     * @param orderStatusParam orderStatusParam
     *
     * @author jiang_nan
     */
    public void handle(OrderStatusParam orderStatusParam) {
        logger.debug("订单状态迁移操作");
        int status = orderStatusParam.getNewStatus();
        if(StatusConst.OrderStatusDef.NEW == status){//新建订单状态
            this.orderStatus = new OrderStatusNew(orderStatusParam);
        }else if(StatusConst.OrderStatusDef.OBLIGATION == status){//待付款订单状态
            this.orderStatus = new OrderStatusObligation(orderStatusParam);
        }else if(StatusConst.OrderStatusDef.PAYMENT == status){//已付款订单状态
            this.orderStatus = new OrderStatusPayment(orderStatusParam);
        }else if(StatusConst.OrderStatusDef.CONFIRM == status){//已确认订单状态
            this.orderStatus = new OrderStatusConfirm(orderStatusParam);
            ((OrderStatusConfirm)this.orderStatus).setOrderDetailStatusLogic(orderDetailStatusLogic);
        }else if(StatusConst.OrderStatusDef.WAIT_SEND == status){//待发货订单状态
            this.orderStatus = new OrderStatusWaitSend(orderStatusParam);
            ((OrderStatusWaitSend)this.orderStatus).setOrderDetailStatusLogic(orderDetailStatusLogic);
            ((OrderStatusWaitSend)this.orderStatus).setOrderDetailAvailabilityLogic(orderDetailAvailabilityLogic);
        }else if(StatusConst.OrderStatusDef.PARTIAL_SHIPMENT == status){//部分发货订单状态
            this.orderStatus = new OrderStatusPartialShipment(orderStatusParam);
        }else if(StatusConst.OrderStatusDef.PARTIAL_RECEIPT == status){//部分收货订单状态
            this.orderStatus = new OrderStatusPartialReceipt(orderStatusParam);
        }else if(StatusConst.OrderStatusDef.ALL_SHIPMENT == status){//全部发货订单状态
            this.orderStatus = new OrderStatusAllShipment(orderStatusParam);
        }else if(StatusConst.OrderStatusDef.ALL_RECEIPT == status){//全部收货订单状态
            this.orderStatus = new OrderStatusAllReceipt(orderStatusParam);
            ((OrderStatusAllReceipt)this.orderStatus).setOrderDetailStatusLogic(orderDetailStatusLogic);
            ((OrderStatusAllReceipt)this.orderStatus).setOrderDetailAvailabilityLogic(orderDetailAvailabilityLogic);
            ((OrderStatusAllReceipt)this.orderStatus).setOrderStatusAllReceiptLogic(orderStatusAllReceiptLogic);
        }else if(StatusConst.OrderStatusDef.CANCEL == status){//订单取消订单状态
            this.orderStatus = new OrderStatusCancel(orderStatusParam);
            ((OrderStatusCancel)this.orderStatus).setOrderDetailStatusLogic(orderDetailStatusLogic);
            ((OrderStatusCancel)this.orderStatus).setOrderDetailAvailabilityLogic(orderDetailAvailabilityLogic);
            ((OrderStatusCancel)this.orderStatus).setStockLogic(stockLogic);
        }else if(StatusConst.OrderStatusDef.WAIT_DISTRIBUTION == status){//待分销
            this.orderStatus = new OrderStatusWaitDistribution(orderStatusParam);
            ((OrderStatusWaitDistribution)this.orderStatus).setOrderDetailStatusLogic(orderDetailStatusLogic);
        }

        else{
            throw new BusinessException("没有找到定义的订单状态");
        }
        orderStatus.setOrderLogic(this.orderLogic);
        orderStatus.setOrderStatusLogic(orderStatusLogic);
        orderStatus.handle();
    }


}
