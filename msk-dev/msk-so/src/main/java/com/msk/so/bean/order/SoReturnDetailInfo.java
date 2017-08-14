package com.msk.so.bean.order;

import com.msk.core.entity.SoReturnDetail;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by liu_tao2 on 2016/7/19.
 */
public class SoReturnDetailInfo extends SoReturnDetail {

    /** 迟收数量 */
    private BigDecimal laterQty;

    /** 明细ID */
    private Long orderDetailId;

    /** 产品单价 */
    private BigDecimal pdPrice;

    /** 迟收金钱 */
    private BigDecimal laterAmount;

    /** 明细状态 */
    private Integer orderDetailStatus;

    /** 供货明细状态 */
    private Integer suppStatus;

    /** 明细新状态 */
    private Integer orderDetailStatusNew;

    /** 供货明细新状态 */
    private Integer suppStatusNew;

    /** 迟收期望配送时间 */
    private Date receiptDate;

    /** 供货明细Id */
    private Long suppId;

    /** 订单ID */
    private Long orderId;

    /** 订单编码 */
    private String orderCode;

    /** 新的明细Id */
    private Long orderDetailIdNew;

    /** 1:正常订单 2:非正常订单 3:促销订单 */
    private Integer orderDetailType;

    /** 1:标准订单,2:大额订单,3:大宗订单,4:超级大宗订单 */
    private Integer orderDetailLevel;

    /** 1:同意 */
    private String agreeJoint;

    /** 1:是 */
    private String isJoint;

    /** 买家确认拼货，1:是 */
    private Integer buyersConfirmShipments;

    /** 价盘周期 */
    private String priceCycle;

    /** 新的供货明细Id */
    private Long suppIdNew;

    /** 明细收货数量 */
    private BigDecimal detailReceiveQty;

    /** 明细拒收数量 */
    private BigDecimal detailRejectionQty;

    /** 明细取消数量 */
    private BigDecimal detailCancelQty;

    /** 明细发货数量 */
    private BigDecimal detailSendQty;

    /** 明细退货数量 */
    private BigDecimal detailReturnQty;

    /** 供货明细收货数量 */
    private BigDecimal suppReceiveQty;

    /** 供货明细拒收数量 */
    private BigDecimal suppRejectionQty;

    /** 供货明细取消数量 */
    private BigDecimal suppCancelQty;

    /** 供货明细发货数量 */
    private BigDecimal suppSendQty;

    /** 供货明细可迟收数量 */
    private BigDecimal suppLaterQty;

    /** 供货明细退货数量 */
    private BigDecimal suppReturnQty;

    /** 明细可迟收数量 */
    private BigDecimal detailLaterQty;

    /** 供货明细可拒收数量 */
    private BigDecimal suppRejectQty;

    /** 明细可拒收数量 */
    private BigDecimal detailRejectQty;

    /** 现场退货数量 */
    private BigDecimal rejectQty;

    private BigDecimal orderQty;

    private BigDecimal suppQty;

    public BigDecimal getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(BigDecimal orderQty) {
        this.orderQty = orderQty;
    }

    public BigDecimal getSuppQty() {
        return suppQty;
    }

    public void setSuppQty(BigDecimal suppQty) {
        this.suppQty = suppQty;
    }

    public BigDecimal getRejectQty() {
        return rejectQty;
    }

    public void setRejectQty(BigDecimal rejectQty) {
        this.rejectQty = rejectQty;
    }

    public BigDecimal getSuppRejectQty() {
        return suppRejectQty;
    }

    public void setSuppRejectQty(BigDecimal suppRejectQty) {
        this.suppRejectQty = suppRejectQty;
    }

    public BigDecimal getDetailRejectQty() {
        return detailRejectQty;
    }

    public void setDetailRejectQty(BigDecimal detailRejectQty) {
        this.detailRejectQty = detailRejectQty;
    }

    public Integer getOrderDetailStatusNew() {
        return orderDetailStatusNew;
    }

    public void setOrderDetailStatusNew(Integer orderDetailStatusNew) {
        this.orderDetailStatusNew = orderDetailStatusNew;
    }

    public Integer getSuppStatusNew() {
        return suppStatusNew;
    }

    public void setSuppStatusNew(Integer suppStatusNew) {
        this.suppStatusNew = suppStatusNew;
    }

    public BigDecimal getDetailReceiveQty() {
        return detailReceiveQty;
    }

    public void setDetailReceiveQty(BigDecimal detailReceiveQty) {
        this.detailReceiveQty = detailReceiveQty;
    }

    public BigDecimal getDetailRejectionQty() {
        return detailRejectionQty;
    }

    public void setDetailRejectionQty(BigDecimal detailRejectionQty) {
        this.detailRejectionQty = detailRejectionQty;
    }

