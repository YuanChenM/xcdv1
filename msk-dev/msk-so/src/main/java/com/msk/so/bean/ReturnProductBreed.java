package com.msk.so.bean;

import com.msk.core.entity.PdBreed;

/**
 * 
 * @author gyh
 *
 */
public class ReturnProductBreed extends PdBreed {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    
    

    private String goodsStandard; // 货品规格

    private String packStandard; // 包装规格

    private String bulkOne;// 单件体积(/箱)

    /** 订单明细ID */
    private java.lang.Integer orderDetailId;

    /** 产品单价 */
    private java.math.BigDecimal pdPrice;

    /** 供应商编码 */
    private java.lang.String supplierCode;
    /** 供应商名称 */
    private java.lang.String supplierName;

    /**
     * Get the goodsStandard.
     *
     * @return goodsStandard
     *
     * @author Administrator
     */
    public String getGoodsStandard() {
        return this.goodsStandard;
    }

    /**
     * Set the goodsStandard.
     *
     * @param goodsStandard goodsStandard
     *
     * @author Administrator
     */
    public void setGoodsStandard(String goodsStandard) {
        this.goodsStandard = goodsStandard;
    }

    /**
     * Get the packStandard.
     *
     * @return packStandard
     *
     * @author Administrator
     */
    public String getPackStandard() {
        return this.packStandard;
    }

    /**
     * Set the packStandard.
     *
     * @param packStandard packStandard
     *
     * @author Administrator
     */
    public void setPackStandard(String packStandard) {
        this.packStandard = packStandard;
    }

    /**
     * Get the bulkOne.
     *
     * @return bulkOne
     *
     * @author Administrator
     */
    public String getBulkOne() {
        return this.bulkOne;
    }

    /**
     * Set the bulkOne.
     *
     * @param bulkOne bulkOne
     *
     * @author Administrator
     */
    public void setBulkOne(String bulkOne) {
        this.bulkOne = bulkOne;
    }

  
    /**
     * Get the pdPrice.
     *
     * @return pdPrice
     *
     * @author Administrator
     */
    public java.math.BigDecimal getPdPrice() {
        return this.pdPrice;
    }

    /**
     * Set the pdPrice.
     *
     * @param pdPrice pdPrice
     *
     * @author Administrator
     */
    public void setPdPrice(java.math.BigDecimal pdPrice) {
        this.pdPrice = pdPrice;
    }

    /**
     * Get the supplierCode.
     *
     * @return supplierCode
     *
     * @author Administrator
     */
    public java.lang.String getSupplierCode() {
        return this.supplierCode;
    }

    /**
     * Set the supplierCode.
     *
     * @param supplierCode supplierCode
     *
     * @author Administrator
     */
    public void setSupplierCode(java.lang.String supplierCode) {
        this.supplierCode = supplierCode;
    }

    /**
     * Get the supplierName.
     *
     * @return supplierName
     *
     * @author Administrator
     */
    public java.lang.String getSupplierName() {
        return this.supplierName;
    }

    /**
     * Set the supplierName.
     *
     * @param supplierName supplierName
     *
     * @author Administrator
     */
    public void setSupplierName(java.lang.String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * Get the orderDetailId.
     *
     * @return orderDetailId
     *
     * @author Administrator
     */
    public java.lang.Integer getOrderDetailId() {
        return this.orderDetailId;
    }

    /**
     * Set the orderDetailId.
     *
     * @param orderDetailId orderDetailId
     *
     * @author Administrator
     */
    public void setOrderDetailId(java.lang.Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

}
