package com.msk.ds.bean;

import com.msk.core.bean.RsPageParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * xu_wei on 2016/03/24.
 */
public class ISC1892I1Param extends RsPageParam {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 发货入库管理ID
     */
    private Long deliveryStockId;
    /**
     * 备注
     */
    private String stockMemo;
    /**
     * 实际入库时间
     */
    private String inputDate;

    /**部分发货或者部分收货对应的产品信息*/
    private List<ISC1892I1RsParam> productList;

    public Long getDeliveryStockId() {
        return deliveryStockId;
    }

    public void setDeliveryStockId(Long deliveryStockId) {
        this.deliveryStockId = deliveryStockId;
    }

    public String getStockMemo() {
        return stockMemo;
    }

    public void setStockMemo(String stockMemo) {
        this.stockMemo = stockMemo;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public List<ISC1892I1RsParam> getProductList() {
        return productList;
    }

    public void setProductList(List<ISC1892I1RsParam> productList) {
        this.productList = productList;
    }

}
