package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

/**
 * Created by xuhongyang on 2017/2/4.
 *
 * 配送站信息
 */
public class PlTerminal extends BaseBean {

    //配送站ID
    private Long terminalId;
    //配送站名称
    private String terminalName;
    //物流区编码
    private String logiareaCode;
    //物流区名称
    private String logiareaName;
    //所属城市编码
    private String cityCode;
    //所属城市名称
    private String cityName;
    //所属区县编码
    private String districtCode;
    //所属区县名称
    private String districtName;
    //地址
    private String terminalAddress;

    /**
     * Getter method for property <tt>terminalId</tt>.
     *
     * @return property value of terminalId
     */
    public Long getTerminalId() {
        return terminalId;
    }

    /**
     * Setter method for property <tt>terminalId</tt>.
     *
     * @param terminalId value to be assigned to property terminalId
     */
    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    /**
     * Getter method for property <tt>terminalName</tt>.
     *
     * @return property value of terminalName
     */
    public String getTerminalName() {
        return terminalName;
    }

    /**
     * Setter method for property <tt>terminalName</tt>.
     *
     * @param terminalName value to be assigned to property terminalName
     */
    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    /**
     * Getter method for property <tt>logiareaCode</tt>.
     *
     * @return property value of logiareaCode
     */
    public String getLogiareaCode() {
        return logiareaCode;
    }

    /**
     * Setter method for property <tt>logiareaCode</tt>.
     *
     * @param logiareaCode value to be assigned to property logiareaCode
     */
    public void setLogiareaCode(String logiareaCode) {
        this.logiareaCode = logiareaCode;
    }

    /**
     * Getter method for property <tt>logiareaName</tt>.
     *
     * @return property value of logiareaName
     */
    public String getLogiareaName() {
        return logiareaName;
    }

    /**
     * Setter method for property <tt>logiareaName</tt>.
     *
     * @param logiareaName value to be assigned to property logiareaName
     */
    public void setLogiareaName(String logiareaName) {
        this.logiareaName = logiareaName;
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
     * Getter method for property <tt>cityName</tt>.
     *
     * @return property value of cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Setter method for property <tt>cityName</tt>.
     *
     * @param cityName value to be assigned to property cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    /**
     * Getter method for property <tt>districtName</tt>.
     *
     * @return property value of districtName
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * Setter method for property <tt>districtName</tt>.
     *
     * @param districtName value to be assigned to property districtName
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * Getter method for property <tt>terminalAddress</tt>.
     *
     * @return property value of terminalAddress
     */
    public String getTerminalAddress() {
        return terminalAddress;
    }

    /**
     * Setter method for property <tt>terminalAddress</tt>.
     *
     * @param terminalAddress value to be assigned to property terminalAddress
     */
    public void setTerminalAddress(String terminalAddress) {
        this.terminalAddress = terminalAddress;
    }
}
