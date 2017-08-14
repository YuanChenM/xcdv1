package com.msk.pl.bean;

import com.msk.core.bean.BaseParam;

/**
 * Created by xuhongyang on 2017/2/6.
 *
 * 外勤用户验证接口入参
 */
public class IPL20170201Param extends BaseParam {

    private String userName;//用户外勤365实名

    private String wqAccount;//用户外勤365账号

    /**
     * Getter method for property <tt>userName</tt>.
     *
     * @return property value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for property <tt>userName</tt>.
     *
     * @param userName value to be assigned to property userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter method for property <tt>wqAccount</tt>.
     *
     * @return property value of wqAccount
     */
    public String getWqAccount() {
        return wqAccount;
    }

    /**
     * Setter method for property <tt>wqAccount</tt>.
     *
     * @param wqAccount value to be assigned to property wqAccount
     */
    public void setWqAccount(String wqAccount) {
        this.wqAccount = wqAccount;
    }
}
