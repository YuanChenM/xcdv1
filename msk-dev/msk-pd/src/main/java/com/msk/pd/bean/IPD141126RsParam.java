package com.msk.pd.bean;

import com.msk.core.bean.RsPageParam;

/**
 * Created by FjM on 2016/3/10.
 */
public class IPD141126RsParam extends RsPageParam{
    /** serialVersionUID */
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
