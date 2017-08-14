package com.msk.so.bean.rs;

import com.msk.core.bean.BaseBean;

/**
 * Created by liu_tao2 on 2016/7/21.
 */
public class ISO151802RsResult extends BaseBean {

    /** 现场退货单ID */
    private Long returnId;

    /** 现场退货单编号 */
    private String returnCode;

    /** 现场退货单状态 */
    private Integer returnStatus;

    /** 退货单创建时间 */
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
