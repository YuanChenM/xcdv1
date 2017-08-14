package com.msk.so.bean;

/**
 * Created by Administrator on 2016/2/26.
 */
public class DeliveryReqParam{
    //动检证要求，1要
    private String vicFlg;
    //装卸要求
    private String unloadReq;
    //包装要求
    private String packingReq;
    //距离门店最近停车距离(米)
    private Integer parkingDistance;
    //其他配送服务要求
    private String otherDeliveryReq;
    //本次配送服务要求

    /**
     * 获得thisDeliveryReq
     */
    public String getThisDeliveryReq() {
        return thisDeliveryReq;
    }

    /**
     * 设置thisDeliveryReq
     */
    public void setThisDeliveryReq(String thisDeliveryReq) {
        this.thisDeliveryReq = thisDeliveryReq;
    }

    /**
     * 获得vicFlg
     */
    public String getVicFlg() {
        return vicFlg;
    }

    /**
     * 设置vicFlg
     */
    public void setVicFlg(String vicFlg) {
        this.vicFlg = vicFlg;
    }

    /**
     * 获得unloadReq
     */
    public String getUnloadReq() {
        return unloadReq;
    }

    /**
     * 设置unloadReq
     */
    public void setUnloadReq(String unloadReq) {
        this.unloadReq = unloadReq;
    }

    /**
     * 获得packingReq
     */
    public String getPackingReq() {
        return packingReq;
    }

    /**
     * 设置packingReq
     */
    public void setPackingReq(String packingReq) {
        this.packingReq = packingReq;
    }

    /**
     * 获得parkingDistance
     */
    public Integer getParkingDistance() {
        return parkingDistance;
    }

    /**
     * 设置parkingDistance
     */
    public void setParkingDistance(Integer parkingDistance) {
        this.parkingDistance = parkingDistance;
    }

    /**
     * 获得otherDeliveryReq
     */
    public String getOtherDeliveryReq() {
        return otherDeliveryReq;
    }

    /**
     * 设置otherDeliveryReq
     */
    public void setOtherDeliveryReq(String otherDeliveryReq) {
        this.otherDeliveryReq = otherDeliveryReq;
    }

    private String thisDeliveryReq;
}


