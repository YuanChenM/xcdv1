package com.msk.pd.bean;

import com.msk.core.bean.RsPageResult;

import java.util.List;

/**
 * IPD141142RsResult. 返回产品标准所有数据
 *
 * @author xhy
 */
public class IPD141142RsResult extends RsPageResult {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private List<IPD141142RsBean> searchList;


    /**
     * Getter method for property <tt>searchList</tt>.
     *
     * @return property value of searchList
     */
    public List<IPD141142RsBean> getSearchList() {
        return searchList;
    }

    /**
     * Setter method for property <tt>searchList</tt>.
     *
     * @param searchList value to be assigned to property searchList
     */
    public void setSearchList(List<IPD141142RsBean> searchList) {
        this.searchList = searchList;
    }
}
