package com.msk.so.bean.rs;

import com.msk.core.bean.BaseBean;

import java.util.Date;

/**
 * Created by liu_tao2 on 2016/7/18.
 */
public class ISO151801RsResult extends BaseBean {



    /** 迟收单ID */
    private Long returnId;

    /** 迟收单编号 */
    private String returnCode;

    /** 迟收单状态 */
    private Integer returnStatus;

    /** 迟收单创建时间 */
    private String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public Integer getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }
}
