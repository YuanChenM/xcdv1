package com.msk.batch.so.bean;

import com.msk.core.entity.BaseEntity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * BSO152403Param
 * @author xu_wei
 */
@XmlRootElement(name = "LINE")
@XmlType(propOrder = {"shipDetailId","sku","inboundBatch","unit","sellerCode","districtCode","supplierCode","suppQty","pdPrice","orderSource","inventoryStatus"})
public class BSO152403DetailResult extends BaseEntity {
    /** 供货明细ID */
    private String shipDetailId;
    /** SKU */
    private String sku;
    /** inboundBatch */
    private String inboundBatch;
    /** UNIT */
    private String unit;
    /** sellerCode */
    private String sellerCode;
    /** districtCode */
    private String districtCode;
    /** SUPPLIER_CODE */
    private String supplierCode;
    /** SUPP_QTY */
    private BigDecimal suppQty;
    /** PD_PRICE */
    private BigDecimal pdPrice;
    /** orderSource */
    private String orderSource;
    /*inventoryStatus*/
    private String inventoryStatus;
    /*pdCode*/
    private String pdCode;
    @XmlElement(name = "ORDERLINE",defaultValue = "")
    public String getShipDetailId() {
        return shipDetailId;
    }

    public void setShipDetailId(String shipDetailId) {
        this.shipDetailId = shipDetailId;
    }
    @XmlElement(name = "SKU",defaultValue = "")
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
    @XmlElement(name = "INBOUNDBATCH",defaultValue = "")
    public String getInboundBatch() {
        return inboundBatch;
    }

    public void setInboundBatch(String inboundBatch) {
        this.inboundBatch = inboundBatch;
    }
    @XmlElement(name = "UOM",defaultValue = "")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    @XmlElement(name = "CONSIGNEE",defaultValue = "")
    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }
    @XmlElement(name = "AREA",defaultValue = "")
    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }
    @XmlElement(name = "COMPANY",defaultValue = "")
    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }
    @XmlElement(name = "QTYORIGINAL",defaultValue = "")
    public BigDecimal getSuppQty() {
        return suppQty;
    }

    public void setSuppQty(BigDecimal suppQty) {
        this.suppQty = suppQty;
    }
    @XmlElement(name = "INPUTQTY",defaultValue = "")
    public BigDecimal getPdPrice() {
        return pdPrice;
    }

    public void setPdPrice(BigDecimal pdPrice) {
        this.pdPrice = pdPrice;
    }
    @XmlElement(name = "ATTRIBUTES",defaultValue = "")
    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }
    @XmlElement(name = "INVENTORYSTATUS",defaultValue = "")
    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }
    @XmlTransient
    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }
}
