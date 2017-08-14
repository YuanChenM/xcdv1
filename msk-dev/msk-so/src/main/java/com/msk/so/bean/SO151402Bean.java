package com.msk.so.bean;

import java.math.BigDecimal;
import java.util.List;

import com.msk.core.entity.SoOrderDetail;
import com.msk.core.entity.SoOrderDetailAvailability;

/**
 * 分销订单(订购产品)明细
 * OM141102Bean
 *
 * @author jiang_nan
 * @version 1.0
 *          修改者 gyh
 *          日期 2015.12.31
 **/
public class SO151402Bean extends SoOrderDetail {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 订单总金额 */
    private BigDecimal pdPriceAll;
    /** 外包装规格 */
    private String normsOut;
    /**明细状态*/
    private String detailStatusName;
    /**退货标志*/
    private String returnFlg;
    /**分批发货*/
    private String splitDeliveryFlgName;

    private String priceCycleName;

    private BigDecimal netWeightOut;

    //期望配送日
    private String expectedDate;



    /** 订单明细供应商表 */
    private List<SoOrderDetailAvailability> soOrderDetailAvailabilities;

    private String childOrderId;

    private String childOrderCode;

    //订单类型
    private String orderType;

    //订单状态
    private String orderStatus;

    private BigDecimal oneAllMoney;

    private Integer childFlag;

    public Integer getChildFlag() {
        return childFlag;
    }

    public void setChildFlag(Integer childFlag) {
        this.childFlag = childFlag;
    }

    public BigDecimal getNetWeightOut() {
        return netWeightOut;
    }

    public void setNetWeightOut(BigDecimal netWeightOut) {
        this.netWeightOut = netWeightOut;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(String childOrderId) {
        this.childOrderId = childOrderId;
    }

    public String getChildOrderCode() {
        return childOrderCode;
    }

    public void setChildOrderCode(String childOrderCode) {
        this.childOrderCode = childOrderCode;
    }

    /**
     * Get the soOrderDetailAvailabilities.
     *
     * @return soOrderDetailAvailabilities
     *
     * @author gyh
     */
    public List<SoOrderDetailAvailability> getSoOrderDetailAvailabilities() {
        return this.soOrderDetailAvailabilities;
    }

    /**
     * Set the soOrderDetailAvailabilities.
     *
     * @param soOrderDetailAvailabilities soOrderDetailAvailabilities
     *
     * @author gyh
     */
    public void setSoOrderDetailAvailabilities(List<SoOrderDetailAvailability> soOrderDetailAvailabilities) {
        this.soOrderDetailAvailabilities = soOrderDetailAvailabilities;
    }

    /**
     * Get the normsOut.
     *
     * @return normsOut
     *
     * @author gyh
     */
    public String getNormsOut() {
        return this.normsOut;
    }

    /**
     * Set the normsOut.
     *
     * @param normsOut normsOut
     *
     * @author gyh
     */
    public void setNormsOut(String normsOut) {
        this.normsOut = normsOut;
    }

    /**
     * Get the pdPriceAll.
     *
     * @return pdPriceAll
     *
     * @author gyh
     */
    public BigDecimal getPdPriceAll() {
        return this.pdPriceAll;
    }

    /**
     * Set the pdPriceAll.
     *
     * @param pdPriceAll pdPriceAll
     *
     * @author gyh
     */
    public void setPdPriceAll(BigDecimal pdPriceAll) {
        this.pdPriceAll = pdPriceAll;
    }

    /**
     * Get the detailStatusName.
     *
     * @return detailStatusName
     *
     * @author gyh
     */
    public String getDetailStatusName() {
        return this.detailStatusName;
    }

    /**
     * Set the detailStatusName.
     *
     * @param detailStatusName detailStatusName
     *
     * @author gyh
     */
    public void setDetailStatusName(String detailStatusName) {
        this.detailStatusName = detailStatusName;
    }

    public String getReturnFlg() {
        return returnFlg;
    }

    public void setReturnFlg(String returnFlg) {
        this.returnFlg = returnFlg;
    }

    public String getSplitDeliveryFlgName() {
        return splitDeliveryFlgName;
    }

    public void setSplitDeliveryFlgName(String splitDeliveryFlgName) {
        this.splitDeliveryFlgName = splitDeliveryFlgName;
    }

    public String getPriceCycleName() {
        return priceCycleName;
    }

    public void setPriceCycleName(String priceCycleName) {
        this.priceCycleName = priceCycleName;
    }

    public BigDecimal getOneAllMoney() {
        return oneAllMoney;
    }

    public void setOneAllMoney(BigDecimal oneAllMoney) {
        this.oneAllMoney = oneAllMoney;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }
}
