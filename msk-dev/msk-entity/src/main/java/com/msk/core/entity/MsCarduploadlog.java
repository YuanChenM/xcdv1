/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表ms_carduploadlog对应的MsCarduploadlog。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class MsCarduploadlog extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 日志ID */
    private java.lang.Long logId;
    /** 1:成功 */
    private java.lang.Integer uploadResult;
    /**
     * <p>默认构造函数。</p>
     */
    public MsCarduploadlog() {

    }

    /**
     * <p>日志ID。</p>
     *
     * @return the 日志ID
     */
    public java.lang.Long getLogId() {
        return logId;
    }

    /**
     * <p>日志ID。</p>
     *
     * @param logId 日志ID。
     */
    public void setLogId(java.lang.Long logId) {
        this.logId = logId;
    }

    /**
     * <p>1:成功。</p>
     *
     * @return the 1:成功
     */
    public java.lang.Integer getUploadResult() {
        return uploadResult;
    }

    /**
     * <p>1:成功。</p>
     *
     * @param uploadResult 1:成功。
     */
    public void setUploadResult(java.lang.Integer uploadResult) {
        this.uploadResult = uploadResult;
    }

}
