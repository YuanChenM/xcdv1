package com.msk.pd.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.entity.BaseEntity;

/**
 * 
 * IPD141143OrderLevel.神农客价盘通道同步接口
 *
 * @author xhy
 */
@JsonIgnoreProperties(value = { "delFlg", "crtId", "crtTime", "updId", "updTime", "ver", "actId", "actTime" })
public class IPD141143OrderLevel extends BaseEntity{

    private static final long serialVersionUID = 1L;
    
    private String orderLevel; // 订单等级等级

    private String  boxMin;

    private String boxMax;

    /**
     * Getter method for property <tt>orderLevel</tt>.
     *
     * @return property value of orderLevel
     */
    public String getOrderLevel() {
        return orderLevel;
    }

    /**
     * Setter method for property <tt>orderLevel</tt>.
     *
     * @param orderLevel value to be assigned to property orderLevel
     */
    public void setOrderLevel(String orderLevel) {
        this.orderLevel = orderLevel;
    }

    /**
     * Getter method for property <tt>boxMin</tt>.
     *
     * @return property value of boxMin
     */
    public String getBoxMin() {
        return boxMin;
    }

    /**
     * Setter method for property <tt>boxMin</tt>.
     *
     * @param boxMin value to be assigned to property boxMin
     */
    public void setBoxMin(String boxMin) {
        this.boxMin = boxMin;
    }

    /**
     * Getter method for property <tt>boxMax</tt>.
     *
     * @return property value of boxMax
     */
    public String getBoxMax() {
        return boxMax;
    }

    /**
     * Setter method for property <tt>boxMax</tt>.
     *
     * @param boxMax value to be assigned to property boxMax
     */
    public void setBoxMax(String boxMax) {
        this.boxMax = boxMax;
    }
}