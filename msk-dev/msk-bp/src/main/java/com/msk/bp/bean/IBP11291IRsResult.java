package com.msk.bp.bean;

import com.msk.core.bean.BaseBean;
import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * IBP11291IRsResult接口返回结果信息.
 *
 * @author xu_wei
 */
public class IBP11291IRsResult extends BaseBean {
    /**
     * 产品列表
     */
    private List<IBP11291IProducts> productslist;

    public List<IBP11291IProducts> getProductslist() {
        return productslist;
    }

    public void setProductslist(List<IBP11291IProducts> productslist) {
        this.productslist = productslist;
    }
}
