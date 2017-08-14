/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_stock_record对应的SoStockRecord。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoStockRecord extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 库存编号 */
    private java.lang.Long stockId;
    /** 业务编码 */
    private java.lang.String flowId;
    /** 产品编码 */
    private java.lang.String pdCode;
    /** 供应商编号 */
    private java.lang.String supplierCode;
    /** 卖家编码 */
    private java.lang.String slCode;
    /** 变更数量 */
    private java.math.BigDecimal qty;
    /** 变更类型 */
    private java.lang.Integer type;
    /**
     * <p>默认构造函数。</p>
     */
    public SoStockRecord() {

    }

    /**
     * <p>库存编号。</p>
     *
     * @return the 库存编号
     */
    public java.lang.Long getStockId() {
        return stockId;
    }

    /**
     * <p>库存编号。</p>
     *
     * @param stockId 库存编号。
     */
    public void setStockId(java.lang.Long stockId) {
        this.stockId = stockId;
    }

    /**
     * <p>业务编码。</p>
     *
     * @return the 业务编码
     */
    public java.lang.String getFlowId() {
        return flowId;
    }

    /**
     * <p>业务编码。</p>
     *
     * @param flowId 业务编码。
     */
    public void setFlowId(java.lang.String flowId) {
        this.flowId = flowId;
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
     * <p>供应商编号。</p>
     *
     * @return the 供应商编号
     */
    public java.lang.String getSupplierCode() {
        return supplierCode;
    }

    /**
     * <p>供应商编号。</p>
     *
     * @param supplierCode 供应商编号。
     */
    public void setSupplierCode(java.lang.String supplierCode) {
        this.supplierCode = supplierCode;
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
     * <p>变更数量。</p>
     *
     * @return the 变更数量
     */
    public java.math.BigDecimal getQty() {
        return qty;
    }

    /**
     * <p>变更数量。</p>
     *
     * @param qty 变更数量。
     */
    public void setQty(java.math.BigDecimal qty) {
        this.qty = qty;
    }

    /**
     * <p>变更类型。</p>
     *
     * @return the 变更类型
     */
    public java.lang.Integer getType() {
        return type;
    }

    /**
     * <p>变更类型。</p>
     *
     * @param type 变更类型。
     */
    public void setType(java.lang.Integer type) {
        this.type = type;
    }

}
