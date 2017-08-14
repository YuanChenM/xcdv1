package com.msk.so.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.bean.BaseParam;

/**
 * ISO151401RsParam 卖家产品库存查询
 *
 * @author sjj
 */
@JsonIgnoreProperties(value = {"delFlg", "crtId", "crtTime", "updId", "updTime", "ver", "actId"})
public class ISO151401RsParam extends BaseParam {

    private static final long serialVersionUID = 1L;

    private String sellerCode;

    private String platformType;

    private Integer districtCode;

    private Integer sellerType;

    private String pdCode;   //产品编码包含产品等级编码

    private String userMobile;//专属买家手机号码

    /**
     * Getter method for property <tt>userMobile</tt>.
     *
     * @return property value of userMobile
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * Setter method for property <tt>userMobile</tt>.
     *
     * @param userMobile value to be assigned to property userMobile
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    /**
     * Getter method for property <tt>sellerCode</tt>.
     *
     * @return property value of sellerCode
     */
    public String getSellerCode() {
        return sellerCode;
    }

    /**
     * Setter method for property <tt>sellerCode</tt>.
     *
     * @param sellerCode value to be assigned to property sellerCode
     */
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    /**
     * Getter method for property <tt>platformType</tt>.
     *
     * @return property value of platformType
     */
    public String getPlatformType() {
        return platformType;
    }

    /**
     * Setter method for property <tt>platformType</tt>.
     *
     * @param platformType value to be assigned to property platformType
     */
    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    /**
     * Getter method for property <tt>districtCode</tt>.
     *
     * @return property value of districtCode
     */
    public Integer getDistrictCode() {
        return districtCode;
    }

    /**
     * Setter method for property <tt>districtCode</tt>.
     *
     * @param districtCode value to be assigned to property districtCode
     */
    public void setDistrictCode(Integer districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * Getter method for property <tt>sellerType</tt>.
     *
     * @return property value of sellerType
     */
    public Integer getSellerType() {
        return sellerType;
    }

    /**
     * Setter method for property <tt>sellerType</tt>.
     *
     * @param sellerType value to be assigned to property sellerType
     */
    public void setSellerType(Integer sellerType) {
        this.sellerType = sellerType;
    }

    /**
     * Getter method for property <tt>pdCode</tt>.
     *
     * @return property value of pdCode
     */
    public String getPdCode() {
        return pdCode;
    }

    /**
     * Setter method for property <tt>pdCode</tt>.
     *
     * @param pdCode value to be assigned to property pdCode
     */
    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }
}