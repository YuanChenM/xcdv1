package com.msk.so.bean;

import com.msk.core.bean.RsPageResult;

import java.util.Date;
import java.util.List;

/**
 * 
 * ISO151416RsResult接口返回结果信息.
 *
 * @author zyj
 */
public class ISO151416RsResult extends RsPageResult {

    private List<SellerProductListResult> sellerProductResult;

    /**
     * Getter method for property <tt>sellerProductResult</tt>.
     *
     * @return property value of sellerProductResult
     */
    public List<SellerProductListResult> getSellerProductResult() {
        return sellerProductResult;
    }

    /**
     * Setter method for property <tt>sellerProductResult</tt>.
     *
     * @param sellerProductResult value to be assigned to property sellerProductResult
     */
    public void setSellerProductResult(List<SellerProductListResult> sellerProductResult) {
        this.sellerProductResult = sellerProductResult;
    }
}
