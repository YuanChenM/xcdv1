/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_bs_buyer_leagues对应的SlBsBuyerLeagues�?</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlBsBuyerLeagues extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 联盟ID */
    private Long unionId;
    /** 联盟主买手ID */
    private String ownerSlCode;
    /** 联盟方买手ID */
    private String allianceSlCode;
    /** 产品类别 */
    private String classesCode;
    /** 产品二级分类编码 */
    private String machiningCode;
    /** 产品品种 */
    private String breedCode;
    /** 产品特征 */
    private String featureCode;
    /** �?重编�? */
    private String weightCode;
    /** 产品等级编码 */
    private String gradeCode;
    /** 分红比例 */
    private java.math.BigDecimal divide;
    /** 合营优先顺序 */
    private Integer sortNum;
    /** 1：申请中  2：同�? 3：拒�? */
    private String applyStatus;
    /** 申请日时 */
    private java.util.Date applyTime;
    /**
     * <p>默认构�?�函数�??</p>
     */
    public SlBsBuyerLeagues() {

    }

    /**
     * <p>联盟ID�?</p>
     *
     * @return the 联盟ID
     */
    public Long getUnionId() {
        return unionId;
    }

    /**
     * <p>联盟ID�?</p>
     *
     * @param unionId 联盟ID�?
     */
    public void setUnionId(Long unionId) {
        this.unionId = unionId;
    }

    /**
     * <p>联盟主买手ID�?</p>
     *
     * @return the 联盟主买手ID
     */
    public String getOwnerSlCode() {
        return ownerSlCode;
    }

    /**
     * <p>联盟主买手ID�?</p>
     *
     * @param ownerSlCode 联盟主买手ID�?
     */
    public void setOwnerSlCode(String ownerSlCode) {
        this.ownerSlCode = ownerSlCode;
    }

    /**
     * <p>联盟方买手ID�?</p>
     *
     * @return the 联盟方买手ID
     */
    public String getAllianceSlCode() {
        return allianceSlCode;
    }

    /**
     * <p>联盟方买手ID�?</p>
     *
     * @param allianceSlCode 联盟方买手ID�?
     */
    public void setAllianceSlCode(String allianceSlCode) {
        this.allianceSlCode = allianceSlCode;
    }

    /**
     * <p>产品类别�?</p>
     *
     * @return the 产品类别
     */
    public String getClassesCode() {
        return classesCode;
    }

    /**
     * <p>产品类别�?</p>
     *
     * @param classesCode 产品类别�?
     */
    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    /**
     * <p>产品二级分类编码�?</p>
     *
     * @return the 产品二级分类编码
     */
    public String getMachiningCode() {
        return machiningCode;
    }

    /**
     * <p>产品二级分类编码�?</p>
     *
     * @param machiningCode 产品二级分类编码�?
     */
    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }

    /**
     * <p>产品品种�?</p>
     *
     * @return the 产品品种
     */
    public String getBreedCode() {
        return breedCode;
    }

    /**
     * <p>产品品种�?</p>
     *
     * @param breedCode 产品品种�?
     */
    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    /**
     * <p>产品特征�?</p>
     *
     * @return the 产品特征
     */
    public String getFeatureCode() {
        return featureCode;
    }

    /**
     * <p>产品特征�?</p>
     *
     * @param featureCode 产品特征�?
     */
    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    /**
     * <p>�?重编码�??</p>
     *
     * @return the �?重编�?
     */
    public String getWeightCode() {
        return weightCode;
    }

    /**
     * <p>�?重编码�??</p>
     *
     * @param weightCode �?重编码�??
     */
    public void setWeightCode(String weightCode) {
        this.weightCode = weightCode;
    }

    /**
     * <p>产品等级编码�?</p>
     *
     * @return the 产品等级编码
     */
    public String getGradeCode() {
        return gradeCode;
    }

    /**
     * <p>产品等级编码�?</p>
     *
     * @param gradeCode 产品等级编码�?
     */
    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    /**
     * <p>分红比例�?</p>
     *
     * @return the 分红比例
     */
    public java.math.BigDecimal getDivide() {
        return divide;
    }

    /**
     * <p>分红比例�?</p>
     *
     * @param divide 分红比例�?
     */
    public void setDivide(java.math.BigDecimal divide) {
        this.divide = divide;
    }

    /**
     * <p>合营优先顺序�?</p>
     *
     * @return the 合营优先顺序
     */
    public Integer getSortNum() {
        return sortNum;
    }

    /**
     * <p>合营优先顺序�?</p>
     *
     * @param sortNum 合营优先顺序�?
     */
    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    /**
     * <p>1：申请中  2：同�? 3：拒绝�??</p>
     *
     * @return the 1：申请中  2：同�? 3：拒�?
     */
    public String getApplyStatus() {
        return applyStatus;
    }

    /**
     * <p>1：申请中  2：同�? 3：拒绝�??</p>
     *
     * @param applyStatus 1：申请中  2：同�? 3：拒绝�??
     */
    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    /**
     * <p>申请日时�?</p>
     *
     * @return the 申请日时
     */
    public java.util.Date getApplyTime() {
        return applyTime;
    }

    /**
     * <p>申请日时�?</p>
     *
     * @param applyTime 申请日时�?
     */
    public void setApplyTime(java.util.Date applyTime) {
        this.applyTime = applyTime;
    }

}
