/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_product_status_his对应的SlProductStatusHis。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlProductStatusHis extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** HIS_ID */
    private java.lang.Long hisId;
    /** SL_CODE */
    private java.lang.String slCode;
    /** SL_PD_ID */
    private java.lang.Integer slPdId;
    /** PROD_EP_ID */
    private java.lang.Integer prodEpId;
    /** BRAND_EP_ID */
    private java.lang.Integer brandEpId;
    /** BRAND_ID */
    private java.lang.Integer brandId;
    /** PD_CLASSES_CODE */
    private java.lang.String pdClassesCode;
    /** MACHINING_CODE */
    private java.lang.String machiningCode;
    /** PD_BREED_CODE */
    private java.lang.String pdBreedCode;
    /** PD_FEATURE_CODE */
    private java.lang.String pdFeatureCode;
    /** WEIGHT_CODE */
    private java.lang.String weightCode;
    /** 0:否,1:是 */
    private java.lang.String distFlg;
    /** 0:否,1:是 */
    private java.lang.String distmskFlg;
    /** DISTMSK_RATE */
    private java.math.BigDecimal distmskRate;
    /** SL_TNC_STD */
    private java.lang.String slTncStd;
    /** SL_TNC_GRADE_CODE */
    private java.lang.Integer slTncGradeCode;
    /** TNC_NG_REASON */
    private java.lang.String tncNgReason;
    /** TNC_AUDIT_STATUS */
    private java.lang.Integer tncAuditStatus;
    /** TNC_AUDITOR */
    private java.lang.String tncAuditor;
    /** TNC_AUDIT_DATE */
    private java.util.Date tncAuditDate;
    /** TNC_MONITOR_RESULT */
    private java.lang.Integer tncMonitorResult;
    /** TNC_MONITOR_AUDITOR */
    private java.lang.String tncMonitorAuditor;
    /** TNC_MONITOR_DATE */
    private java.util.Date tncMonitorDate;
    /** SL_QLT_STD */
    private java.lang.String slQltStd;
    /** SL_QLT_GRADE_CODE */
    private java.lang.Integer slQltGradeCode;
    /** QLT_NG_REASON */
    private java.lang.String qltNgReason;
    /** QLT_AUDIT_STATUS */
    private java.lang.Integer qltAuditStatus;
    /** QLT_AUDITOR */
    private java.lang.String qltAuditor;
    /** QLT_AUDIT_DATE */
    private java.util.Date qltAuditDate;
    /** QLT_MONITOR_RESULT */
    private java.lang.Integer qltMonitorResult;
    /** QLT_MONITOR_AUDITOR */
    private java.lang.String qltMonitorAuditor;
    /** QLT_MONITOR_DATE */
    private java.util.Date qltMonitorDate;
    /** 1 申请中 2论证中 3禁止准入 4试销 5正式上线 6下线  7黑名单 */
    private java.lang.String status;
    /** STATUS_MONITOR_RESULT */
    private java.lang.Integer statusMonitorResult;
    /** STATUS_MONITOR_AUDITOR */
    private java.lang.String statusMonitorAuditor;
    /** STATUS_MONITOR_DATE */
    private java.util.Date statusMonitorDate;
    /**
     * <p>默认构造函数。</p>
     */
    public SlProductStatusHis() {

    }

    /**
     * <p>HIS_ID。</p>
     *
     * @return the HIS_ID
     */
    public java.lang.Long getHisId() {
        return hisId;
    }

    /**
     * <p>HIS_ID。</p>
     *
     * @param hisId HIS_ID。
     */
    public void setHisId(java.lang.Long hisId) {
        this.hisId = hisId;
    }

    /**
     * <p>SL_CODE。</p>
     *
     * @return the SL_CODE
     */
    public java.lang.String getSlCode() {
        return slCode;
    }

    /**
     * <p>SL_CODE。</p>
     *
     * @param slCode SL_CODE。
     */
    public void setSlCode(java.lang.String slCode) {
        this.slCode = slCode;
    }

    /**
     * <p>SL_PD_ID。</p>
     *
     * @return the SL_PD_ID
     */
    public java.lang.Integer getSlPdId() {
        return slPdId;
    }

    /**
     * <p>SL_PD_ID。</p>
     *
     * @param slPdId SL_PD_ID。
     */
    public void setSlPdId(java.lang.Integer slPdId) {
        this.slPdId = slPdId;
    }

    /**
     * <p>PROD_EP_ID。</p>
     *
     * @return the PROD_EP_ID
     */
    public java.lang.Integer getProdEpId() {
        return prodEpId;
    }

    /**
     * <p>PROD_EP_ID。</p>
     *
     * @param prodEpId PROD_EP_ID。
     */
    public void setProdEpId(java.lang.Integer prodEpId) {
        this.prodEpId = prodEpId;
    }

    /**
     * <p>BRAND_EP_ID。</p>
     *
     * @return the BRAND_EP_ID
     */
    public java.lang.Integer getBrandEpId() {
        return brandEpId;
    }

    /**
     * <p>BRAND_EP_ID。</p>
     *
     * @param brandEpId BRAND_EP_ID。
     */
    public void setBrandEpId(java.lang.Integer brandEpId) {
        this.brandEpId = brandEpId;
    }

    /**
     * <p>BRAND_ID。</p>
     *
     * @return the BRAND_ID
     */
    public java.lang.Integer getBrandId() {
        return brandId;
    }

    /**
     * <p>BRAND_ID。</p>
     *
     * @param brandId BRAND_ID。
     */
    public void setBrandId(java.lang.Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * <p>PD_CLASSES_CODE。</p>
     *
     * @return the PD_CLASSES_CODE
     */
    public java.lang.String getPdClassesCode() {
        return pdClassesCode;
    }

    /**
     * <p>PD_CLASSES_CODE。</p>
     *
     * @param pdClassesCode PD_CLASSES_CODE。
     */
    public void setPdClassesCode(java.lang.String pdClassesCode) {
        this.pdClassesCode = pdClassesCode;
    }

    /**
     * <p>MACHINING_CODE。</p>
     *
     * @return the MACHINING_CODE
     */
    public java.lang.String getMachiningCode() {
        return machiningCode;
    }

    /**
     * <p>MACHINING_CODE。</p>
     *
     * @param machiningCode MACHINING_CODE。
     */
    public void setMachiningCode(java.lang.String machiningCode) {
        this.machiningCode = machiningCode;
    }

    /**
     * <p>PD_BREED_CODE。</p>
     *
     * @return the PD_BREED_CODE
     */
    public java.lang.String getPdBreedCode() {
        return pdBreedCode;
    }

    /**
     * <p>PD_BREED_CODE。</p>
     *
     * @param pdBreedCode PD_BREED_CODE。
     */
    public void setPdBreedCode(java.lang.String pdBreedCode) {
        this.pdBreedCode = pdBreedCode;
    }

    /**
     * <p>PD_FEATURE_CODE。</p>
     *
     * @return the PD_FEATURE_CODE
     */
    public java.lang.String getPdFeatureCode() {
        return pdFeatureCode;
    }

    /**
     * <p>PD_FEATURE_CODE。</p>
     *
     * @param pdFeatureCode PD_FEATURE_CODE。
     */
    public void setPdFeatureCode(java.lang.String pdFeatureCode) {
        this.pdFeatureCode = pdFeatureCode;
    }

    /**
     * <p>WEIGHT_CODE。</p>
     *
     * @return the WEIGHT_CODE
     */
    public java.lang.String getWeightCode() {
        return weightCode;
    }

    /**
     * <p>WEIGHT_CODE。</p>
     *
     * @param weightCode WEIGHT_CODE。
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
     * <p>DISTMSK_RATE。</p>
     *
     * @return the DISTMSK_RATE
     */
    public java.math.BigDecimal getDistmskRate() {
        return distmskRate;
    }

    /**
     * <p>DISTMSK_RATE。</p>
     *
     * @param distmskRate DISTMSK_RATE。
     */
    public void setDistmskRate(java.math.BigDecimal distmskRate) {
        this.distmskRate = distmskRate;
    }

    /**
     * <p>SL_TNC_STD。</p>
     *
     * @return the SL_TNC_STD
     */
    public java.lang.String getSlTncStd() {
        return slTncStd;
    }

    /**
     * <p>SL_TNC_STD。</p>
     *
     * @param slTncStd SL_TNC_STD。
     */
    public void setSlTncStd(java.lang.String slTncStd) {
        this.slTncStd = slTncStd;
    }

    /**
     * <p>SL_TNC_GRADE_CODE。</p>
     *
     * @return the SL_TNC_GRADE_CODE
     */
    public java.lang.Integer getSlTncGradeCode() {
        return slTncGradeCode;
    }

    /**
     * <p>SL_TNC_GRADE_CODE。</p>
     *
     * @param slTncGradeCode SL_TNC_GRADE_CODE。
     */
    public void setSlTncGradeCode(java.lang.Integer slTncGradeCode) {
        this.slTncGradeCode = slTncGradeCode;
    }

    /**
     * <p>TNC_NG_REASON。</p>
     *
     * @return the TNC_NG_REASON
     */
    public java.lang.String getTncNgReason() {
        return tncNgReason;
    }

    /**
     * <p>TNC_NG_REASON。</p>
     *
     * @param tncNgReason TNC_NG_REASON。
     */
    public void setTncNgReason(java.lang.String tncNgReason) {
        this.tncNgReason = tncNgReason;
    }

    /**
     * <p>TNC_AUDIT_STATUS。</p>
     *
     * @return the TNC_AUDIT_STATUS
     */
    public java.lang.Integer getTncAuditStatus() {
        return tncAuditStatus;
    }

    /**
     * <p>TNC_AUDIT_STATUS。</p>
     *
     * @param tncAuditStatus TNC_AUDIT_STATUS。
     */
    public void setTncAuditStatus(java.lang.Integer tncAuditStatus) {
        this.tncAuditStatus = tncAuditStatus;
    }

    /**
     * <p>TNC_AUDITOR。</p>
     *
     * @return the TNC_AUDITOR
     */
    public java.lang.String getTncAuditor() {
        return tncAuditor;
    }

    /**
     * <p>TNC_AUDITOR。</p>
     *
     * @param tncAuditor TNC_AUDITOR。
     */
    public void setTncAuditor(java.lang.String tncAuditor) {
        this.tncAuditor = tncAuditor;
    }

    /**
     * <p>TNC_AUDIT_DATE。</p>
     *
     * @return the TNC_AUDIT_DATE
     */
    public java.util.Date getTncAuditDate() {
        return tncAuditDate;
    }

    /**
     * <p>TNC_AUDIT_DATE。</p>
     *
     * @param tncAuditDate TNC_AUDIT_DATE。
     */
    public void setTncAuditDate(java.util.Date tncAuditDate) {
        this.tncAuditDate = tncAuditDate;
    }

    /**
     * <p>TNC_MONITOR_RESULT。</p>
     *
     * @return the TNC_MONITOR_RESULT
     */
    public java.lang.Integer getTncMonitorResult() {
        return tncMonitorResult;
    }

    /**
     * <p>TNC_MONITOR_RESULT。</p>
     *
     * @param tncMonitorResult TNC_MONITOR_RESULT。
     */
    public void setTncMonitorResult(java.lang.Integer tncMonitorResult) {
        this.tncMonitorResult = tncMonitorResult;
    }

    /**
     * <p>TNC_MONITOR_AUDITOR。</p>
     *
     * @return the TNC_MONITOR_AUDITOR
     */
    public java.lang.String getTncMonitorAuditor() {
        return tncMonitorAuditor;
    }

    /**
     * <p>TNC_MONITOR_AUDITOR。</p>
     *
     * @param tncMonitorAuditor TNC_MONITOR_AUDITOR。
     */
    public void setTncMonitorAuditor(java.lang.String tncMonitorAuditor) {
        this.tncMonitorAuditor = tncMonitorAuditor;
    }

    /**
     * <p>TNC_MONITOR_DATE。</p>
     *
     * @return the TNC_MONITOR_DATE
     */
    public java.util.Date getTncMonitorDate() {
        return tncMonitorDate;
    }

    /**
     * <p>TNC_MONITOR_DATE。</p>
     *
     * @param tncMonitorDate TNC_MONITOR_DATE。
     */
    public void setTncMonitorDate(java.util.Date tncMonitorDate) {
        this.tncMonitorDate = tncMonitorDate;
    }

    /**
     * <p>SL_QLT_STD。</p>
     *
     * @return the SL_QLT_STD
     */
    public java.lang.String getSlQltStd() {
        return slQltStd;
    }

    /**
     * <p>SL_QLT_STD。</p>
     *
     * @param slQltStd SL_QLT_STD。
     */
    public void setSlQltStd(java.lang.String slQltStd) {
        this.slQltStd = slQltStd;
    }

    /**
     * <p>SL_QLT_GRADE_CODE。</p>
     *
     * @return the SL_QLT_GRADE_CODE
     */
    public java.lang.Integer getSlQltGradeCode() {
        return slQltGradeCode;
    }

    /**
     * <p>SL_QLT_GRADE_CODE。</p>
     *
     * @param slQltGradeCode SL_QLT_GRADE_CODE。
     */
    public void setSlQltGradeCode(java.lang.Integer slQltGradeCode) {
        this.slQltGradeCode = slQltGradeCode;
    }

    /**
     * <p>QLT_NG_REASON。</p>
     *
     * @return the QLT_NG_REASON
     */
    public java.lang.String getQltNgReason() {
        return qltNgReason;
    }

    /**
     * <p>QLT_NG_REASON。</p>
     *
     * @param qltNgReason QLT_NG_REASON。
     */
    public void setQltNgReason(java.lang.String qltNgReason) {
        this.qltNgReason = qltNgReason;
    }

    /**
     * <p>QLT_AUDIT_STATUS。</p>
     *
     * @return the QLT_AUDIT_STATUS
     */
    public java.lang.Integer getQltAuditStatus() {
        return qltAuditStatus;
    }

    /**
     * <p>QLT_AUDIT_STATUS。</p>
     *
     * @param qltAuditStatus QLT_AUDIT_STATUS。
     */
    public void setQltAuditStatus(java.lang.Integer qltAuditStatus) {
        this.qltAuditStatus = qltAuditStatus;
    }

    /**
     * <p>QLT_AUDITOR。</p>
     *
     * @return the QLT_AUDITOR
     */
    public java.lang.String getQltAuditor() {
        return qltAuditor;
    }

    /**
     * <p>QLT_AUDITOR。</p>
     *
     * @param qltAuditor QLT_AUDITOR。
     */
    public void setQltAuditor(java.lang.String qltAuditor) {
        this.qltAuditor = qltAuditor;
    }

    /**
     * <p>QLT_AUDIT_DATE。</p>
     *
     * @return the QLT_AUDIT_DATE
     */
    public java.util.Date getQltAuditDate() {
        return qltAuditDate;
    }

    /**
     * <p>QLT_AUDIT_DATE。</p>
     *
     * @param qltAuditDate QLT_AUDIT_DATE。
     */
    public void setQltAuditDate(java.util.Date qltAuditDate) {
        this.qltAuditDate = qltAuditDate;
    }

    /**
     * <p>QLT_MONITOR_RESULT。</p>
     *
     * @return the QLT_MONITOR_RESULT
     */
    public java.lang.Integer getQltMonitorResult() {
        return qltMonitorResult;
    }

    /**
     * <p>QLT_MONITOR_RESULT。</p>
     *
     * @param qltMonitorResult QLT_MONITOR_RESULT。
     */
    public void setQltMonitorResult(java.lang.Integer qltMonitorResult) {
        this.qltMonitorResult = qltMonitorResult;
    }

    /**
     * <p>QLT_MONITOR_AUDITOR。</p>
     *
     * @return the QLT_MONITOR_AUDITOR
     */
    public java.lang.String getQltMonitorAuditor() {
        return qltMonitorAuditor;
    }

    /**
     * <p>QLT_MONITOR_AUDITOR。</p>
     *
     * @param qltMonitorAuditor QLT_MONITOR_AUDITOR。
     */
    public void setQltMonitorAuditor(java.lang.String qltMonitorAuditor) {
        this.qltMonitorAuditor = qltMonitorAuditor;
    }

    /**
     * <p>QLT_MONITOR_DATE。</p>
     *
     * @return the QLT_MONITOR_DATE
     */
    public java.util.Date getQltMonitorDate() {
        return qltMonitorDate;
    }

    /**
     * <p>QLT_MONITOR_DATE。</p>
     *
     * @param qltMonitorDate QLT_MONITOR_DATE。
     */
    public void setQltMonitorDate(java.util.Date qltMonitorDate) {
        this.qltMonitorDate = qltMonitorDate;
    }

    /**
     * <p>1 申请中 2论证中 3禁止准入 4试销 5正式上线 6下线  7黑名单。</p>
     *
     * @return the 1 申请中 2论证中 3禁止准入 4试销 5正式上线 6下线  7黑名单
     */
    public java.lang.String getStatus() {
        return status;
    }

    /**
     * <p>1 申请中 2论证中 3禁止准入 4试销 5正式上线 6下线  7黑名单。</p>
     *
     * @param status 1 申请中 2论证中 3禁止准入 4试销 5正式上线 6下线  7黑名单。
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    /**
     * <p>STATUS_MONITOR_RESULT。</p>
     *
     * @return the STATUS_MONITOR_RESULT
     */
    public java.lang.Integer getStatusMonitorResult() {
        return statusMonitorResult;
    }

    /**
     * <p>STATUS_MONITOR_RESULT。</p>
     *
     * @param statusMonitorResult STATUS_MONITOR_RESULT。
     */
    public void setStatusMonitorResult(java.lang.Integer statusMonitorResult) {
        this.statusMonitorResult = statusMonitorResult;
    }

    /**
     * <p>STATUS_MONITOR_AUDITOR。</p>
     *
     * @return the STATUS_MONITOR_AUDITOR
     */
    public java.lang.String getStatusMonitorAuditor() {
        return statusMonitorAuditor;
    }

    /**
     * <p>STATUS_MONITOR_AUDITOR。</p>
     *
     * @param statusMonitorAuditor STATUS_MONITOR_AUDITOR。
     */
    public void setStatusMonitorAuditor(java.lang.String statusMonitorAuditor) {
        this.statusMonitorAuditor = statusMonitorAuditor;
    }

    /**
     * <p>STATUS_MONITOR_DATE。</p>
     *
     * @return the STATUS_MONITOR_DATE
     */
    public java.util.Date getStatusMonitorDate() {
        return statusMonitorDate;
    }

    /**
     * <p>STATUS_MONITOR_DATE。</p>
     *
     * @param statusMonitorDate STATUS_MONITOR_DATE。
     */
    public void setStatusMonitorDate(java.util.Date statusMonitorDate) {
        this.statusMonitorDate = statusMonitorDate;
    }

}
