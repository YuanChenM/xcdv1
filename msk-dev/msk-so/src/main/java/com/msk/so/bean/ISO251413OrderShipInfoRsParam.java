package com.msk.so.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 三合一接口  订单收货
 * 配送单信息
 * Created by zhang_qiang1 on 2016/11/7.
 */
public class ISO251413OrderShipInfoRsParam implements Serializable {

    private String deliverCode;//WMS配送单号，按现在的需求一张发货单可能分多车次发货，所以收货时需要提供WMS实际的配送单号，对应发货接口时传输给OMS的配送单号；此单号是发货信息回传给OMS时的单号，收货时，也根据配送单号进行收货。

    private String actualReceiveDate;//实际到货时间，是指物流将货物实际送达的时间，后续需要根据此判定退货是否符合时间要求的


    private Long returnId;// 退货id


    private String returnCode;// 退货编码

    private BigDecimal receiveQty;
    private BigDecimal sendQty;
    private BigDecimal returnQty;
    private BigDecimal rejectionQty;
    private BigDecimal cancelQty;

    private List<ISO251413OrderShipProductRsParam> productList;// 配送明细

    public String getDeliverCode() {
        return deliverCode;
    }

    public void setDeliverCode(String deliverCode) {
        this.deliverCode = deliverCode;
    }

    public String getActualReceiveDate() {
        return actualReceiveDate;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    public void setActualReceiveDate(String actualReceiveDate) {
        this.actualReceiveDate = actualReceiveDate;
    }

    public List<ISO251413OrderShipProductRsParam> getProductList() {
        return productList;
    }

    public BigDecimal getReceiveQty() {
        return receiveQty;
    }

    public void setReceiveQty(BigDecimal receiveQty) {
        this.receiveQty = receiveQty;
    }

    public BigDecimal getSendQty() {
        return sendQty;
    }

    public void setSendQty(BigDecimal sendQty) {
        this.sendQty = sendQty;
    }

    public BigDecimal getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(BigDecimal returnQty) {
        this.returnQty = returnQty;
    }

    public BigDecimal getRejectionQty() {
        return rejectionQty;
    }

    public void setRejectionQty(BigDecimal rejectionQty) {
        this.rejectionQty = rejectionQty;
    }

    public BigDecimal getCancelQty() {
        return cancelQty;
    }

    public void setCancelQty(BigDecimal cancelQty) {
        this.cancelQty = cancelQty;
    }

    public void setProductList(List<ISO251413OrderShipProductRsParam> productList) {
        this.productList = productList;
    }
}
