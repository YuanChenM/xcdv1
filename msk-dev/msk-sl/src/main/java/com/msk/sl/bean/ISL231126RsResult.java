package com.msk.sl.bean;

import com.msk.core.entity.SlMstCertItem;

import java.util.List;

/**
 * Created by Administrator on 2016/2/16.
 */
public class ISL231126RsResult extends SlMstCert{
    private List<SlMstCertItem> certItemList;//证照项目List

    /**
     * Getter method for property <tt>certItemList</tt>.
     *
     * @return property value of certItemList
     */
    @Override
    public List<SlMstCertItem> getCertItemList() {
        return certItemList;
    }

    /**
     * Setter method for property <tt>certItemList</tt>.
     *
     * @param certItemList value to be assigned to property certItemList
     */
    @Override
    public void setCertItemList(List<SlMstCertItem> certItemList) {
        this.certItemList = certItemList;
    }
}
