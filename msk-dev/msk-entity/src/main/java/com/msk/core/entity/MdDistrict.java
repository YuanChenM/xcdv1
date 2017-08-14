/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表md_district对应的MdDistrict。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class MdDistrict extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 区ID */
    private java.lang.Long districtId;
    /** 地区ID */
    private java.lang.Long cityId;
    /** 区编码 */
    private java.lang.String districtCode;
    /** 区名称 */
    private java.lang.String districtName;
    /** 划分级别（大区1，省和物流区2，地区和城市3，区4） */
    private java.math.BigDecimal divisionLevel;
    /** 拼音 */
    private java.lang.String spell;
    /** 拼音首字母缩写 */
    private java.lang.String shortSpell;
    /** 地区+区的编码（5位） */
    private java.lang.String shortCode;
    /** 地区+区的名称 */
    private java.lang.String shortName;
    /** 大区+省+地区的编码（9位） */
    private java.lang.String fullCodeP;
    /** 大区+省+地区的名称 */
    private java.lang.String fullNameP;
    /** 大区+物流区+地区的编码（9位） */
    private java.lang.String fullCodeL;
    /** 大区+物流区+地区的名称 */
    private java.lang.String fullNameL;
    /**
     * <p>默认构造函数。</p>
     */
    public MdDistrict() {

    }

    /**
     * <p>区ID。</p>
     *
     * @return the 区ID
     */
    public java.lang.Long getDistrictId() {
        return districtId;
    }

    /**
     * <p>区ID。</p>
     *
     * @param districtId 区ID。
     */
    public void setDistrictId(java.lang.Long districtId) {
        this.districtId = districtId;
    }

    /**
     * <p>地区ID。</p>
     *
     * @return the 地区ID
     */
    public java.lang.Long getCityId() {
        return cityId;
    }

    /**
     * <p>地区ID。</p>
     *
     * @param cityId 地区ID。
     */
    public void setCityId(java.lang.Long cityId) {
        this.cityId = cityId;
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
     * <p>区名称。</p>
     *
     * @return the 区名称
     */
    public java.lang.String getDistrictName() {
        return districtName;
    }

    /**
     * <p>区名称。</p>
     *
     * @param districtName 区名称。
     */
    public void setDistrictName(java.lang.String districtName) {
        this.districtName = districtName;
    }

    /**
     * <p>划分级别（大区1，省和物流区2，地区和城市3，区4）。</p>
     *
     * @return the 划分级别（大区1，省和物流区2，地区和城市3，区4）
     */
    public java.math.BigDecimal getDivisionLevel() {
        return divisionLevel;
    }

    /**
     * <p>划分级别（大区1，省和物流区2，地区和城市3，区4）。</p>
     *
     * @param divisionLevel 划分级别（大区1，省和物流区2，地区和城市3，区4）。
     */
    public void setDivisionLevel(java.math.BigDecimal divisionLevel) {
        this.divisionLevel = divisionLevel;
    }

    /**
     * <p>拼音。</p>
     *
     * @return the 拼音
     */
    public java.lang.String getSpell() {
        return spell;
    }

    /**
     * <p>拼音。</p>
     *
     * @param spell 拼音。
     */
    public void setSpell(java.lang.String spell) {
        this.spell = spell;
    }

    /**
     * <p>拼音首字母缩写。</p>
     *
     * @return the 拼音首字母缩写
     */
    public java.lang.String getShortSpell() {
        return shortSpell;
    }

    /**
     * <p>拼音首字母缩写。</p>
     *
     * @param shortSpell 拼音首字母缩写。
     */
    public void setShortSpell(java.lang.String shortSpell) {
        this.shortSpell = shortSpell;
    }

    /**
     * <p>地区+区的编码（5位）。</p>
     *
     * @return the 地区+区的编码（5位）
     */
    public java.lang.String getShortCode() {
        return shortCode;
    }

    /**
     * <p>地区+区的编码（5位）。</p>
     *
     * @param shortCode 地区+区的编码（5位）。
     */
    public void setShortCode(java.lang.String shortCode) {
        this.shortCode = shortCode;
    }

    /**
     * <p>地区+区的名称。</p>
     *
     * @return the 地区+区的名称
     */
    public java.lang.String getShortName() {
        return shortName;
    }

    /**
     * <p>地区+区的名称。</p>
     *
     * @param shortName 地区+区的名称。
     */
    public void setShortName(java.lang.String shortName) {
        this.shortName = shortName;
    }

    /**
     * <p>大区+省+地区的编码（9位）。</p>
     *
     * @return the 大区+省+地区的编码（9位）
     */
    public java.lang.String getFullCodeP() {
        return fullCodeP;
    }

    /**
     * <p>大区+省+地区的编码（9位）。</p>
     *
     * @param fullCodeP 大区+省+地区的编码（9位）。
     */
    public void setFullCodeP(java.lang.String fullCodeP) {
        this.fullCodeP = fullCodeP;
    }

    /**
     * <p>大区+省+地区的名称。</p>
     *
     * @return the 大区+省+地区的名称
     */
    public java.lang.String getFullNameP() {
        return fullNameP;
    }

    /**
     * <p>大区+省+地区的名称。</p>
     *
     * @param fullNameP 大区+省+地区的名称。
     */
    public void setFullNameP(java.lang.String fullNameP) {
        this.fullNameP = fullNameP;
    }

    /**
     * <p>大区+物流区+地区的编码（9位）。</p>
     *
     * @return the 大区+物流区+地区的编码（9位）
     */
    public java.lang.String getFullCodeL() {
        return fullCodeL;
    }

    /**
     * <p>大区+物流区+地区的编码（9位）。</p>
     *
     * @param fullCodeL 大区+物流区+地区的编码（9位）。
     */
    public void setFullCodeL(java.lang.String fullCodeL) {
        this.fullCodeL = fullCodeL;
    }

    /**
     * <p>大区+物流区+地区的名称。</p>
     *
     * @return the 大区+物流区+地区的名称
     */
    public java.lang.String getFullNameL() {
        return fullNameL;
    }

    /**
     * <p>大区+物流区+地区的名称。</p>
     *
     * @param fullNameL 大区+物流区+地区的名称。
     */
    public void setFullNameL(java.lang.String fullNameL) {
        this.fullNameL = fullNameL;
    }

}
