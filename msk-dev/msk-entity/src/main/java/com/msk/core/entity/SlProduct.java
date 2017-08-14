/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_product对应的SlProduct。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlProduct extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 卖家编码 */
    private java.lang.String slCode;
    /** 卖家产品ID */
    private java.lang.Integer slPdId;
    /** 生产商企业ID */
    private java.lang.Integer prodEpId;
    /** 品牌商企业ID */
    private java.lang.Integer brandEpId;
    /** 产品品牌ID */
    private java.lang.Integer brandId;
    /** 产品类别 */
    private java.lang.String pdClassesCode;
    /** 产品二级分类编码 */
    private java.lang.String machiningCode;
    /** 产品品种 */
    private java.lang.String pdBreedCode;
    /** 产品特征 */
    private java.lang.String pdFeatureCode;
    /** 净重编码 */
    private java.lang.String weightCode;
    /** 0:否,1:是 */
    private java.lang.String distFlg;
    /** 0:否,1:是 */
    private java.lang.String distmskFlg;
    /** 美侍客分销折扣率 */
    private java.math.BigDecimal distmskRate;
    /** 卖家产品技术标准 */
    private java.lang.String slTncStd;
    /** 产品技术标准定级(加工质量标准) */
    private java.lang.Integer slTncGradeCode;
    /** 产品技术标准定级不通过理由 */
    private java.lang.String tncNgReason;
    /** 产品技术标准定级状态 */
    private java.lang.Integer tncAuditStatus;
    /** 产品技术标准定级人 */
    private java.lang.String tncAuditor;
    /** 产品技术标准定级日期 */
    private java.util.Date tncAuditDate;
    /** 产品技术标准定级监控人审核意见 */
    private java.lang.Integer tncMonitorResult;
    /** 产品技术标准定级监控人 */
    private java.lang.String tncMonitorAuditor;
    /** 产品技术标准定级监控人审核日期 */
    private java.util.Date tncMonitorDate;
    /** 卖家产品质量标准（加工技术标准） */
    private java.lang.String slQltStd;
    /** 产品质量标准定级 */
    private java.lang.Integer slQltGradeCode;
    /** 产品质量标准定级不通过理由 */
    private java.lang.String qltNgReason;
    /** 产品质量标准定级状态 */
    private java.lang.Integer qltAuditStatus;
    /** 产品质量标准定级人 */
    private java.lang.String qltAuditor;
    /** 产品质量标准定级日期 */
    private java.util.Date qltAuditDate;
    /** 产品质量标准定级监控人审核意见 */
    private java.lang.Integer qltMonitorResult;
    /** 产品质量标准定级监控人 */
    private java.lang.String qltMonitorAuditor;
    /** 产品质量标准定级监控人审核日期 */
    private java.util.Date qltMonitorDate;
    /** 状态 */
    private java.lang.String status;
    /** 产品状态审核意见 */
    private java.lang.Integer statusMonitorResult;
    /** 产品状态审核人 */
    private java.lang.String statusMonitorAuditor;
    /** 产品状态审核日期 */
    private java.util.Date statusMonitorDate;
    /**
     * <p>默认构造函数。</p>
     */
    public SlProduct() {

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
     * <p>卖家产品ID。</p>
     *
     * @return the 卖家产品ID
     */
    public java.lang.Integer getSlPdId() {
        return slPdId;
    }

    /**
     * <p>卖家产品ID。</p>
     *
     * @param slPdId 卖家产品ID。
     */
    public void setSlPdId(java.lang.Integer slPdId) {
        this.slPdId = slPdId;
    }

    /**
     * <p>生产商企业ID。</p>
     *
     * @return the 生产商企业ID
     */
    public java.lang.Integer getProdEpId() {
        return prodEpId;
    }

    /**
     * <p>生产商企业ID。</p>
     *
     * @param prodEpId 生产商企业ID。
     */
    public void setProdEpId(java.lang.Integer prodEpId) {
        this.prodEpId = prodEpId;
    }

    /**
     * <p>品牌商企业ID。</p>
     *
     * @return the 品牌商企业ID
     */
    public java.lang.Integer getBrandEpId() {
        return brandEpId;
    }

    /**
     * <p>品牌商企业ID。</p>
     *
     * @param brandEpId 品牌商企业ID。
     */
    public void setBrandEpId(java.lang.Integer brandEpId) {
        this.brandEpId = brandEpId;
    }

    /**
     * <p>产品品牌ID。</p>
     *
     * @return the 产品品牌ID
     */
    public java.lang.Integer getBrandId() {
        return brandId;
    }

    /**
     * <p>产品品牌ID。</p>
     *
     * @param brandId 产品品牌ID。
     */
    public void setBrandId(java.lang.Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * <p>产品类别。</p>
     *
     * @return the 产品类别
     */
    public java.lang.String getPdClassesCode() {
        return pdClassesCode;
    }

    /**
     * <p>产品类别。</p>
     *
     * @param pdClassesCode 产品类别。
     */
    public void setPdClassesCode(java.lang.String pdClassesCode) {
        this.pdClassesCode = pdClassesCode;
    }

    /**
     * <p>产品二级分类编码。</p>
     *
     * @return the 产品二级分类编码
     */
    public java.lang.String getMachiningCode() {
        return machiningCode;
    }

    /**
     * <p>产品二级分类编码。</p>
     *
     * @param machiningCode 产品二级分类编码。
     */
    public void setMachiningCode(java.lang.String machiningCode) {
        this.machiningCode = machiningCode;
    }

    /**
     * <p>产品品种。</p>
     *
     * @return the 产品品种
     */
    public java.lang.String getPdBreedCode() {
        return pdBreedCode;
    }

    /**
     * <p>产品品种。</p>
     *
     * @param pdBreedCode 产品品种。
     */
    public void setPdBreedCode(java.lang.String pdBreedCode) {
        this.pdBreedCode = pdBreedCode;
    }

    /**
     * <p>产品特征。</p>
     *
     * @return the 产品特征
     */
    public java.lang.String getPdFeatureCode() {
        return pdFeatureCode;
    }

    /**
     * <p>产品特征。</p>
     *
     * @param pdFeatureCode 产品特征。
     */
    public void setPdFeatureCode(java.lang.String pdFeatureCode) {
        this.pdFeatureCode = pdFeatureCode;
    }

    /**
     * <p>净重编码。</p>
     *
     * @return the 净重编码
     */
    public java.lang.String getWeightCode() {
        return weightCode;
    }

    /**
     * <p>净重编码。</p>
     *
     * @param weightCode 净重编码。
     */
    public void setWeightCode(java.lang.String weightCode) {
        this.weightCode = weightCode;
    }

    /**
     * <p>0:否,1:是。</p>
     *
     * @return the 0:否,1:是
     */
    public java.lang.String getDistFlg() {
        return distFlg;
    }

    /**
     * <p>0:否,1:是。</p>
     *
     * @param distFlg 0:否,1:是。
     */
    public void setDistFlg(java.lang.String distFlg) {
        this.distFlg = distFlg;
    }

    /**
     * <p>0:否,1:是。</p>
     *
     * @return the 0:否,1:是
     */
    public java.lang.String getDistmskFlg() {
        return distmskFlg;
    }

    /**
     * <p>0:否,1:是。</p>
     *
     * @param distmskFlg 0:否,1:是。
     */
    public void setDistmskFlg(java.lang.String distmskFlg) {
        this.distmskFlg = distmskFlg;
    }

    /**
     * <p>美侍客分销折扣率。</p>
     *
     * @return the 美侍客分销折扣率
     */
    public java.math.BigDecimal getDistmskRate() {
        return distmskRate;
    }

    /**
     * <p>美侍客分销折扣率。</p>
     *
     * @param distmskRate 美侍客分销折扣率。
     */
    public void setDistmskRate(java.math.BigDecimal distmskRate) {
        this.distmskRate = distmskRate;
    }

    /**
     * <p>卖家产品技术标准。</p>
     *
     * @return the 卖家产品技术标准
     */
    public java.lang.String getSlTncStd() {
        return slTncStd;
    }

    /**
     * <p>卖家产品技术标准。</p>
     *
     * @param slTncStd 卖家产品技术标准。
     */
    public void setSlTncStd(java.lang.String slTncStd) {
        this.slTncStd = slTncStd;
    }

    /**
     * <p>产品技术标准定级(加工质量标准)。</p>
     *
     * @return the 产品技术标准定级(加工质量标准)
     */
    public java.lang.Integer getSlTncGradeCode() {
        return slTncGradeCode;
    }

    /**
     * <p>产品技术标准定级(加工质量标准)。</p>
     *
     * @param slTncGradeCode 产品技术标准定级(加工质量标准)。
     */
    public void setSlTncGradeCode(java.lang.Integer slTncGradeCode) {
        this.slTncGradeCode = slTncGradeCode;
    }

    /**
     * <p>产品技术标准定级不通过理由。</p>
     *
     * @return the 产品技术标准定级不通过理由
     */
    public java.lang.String getTncNgReason() {
        return tncNgReason;
    }

    /**
     * <p>产品技术标准定级不通过理由。</p>
     *
     * @param tncNgReason 产品技术标准定级不通过理由。
     */
    public void setTncNgReason(java.lang.String tncNgReason) {
        this.tncNgReason = tncNgReason;
    }

    /**
     * <p>产品技术标准定级状态。</p>
     *
     * @return the 产品技术标准定级状态
     */
    public java.lang.Integer getTncAuditStatus() {
        return tncAuditStatus;
    }

    /**
     * <p>产品技术标准定级状态。</p>
     *
     * @param tncAuditStatus 产品技术标准定级状态。
     */
    public void setTncAuditStatus(java.lang.Integer tncAuditStatus) {
        this.tncAuditStatus = tncAuditStatus;
    }

    /**
     * <p>产品技术标准定级人。</p>
     *
     * @return the 产品技术标准定级人
     */
    public java.lang.String getTncAuditor() {
        return tncAuditor;
    }

    /**
     * <p>产品技术标准定级人。</p>
     *
     * @param tncAuditor 产品技术标准定级人。
     */
    public void setTncAuditor(java.lang.String tncAuditor) {
        this.tncAuditor = tncAuditor;
    }

    /**
     * <p>产品技术标准定级日期。</p>
     *
     * @return the 产品技术标准定级日期
     */
    public java.util.Date getTncAuditDate() {
        return tncAuditDate;
    }

    /**
     * <p>产品技术标准定级日期。</p>
     *
     * @param tncAuditDate 产品技术标准定级日期。
     */
    public void setTncAuditDate(java.util.Date tncAuditDate) {
        this.tncAuditDate = tncAuditDate;
    }

    /**
     * <p>产品技术标准定级监控人审核意见。</p>
     *
     * @return the 产品技术标准定级监控人审核意见
     */
    public java.lang.Integer getTncMonitorResult() {
        return tncMonitorResult;
    }

    /**
     * <p>产品技术标准定级监控人审核意见。</p>
     *
     * @param tncMonitorResult 产品技术标准定级监控人审核意见。
     */
    public void setTncMonitorResult(java.lang.Integer tncMonitorResult) {
        this.tncMonitorResult = tncMonitorResult;
    }

    /**
     * <p>产品技术标准定级监控人。</p>
     *
     * @return the 产品技术标准定级监控人
     */
    public java.lang.String getTncMonitorAuditor() {
        return tncMonitorAuditor;
    }

    /**
     * <p>产品技术标准定级监控人。</p>
     *
     * @param tncMonitorAuditor 产品技术标准定级监控人。
     */
    public void setTncMonitorAuditor(java.lang.String tncMonitorAuditor) {
        this.tncMonitorAuditor = tncMonitorAuditor;
    }

    /**
     * <p>产品技术标准定级监控人审核日期。</p>
     *
     * @return the 产品技术标准定级监控人审核日期
     */
    public java.util.Date getTncMonitorDate() {
        return tncMonitorDate;
    }

    /**
     * <p>产品技术标准定级监控人审核日期。</p>
     *
     * @param tncMonitorDate 产品技术标准定级监控人审核日期。
     */
    public void setTncMonitorDate(java.util.Date tncMonitorDate) {
        this.tncMonitorDate = tncMonitorDate;
    }

    /**
     * <p>卖家产品质量标准（加工技术标准）。</p>
     *
     * @return the 卖家产品质量标准（加工技术标准）
     */
    public java.lang.String getSlQltStd() {
        return slQltStd;
    }

    /**
     * <p>卖家产品质量标准（加工技术标准）。</p>
     *
     * @param slQltStd 卖家产品质量标准（加工技术标准）。
     */
    public void setSlQltStd(java.lang.String slQltStd) {
        this.slQltStd = slQltStd;
    }

    /**
     * <p>产品质量标准定级。</p>
     *
     * @return the 产品质量标准定级
     */
    public java.lang.Integer getSlQltGradeCode() {
        return slQltGradeCode;
    }

    /**
     * <p>产品质量标准定级。</p>
     *
     * @param slQltGradeCode 产品质量标准定级。
     */
    public void setSlQltGradeCode(java.lang.Integer slQltGradeCode) {
        this.slQltGradeCode = slQltGradeCode;
    }

    /**
     * <p>产品质量标准定级不通过理由。</p>
     *
     * @return the 产品质量标准定级不通过理由
     */
    public java.lang.String getQltNgReason() {
        return qltNgReason;
    }

    /**
     * <p>产品质量标准定级不通过理由。</p>
     *
     * @param qltNgReason 产品质量标准定级不通过理由。
     */
    public void setQltNgReason(java.lang.String qltNgReason) {
        this.qltNgReason = qltNgReason;
    }

    /**
     * <p>产品质量标准定级状态。</p>
     *
     * @return the 产品质量标准定级状态
     */
    public java.lang.Integer getQltAuditStatus() {
        return qltAuditStatus;
    }

    /**
     * <p>产品质量标准定级状态。</p>
     *
     * @param qltAuditStatus 产品质量标准定级状态。
     */
    public void setQltAuditStatus(java.lang.Integer qltAuditStatus) {
        this.qltAuditStatus = qltAuditStatus;
    }

    /**
     * <p>产品质量标准定级人。</p>
     *
     * @return the 产品质量标准定级人
     */
    public java.lang.String getQltAuditor() {
        return qltAuditor;
    }

    /**
     * <p>产品质量标准定级人。</p>
     *
     * @param qltAuditor 产品质量标准定级人。
     */
    public void setQltAuditor(java.lang.String qltAuditor) {
        this.qltAuditor = qltAuditor;
    }

    /**
     * <p>产品质量标准定级日期。</p>
     *
     * @return the 产品质量标准定级日期
     */
    public java.util.Date getQltAuditDate() {
        return qltAuditDate;
    }

    /**
     * <p>产品质量标准定级日期。</p>
     *
     * @param qltAuditDate 产品质量标准定级日期。
     */
    public void setQltAuditDate(java.util.Date qltAuditDate) {
        this.qltAuditDate = qltAuditDate;
    }

    /**
     * <p>产品质量标准定级监控人审核意见。</p>
     *
     * @return the 产品质量标准定级监控人审核意见
     */
    public java.lang.Integer getQltMonitorResult() {
        return qltMonitorResult;
    }

    /**
     * <p>产品质量标准定级监控人审核意见。</p>
     *
     * @param qltMonitorResult 产品质量标准定级监控人审核意见。
     */
    public void setQltMonitorResult(java.lang.Integer qltMonitorResult) {
        this.qltMonitorResult = qltMonitorResult;
    }

    /**
     * <p>产品质量标准定级监控人。</p>
     *
     * @return the 产品质量标准定级监控人
     */
    public java.lang.String getQltMonitorAuditor() {
        return qltMonitorAuditor;
    }

    /**
     * <p>产品质量标准定级监控人。</p>
     *
     * @param qltMonitorAuditor 产品质量标准定级监控人。
     */
    public void setQltMonitorAuditor(java.lang.String qltMonitorAuditor) {
        this.qltMonitorAuditor = qltMonitorAuditor;
    }

    /**
     * <p>产品质量标准定级监控人审核日期。</p>
     *
     * @return the 产品质量标准定级监控人审核日期
     */
    public java.util.Date getQltMonitorDate() {
        return qltMonitorDate;
    }

    /**
     * <p>产品质量标准定级监控人审核日期。</p>
     *
     * @param qltMonitorDate 产品质量标准定级监控人审核日期。
     */
    public void setQltMonitorDate(java.util.Date qltMonitorDate) {
        this.qltMonitorDate = qltMonitorDate;
    }

    /**
     * <p>状态。</p>
     *
     * @return the 状态
     */
    public java.lang.String getStatus() {
        return status;
    }

    /**
     * <p>状态。</p>
     *
     * @param status 状态。
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    /**
     * <p>产品状态审核意见。</p>
     *
     * @return the 产品状态审核意见
     */
    public java.lang.Integer getStatusMonitorResult() {
        return statusMonitorResult;
    }

    /**
     * <p>产品状态审核意见。</p>
     *
     * @param statusMonitorResult 产品状态审核意见。
     */
    public void setStatusMonitorResult(java.lang.Integer statusMonitorResult) {
        this.statusMonitorResult = statusMonitorResult;
    }

    /**
     * <p>产品状态审核人。</p>
     *
     * @return the 产品状态审核人
     */
    public java.lang.String getStatusMonitorAuditor() {
        return statusMonitorAuditor;
    }

    /**
     * <p>产品状态审核人。</p>
     *
     * @param statusMonitorAuditor 产品状态审核人。
     */
    public void setStatusMonitorAuditor(java.lang.String statusMonitorAuditor) {
        this.statusMonitorAuditor = statusMonitorAuditor;
    }

    /**
     * <p>产品状态审核日期。</p>
     *
     * @return the 产品状态审核日期
     */
    public java.util.Date getStatusMonitorDate() {
        return statusMonitorDate;
    }

    /**
     * <p>产品状态审核日期。</p>
     *
     * @param statusMonitorDate 产品状态审核日期。
     */
    public void setStatusMonitorDate(java.util.Date statusMonitorDate) {
        this.statusMonitorDate = statusMonitorDate;
    }

}
