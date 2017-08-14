package com.msk.so.logic.order;

import com.msk.common.logic.CommonLogic;
import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.so.bean.order.BaseOrderDetailParam;
import com.msk.so.bean.order.BaseOrderParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * *ThirdPartyBuyerOrder
 * *@author jiang_nan
 * *@version 1.0
 **/
public class ThirdPartyBuyerOrder extends BaseOrder<BaseOrderParam>{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ThirdPartyOrder.class);
    @Autowired
    private CommonLogic commonLogic;

    /**
     * 第三方买手囤货订单信息表
     * @param orderDetailParamList 订单信息
     * @return 订单明细供货信息表
     */
    public List<SoOrderDetailAvailability> createOrderDetailAvailability(List<BaseOrderDetailParam> orderDetailParamList){
        ThirdPartyCommon thirdPartyCommon = new ThirdPartyCommon(commonLogic);
        List<SoOrderDetailAvailability> orderDetailAvailabilityList = thirdPartyCommon.createOrderDetailAvailability(orderDetailParamList);
        return orderDetailAvailabilityList;
    }
}
