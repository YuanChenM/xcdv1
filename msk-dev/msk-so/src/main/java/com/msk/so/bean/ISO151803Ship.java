package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

import java.util.Date;
import java.util.List;


/**
 *
 */
public class ISO151803Ship extends BaseEntity {
    private Long shipId;//发货明细
    private String shipCode;//发货单号ID
    private String proDate;//期望配送日 yyyy-mm-dd
    private String expectReceiveTime;//预计送达时间
    private String actualReceiveTime;//实际送达时间，取配送单中最迟配送到的时间
    private Integer canReturn;//从时间判定是否可退货，1-可退货，2-不可退

    private List<ISO151803Product>productList;


    public List<ISO151803Product> getProductList() {
        return productList;
    }

    public void setProductList(List<ISO151803Product> productList) {
        this.productList = productList;
    }

    public void setExpectReceiveTime(String expectReceiveTime) {
        this.expectReceiveTime = expectReceiveTime;
    }

    public void setActualReceiveTime(String actualReceiveTime) {
        this.actualReceiveTime = actualReceiveTime;
    }

    public String getExpectReceiveTime() {
        return expectReceiveTime;
    }

    public String getActualReceiveTime() {
        return actualReceiveTime;
    }

    public Integer getCanReturn() {
        return canReturn;
    }

    public void setCanReturn(Integer canReturn) {
        this.canReturn = canReturn;
    }



    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public String getShipCode() {
        return shipCode;
    }

    public void setShipCode(String shipCode) {
        this.shipCode = shipCode;
    }

    public String getProDate() {
        return proDate;
    }

    public void setProDate(String proDate) {
        this.proDate = proDate;
    }
}
