package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;

/**
 * IPD141135RsBean.通用质量信息指标同步接口
 *
 * @author xhy
 */
public class IPD141135RsGnqBean extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String gnqStdItemId;

    private String gnqStdItemName;

    private String okVal;

    private String ngVal;

    /**
     * Getter method for property <tt>gnqStdItemId</tt>.
     *
     * @return property value of gnqStdItemId
     */
    public String getGnqStdItemId() {
        return gnqStdItemId;
    }

    /**
     * Setter method for property <tt>gnqStdItemId</tt>.
     *
     * @param gnqStdItemId value to be assigned to property gnqStdItemId
     */
    public void setGnqStdItemId(String gnqStdItemId) {
        this.gnqStdItemId = gnqStdItemId;
    }

    /**
     * Getter method for property <tt>gnqStdItemName</tt>.
     *
     * @return property value of gnqStdItemName
     */
    public String getGnqStdItemName() {
        return gnqStdItemName;
    }

    /**
     * Setter method for property <tt>gnqStdItemName</tt>.
     *
     * @param gnqStdItemName value to be assigned to property gnqStdItemName
     */
    public void setGnqStdItemName(String gnqStdItemName) {
        this.gnqStdItemName = gnqStdItemName;
    }

    /**
     * Getter method for property <tt>okVal</tt>.
     *
     * @return property value of okVal
     */
    public String getOkVal() {
        return okVal;
    }

    /**
     * Setter method for property <tt>okVal</tt>.
     *
     * @param okVal value to be assigned to property okVal
     */
    public void setOkVal(String okVal) {
        this.okVal = okVal;
    }

    /**
     * Getter method for property <tt>ngVal</tt>.
     *
     * @return property value of ngVal
     */
    public String getNgVal() {
        return ngVal;
    }

    /**
     * Setter method for property <tt>ngVal</tt>.
     *
     * @param ngVal value to be assigned to property ngVal
     */
    public void setNgVal(String ngVal) {
        this.ngVal = ngVal;
    }
}