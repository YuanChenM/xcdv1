package com.msk.so.bean;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * 创建退货单Bean
 * ISO151408Bean
 *
 * @author sunjiaju
 **/
public class ISO151408Bean extends BaseEntity {
    /** 退货金额 */
    private BigDecimal returnAmount;

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }
}
