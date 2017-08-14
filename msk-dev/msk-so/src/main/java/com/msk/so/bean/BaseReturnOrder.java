package com.msk.so.bean;

import com.msk.core.bean.BaseBean;

/**
 * BaseReturnOrderBean 退货单基本信息
 * 
 * @author xhy
 * @version 1.0
 **/
public class BaseReturnOrder extends BaseBean {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private String returnCode;// 退货单编码

    private String orderCode; // 需求订单编码

    private String returnSource; //退货单来源

    private String returnMode; // 退货方式

    private String refundMode;// 退款方式

    private String returnAmount; // 退款总金额

    private String isInvoice; // 是否开票

    private String isPaid; // 是否付款  

    private String returnActor; // 退货处理人

    private String returnStatus; // 退货单状态

    private String returnTime; // 退货时间
    
    private String returnReasonCode; // 退货原因
    
    private String returnGoodsAllMoney; // 退货原因描述

    private String returnStatusName; // 退货单状态名称
    /**
     * Get the returnCode.
     *
     * @return returnCode
     *
     * @author xhy
     */
    public String getReturnCode() {
        return this.returnCode;
    }

    /**
     * Set the returnCode.
     *
     * @param returnCode returnCode
     *
     * @author xhy
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

  

    /**
     * Get the returnSource.
     *
     * @return returnSource
     *
     * @author xhy
     */
    public String getReturnSource() {
        return this.returnSource;
    }

    /**
     * Set the returnSource.
     *
     * @param returnSource returnSource
     *
     * @author xhy
     */
    public void setReturnSource(String returnSource) {
        this.returnSource = returnSource;
    }

    /**
     * Get the returnMode.
     *
     * @return returnMode
     *
     * @author xhy
     */
    public String getReturnMode() {
        return this.returnMode;
    }

    /**
     * Set the returnMode.
     *
     * @param returnMode returnMode
     *
     * @author xhy
     */
    public void setReturnMode(String returnMode) {
        this.returnMode = returnMode;
    }

    /**
     * Get the refundMode.
     *
     * @return refundMode
     *
     * @author xhy
     */
    public String getRefundMode() {
        return this.refundMode;
    }

    /**
     * Set the refundMode.
     *
     * @param refundMode refundMode
     *
     * @author xhy
     */
    public void setRefundMode(String refundMode) {
        this.refundMode = refundMode;
    }

    /**
     * Get the returnAmount.
     *
     * @return returnAmount
     *
     * @author xhy
     */
    public String getReturnAmount() {
        return this.returnAmount;
    }

    /**
     * Set the returnAmount.
     *
     * @param returnAmount returnAmount
     *
     * @author xhy
     */
    public void setReturnAmount(String returnAmount) {
        this.returnAmount = returnAmount;
    }

    /**
     * Get the isInvoice.
     *
     * @return isInvoice
     *
     * @author xhy
     */
    public String getIsInvoice() {
        return this.isInvoice;
    }

    /**
     * Set the isInvoice.
     *
     * @param isInvoice isInvoice
     *
     * @author xhy
     */
    public void setIsInvoice(String isInvoice) {
        this.isInvoice = isInvoice;
    }

    /**
     * Get the isPaid.
     *
     * @return isPaid
     *
     * @author xhy
     */
    public String getIsPaid() {
        return this.isPaid;
    }

    /**
     * Set the isPaid.
     *
     * @param isPaid isPaid
     *
     * @author xhy
     */
    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

 

 

    /**
     * Get the returnStatus.
     *
     * @return returnStatus
     *
     * @author xhy
     */
    public String getReturnStatus() {
        return this.returnStatus;
    }

    /**
     * Set the returnStatus.
     *
     * @param returnStatus returnStatus
     *
     * @author xhy
     */
    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    /**
     * Get the returnTime.
     *
     * @return returnTime
     *
     * @author xhy
     */
    public String getReturnTime() {
        return this.returnTime;
    }

    /**
     * Set the returnTime.
     *
     * @param returnTime returnTime
     *
     * @author xhy
     */
    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    /**
     * Get the returnReasonCode.
     *
     * @return returnReasonCode
     *
     * @author xhy
     */
    public String getReturnReasonCode() {
        return this.returnReasonCode;
    }

    /**
     * Set the returnReasonCode.
     *
     * @param returnReasonCode returnReasonCode
     *
     * @author xhy
     */
    public void setReturnReasonCode(String returnReasonCode) {
        this.returnReasonCode = returnReasonCode;
    }

    /**
     * Get the returnGoodsAllMoney.
     *
     * @return returnGoodsAllMoney
     *
     * @author xhy
     */
    public String getReturnGoodsAllMoney() {
        return this.returnGoodsAllMoney;
    }

    /**
     * Set the returnGoodsAllMoney.
     *
     * @param returnGoodsAllMoney returnGoodsAllMoney
     *
     * @author xhy
     */
    public void setReturnGoodsAllMoney(String returnGoodsAllMoney) {
        this.returnGoodsAllMoney = returnGoodsAllMoney;
    }

    /**
     * Get the returnActor.
     *
     * @return returnActor
     *
     * @author Administrator
     */
    public String getReturnActor() {
        return this.returnActor;
    }

    /**
     * Set the returnActor.
     *
     * @param returnActor returnActor
     *
     * @author Administrator
     */
    public void setReturnActor(String returnActor) {
        this.returnActor = returnActor;
    }



    public String getReturnStatusName() {
        return returnStatusName;
    }

    public void setReturnStatusName(String returnStatusName) {
        this.returnStatusName = returnStatusName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}
