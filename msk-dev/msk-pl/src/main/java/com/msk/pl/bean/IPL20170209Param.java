package com.msk.pl.bean;

import com.msk.core.bean.BaseParam;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by xuhongyang on 2017/2/6.
 *
 * 进货单产品保存接口入参
 */
public class IPL20170209Param extends BaseParam {





    //进货单产品ID
    private Long plPdId;
    //进货单ID
    private Long plId;
    //产品编码
    private String pdCode;
    //产品名称
    private String pdName;
    //小包装特征
    private String smallPackFeature;
    //小包装件数
    private String smallPackNumber;
    //大包装个数
    private String bigPackNumber;
    //净重
    private String netweight;
    //毛重
    private String grossweight;
    //纸箱尺寸
    private String cartonSize;
    //产品等级
    private String pdGrade;
    //托盘堆码数
    private String palletNumber;
    //销售时间
    private Date saleTime;
    //价盘期
    private String pricePeriod;
    //对应价盘通道
    private String priceChannel;
    //单价
    private String unitPrice;
    //销售量
    private String salesVolume;
    //客户对象
    private String clientObject;
    //品牌所有人
    private String brandOwner;
    //产品等级需求
    private String pdNeedGrade;
    //生产商
    private String manufacturer;
    /** PD_NAME_TYPE */
    private Integer pdNameType;

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
     * Getter method for property <tt>plId</tt>.
     *
     * @return property value of plId
     */
    public Long getPlId() {
        return plId;
    }

    /**
     * Setter method for property <tt>plId</tt>.
     *
     * @param plId value to be assigned to property plId
     */
    public void setPlId(Long plId) {
        this.plId = plId;
    }

    /**
     * Getter method for property <tt>pdCode</tt>.
     *
     * @return property value of pdCode
     */
    public String getPdCode() {
        return pdCode;
    }

    /**
     * Setter method for property <tt>pdCode</tt>.
     *
     * @param pdCode value to be assigned to property pdCode
     */
    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
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
     * Getter method for property <tt>smallPackFeature</tt>.
     *
     * @return property value of smallPackFeature
     */
    public String getSmallPackFeature() {
        return smallPackFeature;
    }

    /**
     * Setter method for property <tt>smallPackFeature</tt>.
     *
     * @param smallPackFeature value to be assigned to property smallPackFeature
     */
    public void setSmallPackFeature(String smallPackFeature) {
        this.smallPackFeature = smallPackFeature;
    }

    /**
     * Getter method for property <tt>smallPackNumber</tt>.
     *
     * @return property value of smallPackNumber
     */
    public String getSmallPackNumber() {
        return smallPackNumber;
    }

    /**
     * Setter method for property <tt>smallPackNumber</tt>.
     *
     * @param smallPackNumber value to be assigned to property smallPackNumber
     */
    public void setSmallPackNumber(String smallPackNumber) {
        this.smallPackNumber = smallPackNumber;
    }

    /**
     * Getter method for property <tt>bigPackNumber</tt>.
     *
     * @return property value of bigPackNumber
     */
    public String getBigPackNumber() {
        return bigPackNumber;
    }

    /**
     * Setter method for property <tt>bigPackNumber</tt>.
     *
     * @param bigPackNumber value to be assigned to property bigPackNumber
     */
    public void setBigPackNumber(String bigPackNumber) {
        this.bigPackNumber = bigPackNumber;
    }

    /**
     * Getter method for property <tt>netweight</tt>.
     *
     * @return property value of netweight
     */
    public String getNetweight() {
        return netweight;
    }

    /**
     * Setter method for property <tt>netweight</tt>.
     *
     * @param netweight value to be assigned to property netweight
     */
    public void setNetweight(String netweight) {
        this.netweight = netweight;
    }

    /**
     * Getter method for property <tt>grossweight</tt>.
     *
     * @return property value of grossweight
     */
    public String getGrossweight() {
        return grossweight;
    }

    /**
     * Setter method for property <tt>grossweight</tt>.
     *
     * @param grossweight value to be assigned to property grossweight
     */
    public void setGrossweight(String grossweight) {
        this.grossweight = grossweight;
    }

    /**
     * Getter method for property <tt>cartonSize</tt>.
     *
     * @return property value of cartonSize
     */
    public String getCartonSize() {
        return cartonSize;
    }

    /**
     * Setter method for property <tt>cartonSize</tt>.
     *
     * @param cartonSize value to be assigned to property cartonSize
     */
    public void setCartonSize(String cartonSize) {
        this.cartonSize = cartonSize;
    }

    /**
     * Getter method for property <tt>pdGrade</tt>.
     *
     * @return property value of pdGrade
     */
    public String getPdGrade() {
        return pdGrade;
    }

    /**
     * Setter method for property <tt>pdGrade</tt>.
     *
     * @param pdGrade value to be assigned to property pdGrade
     */
    public void setPdGrade(String pdGrade) {
        this.pdGrade = pdGrade;
    }

    /**
     * Getter method for property <tt>palletNumber</tt>.
     *
     * @return property value of palletNumber
     */
    public String getPalletNumber() {
        return palletNumber;
    }

    /**
     * Setter method for property <tt>palletNumber</tt>.
     *
     * @param palletNumber value to be assigned to property palletNumber
     */
    public void setPalletNumber(String palletNumber) {
        this.palletNumber = palletNumber;
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
     * Getter method for property <tt>clientObject</tt>.
     *
     * @return property value of clientObject
     */
    public String getClientObject() {
        return clientObject;
    }

    /**
     * Setter method for property <tt>clientObject</tt>.
     *
     * @param clientObject value to be assigned to property clientObject
     */
    public void setClientObject(String clientObject) {
        this.clientObject = clientObject;
    }

    /**
     * Getter method for property <tt>brandOwner</tt>.
     *
     * @return property value of brandOwner
     */
    public String getBrandOwner() {
        return brandOwner;
    }

    /**
     * Setter method for property <tt>brandOwner</tt>.
     *
     * @param brandOwner value to be assigned to property brandOwner
     */
    public void setBrandOwner(String brandOwner) {
        this.brandOwner = brandOwner;
    }

    /**
     * Getter method for property <tt>pdNeedGrade</tt>.
     *
     * @return property value of pdNeedGrade
     */
    public String getPdNeedGrade() {
        return pdNeedGrade;
    }

    /**
     * Setter method for property <tt>pdNeedGrade</tt>.
     *
     * @param pdNeedGrade value to be assigned to property pdNeedGrade
     */
    public void setPdNeedGrade(String pdNeedGrade) {
        this.pdNeedGrade = pdNeedGrade;
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

    /**
     * <p>PD_NAME_TYPE</p>
     *
     * @return PD_NAME_TYPE
     */
    public java.lang.Integer getPdNameType() {
        return pdNameType;
    }

    /**
     * <p>PD_NAME_TYPE</p>
     *
     * @param pdNameType PD_NAME_TYPE
     */
    public void setPdNameType(java.lang.Integer pdNameType) {
        this.pdNameType = pdNameType;
    }
}
