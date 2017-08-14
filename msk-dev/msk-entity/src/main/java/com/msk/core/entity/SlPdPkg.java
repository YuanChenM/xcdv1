/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_pd_pkg对应的SlPdPkg。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlPdPkg extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 卖家编码 */
    private java.lang.String slCode;
    /** 卖家产品ID */
    private java.lang.Integer slPdId;
    /** 卖家产品包装ID */
    private java.lang.Integer slPdPkgId;
    /** 产品标准ID */
    private java.lang.Integer standardId;
    /** (卖家编码+卖家产品ID)内顺序号 */
    private java.lang.String pkgCode;
    /** 生产商企业ID */
    private java.lang.Integer prodEpId;
    /** 品牌商企业ID */
    private java.lang.Integer brandEpId;
    /** 产品品牌ID */
    private java.lang.Integer brandId;
    /** 产品类别 */
    private java.lang.String pdClassesCode;
    /** 产品品种 */
    private java.lang.String pdBreedCode;
    /** 产品特征 */
    private java.lang.String pdFeatureCode;
    /** 内包装_单个产品规格净重 */
    private java.lang.String inSglNw;
    /** 内包装_单个产品规格净重误差范围 */
    private java.lang.String inSglNwRange;
    /** 内包装_净重 */
    private java.math.BigDecimal inNw;
    /** 内包装_个数 */
    private java.lang.String inNumber;
    /** 内包装_尺寸 */
    private java.lang.String inSize;
    /** 内包装_材质及技术标准 */
    private java.lang.String inMts;
    /** 外包装_规格 */
    private java.lang.String outSpec;
    /** 外包装_净重 */
    private java.math.BigDecimal outNw;
    /** 外包装_毛重 */
    private java.lang.String outGw;
    /** 外包装_尺寸 */
    private java.lang.String outSize;
    /** 外包装_材质及技术标准 */
    private java.lang.String outMts;
    /** 第十种包装信息 */
    private java.lang.String pkgTen;
    /** 外包装长 */
    private java.math.BigDecimal outLength;
    /** 外包装宽 */
    private java.math.BigDecimal outWidth;
    /** 外包装高 */
    private java.math.BigDecimal outHeight;
    /** 外包装体积 */
    private java.math.BigDecimal outVolume;
    /** 0:待审核,1:审核完成,2:重新审核 */
    private java.lang.Integer auditStatus;
    /** 1:同意,2:增加标准包装规格,3:要求执行神农客标准 */
    private java.lang.Integer auditResult;
    /** 审核结果说明 */
    private java.lang.String auditResultDesc;
    /** 审核人 */
    private java.lang.String auditor;
    /** 审核日期 */
    private java.util.Date auditDate;
    /** 0:待审核,1:同意,2:不同意 */
    private java.lang.Integer monitorResult;
    /** 监控人 */
    private java.lang.String monitorAuditor;
    /** 监控人审核日期 */
    private java.util.Date monitorDate;
    /**
     * <p>默认构造函数。</p>
     */
    public SlPdPkg() {

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
     * <p>卖家产品包装ID。</p>
     *
     * @return the 卖家产品包装ID
     */
    public java.lang.Integer getSlPdPkgId() {
        return slPdPkgId;
    }

    /**
     * <p>卖家产品包装ID。</p>
     *
     * @param slPdPkgId 卖家产品包装ID。
     */
    public void setSlPdPkgId(java.lang.Integer slPdPkgId) {
        this.slPdPkgId = slPdPkgId;
    }

    /**
     * <p>产品标准ID。</p>
     *
     * @return the 产品标准ID
     */
    public java.lang.Integer getStandardId() {
        return standardId;
    }

    /**
     * <p>产品标准ID。</p>
     *
     * @param standardId 产品标准ID。
     */
    public void setStandardId(java.lang.Integer standardId) {
        this.standardId = standardId;
    }

    /**
     * <p>(卖家编码+卖家产品ID)内顺序号。</p>
     *
     * @return the (卖家编码+卖家产品ID)内顺序号
     */
    public java.lang.String getPkgCode() {
        return pkgCode;
    }

    /**
     * <p>(卖家编码+卖家产品ID)内顺序号。</p>
     *
     * @param pkgCode (卖家编码+卖家产品ID)内顺序号。
     */
    public void setPkgCode(java.lang.String pkgCode) {
        this.pkgCode = pkgCode;
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
     * <p>内包装_单个产品规格净重。</p>
     *
     * @return the 内包装_单个产品规格净重
     */
    public java.lang.String getInSglNw() {
        return inSglNw;
    }

    /**
     * <p>内包装_单个产品规格净重。</p>
     *
     * @param inSglNw 内包装_单个产品规格净重。
     */
    public void setInSglNw(java.lang.String inSglNw) {
        this.inSglNw = inSglNw;
    }

    /**
     * <p>内包装_单个产品规格净重误差范围。</p>
     *
     * @return the 内包装_单个产品规格净重误差范围
     */
    public java.lang.String getInSglNwRange() {
        return inSglNwRange;
    }

    /**
     * <p>内包装_单个产品规格净重误差范围。</p>
     *
     * @param inSglNwRange 内包装_单个产品规格净重误差范围。
     */
    public void setInSglNwRange(java.lang.String inSglNwRange) {
        this.inSglNwRange = inSglNwRange;
    }

    /**
     * <p>内包装_净重。</p>
     *
     * @return the 内包装_净重
     */
    public java.math.BigDecimal getInNw() {
        return inNw;
    }

    /**
     * <p>内包装_净重。</p>
     *
     * @param inNw 内包装_净重。
     */
    public void setInNw(java.math.BigDecimal inNw) {
        this.inNw = inNw;
    }

    /**
     * <p>内包装_个数。</p>
     *
     * @return the 内包装_个数
     */
    public java.lang.String getInNumber() {
        return inNumber;
    }

    /**
     * <p>内包装_个数。</p>
     *
     * @param inNumber 内包装_个数。
     */
    public void setInNumber(java.lang.String inNumber) {
        this.inNumber = inNumber;
    }

    /**
     * <p>内包装_尺寸。</p>
     *
     * @return the 内包装_尺寸
     */
    public java.lang.String getInSize() {
        return inSize;
    }

    /**
     * <p>内包装_尺寸。</p>
     *
     * @param inSize 内包装_尺寸。
     */
    public void setInSize(java.lang.String inSize) {
        this.inSize = inSize;
    }

    /**
     * <p>内包装_材质及技术标准。</p>
     *
     * @return the 内包装_材质及技术标准
     */
    public java.lang.String getInMts() {
        return inMts;
    }

    /**
     * <p>内包装_材质及技术标准。</p>
     *
     * @param inMts 内包装_材质及技术标准。
     */
    public void setInMts(java.lang.String inMts) {
        this.inMts = inMts;
    }

    /**
     * <p>外包装_规格。</p>
     *
     * @return the 外包装_规格
     */
    public java.lang.String getOutSpec() {
        return outSpec;
    }

    /**
     * <p>外包装_规格。</p>
     *
     * @param outSpec 外包装_规格。
     */
    public void setOutSpec(java.lang.String outSpec) {
        this.outSpec = outSpec;
    }

    /**
     * <p>外包装_净重。</p>
     *
     * @return the 外包装_净重
     */
    public java.math.BigDecimal getOutNw() {
        return outNw;
    }

    /**
     * <p>外包装_净重。</p>
     *
     * @param outNw 外包装_净重。
     */
    public void setOutNw(java.math.BigDecimal outNw) {
        this.outNw = outNw;
    }

    /**
     * <p>外包装_毛重。</p>
     *
     * @return the 外包装_毛重
     */
    public java.lang.String getOutGw() {
        return outGw;
    }

    /**
     * <p>外包装_毛重。</p>
     *
     * @param outGw 外包装_毛重。
     */
    public void setOutGw(java.lang.String outGw) {
        this.outGw = outGw;
    }

    /**
     * <p>外包装_尺寸。</p>
     *
     * @return the 外包装_尺寸
     */
    public java.lang.String getOutSize() {
        return outSize;
    }

    /**
     * <p>外包装_尺寸。</p>
     *
     * @param outSize 外包装_尺寸。
     */
    public void setOutSize(java.lang.String outSize) {
        this.outSize = outSize;
    }

    /**
     * <p>外包装_材质及技术标准。</p>
     *
     * @return the 外包装_材质及技术标准
     */
    public java.lang.String getOutMts() {
        return outMts;
    }

    /**
     * <p>外包装_材质及技术标准。</p>
     *
     * @param outMts 外包装_材质及技术标准。
     */
    public void setOutMts(java.lang.String outMts) {
        this.outMts = outMts;
    }

    /**
     * <p>第十种包装信息。</p>
     *
     * @return the 第十种包装信息
     */
    public java.lang.String getPkgTen() {
        return pkgTen;
    }

    /**
     * <p>第十种包装信息。</p>
     *
     * @param pkgTen 第十种包装信息。
     */
    public void setPkgTen(java.lang.String pkgTen) {
        this.pkgTen = pkgTen;
    }

    /**
     * <p>外包装长。</p>
     *
     * @return the 外包装长
     */
    public java.math.BigDecimal getOutLength() {
        return outLength;
    }

    /**
     * <p>外包装长。</p>
     *
     * @param outLength 外包装长。
     */
    public void setOutLength(java.math.BigDecimal outLength) {
        this.outLength = outLength;
    }

    /**
     * <p>外包装宽。</p>
     *
     * @return the 外包装宽
     */
    public java.math.BigDecimal getOutWidth() {
        return outWidth;
    }

    /**
     * <p>外包装宽。</p>
     *
     * @param outWidth 外包装宽。
     */
    public void setOutWidth(java.math.BigDecimal outWidth) {
        this.outWidth = outWidth;
    }

    /**
     * <p>外包装高。</p>
     *
     * @return the 外包装高
     */
    public java.math.BigDecimal getOutHeight() {
        return outHeight;
    }

    /**
     * <p>外包装高。</p>
     *
     * @param outHeight 外包装高。
     */
    public void setOutHeight(java.math.BigDecimal outHeight) {
        this.outHeight = outHeight;
    }

    /**
     * <p>外包装体积。</p>
     *
     * @return the 外包装体积
     */
    public java.math.BigDecimal getOutVolume() {
        return outVolume;
    }

    /**
     * <p>外包装体积。</p>
     *
     * @param outVolume 外包装体积。
     */
    public void setOutVolume(java.math.BigDecimal outVolume) {
        this.outVolume = outVolume;
    }

    /**
     * <p>0:待审核,1:审核完成,2:重新审核。</p>
     *
     * @return the 0:待审核,1:审核完成,2:重新审核
     */
    public java.lang.Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * <p>0:待审核,1:审核完成,2:重新审核。</p>
     *
     * @param auditStatus 0:待审核,1:审核完成,2:重新审核。
     */
    public void setAuditStatus(java.lang.Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * <p>1:同意,2:增加标准包装规格,3:要求执行神农客标准。</p>
     *
     * @return the 1:同意,2:增加标准包装规格,3:要求执行神农客标准
     */
    public java.lang.Integer getAuditResult() {
        return auditResult;
    }

    /**
     * <p>1:同意,2:增加标准包装规格,3:要求执行神农客标准。</p>
     *
     * @param auditResult 1:同意,2:增加标准包装规格,3:要求执行神农客标准。
     */
    public void setAuditResult(java.lang.Integer auditResult) {
        this.auditResult = auditResult;
    }

    /**
     * <p>审核结果说明。</p>
     *
     * @return the 审核结果说明
     */
    public java.lang.String getAuditResultDesc() {
        return auditResultDesc;
    }

    /**
     * <p>审核结果说明。</p>
     *
     * @param auditResultDesc 审核结果说明。
     */
    public void setAuditResultDesc(java.lang.String auditResultDesc) {
        this.auditResultDesc = auditResultDesc;
    }

    /**
     * <p>审核人。</p>
     *
     * @return the 审核人
     */
    public java.lang.String getAuditor() {
        return auditor;
    }

    /**
     * <p>审核人。</p>
     *
     * @param auditor 审核人。
     */
    public void setAuditor(java.lang.String auditor) {
        this.auditor = auditor;
    }

    /**
     * <p>审核日期。</p>
     *
     * @return the 审核日期
     */
    public java.util.Date getAuditDate() {
        return auditDate;
    }

    /**
     * <p>审核日期。</p>
     *
     * @param auditDate 审核日期。
     */
    public void setAuditDate(java.util.Date auditDate) {
        this.auditDate = auditDate;
    }

    /**
     * <p>0:待审核,1:同意,2:不同意。</p>
     *
     * @return the 0:待审核,1:同意,2:不同意
     */
    public java.lang.Integer getMonitorResult() {
        return monitorResult;
    }

    /**
     * <p>0:待审核,1:同意,2:不同意。</p>
     *
     * @param monitorResult 0:待审核,1:同意,2:不同意。
     */
    public void setMonitorResult(java.lang.Integer monitorResult) {
        this.monitorResult = monitorResult;
    }

    /**
     * <p>监控人。</p>
     *
     * @return the 监控人
     */
    public java.lang.String getMonitorAuditor() {
        return monitorAuditor;
    }

    /**
     * <p>监控人。</p>
     *
     * @param monitorAuditor 监控人。
     */
    public void setMonitorAuditor(java.lang.String monitorAuditor) {
        this.monitorAuditor = monitorAuditor;
    }

    /**
     * <p>监控人审核日期。</p>
     *
     * @return the 监控人审核日期
     */
    public java.util.Date getMonitorDate() {
        return monitorDate;
    }

    /**
     * <p>监控人审核日期。</p>
     *
     * @param monitorDate 监控人审核日期。
     */
    public void setMonitorDate(java.util.Date monitorDate) {
        this.monitorDate = monitorDate;
    }

}
