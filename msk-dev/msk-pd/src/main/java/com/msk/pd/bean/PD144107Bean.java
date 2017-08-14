package com.msk.pd.bean;


import com.msk.core.bean.BaseBean;

/**
 * Created by yang_chunyan on 2016/10/27.
 */
public class PD144107Bean extends BaseBean {
    //主键ID
    private String id;
    //产品编码
    private String pdCode;
    //产品名称
    private String pdName;
    //封面图片
    private String coverImg;
    //产品轮播图片
    private String appImg;
    //排序
    private String sort;
    //使用场景
    private String imgFunction;
    //上传类型
    private String type;

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getAppImg() {
        String img = "<img src='" + appImg + "' style='width:20px;height:20px;'" + "/>";
        return img;
    }

    public void setAppImg(String appImg) {
        this.appImg = appImg;
    }

    public String getImgFunction() {
        return imgFunction;
    }

    public void setImgFunction(String imgFunction) {
        this.imgFunction = imgFunction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
