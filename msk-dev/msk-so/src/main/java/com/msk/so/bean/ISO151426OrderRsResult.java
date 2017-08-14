package com.msk.so.bean;

import com.msk.core.bean.BaseBean;
import com.msk.core.entity.BaseEntity;
import com.msk.core.entity.SoOrder;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by liu_tao2 on 2016/4/19.
 */
public class ISO151426OrderRsResult extends BaseBean {

    /**
     * 下单时间
     */
    private String orderDate;

    /**
     * 订单号
     */
    private Long orderId;

    /**
     * 实际付款
     */
    private BigDecimal realPayment;

    /**
     * 交易状态
     */
    private Integer orderStatus;

    /**
     * 订单编码
     */
    private String orderCode;

    /**
     * 产品信息
     */
    private List<ISO151426PruductRsResult> products;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * 子订单产品信息
     */
    private List<ISO151426PruductRsResult> childProducts;

    public List<ISO151426PruductRsResult> getChildProducts() {
        return childProducts;
    }

    public void setChildProducts(List<ISO151426PruductRsResult> childProducts) {
        this.childProducts = childProducts;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getRealPayment() {
        return realPayment;
    }

    public void setRealPayment(BigDecimal realPayment) {
        this.realPayment = realPayment;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<ISO151426PruductRsResult> getProducts() {
        return products;
    }

    public void setProducts(List<ISO151426PruductRsResult> products) {
        this.products = products;
    }
}
