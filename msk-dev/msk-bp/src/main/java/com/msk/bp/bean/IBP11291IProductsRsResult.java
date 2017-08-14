package com.msk.bp.bean;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * IBP11291IRsResult接口返回结果信息.
 *
 * @author xu_wei
 */
public class IBP11291IProductsRsResult extends BaseEntity {
    /**
     * 订单等级等级（10级）
     */
    private String orderLevel;
    /**
     * 商品价格（10级价格）
     */
    private String price;
    /**
     * 物流区编码
     */
    private String logiAreaCode;
    /**
     * 物流区名称
     */
    private String logiAreaName;
    /**
     * 卖家编码
     */
    private String slCode;
    /**
     * 卖家名称
     */
    private String slName;
    /**
     * 订单等级编码
     */
    private String orderlevelCode;
    /**
     * 订单等级名称
     */
    private String orderlevelName;
    /**
     * 净重（数值）
     */
    private BigDecimal netWeight;
    /**
     * 公斤价
     */
    private BigDecimal priceOfKg;
    /**
     * 箱价（净重*公斤价）
     */
    private BigDecimal priceOfBox;

    /**
     * 等级标准(箱)下限

     */
    private BigDecimal boxMin;

    public BigDecimal getBoxMin() {
        return boxMin;
    }

    public void setBoxMin(BigDecimal boxMin) {
        this.boxMin = boxMin;
    }

    public BigDecimal getBoxMax() {
        return boxMax;
    }

    public void setBoxMax(BigDecimal boxMax) {
        this.boxMax = boxMax;
    }

    /**
     * 等级标准(箱)上限
     */
    private BigDecimal boxMax;

    /**
     * 折扣率
     */
    private BigDecimal disCount;


    public BigDecimal getDisCount() {
        return disCount;
    }

    public void setDisCount(BigDecimal disCount) {
        this.disCount = disCount;
    }

    public String getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(String orderLevel) {
        this.orderLevel = orderLevel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getOrderlevelCode() {
        return orderlevelCode;
    }

    public void setOrderlevelCode(String orderlevelCode) {
        this.orderlevelCode = orderlevelCode;
    }

    public String getOrderlevelName() {
        return orderlevelName;
    }

    public void setOrderlevelName(String orderlevelName) {
        this.orderlevelName = orderlevelName;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public BigDecimal getPriceOfKg() {
        return priceOfKg;
    }

    public void setPriceOfKg(BigDecimal priceOfKg) {
        this.priceOfKg = priceOfKg;
    }

    public BigDecimal getPriceOfBox() {
        return priceOfBox;
    }

    public void setPriceOfBox(BigDecimal priceOfBox) {
        this.priceOfBox = priceOfBox;
    }
}
