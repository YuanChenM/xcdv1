package com.msk.so.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * Created by wang_jianzhou on 2016/4/18.
 */
public class ISO151424RsResult extends RsPageResult {

  private List<ISO151424ProductResult> products;

    public List<ISO151424ProductResult> getProducts() {
        return products;
    }

    public void setProducts(List<ISO151424ProductResult> products) {
        this.products = products;
    }
}
