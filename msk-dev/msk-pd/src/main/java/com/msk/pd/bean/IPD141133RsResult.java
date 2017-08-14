package com.msk.pd.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * IPD141133RsResult.
 *
 * @author xhy
 */
public class IPD141133RsResult extends RsPageResult {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private List<IPD141133RsBean> searchList;

    /**
     * Getter method for property <tt>searchList</tt>.
     *
     * @return property value of searchList
     */
    public List<IPD141133RsBean> getSearchList() {
        return searchList;
    }

    /**
     * Setter method for property <tt>searchList</tt>.
     *
     * @param searchList value to be assigned to property searchList
     */
    public void setSearchList(List<IPD141133RsBean> searchList) {
        this.searchList = searchList;
    }
}
