package com.msk.so.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * Created by wang_shuai on 2016/6/23.
 */
public class ISO151427Result extends RsPageResult {
    private List<ISO151427SettlementDetail> resultList;

    public List<ISO151427SettlementDetail> getResultList() {
        return resultList;
    }

    public void setResultList(List<ISO151427SettlementDetail> resultList) {
        this.resultList = resultList;
    }
}
