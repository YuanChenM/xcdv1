package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

import java.util.Date;

/**
 * Created by xuhongyang on 2017/2/6.
 */
public class IPL2017020501Result extends BaseBean {


    private Long plPdId;
    //产品名称
    private String pdName;
    //单价
    private String unitPrice;
    //销售量
    private String salesVolume;
    //销售时间
    private Date saleTime;
    //价盘期
    private String pricePeriod;
    //对应价盘通道
    private String priceChannel;
    //生产商
    private String manufacturer;

    /**
     * Getter method for property <tt>plPdId</tt>.
     *
     * @return property value of plPdId
     */
    public Long getPlPdId() {
        return plPdId;
    }

    /**
     * Setter method for property <tt>plPdId</tt>.
     *
     * @param plPdId value to be assigned to property plPdId
     */
    public void setPlPdId(Long plPdId) {
        this.plPdId = plPdId;
    }

    /**
     * Getter method for property <tt>pdName</tt>.
     *
     * @return property value of pdName
     */
    public String getPdName() {
        return pdName;
    }

    /**
     * Setter method for property <tt>pdName</tt>.
     *
     * @param pdName value to be assigned to property pdName
     */
    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    /**
     * Getter method for property <tt>unitPrice</tt>.
     *
     * @return property value of unitPrice
     */
    public String getUnitPrice() {
        return unitPrice;
    }

    /**
     * Setter method for property <tt>unitPrice</tt>.
     *
     * @param unitPrice value to be assigned to property unitPrice
     */
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Getter method for property <tt>salesVolume</tt>.
     *
     * @return property value of salesVolume
     */
    public String getSalesVolume() {
        return salesVolume;
    }

    /**
     * Setter method for property <tt>salesVolume</tt>.
     *
     * @param salesVolume value to be assigned to property salesVolume
     */
    public void setSalesVolume(String salesVolume) {
        this.salesVolume = salesVolume;
    }

    /**
     * Getter method for property <tt>saleTime</tt>.
     *
     * @return property value of saleTime
     */
    public Date getSaleTime() {
        return saleTime;
    }

    /**
     * Setter method for property <tt>saleTime</tt>.
     *
     * @param saleTime value to be assigned to property saleTime
     */
    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    /**
     * Getter method for property <tt>pricePeriod</tt>.
     *
     * @return property value of pricePeriod
     */
    public String getPricePeriod() {
        return pricePeriod;
    }

    /**
     * Setter method for property <tt>pricePeriod</tt>.
     *
     * @param pricePeriod value to be assigned to property pricePeriod
     */
    public void setPricePeriod(String pricePeriod) {
        this.pricePeriod = pricePeriod;
    }

    /**
     * Getter method for property <tt>priceChannel</tt>.
     *
     * @return property value of priceChannel
     */
    public String getPriceChannel() {
        return priceChannel;
    }

    /**
     * Setter method for property <tt>priceChannel</tt>.
     *
     * @param priceChannel value to be assigned to property priceChannel
     */
    public void setPriceChannel(String priceChannel) {
        this.priceChannel = priceChannel;
    }

    /**
     * Getter method for property <tt>manufacturer</tt>.
     *
     * @return property value of manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Setter method for property <tt>manufacturer</tt>.
     *
     * @param manufacturer value to be assigned to property manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
