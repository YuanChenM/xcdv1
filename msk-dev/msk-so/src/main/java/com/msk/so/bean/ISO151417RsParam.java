package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

import java.util.List;

/**
 * Created by liutao on 2016/10/11.
 */
public class ISO151417RsParam extends BaseParam {

    private String userId;

    private String evaluateDate;

    private Long orderId;

    private List<ISO151417RsProductParam> products;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEvaluateDate() {
        return evaluateDate;
    }

    public void setEvaluateDate(String evaluateDate) {
        this.evaluateDate = evaluateDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<ISO151417RsProductParam> getProducts() {
        return products;
    }

    public void setProducts(List<ISO151417RsProductParam> products) {
        this.products = products;
    }
}
