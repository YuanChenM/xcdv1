package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Administrator on 2017/2/13 0013.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BWQ2017050202Bean {

    @JsonProperty("id")
    private String id;
    @JsonProperty("rows")
    private List<BWQ201705020201Bean> rows;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BWQ201705020201Bean> getRows() {
        return rows;
    }

    public void setRows(List<BWQ201705020201Bean> rows) {
        this.rows = rows;
    }
}
