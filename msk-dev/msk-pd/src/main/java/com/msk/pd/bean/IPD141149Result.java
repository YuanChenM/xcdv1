package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;
import com.msk.core.entity.PdAppScrollImg;
import com.msk.core.entity.PdAppScrollImgSetting;

import java.util.List;

/**
 * Created by ren_qiang on 2016/11/3.
 */
public class IPD141149Result extends BaseEntity {

    private PdAppScrollImgSetting ImgSetting;

    private List<PdAppScrollImg> scrollImgs;

    public PdAppScrollImgSetting getImgSetting() {
        return ImgSetting;
    }

    public void setImgSetting(PdAppScrollImgSetting imgSetting) {
        ImgSetting = imgSetting;
    }

    public List<PdAppScrollImg> getScrollImgs() {
        return scrollImgs;
    }

    public void setScrollImgs(List<PdAppScrollImg> scrollImgs) {
        this.scrollImgs = scrollImgs;
    }
}
