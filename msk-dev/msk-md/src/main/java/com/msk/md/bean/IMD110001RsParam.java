package com.msk.md.bean;

import java.util.List;

import com.msk.core.bean.RsPageParam;
import com.msk.core.bean.RsPageResult;

/**
 * IMD110001RsParam
 *
 * @author yuan_chen
 */
public class IMD110001RsParam extends RsPageParam {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 大区code */
    private String areaCode;
    /** 区分(0:省,1:物流区) */
    private int prLgcsType;
    /** 省或物流区code */
    private String prLgcsCode;
    /** 城市code */
    private String cityCode;
    /** 区code */
    private String districtCode;

    /**
     * Getter method for property <tt>areaCode</tt>.
     *
     * @return property value of areaCode
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * Setter method for property <tt>areaCode</tt>.
     *
     * @param areaCode value to be assigned to property areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * Getter method for property <tt>prLgcsType</tt>.
     *
     * @return property value of prLgcsType
     */
    public int getPrLgcsType() {
        return prLgcsType;
    }

    /**
     * Setter method for property <tt>prLgcsType</tt>.
     *
     * @param prLgcsType value to be assigned to property prLgcsType
     */
    public void setPrLgcsType(int prLgcsType) {
        this.prLgcsType = prLgcsType;
    }

    /**
     * Getter method for property <tt>prLgcsCode</tt>.
     *
     * @return property value of prLgcsCode
     */
    public String getPrLgcsCode() {
        return prLgcsCode;
    }

    /**
     * Setter method for property <tt>prLgcsCode</tt>.
     *
     * @param prLgcsCode value to be assigned to property prLgcsCode
     */
    public void setPrLgcsCode(String prLgcsCode) {
        this.prLgcsCode = prLgcsCode;
    }

    /**
     * Getter method for property <tt>cityCode</tt>.
     *
     * @return property value of cityCode
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * Setter method for property <tt>cityCode</tt>.
     *
     * @param cityCode value to be assigned to property cityCode
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * Getter method for property <tt>districtCode</tt>.
     *
     * @return property value of districtCode
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * Setter method for property <tt>districtCode</tt>.
     *
     * @param districtCode value to be assigned to property districtCode
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }
}