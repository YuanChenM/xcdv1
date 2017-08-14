package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * Created by air on 2016/3/11.
 */
public class IPD141126RsResult extends BaseEntity{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private String tspStdClaId;

    private String tspStdClaName;

    private List<IPD141126Bean> tspStdSublist ;

    public String getTspStdClaId() {
        return tspStdClaId;
    }

    public void setTspStdClaId(String tspStdClaId) {
        this.tspStdClaId = tspStdClaId;
    }

    public String getTspStdClaName() {
        return tspStdClaName;
    }

    public void setTspStdClaName(String tspStdClaName) {
        this.tspStdClaName = tspStdClaName;
    }

    public List<IPD141126Bean> getTspStdSublist() {
        return tspStdSublist;
    }

    public void setTspStdSublist(List<IPD141126Bean> tspStdSublist) {
        this.tspStdSublist = tspStdSublist;
    }
}
