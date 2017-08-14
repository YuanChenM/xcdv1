package com.msk.bp.bean;

import com.msk.core.bean.RsPageParam;

/**
 * IBP11291IRsParam接受参数.
 *
 * @author xu_wei
 */
public class IBP11291IRsParam extends RsPageParam {
    /**
     * 价盘周期
     */
    private String pricePeriod;
    /**
     * 物流区编码
     */
    private String logiAreaCode;
    /**
     * 卖家编码
     */
    private String slCode;
    /**
     * 商品编码
     */
    private String pdCode;
    /**
     * 产品类别编码
     */
    private String classesCode;
    /**
     * 产品二级分类编码
     */
    private String machiningCode;
    /**
     * 产品种类编码
     */
    private String breedCode;
    /**
     * 产品特征编码
     */
    private String featureCode;
    /**
     * 产品净重编码
     */
    private String weightCode;
    /**
     * 产品等级编码
     */
    private String gradeCode;

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getPricePeriod() {
        return pricePeriod;
    }

    public void setPricePeriod(String pricePeriod) {
        this.pricePeriod = pricePeriod;
    }

    public String getLogiAreaCode() {
        return logiAreaCode;
    }

    public void setLogiAreaCode(String logiAreaCode) {
        this.logiAreaCode = logiAreaCode;
    }

    public String getSlCode() {
        return slCode;
    }

    public void setSlCode(String slCode) {
        this.slCode = slCode;
    }

    public String getClassesCode() {
        return classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    public String getMachiningCode() {
        return machiningCode;
    }

    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public String getWeightCode() {
        return weightCode;
    }

    public void setWeightCode(String weightCode) {
        this.weightCode = weightCode;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }
}
