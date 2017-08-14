/**
 * IMS112103RsParam.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * IMS112103RsParam.
 * 会员卡消费记录查询传入参数
 * @author rwf
 */
public class IMS112103RsParam implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 查询用户的用户ID */
    private String userID;
    /** 查询开始日期 */
    private Date startDate;
    /** 查询结束日期 */
    private Date endDate;

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

    /**
     * Get the startDate.
     *
     * @return startDate
     *
     * @author rwf
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * Set the startDate.
     *
     * @param startDate startDate
     *
     * @author rwf
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Get the endDate.
     *
     * @return endDate
     *
     * @author rwf
     */
    public Date getEndDate() {
        return this.endDate;
    }

    /**
     * Set the endDate.
     *
     * @param endDate endDate
     *
     * @author rwf
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
