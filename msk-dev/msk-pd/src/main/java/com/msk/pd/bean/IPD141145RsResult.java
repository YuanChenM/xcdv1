package com.msk.pd.bean;

import com.msk.core.bean.RsPageResult;
import com.msk.core.entity.PdTcProviderPackage;

import java.util.List;

/**
 * Created by gyh on 2016/4/20.
 */
public class IPD141145RsResult extends RsPageResult{
    private String sellerCode;//卖家id
    private List<PdTcProviderPackage> pdList;//卖家申请新品

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

    /**
     * Getter method for property <tt>pdList</tt>.
     *
     * @return property value of pdList
     */
    public List<PdTcProviderPackage> getPdList() {
        return pdList;
    }

    /**
     * Setter method for property <tt>pdList</tt>.
     *
     * @param pdList value to be assigned to property pdList
     */
    public void setPdList(List<PdTcProviderPackage> pdList) {
        this.pdList = pdList;
    }
}
