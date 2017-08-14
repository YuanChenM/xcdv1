/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表pd_orderlevel对应的PdOrderlevel�?</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class PdOrderlevel extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** WAY_CODE */
    private String wayCode;
    /** WAY_NAME */
    private String wayName;
    /** 订单等级编码 */
    private String orderlevelCode;
    /** 订单等级名称 */
    private String orderlevelName;
    /** 报价平衡系数 */
    private java.math.BigDecimal pricePercent;
    /** 箱数范围 */
    private String boxCnt;
    /** 箱数下限 */
    private Integer boxCntmin;
    /** 箱数上限 */
    private Integer boxCntmax;
    /**
     * <p>默认构�?�函数�??</p>
     */
    public PdOrderlevel() {

    }

    /**
     * <p>WAY_CODE�?</p>
     *
     * @return the WAY_CODE
     */
    public String getWayCode() {
        return wayCode;
    }

    /**
     * <p>WAY_CODE�?</p>
     *
     * @param wayCode WAY_CODE�?
     */
    public void setWayCode(String wayCode) {
        this.wayCode = wayCode;
    }

    /**
     * <p>WAY_NAME�?</p>
     *
     * @return the WAY_NAME
     */
    public String getWayName() {
        return wayName;
    }

    /**
     * <p>WAY_NAME�?</p>
     *
     * @param wayName WAY_NAME�?
     */
    public void setWayName(String wayName) {
        this.wayName = wayName;
    }

    /**
     * <p>订单等级编码�?</p>
     *
     * @return the 订单等级编码
     */
    public String getOrderlevelCode() {
        return orderlevelCode;
    }

    /**
     * <p>订单等级编码�?</p>
     *
     * @param orderlevelCode 订单等级编码�?
     */
    public void setOrderlevelCode(String orderlevelCode) {
        this.orderlevelCode = orderlevelCode;
    }

    /**
     * <p>订单等级名称�?</p>
     *
     * @return the 订单等级名称
     */
    public String getOrderlevelName() {
        return orderlevelName;
    }

    /**
     * <p>订单等级名称�?</p>
     *
     * @param orderlevelName 订单等级名称�?
     */
    public void setOrderlevelName(String orderlevelName) {
        this.orderlevelName = orderlevelName;
    }

    /**
     * <p>报价平衡系数�?</p>
     *
     * @return the 报价平衡系数
     */
    public java.math.BigDecimal getPricePercent() {
        return pricePercent;
    }

    /**
     * <p>报价平衡系数�?</p>
     *
     * @param pricePercent 报价平衡系数�?
     */
    public void setPricePercent(java.math.BigDecimal pricePercent) {
        this.pricePercent = pricePercent;
    }

    /**
     * <p>箱数范围�?</p>
     *
     * @return the 箱数范围
     */
    public String getBoxCnt() {
        return boxCnt;
    }

    /**
     * <p>箱数范围�?</p>
     *
     * @param boxCnt 箱数范围�?
     */
    public void setBoxCnt(String boxCnt) {
        this.boxCnt = boxCnt;
    }

    /**
     * <p>箱数下限�?</p>
     *
     * @return the 箱数下限
     */
    public Integer getBoxCntmin() {
        return boxCntmin;
    }

    /**
     * <p>箱数下限�?</p>
     *
     * @param boxCntmin 箱数下限�?
     */
    public void setBoxCntmin(Integer boxCntmin) {
        this.boxCntmin = boxCntmin;
    }

    /**
     * <p>箱数上限�?</p>
     *
     * @return the 箱数上限
     */
    public Integer getBoxCntmax() {
        return boxCntmax;
    }

    /**
     * <p>箱数上限�?</p>
     *
     * @param boxCntmax 箱数上限�?
     */
    public void setBoxCntmax(Integer boxCntmax) {
        this.boxCntmax = boxCntmax;
    }

}
