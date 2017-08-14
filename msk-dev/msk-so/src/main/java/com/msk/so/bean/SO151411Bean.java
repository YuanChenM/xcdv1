package com.msk.so.bean;

import com.msk.core.entity.SoOrderDetailAvailability;

import java.math.BigDecimal;

/**
 * 申请退货
 * SO151411Bean
 *
 * @author sunjiaju
 * @version 1.0
 */
public class SO151411Bean extends SoOrderDetailAvailability {
    private BigDecimal pdPrice;

    private String statusName;

    private String lgcsCode;

    private String sellerCode;

    private Integer orderType;

    private BigDecimal returnedQty;

    private String supplierCodeShow;

    public BigDecimal getPdPrice() {
        return pdPrice;
    }

    public void setPdPrice(BigDecimal pdPrice) {
        this.pdPrice = pdPrice;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getLgcsCode() {
        return lgcsCode;
    }

    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getReturnedQty() {
        return returnedQty;
    }

    public void setReturnedQty(BigDecimal returnedQty) {
        this.returnedQty = returnedQty;
    }

    public String getSupplierCodeShow() {
        return supplierCodeShow;
    }

    public void setSupplierCodeShow(String supplierCodeShow) {
        this.supplierCodeShow = supplierCodeShow;
    }
}
