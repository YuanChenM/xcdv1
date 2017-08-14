package com.msk.bp.bean;

import com.msk.core.entity.BaseEntity;
import com.msk.core.utils.StringUtil;

/**
 * 美侍客卖家产品价盘bean
 */
public class BP112215Bean extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /** 价盘ID */
    private java.lang.Long pricecycleId;
    /** 价盘周期 */
    private java.lang.String pricecyclePeriod;
    /** 产品编码 */
    private java.lang.String pdCode;
    /** 物流区编码 */
    private java.lang.String logiareaCode;
    /** 物流区名称 */
    private java.lang.String logiareaName;
    /** 卖家编码 */
    private java.lang.String slCode;
    /** 卖家名称 */
    private java.lang.String slName;
    /** 订单等级编码 */
    private java.lang.String orderlevelCode;
    /** 订单等级名称 */
    private java.lang.String orderlevelName;
    /** 净重（数值） */
    private java.lang.String netweight;
    /** 公斤价 */
    private java.lang.String priceofkg;
    /** 箱价（净重*公斤价） */
    private java.lang.String priceofbox;
    /** 折扣率 */
    private java.lang.String discount;
    /** 品名 */
    private java.lang.String pdName;
    /** 配料 */
    private java.lang.String machining;
    /** 规格 */
    private java.lang.String featureName;
    /** 产品等级 */
    private java.lang.String pdGrade;
    /** 箱数 */
    private java.lang.String stockNum;
    /** 折后报价 */
    private java.math.BigDecimal afterPrice;

    /**
     * <p>默认构造函数。</p>
     */
    public BP112215Bean() {

    }

    /**
     * <p>价盘ID。</p>
     *
     * @return the 价盘ID
     */
    public java.lang.Long getPricecycleId() {
        return pricecycleId;
    }

    /**
     * <p>价盘ID。</p>
     *
     * @param pricecycleId 价盘ID。
     */
    public void setPricecycleId(java.lang.Long pricecycleId) {
        this.pricecycleId = pricecycleId;
    }

    /**
     * <p>价盘周期。</p>
     *
     * @return the 价盘周期
     */
    public java.lang.String getPricecyclePeriod() {
        return pricecyclePeriod;
    }

    /**
     * <p>价盘周期。</p>
     *
     * @param pricecyclePeriod 价盘周期。
     */
    public void setPricecyclePeriod(java.lang.String pricecyclePeriod) {
        this.pricecyclePeriod = pricecyclePeriod;
    }

    /**
     * <p>产品编码。</p>
     *
     * @return the 产品编码
     */
    public java.lang.String getPdCode() {
        return pdCode;
    }

    /**
     * <p>产品编码。</p>
     *
     * @param pdCode 产品编码。
     */
    public void setPdCode(java.lang.String pdCode) {
        this.pdCode = pdCode;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @return the 物流区编码
     */
    public java.lang.String getLogiareaCode() {
        return logiareaCode;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @param logiareaCode 物流区编码。
     */
    public void setLogiareaCode(java.lang.String logiareaCode) {
        this.logiareaCode = logiareaCode;
    }

    /**
     * <p>物流区名称。</p>
     *
     * @return the 物流区名称
     */
    public java.lang.String getLogiareaName() {
        return logiareaName;
    }

    /**
     * <p>物流区名称。</p>
     *
     * @param logiareaName 物流区名称。
     */
    public void setLogiareaName(java.lang.String logiareaName) {
        this.logiareaName = logiareaName;
    }

    /**
     * <p>卖家编码。</p>
     *
     * @return the 卖家编码
     */
    public java.lang.String getSlCode() {
        return slCode;
    }

    /**
     * <p>卖家编码。</p>
     *
     * @param slCode 卖家编码。
     */
    public void setSlCode(java.lang.String slCode) {
        this.slCode = slCode;
    }

    /**
     * <p>卖家名称。</p>
     *
     * @return the 卖家名称
     */
    public java.lang.String getSlName() {
        return slName;
    }

    /**
     * <p>卖家名称。</p>
     *
     * @param slName 卖家名称。
     */
    public void setSlName(java.lang.String slName) {
        this.slName = slName;
    }

    /**
     * <p>订单等级编码。</p>
     *
     * @return the 订单等级编码
     */
    public java.lang.String getOrderlevelCode() {
        return orderlevelCode;
    }

    /**
     * <p>订单等级编码。</p>
     *
     * @param orderlevelCode 订单等级编码。
     */
    public void setOrderlevelCode(java.lang.String orderlevelCode) {
        this.orderlevelCode = orderlevelCode;
    }

    /**
     * <p>订单等级名称。</p>
     *
     * @return the 订单等级名称
     */
    public java.lang.String getOrderlevelName() {
        return orderlevelName;
    }

    /**
     * <p>订单等级名称。</p>
     *
     * @param orderlevelName 订单等级名称。
     */
    public void setOrderlevelName(java.lang.String orderlevelName) {
        this.orderlevelName = orderlevelName;
    }

    /**
     * <p>净重（数值）。</p>
     *
     * @return the 净重（数值）
     */
    public java.lang.String getNetweight() {
        return netweight;
    }

    /**
     * <p>净重（数值）。</p>
     *
     * @param netweight 净重（数值）。
     */
    public void setNetweight(java.lang.String netweight) {
        this.netweight = netweight;
    }

    /**
     * <p>公斤价。</p>
     *
     * @return the 公斤价
     */
    public java.lang.String getPriceofkg() {
        return priceofkg;
    }

    /**
     * <p>公斤价。</p>
     *
     * @param priceofkg 公斤价。
     */
    public void setPriceofkg(java.lang.String priceofkg) {
        this.priceofkg = priceofkg;
    }

    /**
     * <p>箱价（净重*公斤价）。</p>
     *
     * @return the 箱价（净重*公斤价）
     */
    public java.lang.String getPriceofbox() {
        return priceofbox;
    }

    /**
     * <p>箱价（净重*公斤价）。</p>
     *
     * @param priceofbox 箱价（净重*公斤价）。
     */
    public void setPriceofbox(java.lang.String priceofbox) {
        this.priceofbox = priceofbox;
    }

    /**
     * <p>折扣率。</p>
     *
     * @return the 折扣率
     */
    public java.lang.String getDiscount() {
        return discount;
    }

    /**
     * <p>折扣率。</p>
     *
     * @param discount 折扣率。
     */
    public void setDiscount(java.lang.String discount) {
        this.discount = discount;
    }

    public java.math.BigDecimal getAfterPrice() {
        return afterPrice;
    }

    public void setAfterPrice(java.math.BigDecimal afterPrice) {
        this.afterPrice = afterPrice;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getMachining() {
        return machining;
    }

    public void setMachining(String machining) {
        this.machining = machining;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getPdGrade() {
        return pdGrade;
    }

    public void setPdGrade(String pdGrade) {
        this.pdGrade = pdGrade;
    }

    public String getStockNum() {
        return stockNum;
    }

    public void setStockNum(String stockNum) {
        this.stockNum = stockNum;
    }
}
