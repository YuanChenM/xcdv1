package com.msk.so.bean;

import com.msk.core.bean.BaseBean;

/**
 * 分销正常库存
 */
public class SO151201Bean extends BaseBean {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    //库存ID
    private String stockId;

    //物流区编码
    private String lgcsCode;

    //物流区名称
    private String lgcsName;

    //仓库编号
    private String warehouseCode;

    //仓库名称
    private String warehouseName;

    //供货平台
    private String supplyPlayFrom;

    //卖家编码
    private String slCode;

    //卖家名称
    private String slName;

    //供应商编码
    private String supplierCode;

    //供应商名称
    private String supplierName;

    //产品编码
    private String pdCode;

    //产品名称
    private String pdName;

    //库存数量
    private String stockQty;

    //显示用卖家编码
    private String slCodeDis;

    public String getSlCodeDis() {
        return slCodeDis;
    }

    public void setSlCodeDis(String slCodeDis) {
        this.slCodeDis = slCodeDis;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getLgcsCode() {
        return lgcsCode;
    }

    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    public String getLgcsName() {
        return lgcsName;
    }

    public void setLgcsName(String lgcsName) {
        this.lgcsName = lgcsName;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getSupplyPlayFrom() {
        return supplyPlayFrom;
    }

    public void setSupplyPlayFrom(String supplyPlayFrom) {
        this.supplyPlayFrom = supplyPlayFrom;
    }

    public String getSlCode() {
        return slCode;
    }

    public void setSlCode(String slCode) {
        this.slCode = slCode;
    }

    public String getSlName() {
        return slName;
    }

    public void setSlName(String slName) {
        this.slName = slName;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getStockQty() {
        return stockQty;
    }

    public void setStockQty(String stockQty) {
        this.stockQty = stockQty;
    }
}
