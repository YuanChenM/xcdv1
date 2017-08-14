package com.msk.pl.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * Created by gyh on 2017/2/7.
 * 合伙人进货单bean
 */
public class IPL20170217RsResult extends RsPageResult {
    //存放合伙人进货单列表
    private List<IPL20170217RsResultBean> plInfoList;

    /**
     * Getter method for property <tt>plInfoList</tt>.
     *
     * @return property value of plInfoList
     */
    public List<IPL20170217RsResultBean> getPlInfoList() {
        return plInfoList;
    }

    /**
     * Setter method for property <tt>plInfoList</tt>.
     *
     * @param plInfoList value to be assigned to property plInfoList
     */
    public void setPlInfoList(List<IPL20170217RsResultBean> plInfoList) {
        this.plInfoList = plInfoList;
    }
}
