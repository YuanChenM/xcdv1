package com.msk.so.bean;

import com.msk.core.bean.BaseBean;

import java.util.List;

/**
 * 
 * ISO151405RsResult接口返回结果信息.
 *
 * @author sjj
 */
public class ISO151406RsResult extends BaseBean {

    private List<HouseAccountSalesResult> salesList;

    public List<HouseAccountSalesResult> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<HouseAccountSalesResult> salesList) {
        this.salesList = salesList;
    }
}
