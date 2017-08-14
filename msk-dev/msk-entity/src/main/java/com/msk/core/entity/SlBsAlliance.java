/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_bs_alliance对应的SlBsAlliance。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlBsAlliance extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 区划(6)+顺序码(4) */
    private java.lang.String slCode;
    /** 区划(6)+顺序码(4) */
    private java.lang.String slCodeAlliance;
    /** 优先顺序 */
    private java.util.Date sort;
    /** 开始日时 */
    private java.util.Date startTime;
    /** 结束日时 */
    private java.util.Date endTime;
    /**
     * <p>默认构造函数。</p>
     */
    public SlBsAlliance() {

    }

    /**
     * <p>区划(6)+顺序码(4)。</p>
     *
     * @return the 区划(6)+顺序码(4)
     */
    public java.lang.String getSlCode() {
        return slCode;
    }

    /**
     * <p>区划(6)+顺序码(4)。</p>
     *
     * @param slCode 区划(6)+顺序码(4)。
     */
    public void setSlCode(java.lang.String slCode) {
        this.slCode = slCode;
    }

    /**
     * <p>区划(6)+顺序码(4)。</p>
     *
     * @return the 区划(6)+顺序码(4)
     */
    public java.lang.String getSlCodeAlliance() {
        return slCodeAlliance;
    }

    /**
     * <p>区划(6)+顺序码(4)。</p>
     *
     * @param slCodeAlliance 区划(6)+顺序码(4)。
     */
    public void setSlCodeAlliance(java.lang.String slCodeAlliance) {
        this.slCodeAlliance = slCodeAlliance;
    }

    /**
     * <p>优先顺序。</p>
     *
     * @return the 优先顺序
     */
    public java.util.Date getSort() {
        return sort;
    }

    /**
     * <p>优先顺序。</p>
     *
     * @param sort 优先顺序。
     */
    public void setSort(java.util.Date sort) {
        this.sort = sort;
    }

    /**
     * <p>开始日时。</p>
     *
     * @return the 开始日时
     */
    public java.util.Date getStartTime() {
        return startTime;
    }

    /**
     * <p>开始日时。</p>
     *
     * @param startTime 开始日时。
     */
    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }

    /**
     * <p>结束日时。</p>
     *
     * @return the 结束日时
     */
    public java.util.Date getEndTime() {
        return endTime;
    }

    /**
     * <p>结束日时。</p>
     *
     * @param endTime 结束日时。
     */
    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }

}
