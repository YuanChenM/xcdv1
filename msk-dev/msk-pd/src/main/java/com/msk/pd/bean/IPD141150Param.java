package com.msk.pd.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.PdAppImg;

import java.util.List;

/**
 * Created by ren_qiang on 2016/11/3.
 */
@JsonIgnoreProperties(value = { "delFlg", "crtId", "crtTime", "updId", "updTime", "ver", "actId", "actTime" })
public class IPD141150Param extends BaseParam {

    private  String  pdCode;
    private  List<PdAppImg>    pdScrollImgList;

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public List<PdAppImg> getPdScrollImgList() {
        return pdScrollImgList;
    }

    public void setPdScrollImgList(List<PdAppImg> pdScrollImgList) {
        this.pdScrollImgList = pdScrollImgList;
    }
}
