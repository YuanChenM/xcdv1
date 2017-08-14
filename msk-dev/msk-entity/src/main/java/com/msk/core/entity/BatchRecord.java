/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表batch_record对应的BatchRecord。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class BatchRecord extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 运行ID */
    private java.lang.Long runId;
    /** 批处理编码 */
    private java.lang.String batchCode;
    /** 运行状态 */
    private java.lang.Integer status;
    /** 运行结果 */
    private java.lang.String result;
    /**
     * <p>默认构造函数。</p>
     */
    public BatchRecord() {

    }

    /**
     * <p>运行ID。</p>
     *
     * @return the 运行ID
     */
    public java.lang.Long getRunId() {
        return runId;
    }

    /**
     * <p>运行ID。</p>
     *
     * @param runId 运行ID。
     */
    public void setRunId(java.lang.Long runId) {
        this.runId = runId;
    }

    /**
     * <p>批处理编码。</p>
     *
     * @return the 批处理编码
     */
    public java.lang.String getBatchCode() {
        return batchCode;
    }

    /**
     * <p>批处理编码。</p>
     *
     * @param batchCode 批处理编码。
     */
    public void setBatchCode(java.lang.String batchCode) {
        this.batchCode = batchCode;
    }

    /**
     * <p>运行状态。</p>
     *
     * @return the 运行状态
     */
    public java.lang.Integer getStatus() {
        return status;
    }

    /**
     * <p>运行状态。</p>
     *
     * @param status 运行状态。
     */
    public void setStatus(java.lang.Integer status) {
        this.status = status;
    }

    /**
     * <p>运行结果。</p>
     *
     * @return the 运行结果
     */
    public java.lang.String getResult() {
        return result;
    }

    /**
     * <p>运行结果。</p>
     *
     * @param result 运行结果。
     */
    public void setResult(java.lang.String result) {
        this.result = result;
    }

}
