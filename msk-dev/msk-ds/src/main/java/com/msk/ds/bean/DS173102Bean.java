package com.msk.ds.bean;

/**
 *
 * 月度在线控制表一览bean
 */
public class DS173102Bean {

    /**月度 */
    private String month;

    /**
     * 获得month
     */
    public String getMonth() {
        return month;
    }

    /**
     * 设置month
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * 获得district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 获得prod
     */
    public String getProd() {
        return prod;
    }

    /**
     * 设置prod
     */
    public void setProd(String prod) {
        this.prod = prod;
    }

    /**区域 */
    private String district;
    /**生产商 */
    private String prod;

}
