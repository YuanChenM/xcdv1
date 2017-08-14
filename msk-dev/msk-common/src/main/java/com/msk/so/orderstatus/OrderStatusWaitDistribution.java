package com.msk.so.orderstatus;

import com.msk.common.consts.StatusConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msk.so.bean.OrderStatusParam;
import com.msk.so.logic.OrderDetailStatusLogic;

/**
 * 订单待分销状态操作
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderStatusWaitDistribution extends BaseOrderStatus{
    
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderStatusWaitDistribution.class);
    
    private OrderDetailStatusLogic orderDetailStatusLogic;

    /**
     * 
     * The Constructors Method.
     *
     * @param orderStatusParam orderStatusParam
     *
     * @author zhou_ling
     */
    public OrderStatusWaitDistribution(OrderStatusParam orderStatusParam) {
        super(orderStatusParam);
    }

    @Override
    public void handle() {
        
        logger.debug("订单待分销状态操作");
        
        //TODO (batch中有相似代码，讨论是否要抽出共通)1：锁库存（占用数据），卖家产品库存
        // 设置共通传入参数
       /* StockParam stockParam = new StockParam();
        //物流区编号(char(2))
        stockParam.setLgcsCode(distributionInfo.getLgcsCode());
        //产品编码
        stockParam.setPdCode(distributionInfo.getPdCode());
        //卖家编码
        stockParam.setSlCode(distributionInfo.getSlCode());
        //需要更新数量(比如:订单数量)
        stockParam.setStockNum(orderDetail.getOrderQty());
        // 调用共通,检查卖家库存是否充足
        boolean isStocked = stockLogic.checkStock(stockParam);
        if (isStocked) {
            // 库存充足,更新库存(冻结库存)
            stockLogic.frozenStock(stockParam);
        } else {
            // 库存不足
        }*/

        //TODO 2：生成应收账单（二期）
        
        // 3：订单明细状态：待分销
        //更新订单主表和订单状态表
        super.saveStatus();
        //更新订单详细表和订单详细状态表
        OrderStatusParam orderStatusParam = this.getOrderStatusParam();
        Long orderId = orderStatusParam.getOrderId();

        this.orderDetailStatusLogic.modifyStatus(orderId,
                                                StatusConst.OrderDetailStatusDef.WAIT_DISTRIBUTION,
                                                StatusConst.OrderDetailStatusDef.WAIT_DISTRIBUTION,
                                                orderStatusParam.getUpdId(),
                                                orderStatusParam.getUpdTime()
                                                );
        //this.orderDetailStatusLogic.modifyStatus(orderStatusParam);
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
