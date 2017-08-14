package com.msk.so.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by wang_jianzhou on 2016/12/6.
 */
public class ISO151805RsOrderPricesBeanResult implements Serializable {

    private Integer orderLevel;

    private Integer levelStart;

    private Integer levelEnd;

    private BigDecimal levelPrice;

    public Integer getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(Integer orderLevel) {
        this.orderLevel = orderLevel;
    }

    public Integer getLevelStart() {
        return levelStart;
    }

    public void setLevelStart(Integer levelStart) {
        this.levelStart = levelStart;
    }

    public Integer getLevelEnd() {
        return levelEnd;
    }

    public void setLevelEnd(Integer levelEnd) {
        this.levelEnd = levelEnd;
    }

    public BigDecimal getLevelPrice() {
        return levelPrice;
    }

    public void setLevelPrice(BigDecimal levelPrice) {
        this.levelPrice = levelPrice;
    }
}
