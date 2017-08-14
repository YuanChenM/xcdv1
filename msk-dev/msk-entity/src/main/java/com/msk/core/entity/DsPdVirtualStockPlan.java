/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表ds_pd_virtual_stock_plan对应的DsPdVirtualStockPlan。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class DsPdVirtualStockPlan extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 供应分销流水ID */
    private java.lang.Long suppDsId;
    /** 虚拟库存计划ID */
    private java.lang.Long virtualStockPlanId;
    /** 分销月度 */
    private java.lang.String distMonth;
    /** 物流区编号 */
    private java.lang.String lgcsCode;
    /** 供应商编号 */
    private java.lang.String suppCode;
    /** 产品库存类型 */
    private java.lang.String pdStockType;
    /** 半旬码 */
    private java.lang.String halfCode;
    /** 产品类别编码 */
    private java.lang.String classesCode;
    /** 产品品种编码 */
    private java.lang.String breedCode;
    /** 产品特征编码 */
    private java.lang.String featureCode;
    /** 产品等级编码 */
    private java.lang.String gradeCode;
    /** 外包装规格 */
    private java.lang.String outSpec;
    /** 外包装净重 */
    private java.math.BigDecimal outNw;
    /** 产品编码 */
    private java.lang.String pdCode;
    /** 包装编码 */
    private java.lang.String normsCode;
    /** 调整日期 */
    private java.util.Date adjustDate;
    /** 原始计划数量 */
    private java.math.BigDecimal origPlanNum;
    /** 原计划数量 */
    private java.math.BigDecimal oldPlanNum;
    /** 新计划数量 */
    private java.math.BigDecimal newPlanNum;
    /**
     * <p>默认构造函数。</p>
     */
    public DsPdVirtualStockPlan() {

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
     * <p>虚拟库存计划ID。</p>
     *
     * @return the 虚拟库存计划ID
     */
    public java.lang.Long getVirtualStockPlanId() {
        return virtualStockPlanId;
    }

    /**
     * <p>虚拟库存计划ID。</p>
     *
     * @param virtualStockPlanId 虚拟库存计划ID。
     */
    public void setVirtualStockPlanId(java.lang.Long virtualStockPlanId) {
        this.virtualStockPlanId = virtualStockPlanId;
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
     * <p>产品库存类型。</p>
     *
     * @return the 产品库存类型
     */
    public java.lang.String getPdStockType() {
        return pdStockType;
    }

    /**
     * <p>产品库存类型。</p>
     *
     * @param pdStockType 产品库存类型。
     */
    public void setPdStockType(java.lang.String pdStockType) {
        this.pdStockType = pdStockType;
    }

    /**
     * <p>半旬码。</p>
     *
     * @return the 半旬码
     */
    public java.lang.String getHalfCode() {
        return halfCode;
    }

    /**
     * <p>半旬码。</p>
     *
     * @param halfCode 半旬码。
     */
    public void setHalfCode(java.lang.String halfCode) {
        this.halfCode = halfCode;
    }

    /**
     * <p>产品类别编码。</p>
     *
     * @return the 产品类别编码
     */
    public java.lang.String getClassesCode() {
        return classesCode;
    }

    /**
     * <p>产品类别编码。</p>
     *
     * @param classesCode 产品类别编码。
     */
    public void setClassesCode(java.lang.String classesCode) {
        this.classesCode = classesCode;
    }

    /**
     * <p>产品品种编码。</p>
     *
     * @return the 产品品种编码
     */
    public java.lang.String getBreedCode() {
        return breedCode;
    }

    /**
     * <p>产品品种编码。</p>
     *
     * @param breedCode 产品品种编码。
     */
    public void setBreedCode(java.lang.String breedCode) {
        this.breedCode = breedCode;
    }

    /**
     * <p>产品特征编码。</p>
     *
     * @return the 产品特征编码
     */
    public java.lang.String getFeatureCode() {
        return featureCode;
    }

    /**
     * <p>产品特征编码。</p>
     *
     * @param featureCode 产品特征编码。
     */
    public void setFeatureCode(java.lang.String featureCode) {
        this.featureCode = featureCode;
    }

    /**
     * <p>产品等级编码。</p>
     *
     * @return the 产品等级编码
     */
    public java.lang.String getGradeCode() {
        return gradeCode;
    }

    /**
     * <p>产品等级编码。</p>
     *
     * @param gradeCode 产品等级编码。
     */
    public void setGradeCode(java.lang.String gradeCode) {
        this.gradeCode = gradeCode;
    }

    /**
     * <p>外包装规格。</p>
     *
     * @return the 外包装规格
     */
    public java.lang.String getOutSpec() {
        return outSpec;
    }

    /**
     * <p>外包装规格。</p>
     *
     * @param outSpec 外包装规格。
     */
    public void setOutSpec(java.lang.String outSpec) {
        this.outSpec = outSpec;
    }

    /**
     * <p>外包装净重。</p>
     *
     * @return the 外包装净重
     */
    public java.math.BigDecimal getOutNw() {
        return outNw;
    }

    /**
     * <p>外包装净重。</p>
     *
     * @param outNw 外包装净重。
     */
    public void setOutNw(java.math.BigDecimal outNw) {
        this.outNw = outNw;
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
     * <p>包装编码。</p>
     *
     * @return the 包装编码
     */
    public java.lang.String getNormsCode() {
        return normsCode;
    }

    /**
     * <p>包装编码。</p>
     *
     * @param normsCode 包装编码。
     */
    public void setNormsCode(java.lang.String normsCode) {
        this.normsCode = normsCode;
    }

    /**
     * <p>调整日期。</p>
     *
     * @return the 调整日期
     */
    public java.util.Date getAdjustDate() {
        return adjustDate;
    }

    /**
     * <p>调整日期。</p>
     *
     * @param adjustDate 调整日期。
     */
    public void setAdjustDate(java.util.Date adjustDate) {
        this.adjustDate = adjustDate;
    }

    /**
     * <p>原始计划数量。</p>
     *
     * @return the 原始计划数量
     */
    public java.math.BigDecimal getOrigPlanNum() {
        return origPlanNum;
    }

    /**
     * <p>原始计划数量。</p>
     *
     * @param origPlanNum 原始计划数量。
     */
    public void setOrigPlanNum(java.math.BigDecimal origPlanNum) {
        this.origPlanNum = origPlanNum;
    }

    /**
     * <p>原计划数量。</p>
     *
     * @return the 原计划数量
     */
    public java.math.BigDecimal getOldPlanNum() {
        return oldPlanNum;
    }

    /**
     * <p>原计划数量。</p>
     *
     * @param oldPlanNum 原计划数量。
     */
    public void setOldPlanNum(java.math.BigDecimal oldPlanNum) {
        this.oldPlanNum = oldPlanNum;
    }

    /**
     * <p>新计划数量。</p>
     *
     * @return the 新计划数量
     */
    public java.math.BigDecimal getNewPlanNum() {
        return newPlanNum;
    }

    /**
     * <p>新计划数量。</p>
     *
     * @param newPlanNum 新计划数量。
     */
    public void setNewPlanNum(java.math.BigDecimal newPlanNum) {
        this.newPlanNum = newPlanNum;
    }

}
