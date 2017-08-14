package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;

/**
 * IPD141134RsBean.加工质量标准指标信息同步接口
 *
 * @author xhy
 */
public class IPD141134RsTncBean extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String tncStdItemId;

    private String tncStdItemName;

    private String goodVal;

    private String normalVal;

    private String badVal;


    /**
     * Getter method for property <tt>tncStdItemId</tt>.
     *
     * @return property value of tncStdItemId
     */
    public String getTncStdItemId() {
        return tncStdItemId;
    }

    /**
     * Setter method for property <tt>tncStdItemId</tt>.
     *
     * @param tncStdItemId value to be assigned to property tncStdItemId
     */
    public void setTncStdItemId(String tncStdItemId) {
        this.tncStdItemId = tncStdItemId;
    }

    /**
     * Getter method for property <tt>tncStdItemName</tt>.
     *
     * @return property value of tncStdItemName
     */
    public String getTncStdItemName() {
        return tncStdItemName;
    }

    /**
     * Setter method for property <tt>tncStdItemName</tt>.
     *
     * @param tncStdItemName value to be assigned to property tncStdItemName
     */
    public void setTncStdItemName(String tncStdItemName) {
        this.tncStdItemName = tncStdItemName;
    }

    /**
     * Getter method for property <tt>goodVal</tt>.
     *
     * @return property value of goodVal
     */
    public String getGoodVal() {
        return goodVal;
    }

    /**
     * Setter method for property <tt>goodVal</tt>.
     *
     * @param goodVal value to be assigned to property goodVal
     */
    public void setGoodVal(String goodVal) {
        this.goodVal = goodVal;
    }

    /**
     * Getter method for property <tt>normalVal</tt>.
     *
     * @return property value of normalVal
     */
    public String getNormalVal() {
        return normalVal;
    }

    /**
     * Setter method for property <tt>normalVal</tt>.
     *
     * @param normalVal value to be assigned to property normalVal
     */
    public void setNormalVal(String normalVal) {
        this.normalVal = normalVal;
    }

    /**
     * Getter method for property <tt>badVal</tt>.
     *
     * @return property value of badVal
     */
    public String getBadVal() {
        return badVal;
    }

    /**
     * Setter method for property <tt>badVal</tt>.
     *
     * @param badVal value to be assigned to property badVal
     */
    public void setBadVal(String badVal) {
        this.badVal = badVal;
    }
}