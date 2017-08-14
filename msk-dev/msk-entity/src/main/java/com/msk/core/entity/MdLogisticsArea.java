/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表md_logistics_area对应的MdLogisticsArea。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class MdLogisticsArea extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 物流区ID */
    private java.lang.Long lgcsAreaId;
    /** 大区ID */
    private java.lang.Long areaId;
    /** 物流区编码 */
    private java.lang.String lgcsAreaCode;
    /** 物流区名称 */
    private java.lang.String lgcsAreaName;
    /** 划分级别（大区1，省和物流区2，地区和城市3，区4） */
    private java.math.BigDecimal divisionLevel;
    /** 拼音 */
    private java.lang.String spell;
    /** 拼音首字母缩写 */
    private java.lang.String shortSpell;
    /** 大区+物流区的编码（4位） */
    private java.lang.String fullCode;
    /** 大区+物流区的名称 */
    private java.lang.String fullName;
    /**
     * <p>默认构造函数。</p>
     */
    public MdLogisticsArea() {

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
     * <p>大区ID。</p>
     *
     * @return the 大区ID
     */
    public java.lang.Long getAreaId() {
        return areaId;
    }

    /**
     * <p>大区ID。</p>
     *
     * @param areaId 大区ID。
     */
    public void setAreaId(java.lang.Long areaId) {
        this.areaId = areaId;
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
     * <p>物流区名称。</p>
     *
     * @return the 物流区名称
     */
    public java.lang.String getLgcsAreaName() {
        return lgcsAreaName;
    }

    /**
     * <p>物流区名称。</p>
     *
     * @param lgcsAreaName 物流区名称。
     */
    public void setLgcsAreaName(java.lang.String lgcsAreaName) {
        this.lgcsAreaName = lgcsAreaName;
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
     * <p>大区+物流区的编码（4位）。</p>
     *
     * @return the 大区+物流区的编码（4位）
     */
    public java.lang.String getFullCode() {
        return fullCode;
    }

    /**
     * <p>大区+物流区的编码（4位）。</p>
     *
     * @param fullCode 大区+物流区的编码（4位）。
     */
    public void setFullCode(java.lang.String fullCode) {
        this.fullCode = fullCode;
    }

    /**
     * <p>大区+物流区的名称。</p>
     *
     * @return the 大区+物流区的名称
     */
    public java.lang.String getFullName() {
        return fullName;
    }

    /**
     * <p>大区+物流区的名称。</p>
     *
     * @param fullName 大区+物流区的名称。
     */
    public void setFullName(java.lang.String fullName) {
        this.fullName = fullName;
    }

}
