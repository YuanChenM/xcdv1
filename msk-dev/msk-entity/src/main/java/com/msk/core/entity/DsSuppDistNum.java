/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表ds_supp_dist_num对应的DsSuppDistNum。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class DsSuppDistNum extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 供应分销流水ID */
    private java.lang.Long suppDsId;
    /** 分销月度 */
    private java.lang.String distMonth;
    /** 物流区编号 */
    private java.lang.String lgcsCode;
    /** 供应商编号 */
    private java.lang.String suppCode;
    /** 产品编码 */
    private java.lang.String pdCode;
    /** 1:神农先生 2:神农客 3:神农人家 */
    private java.lang.Integer brandType;
    /** 分销通道 */
    private java.lang.Integer distType;
    /** 分销数量 */
    private java.math.BigDecimal distNum;
    /**
     * <p>默认构造函数。</p>
     */
    public DsSuppDistNum() {

    }

    /**
     * <p>供应分销流水ID。</p>
     *
     * @return the 供应分销流水ID
     */
    public java.lang.Long getSuppDsId() {
        return suppDsId;
    }

    /**
     * <p>供应分销流水ID。</p>
     *
     * @param suppDsId 供应分销流水ID。
     */
    public void setSuppDsId(java.lang.Long suppDsId) {
        this.suppDsId = suppDsId;
    }

    /**
     * <p>分销月度。</p>
     *
     * @return the 分销月度
     */
    public java.lang.String getDistMonth() {
        return distMonth;
    }

    /**
     * <p>分销月度。</p>
     *
     * @param distMonth 分销月度。
     */
    public void setDistMonth(java.lang.String distMonth) {
        this.distMonth = distMonth;
    }

    /**
     * <p>物流区编号。</p>
     *
     * @return the 物流区编号
     */
    public java.lang.String getLgcsCode() {
        return lgcsCode;
    }

    /**
     * <p>物流区编号。</p>
     *
     * @param lgcsCode 物流区编号。
     */
    public void setLgcsCode(java.lang.String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    /**
     * <p>供应商编号。</p>
     *
     * @return the 供应商编号
     */
    public java.lang.String getSuppCode() {
        return suppCode;
    }

    /**
     * <p>供应商编号。</p>
     *
     * @param suppCode 供应商编号。
     */
    public void setSuppCode(java.lang.String suppCode) {
        this.suppCode = suppCode;
    }

    /**
     * <p>产品编码。</p>
     *
     * @return the 产品编码
     */
    public java.lang.String getPdCode() {
        return pdCode;
    }

    /**
     * <p>产品编码。</p>
     *
     * @param pdCode 产品编码。
     */
    public void setPdCode(java.lang.String pdCode) {
        this.pdCode = pdCode;
    }

    /**
     * <p>1:神农先生 2:神农客 3:神农人家。</p>
     *
     * @return the 1:神农先生 2:神农客 3:神农人家
     */
    public java.lang.Integer getBrandType() {
        return brandType;
    }

    /**
     * <p>1:神农先生 2:神农客 3:神农人家。</p>
     *
     * @param brandType 1:神农先生 2:神农客 3:神农人家。
     */
    public void setBrandType(java.lang.Integer brandType) {
        this.brandType = brandType;
    }

    /**
     * <p>分销通道。</p>
     *
     * @return the 分销通道
     */
    public java.lang.Integer getDistType() {
        return distType;
    }

    /**
     * <p>分销通道。</p>
     *
     * @param distType 分销通道。
     */
    public void setDistType(java.lang.Integer distType) {
        this.distType = distType;
    }

    /**
     * <p>分销数量。</p>
     *
     * @return the 分销数量
     */
    public java.math.BigDecimal getDistNum() {
        return distNum;
    }

    /**
     * <p>分销数量。</p>
     *
     * @param distNum 分销数量。
     */
    public void setDistNum(java.math.BigDecimal distNum) {
        this.distNum = distNum;
    }

}
