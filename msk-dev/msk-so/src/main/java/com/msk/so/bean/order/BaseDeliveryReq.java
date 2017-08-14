package com.msk.so.bean.order;

import com.msk.core.bean.BaseBean;
import com.msk.core.bean.BaseParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BaseDeliveryReq
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class BaseDeliveryReq extends BaseParam {
    /** 动检证要求，1:要 */
    private String vicFlg;
    /** 装卸要求 */
    private String unloadReq;
    /** 包装要求 */
    private String packingReq;
    /** 距离门店最近停车距离(米) */
    private Integer parkingDistance;
    /** 其它配送服务要求 */
    private String otherDeliveryReq;
    /** 本次配送服务要求 */
    private String thisDeliveryReq;

    /**
     * Getter method for property <tt>vicFlg</tt>.
     *
     * @return property value of vicFlg
     */
    public String getVicFlg() {
        return vicFlg;
    }

    /**
     * Setter method for property <tt>vicFlg</tt>.
     *
     * @param vicFlg value to be assigned to property vicFlg
     */
    public void setVicFlg(String vicFlg) {
        this.vicFlg = vicFlg;
    }

    /**
     * Getter method for property <tt>unloadReq</tt>.
     *
     * @return property value of unloadReq
     */
    public String getUnloadReq() {
        return unloadReq;
    }

    /**
     * Setter method for property <tt>unloadReq</tt>.
     *
     * @param unloadReq value to be assigned to property unloadReq
     */
    public void setUnloadReq(String unloadReq) {
        this.unloadReq = unloadReq;
    }

    /**
     * Getter method for property <tt>packingReq</tt>.
     *
     * @return property value of packingReq
     */
    public String getPackingReq() {
        return packingReq;
    }

    /**
     * Setter method for property <tt>packingReq</tt>.
     *
     * @param packingReq value to be assigned to property packingReq
     */
    public void setPackingReq(String packingReq) {
        this.packingReq = packingReq;
    }

    /**
     * Getter method for property <tt>parkingDistance</tt>.
     *
     * @return property value of parkingDistance
     */
    public Integer getParkingDistance() {
        return parkingDistance;
    }

    /**
     * Setter method for property <tt>parkingDistance</tt>.
     *
     * @param parkingDistance value to be assigned to property parkingDistance
     */
    public void setParkingDistance(Integer parkingDistance) {
        this.parkingDistance = parkingDistance;
    }

    /**
     * Getter method for property <tt>otherDeliveryReq</tt>.
     *
     * @return property value of otherDeliveryReq
     */
    public String getOtherDeliveryReq() {
        return otherDeliveryReq;
    }

    /**
     * Setter method for property <tt>otherDeliveryReq</tt>.
     *
     * @param otherDeliveryReq value to be assigned to property otherDeliveryReq
     */
    public void setOtherDeliveryReq(String otherDeliveryReq) {
        this.otherDeliveryReq = otherDeliveryReq;
    }

    /**
     * Getter method for property <tt>thisDeliveryReq</tt>.
     *
     * @return property value of thisDeliveryReq
     */
    public String getThisDeliveryReq() {
        return thisDeliveryReq;
    }

    /**
     * Setter method for property <tt>thisDeliveryReq</tt>.
     *
     * @param thisDeliveryReq value to be assigned to property thisDeliveryReq
     */
    public void setThisDeliveryReq(String thisDeliveryReq) {
        this.thisDeliveryReq = thisDeliveryReq;
    }
}
