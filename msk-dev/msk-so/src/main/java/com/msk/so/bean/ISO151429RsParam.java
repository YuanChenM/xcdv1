package com.msk.so.bean;

import com.msk.core.bean.RsPageParam;

/**
 * Created by wang_shuai on 2016/6/22.
 */
public class ISO151429RsParam extends RsPageParam {
    //管家id
    private String houseCode;
    //管家编码
    private String houseCodeDis;
    //物流区code
    private String lgcsCode;

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    public String getHouseCodeDis() {
        return houseCodeDis;
    }

    public void setHouseCodeDis(String houseCodeDis) {
        this.houseCodeDis = houseCodeDis;
    }

    public String getLgcsCode() {
        return lgcsCode;
    }

    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }
}
