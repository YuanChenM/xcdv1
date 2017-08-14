package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

import java.math.BigDecimal;

/**
 * Created by xuhongyang on 2017/2/10.
 */
public class IPL20170225Result extends BaseBean {

    //进货单ID
    private int repayDay;

    /**
     * Getter method for property <tt>repayDay</tt>.
     *
     * @return property value of repayDay
     */
    public int getRepayDay() {
        return repayDay;
    }

    /**
     * Setter method for property <tt>repayDay</tt>.
     *
     * @param repayDay value to be assigned to property repayDay
     */
    public void setRepayDay(int repayDay) {
        this.repayDay = repayDay;
    }
}
