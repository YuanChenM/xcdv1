package com.msk.ds.bean;

import com.msk.core.bean.BaseBean;

import java.util.List;


/**
 * ISC1891I1RsResult.
 *
 * @author xu_wei
 */
public class ISC1892I1RsResult extends BaseBean {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 1:未申请,2:申请中,3:已确认,4::待收货,5:已收货,6:部分收货
     */
    private java.lang.String deliveryStockStatus;
    /**
     * 产品相关的信息
     */
    private List<ISC1892I1Bean> returnInfos;

    public String getDeliveryStockStatus() {
        return deliveryStockStatus;
    }

    public void setDeliveryStockStatus(String deliveryStockStatus) {
        this.deliveryStockStatus = deliveryStockStatus;
    }

    public List<ISC1892I1Bean> getReturnInfos() {
        return returnInfos;
    }

    public void setReturnInfos(List<ISC1892I1Bean> returnInfos) {
        this.returnInfos = returnInfos;
    }


}
