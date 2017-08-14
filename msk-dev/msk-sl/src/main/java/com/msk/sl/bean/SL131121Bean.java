package com.msk.sl.bean;

import com.msk.core.entity.PdLogiarea;
import com.msk.core.entity.SlPdLgcs;
import com.msk.sl.bean.SlLogiAreaPdBean;

/**
 * PD141121Bean.
 * @author yuan_chen
 */
public class SL131121Bean extends SlPdLgcs {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 卖家名称 */
    private String slName;
    /** 物流区名称 */
    private String lgcsName;
    /** 类别名称 */
    private String classesName;
    /** 品种名称 */
    private String breedName;
    /** 特征名称 */
    private String featureName;
    /** checkFlag */
    private int checkFlag;

    /**
     * Getter method for property <tt>slName</tt>.
     *
     * @return property value of slName
     */
    public String getSlName() {
        return slName;
    }

    /**
     * Setter method for property <tt>slName</tt>.
     *
     * @param slName value to be assigned to property slName
     */
    public void setSlName(String slName) {
        this.slName = slName;
    }

    /**
     * Getter method for property <tt>lgcsName</tt>.
     *
     * @return property value of lgcsName
     */
    public String getLgcsName() {
        return lgcsName;
    }

    /**
     * Setter method for property <tt>lgcsName</tt>.
     *
     * @param lgcsName value to be assigned to property lgcsName
     */
    public void setLgcsName(String lgcsName) {
        this.lgcsName = lgcsName;
    }

    /**
     * Getter method for property <tt>classesName</tt>.
     *
     * @return property value of classesName
     */
    public String getClassesName() {
        return classesName;
    }

    /**
     * Setter method for property <tt>classesName</tt>.
     *
     * @param classesName value to be assigned to property classesName
     */
    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    /**
     * Getter method for property <tt>breedName</tt>.
     *
     * @return property value of breedName
     */
    public String getBreedName() {
        return breedName;
    }

    /**
     * Setter method for property <tt>breedName</tt>.
     *
     * @param breedName value to be assigned to property breedName
     */
    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    /**
     * Getter method for property <tt>featureName</tt>.
     *
     * @return property value of featureName
     */
    public String getFeatureName() {
        return featureName;
    }

    /**
     * Setter method for property <tt>featureName</tt>.
     *
     * @param featureName value to be assigned to property featureName
     */
    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    /**
     * Getter method for property <tt>checkFlag</tt>.
     *
     * @return property value of checkFlag
     */
    public int getCheckFlag() {
        return checkFlag;
    }

    /**
     * Setter method for property <tt>checkFlag</tt>.
     *
     * @param checkFlag value to be assigned to property checkFlag
     */
    public void setCheckFlag(int checkFlag) {
        this.checkFlag = checkFlag;
    }
}
