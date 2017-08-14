package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/2/13 0013.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BWQ20170502Bean extends BaseEntity{

    private BWQ2017050201Bean pt;
    private List<BWQ2017050202Bean> sts;

    public BWQ2017050201Bean getPt() {
        return pt;
    }

    public void setPt(BWQ2017050201Bean pt) {
        this.pt = pt;
    }

    public List<BWQ2017050202Bean> getSts() {
        return sts;
    }

    public void setSts(List<BWQ2017050202Bean> sts) {
        this.sts = sts;
    }
}
