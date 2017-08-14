package com.msk.so.bean;

import com.msk.core.bean.RsPageParam;

/**
 * ISO151420RsParam接受参数.
 *
 * @author sjj
 */
public class ISO151420RsParam extends RsPageParam {
    // 用户ID
    private String userId;
    // 投诉时间
    private String complainDate;
    // 订单ID
    private Long orderId;
    // 投诉理由Code
    private Integer complainReasonCode;
    // 投诉描述
    private String complainDescription;
    // 投诉凭证图片文件ID
    private String complainImg;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComplainDate() {
        return complainDate;
    }

    public void setComplainDate(String complainDate) {
        this.complainDate = complainDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getComplainReasonCode() {
        return complainReasonCode;
    }

    public void setComplainReasonCode(Integer complainReasonCode) {
        this.complainReasonCode = complainReasonCode;
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
