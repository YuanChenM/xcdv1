package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

/**
 * 
 * ISO151421ComplainRsResult接口返回结果信息.
 *
 * @author sjj
 */
public class ISO151421ComplainRsResult extends BaseEntity{
    // 订单ID
    private Long orderId;
    // 投诉ID
    private Long complainId;
    // 投诉单号
    private String complainCode;
    // 投诉处理状态
    private Integer complainStatus;
    // 投诉理由Code
    private Integer complainReasonCode;
    // 投诉理由
    private String complainReason;
    // 投诉描述
    private String complainDescription;
    // 投诉凭证图片
    private String complainImg;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getComplainId() {
        return complainId;
    }

    public void setComplainId(Long complainId) {
        this.complainId = complainId;
    }

    public String getComplainCode() {
        return complainCode;
    }

    public void setComplainCode(String complainCode) {
        this.complainCode = complainCode;
    }

    public Integer getComplainStatus() {
        return complainStatus;
    }

    public void setComplainStatus(Integer complainStatus) {
        this.complainStatus = complainStatus;
    }

    public Integer getComplainReasonCode() {
        return complainReasonCode;
    }

    public void setComplainReasonCode(Integer complainReasonCode) {
        this.complainReasonCode = complainReasonCode;
    }

    public String getComplainReason() {
        return complainReason;
    }

    public void setComplainReason(String complainReason) {
        this.complainReason = complainReason;
    }

    public String getComplainDescription() {
        return complainDescription;
    }

    public void setComplainDescription(String complainDescription) {
        this.complainDescription = complainDescription;
    }

    public String getComplainImg() {
        return complainImg;
    }

    public void setComplainImg(String complainImg) {
        this.complainImg = complainImg;
    }
}
