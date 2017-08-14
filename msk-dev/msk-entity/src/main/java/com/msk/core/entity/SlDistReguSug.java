/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_dist_regu_sug对应的SlDistReguSug。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlDistReguSug extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 卖家编码 */
    private java.lang.String slCode;
    /** 章节ID */
    private java.lang.Integer chapId;
    /** 类别 */
    private java.lang.String chapClass;
    /** 0:未录入,1:同意,2:不同意 */
    private java.lang.Integer agreeFlg;
    /** 卖家意见 */
    private java.lang.String slSug;
    /**
     * <p>默认构造函数。</p>
     */
    public SlDistReguSug() {

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
     * <p>章节ID。</p>
     *
     * @return the 章节ID
     */
    public java.lang.Integer getChapId() {
        return chapId;
    }

    /**
     * <p>章节ID。</p>
     *
     * @param chapId 章节ID。
     */
    public void setChapId(java.lang.Integer chapId) {
        this.chapId = chapId;
    }

    /**
     * <p>类别。</p>
     *
     * @return the 类别
     */
    public java.lang.String getChapClass() {
        return chapClass;
    }

    /**
     * <p>类别。</p>
     *
     * @param chapClass 类别。
     */
    public void setChapClass(java.lang.String chapClass) {
        this.chapClass = chapClass;
    }

    /**
     * <p>0:未录入,1:同意,2:不同意。</p>
     *
     * @return the 0:未录入,1:同意,2:不同意
     */
    public java.lang.Integer getAgreeFlg() {
        return agreeFlg;
    }

    /**
     * <p>0:未录入,1:同意,2:不同意。</p>
     *
     * @param agreeFlg 0:未录入,1:同意,2:不同意。
     */
    public void setAgreeFlg(java.lang.Integer agreeFlg) {
        this.agreeFlg = agreeFlg;
    }

    /**
     * <p>卖家意见。</p>
     *
     * @return the 卖家意见
     */
    public java.lang.String getSlSug() {
        return slSug;
    }

    /**
     * <p>卖家意见。</p>
     *
     * @param slSug 卖家意见。
     */
    public void setSlSug(java.lang.String slSug) {
        this.slSug = slSug;
    }

}
