package com.msk.so.bean;

import com.msk.core.bean.BaseBean;

import java.util.List;

/**
 * 
 * ISO151405RsResult接口返回结果信息.
 *
 * @author sjj
 */
public class ISO151405RsResult extends BaseBean {

    private List<PdSalesResult> pdList;

    public List<PdSalesResult> getPdList() {
        return pdList;
    }

    public void setPdList(List<PdSalesResult> pdList) {
        this.pdList = pdList;
    }
}
