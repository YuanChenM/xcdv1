package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;

/**
 * Created by air on 2016/3/11.
 */
public class IPD141126Bean extends BaseEntity {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String tspStdItemId;
    private String tspStdItemName;
    private String okVal;
    private String ngVal;


    public String getTspStdItemId() {
        return tspStdItemId;
    }

    public void setTspStdItemId(String tspStdItemId) {
        this.tspStdItemId = tspStdItemId;
    }

    public String getTspStdItemName() {
        return tspStdItemName;
    }

    public void setTspStdItemName(String tspStdItemName) {
        this.tspStdItemName = tspStdItemName;
    }

    public String getOkVal() {
        return okVal;
    }

    public void setOkVal(String okVal) {
        this.okVal = okVal;
    }

    public String getNgVal() {
        return ngVal;
    }

    public void setNgVal(String ngVal) {
        this.ngVal = ngVal;
    }
}
