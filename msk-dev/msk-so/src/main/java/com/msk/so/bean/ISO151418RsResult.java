package com.msk.so.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * Created by liutao on 2016/10/11.
 */
public class ISO151418RsResult extends RsPageResult {
    private List<ISO151418ProductResult> products;

    public List<ISO151418ProductResult> getProducts() {
        return products;
    }

    public void setProducts(List<ISO151418ProductResult> products) {
        this.products = products;
    }
}
