package com.msk.so.bean;

import com.msk.core.bean.BaseBean;
import com.msk.core.bean.BaseParam;

import java.math.BigDecimal;

/**
 * Created by liu_tao2 on 2016/4/19.
 */
public class ISO151426PruductRsResult extends BaseBean{
    /**
     * 商品编码
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 产品单价
     */
    private BigDecimal pdPrice;

    public BigDecimal getPdPrice() {
        return pdPrice;
    }

    public void setPdPrice(BigDecimal pdPrice) {
        this.pdPrice = pdPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
