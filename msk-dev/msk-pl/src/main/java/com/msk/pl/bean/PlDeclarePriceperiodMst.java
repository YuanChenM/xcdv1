/*
 * 2017/04/17 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

/**
 * <p>表pl_declare_priceperiod_mst对应的实体PlDeclarePriceperiodMst</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class PlDeclarePriceperiodMst extends BaseBean {

    /** ID */
    private Long ppId;
    /** 价盘期数 */
    private String pricePeriod;
    /** 价盘编码 */
    private String pricePeriodCode;
    /** 价盘期日期区间 */
    private String pricePeriodDate;
    /** 价盘期对应年月 */
    private String pricePeriodYm;
    /** 价盘期对应年 */
    private String pricePeriodYear;
    /** 价盘期对应月 */
    private String pricePeriodMonth;
    /** 可填报开始日期 */
    private java.util.Date inputStartDate;
    /** 可填报截止日期 */
    private java.util.Date inputEndDate;
    /** 版本号 */
    private Integer ver;

    /**
     * <p>默认构造函数</p>
     */
    public PlDeclarePriceperiodMst() {
    }

    /**
     * <p>ID</p>
     *
     * @return ID
     */
    public Long getPpId() {
        return ppId;
    }

    /**
     * <p>ID</p>
     *
     * @param ppId ID
     */
    public void setPpId(Long ppId) {
        this.ppId = ppId;
    }
    /**
     * <p>价盘期数</p>
     *
     * @return 价盘期数
     */
    public String getPricePeriod() {
        return pricePeriod;
    }

    /**
     * <p>价盘期数</p>
     *
     * @param pricePeriod 价盘期数
     */
    public void setPricePeriod(String pricePeriod) {
        this.pricePeriod = pricePeriod;
    }
    /**
     * <p>价盘编码</p>
     *
     * @return 价盘编码
     */
    public String getPricePeriodCode() {
        return pricePeriodCode;
    }

    /**
     * <p>价盘编码</p>
     *
     * @param pricePeriodCode 价盘编码
     */
    public void setPricePeriodCode(String pricePeriodCode) {
        this.pricePeriodCode = pricePeriodCode;
    }
    /**
     * <p>价盘期日期区间</p>
     *
     * @return 价盘期日期区间
     */
    public String getPricePeriodDate() {
        return pricePeriodDate;
    }

    /**
     * <p>价盘期日期区间</p>
     *
     * @param pricePeriodDate 价盘期日期区间
     */
    public void setPricePeriodDate(String pricePeriodDate) {
        this.pricePeriodDate = pricePeriodDate;
    }
    /**
     * <p>价盘期对应年月</p>
     *
     * @return 价盘期对应年月
     */
    public String getPricePeriodYm() {
        return pricePeriodYm;
    }

    /**
     * <p>价盘期对应年月</p>
     *
     * @param pricePeriodYm 价盘期对应年月
     */
    public void setPricePeriodYm(String pricePeriodYm) {
        this.pricePeriodYm = pricePeriodYm;
    }
    /**
     * <p>价盘期对应年</p>
     *
     * @return 价盘期对应年
     */
    public String getPricePeriodYear() {
        return pricePeriodYear;
    }

    /**
     * <p>价盘期对应年</p>
     *
     * @param pricePeriodYear 价盘期对应年
     */
    public void setPricePeriodYear(String pricePeriodYear) {
        this.pricePeriodYear = pricePeriodYear;
    }
    /**
     * <p>价盘期对应月</p>
     *
     * @return 价盘期对应月
     */
    public String getPricePeriodMonth() {
        return pricePeriodMonth;
    }

    /**
     * <p>价盘期对应月</p>
     *
     * @param pricePeriodMonth 价盘期对应月
     */
    public void setPricePeriodMonth(String pricePeriodMonth) {
        this.pricePeriodMonth = pricePeriodMonth;
    }
    /**
     * <p>可填报开始日期</p>
     *
     * @return 可填报开始日期
     */
    public java.util.Date getInputStartDate() {
        return inputStartDate;
    }

    /**
     * <p>可填报开始日期</p>
     *
     * @param inputStartDate 可填报开始日期
     */
    public void setInputStartDate(java.util.Date inputStartDate) {
        this.inputStartDate = inputStartDate;
    }
    /**
     * <p>可填报截止日期</p>
     *
     * @return 可填报截止日期
     */
    public java.util.Date getInputEndDate() {
        return inputEndDate;
    }

    /**
     * <p>可填报截止日期</p>
     *
     * @param inputEndDate 可填报截止日期
     */
    public void setInputEndDate(java.util.Date inputEndDate) {
        this.inputEndDate = inputEndDate;
    }
    /**
     * <p>版本号</p>
     *
     * @return 版本号
     */
    public Integer getVer() {
        return ver;
    }

    /**
     * <p>版本号</p>
     *
     * @param ver 版本号
     */
    public void setVer(Integer ver) {
        this.ver = ver;
    }

}
