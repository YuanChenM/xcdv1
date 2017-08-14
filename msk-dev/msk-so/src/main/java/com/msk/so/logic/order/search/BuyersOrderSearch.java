package com.msk.so.logic.order.search;

import com.msk.core.exception.BusinessException;
import com.msk.core.exception.ValidatorException;
import com.msk.core.utils.StringUtil;
import com.msk.core.utils.ValidatorUtils;
import com.msk.so.bean.order.BaseOrderSearchParam;
import com.msk.so.bean.order.OrderDetailSearchParam;
import com.msk.so.bean.order.OrderListSearchParam;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 买家订单查询
 * @author jiang_nan
 * @version 1.0
 **/
public class BuyersOrderSearch extends BaseSearchOrder{
    @Override
    public void validateDetail(BaseOrderSearchParam param) {
        String buyersId = param.getBuyersId();
        String buyersCode = param.getBuyersCode();
        if(StringUtil.isEmpty(buyersId)||StringUtil.isEmpty(buyersCode)){
            throw new BusinessException("获得买家订单明细时候,没有买家Code或者买家Id无法获得数据");
        }
        List<OrderDetailSearchParam> orders= param.getOrders();
        if(CollectionUtils.isEmpty(orders)){
            throw new BusinessException("没有传入订单ID或者Code");
        }
    }

    @Override
    public void validateList(OrderListSearchParam searchParam) {
        String buyersId = searchParam.getBuyersId();
        String buyersCode = searchParam.getBuyersCode();
        if(StringUtil.isEmpty(buyersId)||StringUtil.isEmpty(buyersCode)){
            throw new BusinessException("获得买家订单明细时候,没有买家Code或者买家Id无法获得数据");
        }
    }
}

