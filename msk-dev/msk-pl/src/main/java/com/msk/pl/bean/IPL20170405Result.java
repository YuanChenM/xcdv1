package com.msk.pl.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * Created by taozhif on 2017/4/18.
 */
public class IPL20170405Result extends RsPageResult {

    private List<PlDeclareInfo> dtList;

    public List<PlDeclareInfo> getDtList() {
        return dtList;
    }

    public void setDtList(List<PlDeclareInfo> dtList) {
        this.dtList = dtList;
    }
}
