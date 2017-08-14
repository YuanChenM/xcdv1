/**
 * CIMS112102RsParam.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

/**
 * CIMS112102RsParam.
 * 拼接通联借口路径参数 卡信息查询
 * 
 * @author rwf
 */
public class CIMS112102RsParam {

    /** 通联访问参数定义app_key */
    private String app_key;
    /** 通联访问参数定义app_key */
    private String card_id;
    /** 通联访问参数定义format */
    private String format;
    /** 通联访问参数定义method */
    private String method;
    /** 通联访问参数定义sign */
    private String sign;
    /** 通联访问参数定义sign_v */
    private String sign_v;
    /** 通联访问参数定义timestamp */
    private String timestamp;
    /** 通联访问参数定义v */
    private String v;
    /** 本月消费记录本月第一天时间 */
    private String beginDate;
    /** 本月消费记录本月当前时间 */
    private String endDate;
    /** 本月消费记录查询的签名后的字段 */
    private String signSearch;

    /**
     * Get the app_key.
     *
     * @return app_key
     *
     * @author rwf
     */
    public String getApp_key() {
        return this.app_key;
    }

    /**
     * Set the app_key.
     *
     * @param app_key app_key
     *
     * @author rwf
     */
    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }

    /**
     * Get the card_id.
     *
     * @return card_id
     *
     * @author rwf
     */
    public String getCard_id() {
        return this.card_id;
    }

    /**
     * Set the card_id.
     *
     * @param card_id card_id
     *
     * @author rwf
     */
    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    /**
     * Get the format.
     *
     * @return format
     *
     * @author rwf
     */
    public String getFormat() {
        return this.format;
    }

    /**
     * Set the format.
     *
     * @param format format
     *
     * @author rwf
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Get the method.
     *
     * @return method
     *
     * @author rwf
     */
    public String getMethod() {
        return this.method;
    }

    /**
     * Set the method.
     *
     * @param method method
     *
     * @author rwf
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Get the sign.
     *
     * @return sign
     *
     * @author rwf
     */
    public String getSign() {
        return this.sign;
    }

    /**
     * Set the sign.
     *
     * @param sign sign
     *
     * @author rwf
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * Get the sign_v.
     *
     * @return sign_v
     *
     * @author rwf
     */
    public String getSign_v() {
        return this.sign_v;
    }

    /**
     * Set the sign_v.
     *
     * @param sign_v sign_v
     *
     * @author rwf
     */
    public void setSign_v(String sign_v) {
        this.sign_v = sign_v;
    }

    /**
     * Get the timestamp.
     *
     * @return timestamp
     *
     * @author rwf
     */
    public String getTimestamp() {
        return this.timestamp;
    }

    /**
     * Set the timestamp.
     *
     * @param timestamp timestamp
     *
     * @author rwf
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Get the v.
     *
     * @return v
     *
     * @author rwf
     */
    public String getV() {
        return this.v;
    }

    /**
     * Set the v.
     *
     * @param v v
     *
     * @author rwf
     */
    public void setV(String v) {
        this.v = v;
    }

    /**
     * Get the signSearch.
     *
     * @return signSearch
     *
     * @author rwf
     */
    public String getSignSearch() {
        return this.signSearch;
    }

    /**
     * Set the signSearch.
     *
     * @param signSearch signSearch
     *
     * @author rwf
     */
    public void setSignSearch(String signSearch) {
        this.signSearch = signSearch;
    }

    /**
     * Get the beginDate.
     *
     * @return beginDate
     *
     * @author rwf
     */
    public String getBeginDate() {
        return this.beginDate;
    }

    /**
     * Set the beginDate.
     *
     * @param beginDate beginDate
     *
     * @author rwf
     */
    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * Get the endDate.
     *
     * @return endDate
     *
     * @author rwf
     */
    public String getEndDate() {
        return this.endDate;
    }

    /**
     * Set the endDate.
     *
     * @param endDate endDate
     *
     * @author rwf
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
