/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_complain对应的SoComplain。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoComplain extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 投诉ID */
    private Long complainId;
    /** 投诉编码 */
    private String complainCode;
    /** 订单ID */
    private Long orderId;
    /** 评价人员，买家ID */
    private String userId;
    /** 投诉时间 */
    private java.util.Date complainDate;
    /** 投诉理由编码，CodeMaster */
    private Integer complainReasonCode;
    /** 投诉描述 */
    private String complainDesc;
    /** 投诉图片 */
    private String complainImg;
    /** 投诉狀態 */
    private Integer complainStatus;
    /**
     * <p>默认构造函数。</p>
     */
    public SoComplain() {

    }

    /**
     * <p>投诉ID。</p>
     *
     * @return the 投诉ID
     */
    public Long getComplainId() {
        return complainId;
    }

    /**
     * <p>投诉ID。</p>
     *
     * @param complainId 投诉ID。
     */
    public void setComplainId(Long complainId) {
        this.complainId = complainId;
    }

    /**
     * <p>投诉编码。</p>
     *
     * @return the 投诉编码
     */
    public String getComplainCode() {
        return complainCode;
    }

    /**
     * <p>投诉编码。</p>
     *
     * @param complainCode 投诉编码。
     */
    public void setComplainCode(String complainCode) {
        this.complainCode = complainCode;
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

    /**
     * <p>投诉时间。</p>
     *
     * @return the 投诉时间
     */
    public java.util.Date getComplainDate() {
        return complainDate;
    }

    /**
     * <p>投诉时间。</p>
     *
     * @param complainDate 投诉时间。
     */
    public void setComplainDate(java.util.Date complainDate) {
        this.complainDate = complainDate;
    }

    /**
     * <p>投诉理由编码，CodeMaster。</p>
     *
     * @return the 投诉理由编码，CodeMaster
     */
    public Integer getComplainReasonCode() {
        return complainReasonCode;
    }

    /**
     * <p>投诉理由编码，CodeMaster。</p>
     *
     * @param complainReasonCode 投诉理由编码，CodeMaster。
     */
    public void setComplainReasonCode(Integer complainReasonCode) {
        this.complainReasonCode = complainReasonCode;
    }

    /**
     * <p>投诉描述。</p>
     *
     * @return the 投诉描述
     */
    public String getComplainDesc() {
        return complainDesc;
    }

    /**
     * <p>投诉描述。</p>
     *
     * @param complainDesc 投诉描述。
     */
    public void setComplainDesc(String complainDesc) {
        this.complainDesc = complainDesc;
    }

    /**
     * <p>投诉图片。</p>
     *
     * @return the 投诉图片
     */
    public String getComplainImg() {
        return complainImg;
    }

    /**
     * <p>投诉图片。</p>
     *
     * @param complainImg 投诉图片。
     */
    public void setComplainImg(String complainImg) {
        this.complainImg = complainImg;
    }

    public Integer getComplainStatus() {
        return complainStatus;
    }

    public void setComplainStatus(Integer complainStatus) {
        this.complainStatus = complainStatus;
    }
}
