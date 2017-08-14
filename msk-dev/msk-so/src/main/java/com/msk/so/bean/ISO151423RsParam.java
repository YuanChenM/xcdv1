package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

/**
 * Created by liu_tao2 on 2016/4/18.
 */
public class ISO151423RsParam extends BaseParam {
    public ISO151423RsParam(){}

    /**
     *管家ID
     */
    private String sellers ;

    /**
     *卖家编码
     */
    private String sellerCode;

    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public String getSellers() {
        return sellers;
    }

    public void setSellers(String sellers) {
        this.sellers = sellers;
    }
}
