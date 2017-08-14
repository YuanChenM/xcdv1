package com.msk.so.bean;

import com.msk.core.bean.BaseBean;
import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * 
 * ISO151403RsResult接口返回结果信息.
 *
 * @author sjj
 */
public class ISO151403RsResult extends BaseBean {

    private List<SellerListResult> sellerList;

    public List<SellerListResult> getSellerList() {
        return sellerList;
    }

    public void setSellerList(List<SellerListResult> sellerList) {
        this.sellerList = sellerList;
    }
}
