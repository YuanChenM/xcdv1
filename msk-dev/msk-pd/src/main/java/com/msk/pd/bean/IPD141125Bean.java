package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;

/**
 * Created by FjM on 2016/3/11.
 */
public class IPD141125Bean extends BaseEntity {


    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String gnqStdItemId;
    private String gnqStdItemName;
    private String okVal;
    private String ngVal;


    public String getGnqStdItemId() {
        return gnqStdItemId;
    }

    public void setGnqStdItemId(String gnqStdItemId) {
        this.gnqStdItemId = gnqStdItemId;
    }

    public String getGnqStdItemName() {
        return gnqStdItemName;
    }

    public void setGnqStdItemName(String gnqStdItemName) {
        this.gnqStdItemName = gnqStdItemName;
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
