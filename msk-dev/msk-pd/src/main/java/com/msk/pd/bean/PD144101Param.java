package com.msk.pd.bean;


import com.msk.core.bean.BaseParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * PD144101Param.
 *
 * @author gyh
 */
public class PD144101Param extends BaseParam {
    // 轮播图片主键ID.
    private String id;
    // 轮播图片顺序.
    private String sort;
    // 首页轮播图片.
    private String scrollImg;
    // 上传方式 0:ftp 1:图片服务器.
    private String type;
    // 模块高度.
    private int modelHeight;
    /** 原始图片名称 */
    private java.lang.String originalImgName;

    private MultipartFile productImgFile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getModelHeight() {
        return modelHeight;
    }

    public void setModelHeight(int modelHeight) {
        this.modelHeight = modelHeight;
    }

    public String getScrollImg() {
        return "<img src='" + scrollImg + "' style='width:20px;height:20px;'" + "/>";
    }

    public void setScrollImg(String scrollImg) {
        this.scrollImg = scrollImg;
    }

    public MultipartFile getProductImgFile() {
        return productImgFile;
    }

    public void setProductImgFile(MultipartFile productImgFile) {
        this.productImgFile = productImgFile;
    }

    public String getOriginalImgName() {
        return originalImgName;
    }

    public void setOriginalImgName(String originalImgName) {
        this.originalImgName = originalImgName;
    }
}