package com.msk.pd.bean;

import com.msk.core.bean.RsPageResult;
import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

/**
 * 产品信息接口
 * Created by Administrator on 2016/1/26.
 */
public class IPD141115RsResult extends RsPageResult {

    private static final long serialVersionUID = 1L;

    private List<IPD141115PdInfoRsResult> pdList;

    /**
     * Getter method for property <tt>pdList</tt>.
     *
     * @return property value of pdList
     */
    public List<IPD141115PdInfoRsResult> getPdList() {
        return pdList;
    }

    /**
     * Setter method for property <tt>pdList</tt>.
     *
     * @param pdList value to be assigned to property pdList
     */
    public void setPdList(List<IPD141115PdInfoRsResult> pdList) {
        this.pdList = pdList;
    }
}
