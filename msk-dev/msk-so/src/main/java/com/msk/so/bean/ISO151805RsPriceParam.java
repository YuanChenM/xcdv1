package com.msk.so.bean;

import com.msk.common.bean.param.BaseParam;
import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * Created by liutao on 2016/10/18.
 */
public class ISO151805RsPriceParam extends BaseEntity {
    private String pricePeriod;

    private List<ISO151805RsPriceProductParam> productList;

    public String getPricePeriod() {
        return pricePeriod;
    }

    public void setPricePeriod(String pricePeriod) {
        this.pricePeriod = pricePeriod;
    }

    public List<ISO151805RsPriceProductParam> getProductList() {
        return productList;
    }

    public void setProductList(List<ISO151805RsPriceProductParam> productList) {
        this.productList = productList;
    }
}
