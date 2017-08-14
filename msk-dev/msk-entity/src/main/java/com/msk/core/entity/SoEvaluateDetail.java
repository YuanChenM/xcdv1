/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表so_evaluate_detail对应的SoEvaluateDetail。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SoEvaluateDetail extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 明细ID */
    private Long detailId;
    /** 评价ID */
    private Long evaluateId;
    /** 配送日期 */
    private java.util.Date proDate;
    /** 产品编码 */
    private String pdCode;
    /** 评价描述 */
    private String evaluateDesc;
    /** 评价备注 */
    private String evaluateRemark;
    /** 评价评分 */
    private Integer evaluateScore;
    /** 评价图片 */
    private String evaluateImg;
    /**
     * <p>默认构造函数。</p>
     */
    public SoEvaluateDetail() {

    }

    /**
     * <p>明细ID。</p>
     *
     * @return the 明细ID
     */
    public Long getDetailId() {
        return detailId;
    }

    /**
     * <p>明细ID。</p>
     *
     * @param detailId 明细ID。
     */
    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    /**
     * <p>评价ID。</p>
     *
     * @return the 评价ID
     */
    public Long getEvaluateId() {
        return evaluateId;
    }

    /**
     * <p>评价ID。</p>
     *
     * @param evaluateId 评价ID。
     */
    public void setEvaluateId(Long evaluateId) {
        this.evaluateId = evaluateId;
    }

    /**
     * <p>配送日期。</p>
     *
     * @return the 配送日期
     */
    public java.util.Date getProDate() {
        return proDate;
    }

    /**
     * <p>配送日期。</p>
     *
     * @param proDate 配送日期。
     */
    public void setProDate(java.util.Date proDate) {
        this.proDate = proDate;
    }

    /**
     * <p>产品编码。</p>
     *
     * @return the 产品编码
     */
    public String getPdCode() {
        return pdCode;
    }

    /**
     * <p>产品编码。</p>
     *
     * @param pdCode 产品编码。
     */
    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    /**
     * <p>评价描述。</p>
     *
     * @return the 评价描述
     */
    public String getEvaluateDesc() {
        return evaluateDesc;
    }

    /**
     * <p>评价描述。</p>
     *
     * @param evaluateDesc 评价描述。
     */
    public void setEvaluateDesc(String evaluateDesc) {
        this.evaluateDesc = evaluateDesc;
    }

    /**
     * <p>评价备注。</p>
     *
     * @return the 评价备注
     */
    public String getEvaluateRemark() {
        return evaluateRemark;
    }

    /**
     * <p>评价备注。</p>
     *
     * @param evaluateRemark 评价备注。
     */
    public void setEvaluateRemark(String evaluateRemark) {
        this.evaluateRemark = evaluateRemark;
    }

    public Integer getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(Integer evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    /**
     * <p>评价图片。</p>
     *
     * @return the 评价图片
     */
    public String getEvaluateImg() {
        return evaluateImg;
    }

    /**
     * <p>评价图片。</p>
     *
     * @param evaluateImg 评价图片。
     */
    public void setEvaluateImg(String evaluateImg) {
        this.evaluateImg = evaluateImg;
    }

}
