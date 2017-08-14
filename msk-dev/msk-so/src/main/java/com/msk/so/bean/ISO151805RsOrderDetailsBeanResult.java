package com.msk.so.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wang_jianzhou on 2016/12/6.
 */
public class ISO151805RsOrderDetailsBeanResult implements Serializable {

    private Long detailId;

    private String proDate;

    private String pdCode;

    private String pdName;

    private String skuCode;

    private BigDecimal orderQty;


    private List<ISO151805RsOrderPricesBeanResult> priceList;

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

    public List<ISO151805RsOrderPricesBeanResult> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<ISO151805RsOrderPricesBeanResult> priceList) {
        this.priceList = priceList;
    }
}
