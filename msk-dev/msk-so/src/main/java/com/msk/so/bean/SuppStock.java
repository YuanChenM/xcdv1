package com.msk.so.bean;

import com.msk.core.entity.SoStockSp;

import java.math.BigDecimal;

/**
 * SuppStock
 *
 * @author yang_yang
 * @version 1.0
 **/
public class SuppStock extends SoStockSp {
    private BigDecimal price;
    private String lgcsName;
    private String priceCyclePeriod;
    private String orderLevelCode;
    private String orderLevelName;
    private BigDecimal activeQty;
    private String pricecycleId;
    private BigDecimal netWeightOut;

    public BigDecimal getNetWeightOut() {
        return netWeightOut;
    }

    public void setNetWeightOut(BigDecimal netWeightOut) {
        this.netWeightOut = netWeightOut;
    }

    /**
     * Getter method for property <tt>orderLevelCode</tt>.
     *
     * @return property value of orderLevelCode
     */
    public String getOrderLevelCode() {
        return orderLevelCode;
    }

    /**
     * Setter method for property <tt>orderLevelCode</tt>.
     *
     * @param orderLevelCode value to be assigned to property orderLevelCode
     */
    public void setOrderLevelCode(String orderLevelCode) {
        this.orderLevelCode = orderLevelCode;
    }

    /**
     * Getter method for property <tt>orderLevelName</tt>.
     *
     * @return property value of orderLevelName
     */
    public String getOrderLevelName() {
        return orderLevelName;
    }

    /**
     * Setter method for property <tt>orderLevelName</tt>.
     *
     * @param orderLevelName value to be assigned to property orderLevelName
     */
    public void setOrderLevelName(String orderLevelName) {
        this.orderLevelName = orderLevelName;
    }

    /**
     * Getter method for property <tt>priceCyclePeriod</tt>.
     *
     * @return property value of priceCyclePeriod
     */
    public String getPriceCyclePeriod() {
        return priceCyclePeriod;
    }

    /**
     * Setter method for property <tt>priceCyclePeriod</tt>.
     *
     * @param priceCyclePeriod value to be assigned to property priceCyclePeriod
     */
    public void setPriceCyclePeriod(String priceCyclePeriod) {
        this.priceCyclePeriod = priceCyclePeriod;
    }

    /**
     * Getter method for property <tt>lgcsName</tt>.
     *
     * @return property value of lgcsName
     */
    @Override
    public String getLgcsName() {
        return lgcsName;
    }

    /**
     * Setter method for property <tt>lgcsName</tt>.
     *
     * @param lgcsName value to be assigned to property lgcsName
     */
    @Override
    public void setLgcsName(String lgcsName) {
        this.lgcsName = lgcsName;
    }

    /**
     * Getter method for property <tt>price</tt>.
     *
     * @return property value of price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Setter method for property <tt>price</tt>.
     *
     * @param price value to be assigned to property price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getActiveQty() {
        return activeQty;
    }

    public void setActiveQty(BigDecimal activeQty) {
        this.activeQty = activeQty;
    }

    public String getPricecycleId() {
        return pricecycleId;
    }

    public void setPricecycleId(String pricecycleId) {
        this.pricecycleId = pricecycleId;
    }
}
