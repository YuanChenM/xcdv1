package com.msk.so.logic.order.level;

import com.msk.core.entity.SoOrderDetail;

import java.util.List;

/**
 * 订单等级处理接口
 * Created by jiangnan on 16/2/25.
 */
public interface IOrderDetailLevel {
    /**
     * 根据订单数量获得订单等级
     * @param orderDetailList 订单明细数量
     * @return 订单等级
     */
    public int orderDetailLevel(SoOrderDetail orderDetailList);
}
