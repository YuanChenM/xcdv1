package com.msk.so.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * Created by wang_shuai on 2016/6/22.
 */
public class ISO151429RsResult extends RsPageResult {
    private List<ISO151429HouseKeepingPd> houseKeepingPdList;

    public List<ISO151429HouseKeepingPd> getHouseKeepingPdList() {
        return houseKeepingPdList;
    }

    public void setHouseKeepingPdList(List<ISO151429HouseKeepingPd> houseKeepingPdList) {
        this.houseKeepingPdList = houseKeepingPdList;
    }
}
