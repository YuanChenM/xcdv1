package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/2/14 0014.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BWQ20170503Bean extends BWQ2017050201Bean{
   /* private BWQ2017050201Bean pt;*/
    private List<BWQ201705020201Bean> rows;

    /*public BWQ2017050201Bean getPt() {
        return pt;
    }

    public void setPt(BWQ2017050201Bean pt) {
        this.pt = pt;
    }*/

    public List<BWQ201705020201Bean> getRows() {
        return rows;
    }

    public void setRows(List<BWQ201705020201Bean> rows) {
        this.rows = rows;
    }
}
