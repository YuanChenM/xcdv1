/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_ep_cert_item对应的SlEpCertItem。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlEpCertItem extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 企业ID */
    private java.lang.Long epId;
    /** 证照顺序号 */
    private java.lang.Long certSeq;
    /** 企业证照项目顺序号 */
    private java.lang.Long certItemSeq;
    /** 证照ID */
    private java.lang.Long certId;
    /** 证照项目ID */
    private java.lang.Long certItemId;
    /** 证照项目名称 */
    private java.lang.String certItemName;
    /** 证照项目内容 */
    private java.lang.String certItemValue;
    /**
     * <p>默认构造函数。</p>
     */
    public SlEpCertItem() {

    }

    /**
     * <p>企业ID。</p>
     *
     * @return the 企业ID
     */
    public java.lang.Long getEpId() {
        return epId;
    }

    /**
     * <p>企业ID。</p>
     *
     * @param epId 企业ID。
     */
    public void setEpId(java.lang.Long epId) {
        this.epId = epId;
    }

    /**
     * <p>证照顺序号。</p>
     *
     * @return the 证照顺序号
     */
    public java.lang.Long getCertSeq() {
        return certSeq;
    }

    /**
     * <p>证照顺序号。</p>
     *
     * @param certSeq 证照顺序号。
     */
    public void setCertSeq(java.lang.Long certSeq) {
        this.certSeq = certSeq;
    }

    /**
     * <p>企业证照项目顺序号。</p>
     *
     * @return the 企业证照项目顺序号
     */
    public java.lang.Long getCertItemSeq() {
        return certItemSeq;
    }

    /**
     * <p>企业证照项目顺序号。</p>
     *
     * @param certItemSeq 企业证照项目顺序号。
     */
    public void setCertItemSeq(java.lang.Long certItemSeq) {
        this.certItemSeq = certItemSeq;
    }

    /**
     * <p>证照ID。</p>
     *
     * @return the 证照ID
     */
    public java.lang.Long getCertId() {
        return certId;
    }

    /**
     * <p>证照ID。</p>
     *
     * @param certId 证照ID。
     */
    public void setCertId(java.lang.Long certId) {
        this.certId = certId;
    }

    /**
     * <p>证照项目ID。</p>
     *
     * @return the 证照项目ID
     */
    public java.lang.Long getCertItemId() {
        return certItemId;
    }

    /**
     * <p>证照项目ID。</p>
     *
     * @param certItemId 证照项目ID。
     */
    public void setCertItemId(java.lang.Long certItemId) {
        this.certItemId = certItemId;
    }

    /**
     * <p>证照项目名称。</p>
     *
     * @return the 证照项目名称
     */
    public java.lang.String getCertItemName() {
        return certItemName;
    }

    /**
     * <p>证照项目名称。</p>
     *
     * @param certItemName 证照项目名称。
     */
    public void setCertItemName(java.lang.String certItemName) {
        this.certItemName = certItemName;
    }

    /**
     * <p>证照项目内容。</p>
     *
     * @return the 证照项目内容
     */
    public java.lang.String getCertItemValue() {
        return certItemValue;
    }

    /**
     * <p>证照项目内容。</p>
     *
     * @param certItemValue 证照项目内容。
     */
    public void setCertItemValue(java.lang.String certItemValue) {
        this.certItemValue = certItemValue;
    }

}
