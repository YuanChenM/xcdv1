package com.msk.so.bean;

import com.msk.core.bean.BaseBean;

/**
 * @author chen_xin
 * @version 创建时间：2015年12月23日 下午2:16:10
 *          类说明
 * @author rwf update 2015-12-31 14:06 
 * 退货单列表         
 */
public class SO151406Bean extends BaseBean {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    //退货单ID
   private String returnId;
    // 退货单编码
    private String returnCode;
    // 需求订单编码
    private String orderCode;
    // 买家编码
    private String buyersCode;
    // 买家名称
    private String buyersName;
    //退货单来源 1:平台 2:呼叫中心 3:手机客户端
    private String returnSource;
    // 是否已经付款
    private String isPaid;
    //退款方式
    private String refundMode;
    //是否开票
    private String isInvoice;
    //退货单申请时间
    private String returnTime;
    // 退款金额
    private String returnAmount;
    // 状态
    private String returnStatus;
    //退货方式
    private String returnMode;
    //订单ID
    private String orderId;
    //查询开始时间
    private String startTime;
    //查询结束时间
    private String endTime;
    //查询条件的退货单编码
    private String returnCodeQuery;
    //查询条件的需求订单编码
    private String orderCodeQuery;
    //查询条件的买家编码
    private String buyersCodeQuery;
    //查询条件的买家名称
    private String buyersNameQuery;
    //需求订单code
    private String requireOrderCode;
    //退货单状态名称
    private String returnStatusName;

    public String getRequireOrderCode() {
        return requireOrderCode;
    }

    public void setRequireOrderCode(String requireOrderCode) {
        this.requireOrderCode = requireOrderCode;
    }

