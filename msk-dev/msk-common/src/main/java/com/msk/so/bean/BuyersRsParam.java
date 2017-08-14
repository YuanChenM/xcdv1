package com.msk.so.bean;


import com.msk.core.bean.BaseParam;

/**
 *
 * 调用买家模块接口
 * @author sun_jiaju
 */
public class BuyersRsParam extends BaseParam {
    //买家ID
    private String buyerId;
    //省名称
    private String provinceName;
    //市名称
    private String cityName;
    //区名称
    private String districtName;
    //配送地址
    private String deliveryAddr;
    //买家ID
    private String buyerCode;

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDeliveryAddr() {
        return deliveryAddr;
    }

    public void setDeliveryAddr(String deliveryAddr) {
        this.deliveryAddr = deliveryAddr;
    }

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }
}
