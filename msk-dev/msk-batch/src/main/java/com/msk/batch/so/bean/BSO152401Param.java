package com.msk.batch.so.bean;

import java.util.Date;

import com.msk.common.utils.PriceCycleUtils;
import com.msk.common.bean.PriceCycle;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst.IntDef;

/**
 * BSO152401Param
 * @author yuan_chen
 */
public class BSO152401Param extends BaseParam {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 当前时间 */
    private Date currentDate;
    /** 价盘周期 */
    private PriceCycle priceCycle;
    /** 上个价盘周期 */
    private PriceCycle prePriceCycle;
    /** 订单等级 */
    private int orderLevel;
    /** 是否为测试 */
    private boolean isTest;
    /**
     * Get the priceCycle.
     *
     * @return priceCycle
     *
     * @author administator
     */
    public PriceCycle getPriceCycle() {
        return this.priceCycle;
    }

    /**
     * Get the currentDate.
     *
     * @return currentDate
     *
     * @author administator
     */
    public Date getCurrentDate() {
        return this.currentDate;
    }

    /**
     * Set the currentDate.
     *
     * @param currentDate currentDate
     *
     * @author administator
     */
    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
        this.priceCycle = this.getPriceCycle(IntDef.INT_ZERO);
        this.prePriceCycle = this.getPriceCycle(IntDef.INT_N_TWO);
    }

    /**
     * Get the prePriceCycle.
     *
     * @return prePriceCycle
     *
     * @author administator
     */
    public PriceCycle getPrePriceCycle() {
        return this.prePriceCycle;
    }

    /**
     * Getter method for property <tt>orderLevel</tt>.
     *
     * @return property value of orderLevel
     */
    public int getOrderLevel() {
        return orderLevel;
    }

    /**
     * Setter method for property <tt>orderLevel</tt>.
     *
     * @param orderLevel value to be assigned to property orderLevel
     */
    public void setOrderLevel(int orderLevel) {
        this.orderLevel = orderLevel;
    }

    /**
     * 价盘周期取得
     * 
     * @param amount amount
     * @return 价盘周期
     */
    private PriceCycle getPriceCycle(int amount) {
        return PriceCycleUtils.getPriceCycle(this.currentDate, amount);
    }

    /**
     * Get the isTest.
     *
     * @return isTest
     *
     * @author administator
     */
    public boolean isTest() {
        return this.isTest;
    }

    /**
     * Set the isTest.
     *
     * @param isTest isTest
     *
     * @author administator
     */
    public void setTest(boolean isTest) {
        this.isTest = isTest;
    }
}
