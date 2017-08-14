package com.msk.so.bean;

import com.msk.core.bean.RsPageParam;

import java.util.List;

/**
 * Created by wang_shuai on 2016/6/22.
 */
public class ISO151427RsParam extends RsPageParam{
    //配送单list
    private List<ISO151427Deliver> deliverList;
    //退货单list
    private List<ISO151427SoReturn> returnList;
    //结算明细订单状态
    private String settlementStatus;
    //卖家id
    private String sellerId;
    //卖家编码
    private String sellerCode;
    //订单id
    private String orderId;
    //订单编码
    private String orderCode;

    public List<ISO151427Deliver> getDeliverList() {
        return deliverList;
    }

    public void setDeliverList(List<ISO151427Deliver> deliverList) {
        this.deliverList = deliverList;
    }

    public List<ISO151427SoReturn> getReturnList() {
        return returnList;
    }

    public void setReturnList(List<ISO151427SoReturn> returnList) {
        this.returnList = returnList;
    }

    public String getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(String settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

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
}
