/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;

/**
 * <p>表by_buyer_pd_cla对应的ByBuyerPdCla。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class ByBuyerPdCla extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    private java.lang.Long id;
    /**
     * 买家ID
     */
    private java.lang.String buyerId;
    /**
     * 参考产品类别
     */
    private java.lang.String classCode;
    /**
     * 产品类别名称
     */
    private java.lang.String className;
    /**
     * 产品二级分类
     */
    private java.lang.String machiningCodeU;

    /**
     * <p>默认构造函数。</p>
     */
    public ByBuyerPdCla() {

    }

    /**
     * <p>ID。</p>
     *
     * @return the ID
     */
    public java.lang.Long getId() {
        return id;
    }

    /**
     * <p>ID。</p>
     *
     * @param id ID。
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    /**
     * <p>买家ID。</p>
     *
     * @return the 买家ID
     */
    public java.lang.String getBuyerId() {
        return buyerId;
    }

    /**
     * <p>买家ID。</p>
     *
     * @param buyerId 买家ID。
     */
    public void setBuyerId(java.lang.String buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * <p>参考产品类别。</p>
     *
     * @return the 参考产品类别
     */
    public java.lang.String getClassCode() {
        return classCode;
    }

    /**
     * <p>参考产品类别。</p>
     *
     * @param classCode 参考产品类别。
     */
    public void setClassCode(java.lang.String classCode) {
        this.classCode = classCode;
    }

    /**
     * <p>产品类别名称。</p>
     *
     * @return the 产品类别名称
     */
    public java.lang.String getClassName() {
        return className;
    }

    /**
     * <p>产品类别名称。</p>
     *
     * @param className 产品类别名称。
     */
    public void setClassName(java.lang.String className) {
        this.className = className;
    }

    /**
     * <p>产品二级分类。</p>
     *
     * @return the 产品二级分类
     */
    public java.lang.String getMachiningCodeU() {
        return machiningCodeU;
    }

    /**
     * <p>产品二级分类。</p>
     *
     * @param machiningCodeU 产品二级分类。
     */
    public void setMachiningCodeU(java.lang.String machiningCodeU) {
        this.machiningCodeU = machiningCodeU;
    }
}
