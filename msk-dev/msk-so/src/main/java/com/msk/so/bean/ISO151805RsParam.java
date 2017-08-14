package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

import java.util.List;

/**
 * Created by liutao on 2016/10/18.
 */
public class ISO151805RsParam extends BaseParam {
    private List<ISO151805RsOrderListParam> orderList;

    public List<ISO151805RsOrderListParam> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<ISO151805RsOrderListParam> orderList) {
        this.orderList = orderList;
    }
}
