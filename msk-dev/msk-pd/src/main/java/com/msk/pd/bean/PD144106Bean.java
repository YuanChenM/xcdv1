package com.msk.pd.bean;


import com.msk.core.bean.BaseBean;
import com.msk.core.entity.PdAppImg;

/**
 * Created by yang_chunyan on 2016/10/27.
 */
public class PD144106Bean extends PdAppImg {
    //产品编码
    private String pdCode;
    //产品名称
    private String pdName;
    //物流区编码
    private String lgcsCode;
    //物流区名称
    private String lgcsName;
    //状态
    private String status;
    //标签
    private String pdLabel;

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

    public String getLgcsCode() {
        return lgcsCode;
    }

    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    public String getLgcsName() {
        return lgcsName;
    }

    public void setLgcsName(String lgcsName) {
        this.lgcsName = lgcsName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPdLabel() {
        return pdLabel;
    }

    public void setPdLabel(String pdLabel) {
        this.pdLabel = pdLabel;
    }
}
