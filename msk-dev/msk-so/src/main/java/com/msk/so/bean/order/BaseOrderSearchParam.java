package com.msk.so.bean.order;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsPageParam;

import java.util.List;

/**
 * *BaseOrderSearchParam
 * *@author jiang_nan
 * *@version 1.0
 **/
public class BaseOrderSearchParam extends RsPageParam {
    /**买家ID*/
    private String buyersId;
    /**买家Code*/
    private String buyersCode;

    /**卖家编码*/
    private String sellerCode;

    /**订单查询类型,页面不需要传入，只有买手的时候才会用到*/
    private String searchType;

    /**订单明细*/
    private List<OrderDetailSearchParam> orders;

    /**直销员*/
    private String sellers;

    /** 系统编码 */
    private String siteCode;

    private String orderTaker;

    private String orderSource;

    private String orderCode;

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getOrderTaker() {
        return orderTaker;
    }

    public void setOrderTaker(String orderTaker) {
        this.orderTaker = orderTaker;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getSellers() {
        return sellers;
    }

    public void setSellers(String sellers) {
        this.sellers = sellers;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getBuyersId() {
        return buyersId;
    }

    public void setBuyersId(String buyersId) {
        this.buyersId = buyersId;
    }

    public String getBuyersCode() {
        return buyersCode;
    }

    public void setBuyersCode(String buyersCode) {
        this.buyersCode = buyersCode;
    }

    public List<OrderDetailSearchParam> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDetailSearchParam> orders) {
        this.orders = orders;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}
