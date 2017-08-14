package com.msk.sp.bean;

import com.msk.core.bean.BaseParam;

import java.math.BigDecimal;

/**
 * Created by yang_chunyan on 2016/3/29.
 */
public class SP171131Param extends BaseParam{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    //序号
    private  Integer idCode;
    //产品编码
    private String pdCode;
    //物流区编码
    private String lgcsCode;
    //物流区名称
    private String lgcsName;
    //产品等级
    private String pdLevel;
    //现有库存重量
    private BigDecimal stockWeight;
    //品名
    private String pdName;
    //规格
    private String feacherName;
    //产品净重
    private String pdWeight;
    //报价状态
    private String quotationStatus;
    //配料
    private String machining;
    //卖家编码
    private String slCode;
    //卖家名称
    private String slName;
    //报价数量
    private Integer ncount;
    //报价ID
    private Long pricecycleId;
    //价盘周期
    private String cycleCode;
    //价盘期数
    private String dayAmount;
    //价盘开始时间
    private String startDate;
    //价盘结束时间
    private String endDate;

    /**
     * 登录Id
     */
    private String loginId;

    /**
     * 订单等级编码
     */
    private String orderLevelCode;

    public String getOrderLevelCode() {
        return orderLevelCode;
    }

    public void setOrderLevelCode(String orderLevelCode) {
        this.orderLevelCode = orderLevelCode;
    }

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

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * 上期价盘周期
     */
    private String lastPricecyclePeriod;

    public String getLastPricecyclePeriod() {
        return lastPricecyclePeriod;
    }

    public void setLastPricecyclePeriod(String lastPricecyclePeriod) {
        this.lastPricecyclePeriod = lastPricecyclePeriod;
    }

    public Integer getIdCode() {
        return idCode;
    }

    public void setIdCode(Integer idCode) {
        this.idCode = idCode;
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

    public String getPdCode() {
        return pdCode;
    }

    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }

    public String getLgcsCode() {
        return lgcsCode;
    }

    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    public String getLgcsName() {
        return lgcsName;
    }

    public void setLgcsName(String lgcsName) {
        this.lgcsName = lgcsName;
    }

    public String getPdLevel() {
        return pdLevel;
    }

    public void setPdLevel(String pdLevel) {
        this.pdLevel = pdLevel;
    }

    public BigDecimal getStockWeight() {
        return stockWeight;
    }

    public void setStockWeight(BigDecimal stockWeight) {
        this.stockWeight = stockWeight;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getFeacherName() {
        return feacherName;
    }

    public void setFeacherName(String feacherName) {
        this.feacherName = feacherName;
    }

    public String getPdWeight() {
        return pdWeight;
    }

    public void setPdWeight(String pdWeight) {
        this.pdWeight = pdWeight;
    }

    public String getQuotationStatus() {
        return quotationStatus;
    }

    public void setQuotationStatus(String quotationStatus) {
        this.quotationStatus = quotationStatus;
    }

    public String getMachining() {
        return machining;
    }

    public void setMachining(String machining) {
        this.machining = machining;
    }

    public Integer getNcount() {
        return ncount;
    }

    public void setNcount(Integer ncount) {
        this.ncount = ncount;
    }

    public Long getPricecycleId() {
        return pricecycleId;
    }

    public void setPricecycleId(Long pricecycleId) {
        this.pricecycleId = pricecycleId;
    }

    public String getCycleCode() {
        return cycleCode;
    }

    public void setCycleCode(String cycleCode) {
        this.cycleCode = cycleCode;
    }

    public String getDayAmount() {
        return dayAmount;
    }

    public void setDayAmount(String dayAmount) {
        this.dayAmount = dayAmount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
