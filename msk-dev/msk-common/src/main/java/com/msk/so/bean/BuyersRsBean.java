package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

/**
 *
 * 调用买家模块接口
 * @author sun_jiaju
 */
public class BuyersRsBean extends BaseEntity {
    //买家编码
    private  String buyerCode;
    //买家Id
    private String buyerId;

    public String getBuyerCode() {
        return buyerCode;
    }

    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
}
