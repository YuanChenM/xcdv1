/**
 * IMS112102RsParam.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import com.msk.core.bean.BaseBean;

/**
 * IMS112102RsParam.
 * 会员卡信息查询 输入参数接收
 * @author rwf
 */
public class IMS112102RsParam extends BaseBean {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 用户ID */
    private String userID;

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
