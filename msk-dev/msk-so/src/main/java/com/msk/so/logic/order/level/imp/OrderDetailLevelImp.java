package com.msk.so.logic.order.level.imp;

import com.msk.core.entity.SoOrderDetail;
import com.msk.so.logic.order.level.IOrderDetailLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单等级业务实现
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderDetailLevelImp implements IOrderDetailLevel {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderDetailLevelImp.class);

    /**
     * 根据订单数量获得订单等级
     *
     * @param orderDetailList 订单明细数量
     * @return 订单等级
     */
    @Override
    public int orderDetailLevel(SoOrderDetail orderDetailList) {
        return 0;
    }
}
