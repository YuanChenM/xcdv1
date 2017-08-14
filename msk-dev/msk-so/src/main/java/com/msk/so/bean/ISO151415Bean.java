package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sunjiaju on 2016/6/22.
 */
public class ISO151415Bean extends BaseEntity {
    /** 订单类型*/
    private Integer orderType;
    /** 是否退货*/
    private Integer isReturn;
    /** 收款方id */
    private String businessMainId;
    /** 收款方名称 */
    private String businessMainName;
    /** 付款方id */
    private String businessAssistantId;
    /** 付款方编码 */
    private String businessAssistantCode;
    /** 付款方名称 */
    private String businessAssistantName;
    /** 收款方角色 */
    private Integer businessMainRole;
    /** 付款方角色 */
    private Integer businessAssistantRole;
    /** 交易明细的唯一检索标识（订单号、管理费用单号） */
    private String transCode;
    /** 0 主订单 1管理费用清单 */
    private Integer transType;
    /** :0：正常 1：交易关闭 */
    private String transFlg;
    /** 订单金额 */
    private BigDecimal orderAmount;
    /** 订单生成的日期 */
    private Date tranTime;
    /** 1:神农客 2:美侍客 3:大促会 */
    private Integer supplyPlatform;
    /** 支付类型 1:在线支付,2:线下支付 */
    private Integer paymentType;
    /** 买家应付金额 */
    private BigDecimal due;
    /** 卖家应收金额 */
    private BigDecimal receiveable;
    /** 订单状态 */
    private Integer orderStatus;
    /** 配送单号 */
    private String deliveryCode;
    /** 配送单签收日期 */
    private Date deliveryTime;
    /** 退货退款单编码、拒收单编码 */
    private String refundCode;
    /** 退款金额 */
    private BigDecimal refundAmount;
    /** 退款发生日期 */
    private Date refundTime;
    /** 订单ID */
    private Long orderId;
    /** 配送金额 */
    private BigDecimal shippingAmount;
    /** 签收金额 */
    private BigDecimal paidAmount;

    public String getBusinessMainId() {
        return businessMainId;
    }

    public void setBusinessMainId(String businessMainId) {
        this.businessMainId = businessMainId;
    }

    public String getBusinessMainName() {
        return businessMainName;
    }

    public void setBusinessMainName(String businessMainName) {
        this.businessMainName = businessMainName;
    }

    public String getBusinessAssistantId() {
        return businessAssistantId;
    }

    public void setBusinessAssistantId(String businessAssistantId) {
        this.businessAssistantId = businessAssistantId;
    }

    public String getBusinessAssistantCode() {
        return businessAssistantCode;
    }

    public void setBusinessAssistantCode(String businessAssistantCode) {
        this.businessAssistantCode = businessAssistantCode;
    }

    public String getBusinessAssistantName() {
        return businessAssistantName;
    }

    public void setBusinessAssistantName(String businessAssistantName) {
        this.businessAssistantName = businessAssistantName;
    }

    public Integer getBusinessMainRole() {
        return businessMainRole;
    }

    public void setBusinessMainRole(Integer businessMainRole) {
        this.businessMainRole = businessMainRole;
    }

    public Integer getBusinessAssistantRole() {
        return businessAssistantRole;
    }

    public void setBusinessAssistantRole(Integer businessAssistantRole) {
        this.businessAssistantRole = businessAssistantRole;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public String getTransFlg() {
        return transFlg;
    }

    public void setTransFlg(String transFlg) {
        this.transFlg = transFlg;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getTranTime() {
        return tranTime;
    }

    public void setTranTime(Date tranTime) {
        this.tranTime = tranTime;
    }

    public Integer getSupplyPlatform() {
        return supplyPlatform;
    }

    public void setSupplyPlatform(Integer supplyPlatform) {
        this.supplyPlatform = supplyPlatform;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getDue() {
        return due;
    }

    public void setDue(BigDecimal due) {
        this.due = due;
    }

    public BigDecimal getReceiveable() {
        return receiveable;
    }

    public void setReceiveable(BigDecimal receiveable) {
        this.receiveable = receiveable;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getRefundCode() {
        return refundCode;
    }

    public void setRefundCode(String refundCode) {
        this.refundCode = refundCode;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    public Integer getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Integer isReturn) {
        this.isReturn = isReturn;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(BigDecimal shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }
}
