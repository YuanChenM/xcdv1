package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * Created by liutao on 2016/10/18.
 */
public class ISO151805RsResult extends BaseEntity {
    private List<ISO151805RsOrderListResult> orderList;

    public List<ISO151805RsOrderListResult> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<ISO151805RsOrderListResult> orderList) {
        this.orderList = orderList;
    }
}
