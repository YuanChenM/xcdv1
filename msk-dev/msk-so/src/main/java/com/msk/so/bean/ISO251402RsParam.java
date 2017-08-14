package com.msk.so.bean;

import java.util.List;

import com.msk.core.entity.SoCpInvoice;
import com.msk.core.entity.SoOrder;
import com.msk.core.entity.SoOrderDetail;
import com.msk.core.entity.SoOrderReceiveDemand;

/**
 * DistriButionOrder.
 * 标准分销订单
 * @author pxg
 */
public class ISO251402RsParam extends SoOrder{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 订单买家信息*/
    private SoOrderReceiveDemand receiverInfo;
    /** 订单配送信息*/
    private DeliveryReqParam deliveryReq;
    /** 订单明细*/
    private SoOrderDetail soOrderDetail;

    /**
     * 获得buyersName
     */

    public String getBuyersName() {
        return buyersName;
    }

    /**
     * 设置buyersName
     */
    public void setBuyersName(String buyersName) {
        this.buyersName = buyersName;
    }

    /** 订单发票*/
    private SoCpInvoice invoiceReq;
    /** 产品列表*/
    private List<SoOrderDetail> products;
    /** 买家名称 */
    private java.lang.String buyersName;
    /**
     * Get the soOrderDetail.
     *
     * @return soOrderDetail
     *
     * @author Administrator
     */
    public SoOrderDetail getSoOrderDetail() {
        return this.soOrderDetail;
    }

    /**
     * 获得receiverInfo
     */
    public SoOrderReceiveDemand getReceiverInfo() {
        return receiverInfo;
    }

    /**
     * 设置receiverInfo
     */
    public void setReceiverInfo(SoOrderReceiveDemand receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    /**
     * 获得deliveryReq
     */
    public DeliveryReqParam getDeliveryReq() {
        return deliveryReq;
    }

    /**
     * 设置deliveryReq
     */
    public void setDeliveryReq(DeliveryReqParam deliveryReq) {
        this.deliveryReq = deliveryReq;
    }

    /**
     * Set the soOrderDetail.
     *
     * @param soOrderDetail soOrderDetail
     *
     * @author Administrator

     */
    public void setSoOrderDetail(SoOrderDetail soOrderDetail) {
        this.soOrderDetail = soOrderDetail;
    }
    /**
     * Get the invoiceReq.
     *
     * @return invoiceReq
     *
     * @author Administrator
     */
    public SoCpInvoice getInvoiceReq() {
        return this.invoiceReq;
    }
    /**
     * Set the invoiceReq.
     *
     * @param invoiceReq invoiceReq
     *
     * @author Administrator
     */
    public void setInvoiceReq(SoCpInvoice invoiceReq) {
        this.invoiceReq = invoiceReq;
    }
    /**
     * Get the products.
     *
     * @return products
     *
     * @author Administrator
     */
    public List<SoOrderDetail> getProducts() {
        return this.products;
    }
    /**
     * Set the products.
     *
     * @param products products
     *
     * @author Administrator
     */
    public void setProducts(List<SoOrderDetail> products) {
        this.products = products;
    }
}
