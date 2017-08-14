/**
 * IMS112103Arr.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * IMS112103Arr.
 * 会员卡消费记录查询中返回的单条消费信息
 * @author rwf
 */
public class IMS112103RsResultArray implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 消费日期 */
    private Date consumptionDate;
    /** 消费金额 */
    private BigDecimal consumptionAmount;
    /** 消费对应订单号 */
    private String consumptionOrderNo;

    /**
     * Get the consumptionDate.
     *
     * @return consumptionDate
     *
     * @author rwf
     */
    public Date getConsumptionDate() {
        return this.consumptionDate;
    }

    /**
     * Set the consumptionDate.
     *
     * @param consumptionDate consumptionDate
     *
     * @author rwf
     */
    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    /**
     * Get the consumptionAmount.
     *
     * @return consumptionAmount
     *
     * @author rwf
     */
    public BigDecimal getConsumptionAmount() {
        return this.consumptionAmount;
    }

    /**
     * Set the consumptionAmount.
     *
     * @param consumptionAmount consumptionAmount
     *
     * @author rwf
     */
    public void setConsumptionAmount(BigDecimal consumptionAmount) {
        this.consumptionAmount = consumptionAmount;
    }

    /**
     * Get the consumptionOrderNo.
     *
     * @return consumptionOrderNo
     *
     * @author rwf
     */
    public String getConsumptionOrderNo() {
        return this.consumptionOrderNo;
    }

    /**
     * Set the consumptionOrderNo.
     *
     * @param consumptionOrderNo consumptionOrderNo
     *
     * @author rwf
     */
    public void setConsumptionOrderNo(String consumptionOrderNo) {
        this.consumptionOrderNo = consumptionOrderNo;
    }

}
