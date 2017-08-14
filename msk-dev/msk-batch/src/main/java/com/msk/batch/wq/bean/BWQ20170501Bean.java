package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2017/2/13 0013.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BWQ20170501Bean {

    /** 流程id**/
    @JsonProperty("form_id")
    private String formId;

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }
}
