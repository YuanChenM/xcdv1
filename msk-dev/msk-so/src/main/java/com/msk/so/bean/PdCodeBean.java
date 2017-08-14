package com.msk.so.bean;

import com.msk.core.bean.BaseParam;


/**
 *
 * 产品编码10位格式.
 *
 * @author sjj
 */
public class PdCodeBean extends BaseParam {
    /** 产品编码10位格式*/
    private String pdCode;

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }
}