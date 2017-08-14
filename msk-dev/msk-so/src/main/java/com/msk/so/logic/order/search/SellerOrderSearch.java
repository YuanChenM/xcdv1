package com.msk.so.logic.order.search;

import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.order.BaseOrderSearchParam;
import com.msk.so.bean.order.OrderDetailSearchParam;
import com.msk.so.bean.order.OrderListSearchParam;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * *SellerOrderSearch
 * *@author jiang_nan
 * *@version 1.0
 **/
public class SellerOrderSearch extends BaseSearchOrder{
    @Override
    public void validateDetail(BaseOrderSearchParam param) {
        String sellerCode = param.getSellerCode();
        if(StringUtil.isEmpty(sellerCode)){
            throw new BusinessException("获得卖家订单明细时候,没有卖家Code无法获得数据");
        }
        List<OrderDetailSearchParam> orders= param.getOrders();
        if(CollectionUtils.isEmpty(orders)){
            throw new BusinessException("没有传入订单ID或者Code");
        }
    }

    @Override
    public void validateList(OrderListSearchParam searchParam) {
        String sellerCode = searchParam.getSellerCode();
        if(StringUtil.isEmpty(sellerCode)){
            throw new BusinessException("获得卖家订单明细时候,没有卖家Code无法获得数据");
        }
    }
}
