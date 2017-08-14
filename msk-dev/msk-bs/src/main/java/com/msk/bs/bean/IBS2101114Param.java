package com.msk.bs.bean;


import com.msk.core.bean.BaseParam;

import java.util.List;

/**
 * Created by zhu_kai1 on 2016/7/13.
 */
public class IBS2101114Param  extends BaseParam {
    // 买家id
    private List<String> buyerIdList;

    public List<String> getBuyerIdList() {
        return buyerIdList;
    }

    public void setBuyerIdList(List<String> buyerIdList) {
        this.buyerIdList = buyerIdList;
    }
}
