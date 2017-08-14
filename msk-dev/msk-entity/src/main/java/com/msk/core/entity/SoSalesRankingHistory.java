/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_sales_ranking_history对应的SoSalesRankingHistory。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoSalesRankingHistory extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 物流区编号 */
    private String lgcsCode;
    /** 订单历史时间 */
    private java.util.Date historyDate;
    /** 订单等级 */
    private Integer orderLevel;
    /** 产品编码 */
    private String pdCode;
    /** 供应商编码 */
    private String suppCode;
    /** 供应商名称 */
    private String suppName;
    /** 价盘周期 */
    private String priceCycle;
    /** 销售额 */
    private java.math.BigDecimal salesAmount;
    /** 销售排行 */
    private Integer salesRanking;
    /** 分销资格 */
    private Integer distQua;
    /** 轮单次数 */
    private Integer wheelFrequency;
    /**
     * <p>默认构造函数。</p>
     */
    public SoSalesRankingHistory() {

    }

    /**
     * <p>LGCS_CODE。</p>
     *
     * @return the LGCS_CODE
     */
    public String getLgcsCode() {
        return lgcsCode;
    }

    /**
     * <p>LGCS_CODE。</p>
     *
     * @param lgcsCode LGCS_CODE。
     */
    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    /**
     * <p>HISTORY_DATE。</p>
     *
     * @return the HISTORY_DATE
     */
    public java.util.Date getHistoryDate() {
        return historyDate;
    }

    /**
     * <p>HISTORY_DATE。</p>
     *
     * @param historyDate HISTORY_DATE。
     */
    public void setHistoryDate(java.util.Date historyDate) {
        this.historyDate = historyDate;
    }

    /**
     * <p>ORDER_LEVEL。</p>
     *
     * @return the ORDER_LEVEL
     */
    public Integer getOrderLevel() {
        return orderLevel;
    }

    /**
     * <p>ORDER_LEVEL。</p>
     *
     * @param orderLevel ORDER_LEVEL。
     */
    public void setOrderLevel(Integer orderLevel) {
        this.orderLevel = orderLevel;
    }

    /**
     * <p>PD_CODE。</p>
     *
     * @return the PD_CODE
     */
    public String getPdCode() {
        return pdCode;
    }

    /**
     * <p>PD_CODE。</p>
     *
     * @param pdCode PD_CODE。
     */
    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    /**
     * <p>SUPP_CODE。</p>
     *
     * @return the SUPP_CODE
     */
    public String getSuppCode() {
        return suppCode;
    }

    /**
     * <p>SUPP_CODE。</p>
     *
     * @param suppCode SUPP_CODE。
     */
    public void setSuppCode(String suppCode) {
        this.suppCode = suppCode;
    }

    /**
     * <p>SUPP_NAME。</p>
     *
     * @return the SUPP_NAME
     */
    public String getSuppName() {
        return suppName;
    }

    /**
     * <p>SUPP_NAME。</p>
     *
     * @param suppName SUPP_NAME。
     */
    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    /**
     * <p>PRICE_CYCLE。</p>
     *
     * @return the PRICE_CYCLE
     */
    public String getPriceCycle() {
        return priceCycle;
    }

    /**
     * <p>PRICE_CYCLE。</p>
     *
     * @param priceCycle PRICE_CYCLE。
     */
    public void setPriceCycle(String priceCycle) {
        this.priceCycle = priceCycle;
    }

    /**
     * <p>SALES_AMOUNT。</p>
     *
     * @return the SALES_AMOUNT
     */
    public java.math.BigDecimal getSalesAmount() {
        return salesAmount;
    }

    /**
     * <p>SALES_AMOUNT。</p>
     *
     * @param salesAmount SALES_AMOUNT。
     */
    public void setSalesAmount(java.math.BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }

    /**
     * <p>SALES_RANKING。</p>
     *
     * @return the SALES_RANKING
     */
    public Integer getSalesRanking() {
        return salesRanking;
    }

    /**
     * <p>SALES_RANKING。</p>
     *
     * @param salesRanking SALES_RANKING。
     */
    public void setSalesRanking(Integer salesRanking) {
        this.salesRanking = salesRanking;
    }

    /**
     * <p>DIST_QUA。</p>
     *
     * @return the DIST_QUA
     */
    public Integer getDistQua() {
        return distQua;
    }

    /**
     * <p>DIST_QUA。</p>
     *
     * @param distQua DIST_QUA。
     */
    public void setDistQua(Integer distQua) {
        this.distQua = distQua;
    }

    /**
     * <p>WHEEL_FREQUENCY。</p>
     *
     * @return the WHEEL_FREQUENCY
     */
    public Integer getWheelFrequency() {
        return wheelFrequency;
    }

    /**
     * <p>WHEEL_FREQUENCY。</p>
     *
     * @param wheelFrequency WHEEL_FREQUENCY。
     */
    public void setWheelFrequency(Integer wheelFrequency) {
        this.wheelFrequency = wheelFrequency;
    }

}
