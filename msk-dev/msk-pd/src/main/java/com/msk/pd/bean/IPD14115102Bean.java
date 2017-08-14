package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;

/**
 * 首页产品楼层接口
 * Created by ren_qiang on 2016/11/3.
 */
public class IPD14115102Bean extends BaseEntity {

    private String pdCode;//产品编码
    private String advertisePrice;//产品广告价格（取该品种的最低价）
    private String breedCode;//品种编码
    private String breedName;//品名
    private String featureCode;//特征编码
    private String featureName;//特征
    private String weightCode;//净重编码
    private String weightName;//净重名称
    private String gradeCode;//等级编码
    private String gradeName;//等级名称
    private  String pdLabel;//标签
    private String coverImg;//封面图片

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getAdvertisePrice() {
        return advertisePrice;
    }

    public void setAdvertisePrice(String advertisePrice) {
        this.advertisePrice = advertisePrice;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getWeightCode() {
        return weightCode;
    }

    public void setWeightCode(String weightCode) {
        this.weightCode = weightCode;
    }

    public String getWeightName() {
        return weightName;
    }

    public void setWeightName(String weightName) {
        this.weightName = weightName;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getPdLabel() {
        return pdLabel;
    }

    public void setPdLabel(String pdLabel) {
        this.pdLabel = pdLabel;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }
}
