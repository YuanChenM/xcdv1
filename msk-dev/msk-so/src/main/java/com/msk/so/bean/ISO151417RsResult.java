package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

/**
 * Created by liutao on 2016/10/11.
 */
public class ISO151417RsResult extends BaseEntity {

    private Long evaluateId;

    private Long orderId;

    public Long getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Long evaluateId) {
        this.evaluateId = evaluateId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
