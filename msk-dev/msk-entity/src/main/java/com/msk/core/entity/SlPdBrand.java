/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_pd_brand对应的SlPdBrand。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlPdBrand extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 卖家编码 */
    private java.lang.String slCode;
    /** 品牌所属企业ID */
    private java.lang.Long brandEpId;
    /** 品牌ID */
    private java.lang.Long brandId;
    /** 品牌名称 */
    private java.lang.String brandName;
    /** 1:自有品牌,2:代理品牌 */
    private java.lang.Integer brandType;
    /** 0:卖家独立品牌,1 :神农先生联合,2:神农客联合3:神农人家联合 */
    private java.lang.String brandClass;
    /** 代理及分销授权合同号 */
    private java.lang.String contractNo;
    /** 有效期开始 */
    private java.util.Date termBegin;
    /** 有效期截止 */
    private java.util.Date termEnd;
    /**
     * <p>默认构造函数。</p>
     */
    public SlPdBrand() {

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
     * <p>品牌所属企业ID。</p>
     *
     * @return the 品牌所属企业ID
     */
    public java.lang.Long getBrandEpId() {
        return brandEpId;
    }

    /**
     * <p>品牌所属企业ID。</p>
     *
     * @param brandEpId 品牌所属企业ID。
     */
    public void setBrandEpId(java.lang.Long brandEpId) {
        this.brandEpId = brandEpId;
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
     * <p>品牌名称。</p>
     *
     * @return the 品牌名称
     */
    public java.lang.String getBrandName() {
        return brandName;
    }

    /**
     * <p>品牌名称。</p>
     *
     * @param brandName 品牌名称。
     */
    public void setBrandName(java.lang.String brandName) {
        this.brandName = brandName;
    }

    /**
     * <p>1:自有品牌,2:代理品牌。</p>
     *
     * @return the 1:自有品牌,2:代理品牌
     */
    public java.lang.Integer getBrandType() {
        return brandType;
    }

    /**
     * <p>1:自有品牌,2:代理品牌。</p>
     *
     * @param brandType 1:自有品牌,2:代理品牌。
     */
    public void setBrandType(java.lang.Integer brandType) {
        this.brandType = brandType;
    }

    /**
     * <p>0:卖家独立品牌,1 :神农先生联合,2:神农客联合3:神农人家联合。</p>
     *
     * @return the 0:卖家独立品牌,1 :神农先生联合,2:神农客联合3:神农人家联合
     */
    public java.lang.String getBrandClass() {
        return brandClass;
    }

    /**
     * <p>0:卖家独立品牌,1 :神农先生联合,2:神农客联合3:神农人家联合。</p>
     *
     * @param brandClass 0:卖家独立品牌,1 :神农先生联合,2:神农客联合3:神农人家联合。
     */
    public void setBrandClass(java.lang.String brandClass) {
        this.brandClass = brandClass;
    }

    /**
     * <p>代理及分销授权合同号。</p>
     *
     * @return the 代理及分销授权合同号
     */
    public java.lang.String getContractNo() {
        return contractNo;
    }

    /**
     * <p>代理及分销授权合同号。</p>
     *
     * @param contractNo 代理及分销授权合同号。
     */
    public void setContractNo(java.lang.String contractNo) {
        this.contractNo = contractNo;
    }

    /**
     * <p>有效期开始。</p>
     *
     * @return the 有效期开始
     */
    public java.util.Date getTermBegin() {
        return termBegin;
    }

    /**
     * <p>有效期开始。</p>
     *
     * @param termBegin 有效期开始。
     */
    public void setTermBegin(java.util.Date termBegin) {
        this.termBegin = termBegin;
    }

    /**
     * <p>有效期截止。</p>
     *
     * @return the 有效期截止
     */
    public java.util.Date getTermEnd() {
        return termEnd;
    }

    /**
     * <p>有效期截止。</p>
     *
     * @param termEnd 有效期截止。
     */
    public void setTermEnd(java.util.Date termEnd) {
        this.termEnd = termEnd;
    }

}