    /**
     * Get the returnCode.
     *
     * @return returnCode
     *
     * @author rwf
     */
    public String getReturnCode() {
        return this.returnCode;
    }
    /**
     * Set the returnCode.
     *
     * @param returnCode returnCode
     *
     * @author rwf
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    /**
     * Get the orderCode.
     *
     * @return orderCode
     *
     * @author rwf
     */
    public String getOrderCode() {
        return this.orderCode;
    }
    /**
     * Set the orderCode.
     *
     * @param orderCode orderCode
     *
     * @author rwf
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    /**
     * Get the buyersCode.
     *
     * @return buyersCode
     *
     * @author rwf
     */
    public String getBuyersCode() {
        return this.buyersCode;
    }
    /**
     * Set the buyersCode.
     *
     * @param buyersCode buyersCode
     *
     * @author rwf
     */
    public void setBuyersCode(String buyersCode) {
        this.buyersCode = buyersCode;
    }
    /**
     * Get the buyersName.
     *
     * @return buyersName
     *
     * @author rwf
     */
    public String getBuyersName() {
        return this.buyersName;
    }
    /**
     * Set the buyersName.
     *
     * @param buyersName buyersName
     *
     * @author rwf
     */
    public void setBuyersName(String buyersName) {
        this.buyersName = buyersName;
    }
    /**
     * Get the returnSource.
     *
     * @return returnSource
     *
     * @author rwf
     */
    public String getReturnSource() {
        return this.returnSource;
    }
    /**
     * Set the returnSource.
     *
     * @param returnSource returnSource
     *
     * @author rwf
     */
    public void setReturnSource(String returnSource) {
        this.returnSource = returnSource;
    }
    /**
     * Get the isPaid.
     *
     * @return isPaid
     *
     * @author rwf
     */
    public String getIsPaid() {
        return this.isPaid;
    }
    /**
     * Set the isPaid.
     *
     * @param isPaid isPaid
     *
     * @author rwf
     */
    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }
    /**
     * Get the refundMode.
     *
     * @return refundMode
     *
     * @author rwf
     */
    public String getRefundMode() {
        return this.refundMode;
    }
    /**
     * Set the refundMode.
     *
     * @param refundMode refundMode
     *
     * @author rwf
     */
    public void setRefundMode(String refundMode) {
        this.refundMode = refundMode;
    }
    /**
     * Get the isInvoice.
     *
     * @return isInvoice
     *
     * @author rwf
     */
    public String getIsInvoice() {
        return this.isInvoice;
    }
    /**
     * Set the isInvoice.
     *
     * @param isInvoice isInvoice
     *
     * @author rwf
     */
    public void setIsInvoice(String isInvoice) {
        this.isInvoice = isInvoice;
    }
    /**
     * Get the returnTime.
     *
     * @return returnTime
     *
     * @author rwf
     */
    public String getReturnTime() {
        return this.returnTime;
    }
    /**
     * Set the returnTime.
     *
     * @param returnTime returnTime
     *
     * @author rwf
     */
    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }
    /**
     * Get the returnAmount.
     *
     * @return returnAmount
     *
     * @author rwf
     */
    public String getReturnAmount() {
        return this.returnAmount;
    }
    /**
     * Set the returnAmount.
     *
     * @param returnAmount returnAmount
     *
     * @author rwf
     */
    public void setReturnAmount(String returnAmount) {
        this.returnAmount = returnAmount;
    }
    /**
     * Get the returnStatus.
     *
     * @return returnStatus
     *
     * @author rwf
     */
    public String getReturnStatus() {
        return this.returnStatus;
    }
    /**
     * Set the returnStatus.
     *
     * @param returnStatus returnStatus
     *
     * @author rwf
     */
    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }
    /**
     * Get the orderId.
     *
     * @return orderId
     *
     * @author rwf
     */
    public String getOrderId() {
        return this.orderId;
    }
    /**
     * Set the orderId.
     *
     * @param orderId orderId
     *
     * @author rwf
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    /**
     * Get the startTime.
     *
     * @return startTime
     *
     * @author rwf
     */
    public String getStartTime() {
        return this.startTime;
    }
    /**
     * Set the startTime.
     *
     * @param startTime startTime
     *
     * @author rwf
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    /**
     * Get the endTime.
     *
     * @return endTime
     *
     * @author rwf
     */
    public String getEndTime() {
        return this.endTime;
    }
    /**
     * Set the endTime.
     *
     * @param endTime endTime
     *
     * @author rwf
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    /**
     * Get the returnCodeQuery.
     *
     * @return returnCodeQuery
     *
     * @author rwf
     */
    public String getReturnCodeQuery() {
        return this.returnCodeQuery;
    }
    /**
     * Set the returnCodeQuery.
     *
     * @param returnCodeQuery returnCodeQuery
     *
     * @author rwf
     */
    public void setReturnCodeQuery(String returnCodeQuery) {
        this.returnCodeQuery = returnCodeQuery;
    }
    /**
     * Get the orderCodeQuery.
     *
     * @return orderCodeQuery
     *
     * @author rwf
     */
    public String getOrderCodeQuery() {
        return this.orderCodeQuery;
    }
    /**
     * Set the orderCodeQuery.
     *
     * @param orderCodeQuery orderCodeQuery
     *
     * @author rwf
     */
    public void setOrderCodeQuery(String orderCodeQuery) {
        this.orderCodeQuery = orderCodeQuery;
    }
    /**
     * Get the buyersCodeQuery.
     *
     * @return buyersCodeQuery
     *
     * @author rwf
     */
    public String getBuyersCodeQuery() {
        return this.buyersCodeQuery;
    }
    /**
     * Set the buyersCodeQuery.
     *
     * @param buyersCodeQuery buyersCodeQuery
     *
     * @author rwf
     */
    public void setBuyersCodeQuery(String buyersCodeQuery) {
        this.buyersCodeQuery = buyersCodeQuery;
    }
    /**
     * Get the buyersNameQuery.
     *
     * @return buyersNameQuery
     *
     * @author rwf
     */
    public String getBuyersNameQuery() {
        return this.buyersNameQuery;
    }
    /**
     * Set the buyersNameQuery.
     *
     * @param buyersNameQuery buyersNameQuery
     *
     * @author rwf
     */
    public void setBuyersNameQuery(String buyersNameQuery) {
        this.buyersNameQuery = buyersNameQuery;
    }
    /**
     * Get the returnMode.
     *
     * @return returnMode
     *
     * @author rwf
     */
    public String getReturnMode() {
        return this.returnMode;
    }
    /**
     * Set the returnMode.
     *
     * @param returnMode returnMode
     *
     * @author rwf
     */
    public void setReturnMode(String returnMode) {
        this.returnMode = returnMode;
    }
    /**
     * Get the returnId.
     *
     * @return returnId
     *
     * @author rwf
     */
    public String getReturnId() {
        return this.returnId;
    }
    /**
     * Set the returnId.
     *
     * @param returnId returnId
     *
     * @author rwf
     */
    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    public String getReturnStatusName() {
        return returnStatusName;
    }

    public void setReturnStatusName(String returnStatusName) {
        this.returnStatusName = returnStatusName;
    }
}
