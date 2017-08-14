package com.msk.pl.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * Created by zhao_chen on 2017/4/18.
 */
public class IPL20170411RsPageResult extends RsPageResult {

    private List<IPL20170411Result> bsTaskList;

    public List<IPL20170411Result> getBsTaskList() {
        return bsTaskList;
    }

    public void setBsTaskList(List<IPL20170411Result> bsTaskList) {
        this.bsTaskList = bsTaskList;
    }
}
