package com.msk.so.bean.order;

import java.util.List;

/**
 * 订单部分收货或者部分发货需要的接口参数
 * @author jiang_nan
 * @version 1.0
 **/
public class OrderPartOperationParam extends BaseOrderStatusParam{
    /**部分发货或者部分收货对应的产品信息*/
    private List<BaseOrderDetailParam> productList;

    public List<BaseOrderDetailParam> getProductList() {
        return productList;
    }

    public void setProductList(List<BaseOrderDetailParam> productList) {
        this.productList = productList;
    }
}
