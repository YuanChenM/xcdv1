package com.msk.so.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * zhang_qaing1 库存调整接口 入参  本次收货产品信息
 */
public class ISO151806ProductRsParam implements Serializable {
    private String inboundBatch;//采购入库批次

    private String supplierCode;//供应商编码，对应 COMPANY

    private String skuCode;//调整产品的SKU编码

    private String unit;//产品单位

    private BigDecimal adjustQty;//库存调整数值

    private String fromInventoryStatus;//出仓仓库的库存类型，减少库存的仓库，AVAILABLE 表示良品仓

    private String toInventoryStatus;//入仓仓库的库存类型，增加库存的仓库，AVAILABLE 表示良品仓


    public String getInboundBatch() {
        return inboundBatch;
    }

    public void setInboundBatch(String inboundBatch) {
        this.inboundBatch = inboundBatch;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getAdjustQty() {
        return adjustQty;
    }

    public void setAdjustQty(BigDecimal adjustQty) {
        this.adjustQty = adjustQty;
    }

    public String getFromInventoryStatus() {
        return fromInventoryStatus;
    }

    public void setFromInventoryStatus(String fromInventoryStatus) {
        this.fromInventoryStatus = fromInventoryStatus;
    }

    public String getToInventoryStatus() {
        return toInventoryStatus;
    }

    public void setToInventoryStatus(String toInventoryStatus) {
        this.toInventoryStatus = toInventoryStatus;
    }
}
