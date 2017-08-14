package com.msk.so.bean;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.bean.BaseBean;

/**
 * 
 * ISO251409RsReturnDetails.
 *
 * @author pxg
 */
@JsonIgnoreProperties(value={"delFlg","crtId","updId","updTime","actId","actTime","ver","crtTime"})
public class ISO251409RsReturnDetails extends BaseBean{
    
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 退货单明细ID*/
    private Integer returnDetailId;
    /** 产品编号*/
    private String pdCode;
    /** 产品名称*/
    private String pdName;
    /** 产品等级*/
    private Integer pdLevel;
    /** 产品单位*/
    private String unit;
    /** 单件体积*/
    private BigDecimal packingVolume;
    /** 重量*/
    private BigDecimal weight;
    /** 体积*/
    private BigDecimal volume;
    /** 单价*/
    private BigDecimal orderPrice;
    /** 单价所属价盘周期*/
    private String priceCycle;
    /** 退货数量*/
    private Integer returnQty;
    /** 收货数量*/
    private Integer receiveQty;
    /** 退货原因*/
    private String returnReasonCode;
    /** 退货原因描述*/
    private String returnReasonDes;
    /** 原订单明细ID*/
    private Integer orderDetailId;
    /**
     * Get the returnDetailId.
     *
     * @return returnDetailId
     *
     * @author Administrator
     */
    public Integer getReturnDetailId() {
        return this.returnDetailId;
    }
    /**
     * Set the returnDetailId.
     *
     * @param returnDetailId returnDetailId
     *
     * @author Administrator
     */
    public void setReturnDetailId(Integer returnDetailId) {
        this.returnDetailId = returnDetailId;
    }
    /**
     * Get the pdCode.
     *
     * @return pdCode
     *
     * @author Administrator
     */
    public String getPdCode() {
        return this.pdCode;
    }
    /**
     * Set the pdCode.
     *
     * @param pdCode pdCode
     *
     * @author Administrator
     */
    public void setPdCode(String pdCode) {
        this.pdCode = pdCode;
    }
    /**
     * Get the pdName.
     *
     * @return pdName
     *
     * @author Administrator
     */
    public String getPdName() {
        return this.pdName;
    }
    /**
     * Set the pdName.
     *
     * @param pdName pdName
     *
     * @author Administrator
     */
    public void setPdName(String pdName) {
        this.pdName = pdName;
    }
    /**
     * Get the pdLevel.
     *
     * @return pdLevel
     *
     * @author Administrator
     */
    public Integer getPdLevel() {
        return this.pdLevel;
    }
    /**
     * Set the pdLevel.
     *
     * @param pdLevel pdLevel
     *
     * @author Administrator
     */
    public void setPdLevel(Integer pdLevel) {
        this.pdLevel = pdLevel;
    }
    /**
     * Get the unit.
     *
     * @return unit
     *
     * @author Administrator
     */
    public String getUnit() {
        return this.unit;
    }
    /**
     * Set the unit.
     *
     * @param unit unit
     *
     * @author Administrator
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
    /**
     * Get the packingVolume.
     *
     * @return packingVolume
     *
     * @author Administrator
     */
    public BigDecimal getPackingVolume() {
        return this.packingVolume;
    }
    /**
     * Set the packingVolume.
     *
     * @param packingVolume packingVolume
     *
     * @author Administrator
     */
    public void setPackingVolume(BigDecimal packingVolume) {
        this.packingVolume = packingVolume;
    }
    /**
     * Get the weight.
     *
     * @return weight
     *
     * @author Administrator
     */
    public BigDecimal getWeight() {
        return this.weight;
    }
    /**
     * Set the weight.
     *
     * @param weight weight
     *
     * @author Administrator
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
    /**
     * Get the volume.
     *
     * @return volume
     *
     * @author Administrator
     */
    public BigDecimal getVolume() {
        return this.volume;
    }
    /**
     * Set the volume.
     *
     * @param volume volume
     *
     * @author Administrator
     */
    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }
    /**
     * Get the orderPrice.
     *
     * @return orderPrice
     *
     * @author Administrator
     */
    public BigDecimal getOrderPrice() {
        return this.orderPrice;
    }
    /**
     * Set the orderPrice.
     *
     * @param orderPrice orderPrice
     *
     * @author Administrator
     */
    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
    /**
     * Get the priceCycle.
     *
     * @return priceCycle
     *
     * @author Administrator
     */
    public String getPriceCycle() {
        return this.priceCycle;
    }
    /**
     * Set the priceCycle.
     *
     * @param priceCycle priceCycle
     *
     * @author Administrator
     */
    public void setPriceCycle(String priceCycle) {
        this.priceCycle = priceCycle;
    }
    /**
     * Get the returnQty.
     *
     * @return returnQty
     *
     * @author Administrator
     */
    public Integer getReturnQty() {
        return this.returnQty;
    }
    /**
     * Set the returnQty.
     *
     * @param returnQty returnQty
     *
     * @author Administrator
     */
    public void setReturnQty(Integer returnQty) {
        this.returnQty = returnQty;
    }
    /**
     * Get the receiveQty.
     *
     * @return receiveQty
     *
     * @author Administrator
     */
    public Integer getReceiveQty() {
        return this.receiveQty;
    }
    /**
     * Set the receiveQty.
     *
     * @param receiveQty receiveQty
     *
     * @author Administrator
     */
    public void setReceiveQty(Integer receiveQty) {
        this.receiveQty = receiveQty;
    }
    /**
     * Get the returnReasonCode.
     *
     * @return returnReasonCode
     *
     * @author Administrator
     */
    public String getReturnReasonCode() {
        return this.returnReasonCode;
    }
    /**
     * Set the returnReasonCode.
     *
     * @param returnReasonCode returnReasonCode
     *
     * @author Administrator
     */
    public void setReturnReasonCode(String returnReasonCode) {
        this.returnReasonCode = returnReasonCode;
    }
    /**
     * Get the returnReasonDes.
     *
     * @return returnReasonDes
     *
     * @author Administrator
     */
    public String getReturnReasonDes() {
        return this.returnReasonDes;
    }
    /**
     * Set the returnReasonDes.
     *
     * @param returnReasonDes returnReasonDes
     *
     * @author Administrator
     */
    public void setReturnReasonDes(String returnReasonDes) {
        this.returnReasonDes = returnReasonDes;
    }
    /**
     * Get the orderDetailId.
     *
     * @return orderDetailId
     *
     * @author Administrator
     */
    public Integer getOrderDetailId() {
        return this.orderDetailId;
    }
    /**
     * Set the orderDetailId.
     *
     * @param orderDetailId orderDetailId
     *
     * @author Administrator
     */
    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }
}
