package com.msk.pd.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.entity.BaseEntity;

/**
 * Created by fjm on 2016/3/9.
 */
@JsonIgnoreProperties(value={"delFlg","crtId","crtTime","updId","updTime","ver","actId","actTime"})
public class IPD141122RsParam extends BaseEntity{
    private static final long serialVersionUID = 1L;

    private String classesCode;// 类别编码

    private String machiningCode; // 品种编码

    private String breedCode; // 特征编码







    public String getClassesCode() {
        return classesCode;
    }

    public void setClassesCode(String classesCode) {
        this.classesCode = classesCode;
    }

    public String getMachiningCode() {
        return machiningCode;
    }

    public void setMachiningCode(String machiningCode) {
        this.machiningCode = machiningCode;
    }

    public String getBreedCode() {
        return breedCode;
    }

    public void setBreedCode(String breedCode) {
        this.breedCode = breedCode;
    }


}
