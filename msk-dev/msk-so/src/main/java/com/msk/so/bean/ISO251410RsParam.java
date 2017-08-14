package com.msk.so.bean;

/**
 * DistriButionOrder.
 * 取消标准分销退货单
 * 
 * @author pxg
 */
public class ISO251410RsParam {
    /** 退货单ID*/
    private Integer returnID;
    /** 退货单版本号*/
    private Integer ver;
    /** 取消原因*/
    private String cancelReason;
    /**
     * Get the returnID.
     *
     * @return returnID
     *
     * @author Administrator
     */
    public Integer getReturnID() {
        return this.returnID;
    }
    /**
     * Set the returnID.
     *
     * @param returnID returnID
     *
     * @author Administrator
     */
    public void setReturnID(Integer returnID) {
        this.returnID = returnID;
    }
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
     * Get the cancelReason.
     *
     * @return cancelReason
     *
     * @author Administrator
     */
    public String getCancelReason() {
        return this.cancelReason;
    }
    /**
     * Set the cancelReason.
     *
     * @param cancelReason cancelReason
     *
     * @author Administrator
     */
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
}   
