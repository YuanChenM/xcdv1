package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

import java.util.List;

/**
 * Created by liu_tao2 on 2016/4/18.
 */
public class ISO151423RsResult extends BaseParam{

    private List<ISO151423OrdersRsResult> orders;

    public List<ISO151423OrdersRsResult> getOrders() {
        return orders;
    }

    public void setOrders(List<ISO151423OrdersRsResult> orders) {
        this.orders = orders;
    }
}
