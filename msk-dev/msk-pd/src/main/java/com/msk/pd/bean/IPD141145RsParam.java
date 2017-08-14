package com.msk.pd.bean;

import com.msk.core.bean.RsPageParam;

/**
 * Created by gyh on 2016/4/20.
 */
public class IPD141145RsParam extends RsPageParam{
    private String sellerCode;//卖家id

    /**
     * Getter method for property <tt>sellerCode</tt>.
     *
     * @return property value of sellerCode
     */
    public String getSellerCode() {
        return sellerCode;
    }

    /**
     * Setter method for property <tt>sellerCode</tt>.
     *
     * @param sellerCode value to be assigned to property sellerCode
     */
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }
}
