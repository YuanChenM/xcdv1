package com.msk.so.bean;

import com.msk.core.bean.RsPageParam;

/**
 * ISO151421RsParam接受参数.
 *
 * @author sjj
 */
public class ISO151421RsParam extends RsPageParam {
    // 投诉用户ID
    private String userId;
    // 投诉处理状态区分
    private String complainStatus;
    // 订单ID
    private Long orderId;
    // 投诉ID
    private Long complainId;
    // 投诉单号
    private String complainCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComplainStatus() {
        return complainStatus;
    }

    public void setComplainStatus(String complainStatus) {
        this.complainStatus = complainStatus;
    }

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
}
