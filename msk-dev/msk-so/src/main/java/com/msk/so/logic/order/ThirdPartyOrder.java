package com.msk.so.logic.order;


import com.msk.common.logic.CommonLogic;
import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.so.bean.order.BaseOrderDetailParam;
import com.msk.so.bean.order.BaseOrderParam;
import com.msk.so.bean.order.BaseOrderResult;
import com.msk.so.logic.order.buyer.StandardBuyerOrder;
import com.msk.so.logic.order.buyer.ThirdPartyBuyersOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 第三方订单
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class ThirdPartyOrder extends BaseOrder<BaseOrderParam>{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ThirdPartyOrder.class);
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private ThirdPartyBuyersOrder thirdPartyBuyersOrder;
    @Override
    @Transactional
    public BaseOrderResult doOperate(BaseOrderParam entity) {
        String buyersId = entity.getBuyersId();
        if(this.thirdPartyBuyersOrder.haveBuyer(buyersId)){
            Map<String,BaseOrderParam> orderListMap= this.thirdPartyBuyersOrder.createOrder(entity);
            if(!CollectionUtils.isEmpty(orderListMap)){
                return this.saveBuyersSaleOrder(entity,orderListMap);
            }
        }
        return super.doOperate(entity);
    }

    /**
     *t创建订单明细供货信息表
     * @pist 订单信息
     * @return 订单明细供货信息表
     */
    public List<SoOrderDetailAvailability> createOrderDetailAvailability(List<BaseOrderDetailParam> orderDetailParamList){
        ThirdPartyCommon thirdPartyCommon = new ThirdPartyCommon(commonLogic);
        List<SoOrderDetailAvailability> orderDetailAvailabilityList = thirdPartyCommon.createOrderDetailAvailability(orderDetailParamList);
        return orderDetailAvailabilityList;
    }

}
