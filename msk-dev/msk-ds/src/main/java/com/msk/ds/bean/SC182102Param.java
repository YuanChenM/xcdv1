package com.msk.ds.bean;

import com.msk.core.bean.BaseBean;

import java.math.BigDecimal;

/**
 * zhou_yajun on 2016/1/28.
 */
public class SC182102Param extends BaseBean{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /**产品名称 */
    private String productName;
    /**产品编码 */
    private String productCode;
    /**产品品种名称 */
    private String productTypeName;
    /**产品特征 */
    private String productFeature;
    /**产品等级 */
    private String productLevel;
    /**产品规格 */
    private String productSpecifical;
    /**净重 */
    private BigDecimal netWeight;
    /**包装编码 */
    private String packageCode;
    /**计划发货箱数 */
    private BigDecimal sendNum;
    /**实际发货箱数 */
    private BigDecimal sendActualNum;
    /**实际收货箱数 */
    private BigDecimal receiveNum;
    /** 实际发货数量 */
    private BigDecimal sendQty;
    /**备注 */
    private String remark;
    /**录入时间 */
    private String inputDate;
    /** 应上海需求添加属性 ,modify by likai1 2016/8/2 start */
    /** 计划发货重量（KG）*/
    private BigDecimal sendPlanQty;
    /** 实际收货重量（KG）*/
    private BigDecimal recriveQty;
    /** 差异箱数 */
    private BigDecimal differNum;
    /** 差异重量（KG）*/
    private BigDecimal differQty;

    /** 应上海需求添加属性 ,modify by likai1 2016/8/2 end */
    /** 应上海需求 #1791添加页面合计 modify by renyi on 2016/8/10 start */
    private BigDecimal currentNetWeight;
    private BigDecimal currentSendNum;
    private BigDecimal currentSendActualNum;
    private BigDecimal currentReceiveNum;
    private BigDecimal currentSendPlanQty;
    private BigDecimal currentSendQty;
    private BigDecimal currentRecriveQty;
    private BigDecimal currentDifferNum;
    private BigDecimal currentDifferQty;
    private BigDecimal totalNetWeight;
    private BigDecimal totalSendNum;
    private BigDecimal totalSendActualNum;
    private BigDecimal totalReceiveNum;
    private BigDecimal totalSendPlanQty;
    private BigDecimal totalSendQty;
    private BigDecimal totalRecriveQty;
    private BigDecimal totalDifferNum;
    private BigDecimal totalDifferQty;
    public BigDecimal getCurrentNetWeight() {
        return currentNetWeight;
    }

    public void setCurrentNetWeight(BigDecimal currentNetWeight) {
        this.currentNetWeight = currentNetWeight;
    }

    public BigDecimal getCurrentSendNum() {
        return currentSendNum;
    }

    public void setCurrentSendNum(BigDecimal currentSendNum) {
        this.currentSendNum = currentSendNum;
    }

    public BigDecimal getCurrentSendActualNum() {
        return currentSendActualNum;
    }

    public void setCurrentSendActualNum(BigDecimal currentSendActualNum) {
        this.currentSendActualNum = currentSendActualNum;
    }

    public BigDecimal getCurrentReceiveNum() {
        return currentReceiveNum;
    }

    public void setCurrentReceiveNum(BigDecimal currentReceiveNum) {
        this.currentReceiveNum = currentReceiveNum;
    }

    public BigDecimal getCurrentSendPlanQty() {
        return currentSendPlanQty;
    }

    public void setCurrentSendPlanQty(BigDecimal currentSendPlanQty) {
        this.currentSendPlanQty = currentSendPlanQty;
    }

    public BigDecimal getCurrentSendQty() {
        return currentSendQty;
    }

    public void setCurrentSendQty(BigDecimal currentSendQty) {
        this.currentSendQty = currentSendQty;
    }

    public BigDecimal getCurrentRecriveQty() {
        return currentRecriveQty;
    }

    public void setCurrentRecriveQty(BigDecimal currentRecriveQty) {
        this.currentRecriveQty = currentRecriveQty;
    }

    public BigDecimal getCurrentDifferNum() {
        return currentDifferNum;
    }

