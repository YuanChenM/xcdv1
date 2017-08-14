package com.msk.bs.bean;

import com.msk.core.entity.SlHouseAccount;
import com.msk.core.entity.SlHouseProduct;

import java.util.List;

/**
 * Created by gyh on 2016/3/17.
 */
public class IBS2101105RsResult extends SlHouseAccount {
    //行政区划
    private String cityName;
    //物流区划
    private String lgcsAreaName;
    //买手名称
    private String slContact;
    //当前专属买家数
    private String buyerNum;
    private Integer greade;//买手店管家等级
//  private List<SlHouseArea> slAreaList;//经营区域List
    private List<SlHouseProduct> housePdList;//管家管理产品list

    /**
     * Getter method for property <tt>cityName</tt>.
     *
     * @return property value of cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Setter method for property <tt>cityName</tt>.
     *
     * @param cityName value to be assigned to property cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Getter method for property <tt>lgcsAreaName</tt>.
     *
     * @return property value of lgcsAreaName
     */
    public String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * Setter method for property <tt>lgcsAreaName</tt>.
     *
     * @param lgcsAreaName value to be assigned to property lgcsAreaName
     */
    public void setLgcsAreaName(String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
    }

    /**
     * Getter method for property <tt>slContact</tt>.
     *
     * @return property value of slContact
     */
    public String getSlContact() {
        return slContact;
    }

    /**
     * Setter method for property <tt>slContact</tt>.
     *
     * @param slContact value to be assigned to property slContact
     */
    public void setSlContact(String slContact) {
        this.slContact = slContact;
    }

    /**
     * Getter method for property <tt>buyerNum</tt>.
     *
     * @return property value of buyerNum
     */
    public String getBuyerNum() {
        return buyerNum;
    }

    /**
     * Setter method for property <tt>buyerNum</tt>.
     *
     * @param buyerNum value to be assigned to property buyerNum
     */
    public void setBuyerNum(String buyerNum) {
        this.buyerNum = buyerNum;
    }

    /**
     * Getter method for property <tt>greade</tt>.
     *
     * @return property value of greade
     */
    public Integer getGreade() {
        return greade;
    }

    /**
     * Setter method for property <tt>greade</tt>.
     *
     * @param greade value to be assigned to property greade
     */
    public void setGreade(Integer greade) {
        this.greade = greade;
    }

    /**
     * Getter method for property <tt>housePdList</tt>.
     *
     * @return property value of housePdList
     */
    public List<SlHouseProduct> getHousePdList() {
        return housePdList;
    }

    /**
     * Setter method for property <tt>housePdList</tt>.
     *
     * @param housePdList value to be assigned to property housePdList
     */
    public void setHousePdList(List<SlHouseProduct> housePdList) {
        this.housePdList = housePdList;
    }
}
