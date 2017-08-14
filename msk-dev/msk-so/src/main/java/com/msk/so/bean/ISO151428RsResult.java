package com.msk.so.bean;

import com.msk.core.bean.RsPageResult;

import java.util.Date;
import java.util.List;

/**
 * Created by wang_shuai on 2016/6/22.
 */
public class ISO151428RsResult extends RsPageResult {
    private List<ISO151428BuyRecord> buyRecordList;

    public List<ISO151428BuyRecord> getBuyRecordList() {
        return buyRecordList;
    }

    public void setBuyRecordList(List<ISO151428BuyRecord> buyRecordList) {
        this.buyRecordList = buyRecordList;
    }
}
