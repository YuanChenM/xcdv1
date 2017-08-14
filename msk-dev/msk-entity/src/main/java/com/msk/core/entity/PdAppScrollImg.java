/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表pd_app_scroll_img对应的PdAppScrollImg。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class PdAppScrollImg extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private java.lang.Long id;
    /** 轮播顺序 */
    private java.lang.String sort;
    /** 图片 */
    private java.lang.String scrollImg;
    /**  图片上传方式 0:ftp 1:图片服务器 */
    private java.lang.String type;
    /** 原始图片名称 */
    private java.lang.String originalImgName;
    /**
     * <p>默认构造函数。</p>
     */
    public PdAppScrollImg() {

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
     * <p>轮播顺序。</p>
     *
     * @return the 轮播顺序
     */
    public java.lang.String getSort() {
        return sort;
    }

    /**
     * <p>轮播顺序。</p>
     *
     * @param sort 轮播顺序。
     */
    public void setSort(java.lang.String sort) {
        this.sort = sort;
    }

    /**
     * <p>图片。</p>
     *
     * @return the 图片
     */
    public java.lang.String getScrollImg() {
        return scrollImg;
    }

    /**
     * <p>图片。</p>
     *
     * @param scrollImg 图片。
     */
    public void setScrollImg(java.lang.String scrollImg) {
        this.scrollImg = scrollImg;
    }

    /**
     * <p> 图片上传方式 0:ftp 1:图片服务器。</p>
     *
     * @return the  图片上传方式 0:ftp 1:图片服务器
     */
    public java.lang.String getType() {
        return type;
    }

    /**
     * <p> 图片上传方式 0:ftp 1:图片服务器。</p>
     *
     * @param type  图片上传方式 0:ftp 1:图片服务器。
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }

    /**
     * <p>原始图片名称。</p>
     *
     * @return the 原始图片名称
     */
    public java.lang.String getOriginalImgName() {
        return originalImgName;
    }

    /**
     * <p>原始图片名称。</p>
     *
     * @param originalImgName 原始图片名称。
     */
    public void setOriginalImgName(java.lang.String originalImgName) {
        this.originalImgName = originalImgName;
    }

}
