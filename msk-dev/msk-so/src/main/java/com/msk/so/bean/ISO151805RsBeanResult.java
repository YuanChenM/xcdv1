package com.msk.so.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wang_jianzhou on 2016/12/6.
 */
public class ISO151805RsBeanResult implements Serializable {

    private List<ISO151805RsOrderListBeanResult> orderList;

    public List<ISO151805RsOrderListBeanResult> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<ISO151805RsOrderListBeanResult> orderList) {
        this.orderList = orderList;
    }
}
