/**
 * IMS112101RsParam.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import com.msk.core.bean.BaseBean;

/**
 * IMS112101RsParam.
 * 发放会员卡 传入参数接收
 * @author rwf
 */
public class IMS112101RsParam extends BaseBean {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    // 用户ID
    private String userID;
    // 用户名称
    private String userName;

    /**
     * Get the userName.
     *
     * @return userName
     *
     * @author rwf
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Set the userName.
     *
     * @param userName userName
     *
     * @author rwf
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get the userID.
     *
     * @return userID
     *
     * @author rwf
     */
    public String getUserID() {
        return this.userID;
    }

    /**
     * Set the userID.
     *
     * @param userID userID
     *
     * @author rwf
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

}
