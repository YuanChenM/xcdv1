package com.msk.pd.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * IPD141143RsResult.神农客价盘通道同步接口
 *
 * @author xhy 2016-4-8
 */
public class IPD141143RsResult extends RsPageResult {
    private static final long serialVersionUID = 1L;

    private List<IPD141143Orders> searchList;

    /**
     * Getter method for property <tt>searchList</tt>.
     *
     * @return property value of searchList
     */
    public List<IPD141143Orders> getSearchList() {
        return searchList;
    }

    /**
     * Setter method for property <tt>searchList</tt>.
     *
     * @param searchList value to be assigned to property searchList
     */
    public void setSearchList(List<IPD141143Orders> searchList) {
        this.searchList = searchList;
    }
}