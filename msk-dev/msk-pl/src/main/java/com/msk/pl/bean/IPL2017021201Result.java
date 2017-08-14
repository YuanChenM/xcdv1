package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by xuhongyang on 2017/2/10.
 */
public class IPL2017021201Result extends BaseBean {

    //进货单ID
    private Long plId;
    //进货单创建时间
    private String crtTimes;
    //进货单状态(1.有效 0.无效)
    private int status;
    //激励费用
    private BigDecimal incentiveFee;


    /**
     * Getter method for property <tt>plId</tt>.
     *
     * @return property value of plId
     */
    public Long getPlId() {
        return plId;
    }

    /**
     * Setter method for property <tt>plId</tt>.
     *
     * @param plId value to be assigned to property plId
     */
    public void setPlId(Long plId) {
        this.plId = plId;
    }

    /**
     * Getter method for property <tt>crtTimes</tt>.
     *
     * @return property value of crtTimes
     */
    public String getCrtTimes() {
        return crtTimes;
    }

    /**
     * Setter method for property <tt>crtTimes</tt>.
     *
     * @param crtTimes value to be assigned to property crtTimes
     */
    public void setCrtTimes(String crtTimes) {
        this.crtTimes = crtTimes;
    }

    /**
     * Getter method for property <tt>status</tt>.
     *
     * @return property value of status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     *
     * @param status value to be assigned to property status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Getter method for property <tt>incentiveFee</tt>.
     *
     * @return property value of incentiveFee
     */
    public BigDecimal getIncentiveFee() {
        return incentiveFee;
    }

    /**
     * Setter method for property <tt>incentiveFee</tt>.
     *
     * @param incentiveFee value to be assigned to property incentiveFee
     */
    public void setIncentiveFee(BigDecimal incentiveFee) {
        this.incentiveFee = incentiveFee;
    }

}
