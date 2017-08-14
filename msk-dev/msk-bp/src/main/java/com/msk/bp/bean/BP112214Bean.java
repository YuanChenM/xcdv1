package com.msk.bp.bean;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * Created by zhang_qiang1 on 2016/3/29.
 */
public class BP112214Bean extends BaseEntity{
    public BP112214Bean() {
    }
    //  价盘表
    private static final long serialVersionUID = 1L;
    /** 价盘ID */
    private Long pricecycleId;
    /** 价盘周期 */
    private String pricecyclePeriod;
    /** 产品编码 */
    private String pdCode;
    /*品名*/
    private String pdName;
    /** 产品等级 */
    private String pdGrade;
    /** 物流区编码 */
    private String logiareaCode;
    /** 物流区名称 */
    private String logiareaName;
    /** 卖家编码 */
    private String slCode;
    /** 卖家名称 */
    private String slName;
    /** 订单等级编码 */
    private String orderlevelCode;
    /** 订单等级名称 */
    private String orderlevelName;
    /** 净重（数值） */
    private BigDecimal netweight;
    /** 公斤价 */
    private BigDecimal priceofkg;
    /** 箱价（净重*公斤价） */
    private BigDecimal priceofbox;
    /** 折扣率 */
    private BigDecimal discount;
    /** 配料 */
    private String machining;
    /** 规格 */
    private String featureName;
    /** 箱数 */
    private String stockNum;
    /** 折后报价 */
    private BigDecimal afterPrice;







    /**
     * <p>默认构造函数。</p>
     */


    /**
     * <p>价盘ID。</p>
     *
     * @return the 价盘ID
     */
    public Long getPricecycleId() {
        return pricecycleId;
    }

    /**
     * <p>价盘ID。</p>
     *
     * @param pricecycleId 价盘ID。
     */
    public void setPricecycleId(Long pricecycleId) {
        this.pricecycleId = pricecycleId;
    }

    /**
     * <p>价盘周期。</p>
     *
     * @return the 价盘周期
     */
    public String getPricecyclePeriod() {
        return pricecyclePeriod;
    }

    /**
     * <p>价盘周期。</p>
     *
     * @param pricecyclePeriod 价盘周期。
     */
    public void setPricecyclePeriod(String pricecyclePeriod) {
        this.pricecyclePeriod = pricecyclePeriod;
    }

    /**
     * <p>产品编码。</p>
     *
     * @return the 产品编码
     */
    public String getPdCode() {
        return pdCode;
    }

    /**
     * <p>产品编码。</p>
     *
     * @param pdCode 产品编码。
     */
    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @return the 物流区编码
     */
    public String getLogiareaCode() {
        return logiareaCode;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @param logiareaCode 物流区编码。
     */
    public void setLogiareaCode(String logiareaCode) {
        this.logiareaCode = logiareaCode;
    }

    /**
     * <p>物流区名称。</p>
     *
     * @return the 物流区名称
     */
    public String getLogiareaName() {
        return logiareaName;
    }

    /**
     * <p>物流区名称。</p>
     *
     * @param logiareaName 物流区名称。
     */
    public void setLogiareaName(String logiareaName) {
        this.logiareaName = logiareaName;
    }

    /**
     * <p>卖家编码。</p>
     *
     * @return the 卖家编码
     */
    public String getSlCode() {
        return slCode;
    }

    /**
     * <p>卖家编码。</p>
     *
     * @param slCode 卖家编码。
     */
    public void setSlCode(String slCode) {
        this.slCode = slCode;
    }

    /**
     * <p>卖家名称。</p>
     *
     * @return the 卖家名称
     */
    public String getSlName() {
        return slName;
    }

    /**
     * <p>卖家名称。</p>
     *
     * @param slName 卖家名称。
     */
    public void setSlName(String slName) {
        this.slName = slName;
    }

    /**
     * <p>订单等级编码。</p>
     *
     * @return the 订单等级编码
     */
    public String getOrderlevelCode() {
        return orderlevelCode;
    }

    /**
     * <p>订单等级编码。</p>
     *
     * @param orderlevelCode 订单等级编码。
     */
    public void setOrderlevelCode(String orderlevelCode) {
        this.orderlevelCode = orderlevelCode;
    }

    /**
     * <p>订单等级名称。</p>
     *
     * @return the 订单等级名称
     */
    public String getOrderlevelName() {
        return orderlevelName;
    }

    /**
     * <p>订单等级名称。</p>
     *
     * @param orderlevelName 订单等级名称。
     */
    public void setOrderlevelName(String orderlevelName) {
        this.orderlevelName = orderlevelName;
    }

    /**
     * <p>净重（数值）。</p>
     *
     * @return the 净重（数值）
     */
    public BigDecimal getNetweight() {
        return netweight;
    }

    /**
     * <p>净重（数值）。</p>
     *
     * @param netweight 净重（数值）。
     */
    public void setNetweight(BigDecimal netweight) {
        this.netweight = netweight;
    }

    /**
     * <p>公斤价。</p>
     *
     * @return the 公斤价
     */
    public BigDecimal getPriceofkg() {
        return priceofkg;
    }

    /**
     * <p>公斤价。</p>
     *
     * @param priceofkg 公斤价。
     */
    public void setPriceofkg(BigDecimal priceofkg) {
        this.priceofkg = priceofkg;
    }

    /**
     * <p>箱价（净重*公斤价）。</p>
     *
     * @return the 箱价（净重*公斤价）
     */
    public BigDecimal getPriceofbox() {
        return priceofbox;
    }

    /**
     * <p>箱价（净重*公斤价）。</p>
     *
     * @param priceofbox 箱价（净重*公斤价）。
     */
    public void setPriceofbox(BigDecimal priceofbox) {
        this.priceofbox = priceofbox;
    }

    /**
     * <p>折扣率。</p>
     *
     * @return the 折扣率
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * <p>折扣率。</p>
     *
     * @param discount 折扣率。
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getStockNum() {
        return stockNum;
    }

    public void setStockNum(String stockNum) {
        this.stockNum = stockNum;
    }

    public BigDecimal getAfterPrice() {
        return afterPrice;
    }

    public void setAfterPrice(BigDecimal afterPrice) {
        this.afterPrice = afterPrice;
    }


    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getPdGrade() {
        return pdGrade;
    }

    public void setPdGrade(String pdGrade) {
        this.pdGrade = pdGrade;
    }

}
