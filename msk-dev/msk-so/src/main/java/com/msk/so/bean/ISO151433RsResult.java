package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

/**
 * 
 * ISO151433RsResult接口返回结果信息.
 *
 * @author sunjiaju
 */
public class ISO151433RsResult extends BaseEntity {
    //订单ID
    private Long orderId;
    //发货单ID
    private Long shipId;
    //数据版本号
    private Integer ver;

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

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }
}
