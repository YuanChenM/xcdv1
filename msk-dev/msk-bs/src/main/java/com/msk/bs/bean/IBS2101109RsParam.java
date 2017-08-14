package com.msk.bs.bean;

import com.msk.core.entity.SlHouseAccount;

/**
 * Created by gyh on 2016/3/30.
 */
public class IBS2101109RsParam extends SlHouseAccount {

    private String houseAccount;//冻品管家账号
    private String oldAccountPsd;//旧登录密码
    private String newAccountPsd;//新登录密码

    /**
     * Getter method for property <tt>houseAccount</tt>.
     *
     * @return property value of houseAccount
     */
    public String getHouseAccount() {
        return houseAccount;
    }

    /**
     * Setter method for property <tt>houseAccount</tt>.
     *
     * @param houseAccount value to be assigned to property houseAccount
     */
    public void setHouseAccount(String houseAccount) {
        this.houseAccount = houseAccount;
    }

    /**
     * Getter method for property <tt>oldAccountPsd</tt>.
     *
     * @return property value of oldAccountPsd
     */
    public String getOldAccountPsd() {
        return oldAccountPsd;
    }

    /**
     * Setter method for property <tt>oldAccountPsd</tt>.
     *
     * @param oldAccountPsd value to be assigned to property oldAccountPsd
     */
    public void setOldAccountPsd(String oldAccountPsd) {
        this.oldAccountPsd = oldAccountPsd;
    }

    /**
     * Getter method for property <tt>newAccountPsd</tt>.
     *
     * @return property value of newAccountPsd
     */
    public String getNewAccountPsd() {
        return newAccountPsd;
    }

    /**
     * Setter method for property <tt>newAccountPsd</tt>.
     *
     * @param newAccountPsd value to be assigned to property newAccountPsd
     */
    public void setNewAccountPsd(String newAccountPsd) {
        this.newAccountPsd = newAccountPsd;
    }
}
