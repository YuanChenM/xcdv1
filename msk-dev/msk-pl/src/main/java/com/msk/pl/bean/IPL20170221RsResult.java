package com.msk.pl.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * Created by gyh on 2017/2/8.
 * 合伙人计费查询结果
 */
public class IPL20170221RsResult extends RsPageResult {
    //合伙人计费查询结果
    private List<IPL20170221RsResultBean> partnerFeeList;

    /**
     * Getter method for property <tt>partnerFeeList</tt>.
     *
     * @return property value of partnerFeeList
     */
    public List<IPL20170221RsResultBean> getPartnerFeeList() {
        return partnerFeeList;
    }

    /**
     * Setter method for property <tt>partnerFeeList</tt>.
     *
     * @param partnerFeeList value to be assigned to property partnerFeeList
     */
    public void setPartnerFeeList(List<IPL20170221RsResultBean> partnerFeeList) {
        this.partnerFeeList = partnerFeeList;
    }
}
