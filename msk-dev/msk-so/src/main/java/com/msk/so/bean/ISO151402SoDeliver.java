package com.msk.so.bean;

import com.msk.core.bean.RsPageResult;
import com.msk.core.entity.SoDeliver;

import java.util.List;

/**
 * Created by liu_tao2 on 2016/4/19.
 */
public class ISO151402SoDeliver extends SoDeliver {

    private String deliverModeStr;

    public String getDeliverModeStr() {
        return deliverModeStr;
    }

    public void setDeliverModeStr(String deliverModeStr) {
        this.deliverModeStr = deliverModeStr;
    }
}
