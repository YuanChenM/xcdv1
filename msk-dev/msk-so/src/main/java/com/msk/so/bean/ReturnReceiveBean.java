package com.msk.so.bean;

import com.msk.core.bean.BaseBean;

/**
 * ReturnReceiveBean.
 * 退货单物流收货信息
 * 
 * @author rwf
 */
public class ReturnReceiveBean extends BaseBean {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    // 是否开动检证
    private String verification;
    // 退货等待时间
    private String returnWaitTime;
    // 提前通知时间
    private String noticeTime;
    // 距离门店最近停车距离(米)
    private String distance;
    // 正常退货时间段
    private String normalTime;
    // 退货最早时间要求
    private String returnEarliestTime;
    // 退货最晚时间要求
    private String returnLatestTime;
    // 其它退货服务要求
    private String otherReturnRequest;
    // 本次退货服务要求
    private String thisTimeReturnRequest;

    /**
     * Get the verification.
     *
     * @return verification
     *
     * @author rwf
     */
    public String getVerification() {
        return this.verification;
    }

    /**
     * Set the verification.
     *
     * @param verification verification
     *
     * @author rwf
     */
    public void setVerification(String verification) {
        this.verification = verification;
    }

    /**
     * Get the returnWaitTime.
     *
     * @return returnWaitTime
     *
     * @author rwf
     */
    public String getReturnWaitTime() {
        return this.returnWaitTime;
    }

    /**
     * Set the returnWaitTime.
     *
     * @param returnWaitTime returnWaitTime
     *
     * @author rwf
     */
    public void setReturnWaitTime(String returnWaitTime) {
        this.returnWaitTime = returnWaitTime;
    }

    /**
     * Get the noticeTime.
     *
     * @return noticeTime
     *
     * @author rwf
     */
    public String getNoticeTime() {
        return this.noticeTime;
    }

    /**
     * Set the noticeTime.
     *
     * @param noticeTime noticeTime
     *
     * @author rwf
     */
    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime;
    }

    /**
     * Get the distance.
     *
     * @return distance
     *
     * @author rwf
     */
    public String getDistance() {
        return this.distance;
    }

    /**
     * Set the distance.
     *
     * @param distance distance
     *
     * @author rwf
     */
    public void setDistance(String distance) {
        this.distance = distance;
    }

    /**
     * Get the normalTime.
     *
     * @return normalTime
     *
     * @author rwf
     */
    public String getNormalTime() {
        return this.normalTime;
    }

    /**
     * Set the normalTime.
     *
     * @param normalTime normalTime
     *
     * @author rwf
     */
    public void setNormalTime(String normalTime) {
        this.normalTime = normalTime;
    }

    /**
     * Get the returnEarliestTime.
     *
     * @return returnEarliestTime
     *
     * @author rwf
     */
    public String getReturnEarliestTime() {
        return this.returnEarliestTime;
    }

    /**
     * Set the returnEarliestTime.
     *
     * @param returnEarliestTime returnEarliestTime
     *
     * @author rwf
     */
    public void setReturnEarliestTime(String returnEarliestTime) {
        this.returnEarliestTime = returnEarliestTime;
    }

    /**
     * Get the returnLatestTime.
     *
     * @return returnLatestTime
     *
     * @author rwf
     */
    public String getReturnLatestTime() {
        return this.returnLatestTime;
    }

    /**
     * Set the returnLatestTime.
     *
     * @param returnLatestTime returnLatestTime
     *
     * @author rwf
     */
    public void setReturnLatestTime(String returnLatestTime) {
        this.returnLatestTime = returnLatestTime;
    }

    /**
     * Get the otherReturnRequest.
     *
     * @return otherReturnRequest
     *
     * @author rwf
     */
    public String getOtherReturnRequest() {
        return this.otherReturnRequest;
    }

    /**
     * Set the otherReturnRequest.
     *
     * @param otherReturnRequest otherReturnRequest
     *
     * @author rwf
     */
    public void setOtherReturnRequest(String otherReturnRequest) {
        this.otherReturnRequest = otherReturnRequest;
    }

    /**
     * Get the thisTimeReturnRequest.
     *
     * @return thisTimeReturnRequest
     *
     * @author rwf
     */
    public String getThisTimeReturnRequest() {
        return this.thisTimeReturnRequest;
    }

    /**
     * Set the thisTimeReturnRequest.
     *
     * @param thisTimeReturnRequest thisTimeReturnRequest
     *
     * @author rwf
     */
    public void setThisTimeReturnRequest(String thisTimeReturnRequest) {
        this.thisTimeReturnRequest = thisTimeReturnRequest;
    }

}
