package com.msk.pd.bean;

import com.msk.core.bean.RsPageResult;
import com.msk.core.entity.BaseEntity;
import com.msk.core.entity.PdOrgStd;

import java.util.List;

/**
 * IPD141128RsResult.产品品种接口查询
 *
 * @author xhy
 */
public class IPD141131RsResult extends RsPageResult {

    private static final long serialVersionUID = 1L;


    private List<IPD141131RsBean> searchList;


    /**
     * Getter method for property <tt>searchList</tt>.
     *
     * @return property value of searchList
     */
    public List<IPD141131RsBean> getSearchList() {
        return searchList;
    }

    /**
     * Setter method for property <tt>searchList</tt>.
     *
     * @param searchList value to be assigned to property searchList
     */
    public void setSearchList(List<IPD141131RsBean> searchList) {
        this.searchList = searchList;
    }
}