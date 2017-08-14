package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

/**
 * DistriButionOrder.
 * 删除/恢复标准分销订单
 * 
 * @author pxg
 */
public class ISO251412RsParam extends BaseParam{
    /** 订单ID*/
    private Long orderId;
    /** 订单版本号*/
    private Integer ver;
    /** 操作类型,0:删除,1:恢复*/
    private Integer operateType;
    /**
     * Get the ver.
     *
     * @return ver
     *
     * @author Administrator
     */
    public Integer getVer() {
        return this.ver;
    }
    /**
     * Set the ver.
     *
     * @param ver ver
     *
     * @author Administrator
     */
    public void setVer(Integer ver) {
        this.ver = ver;
    }
    /**
     * Get the operateType.
     *
     * @return operateType
     *
     * @author Administrator
     */
    public Integer getOperateType() {
        return this.operateType;
    }
    /**
     * Set the operateType.
     *
     * @param operateType operateType
     *
     * @author Administrator
     */
    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }
    /**
     * Get the orderId.
     *
     * @return orderId
     *
     * @author Administrator
     */
    public Long getOrderId() {
        return this.orderId;
    }
    /**
     * Set the orderId.
     *
     * @param orderId orderId
     *
     * @author Administrator
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}   
