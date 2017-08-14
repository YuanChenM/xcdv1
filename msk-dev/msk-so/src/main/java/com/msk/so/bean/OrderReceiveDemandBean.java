package com.msk.so.bean;


import com.msk.core.entity.SoOrderReceiveDemand;

/**
 * OrderDeliveryBean
 * 配送物流信息
 * 
 * @author jiang_nan
 * @version 1.0
 * update gyh
 * updateTime 2015.1.4
 **/
public class OrderReceiveDemandBean extends SoOrderReceiveDemand{

    private static final long serialVersionUID = 1L;

    //买家ID
    private String orderBuyersId;
    //买家编码
    private String buyersCode;
    //买家名称
    private String buyersName;
    //买家类型
    private String buyersType;
    //买家类型名称
    private String buyersTypeName;

    public String getOrderBuyersId() {
        return orderBuyersId;
    }

    public void setOrderBuyersId(String orderBuyersId) {
        this.orderBuyersId = orderBuyersId;
    }

    public String getBuyersTypeName() {
        return buyersTypeName;
    }

    public void setBuyersTypeName(String buyersTypeName) {
        this.buyersTypeName = buyersTypeName;
    }

    public String getBuyersId() {
        return orderBuyersId;
    }

    public void setBuyersId(String buyersId) {
        this.orderBuyersId = buyersId;
    }

    public String getBuyersCode() {
        return buyersCode;
    }

    public void setBuyersCode(String buyersCode) {
        this.buyersCode = buyersCode;
    }

    public String getBuyersName() {
        return buyersName;
    }

    public void setBuyersName(String buyersName) {
        this.buyersName = buyersName;
    }

    public String getBuyersType() {
        return buyersType;
    }

    public void setBuyersType(String buyersType) {
        this.buyersType = buyersType;
    }
}
