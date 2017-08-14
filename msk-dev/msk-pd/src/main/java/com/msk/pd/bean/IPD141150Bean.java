package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * Created by ren_qiang on 2016/11/3.
 */
public class IPD141150Bean extends BaseEntity {

    private  String  pdCode;
    private String pdScrollImg;
    private String type;
    private String originalImgName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdScrollImg() {
        return pdScrollImg;
    }

    public void setPdScrollImg(String pdScrollImg) {
        this.pdScrollImg = pdScrollImg;
    }

    public String getOriginalImgName() {
        return originalImgName;
    }

    public void setOriginalImgName(String originalImgName) {
        this.originalImgName = originalImgName;
    }
}