    public BigDecimal getDetailCancelQty() {
        return detailCancelQty;
    }

    public void setDetailCancelQty(BigDecimal detailCancelQty) {
        this.detailCancelQty = detailCancelQty;
    }

    public BigDecimal getDetailSendQty() {
        return detailSendQty;
    }

    public void setDetailSendQty(BigDecimal detailSendQty) {
        this.detailSendQty = detailSendQty;
    }

    public BigDecimal getDetailReturnQty() {
        return detailReturnQty;
    }

    public void setDetailReturnQty(BigDecimal detailReturnQty) {
        this.detailReturnQty = detailReturnQty;
    }

    public BigDecimal getSuppReceiveQty() {
        return suppReceiveQty;
    }

    public void setSuppReceiveQty(BigDecimal suppReceiveQty) {
        this.suppReceiveQty = suppReceiveQty;
    }

    public BigDecimal getSuppRejectionQty() {
        return suppRejectionQty;
    }

    public void setSuppRejectionQty(BigDecimal suppRejectionQty) {
        this.suppRejectionQty = suppRejectionQty;
    }

    public BigDecimal getSuppCancelQty() {
        return suppCancelQty;
    }

    public void setSuppCancelQty(BigDecimal suppCancelQty) {
        this.suppCancelQty = suppCancelQty;
    }

    public BigDecimal getSuppSendQty() {
        return suppSendQty;
    }

    public void setSuppSendQty(BigDecimal suppSendQty) {
        this.suppSendQty = suppSendQty;
    }

    public BigDecimal getSuppLaterQty() {
        return suppLaterQty;
    }

    public void setSuppLaterQty(BigDecimal suppLaterQty) {
        this.suppLaterQty = suppLaterQty;
    }

    public BigDecimal getSuppReturnQty() {
        return suppReturnQty;
    }

    public void setSuppReturnQty(BigDecimal suppReturnQty) {
        this.suppReturnQty = suppReturnQty;
    }

    public BigDecimal getDetailLaterQty() {
        return detailLaterQty;
    }

    public void setDetailLaterQty(BigDecimal detailLaterQty) {
        this.detailLaterQty = detailLaterQty;
    }

    public Long getSuppIdNew() {
        return suppIdNew;
    }

    public void setSuppIdNew(Long suppIdNew) {
        this.suppIdNew = suppIdNew;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Long getOrderDetailIdNew() {
        return orderDetailIdNew;
    }

    public void setOrderDetailIdNew(Long orderDetailIdNew) {
        this.orderDetailIdNew = orderDetailIdNew;
    }

    public Integer getOrderDetailType() {
        return orderDetailType;
    }

    public void setOrderDetailType(Integer orderDetailType) {
        this.orderDetailType = orderDetailType;
    }

    public Integer getOrderDetailLevel() {
        return orderDetailLevel;
    }

    public void setOrderDetailLevel(Integer orderDetailLevel) {
        this.orderDetailLevel = orderDetailLevel;
    }

    public String getAgreeJoint() {
        return agreeJoint;
    }

    public void setAgreeJoint(String agreeJoint) {
        this.agreeJoint = agreeJoint;
    }

    public String getIsJoint() {
        return isJoint;
    }

    public void setIsJoint(String isJoint) {
        this.isJoint = isJoint;
    }

    public Integer getBuyersConfirmShipments() {
        return buyersConfirmShipments;
    }

    public void setBuyersConfirmShipments(Integer buyersConfirmShipments) {
        this.buyersConfirmShipments = buyersConfirmShipments;
    }

    public String getPriceCycle() {
        return priceCycle;
    }

    public void setPriceCycle(String priceCycle) {
        this.priceCycle = priceCycle;
    }

    public Long getSuppId() {
        return suppId;
    }

    public void setSuppId(Long suppId) {
        this.suppId = suppId;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Integer getOrderDetailStatus() {
        return orderDetailStatus;
    }

    public void setOrderDetailStatus(Integer orderDetailStatus) {
        this.orderDetailStatus = orderDetailStatus;
    }

    public Integer getSuppStatus() {
        return suppStatus;
    }

    public void setSuppStatus(Integer suppStatus) {
        this.suppStatus = suppStatus;
    }

    public BigDecimal getLaterAmount() {
        return laterAmount;
    }

    public void setLaterAmount(BigDecimal laterAmount) {
        this.laterAmount = laterAmount;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public BigDecimal getPdPrice() {
        return pdPrice;
    }

    public void setPdPrice(BigDecimal pdPrice) {
        this.pdPrice = pdPrice;
    }

    public BigDecimal getLaterQty() {
        return laterQty;
    }

    public void setLaterQty(BigDecimal laterQty) {
        this.laterQty = laterQty;
    }
}
