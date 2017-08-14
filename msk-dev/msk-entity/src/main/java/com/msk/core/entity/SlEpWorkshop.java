/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_ep_workshop对应的SlEpWorkshop。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlEpWorkshop extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 企业ID */
    private java.lang.Long epId;
    /** 车间ID */
    private java.lang.Long workshopId;
    /** 车间名称 */
    private java.lang.String workshopName;
    /** 生产产品 */
    private java.lang.String product;
    /** 工艺流程特点 */
    private java.lang.String process;
    /**
     * <p>默认构造函数。</p>
     */
    public SlEpWorkshop() {

    }

    /**
     * <p>企业ID。</p>
     *
     * @return the 企业ID
     */
    public java.lang.Long getEpId() {
        return epId;
    }

    /**
     * <p>企业ID。</p>
     *
     * @param epId 企业ID。
     */
    public void setEpId(java.lang.Long epId) {
        this.epId = epId;
    }

    /**
     * <p>车间ID。</p>
     *
     * @return the 车间ID
     */
    public java.lang.Long getWorkshopId() {
        return workshopId;
    }

    /**
     * <p>车间ID。</p>
     *
     * @param workshopId 车间ID。
     */
    public void setWorkshopId(java.lang.Long workshopId) {
        this.workshopId = workshopId;
    }

    /**
     * <p>车间名称。</p>
     *
     * @return the 车间名称
     */
    public java.lang.String getWorkshopName() {
        return workshopName;
    }

    /**
     * <p>车间名称。</p>
     *
     * @param workshopName 车间名称。
     */
    public void setWorkshopName(java.lang.String workshopName) {
        this.workshopName = workshopName;
    }

    /**
     * <p>生产产品。</p>
     *
     * @return the 生产产品
     */
    public java.lang.String getProduct() {
        return product;
    }

    /**
     * <p>生产产品。</p>
     *
     * @param product 生产产品。
     */
    public void setProduct(java.lang.String product) {
        this.product = product;
    }

    /**
     * <p>工艺流程特点。</p>
     *
     * @return the 工艺流程特点
     */
    public java.lang.String getProcess() {
        return process;
    }

    /**
     * <p>工艺流程特点。</p>
     *
     * @param process 工艺流程特点。
     */
    public void setProcess(java.lang.String process) {
        this.process = process;
    }

}
