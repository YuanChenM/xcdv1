package com.msk.pd.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.entity.BaseEntity;

/**
 * 返回参数产品等级
 * IPD141102RsParam.
 *
 * @author xhy
 */
@JsonIgnoreProperties(value = { "delFlg", "crtId", "crtTime", "updId", "updTime", "ver", "actId", "actTime" })
public class IPD141102RsParam extends BaseEntity {

    private static final long serialVersionUID = 1L;
    private String gradeCode; // 产品等级编码
    private String gradeName; // 产品等级名称

    /**
     * Get the gradeCode.
     *
     * @return gradeCode
     *
     * @author xhy
     */
    public String getGradeCode() {
        return this.gradeCode;
    }

    /**
     * Set the gradeCode.
     *
     * @param gradeCode gradeCode
     *
     * @author xhy
     */
    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    /**
     * Get the gradeName.
     *
     * @return gradeName
     *
     * @author xhy
     */
    public String getGradeName() {
        return this.gradeName;
    }

    /**
     * Set the gradeName.
     *
     * @param gradeName gradeName
     *
     * @author xhy
     */
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

}