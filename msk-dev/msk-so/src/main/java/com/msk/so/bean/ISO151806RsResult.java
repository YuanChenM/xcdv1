package com.msk.so.bean;

import java.io.Serializable;

/**
 * zhang_qiang1 库存调整接口 返回值
 */
public class ISO151806RsResult implements Serializable {
    private Long adjustId;//调整业务单Id

    private String adjustCode;//调整业务单Code

    public Long getAdjustId() {
        return adjustId;
    }

    public void setAdjustId(Long adjustId) {
        this.adjustId = adjustId;
    }

    public String getAdjustCode() {
        return adjustCode;
    }

    public void setAdjustCode(String adjustCode) {
        this.adjustCode = adjustCode;
    }
}
