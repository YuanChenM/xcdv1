package com.msk.so.logic.order;

import java.util.Map;

/**
 * 订单创建者
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderBuilder {
    /**存储订单类型对应的订单*/
    private Map<Integer,BaseOrder> orderMap;

    /**
     * 构造函数,Spring中设置对应的订单
     * @param orderMap 订单Map
     */
    public OrderBuilder(Map<Integer,BaseOrder> orderMap){
        this.orderMap = orderMap;
    }

    /**
     * 获得订单信息
     * @param orderType 订单类型
     * @return 订单信息
     */
    public BaseOrder getOrder(Integer orderType){
        return this.orderMap.get(orderType);
    }

}
