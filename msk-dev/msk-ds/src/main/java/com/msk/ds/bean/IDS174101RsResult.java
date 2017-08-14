package com.msk.ds.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;


/**
 * IDS174101RsResult.
 *
 * @author yuan_chen
 */
public class IDS174101RsResult extends RsPageResult {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 产品相关的信息 */
    private List<ProductInfo> productInfos;

    /**
     * Getter method for property <tt>productInfos</tt>.
     *
     * @return property value of productInfos
     */
    public List<ProductInfo> getProductInfos() {
        return productInfos;
    }

    /**
     * Setter method for property <tt>productInfos</tt>.
     *
     * @param productInfos value to be assigned to property productInfos
     */
    public void setProductInfos(List<ProductInfo> productInfos) {
        this.productInfos = productInfos;
    }
}
