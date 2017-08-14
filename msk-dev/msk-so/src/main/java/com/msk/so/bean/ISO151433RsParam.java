package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

import java.util.Date;
import java.util.List;

/**
 * Created by sunjiaju on 2016/7/14.
 */
public class ISO151433RsParam extends BaseParam {
    // 订单ID
    private Long orderId;
    // 发货单ID
    private Long shipId;
    // 取消人ID
    private String cancelManId;
    // 取消人名称
    private String cancelManName;
    // 取消时间
    private String cancelTime;
    // 取消原因
    private Integer cancelReason;
    // 取消备注
    private String remark;
    
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public String getCancelManId() {
        return cancelManId;
    }

    public void setCancelManId(String cancelManId) {
        this.cancelManId = cancelManId;
    }

    public String getCancelManName() {
        return cancelManName;
    }

    public void setCancelManName(String cancelManName) {
        this.cancelManName = cancelManName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(Integer cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
    }
}
