/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_evaluate对应的SoEvaluate。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoEvaluate extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 评价ID */
    private Long evaluateId;
    /** 订单ID */
    private Long orderId;
    /** 评价时间 */
    private java.util.Date evaluateDate;
    /** 评价人员，买家ID */
    private String userId;
    /**
     * <p>默认构造函数。</p>
     */
    public SoEvaluate() {

    }

    /**
     * <p>评价ID。</p>
     *
     * @return the 评价ID
     */
    public Long getEvaluateId() {
        return evaluateId;
    }

    /**
     * <p>评价ID。</p>
     *
     * @param evaluateId 评价ID。
     */
    public void setEvaluateId(Long evaluateId) {
        this.evaluateId = evaluateId;
    }

    /**
     * <p>订单ID。</p>
     *
     * @return the 订单ID
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * <p>订单ID。</p>
     *
     * @param orderId 订单ID。
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * <p>评价时间。</p>
     *
     * @return the 评价时间
     */
    public java.util.Date getEvaluateDate() {
        return evaluateDate;
    }

    /**
     * <p>评价时间。</p>
     *
     * @param evaluateDate 评价时间。
     */
    public void setEvaluateDate(java.util.Date evaluateDate) {
        this.evaluateDate = evaluateDate;
    }

    /**
     * <p>评价人员，买家ID。</p>
     *
     * @return the 评价人员，买家ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * <p>评价人员，买家ID。</p>
     *
     * @param userId 评价人员，买家ID。
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
