package com.msk.so.bean.order;

import com.msk.core.bean.BaseParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BaseReceiverInfo
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class BaseReceiverInfo extends BaseParam {


    /** 收货人名称 */
    private String receiverName;
    /** 收货人QQ号 */
    private String receiverQQ;
    /** 收货人微信号 */
    private String receiverWeixin;
    /** 收货人电话 */
    private String receiverTel;
    /** 收货地址省份 */
    private String receiverProvince;
    /** 收货地址市 */
    private String receiverCity;
    /** 收货地址区 */
    private String receiverDistrict;
    /** 收货人详细地址 */
    private String receiverAddr;
    /** 习惯正常收货时间段编码，多个时候，以逗号分隔。 */
    private String receiveTime;
    /** 习惯收货最早时间要求 */
    private String receiveEarliest;
    /** 习惯收货最晚时间要求 */
    private String receiveLast;
    /** 备注 */
    private String remark;
    /** 备注2 */
    private String remark2;
    /** 备注3 */
    private String remark3;
    /** 备注4 */
    private String remark4;
    /*距离门店最近停车距离(米)*/
    private String parkingDistance;

    /** 辅助地址项目 */
    private String receiverAddr2;

    /** 收货人详细地址管理Key  */
    private String receiverAddrKey;

    public String getReceiverAddr2() {
        return receiverAddr2;
    }

    public void setReceiverAddr2(String receiverAddr2) {
        this.receiverAddr2 = receiverAddr2;
    }

    public String getReceiverAddrKey() {
        return receiverAddrKey;
    }

    public void setReceiverAddrKey(String receiverAddrKey) {
        this.receiverAddrKey = receiverAddrKey;
    }

    public String getParkingDistance() {
        return parkingDistance;
    }

    public void setParkingDistance(String parkingDistance) {
        this.parkingDistance = parkingDistance;
    }

    /**
     * Getter method for property <tt>receiverName</tt>.
     *
     * @return property value of receiverName
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * Setter method for property <tt>receiverName</tt>.
     *
     * @param receiverName value to be assigned to property receiverName
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * Getter method for property <tt>receiverQQ</tt>.
     *
     * @return property value of receiverQQ
     */
    public String getReceiverQQ() {
        return receiverQQ;
    }

    /**
     * Setter method for property <tt>receiverQQ</tt>.
     *
     * @param receiverQQ value to be assigned to property receiverQQ
     */
    public void setReceiverQQ(String receiverQQ) {
        this.receiverQQ = receiverQQ;
    }

    /**
     * Getter method for property <tt>receiverWeixin</tt>.
     *
     * @return property value of receiverWeixin
     */
    public String getReceiverWeixin() {
        return receiverWeixin;
    }

    /**
     * Setter method for property <tt>receiverWeixin</tt>.
     *
     * @param receiverWeixin value to be assigned to property receiverWeixin
     */
    public void setReceiverWeixin(String receiverWeixin) {
        this.receiverWeixin = receiverWeixin;
    }

    /**
     * Getter method for property <tt>receiverTel</tt>.
     *
     * @return property value of receiverTel
     */
    public String getReceiverTel() {
        return receiverTel;
    }

    /**
     * Setter method for property <tt>receiverTel</tt>.
     *
     * @param receiverTel value to be assigned to property receiverTel
     */
    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }

    /**
     * Getter method for property <tt>receiverProvince</tt>.
     *
     * @return property value of receiverProvince
     */
    public String getReceiverProvince() {
        return receiverProvince;
    }

    /**
     * Setter method for property <tt>receiverProvince</tt>.
     *
     * @param receiverProvince value to be assigned to property receiverProvince
     */
    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    /**
     * Getter method for property <tt>receiverCity</tt>.
     *
     * @return property value of receiverCity
     */
    public String getReceiverCity() {
        return receiverCity;
    }

    /**
     * Setter method for property <tt>receiverCity</tt>.
     *
     * @param receiverCity value to be assigned to property receiverCity
     */
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    /**
     * Getter method for property <tt>receiverDistrict</tt>.
     *
     * @return property value of receiverDistrict
     */
    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    /**
     * Setter method for property <tt>receiverDistrict</tt>.
     *
     * @param receiverDistrict value to be assigned to property receiverDistrict
     */
    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    /**
     * Getter method for property <tt>receiverAddr</tt>.
     *
     * @return property value of receiverAddr
     */
    public String getReceiverAddr() {
        return receiverAddr;
    }

    /**
     * Setter method for property <tt>receiverAddr</tt>.
     *
     * @param receiverAddr value to be assigned to property receiverAddr
     */
    public void setReceiverAddr(String receiverAddr) {
        this.receiverAddr = receiverAddr;
    }

    /**
     * Getter method for property <tt>receiveTime</tt>.
     *
     * @return property value of receiveTime
     */
    public String getReceiveTime() {
        return receiveTime;
    }

    /**
     * Setter method for property <tt>receiveTime</tt>.
     *
     * @param receiveTime value to be assigned to property receiveTime
     */
    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    /**
     * Getter method for property <tt>receiveEarliest</tt>.
     *
     * @return property value of receiveEarliest
     */
    public String getReceiveEarliest() {
        return receiveEarliest;
    }

    /**
     * Setter method for property <tt>receiveEarliest</tt>.
     *
     * @param receiveEarliest value to be assigned to property receiveEarliest
     */
    public void setReceiveEarliest(String receiveEarliest) {
        this.receiveEarliest = receiveEarliest;
    }

    /**
     * Getter method for property <tt>receiveLast</tt>.
     *
     * @return property value of receiveLast
     */
    public String getReceiveLast() {
        return receiveLast;
    }

    /**
     * Setter method for property <tt>receiveLast</tt>.
     *
     * @param receiveLast value to be assigned to property receiveLast
     */
    public void setReceiveLast(String receiveLast) {
        this.receiveLast = receiveLast;
    }

    /**
     * Getter method for property <tt>remark</tt>.
     *
     * @return property value of remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Setter method for property <tt>remark</tt>.
     *
     * @param remark value to be assigned to property remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Getter method for property <tt>remark2</tt>.
     *
     * @return property value of remark2
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * Setter method for property <tt>remark2</tt>.
     *
     * @param remark2 value to be assigned to property remark2
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    /**
     * Getter method for property <tt>remark3</tt>.
     *
     * @return property value of remark3
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * Setter method for property <tt>remark3</tt>.
     *
     * @param remark3 value to be assigned to property remark3
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    /**
     * Getter method for property <tt>remark4</tt>.
     *
     * @return property value of remark4
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * Setter method for property <tt>remark4</tt>.
     *
     * @param remark4 value to be assigned to property remark4
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }
}
