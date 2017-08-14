package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 三合一接口  订单收货
 * 配送单信息中的配送明细信息
 * Created by zhang_qiang1 on 2016/11/7.
 */
public class ISO251413OrderShipProductRsParam extends BaseParam {


    private Long shipDetailId;//发货明细ID，对应发货XML中的ORDERLINE

    private String supplierCode;//供应商编码


    private String skuCode;//SKU编码，原来是pdCode，改为skuCode，便于理解

    private BigDecimal receiveQty;//收货数量，实际的收货数量


    private BigDecimal delayQty;//迟收数量，实际的迟收数量


    private BigDecimal returnQty;//退货数量，实际的退货数量


    private BigDecimal receivePrice;//收货产品对应的单价，WMS中根据实际的收货数量进行计算得出实际采用的价盘通道价格

    private String pdCode;

    private Long shipId;

    private String deliverCode;

    private Long orderId;

    private Date receiptDate;

    private Long orderDetailId;

    private Integer Status;


    public Long getShipDetailId() {
        return shipDetailId;
    }

    public void setShipDetailId(Long shipDetailId) {
        this.shipDetailId = shipDetailId;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public BigDecimal getReceiveQty() {
        return receiveQty;
    }

    public void setReceiveQty(BigDecimal receiveQty) {
        this.receiveQty = receiveQty;
    }

    public BigDecimal getDelayQty() {
        return delayQty;
    }

    public void setDelayQty(BigDecimal delayQty) {
        this.delayQty = delayQty;
    }

    public BigDecimal getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(BigDecimal returnQty) {
        this.returnQty = returnQty;
    }

    public BigDecimal getReceivePrice() {
        return receivePrice;
    }

    public void setReceivePrice(BigDecimal receivePrice) {
        this.receivePrice = receivePrice;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public String getDeliverCode() {
        return deliverCode;
    }

    public void setDeliverCode(String deliverCode) {
        this.deliverCode = deliverCode;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }


    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }
}
