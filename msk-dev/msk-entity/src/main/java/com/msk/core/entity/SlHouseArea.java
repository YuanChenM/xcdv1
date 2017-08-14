/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_house_area对应的SlHouseArea。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlHouseArea extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 经营区域 */
    private java.lang.Long slAreaId;
    /** 区划(6)+顺序码(4) */
    private java.lang.String slCode;
    /** 用于登录的卖家账号 */
    private java.lang.String houseCode;
    /** 物流区编码 */
    private java.lang.String lgcsAreaCode;
    /** 省编码 */
    private java.lang.String provinceCode;
    /** 地区编码 */
    private java.lang.String cityCode;
    /** 区编码 */
    private java.lang.String districtCode;
    /** 经营地址 */
    private java.lang.String address;
    /**
     * <p>默认构造函数。</p>
     */
    public SlHouseArea() {

    }

    /**
     * <p>经营区域。</p>
     *
     * @return the 经营区域
     */
    public java.lang.Long getSlAreaId() {
        return slAreaId;
    }

    /**
     * <p>经营区域。</p>
     *
     * @param slAreaId 经营区域。
     */
    public void setSlAreaId(java.lang.Long slAreaId) {
        this.slAreaId = slAreaId;
    }

    /**
     * <p>区划(6)+顺序码(4)。</p>
     *
     * @return the 区划(6)+顺序码(4)
     */
    public java.lang.String getSlCode() {
        return slCode;
    }

    /**
     * <p>区划(6)+顺序码(4)。</p>
     *
     * @param slCode 区划(6)+顺序码(4)。
     */
    public void setSlCode(java.lang.String slCode) {
        this.slCode = slCode;
    }

    /**
     * <p>用于登录的卖家账号。</p>
     *
     * @return the 用于登录的卖家账号
     */
    public java.lang.String getHouseCode() {
        return houseCode;
    }

    /**
     * <p>用于登录的卖家账号。</p>
     *
     * @param houseCode 用于登录的卖家账号。
     */
    public void setHouseCode(java.lang.String houseCode) {
        this.houseCode = houseCode;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @return the 物流区编码
     */
    public java.lang.String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @param lgcsAreaCode 物流区编码。
     */
    public void setLgcsAreaCode(java.lang.String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    /**
     * <p>省编码。</p>
     *
     * @return the 省编码
     */
    public java.lang.String getProvinceCode() {
        return provinceCode;
    }

    /**
     * <p>省编码。</p>
     *
     * @param provinceCode 省编码。
     */
    public void setProvinceCode(java.lang.String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * <p>地区编码。</p>
     *
     * @return the 地区编码
     */
    public java.lang.String getCityCode() {
        return cityCode;
    }

    /**
     * <p>地区编码。</p>
     *
     * @param cityCode 地区编码。
     */
    public void setCityCode(java.lang.String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * <p>区编码。</p>
     *
     * @return the 区编码
     */
    public java.lang.String getDistrictCode() {
        return districtCode;
    }

    /**
     * <p>区编码。</p>
     *
     * @param districtCode 区编码。
     */
    public void setDistrictCode(java.lang.String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * <p>经营地址。</p>
     *
     * @return the 经营地址
     */
    public java.lang.String getAddress() {
        return address;
    }

    /**
     * <p>经营地址。</p>
     *
     * @param address 经营地址。
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }

}
