/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表md_city对应的MdCity。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class MdCity extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 地区ID */
    private java.lang.Long cityId;
    /** 省ID */
    private java.lang.Long provinceId;
    /** 物流区ID */
    private java.lang.Long lgcsAreaId;
    /** 地区编码 */
    private java.lang.String cityCode;
    /** 地区名称 */
    private java.lang.String cityName;
    /** 划分级别（大区1，省和物流区2，地区和城市3，区4） */
    private java.math.BigDecimal divisionLevel;
    /** 拼音 */
    private java.lang.String spell;
    /** 拼音首字母缩写 */
    private java.lang.String shortSpell;
    /** 省+地区的编码（5位） */
    private java.lang.String shortCodeP;
    /** 省+地区的名称 */
    private java.lang.String shortNameP;
    /** 物流区+地区的编码（5位） */
    private java.lang.String shortCodeL;
    /** 物流区+地区的名称 */
    private java.lang.String shortNameL;
    /** 大区+省+地区的编码（7位） */
    private java.lang.String fullCodeP;
    /** 大区+省+地区的名称 */
    private java.lang.String fullNameP;
    /** 大区+物流区+地区的编码（7位） */
    private java.lang.String fullCodeL;
    /** 大区+物流区+地区的名称 */
    private java.lang.String fullNameL;
    /**
     * <p>默认构造函数。</p>
     */
    public MdCity() {

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
     * <p>省ID。</p>
     *
     * @return the 省ID
     */
    public java.lang.Long getProvinceId() {
        return provinceId;
    }

    /**
     * <p>省ID。</p>
     *
     * @param provinceId 省ID。
     */
    public void setProvinceId(java.lang.Long provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * <p>物流区ID。</p>
     *
     * @return the 物流区ID
     */
    public java.lang.Long getLgcsAreaId() {
        return lgcsAreaId;
    }

    /**
     * <p>物流区ID。</p>
     *
     * @param lgcsAreaId 物流区ID。
     */
    public void setLgcsAreaId(java.lang.Long lgcsAreaId) {
        this.lgcsAreaId = lgcsAreaId;
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
     * <p>地区名称。</p>
     *
     * @return the 地区名称
     */
    public java.lang.String getCityName() {
        return cityName;
    }

    /**
     * <p>地区名称。</p>
     *
     * @param cityName 地区名称。
     */
    public void setCityName(java.lang.String cityName) {
        this.cityName = cityName;
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
     * <p>省+地区的编码（5位）。</p>
     *
     * @return the 省+地区的编码（5位）
     */
    public java.lang.String getShortCodeP() {
        return shortCodeP;
    }

    /**
     * <p>省+地区的编码（5位）。</p>
     *
     * @param shortCodeP 省+地区的编码（5位）。
     */
    public void setShortCodeP(java.lang.String shortCodeP) {
        this.shortCodeP = shortCodeP;
    }

    /**
     * <p>省+地区的名称。</p>
     *
     * @return the 省+地区的名称
     */
    public java.lang.String getShortNameP() {
        return shortNameP;
    }

    /**
     * <p>省+地区的名称。</p>
     *
     * @param shortNameP 省+地区的名称。
     */
    public void setShortNameP(java.lang.String shortNameP) {
        this.shortNameP = shortNameP;
    }

    /**
     * <p>物流区+地区的编码（5位）。</p>
     *
     * @return the 物流区+地区的编码（5位）
     */
    public java.lang.String getShortCodeL() {
        return shortCodeL;
    }

    /**
     * <p>物流区+地区的编码（5位）。</p>
     *
     * @param shortCodeL 物流区+地区的编码（5位）。
     */
    public void setShortCodeL(java.lang.String shortCodeL) {
        this.shortCodeL = shortCodeL;
    }

    /**
     * <p>物流区+地区的名称。</p>
     *
     * @return the 物流区+地区的名称
     */
    public java.lang.String getShortNameL() {
        return shortNameL;
    }

    /**
     * <p>物流区+地区的名称。</p>
     *
     * @param shortNameL 物流区+地区的名称。
     */
    public void setShortNameL(java.lang.String shortNameL) {
        this.shortNameL = shortNameL;
    }

    /**
     * <p>大区+省+地区的编码（7位）。</p>
     *
     * @return the 大区+省+地区的编码（7位）
     */
    public java.lang.String getFullCodeP() {
        return fullCodeP;
    }

    /**
     * <p>大区+省+地区的编码（7位）。</p>
     *
     * @param fullCodeP 大区+省+地区的编码（7位）。
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
     * <p>大区+物流区+地区的编码（7位）。</p>
     *
     * @return the 大区+物流区+地区的编码（7位）
     */
    public java.lang.String getFullCodeL() {
        return fullCodeL;
    }

    /**
     * <p>大区+物流区+地区的编码（7位）。</p>
     *
     * @param fullCodeL 大区+物流区+地区的编码（7位）。
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
