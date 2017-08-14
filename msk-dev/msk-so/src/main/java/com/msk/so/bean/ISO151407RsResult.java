package com.msk.so.bean;


import com.msk.core.bean.BaseBean;

import java.util.List;

/**
 * 
 * ISO151407ReResult.
 *
 * @author sunjiaju
 */
public class ISO151407RsResult extends BaseBean {
    /** 退货单编码 */
    private List<OrderCountBean> orderCountInfoList;


    public List<OrderCountBean> getOrderCountInfoList() {
        return orderCountInfoList;
    }

    public void setOrderCountInfoList(List<OrderCountBean> orderCountInfoList) {
        this.orderCountInfoList = orderCountInfoList;
    }
}
