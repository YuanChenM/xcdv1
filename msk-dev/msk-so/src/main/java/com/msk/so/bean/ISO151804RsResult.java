package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class ISO151804RsResult extends BaseEntity {
    private List<ISO151804ReasonResult> reasonList;

    public List<ISO151804ReasonResult> getReasonList() {
        return reasonList;
    }

    public void setReasonList(List<ISO151804ReasonResult> reasonList) {
        this.reasonList = reasonList;
    }
}
