package com.msk.so.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DistriButionOrder.
 * 指定退货单列表
 * 
 * @author pxg
 */
public class ISO251409RsReturnList {
    /** 退货单ID*/
    private Integer returnId;
    /** 退货单编码*/
    private String returnCode;
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
}   
