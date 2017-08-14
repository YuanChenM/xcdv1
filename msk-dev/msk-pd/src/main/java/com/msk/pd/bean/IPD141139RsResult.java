package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;

/**
 * IPD141139RsResult.产品包装接口查询
 *
 * @author xhy
 */
public class IPD141139RsResult extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private java.lang.String normsCode;

    private java.lang.String normsName;
    /**
     * 单个产品净重
     */
    private java.lang.String normsSuttle;
    /**
     * 单个产品规格净重误差范围
     */
    private java.lang.String normsError;
    /**
     * 内包装净重/个数
     */
    private java.lang.String normsNumber;
    /**
     * 内包装尺寸
     */
    private java.lang.String normsSize;
    /**
     * 内包装材质及技术标准
     */
    private java.lang.String normsTexture;
    /**
     * 外包装规格
     */
    private java.lang.String normsOut;
    /**
     * 外包装净重/毛重
     */
    private java.lang.String normsKg;
    /**
     * 外包装尺寸
     */
    private java.lang.String normsOutSize;
    /**
     * 外包装材质及技术标准
     */
    private java.lang.String normsOutTexture;

    /**
     * Getter method for property <tt>normsCode</tt>.
     *
     * @return property value of normsCode
     */
    public String getNormsCode() {
        return normsCode;
    }

    /**
     * Setter method for property <tt>normsCode</tt>.
     *
     * @param normsCode value to be assigned to property normsCode
     */
    public void setNormsCode(String normsCode) {
        this.normsCode = normsCode;
    }

    /**
     * Getter method for property <tt>normsName</tt>.
     *
     * @return property value of normsName
     */
    public String getNormsName() {
        return normsName;
    }

    /**
     * Setter method for property <tt>normsName</tt>.
     *
     * @param normsName value to be assigned to property normsName
     */
    public void setNormsName(String normsName) {
        this.normsName = normsName;
    }

    /**
     * Getter method for property <tt>normsSuttle</tt>.
     *
     * @return property value of normsSuttle
     */
    public String getNormsSuttle() {
        return normsSuttle;
    }

    /**
     * Setter method for property <tt>normsSuttle</tt>.
     *
     * @param normsSuttle value to be assigned to property normsSuttle
     */
    public void setNormsSuttle(String normsSuttle) {
        this.normsSuttle = normsSuttle;
    }

    /**
     * Getter method for property <tt>normsError</tt>.
     *
     * @return property value of normsError
     */
    public String getNormsError() {
        return normsError;
    }

    /**
     * Setter method for property <tt>normsError</tt>.
     *
     * @param normsError value to be assigned to property normsError
     */
    public void setNormsError(String normsError) {
        this.normsError = normsError;
    }

    /**
     * Getter method for property <tt>normsNumber</tt>.
     *
     * @return property value of normsNumber
     */
    public String getNormsNumber() {
        return normsNumber;
    }

    /**
     * Setter method for property <tt>normsNumber</tt>.
     *
     * @param normsNumber value to be assigned to property normsNumber
     */
    public void setNormsNumber(String normsNumber) {
        this.normsNumber = normsNumber;
    }

    /**
     * Getter method for property <tt>normsSize</tt>.
     *
     * @return property value of normsSize
     */
    public String getNormsSize() {
        return normsSize;
    }

    /**
     * Setter method for property <tt>normsSize</tt>.
     *
     * @param normsSize value to be assigned to property normsSize
     */
    public void setNormsSize(String normsSize) {
        this.normsSize = normsSize;
    }

    /**
     * Getter method for property <tt>normsTexture</tt>.
     *
     * @return property value of normsTexture
     */
    public String getNormsTexture() {
        return normsTexture;
    }

    /**
     * Setter method for property <tt>normsTexture</tt>.
     *
     * @param normsTexture value to be assigned to property normsTexture
     */
    public void setNormsTexture(String normsTexture) {
        this.normsTexture = normsTexture;
    }

    /**
     * Getter method for property <tt>normsOut</tt>.
     *
     * @return property value of normsOut
     */
    public String getNormsOut() {
        return normsOut;
    }

    /**
     * Setter method for property <tt>normsOut</tt>.
     *
     * @param normsOut value to be assigned to property normsOut
     */
    public void setNormsOut(String normsOut) {
        this.normsOut = normsOut;
    }

    /**
     * Getter method for property <tt>normsKg</tt>.
     *
     * @return property value of normsKg
     */
    public String getNormsKg() {
        return normsKg;
    }

    /**
     * Setter method for property <tt>normsKg</tt>.
     *
     * @param normsKg value to be assigned to property normsKg
     */
    public void setNormsKg(String normsKg) {
        this.normsKg = normsKg;
    }

    /**
     * Getter method for property <tt>normsOutSize</tt>.
     *
     * @return property value of normsOutSize
     */
    public String getNormsOutSize() {
        return normsOutSize;
    }

    /**
     * Setter method for property <tt>normsOutSize</tt>.
     *
     * @param normsOutSize value to be assigned to property normsOutSize
     */
    public void setNormsOutSize(String normsOutSize) {
        this.normsOutSize = normsOutSize;
    }

    /**
     * Getter method for property <tt>normsOutTexture</tt>.
     *
     * @return property value of normsOutTexture
     */
    public String getNormsOutTexture() {
        return normsOutTexture;
    }

    /**
     * Setter method for property <tt>normsOutTexture</tt>.
     *
     * @param normsOutTexture value to be assigned to property normsOutTexture
     */
    public void setNormsOutTexture(String normsOutTexture) {
        this.normsOutTexture = normsOutTexture;
    }
}