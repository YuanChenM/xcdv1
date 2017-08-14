package com.msk.pd.bean;

import com.msk.core.entity.BaseEntity;
import com.msk.core.entity.PdAppImg;
import com.msk.core.entity.PdAppScrollImg;
import com.msk.core.entity.PdAppScrollImgSetting;

import java.util.List;

/**
 * Created by ren_qiang on 2016/11/3.
 */
public class IPD141150Result extends BaseEntity {

    private  List<IPD141150Bean>    pdScrollImgList;

    public List<IPD141150Bean> getPdScrollImgList() {
        return pdScrollImgList;
    }

    public void setPdScrollImgList(List<IPD141150Bean> pdScrollImgList) {
        this.pdScrollImgList = pdScrollImgList;
    }
}
