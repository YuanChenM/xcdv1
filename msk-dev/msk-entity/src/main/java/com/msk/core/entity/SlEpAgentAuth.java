/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_ep_agent_auth对应的SlEpAgentAuth。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlEpAgentAuth extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 卖家编码 */
    private java.lang.String slCode;
    /** 生产商_企业ID */
    private java.lang.Long producerEpId;
    /** 授权经销合同号 */
    private java.lang.String contractNo;
    /** 授权单位 */
    private java.lang.String authEpName;
    /** 授权期限开始 */
    private java.util.Date authTermBegin;
    /** 授权期限结束 */
    private java.util.Date authTermEnd;
    /** 1:长期 */
    private java.lang.String authTermUnliimited;
    /**
     * <p>默认构造函数。</p>
     */
    public SlEpAgentAuth() {

    }

    /**
     * <p>卖家编码。</p>
     *
     * @return the 卖家编码
     */
    public java.lang.String getSlCode() {
        return slCode;
    }

    /**
     * <p>卖家编码。</p>
     *
     * @param slCode 卖家编码。
     */
    public void setSlCode(java.lang.String slCode) {
        this.slCode = slCode;
    }

    /**
     * <p>生产商_企业ID。</p>
     *
     * @return the 生产商_企业ID
     */
    public java.lang.Long getProducerEpId() {
        return producerEpId;
    }

    /**
     * <p>生产商_企业ID。</p>
     *
     * @param producerEpId 生产商_企业ID。
     */
    public void setProducerEpId(java.lang.Long producerEpId) {
        this.producerEpId = producerEpId;
    }

    /**
     * <p>授权经销合同号。</p>
     *
     * @return the 授权经销合同号
     */
    public java.lang.String getContractNo() {
        return contractNo;
    }

    /**
     * <p>授权经销合同号。</p>
     *
     * @param contractNo 授权经销合同号。
     */
    public void setContractNo(java.lang.String contractNo) {
        this.contractNo = contractNo;
    }

    /**
     * <p>授权单位。</p>
     *
     * @return the 授权单位
     */
    public java.lang.String getAuthEpName() {
        return authEpName;
    }

    /**
     * <p>授权单位。</p>
     *
     * @param authEpName 授权单位。
     */
    public void setAuthEpName(java.lang.String authEpName) {
        this.authEpName = authEpName;
    }

    /**
     * <p>授权期限开始。</p>
     *
     * @return the 授权期限开始
     */
    public java.util.Date getAuthTermBegin() {
        return authTermBegin;
    }

    /**
     * <p>授权期限开始。</p>
     *
     * @param authTermBegin 授权期限开始。
     */
    public void setAuthTermBegin(java.util.Date authTermBegin) {
        this.authTermBegin = authTermBegin;
    }

    /**
     * <p>授权期限结束。</p>
     *
     * @return the 授权期限结束
     */
    public java.util.Date getAuthTermEnd() {
        return authTermEnd;
    }

    /**
     * <p>授权期限结束。</p>
     *
     * @param authTermEnd 授权期限结束。
     */
    public void setAuthTermEnd(java.util.Date authTermEnd) {
        this.authTermEnd = authTermEnd;
    }

    /**
     * <p>1:长期。</p>
     *
     * @return the 1:长期
     */
    public java.lang.String getAuthTermUnliimited() {
        return authTermUnliimited;
    }

    /**
     * <p>1:长期。</p>
     *
     * @param authTermUnliimited 1:长期。
     */
    public void setAuthTermUnliimited(java.lang.String authTermUnliimited) {
        this.authTermUnliimited = authTermUnliimited;
    }

}
