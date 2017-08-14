package com.msk.bs.bean;

import com.msk.core.bean.RsPageResult;
import com.msk.core.entity.SlAccount;

import java.util.List;

public class IBS2101103RsResult extends RsPageResult{
    //public class IBS2101103RsResult extends RsPageResult {

    private List<IBS210110301Bean> buyershopList;

    /**
     * Getter method for property <tt>buyershopList</tt>.
     *
     * @return property value of buyershopList
     */
    public List<IBS210110301Bean> getBuyershopList() {
        return buyershopList;
    }

    /**
     * Setter method for property <tt>buyershopList</tt>.
     *
     * @param buyershopList value to be assigned to property buyershopList
     */
    public void setBuyershopList(List<IBS210110301Bean> buyershopList) {
        this.buyershopList = buyershopList;
    }
}
