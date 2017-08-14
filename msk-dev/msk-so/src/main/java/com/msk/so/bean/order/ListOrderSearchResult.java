package com.msk.so.bean.order;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * *ListOrderSearchResult
 * *@author jiang_nan
 * *@version 1.0
 **/
public class ListOrderSearchResult extends RsPageResult{

    private List<BaseOrderSearchResult> orders;
    public List<BaseOrderSearchResult> getOrders() {
        return orders;
    }
    public void setOrders(List<BaseOrderSearchResult> orders) {
        this.orders = orders;
    }
}
