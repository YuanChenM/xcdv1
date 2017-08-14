package com.msk.pl.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * Created by gyh on 2017/2/9.
 * 合伙人任务完成统计
 */
public class IPL20170223RsResult extends RsPageResult {
    //合伙人计费查询结果
    private List<IPL20170223RsResultBean> bsTaskList;

    /**
     * Getter method for property <tt>bsTaskList</tt>.
     *
     * @return property value of bsTaskList
     */
    public List<IPL20170223RsResultBean> getBsTaskList() {
        return bsTaskList;
    }

    /**
     * Setter method for property <tt>bsTaskList</tt>.
     *
     * @param bsTaskList value to be assigned to property bsTaskList
     */
    public void setBsTaskList(List<IPL20170223RsResultBean> bsTaskList) {
        this.bsTaskList = bsTaskList;
    }
}
