package com.msk.so.bean;

import com.msk.core.bean.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 发货单列表
 *
 * @author rwf
 */

public class SO151414Bean extends BaseBean {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private String shipId;

    private String orderCode;

    private String districtName;

    private String buyersCode;

    private String buyersName;

    private String frozenGoodsHousekeep;

    private String receiverAddr;

    private String shipTime;

    private String shipStatusName;

    private String whCode;

    private String whName;

    private List<Long> shipIdList = new ArrayList<>();

    public List<Long> getShipIdList() {
        return shipIdList;
    }

    public void setShipIdList(List<Long> shipIdList) {
        this.shipIdList = shipIdList;
    }

    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
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

    public String getFrozenGoodsHousekeep() {
        return frozenGoodsHousekeep;
    }

    public void setFrozenGoodsHousekeep(String frozenGoodsHousekeep) {
        this.frozenGoodsHousekeep = frozenGoodsHousekeep;
    }

    public String getReceiverAddr() {
        return receiverAddr;
    }

    public void setReceiverAddr(String receiverAddr) {
        this.receiverAddr = receiverAddr;
    }

    public String getShipTime() {
        return shipTime;
    }

    public void setShipTime(String shipTime) {
        this.shipTime = shipTime;
    }

    public String getShipStatusName() {
        return shipStatusName;
    }

    public void setShipStatusName(String shipStatusName) {
        this.shipStatusName = shipStatusName;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }
}