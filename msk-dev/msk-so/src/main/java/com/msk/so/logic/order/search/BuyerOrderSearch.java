package com.msk.so.logic.order.search;

import com.msk.so.bean.order.BaseOrderSearchParam;
import com.msk.so.bean.order.OrderListSearchParam;

/**
 * 买手订单查询
 * *@author jiang_nan
 * *@version 1.0
 **/
public class BuyerOrderSearch extends BaseSearchOrder{
    @Override
    public void validateDetail(BaseOrderSearchParam param) {
        String searchType = param.getSearchType();
        //买手销售
        if(SearchType.SEARCH_TYPE_BSS.equals(searchType)){

        }else{//买手囤货

        }
    }

    @Override
    public void validateList(OrderListSearchParam searchParam) {
        String searchType = searchParam.getSearchType();
        //买手销售
        if(SearchType.SEARCH_TYPE_BSS.equals(searchType)){

        }else{//买手囤货

        }
    }
}
