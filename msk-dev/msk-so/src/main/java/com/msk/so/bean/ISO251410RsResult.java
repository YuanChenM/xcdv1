package com.msk.so.bean;

import java.util.Date;

/**
 * 
 * ISO251407ReResult.
 *
 * @author pxg
 */
public class ISO251410RsResult {
    /** 退货单ID*/
    private Integer returnId;
    /** 退货单编码*/
    private String returnCode;
    /** 退货单状态*/
    private Integer returnStatus;
    /** 退货单状态更新时间*/
    private Date updTime;
    /** 退货单版本号*/
    private Integer ver;
    /**
     * Get the returnId.
     *
     * @return returnId
     *
     * @author Administrator
     */
    public Integer getReturnId() {
        return this.returnId;
    }
    /**
     * Set the returnId.
     *
     * @param returnId returnId
     *
     * @author Administrator
     */
    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }
    /**
     * Get the returnCode.
     *
     * @return returnCode
     *
     * @author Administrator
     */
    public String getReturnCode() {
        return this.returnCode;
    }
    /**
     * Set the returnCode.
     *
     * @param returnCode returnCode
     *
     * @author Administrator
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    /**
     * Get the returnStatus.
     *
     * @return returnStatus
     *
     * @author Administrator
     */
    public Integer getReturnStatus() {
        return this.returnStatus;
    }
    /**
     * Set the returnStatus.
     *
     * @param returnStatus returnStatus
     *
     * @author Administrator
     */
    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }
    /**
     * Get the updTime.
     *
     * @return updTime
     *
     * @author Administrator
     */
    public Date getUpdTime() {
        return this.updTime;
    }
    /**
     * Set the updTime.
     *
     * @param updTime updTime
     *
     * @author Administrator
     */
    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
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
}
