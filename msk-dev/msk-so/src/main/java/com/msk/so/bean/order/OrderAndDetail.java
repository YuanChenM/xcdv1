package com.msk.so.bean.order;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * Created by zhang_qiang1 on 2016/6/20.
 */
public class OrderAndDetail extends BaseEntity {

    private String buyerType;// 判断  是分销  还是 菜场

    private String orderID;// 订单id


    private String orderCode;// 订单编码


    private String orderType;// 订单类型


    private String orderTime;// 下单时间

    private String orderStatus;// 订单状态


    private String buyersName;// 买家名称

    private String buyersTypeName;// 买家类型

    private String markt;//市场


    private String buyerId;//  买家id

    private String receiverAddr;//收货地址


    private String receiverTel;//电话

    private String frozenGoodsHousekeep;// 冻品管家


    private String orderAmount;// 订单总金额

    private String orderDetailId;// 订单明细id


    private String classCode;// 产品类型


    private String className;// 产品类型名称

    private String breedCode;// 产品品种


    private String breedName;//产品品种名称


    private String featureCode;// 特征编码


    private String featrueName;// 特征编码名称


    private String normsName;// 产品包装名称


    private String pdCode;// 产品编码


    private String pdName;// 产品名称


    private String pdGradeName;// 产品等级名称


    private double price;// 产品价格


    private String orderQty;//订单量


    private String orderDetailAmount;//订单明细金额


    private String supplierName;// 供应商名称


    private String suppQty;// 供应量


    private String sendQty;// 发货量


    private String receiveQty;//  收货量


    private String cancelQty;//  取消数量


    private String rejectionQty;//  拒收数量


    private String returnQty;// 退货数量


    private String sendTime;//发货时间


    private String RecevicedTime;//收货时间

    private String buyerCode; //买家编码

    private String shipId;// 发货单id

    private  String  salesParty;// 销售方

    private String orderSource;

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getBuyersName() {
        return buyersName;
    }

    public void setBuyersName(String buyersName) {
        this.buyersName = buyersName;
    }

    public String getFrozenGoodsHousekeep() {
        return frozenGoodsHousekeep;
    }

    public void setFrozenGoodsHousekeep(String frozenGoodsHousekeep) {
        this.frozenGoodsHousekeep = frozenGoodsHousekeep;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public String getFeatrueName() {
        return featrueName;
    }

    public void setFeatrueName(String featrueName) {
        this.featrueName = featrueName;
    }

    public String getNormsName() {
        return normsName;
    }

    public void setNormsName(String normsName) {
        this.normsName = normsName;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getPdGradeName() {
        return pdGradeName;
    }

    public void setPdGradeName(String pdGradeName) {
        this.pdGradeName = pdGradeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(String orderQty) {
        this.orderQty = orderQty;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSuppQty() {
        return suppQty;
    }

    public void setSuppQty(String suppQty) {
        this.suppQty = suppQty;
    }

    public String getSendQty() {
        return sendQty;
    }

    public void setSendQty(String sendQty) {
        this.sendQty = sendQty;
    }

    public String getReceiveQty() {
        return receiveQty;
    }

    public void setReceiveQty(String receiveQty) {
        this.receiveQty = receiveQty;
    }

    public String getCancelQty() {
        return cancelQty;
    }

    public void setCancelQty(String cancelQty) {
        this.cancelQty = cancelQty;
    }

    public String getRejectionQty() {
        return rejectionQty;
    }

    public void setRejectionQty(String rejectionQty) {
        this.rejectionQty = rejectionQty;
    }

    public String getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(String returnQty) {
        this.returnQty = returnQty;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getRecevicedTime() {
        return RecevicedTime;
    }

    public void setRecevicedTime(String recevicedTime) {
        RecevicedTime = recevicedTime;
    }

    public String getMarkt() {
        return markt;
    }

    public void setMarkt(String markt) {
        this.markt = markt;
    }

    public String getReceiverAddr() {
        return receiverAddr;
    }

    public void setReceiverAddr(String receiverAddr) {
        this.receiverAddr = receiverAddr;
    }

    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }

    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }


    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }


    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderDetailAmount() {
        return orderDetailAmount;
    }

    public void setOrderDetailAmount(String orderDetailAmount) {
        this.orderDetailAmount = orderDetailAmount;
    }

    public String getBuyersTypeName() {
        return buyersTypeName;
    }

    public void setBuyersTypeName(String buyersTypeName) {
        this.buyersTypeName = buyersTypeName;
    }

    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    public String getSalesParty() {
        return salesParty;
    }

    public void setSalesParty(String salesParty) {
        this.salesParty = salesParty;
    }
}
