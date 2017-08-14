package com.msk.pd.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * 
 * IPD141111RsResult.产品查询价盘
 *
 * @author zhou_ling
 */
public class IPD141112RsResult extends RsPageResult {

    private static final long serialVersionUID = 1L;

    private List<IPD141112RsPdClaSubItemResult> pdList; //产品信息列表


    /**
     * 获得pdList
     */
    public List<IPD141112RsPdClaSubItemResult> getPdList() {
        return pdList;
    }

    /**
     * 设置pdList
     */
    public void setPdList(List<IPD141112RsPdClaSubItemResult> pdList) {
        this.pdList = pdList;
    }
}