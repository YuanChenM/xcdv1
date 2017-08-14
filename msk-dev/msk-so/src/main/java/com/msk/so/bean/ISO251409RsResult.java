package com.msk.so.bean;

import java.util.List;

import com.msk.core.bean.RsPageResult;

/**
 * 
 * ISO251407ReResult.
 *
 * @author pxg
 */
public class ISO251409RsResult extends RsPageResult {
    /** serialVersionUID */
    private static final long serialVersionUID = -1029011096237858524L;

    /** 退货单信息列表 */
    private List<ISO251409RsReturnInfos> returnInfos;

    /**
     * Get the returnInfos.
     *
     * @return returnInfos
     *
     * @author Administrator
     */
    public List<ISO251409RsReturnInfos> getReturnInfos() {
        return this.returnInfos;
    }

    /**
     * Set the returnInfos.
     *
     * @param returnInfos returnInfos
     *
     * @author Administrator
     */
    public void setReturnInfos(List<ISO251409RsReturnInfos> returnInfos) {
        this.returnInfos = returnInfos;
    }
}
