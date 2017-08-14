package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

import java.util.List;

/**
 * 创建退货单Param
 * 
 * @author sjj
 */
public class ISO151408RsShipListParam extends BaseParam{
    /** 发货单号ID */
    private Long shipId;
    /** 退货产品信息 */
    private List<ISO151408RsProductListParam> productList;


    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }


    public List<ISO151408RsProductListParam> getProductList() {
        return productList;
    }

    public void setProductList(List<ISO151408RsProductListParam> productList) {
        this.productList = productList;
    }
}
