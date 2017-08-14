/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表pd_app_img对应的PdAppImg。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class PdAppImg extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 主键ID */
    private java.lang.Long id;
    /** 产品编码 */
    private java.lang.String pdCode;
    /** 顺序 */
    private java.lang.String sort;
    /** 图片 */
    private java.lang.String appImg;
    /** 上传方式 0:ftp 1:图片服务器 */
    private java.lang.String type;
    /** 适用场景 0:封面 1:产品轮播图 */
    private java.lang.String imgFunction;
    /** 原始图片名称 */
    private java.lang.String originalImgName;
    /**
     * <p>默认构造函数。</p>
     */
    public PdAppImg() {

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
     * <p>产品编码。</p>
     *
     * @return the 产品编码
     */
    public java.lang.String getPdCode() {
        return pdCode;
    }

    /**
     * <p>产品编码。</p>
     *
     * @param pdCode 产品编码。
     */
    public void setPdCode(java.lang.String pdCode) {
        this.pdCode = pdCode;
    }

    /**
     * <p>顺序。</p>
     *
     * @return the 顺序
     */
    public java.lang.String getSort() {
        return sort;
    }

    /**
     * <p>顺序。</p>
     *
     * @param sort 顺序。
     */
    public void setSort(java.lang.String sort) {
        this.sort = sort;
    }

    /**
     * <p>图片。</p>
     *
     * @return the 图片
     */
    public java.lang.String getAppImg() {
        return appImg;
    }

    /**
     * <p>图片。</p>
     *
     * @param appImg 图片。
     */
    public void setAppImg(java.lang.String appImg) {
        this.appImg = appImg;
    }

    /**
     * <p>上传方式 0:ftp 1:图片服务器。</p>
     *
     * @return the 上传方式 0:ftp 1:图片服务器
     */
    public java.lang.String getType() {
        return type;
    }

    /**
     * <p>上传方式 0:ftp 1:图片服务器。</p>
     *
     * @param type 上传方式 0:ftp 1:图片服务器。
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }

    /**
     * <p>适用场景 0:封面 1:产品轮播图。</p>
     *
     * @return the 适用场景 0:封面 1:产品轮播图
     */
    public java.lang.String getImgFunction() {
        return imgFunction;
    }

    /**
     * <p>适用场景 0:封面 1:产品轮播图。</p>
     *
     * @param imgFunction 适用场景 0:封面 1:产品轮播图。
     */
    public void setImgFunction(java.lang.String imgFunction) {
        this.imgFunction = imgFunction;
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
