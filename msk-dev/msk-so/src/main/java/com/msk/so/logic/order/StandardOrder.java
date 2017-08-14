package com.msk.so.logic.order;

import com.msk.so.bean.order.BaseOrderParam;
import com.msk.so.bean.order.BaseOrderResult;
import com.msk.so.logic.order.BaseOrder;
import com.msk.so.logic.order.buyer.StandardBuyerOrder;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 *分销订单
 *@author jiang_nan
 *@version 1.0
 **/
public class StandardOrder extends BaseOrder<BaseOrderParam> {
    private StandardBuyerOrder standardBuyerOrder;
    @Override
    @Transactional
    public BaseOrderResult doOperate(BaseOrderParam entity) {
        String buyersId = entity.getBuyersId();
        if(this.standardBuyerOrder.haveBuyer(buyersId)){
            Map<String,BaseOrderParam> orderListMap= this.standardBuyerOrder.createOrder(entity);
            if(!CollectionUtils.isEmpty(orderListMap)){
                return this.saveBuyersSaleOrder(entity,orderListMap);
            }
        }
        return super.doOperate(entity);
    }

    public void setStandardBuyerOrder(StandardBuyerOrder standardBuyerOrder) {
        this.standardBuyerOrder = standardBuyerOrder;
    }
}
