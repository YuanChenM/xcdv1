package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * Created by liutao on 2016/10/18.
 */
public class ISO151805RsPriceResult extends BaseEntity {
    private List<ISO151805RsPriceProductResult> productList;

    public List<ISO151805RsPriceProductResult> getProductList() {
        return productList;
    }

    public void setProductList(List<ISO151805RsPriceProductResult> productList) {
        this.productList = productList;
    }
}
