package com.msk.so.bean.order;

import com.msk.core.bean.BaseBean;

import java.util.List;

/**
 * *ViewOrderSearchResult
 * *@author jiang_nan
 * *@version 1.0
 **/
public class ViewOrderSearchResult extends BaseBean{
    private List<BaseOrderSearchResult> orders;

    public List<BaseOrderSearchResult> getOrders() {
        return orders;
    }

    public void setOrders(List<BaseOrderSearchResult> orders) {
        this.orders = orders;
    }
}
