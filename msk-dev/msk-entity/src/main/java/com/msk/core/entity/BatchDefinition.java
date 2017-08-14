/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表batch_definition对应的BatchDefinition。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class BatchDefinition extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 批处理编码 */
    private java.lang.String batchCode;
    /** 批处理名称 */
    private java.lang.String batchName;
    /** 运行频率 */
    private java.lang.Integer runFrequency;
    /**
     * <p>默认构造函数。</p>
     */
    public BatchDefinition() {

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
     * <p>批处理名称。</p>
     *
     * @return the 批处理名称
     */
    public java.lang.String getBatchName() {
        return batchName;
    }

    /**
     * <p>批处理名称。</p>
     *
     * @param batchName 批处理名称。
     */
    public void setBatchName(java.lang.String batchName) {
        this.batchName = batchName;
    }

    /**
     * <p>运行频率。</p>
     *
     * @return the 运行频率
     */
    public java.lang.Integer getRunFrequency() {
        return runFrequency;
    }

    /**
     * <p>运行频率。</p>
     *
     * @param runFrequency 运行频率。
     */
    public void setRunFrequency(java.lang.Integer runFrequency) {
        this.runFrequency = runFrequency;
    }

}
