package com.msk.batch.bp.bean;

import com.msk.core.bean.BaseParam;

import java.math.BigDecimal;
import java.util.Date;

/**
 * BBP112213Param
 * @author peng_hao
 */
public class BBP112213Param extends BaseParam {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 当前时间 */
    private Date currentDate;
    /**(报价)价盘ID*/
    private Long priceCycleId;
    /**价盘周期*/
    private String priceCyclePeriod;
    /**产品编码（组合码，不包含加工类型）*/
    private String pdCode;
    /**物流区编码*/
    private String logiAreaCode;
    /**物流区名称*/
    private String logiAreaName;
    /**卖家编码*/
    private String slCode;
    /**卖家名称*/
    private String slName;
    /**报价Detail ID*/
    private int priceCycLeDetailId;
    /**订单等级编码*/
    private String orderLevelCode;
    /**订单等级编码*/
    private String orderLevelName;
    /**等级标准(箱)下限*/
    private int levelStandMin;
    /**等级标准(箱)上限*/
    private int levelStandMax;
    /**市场指导价格(元/KG)下限*/
    private double guidePricesMin;
    /**市场指导价格(元/KG)上限*/
    private double guidePricesMax;
    /**标准价盘等级系数*/
    private int standardCoefficient;
    /**本期价盘等级系数*/
    private int currentCoefficient;
    /**公斤价*/
    private BigDecimal priceOfKg;
    /**折扣率*/
    private BigDecimal disCount;
    /**箱价（净重*公斤价）*/
    private BigDecimal priceOfBox;
    /**净重（F数值）*/
    private BigDecimal netWeight;
    /**是否中标*/
    private int isBidderFlg;
    /**
     * 箱数
     */
    private BigDecimal stockNum;

    public BigDecimal getStockNum() {
        return stockNum;
    }

    public void setStockNum(BigDecimal stockNum) {
        this.stockNum = stockNum;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Long getPriceCycleId() {
        return priceCycleId;
    }

    public void setPriceCycleId(Long priceCycleId) {
        this.priceCycleId = priceCycleId;
    }

    public String getPriceCyclePeriod() {
        return priceCyclePeriod;
    }

    public void setPriceCyclePeriod(String priceCyclePeriod) {
        this.priceCyclePeriod = priceCyclePeriod;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getLogiAreaCode() {
        return logiAreaCode;
    }

    public void setLogiAreaCode(String logiAreaCode) {
        this.logiAreaCode = logiAreaCode;
    }

    public String getLogiAreaName() {
        return logiAreaName;
    }

    public void setLogiAreaName(String logiAreaName) {
        this.logiAreaName = logiAreaName;
    }

    public String getSlCode() {
        return slCode;
    }

    public void setSlCode(String slCode) {
        this.slCode = slCode;
    }

    public String getSlName() {
        return slName;
    }

    public void setSlName(String slName) {
        this.slName = slName;
    }

    public int getPriceCycLeDetailId() {
        return priceCycLeDetailId;
    }

    public void setPriceCycLeDetailId(int priceCycLeDetailId) {
        this.priceCycLeDetailId = priceCycLeDetailId;
    }

    public String getOrderLevelCode() {
        return orderLevelCode;
    }

    public void setOrderLevelCode(String orderLevelCode) {
        this.orderLevelCode = orderLevelCode;
    }

    public String getOrderLevelName() {
        return orderLevelName;
    }

    public void setOrderLevelName(String orderLevelName) {
        this.orderLevelName = orderLevelName;
    }

    public int getLevelStandMin() {
        return levelStandMin;
    }

    public void setLevelStandMin(int levelStandMin) {
        this.levelStandMin = levelStandMin;
    }

    public int getLevelStandMax() {
        return levelStandMax;
    }

    public void setLevelStandMax(int levelStandMax) {
        this.levelStandMax = levelStandMax;
    }

    public double getGuidePricesMin() {
        return guidePricesMin;
    }

    public void setGuidePricesMin(double guidePricesMin) {
        this.guidePricesMin = guidePricesMin;
    }

    public double getGuidePricesMax() {
        return guidePricesMax;
    }

    public void setGuidePricesMax(double guidePricesMax) {
        this.guidePricesMax = guidePricesMax;
    }

    public int getStandardCoefficient() {
        return standardCoefficient;
    }

    public void setStandardCoefficient(int standardCoefficient) {
        this.standardCoefficient = standardCoefficient;
    }

    public int getCurrentCoefficient() {
        return currentCoefficient;
    }

    public void setCurrentCoefficient(int currentCoefficient) {
        this.currentCoefficient = currentCoefficient;
    }

    public BigDecimal getPriceOfKg() {
        return priceOfKg;
    }

    public void setPriceOfKg(BigDecimal priceOfKg) {
        this.priceOfKg = priceOfKg;
    }

    public BigDecimal getDisCount() {
        return disCount;
    }

    public void setDisCount(BigDecimal disCount) {
        this.disCount = disCount;
    }

    public BigDecimal getPriceOfBox() {
        return priceOfBox;
    }

    public void setPriceOfBox(BigDecimal priceOfBox) {
        this.priceOfBox = priceOfBox;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public int getIsBidderFlg() {
        return isBidderFlg;
    }

    public void setIsBidderFlg(int isBidderFlg) {
        this.isBidderFlg = isBidderFlg;
    }

}
