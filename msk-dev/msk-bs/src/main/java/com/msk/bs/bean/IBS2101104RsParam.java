package com.msk.bs.bean;

import com.msk.core.entity.SlHouseArea;
import com.msk.core.entity.SlHouseProduct;
import com.msk.core.entity.SlSeller;

import java.util.List;

public class IBS2101104RsParam {
    //冻品管家账号信息
    private IBS2101104SlHouseAccount slHouseAccount;
    //经营区域List
    private List<IBS2101104SlHouseArea> slAreaList;
    //冻品管家产品分类list
    private List<IBS2101104SlHouseProduct> housePdList;

    /**
     * Getter method for property <tt>slHouseAccount</tt>.
     *
     * @return property value of slHouseAccount
     */
    public IBS2101104SlHouseAccount getSlHouseAccount() {
        return slHouseAccount;
    }

    /**
     * Setter method for property <tt>slHouseAccount</tt>.
     *
     * @param slHouseAccount value to be assigned to property slHouseAccount
     */
    public void setSlHouseAccount(IBS2101104SlHouseAccount slHouseAccount) {
        this.slHouseAccount = slHouseAccount;
    }

    /**
     * Getter method for property <tt>slAreaList</tt>.
     *
     * @return property value of slAreaList
     */
    public List<IBS2101104SlHouseArea> getSlAreaList() {
        return slAreaList;
    }

    /**
     * Setter method for property <tt>slAreaList</tt>.
     *
     * @param slAreaList value to be assigned to property slAreaList
     */
    public void setSlAreaList(List<IBS2101104SlHouseArea> slAreaList) {
        this.slAreaList = slAreaList;
    }

    /**
     * Getter method for property <tt>housePdList</tt>.
     *
     * @return property value of housePdList
     */
    public List<IBS2101104SlHouseProduct> getHousePdList() {
        return housePdList;
    }

    /**
     * Setter method for property <tt>housePdList</tt>.
     *
     * @param housePdList value to be assigned to property housePdList
     */
    public void setHousePdList(List<IBS2101104SlHouseProduct> housePdList) {
        this.housePdList = housePdList;
    }
}
