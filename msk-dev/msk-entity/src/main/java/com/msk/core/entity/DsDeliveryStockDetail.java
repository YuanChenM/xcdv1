/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表ds_delivery_stock_detail对应的DsDeliveryStockDetail。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class DsDeliveryStockDetail extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 发货入库通知单ID */
    private java.lang.Long deliveryStockId;
    /** 产品编码 */
    private java.lang.String pdCode;
    /** 包装编码 */
    private java.lang.String normsCode;
    /** 申请发货箱数 */
    private java.math.BigDecimal applyDeliveryNum;
    /** 仓库确认可发货箱数 */
    private java.math.BigDecimal confirmDeliveryNum;
    /** 计划发货箱数 */
    private java.math.BigDecimal planDeliveryNum;
    /** 实际发货箱数 */
    private java.math.BigDecimal actualDeliveryNum;
    /** 备注 */
    private java.lang.String memo;
    /**
     * <p>默认构造函数。</p>
     */
    public DsDeliveryStockDetail() {

    }

    /**
     * <p>发货入库通知单ID。</p>
     *
     * @return the 发货入库通知单ID
     */
    public java.lang.Long getDeliveryStockId() {
        return deliveryStockId;
    }

    /**
     * <p>发货入库通知单ID。</p>
     *
     * @param deliveryStockId 发货入库通知单ID。
     */
    public void setDeliveryStockId(java.lang.Long deliveryStockId) {
        this.deliveryStockId = deliveryStockId;
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
     * <p>包装编码。</p>
     *
     * @return the 包装编码
     */
    public java.lang.String getNormsCode() {
        return normsCode;
    }

    /**
     * <p>包装编码。</p>
     *
     * @param normsCode 包装编码。
     */
    public void setNormsCode(java.lang.String normsCode) {
        this.normsCode = normsCode;
    }

    /**
     * <p>申请发货箱数。</p>
     *
     * @return the 申请发货箱数
     */
    public java.math.BigDecimal getApplyDeliveryNum() {
        return applyDeliveryNum;
    }

    /**
     * <p>申请发货箱数。</p>
     *
     * @param applyDeliveryNum 申请发货箱数。
     */
    public void setApplyDeliveryNum(java.math.BigDecimal applyDeliveryNum) {
        this.applyDeliveryNum = applyDeliveryNum;
    }

    /**
     * <p>仓库确认可发货箱数。</p>
     *
     * @return the 仓库确认可发货箱数
     */
    public java.math.BigDecimal getConfirmDeliveryNum() {
        return confirmDeliveryNum;
    }

    /**
     * <p>仓库确认可发货箱数。</p>
     *
     * @param confirmDeliveryNum 仓库确认可发货箱数。
     */
    public void setConfirmDeliveryNum(java.math.BigDecimal confirmDeliveryNum) {
        this.confirmDeliveryNum = confirmDeliveryNum;
    }

    /**
     * <p>计划发货箱数。</p>
     *
     * @return the 计划发货箱数
     */
    public java.math.BigDecimal getPlanDeliveryNum() {
        return planDeliveryNum;
    }

    /**
     * <p>计划发货箱数。</p>
     *
     * @param planDeliveryNum 计划发货箱数。
     */
    public void setPlanDeliveryNum(java.math.BigDecimal planDeliveryNum) {
        this.planDeliveryNum = planDeliveryNum;
    }

    /**
     * <p>实际发货箱数。</p>
     *
     * @return the 实际发货箱数
     */
    public java.math.BigDecimal getActualDeliveryNum() {
        return actualDeliveryNum;
    }

    /**
     * <p>实际发货箱数。</p>
     *
     * @param actualDeliveryNum 实际发货箱数。
     */
    public void setActualDeliveryNum(java.math.BigDecimal actualDeliveryNum) {
        this.actualDeliveryNum = actualDeliveryNum;
    }

    /**
     * <p>备注。</p>
     *
     * @return the 备注
     */
    public java.lang.String getMemo() {
        return memo;
    }

    /**
     * <p>备注。</p>
     *
     * @param memo 备注。
     */
    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

}
