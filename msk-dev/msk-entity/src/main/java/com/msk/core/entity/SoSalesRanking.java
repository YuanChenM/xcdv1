/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_sales_ranking对应的SoSalesRanking。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoSalesRanking extends BaseEntity{
    /**
     * 
     */
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
    /**
     * <p>默认构造函数。</p>
     */
    public SoSalesRanking() {

    }

    /**
     * <p>物流区编号。</p>
     *
     * @return the 物流区编号
     */
    public java.lang.String getLgcsCode() {
        return lgcsCode;
    }

    /**
     * <p>物流区编号。</p>
     *
     * @param lgcsCode 物流区编号。
     */
    public void setLgcsCode(java.lang.String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    /**
     * <p>订单等级。</p>
     *
     * @return the 订单等级
     */
    public java.lang.Integer getOrderLevel() {
        return orderLevel;
    }

    /**
     * <p>订单等级。</p>
     *
     * @param orderLevel 订单等级。
     */
    public void setOrderLevel(java.lang.Integer orderLevel) {
        this.orderLevel = orderLevel;
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
     * <p>供应商编码。</p>
     *
     * @return the 供应商编码
     */
    public java.lang.String getSuppCode() {
        return suppCode;
    }

    /**
     * <p>供应商编码。</p>
     *
     * @param suppCode 供应商编码。
     */
    public void setSuppCode(java.lang.String suppCode) {
        this.suppCode = suppCode;
    }

    /**
     * <p>供应商名称。</p>
     *
     * @return the 供应商名称
     */
    public java.lang.String getSuppName() {
        return suppName;
    }

    /**
     * <p>供应商名称。</p>
     *
     * @param suppName 供应商名称。
     */
    public void setSuppName(java.lang.String suppName) {
        this.suppName = suppName;
    }

    /**
     * <p>价盘周期。</p>
     *
     * @return the 价盘周期
     */
    public java.lang.String getPriceCycle() {
        return priceCycle;
    }

    /**
     * <p>价盘周期。</p>
     *
     * @param priceCycle 价盘周期。
     */
    public void setPriceCycle(java.lang.String priceCycle) {
        this.priceCycle = priceCycle;
    }

    /**
     * <p>销售额。</p>
     *
     * @return the 销售额
     */
    public java.math.BigDecimal getSalesAmount() {
        return salesAmount;
    }

    /**
     * <p>销售额。</p>
     *
     * @param salesAmount 销售额。
     */
    public void setSalesAmount(java.math.BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }

    /**
     * <p>销售排行。</p>
     *
     * @return the 销售排行
     */
    public java.lang.Integer getSalesRanking() {
        return salesRanking;
    }

    /**
     * <p>销售排行。</p>
     *
     * @param salesRanking 销售排行。
     */
    public void setSalesRanking(java.lang.Integer salesRanking) {
        this.salesRanking = salesRanking;
    }

    /**
     * <p>分销资格。</p>
     *
     * @return the 分销资格
     */
    public java.lang.Integer getDistQua() {
        return distQua;
    }

    /**
     * <p>分销资格。</p>
     *
     * @param distQua 分销资格。
     */
    public void setDistQua(java.lang.Integer distQua) {
        this.distQua = distQua;
    }

    /**
     * <p>轮单次数。</p>
     *
     * @return the 轮单次数
     */
    public java.lang.Integer getWheelFrequency() {
        return wheelFrequency;
    }

    /**
     * <p>轮单次数。</p>
     *
     * @param wheelFrequency 轮单次数。
     */
    public void setWheelFrequency(java.lang.Integer wheelFrequency) {
        this.wheelFrequency = wheelFrequency;
    }

}
