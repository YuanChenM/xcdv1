package com.msk.pl.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * Created by zhao_chen on 2017/4/18.
 */
public class IPL20170412RsPageResult extends RsPageResult {

    private List<IPL20170412Result> dataList;

    public List<IPL20170412Result> getDataList() {
        return dataList;
    }

    public void setDataList(List<IPL20170412Result> dataList) {
        this.dataList = dataList;
    }

}
