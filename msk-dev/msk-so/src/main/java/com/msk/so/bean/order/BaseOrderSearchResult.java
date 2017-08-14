package com.msk.so.bean.order;

import com.msk.core.entity.SoOrder;
import com.msk.core.entity.SoOrderDetail;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * *BaseOrderSearchResult
 * *@author jiang_nan
 * *@version 1.0
 **/
public class BaseOrderSearchResult extends SoOrder{

    private String invoiceFlg;
    private String paidAmount;
    private String commentTime;
    private String paidTime;
    private java.util.Date OrderTime;
    private BaseReceiverInfo receiveInfo;
    private BaseDeliveryReq deliveryReq;
    private List<SoOrderDetail> orderDetail;
    //完成时间
    private java.util.Date finishTime;
    /**子订单信息*/
    private List<SoOrderDetail> childOrderDetaillist;
    /**版本号*/
    private java.lang.Integer ver;

    private String buyerType;

    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    @Override
    public Integer getVer() {
        return ver;
    }

    @Override
    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public String getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
    }

    public List<SoOrderDetail> getChildOrderDetaillist() {
        return childOrderDetaillist;
    }

    public void setChildOrderDetaillist(List<SoOrderDetail> childOrderDetaillist) {
        this.childOrderDetaillist = childOrderDetaillist;
    }

    public List<SoOrderDetail> getOrderDetail() {

        return orderDetail;
    }



    public void setOrderDetail(List<SoOrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }


    @Override
    public Date getOrderTime() {
        return OrderTime;
    }

    @Override
    public void setOrderTime(Date orderTime) {
        OrderTime = orderTime;
    }

    public String getInvoiceFlg() {
        return invoiceFlg;
    }

    public void setInvoiceFlg(String invoiceFlg) {
        this.invoiceFlg = invoiceFlg;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public BaseReceiverInfo getReceiveInfo() {
        return receiveInfo;
    }

    public void setReceiveInfo(BaseReceiverInfo receiveInfo) {
        this.receiveInfo = receiveInfo;
    }

    public BaseDeliveryReq getDeliveryReq() {
        return deliveryReq;
    }

    public void setDeliveryReq(BaseDeliveryReq deliveryReq) {
        this.deliveryReq = deliveryReq;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
}
