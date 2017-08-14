package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

/**
 * Created by sun_jiaju on 2016/10/11.
 */
public class ISO151425RsResult extends BaseEntity {
    // 投诉单数
    private Integer complainCount;

    public Integer getComplainCount() {
        return complainCount;
    }

    public void setComplainCount(Integer complainCount) {
        this.complainCount = complainCount;
    }
}
