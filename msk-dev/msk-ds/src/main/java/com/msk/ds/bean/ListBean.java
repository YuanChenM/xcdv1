package com.msk.ds.bean;

import com.msk.core.bean.BaseBean;

import java.util.List;

/**
 * Created by air on 2016/2/24.
 */
public class ListBean extends BaseBean{


    private List<ItemBean> list;

    public List<ItemBean> getList() {
        return list;
    }

    public void setList(List<ItemBean> list) {
        this.list = list;
    }


}
