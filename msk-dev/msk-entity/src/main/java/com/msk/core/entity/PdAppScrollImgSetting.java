/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表pd_app_scroll_img_setting对应的PdAppScrollImgSetting。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class PdAppScrollImgSetting extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private java.lang.Long id;
    /** 模块高度 */
    private java.math.BigDecimal modelHeight;
    /**
     * <p>默认构造函数。</p>
     */
    public PdAppScrollImgSetting() {

    }

    /**
     * <p>主键ID。</p>
     *
     * @return the 主键ID
     */
    public java.lang.Long getId() {
        return id;
    }

    /**
     * <p>主键ID。</p>
     *
     * @param id 主键ID。
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    /**
     * <p>模块高度。</p>
     *
     * @return the 模块高度
     */
    public java.math.BigDecimal getModelHeight() {
        return modelHeight;
    }

    /**
     * <p>模块高度。</p>
     *
     * @param modelHeight 模块高度。
     */
    public void setModelHeight(java.math.BigDecimal modelHeight) {
        this.modelHeight = modelHeight;
    }

}
