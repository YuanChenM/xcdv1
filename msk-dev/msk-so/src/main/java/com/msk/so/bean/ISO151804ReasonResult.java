package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 *
 */
public class ISO151804ReasonResult extends BaseEntity {
    private Long reasonId;//原因ID
    private String reasonName;//原因名称

    public Long getReasonId() {
        return reasonId;
    }

    public void setReasonId(Long reasonId) {
        this.reasonId = reasonId;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }
}
