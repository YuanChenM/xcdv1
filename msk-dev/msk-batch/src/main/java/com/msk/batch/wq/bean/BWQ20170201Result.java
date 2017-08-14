package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BWQ20170201Result {

    /** 扩展字段名称**/
    @JsonProperty("ext_key")
    private String extKey;
    /** 扩展字段值**/
    @JsonProperty("ext_value")
    private String extValue;

    public String getExtKey() {
        return extKey;
    }

    public void setExtKey(String extKey) {
        this.extKey = extKey;
    }

    public String getExtValue() {
        return extValue;
    }

    public void setExtValue(String extValue) {
        this.extValue = extValue;
    }
}
