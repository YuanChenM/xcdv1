package com.msk.bp.bean;


import com.msk.core.bean.BaseParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * 卖家产品报价信息
 * BP112212Param
 * liu_tao2
 */
public class BP112212Param extends BaseParam{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**
     * 报价Id
     */
    private Long pricecycleId;

    /**
     * 价盘周期
     */
    private String pricecyclePeriod;

    /**
     * 价盘周期名称
     */
    private String pricecyclePeriodName;

    /**
     * 上期价盘周期
     */
    private String lastPricecyclePeriod;

    /**
     * 产品编码（组合码，不包含加工类型）
     */
    private String pdCode;

    /**
     * 物流区编码
     */
    private String logiAreaCode;

    /**
     * 物流区名称
     */
    private String logiAreaName;

    /**
     * 卖家编码
     */
    private String slCode;

    /**
     * 报价List
     */
    private List<BP112212Bean> bp112212Beans;

    /**
     * 卖家名称
     */
    private String slName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 净重数值
     */
    private BigDecimal weightVal;

    public BigDecimal getWeightVal() {
        return weightVal;
    }

    public void setWeightVal(BigDecimal weightVal) {
        this.weightVal = weightVal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getPricecycleId() {
        return pricecycleId;
    }

    public void setPricecycleId(Long pricecycleId) {
        this.pricecycleId = pricecycleId;
    }

    public String getPricecyclePeriod() {
        return pricecyclePeriod;
    }

    public void setPricecyclePeriod(String pricecyclePeriod) {
        this.pricecyclePeriod = pricecyclePeriod;
    }

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getLogiAreaCode() {
        return logiAreaCode;
    }

    public void setLogiAreaCode(String logiAreaCode) {
        this.logiAreaCode = logiAreaCode;
    }

    public String getLogiAreaName() {
        return logiAreaName;
    }

    public void setLogiAreaName(String logiAreaName) {
        this.logiAreaName = logiAreaName;
    }

    public String getSlCode() {
        return slCode;
    }

    public void setSlCode(String slCode) {
        this.slCode = slCode;
    }

    public String getSlName() {
        return slName;
    }

    public void setSlName(String slName) {
        this.slName = slName;
    }

    public String getLastPricecyclePeriod() {
        return lastPricecyclePeriod;
    }

    public void setLastPricecyclePeriod(String lastPricecyclePeriod) {
        this.lastPricecyclePeriod = lastPricecyclePeriod;
    }

    public String getPricecyclePeriodName() {
        return pricecyclePeriodName;
    }

    public void setPricecyclePeriodName(String pricecyclePeriodName) {
        this.pricecyclePeriodName = pricecyclePeriodName;
    }

    public List<BP112212Bean> getBp112212Beans() {
        return bp112212Beans;
    }

    public void setBp112212Beans(List<BP112212Bean> bp112212Beans) {
        this.bp112212Beans = bp112212Beans;
    }

    /**
     * <p>默认构造函数。</p>
     */
    public BP112212Param() {

    }
}
