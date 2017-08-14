package com.msk.pd.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.entity.BaseEntity;

/**
 * 查询产品主码
 * IPD141105RsParam.
 *
 * @author xhy
 */
@JsonIgnoreProperties(value = { "delFlg", "crtId", "crtTime", "updId", "updTime", "ver", "actId", "actTime","breedCode","featureCode","gradeCode","breedName","featureName","gradeName" })
public class IPD141105RsParam extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private String classesCode; // 类别编码
    private Integer codeLevel;

    /**
     * Getter method for property <tt>classesCode</tt>.
     *
     * @return property value of classesCode
     */
    public String getClassesCode() {
        return classesCode;
    }

    /**
     * Setter method for property <tt>classesCode</tt>.
     *
     * @param classesCode value to be assigned to property classesCode
     */
    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    /**
     * Getter method for property <tt>codeLevel</tt>.
     *
     * @return property value of codeLevel
     */
    public Integer getCodeLevel() {
        return codeLevel;
    }

    /**
     * Setter method for property <tt>codeLevel</tt>.
     *
     * @param codeLevel value to be assigned to property codeLevel
     */
    public void setCodeLevel(Integer codeLevel) {
        this.codeLevel = codeLevel;
    }
}