package com.msk.pd.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * IPD141141RsResult.
 *
 * @author xhy
 */
public class IPD141141RsResult extends RsPageResult {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 物流区产品信息列表 */
    List<LogiAreaPdBean> logiAreaList;

    /**
     * Getter method for property <tt>logiAreaList</tt>.
     *
     * @return property value of logiAreaList
     */
    public List<LogiAreaPdBean> getLogiAreaList() {
        return logiAreaList;
    }

    /**
     * Setter method for property <tt>logiAreaList</tt>.
     *
     * @param logiAreaList value to be assigned to property logiAreaList
     */
    public void setLogiAreaList(List<LogiAreaPdBean> logiAreaList) {
        this.logiAreaList = logiAreaList;
    }
}
