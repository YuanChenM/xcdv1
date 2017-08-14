package com.msk.so.bean;

import java.math.BigDecimal;
/**
 * 
 * ISO251401RsProduct接口接收的产品信息.
 *
 * @author gyh
 */
public class ISO251401RsProduct {
    /**产品编码*/
    private String pdCode;
    /**产品名称*/
    private String pdName;
    /**订单价格*/
    private BigDecimal orderPrice;
    /**价盘周期*/
    private String priceCycle;
    /**订单数量*/
    private BigDecimal orderQty;
    /**
     * Get the pdCode.
     *
     * @return pdCode
     *
     * @author gyh
     */
    public String getPdCode() {
        return this.pdCode;
    }
    /**
     * Set the pdCode.
     *
     * @param pdCode pdCode
     *
     * @author gyh
     */
    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }
    /**
     * Get the pdName.
     *
     * @return pdName
     *
     * @author gyh
     */
    public String getPdName() {
        return this.pdName;
    }
    /**
     * Set the pdName.
     *
     * @param pdName pdName
     *
     * @author gyh
     */
    public void setPdName(String pdName) {
        this.pdName = pdName;
    }
    /**
     * Get the orderPrice.
     *
     * @return orderPrice
     *
     * @author gyh
     */
    public BigDecimal getOrderPrice() {
        return this.orderPrice;
    }
    /**
     * Set the orderPrice.
     *
     * @param orderPrice orderPrice
     *
     * @author gyh
     */
    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
    /**
     * Get the priceCycle.
     *
     * @return priceCycle
     *
     * @author gyh
     */
    public String getPriceCycle() {
        return this.priceCycle;
    }
    /**
     * Set the priceCycle.
     *
     * @param priceCycle priceCycle
     *
     * @author gyh
     */
    public void setPriceCycle(String priceCycle) {
        this.priceCycle = priceCycle;
    }
    /**
     * Get the orderQty.
     *
     * @return orderQty
     *
     * @author gyh
     */
    public java.math.BigDecimal getOrderQty() {
        return this.orderQty;
    }
    /**
     * Set the orderQty.
     *
     * @param orderQty orderQty
     *
     * @author gyh
     */
    public void setOrderQty(BigDecimal orderQty) {
        this.orderQty = orderQty;
    }
}
