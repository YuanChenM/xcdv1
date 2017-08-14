package com.msk.so.bean.order;

import com.msk.core.entity.SoOrder;

import java.util.List;

/**
 * BaseOrderParam
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class BaseOrderParam extends SoOrder{
    /**订单收货人要求*/
    private BaseReceiverInfo receiverInfo;
    /**订单配送要求*/
    private BaseDeliveryReq deliveryReq;
    /**订单发票要求*/
    private BaseInvoiceReq invoiceReq;
    /**订单产品信息*/
    private List<BaseOrderDetailParam> products;

    /**
     * Getter method for property <tt>receiverInfo</tt>.
     *
     * @return property value of receiverInfo
     */
    public BaseReceiverInfo getReceiverInfo() {
        return receiverInfo;
    }

    /**
     * Setter method for property <tt>receiverInfo</tt>.
     *
     * @param receiverInfo value to be assigned to property receiverInfo
     */
    public void setReceiverInfo(BaseReceiverInfo receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    /**
     * Getter method for property <tt>deliveryReq</tt>.
     *
     * @return property value of deliveryReq
     */
    public BaseDeliveryReq getDeliveryReq() {
        return deliveryReq;
    }

    /**
     * Setter method for property <tt>deliveryReq</tt>.
     *
     * @param deliveryReq value to be assigned to property deliveryReq
     */
    public void setDeliveryReq(BaseDeliveryReq deliveryReq) {
        this.deliveryReq = deliveryReq;
    }

    /**
     * Getter method for property <tt>invoiceReq</tt>.
     *
     * @return property value of invoiceReq
     */
    public BaseInvoiceReq getInvoiceReq() {
        return invoiceReq;
    }

    public void setInvoiceReq(BaseInvoiceReq invoiceReq) {
        this.invoiceReq = invoiceReq;
    }

    public List<BaseOrderDetailParam> getProducts() {
        return products;
    }

    public void setProducts(List<BaseOrderDetailParam> products) {
        this.products = products;
    }
}
