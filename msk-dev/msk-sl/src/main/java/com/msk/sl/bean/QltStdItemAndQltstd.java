package com.msk.sl.bean;

import com.msk.core.entity.PdQltStdItem;

/**
 * QltStdItemAndQltstd Controller
 * @author pxg
 */
public class QltStdItemAndQltstd extends PdQltStdItem{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 产品标准ID */
    private Integer standardId;
    /** 质量标准项目ID */
    private String qltStdItemId;
    /** 质量标准优良值 */
    private String qltStdExcVal;
    /** 质量标准合格值 */
    private String qltStdSuitVal;
    /** 质量标准不合格值 */
    private String qltStdUnqualVal;
    /** 标准值单位 */
    private String qltStdValUnit;
    /** 备注 */
    private String remark;
    //卖家产品技术标准值
    private String slQltStdVal;
    //卖家同意标准
    private String agreeFlg;

    /**
     * 获得slQltStdVal
     */
    public String getSlQltStdVal() {
        return slQltStdVal;
    }

    /**
     * 设置slQltStdVal
     */
    public void setSlQltStdVal(String slQltStdVal) {
        this.slQltStdVal = slQltStdVal;
    }

    /**
     * 获得agreeFlg
     */
    public String getAgreeFlg() {
        return agreeFlg;
    }

    /**
     * 设置agreeFlg
     */
    public void setAgreeFlg(String agreeFlg) {
        this.agreeFlg = agreeFlg;
    }

    /**
     * Get the standardId.
     *
     * @return standardId
     *
     * @author Administrator
     */
    public Integer getStandardId() {
        return this.standardId;
    }
    /**
     * Set the standardId.
     *
     * @param standardId standardId
     *
     * @author Administrator
     */
    public void setStandardId(Integer standardId) {
        this.standardId = standardId;
    }
    /**
     * Get the qltStdItemId.
     *
     * @return qltStdItemId
     *
     * @author Administrator
     */
    public String getQltStdItemId() {
        return this.qltStdItemId;
    }
    /**
     * Set the qltStdItemId.
     *
     * @param qltStdItemId qltStdItemId
     *
     * @author Administrator
     */
    public void setQltStdItemId(String qltStdItemId) {
        this.qltStdItemId = qltStdItemId;
    }
    /**
     * Get the qltStdExcVal.
     *
     * @return qltStdExcVal
     *
     * @author Administrator
     */
    public String getQltStdExcVal() {
        return this.qltStdExcVal;
    }
    /**
     * Set the qltStdExcVal.
     *
     * @param qltStdExcVal qltStdExcVal
     *
     * @author Administrator
     */
    public void setQltStdExcVal(String qltStdExcVal) {
        this.qltStdExcVal = qltStdExcVal;
    }
    /**
     * Get the qltStdSuitVal.
     *
     * @return qltStdSuitVal
     *
     * @author Administrator
     */
    public String getQltStdSuitVal() {
        return this.qltStdSuitVal;
    }
    /**
     * Set the qltStdSuitVal.
     *
     * @param qltStdSuitVal qltStdSuitVal
     *
     * @author Administrator
     */
    public void setQltStdSuitVal(String qltStdSuitVal) {
        this.qltStdSuitVal = qltStdSuitVal;
    }
    /**
     * Get the qltStdUnqualVal.
     *
     * @return qltStdUnqualVal
     *
     * @author Administrator
     */
    public String getQltStdUnqualVal() {
        return this.qltStdUnqualVal;
    }
    /**
     * Set the qltStdUnqualVal.
     *
     * @param qltStdUnqualVal qltStdUnqualVal
     *
     * @author Administrator
     */
    public void setQltStdUnqualVal(String qltStdUnqualVal) {
        this.qltStdUnqualVal = qltStdUnqualVal;
    }
    /**
     * Get the qltStdValUnit.
     *
     * @return qltStdValUnit
     *
     * @author Administrator
     */
    public String getQltStdValUnit() {
        return this.qltStdValUnit;
    }
    /**
     * Set the qltStdValUnit.
     *
     * @param qltStdValUnit qltStdValUnit
     *
     * @author Administrator
     */
    public void setQltStdValUnit(String qltStdValUnit) {
        this.qltStdValUnit = qltStdValUnit;
    }
    /**
     * Get the remark.
     *
     * @return remark
     *
     * @author Administrator
     */
    public String getRemark() {
        return this.remark;
    }
    /**
     * Set the remark.
     *
     * @param remark remark
     *
     * @author Administrator
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
