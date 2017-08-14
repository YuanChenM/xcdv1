package com.msk.so.bean.order;

import com.msk.core.bean.BaseParam;
import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * Created by liu_tao2 on 2016/7/12.
 */
public class OrderDetailAndSuppInfo extends BaseEntity {

    /** 产品编码 */
    private String pdCode;

    /** 产品名称 */
    private String pdName;

    /** 订单ID */
    private Long orderId;

    /** 订单编码 */
    private String orderCode;

    /** 订单明细ID */
    private Long orderDetailId;

    /** 明细下单数量 */
    private BigDecimal detailOrderQty;

    /** 明细发货数量 */
    private BigDecimal detailSendQty;

    /** 明细收货数量 */
    private BigDecimal detailReceiveQty;

    /** 明细取消数量 */
    private BigDecimal detailCancelQty;

    /** 明细退货数量 */
    private BigDecimal detailReturnQty;

    /** 明细拒收数量 */
    private BigDecimal detailRejectionQty;

    /** 明细状态 */
    private Integer detailStatus;

    /** 供货数量 */
    private BigDecimal suppOrderQty;

    /** 供应明细发货数量 */
    private BigDecimal suppSendQty;

    /** 供应明细收货数量 */
    private BigDecimal suppReceiveQty;

    /** 供应明细取消数量 */
    private BigDecimal suppCancelQty;

    /** 供货明细退货数量 */
    private BigDecimal suppReturnQty;

    /** 供货明细拒收数量 */
    private BigDecimal suppRejectionQty;

    /** 供货明细状态 */
    private Integer suppStatus;

    /** 发货单号 */
    private String shipId;

    /** 明细可发货数量 */
    private BigDecimal detailQty;

    /** 供货明细可发货数量 */
    private BigDecimal suppQty;

    /** 供货明细Id */
    private Long detailAvailabilityId;

    /** 供应商编码 */
    private String supplierCode;

    /** 订单状态 */
    private Integer orderStatus;

    /** 订单明细订单数量*/
    private BigDecimal orderQty;

    public BigDecimal getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(BigDecimal orderQty) {
        this.orderQty = orderQty;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public BigDecimal getSuppOrderQty() {
        return suppOrderQty;
    }

    public void setSuppOrderQty(BigDecimal suppOrderQty) {
        this.suppOrderQty = suppOrderQty;
    }

    public BigDecimal getDetailQty() {
        return detailQty;
    }

    public void setDetailQty(BigDecimal detailQty) {
        this.detailQty = detailQty;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public BigDecimal getDetailOrderQty() {
        return detailOrderQty;
    }

    public void setDetailOrderQty(BigDecimal detailOrderQty) {
        this.detailOrderQty = detailOrderQty;
    }

    public BigDecimal getDetailSendQty() {
        return detailSendQty;
    }

    public void setDetailSendQty(BigDecimal detailSendQty) {
        this.detailSendQty = detailSendQty;
    }

    public BigDecimal getDetailReceiveQty() {
        return detailReceiveQty;
    }

    public void setDetailReceiveQty(BigDecimal detailReceiveQty) {
        this.detailReceiveQty = detailReceiveQty;
    }

    public BigDecimal getDetailCancelQty() {
        return detailCancelQty;
    }

    public void setDetailCancelQty(BigDecimal detailCancelQty) {
        this.detailCancelQty = detailCancelQty;
    }

    public BigDecimal getDetailReturnQty() {
        return detailReturnQty;
    }

    public void setDetailReturnQty(BigDecimal detailReturnQty) {
        this.detailReturnQty = detailReturnQty;
    }

    public BigDecimal getDetailRejectionQty() {
        return detailRejectionQty;
    }

    public void setDetailRejectionQty(BigDecimal detailRejectionQty) {
        this.detailRejectionQty = detailRejectionQty;
    }

    public Integer getDetailStatus() {
        return detailStatus;
    }

    public void setDetailStatus(Integer detailStatus) {
        this.detailStatus = detailStatus;
    }

    public BigDecimal getSuppQty() {
        return suppQty;
    }

    public void setSuppQty(BigDecimal suppQty) {
        this.suppQty = suppQty;
    }

    public BigDecimal getSuppSendQty() {
        return suppSendQty;
    }

    public void setSuppSendQty(BigDecimal suppSendQty) {
        this.suppSendQty = suppSendQty;
    }

    public BigDecimal getSuppReceiveQty() {
        return suppReceiveQty;
    }

    public void setSuppReceiveQty(BigDecimal suppReceiveQty) {
        this.suppReceiveQty = suppReceiveQty;
    }

    public BigDecimal getSuppCancelQty() {
        return suppCancelQty;
    }

    public void setSuppCancelQty(BigDecimal suppCancelQty) {
        this.suppCancelQty = suppCancelQty;
    }

    public BigDecimal getSuppReturnQty() {
        return suppReturnQty;
    }

    public void setSuppReturnQty(BigDecimal suppReturnQty) {
        this.suppReturnQty = suppReturnQty;
    }

    public BigDecimal getSuppRejectionQty() {
        return suppRejectionQty;
    }

    public void setSuppRejectionQty(BigDecimal suppRejectionQty) {
        this.suppRejectionQty = suppRejectionQty;
    }

    public Integer getSuppStatus() {
        return suppStatus;
    }

    public void setSuppStatus(Integer suppStatus) {
        this.suppStatus = suppStatus;
    }

    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Long getDetailAvailabilityId() {
        return detailAvailabilityId;
    }

    public void setDetailAvailabilityId(Long detailAvailabilityId) {
        this.detailAvailabilityId = detailAvailabilityId;
    }
}
