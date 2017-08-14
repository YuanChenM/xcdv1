package com.msk.pd.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.entity.BaseEntity;

/**
 * 封装参数
 * IPD141112RsPdStdSubParam.
 *
 * @author xhy
 */
@JsonIgnoreProperties(value = {"delFlg", "crtId", "crtTime", "updId", "updTime", "ver", "actId"})
public class IPD141112RsPdStdItemResult extends BaseEntity {


    private static final long serialVersionUID = 1L;

    /**
     * 质量标准项目ID
     */
    private String qltStdItemId;
    /**
     * 标准值名称
     */
    private String qltStdItemName;
    /**
     * 质量标准优良值
     */
    private String qltStdExcVal;
    /**
     * 质量标准合格值
     */
    private String qltStdSuitVal;
    /**
     * 质量标准不合格值
     */
    private String qltStdUnqualVal;
    /**
     * 标准值单位
     */
    private String qltStdValUnit;


    private String qltStdClaId;//质量标准id

    private String qltStdSubId; //质量标准子分类ID

    /**
     * 获得qltStdClaId
     */
    public String getQltStdClaId() {
        return qltStdClaId;
    }

    /**
     * 设置qltStdClaId
     */
    public void setQltStdClaId(String qltStdClaId) {
        this.qltStdClaId = qltStdClaId;
    }

    /**
     * 获得qltStdSubId
     */
    public String getQltStdSubId() {
        return qltStdSubId;
    }

    /**
     * 设置qltStdSubId
     */
    public void setQltStdSubId(String qltStdSubId) {
        this.qltStdSubId = qltStdSubId;
    }

    /**
     * 获得qltStdItemId
     */
    public String getQltStdItemId() {
        return qltStdItemId;
    }

    /**
     * 设置qltStdItemId
     */
    public void setQltStdItemId(String qltStdItemId) {
        this.qltStdItemId = qltStdItemId;
    }

    /**
     * 获得qltStdItemName
     */
    public String getQltStdItemName() {
        return qltStdItemName;
    }

    /**
     * 设置qltStdItemName
     */
    public void setQltStdItemName(String qltStdItemName) {
        this.qltStdItemName = qltStdItemName;
    }

    /**
     * 获得qltStdExcVal
     */
    public String getQltStdExcVal() {
        return qltStdExcVal;
    }

    /**
     * 设置qltStdExcVal
     */
    public void setQltStdExcVal(String qltStdExcVal) {
        this.qltStdExcVal = qltStdExcVal;
    }

    /**
     * 获得qltStdSuitVal
     */
    public String getQltStdSuitVal() {
        return qltStdSuitVal;
    }

    /**
     * 设置qltStdSuitVal
     */
    public void setQltStdSuitVal(String qltStdSuitVal) {
        this.qltStdSuitVal = qltStdSuitVal;
    }

    /**
     * 获得qltStdUnqualVal
     */
    public String getQltStdUnqualVal() {
        return qltStdUnqualVal;
    }

    /**
     * 设置qltStdUnqualVal
     */
    public void setQltStdUnqualVal(String qltStdUnqualVal) {
        this.qltStdUnqualVal = qltStdUnqualVal;
    }

    /**
     * 获得qltStdValUnit
     */
    public String getQltStdValUnit() {
        return qltStdValUnit;
    }

    /**
     * 设置qltStdValUnit
     */
    public void setQltStdValUnit(String qltStdValUnit) {
        this.qltStdValUnit = qltStdValUnit;
    }


}