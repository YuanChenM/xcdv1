/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_ep_honor对应的SlEpHonor。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlEpHonor extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 企业ID */
    private java.lang.Long epId;
    /** 荣誉ID */
    private java.lang.Long honorId;
    /** 荣誉描述 */
    private java.lang.String honorDesc;
    /** 发证日期 */
    private java.util.Date certDate;
    /** 发证单位 */
    private java.lang.String certIssuer;
    /**
     * <p>默认构造函数。</p>
     */
    public SlEpHonor() {

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
     * <p>荣誉ID。</p>
     *
     * @return the 荣誉ID
     */
    public java.lang.Long getHonorId() {
        return honorId;
    }

    /**
     * <p>荣誉ID。</p>
     *
     * @param honorId 荣誉ID。
     */
    public void setHonorId(java.lang.Long honorId) {
        this.honorId = honorId;
    }

    /**
     * <p>荣誉描述。</p>
     *
     * @return the 荣誉描述
     */
    public java.lang.String getHonorDesc() {
        return honorDesc;
    }

    /**
     * <p>荣誉描述。</p>
     *
     * @param honorDesc 荣誉描述。
     */
    public void setHonorDesc(java.lang.String honorDesc) {
        this.honorDesc = honorDesc;
    }

    /**
     * <p>发证日期。</p>
     *
     * @return the 发证日期
     */
    public java.util.Date getCertDate() {
        return certDate;
    }

    /**
     * <p>发证日期。</p>
     *
     * @param certDate 发证日期。
     */
    public void setCertDate(java.util.Date certDate) {
        this.certDate = certDate;
    }

    /**
     * <p>发证单位。</p>
     *
     * @return the 发证单位
     */
    public java.lang.String getCertIssuer() {
        return certIssuer;
    }

    /**
     * <p>发证单位。</p>
     *
     * @param certIssuer 发证单位。
     */
    public void setCertIssuer(java.lang.String certIssuer) {
        this.certIssuer = certIssuer;
    }

}
