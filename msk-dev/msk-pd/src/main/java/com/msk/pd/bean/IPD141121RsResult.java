package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * 产品标准包装档案卡查询返回值
 * IPD141108RsResult
 *
 * @author xhy
 */
public class IPD141121RsResult extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 加工技术标准项目ID */
    private java.lang.String mctStdItemId;

    private java.lang.String mctStdItemName;
    /** 合格值 */
    private java.lang.String mctStdVal1;
    /** 不合格值 */
    private java.lang.String mctStdVal2;


    /**
     * Getter method for property <tt>mctStdItemId</tt>.
     *
     * @return property value of mctStdItemId
     */
    public String getMctStdItemId() {
        return mctStdItemId;
    }

    /**
     * Setter method for property <tt>mctStdItemId</tt>.
     *
     * @param mctStdItemId value to be assigned to property mctStdItemId
     */
    public void setMctStdItemId(String mctStdItemId) {
        this.mctStdItemId = mctStdItemId;
    }

    /**
     * Getter method for property <tt>mctStdItemName</tt>.
     *
     * @return property value of mctStdItemName
     */
    public String getMctStdItemName() {
        return mctStdItemName;
    }

    /**
     * Setter method for property <tt>mctStdItemName</tt>.
     *
     * @param mctStdItemName value to be assigned to property mctStdItemName
     */
    public void setMctStdItemName(String mctStdItemName) {
        this.mctStdItemName = mctStdItemName;
    }

    /**
     * Getter method for property <tt>mctStdVal1</tt>.
     *
     * @return property value of mctStdVal1
     */
    public String getMctStdVal1() {
        return mctStdVal1;
    }

    /**
     * Setter method for property <tt>mctStdVal1</tt>.
     *
     * @param mctStdVal1 value to be assigned to property mctStdVal1
     */
    public void setMctStdVal1(String mctStdVal1) {
        this.mctStdVal1 = mctStdVal1;
    }

    /**
     * Getter method for property <tt>mctStdVal2</tt>.
     *
     * @return property value of mctStdVal2
     */
    public String getMctStdVal2() {
        return mctStdVal2;
    }

    /**
     * Setter method for property <tt>mctStdVal2</tt>.
     *
     * @param mctStdVal2 value to be assigned to property mctStdVal2
     */
    public void setMctStdVal2(String mctStdVal2) {
        this.mctStdVal2 = mctStdVal2;
    }
}