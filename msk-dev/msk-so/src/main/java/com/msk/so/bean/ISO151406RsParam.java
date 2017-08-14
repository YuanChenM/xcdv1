package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

import java.util.List;

/**
 * 
 * ISO151406RsParam接受参数.
 *
 * @author sjj
 */
public class ISO151406RsParam extends BaseParam {
    // 参数列表
    private List<HouseAccountBean> houseAccountList;

    public List<HouseAccountBean> getHouseAccountList() {
        return houseAccountList;
    }

    public void setHouseAccountList(List<HouseAccountBean> houseAccountList) {
        this.houseAccountList = houseAccountList;
    }
}
