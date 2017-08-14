/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表by_market_terminal对应的ByMarketTerminal。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class ByMarketTerminal extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 菜场或批发市场的ID */
    private java.lang.String terMarketId;
    /** 批发市场编码 */
    private java.lang.String marketCode;
    /** 批发市场名称 */
    private java.lang.String marketName;
    /** 批发市场地址 */
    private java.lang.String marketAddr;
    /** 批发市场级别 */
    private java.lang.String marketLevel;
    /** 批发市场级别名称 */
    private java.lang.String marketLevelName;
    /** 物流区编码 */
    private java.lang.String lgcsAreaCode;
    /** 城市（地区）编码 */
    private java.lang.String cityCode;
    /** 区（县）编码 */
    private java.lang.String districtCode;
    /** 批发市场地区顺序码 */
    private java.lang.Integer cityMarketSeq;
    /**
     * <p>默认构造函数。</p>
     */
    public ByMarketTerminal() {

    }

    /**
     * <p>菜场或批发市场的ID。</p>
     *
     * @return the 菜场或批发市场的ID
     */
    public java.lang.String getTerMarketId() {
        return terMarketId;
    }

    /**
     * <p>菜场或批发市场的ID。</p>
     *
     * @param terMarketId 菜场或批发市场的ID。
     */
    public void setTerMarketId(java.lang.String terMarketId) {
        this.terMarketId = terMarketId;
    }

    /**
     * <p>批发市场编码。</p>
     *
     * @return the 批发市场编码
     */
    public java.lang.String getMarketCode() {
        return marketCode;
    }

    /**
     * <p>批发市场编码。</p>
     *
     * @param marketCode 批发市场编码。
     */
    public void setMarketCode(java.lang.String marketCode) {
        this.marketCode = marketCode;
    }

    /**
     * <p>批发市场名称。</p>
     *
     * @return the 批发市场名称
     */
    public java.lang.String getMarketName() {
        return marketName;
    }

    /**
     * <p>批发市场名称。</p>
     *
     * @param marketName 批发市场名称。
     */
    public void setMarketName(java.lang.String marketName) {
        this.marketName = marketName;
    }

    /**
     * <p>批发市场地址。</p>
     *
     * @return the 批发市场地址
     */
    public java.lang.String getMarketAddr() {
        return marketAddr;
    }

    /**
     * <p>批发市场地址。</p>
     *
     * @param marketAddr 批发市场地址。
     */
    public void setMarketAddr(java.lang.String marketAddr) {
        this.marketAddr = marketAddr;
    }

    /**
     * <p>批发市场级别。</p>
     *
     * @return the 批发市场级别
     */
    public java.lang.String getMarketLevel() {
        return marketLevel;
    }

    /**
     * <p>批发市场级别。</p>
     *
     * @param marketLevel 批发市场级别。
     */
    public void setMarketLevel(java.lang.String marketLevel) {
        this.marketLevel = marketLevel;
    }

    /**
     * <p>批发市场级别名称。</p>
     *
     * @return the 批发市场级别名称
     */
    public java.lang.String getMarketLevelName() {
        return marketLevelName;
    }

    /**
     * <p>批发市场级别名称。</p>
     *
     * @param marketLevelName 批发市场级别名称。
     */
    public void setMarketLevelName(java.lang.String marketLevelName) {
        this.marketLevelName = marketLevelName;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @return the 物流区编码
     */
    public java.lang.String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @param lgcsAreaCode 物流区编码。
     */
    public void setLgcsAreaCode(java.lang.String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    /**
     * <p>城市（地区）编码。</p>
     *
     * @return the 城市（地区）编码
     */
    public java.lang.String getCityCode() {
        return cityCode;
    }

    /**
     * <p>城市（地区）编码。</p>
     *
     * @param cityCode 城市（地区）编码。
     */
    public void setCityCode(java.lang.String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * <p>区（县）编码。</p>
     *
     * @return the 区（县）编码
     */
    public java.lang.String getDistrictCode() {
        return districtCode;
    }

    /**
     * <p>区（县）编码。</p>
     *
     * @param districtCode 区（县）编码。
     */
    public void setDistrictCode(java.lang.String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * <p>批发市场地区顺序码。</p>
     *
     * @return the 批发市场地区顺序码。
     */
    public Integer getCityMarketSeq() { return cityMarketSeq; }

    /**
     * <p>批发市场地区顺序码。</p>
     *
     * @param cityMarketSeq 批发市场地区顺序码。
     */
    public void setCityMarketSeq(java.lang.Integer cityMarketSeq) { this.cityMarketSeq = cityMarketSeq; }
}
