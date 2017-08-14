package com.msk.pd.bean;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.RsPageResult;
import com.msk.core.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 首页产品楼层接口
 * Created by ren_qiang on 2016/11/3.
 */
public class IPD141151Result extends RsPageResult  implements Serializable {

    private List<IPD141151Bean> floorList;

    public List<IPD141151Bean> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<IPD141151Bean> floorList) {
        this.floorList = floorList;
    }
}
