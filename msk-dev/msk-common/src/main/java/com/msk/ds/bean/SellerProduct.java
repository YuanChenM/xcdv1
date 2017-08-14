package com.msk.ds.bean;

import com.msk.core.entity.DsSlPdLot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * SellerProduct
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class SellerProduct extends DsSlPdLot{
    private BigDecimal num = BigDecimal.ONE;

    /**
     * Getter method for property <tt>num</tt>.
     *
     * @return property value of num
     */
    public BigDecimal getNum() {
        return num;
    }

    /**
     * Setter method for property <tt>num</tt>.
     *
     * @param num value to be assigned to property num
     */
    public void setNum(BigDecimal num) {
        this.num = num;
    }
}
