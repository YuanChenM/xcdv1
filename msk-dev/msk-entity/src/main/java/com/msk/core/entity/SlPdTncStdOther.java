/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_pd_tnc_std_other对应的SlPdTncStdOther。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlPdTncStdOther extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 1.原种种源标准,2.饲养标准,3,通用质量标准,4.安全标准,5.储存运输标准 */
    private java.lang.Integer stdFlag;
    /** 卖家编码 */
    private java.lang.String slCode;
    /** 卖家编码内的顺序号 */
    private java.lang.Integer slPdId;
    /** 产品标准ID */
    private java.lang.Integer standardId;
    /** 技术标准项目ID */
    private java.lang.String tncStdItemId;
    /** 0:否，1:是 */
    private java.lang.String agreeFlg;
    /**
     * <p>默认构造函数。</p>
     */
    public SlPdTncStdOther() {

    }

    /**
     * <p>1.原种种源标准,2.饲养标准,3,通用质量标准,4.安全标准,5.储存运输标准。</p>
     *
     * @return the 1.原种种源标准,2.饲养标准,3,通用质量标准,4.安全标准,5.储存运输标准
     */
    public java.lang.Integer getStdFlag() {
        return stdFlag;
    }

    /**
     * <p>1.原种种源标准,2.饲养标准,3,通用质量标准,4.安全标准,5.储存运输标准。</p>
     *
     * @param stdFlag 1.原种种源标准,2.饲养标准,3,通用质量标准,4.安全标准,5.储存运输标准。
     */
    public void setStdFlag(java.lang.Integer stdFlag) {
        this.stdFlag = stdFlag;
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
     * <p>卖家编码内的顺序号。</p>
     *
     * @return the 卖家编码内的顺序号
     */
    public java.lang.Integer getSlPdId() {
        return slPdId;
    }

    /**
     * <p>卖家编码内的顺序号。</p>
     *
     * @param slPdId 卖家编码内的顺序号。
     */
    public void setSlPdId(java.lang.Integer slPdId) {
        this.slPdId = slPdId;
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
     * <p>技术标准项目ID。</p>
     *
     * @return the 技术标准项目ID
     */
    public java.lang.String getTncStdItemId() {
        return tncStdItemId;
    }

    /**
     * <p>技术标准项目ID。</p>
     *
     * @param tncStdItemId 技术标准项目ID。
     */
    public void setTncStdItemId(java.lang.String tncStdItemId) {
        this.tncStdItemId = tncStdItemId;
    }

    /**
     * <p>0:否，1:是。</p>
     *
     * @return the 0:否，1:是
     */
    public java.lang.String getAgreeFlg() {
        return agreeFlg;
    }

    /**
     * <p>0:否，1:是。</p>
     *
     * @param agreeFlg 0:否，1:是。
     */
    public void setAgreeFlg(java.lang.String agreeFlg) {
        this.agreeFlg = agreeFlg;
    }

}
