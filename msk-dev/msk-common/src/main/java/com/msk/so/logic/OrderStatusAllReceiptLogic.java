package com.msk.so.logic;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.OrderStatusParam;

/**
 * OrderStatusAllReceipt
 *
 * @author zhou_yajun
 * @version 1.0
 **/
public class OrderStatusAllReceiptLogic extends BaseLogic {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(OrderStatusAllReceiptLogic.class);
    
    /**
     * 
     * 更新订单配送要求表,订单明细表,订单明细供货表的收货时间和收货数量
     *
     * @param orderStatusParam orderStatusParam
     *
     */
    @Transactional
    public void modifyReceiveTimeQty(OrderStatusParam orderStatusParam){
        logger.info("更新订单配送要求表,订单明细表,订单明细供货表的收货时间和收货数量");
        Map<String, Object> filterMap = orderStatusParam.getFilterMap();
        Date customerDate = DateTimeUtil.getCustomerDate();
        filterMap.put("updId", orderStatusParam.getUpdId());
        filterMap.put("updTime", customerDate);
        filterMap.put("orderId", orderStatusParam.getOrderId());
        filterMap.put("orderCode", orderStatusParam.getOrderCode());
        super.modify(orderStatusParam);
        //TODO 更新订单配送要求表的库存数量
    }
    
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
