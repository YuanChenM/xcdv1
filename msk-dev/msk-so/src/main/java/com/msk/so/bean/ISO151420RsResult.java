package com.msk.so.bean;

import com.msk.comm.bean.result.BaseResult;

/**
 * ISO151420RsResult接口返回结果信息.
 *
 * @author sjj
 */
public class ISO151420RsResult extends BaseResult {
    // 投诉ID
    private Long complainId;
    // 投诉单号
    private String complainCode;
    // 订单ID
    private Long orderId;

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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
