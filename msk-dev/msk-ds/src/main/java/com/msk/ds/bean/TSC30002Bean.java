package com.msk.ds.bean;

import com.msk.core.entity.BaseEntity;

/**
 * PD141146Bean.
 *
 * @author XHY
 */
public class TSC30002Bean extends BaseEntity{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String jsNumber;
    private String moneyAll;
    private String percentage;
    private String practicalMoney;
    private String stateHt;


    /**
     * Getter method for property <tt>jsNumber</tt>.
     *
     * @return property value of jsNumber
     */
    public String getJsNumber() {
        return jsNumber;
    }

    /**
     * Setter method for property <tt>jsNumber</tt>.
     *
     * @param jsNumber value to be assigned to property jsNumber
     */
    public void setJsNumber(String jsNumber) {
        this.jsNumber = jsNumber;
    }

    /**
     * Getter method for property <tt>moneyAll</tt>.
     *
     * @return property value of moneyAll
     */
    public String getMoneyAll() {
        return moneyAll;
    }

    /**
     * Setter method for property <tt>moneyAll</tt>.
     *
     * @param moneyAll value to be assigned to property moneyAll
     */
    public void setMoneyAll(String moneyAll) {
        this.moneyAll = moneyAll;
    }

    /**
     * Getter method for property <tt>percentage</tt>.
     *
     * @return property value of percentage
     */
    public String getPercentage() {
        return percentage;
    }

    /**
     * Setter method for property <tt>percentage</tt>.
     *
     * @param percentage value to be assigned to property percentage
     */
    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    /**
     * Getter method for property <tt>practicalMoney</tt>.
     *
     * @return property value of practicalMoney
     */
    public String getPracticalMoney() {
        return practicalMoney;
    }

    /**
     * Setter method for property <tt>practicalMoney</tt>.
     *
     * @param practicalMoney value to be assigned to property practicalMoney
     */
    public void setPracticalMoney(String practicalMoney) {
        this.practicalMoney = practicalMoney;
    }

    /**
     * Getter method for property <tt>stateHt</tt>.
     *
     * @return property value of stateHt
     */
    public String getStateHt() {
        return stateHt;
    }

    /**
     * Setter method for property <tt>stateHt</tt>.
     *
     * @param stateHt value to be assigned to property stateHt
     */
    public void setStateHt(String stateHt) {
        this.stateHt = stateHt;
    }
}
