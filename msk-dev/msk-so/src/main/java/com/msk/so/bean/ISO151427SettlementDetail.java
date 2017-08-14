package com.msk.so.bean;

import com.msk.core.bean.BaseBean;

import java.util.List;

/**
 * Created by wang_shuai on 2016/6/22.
 */
public class ISO151427SettlementDetail extends BaseBean {
    //订单id
    private String orderId;
    //订单编码
    private String orderCode;
    //商品信息list
    private List<ISO151427SoProduct> pdList;
    //订单状态
    private int settlementStatus;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public List<ISO151427SoProduct> getPdList() {
        return pdList;
    }

    public void setPdList(List<ISO151427SoProduct> pdList) {
        this.pdList = pdList;
    }

    public int getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(int settlementStatus) {
        this.settlementStatus = settlementStatus;
    }
}
