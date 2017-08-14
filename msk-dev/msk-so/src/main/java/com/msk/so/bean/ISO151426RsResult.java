package com.msk.so.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * Created by liu_tao2 on 2016/4/19.
 */
public class ISO151426RsResult extends RsPageResult {

    private List<ISO151426OrderRsResult> orders;

    public List<ISO151426OrderRsResult> getOrders() {
        return orders;
    }

    public void setOrders(List<ISO151426OrderRsResult> orders) {
        this.orders = orders;
    }
}
