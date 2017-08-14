package com.msk.bs.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * Created by cx on 2016/4/14.
 */
public class IBS2101112RsResult extends RsPageResult{

    private List<IBS2101112Bean> slBuyerList;

    /**
     * Getter method for property <tt>slBuyerList</tt>.
     *
     * @return property value of slBuyerList
     */
    public List<IBS2101112Bean> getSlBuyerList() {
        return slBuyerList;
    }

    /**
     * Setter method for property <tt>slBuyerList</tt>.
     *
     * @param slBuyerList value to be assigned to property slBuyerList
     */
    public void setSlBuyerList(List<IBS2101112Bean> slBuyerList) {
        this.slBuyerList = slBuyerList;
    }
}
