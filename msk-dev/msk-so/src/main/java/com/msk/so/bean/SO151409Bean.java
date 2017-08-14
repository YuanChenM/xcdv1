package com.msk.so.bean;

import com.msk.core.bean.BaseBean;

import java.math.BigDecimal;

/**
 * 卖家销售排行Bean
 * Created by yang_chunyan on 2016/3/22.
 */
public class SO151409Bean extends BaseBean {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 物流区编号 */
    private java.lang.String lgcsCode;
    /** 订单等级 */
    private java.lang.Integer orderLevel;
    /** 产品编码 */
    private java.lang.String pdCode;
    /** 供应商编码 */
    private java.lang.String suppCode;
    /** 供应商名称 */
    private java.lang.String suppName;
    /** 价盘周期 */
    private java.lang.String priceCycle;
    /** 销售额 */
    private java.math.BigDecimal salesAmount;
    /** 销售排行 */
    private java.lang.Integer salesRanking;
    /** 分销资格 */
    private java.lang.Integer distQua;
    /** 轮单次数 */
    private java.lang.Integer wheelFrequency;

    private java.lang.String levelName;

    public String getLgcsCode() {
        return lgcsCode;
    }

    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    public Integer getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(Integer orderLevel) {
        this.orderLevel = orderLevel;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getSuppCode() {
        return suppCode;
    }

    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getPriceCycle() {
        return priceCycle;
    }

    public void setPriceCycle(String priceCycle) {
        this.priceCycle = priceCycle;
    }

    public BigDecimal getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Integer getSalesRanking() {
        return salesRanking;
    }

    public void setSalesRanking(Integer salesRanking) {
        this.salesRanking = salesRanking;
    }

    public Integer getDistQua() {
        return distQua;
    }

    public void setDistQua(Integer distQua) {
        this.distQua = distQua;
    }

    public Integer getWheelFrequency() {
        return wheelFrequency;
    }

    public void setWheelFrequency(Integer wheelFrequency) {
        this.wheelFrequency = wheelFrequency;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}

