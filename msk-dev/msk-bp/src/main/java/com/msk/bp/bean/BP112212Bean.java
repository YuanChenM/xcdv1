package com.msk.bp.bean;


import com.msk.core.bean.BaseBean;

import java.math.BigDecimal;

/**美侍客卖家产品报价信息
 * BP112212Bean
 * liu_tao2
 */
public class BP112212Bean extends BaseBean {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 报价ID
     */
    private Long pricecycleId;

    /**
     * 报价Detail ID
     */
    private Long pricecycleDetailId;

    /**
     * 订单等级编码
     */
    private String orderLevelCode;

    /**
     * 订单等级名称
     */
    private String orderLevelName;

    /**
     * 等级标准(箱)下限
     */
    private Long levelStandMin;

    /**
     * 等级标准(箱)上限
     */
    private Long levelStandMax;

    /**
     * 市场指导价格(元/KG)下限
     */
    private BigDecimal guidePricesMin;

    /**
     * 市场指导价格(元/KG)下限
     */
    private BigDecimal guidePricesMax;

    /**
     * 标准价盘等级系数
     */
    private Long standardCoefficient;

    /**
     * 本期价盘等级系数
     */
    private Long currentCoefficient;

    /**
     * 公斤价
     */
    private BigDecimal priceOfKg;

    /**
     * 上期报价
     */
    private BigDecimal lastPriceOfKg;

    /**
     * 折扣率
     */
    private BigDecimal disCount;

    /**
     * 箱价（净重*公斤价）
     */
    private BigDecimal priceOfBox;

    /**
     * 净重（数值）
     */
    private BigDecimal netWeight;

    /**
     * 是否中标
     */
    private String isBidderFlg;

    /**
     * 备注
     */
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getPricecycleId() {
        return pricecycleId;
    }

    public BigDecimal getLastPriceOfKg() {
        return lastPriceOfKg;
    }

    public void setLastPriceOfKg(BigDecimal lastPriceOfKg) {
        this.lastPriceOfKg = lastPriceOfKg;
    }

    public void setPricecycleId(Long pricecycleId) {
        this.pricecycleId = pricecycleId;
    }

    public Long getPricecycleDetailId() {
        return pricecycleDetailId;
    }

    public void setPricecycleDetailId(Long pricecycleDetailId) {
        this.pricecycleDetailId = pricecycleDetailId;
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

    public Long getLevelStandMin() {
        return levelStandMin;
    }

    public void setLevelStandMin(Long levelStandMin) {
        this.levelStandMin = levelStandMin;
    }

    public Long getLevelStandMax() {
        return levelStandMax;
    }

    public void setLevelStandMax(Long levelStandMax) {
        this.levelStandMax = levelStandMax;
    }

    public BigDecimal getGuidePricesMin() {
        return guidePricesMin;
    }

    public void setGuidePricesMin(BigDecimal guidePricesMin) {
        this.guidePricesMin = guidePricesMin;
    }

    public BigDecimal getGuidePricesMax() {
        return guidePricesMax;
    }

    public void setGuidePricesMax(BigDecimal guidePricesMax) {
        this.guidePricesMax = guidePricesMax;
    }

    public Long getStandardCoefficient() {
        return standardCoefficient;
    }

    public void setStandardCoefficient(Long standardCoefficient) {
        this.standardCoefficient = standardCoefficient;
    }

    public Long getCurrentCoefficient() {
        return currentCoefficient;
    }

    public void setCurrentCoefficient(Long currentCoefficient) {
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

    public String getIsBidderFlg() {
        return isBidderFlg;
    }

    public void setIsBidderFlg(String isBidderFlg) {
        this.isBidderFlg = isBidderFlg;
    }

    /**
     * <p>默认构造函数。</p>
     */
    public BP112212Bean() {

    }

}
