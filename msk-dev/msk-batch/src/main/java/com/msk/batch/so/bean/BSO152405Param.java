package com.msk.batch.so.bean;

import com.msk.core.bean.BaseParam;

/**
 * Created by wang_shuai on 2016/4/8.
 */
public class BSO152405Param extends BaseParam {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /* 退货单ID*/
    private long returnId;
    /*退货单状态*/
    private int returnStatus;

    public long getReturnId() {
        return returnId;
    }
    public void setReturnId(long returnId) {
        this.returnId = returnId;
    }

    public int getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(int returnStatus) {
        this.returnStatus = returnStatus;
    }
}
