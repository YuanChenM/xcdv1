package com.msk.so.orderstatus;

import java.math.BigDecimal;
import java.util.List;

import com.msk.common.consts.StatusConst;

import com.msk.core.entity.SoStockSupp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.msk.common.consts.StatusConst.OrderStatusDef;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.so.bean.OrderStatusParam;
import com.msk.so.bean.StockParam;
import com.msk.so.logic.OrderDetailAvailabilityLogic;
import com.msk.so.logic.OrderDetailStatusLogic;
import com.msk.so.logic.StockLogic;

/**
 * OrderStatusCancel
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderStatusCancel extends BaseOrderStatus{
    
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderStatusCancel.class);
    
    private OrderDetailStatusLogic orderDetailStatusLogic;
    //订单明细供货表状态变更logic
    private OrderDetailAvailabilityLogic orderDetailAvailabilityLogic;
    
    private StockLogic stockLogic;
    
    /**
     * 
     * The Constructors Method.
     *
     * @param orderStatusParam orderStatusParam
     *
     * @author zhou_Ling
     */
    public OrderStatusCancel(OrderStatusParam orderStatusParam) {
        super(orderStatusParam);
    }

    @Override
    public void handle() {
        logger.debug("订单取消操作");
        
        OrderStatusParam orderStatusParam = this.getOrderStatusParam();
        // 获取当前订单状态
        int oderStatus = orderStatusParam.getOldStatus();
        //判断是否待发货之前，可以进行取消
        if(OrderStatusDef.ALL_RECEIPT != oderStatus && OrderStatusDef.ALL_SHIPMENT != oderStatus && OrderStatusDef.PARTIAL_RECEIPT != oderStatus && OrderStatusDef.PARTIAL_SHIPMENT != oderStatus){
            //更新订单主表和订单状态表
            super.saveStatus();
            //更新订单详细表和订单详细状态表
            Long orderId = orderStatusParam.getOrderId();
            this.orderDetailStatusLogic.modifyStatus(orderId,
                    StatusConst.OrderDetailStatusDef.ALL_SHIPMENT,
                    StatusConst.OrderDetailStatusDef.CANCEL,
                    orderStatusParam.getUpdId(),
                    orderStatusParam.getUpdTime()
            );
            
            BaseParam availabilitieParam = new BaseParam();
            availabilitieParam.setFilter("orderId",String.valueOf(orderStatusParam.getOrderId()));
            List<SoOrderDetailAvailability> availabilitieList = this.orderDetailAvailabilityLogic.getOrderDetailAvailabilityList(availabilitieParam);
            if(!CollectionUtils.isEmpty(availabilitieList)){
                //更新订单明细供货表
                for (SoOrderDetailAvailability entity:availabilitieList) {
                    this.orderDetailAvailabilityLogic.modifyOrderDetailAvailabilityStatus(entity.getOrderDetailAvailabilityId(), StatusConst.OrderDetailAvailabilityStatusDef.ALL_RECEIPT,orderStatusParam.getUpdId(),orderStatusParam.getUpdTime());
                }
                // 更新库存数据 取消供货商和卖家库存
                List<SoStockSupp> suppStockListAvailability = this.orderDetailStatusLogic.getCodeAvailabilityCanel(orderStatusParam);
                if(!CollectionUtils.isEmpty(suppStockListAvailability)){
                    BigDecimal sumStockNum = BigDecimal.ZERO;
                    for(SoStockSupp soStockSupp : suppStockListAvailability) {
                        StockParam stockSuppParam = new StockParam();
                        stockSuppParam.setLgcsCode(soStockSupp.getLgcsCode());
                        stockSuppParam.setSlCode(soStockSupp.getSlCode());
                        stockSuppParam.setSupplierCode(soStockSupp.getSupplierCode());
                        stockSuppParam.setPdCode(soStockSupp.getPdCode());
                        stockSuppParam.setStockNum(soStockSupp.getStockQty());
                        sumStockNum.add(soStockSupp.getStockQty());
                        //更新供应商库存数据 
                        stockLogic.cancelFrozenStockSupp(stockSuppParam);
                    }
                    //更新卖家库存数据
                    for(SoStockSupp soStockSupp : suppStockListAvailability) {
                        StockParam stockParam = new StockParam();
                        stockParam.setLgcsCode(soStockSupp.getLgcsCode());
                        stockParam.setSlCode(soStockSupp.getSlCode());
                        stockParam.setPdCode(soStockSupp.getPdCode());
                        stockParam.setStockNum(sumStockNum);
                        stockLogic.cancelFrozenStock(stockParam);
                    }
                }else{
                    // 更新库存数据 取消卖家库存
                    List<SoStockSupp> suppStockListDetail = this.orderDetailStatusLogic.getCodeDetailCanel(orderStatusParam);
                    if(!CollectionUtils.isEmpty(suppStockListDetail)){
                        for(SoStockSupp soStockSupp : suppStockListDetail) {
                            StockParam stockParam = new StockParam();
                            stockParam.setLgcsCode(soStockSupp.getLgcsCode());
                            stockParam.setSlCode(soStockSupp.getSlCode());
                            stockParam.setPdCode(soStockSupp.getPdCode());
                            stockParam.setStockNum(soStockSupp.getStockQty());
                            //更新供应商库存数据 
                            stockLogic.cancelFrozenStock(stockParam);
                        }
                    }
                }
            }
        }
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

    /**
     * Get the stockLogic.
     *
     * @return stockLogic
     *
     * @author zhou_ling
     */
    public StockLogic getStockLogic() {
        return this.stockLogic;
    }

    /**
     * Set the stockLogic.
     *
     * @param stockLogic stockLogic
     *
     * @author zhou_ling
     */
    public void setStockLogic(StockLogic stockLogic) {
        this.stockLogic = stockLogic;
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
