package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.msk.core.bean.BaseParam;

import java.util.Date;

/**
 * Created by air on 2017/1/23.
 */

@JsonIgnoreProperties(value={"crtId","crtTime","updId","updTime","delFlg","actId","actTime","artnoId","filterMap"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BWQ201704Param extends BaseParam{

    private Date currentDate;

    /** 页码**/
    @JsonProperty("page_number")
    private int pageNumber;
    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

}
