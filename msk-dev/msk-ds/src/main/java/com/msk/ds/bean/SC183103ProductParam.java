package com.msk.ds.bean;

import com.msk.core.bean.BaseParam;

import java.math.BigDecimal;

/**
 * zhou_yajun on 2016/1/28.
 */
public class SC183103ProductParam extends BaseParam{
      /**调整时间*/
    private String adjustDate;
    /**产品编码 */
    private String productCode;
    /**包装编码 */
    private String normsCode;
    /**调整前值*/
    private BigDecimal changeBeforeNum;
    /**调整后值 */
    private BigDecimal changeOverNum;

    public String getAdjustDate() {
        return adjustDate;
    }

    public void setAdjustDate(String adjustDate) {
        this.adjustDate = adjustDate;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getNormsCode() {
        return normsCode;
    }

    public void setNormsCode(String normsCode) {
        this.normsCode = normsCode;
    }

    public BigDecimal getChangeBeforeNum() {
        return changeBeforeNum;
    }

    public void setChangeBeforeNum(BigDecimal changeBeforeNum) {
        this.changeBeforeNum = changeBeforeNum;
    }

    public BigDecimal getChangeOverNum() {
        return changeOverNum;
    }

    public void setChangeOverNum(BigDecimal changeOverNum) {
        this.changeOverNum = changeOverNum;
    }

}
