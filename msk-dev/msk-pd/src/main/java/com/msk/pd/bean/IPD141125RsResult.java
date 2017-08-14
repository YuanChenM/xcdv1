package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * Created by FjM on 2016/3/11.
 */
public class IPD141125RsResult extends BaseEntity {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private String gnqStdClaId;

    private String gnqStdClaName;

    private List<IPD141125Bean> gnqStdSublist ;

    public String getGnqStdClaId() {
        return gnqStdClaId;
    }

    public void setGnqStdClaId(String gnqStdClaId) {
        this.gnqStdClaId = gnqStdClaId;
    }

    public String getGnqStdClaName() {
        return gnqStdClaName;
    }

    public void setGnqStdClaName(String gnqStdClaName) {
        this.gnqStdClaName = gnqStdClaName;
    }

    public List<IPD141125Bean> getGnqStdSublist() {
        return gnqStdSublist;
    }

    public void setGnqStdSublist(List<IPD141125Bean> gnqStdSublist) {
        this.gnqStdSublist = gnqStdSublist;
    }
}
