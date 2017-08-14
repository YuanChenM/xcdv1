package com.msk.pd.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * IPD141140RsResult.原料种源信息同步接口
 *
 * @author xhy
 */
public class IPD141140RsResult extends RsPageResult {

    private static final long serialVersionUID = 1L;


    private List<IPD141140RsBean> searchList;

    /**
     * Getter method for property <tt>searchList</tt>.
     *
     * @return property value of searchList
     */
    public List<IPD141140RsBean> getSearchList() {
        return searchList;
    }

    /**
     * Setter method for property <tt>searchList</tt>.
     *
     * @param searchList value to be assigned to property searchList
     */
    public void setSearchList(List<IPD141140RsBean> searchList) {
        this.searchList = searchList;
    }
}