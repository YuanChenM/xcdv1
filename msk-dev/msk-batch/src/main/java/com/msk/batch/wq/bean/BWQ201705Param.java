package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2017/2/13 0013.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BWQ201705Param extends WqRequest {

    /** 外勤365系统中该流程的编码**/
    @JsonProperty("form_id")
    private String form_id;
    /** 主记录code**/
    @JsonProperty("source_code")
    private String source_code;
    /** 上报日期起,格式：“yyyy-MM-dd”**/
    @JsonProperty("date_start")
    private String date_start;
    /** 上报日期止,格式：“yyyy-MM-dd”**/
    @JsonProperty("date_end")
    private String date_end;
    /** 上报人id**/
    @JsonProperty("creator_id")
    private String creator_id;
    /** 数据页数**/
    @JsonProperty("page")
    private String page;
    /** 每页数据显示条数**/
    @JsonProperty("rows")
    private String rows;

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public String getSource_code() {
        return source_code;
    }

    public void setSource_code(String source_code) {
        this.source_code = source_code;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(String creator_id) {
        this.creator_id = creator_id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }
}
