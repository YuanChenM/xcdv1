/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表by_buyer_rec_time对应的ByBuyerRecTime。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class ByBuyerRecTime extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** ID */
    private java.lang.Long id;
    /** 买家ID */
    private java.lang.String buyerId;
    /** 参考CONSTANT表 */
    private java.lang.String recPerType;
    /** 将24小时按3小时为段分成8段，分别是：00:00-03:00，03:00-06:00，06:00-09:00，09:00-12:00，12:00-15:00，15:00-18:00，18:00-21:00，21:00-24:00。此字段存储真实的时间段内容。一个买家有多个收货时间段时，即存储为多条记录。 */
    private java.lang.String timeDescribe;
    /**
     * <p>默认构造函数。</p>
     */
    public ByBuyerRecTime() {

    }

    /**
     * <p>ID。</p>
     *
     * @return the ID
     */
    public java.lang.Long getId() {
        return id;
    }

    /**
     * <p>ID。</p>
     *
     * @param id ID。
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    /**
     * <p>买家ID。</p>
     *
     * @return the 买家ID
     */
    public java.lang.String getBuyerId() {
        return buyerId;
    }

    /**
     * <p>买家ID。</p>
     *
     * @param buyerId 买家ID。
     */
    public void setBuyerId(java.lang.String buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * <p>参考CONSTANT表。</p>
     *
     * @return the 参考CONSTANT表
     */
    public java.lang.String getRecPerType() {
        return recPerType;
    }

    /**
     * <p>参考CONSTANT表。</p>
     *
     * @param recPerType 参考CONSTANT表。
     */
    public void setRecPerType(java.lang.String recPerType) {
        this.recPerType = recPerType;
    }

    /**
     * <p>将24小时按3小时为段分成8段，分别是：00:00-03:00，03:00-06:00，06:00-09:00，09:00-12:00，12:00-15:00，15:00-18:00，18:00-21:00，21:00-24:00。此字段存储真实的时间段内容。一个买家有多个收货时间段时，即存储为多条记录。。</p>
     *
     * @return the 将24小时按3小时为段分成8段，分别是：00:00-03:00，03:00-06:00，06:00-09:00，09:00-12:00，12:00-15:00，15:00-18:00，18:00-21:00，21:00-24:00。此字段存储真实的时间段内容。一个买家有多个收货时间段时，即存储为多条记录。
     */
    public java.lang.String getTimeDescribe() {
        return timeDescribe;
    }

    /**
     * <p>将24小时按3小时为段分成8段，分别是：00:00-03:00，03:00-06:00，06:00-09:00，09:00-12:00，12:00-15:00，15:00-18:00，18:00-21:00，21:00-24:00。此字段存储真实的时间段内容。一个买家有多个收货时间段时，即存储为多条记录。。</p>
     *
     * @param timeDescribe 将24小时按3小时为段分成8段，分别是：00:00-03:00，03:00-06:00，06:00-09:00，09:00-12:00，12:00-15:00，15:00-18:00，18:00-21:00，21:00-24:00。此字段存储真实的时间段内容。一个买家有多个收货时间段时，即存储为多条记录。。
     */
    public void setTimeDescribe(java.lang.String timeDescribe) {
        this.timeDescribe = timeDescribe;
    }

}