    public void setCurrentDifferNum(BigDecimal currentDifferNum) {
        this.currentDifferNum = currentDifferNum;
    }

    public BigDecimal getCurrentDifferQty() {
        return currentDifferQty;
    }

    public void setCurrentDifferQty(BigDecimal currentDifferQty) {
        this.currentDifferQty = currentDifferQty;
    }

    public BigDecimal getTotalNetWeight() {
        return totalNetWeight;
    }

    public void setTotalNetWeight(BigDecimal totalNetWeight) {
        this.totalNetWeight = totalNetWeight;
    }

    public BigDecimal getTotalSendNum() {
        return totalSendNum;
    }

    public void setTotalSendNum(BigDecimal totalSendNum) {
        this.totalSendNum = totalSendNum;
    }

    public BigDecimal getTotalSendActualNum() {
        return totalSendActualNum;
    }

    public void setTotalSendActualNum(BigDecimal totalSendActualNum) {
        this.totalSendActualNum = totalSendActualNum;
    }

    public BigDecimal getTotalReceiveNum() {
        return totalReceiveNum;
    }

    public void setTotalReceiveNum(BigDecimal totalReceiveNum) {
        this.totalReceiveNum = totalReceiveNum;
    }

    public BigDecimal getTotalSendPlanQty() {
        return totalSendPlanQty;
    }

    public void setTotalSendPlanQty(BigDecimal totalSendPlanQty) {
        this.totalSendPlanQty = totalSendPlanQty;
    }

    public BigDecimal getTotalSendQty() {
        return totalSendQty;
    }

    public void setTotalSendQty(BigDecimal totalSendQty) {
        this.totalSendQty = totalSendQty;
    }

    public BigDecimal getTotalRecriveQty() {
        return totalRecriveQty;
    }

    public void setTotalRecriveQty(BigDecimal totalRecriveQty) {
        this.totalRecriveQty = totalRecriveQty;
    }

    public BigDecimal getTotalDifferNum() {
        return totalDifferNum;
    }

    public void setTotalDifferNum(BigDecimal totalDifferNum) {
        this.totalDifferNum = totalDifferNum;
    }

    public BigDecimal getTotalDifferQty() {
        return totalDifferQty;
    }

    public void setTotalDifferQty(BigDecimal totalDifferQty) {
        this.totalDifferQty = totalDifferQty;
    }

    /** 应上海需求 #1791添加页面合计 modify by renyi on 2016/8/10 end */






    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(String productFeature) {
        this.productFeature = productFeature;
    }

    public String getProductLevel() {
        return productLevel;
    }

    public void setProductLevel(String productLevel) {
        this.productLevel = productLevel;
    }

    public String getProductSpecifical() {
        return productSpecifical;
    }

    public void setProductSpecifical(String productSpecifical) {
        this.productSpecifical = productSpecifical;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public BigDecimal getSendNum() {
        return sendNum;
    }

    public void setSendNum(BigDecimal sendNum) {
        this.sendNum = sendNum;
    }

    public BigDecimal getSendActualNum() {
        return sendActualNum;
    }

    public BigDecimal getReceiveNum() {
        return receiveNum;
    }

    public void setReceiveNum(BigDecimal receiveNum) {
        this.receiveNum = receiveNum;
    }

    public void setSendActualNum(BigDecimal sendActualNum) {
        this.sendActualNum = sendActualNum;
    }

    public BigDecimal getSendQty() {
        return sendQty;
    }

    public void setSendQty(BigDecimal sendQty) {
        this.sendQty = sendQty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public BigDecimal getSendPlanQty() {
        return sendPlanQty;
    }

    public void setSendPlanQty(BigDecimal sendPlanQty) {
        this.sendPlanQty = sendPlanQty;
    }

    public BigDecimal getRecriveQty() {
        return recriveQty;
    }

    public void setRecriveQty(BigDecimal recriveQty) {
        this.recriveQty = recriveQty;
    }

    public BigDecimal getDifferNum() {
        return differNum;
    }

    public void setDifferNum(BigDecimal differNum) {
        this.differNum = differNum;
    }

    public BigDecimal getDifferQty() {
        return differQty;
    }

    public void setDifferQty(BigDecimal differQty) {
        this.differQty = differQty;
    }
}
