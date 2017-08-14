package com.msk.by.bean;

import com.msk.core.bean.BaseBean;
import com.msk.core.entity.ByBuyerEmployee;
import com.msk.core.entity.ByBuyerRecAddr;
import com.msk.core.entity.ByBuyerRecTime;

import java.util.List;

/**
 * *买家信息bean
 * *@author yuan_chen
 * *@version 1.0
 **/
public class BuyerContactInfo extends BaseBean {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /** 公司代码 */
    private String companyId;
    /** 公司电话 */
    private String companyTel;
    /** 公司名称 */
    private String companyName;
    /** 公司类型 */
    private String companyType;
    /** 公司地址 */
    private String companyAddr;
    /** 城市编码 */
    private String cityCode;
    /** 城市名称 */
    private String cityName;
    /** 联系人列表 */
    List<ByBuyerEmployee> byBuyerEmployees;
    /** 联系时间列表 */
    List<ByBuyerRecTime> byBuyerRecTimes;
    /** 联系地址列表 */
    List<ByBuyerRecAddr> byBuyerRecAddrs;

    /**
     * Getter method for property <tt>companyId</tt>.
     *
     * @return property value of companyId
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * Setter method for property <tt>companyId</tt>.
     *
     * @param companyId value to be assigned to property companyId
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * Getter method for property <tt>companyTel</tt>.
     *
     * @return property value of companyTel
     */
    public String getCompanyTel() {
        return companyTel;
    }

    /**
     * Setter method for property <tt>companyTel</tt>.
     *
     * @param companyTel value to be assigned to property companyTel
     */
    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    /**
     * Getter method for property <tt>companyName</tt>.
     *
     * @return property value of companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Setter method for property <tt>companyName</tt>.
     *
     * @param companyName value to be assigned to property companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Getter method for property <tt>companyType</tt>.
     *
     * @return property value of companyType
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * Setter method for property <tt>companyType</tt>.
     *
     * @param companyType value to be assigned to property companyType
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    /**
     * Getter method for property <tt>companyAddr</tt>.
     *
     * @return property value of companyAddr
     */
    public String getCompanyAddr() {
        return companyAddr;
    }

    /**
     * Setter method for property <tt>companyAddr</tt>.
     *
     * @param companyAddr value to be assigned to property companyAddr
     */
    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
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
     * Getter method for property <tt>byBuyerEmployees</tt>.
     *
     * @return property value of byBuyerEmployees
     */
    public List<ByBuyerEmployee> getByBuyerEmployees() {
        return byBuyerEmployees;
    }

    /**
     * Setter method for property <tt>byBuyerEmployees</tt>.
     *
     * @param byBuyerEmployees value to be assigned to property byBuyerEmployees
     */
    public void setByBuyerEmployees(List<ByBuyerEmployee> byBuyerEmployees) {
        this.byBuyerEmployees = byBuyerEmployees;
    }

    /**
     * Getter method for property <tt>byBuyerRecTimes</tt>.
     *
     * @return property value of byBuyerRecTimes
     */
    public List<ByBuyerRecTime> getByBuyerRecTimes() {
        return byBuyerRecTimes;
    }

    /**
     * Setter method for property <tt>byBuyerRecTimes</tt>.
     *
     * @param byBuyerRecTimes value to be assigned to property byBuyerRecTimes
     */
    public void setByBuyerRecTimes(List<ByBuyerRecTime> byBuyerRecTimes) {
        this.byBuyerRecTimes = byBuyerRecTimes;
    }

    /**
     * Getter method for property <tt>byBuyerRecAddrs</tt>.
     *
     * @return property value of byBuyerRecAddrs
     */
    public List<ByBuyerRecAddr> getByBuyerRecAddrs() {
        return byBuyerRecAddrs;
    }

    /**
     * Setter method for property <tt>byBuyerRecAddrs</tt>.
     *
     * @param byBuyerRecAddrs value to be assigned to property byBuyerRecAddrs
     */
    public void setByBuyerRecAddrs(List<ByBuyerRecAddr> byBuyerRecAddrs) {
        this.byBuyerRecAddrs = byBuyerRecAddrs;
    }
}
