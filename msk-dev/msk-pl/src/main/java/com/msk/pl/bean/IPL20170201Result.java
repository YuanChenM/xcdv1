package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

/**
 * Created by xuhongyang on 2017/2/6.
 */
public class IPL20170201Result extends BaseBean {

    private int isPartner;

    private Long partnerId;

    private int isBs;

    private String bsCode;

    private String userName;

    /**
     * Getter method for property <tt>userName</tt>.
     *
     * @return property value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for property <tt>userName</tt>.
     *
     * @param userName value to be assigned to property userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter method for property <tt>bsCode</tt>.
     *
     * @return property value of bsCode
     */
    public String getBsCode() {
        return bsCode;
    }

    /**
     * Setter method for property <tt>bsCode</tt>.
     *
     * @param bsCode value to be assigned to property bsCode
     */
    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
    }

    /**
     * Getter method for property <tt>isPartner</tt>.
     *
     * @return property value of isPartner
     */
    public int getIsPartner() {
        return isPartner;
    }

    /**
     * Setter method for property <tt>isPartner</tt>.
     *
     * @param isPartner value to be assigned to property isPartner
     */
    public void setIsPartner(int isPartner) {
        this.isPartner = isPartner;
    }

    /**
     * Getter method for property <tt>partnerId</tt>.
     *
     * @return property value of partnerId
     */
    public Long getPartnerId() {
        return partnerId;
    }

    /**
     * Setter method for property <tt>partnerId</tt>.
     *
     * @param partnerId value to be assigned to property partnerId
     */
    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    /**
     * Getter method for property <tt>isBs</tt>.
     *
     * @return property value of isBs
     */
    public int getIsBs() {
        return isBs;
    }

    /**
     * Setter method for property <tt>isBs</tt>.
     *
     * @param isBs value to be assigned to property isBs
     */
    public void setIsBs(int isBs) {
        this.isBs = isBs;
    }


}
