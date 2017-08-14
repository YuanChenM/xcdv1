package com.msk.pd.bean;

import com.msk.core.bean.BaseBean;

import java.util.List;

/**
 * PD141124Bean. 产品分类加工bean
 *
 * @author xhy
 */
public class PD141124Bean extends BaseBean {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String classesTreeCode;

    private List<PD141124Level2Bean> level2Beans;

    private String levelName;

    private String levelCode;

    /**
     * Getter method for property <tt>levelCode</tt>.
     *
     * @return property value of levelCode
     */
    public String getLevelCode() {
        return levelCode;
    }

    /**
     * Setter method for property <tt>levelCode</tt>.
     *
     * @param levelCode value to be assigned to property levelCode
     */
    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    /**
     * 获得levelName
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * 设置levelName
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }


    /**
     * 获得classesTreeCode
     */
    public String getClassesTreeCode() {
        return classesTreeCode;
    }

    /**
     * 设置classesTreeCode
     */
    public void setClassesTreeCode(String classesTreeCode) {
        this.classesTreeCode = classesTreeCode;
    }

    /**
     * 获得classesCode
     */


    /**
     * 获得level2Beans
     */
    public List<PD141124Level2Bean> getLevel2Beans() {
        return level2Beans;
    }

    /**
     * 设置level2Beans
     */
    public void setLevel2Beans(List<PD141124Level2Bean> level2Beans) {
        this.level2Beans = level2Beans;
    }


}
