package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.msk.core.entity.BaseEntity;

/**
 * Created by Administrator on 2017/2/13 0013.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BWQ201705Bean extends BaseEntity {
    private BWQ20170501Bean config;
    private BWQ20170502Bean data;

    public BWQ20170501Bean getConfig() {
        return config;
    }

    public void setConfig(BWQ20170501Bean config) {
        this.config = config;
    }

    public BWQ20170502Bean getData() {
        return data;
    }

    public void setData(BWQ20170502Bean data) {
        this.data = data;
    }
}
