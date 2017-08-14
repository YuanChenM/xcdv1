package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by liutao on 2016/10/18.
 */
public class ISO151805RsOrderDetailsResult extends BaseEntity {
    private Long detailId;

    private String proDate;

    private String pdCode;

    private String pdName;

    private String skuCode;

    private BigDecimal orderQty;

    private String districtCode;

    private String priceCycle;

    private Long orderId;

    private List<ISO151805RsOrderPricesResult> priceList;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getPriceCycle() {
        return priceCycle;
    }

    public void setPriceCycle(String priceCycle) {
        this.priceCycle = priceCycle;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getProDate() {
        return proDate;
    }

    public void setProDate(String proDate) {
        this.proDate = proDate;
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

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public BigDecimal getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(BigDecimal orderQty) {
        this.orderQty = orderQty;
    }

    public List<ISO151805RsOrderPricesResult> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<ISO151805RsOrderPricesResult> priceList) {
        this.priceList = priceList;
    }
}
