package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by xuhongyang on 2017/2/10.
 */
public class IPL20170212Result extends BaseBean {

    //进货单ID
    private BigDecimal  totalAmount;

    private List<IPL2017021201Result> feeList;

    /**
     * Getter method for property <tt>totalAmount</tt>.
     *
     * @return property value of totalAmount
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * Setter method for property <tt>totalAmount</tt>.
     *
     * @param totalAmount value to be assigned to property totalAmount
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Getter method for property <tt>feeList</tt>.
     *
     * @return property value of feeList
     */
    public List<IPL2017021201Result> getFeeList() {
        return feeList;
    }

    /**
     * Setter method for property <tt>feeList</tt>.
     *
     * @param feeList value to be assigned to property feeList
     */
    public void setFeeList(List<IPL2017021201Result> feeList) {
        this.feeList = feeList;
    }
}
