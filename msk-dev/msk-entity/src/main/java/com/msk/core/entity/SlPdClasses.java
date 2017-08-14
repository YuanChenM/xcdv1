/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_pd_classes对应的SlPdClasses。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlPdClasses extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 卖家编码 */
    private java.lang.String slCode;
    /** 产品类别 */
    private java.lang.String pdClassesCode;
    /** 产品加工程度编码 */
    private java.lang.String machiningCode;
    /**
     * <p>默认构造函数。</p>
     */
    public SlPdClasses() {

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
     * <p>产品类别。</p>
     *
     * @return the 产品类别
     */
    public java.lang.String getPdClassesCode() {
        return pdClassesCode;
    }

    /**
     * <p>产品类别。</p>
     *
     * @param pdClassesCode 产品类别。
     */
    public void setPdClassesCode(java.lang.String pdClassesCode) {
        this.pdClassesCode = pdClassesCode;
    }

    /**
     * <p>产品加工程度编码。</p>
     *
     * @return the 产品加工程度编码
     */
    public java.lang.String getMachiningCode() {
        return machiningCode;
    }

    /**
     * <p>产品加工程度编码。</p>
     *
     * @param machiningCode 产品加工程度编码。
     */
    public void setMachiningCode(java.lang.String machiningCode) {
        this.machiningCode = machiningCode;
    }

}
