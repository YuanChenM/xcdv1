/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_ep_brand_honor对应的SlEpBrandHonor。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlEpBrandHonor extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 企业ID */
    private java.lang.Long epId;
    /** 品牌ID */
    private java.lang.Long brandId;
    /** 荣誉ID */
    private java.lang.Long honorId;
    /** 荣誉描述 */
    private java.lang.String honorDes;
    /** 证书编号 */
    private java.lang.String honorNo;
    /** 发证日期 */
    private java.util.Date certDate;
    /** 发证单位 */
    private java.lang.String certIssuer;
    /**
     * <p>默认构造函数。</p>
     */
    public SlEpBrandHonor() {

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
     * <p>品牌ID。</p>
     *
     * @return the 品牌ID
     */
    public java.lang.Long getBrandId() {
        return brandId;
    }

    /**
     * <p>品牌ID。</p>
     *
     * @param brandId 品牌ID。
     */
    public void setBrandId(java.lang.Long brandId) {
        this.brandId = brandId;
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
    public java.lang.String getHonorDes() {
        return honorDes;
    }

    /**
     * <p>荣誉描述。</p>
     *
     * @param honorDes 荣誉描述。
     */
    public void setHonorDes(java.lang.String honorDes) {
        this.honorDes = honorDes;
    }

    /**
     * <p>证书编号。</p>
     *
     * @return the 证书编号
     */
    public java.lang.String getHonorNo() {
        return honorNo;
    }

    /**
     * <p>证书编号。</p>
     *
     * @param honorNo 证书编号。
     */
    public void setHonorNo(java.lang.String honorNo) {
        this.honorNo = honorNo;
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
