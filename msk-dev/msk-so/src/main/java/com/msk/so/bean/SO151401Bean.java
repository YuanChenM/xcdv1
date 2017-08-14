package com.msk.so.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msk.core.bean.BaseBean;
import com.msk.core.consts.SystemConst;

import java.math.BigDecimal;

/**
 *
 * 订单列表
 *
 * @author rwf
 */

public class SO151401Bean extends BaseBean {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    // 需求订单ID
    private java.lang.String orderId;
    //发货单ID
    private java.lang.String shipId;
    // 需求订单编码
    private java.lang.String requireOrderCode;
    // 确认订单编码
    private java.lang.String confirmOrderCode;
    // 配送订单编码
    private java.lang.String deliveryOrderCode;
    // 退货标志 1:整单退货,2:部分退货
    private java.lang.String returnFlg;
    // 是否分批发货 1:是 2:否
    private java.lang.String splitDeliveryFlg;
    // 是否开票
    private java.lang.String needInvoice;

    // 买家编码
    private java.lang.String buyersCode;
    // 买家名称
    private java.lang.String buyersName;
    // 买家类别
    private java.lang.String buyersType;
    // 时间编码
    private java.lang.String auxiliaryCode;
    // 订单类型 1:分销,2:第三方,3:大促会
    private java.lang.String orderType;
    // 发货仓库名称
    private java.lang.String sendWarehouseName;
    // 订单来源
    private java.lang.String orderSource;
    // 订单金额
    private java.lang.String orderAmount;
    // 订单状态 1:新建 2:待审核 3:审核通过 4:待发货 5:部分发货 6:全部发货 7:部分收货 8：全部收货 9:完成
    private java.lang.String orderStatus;
    // 订单创建时间
    private java.util.Date orderTime;
    // 物流区域
    private java.lang.String districtCode;
    // 查询订单的开始时间
    private java.util.Date orderTimeStart;
    // 查询订单的结束时间
    private java.util.Date orderTimeEnd;
    /*区域名称*/
    private java.lang.String districtName;

    private java.lang.String buyersTypeName;

    private String orderCode;

    private String typeName;
    private String sourceName;
    /**冻品关键*/
    private String frozenGoodsHousekeep;
    /**订单总量*/
    private String orderQty;
    /**所有订单总量*/
    private String totalQty;
    /**所有订单总金额*/
    private BigDecimal totalAmount;
    /**当前页订单总量*/
    private String currentPageQty;
    /**当前页订单总金额*/
    private BigDecimal currentPageAmount;

    private Integer orderStu;

    private Integer orderDetailStu;

    private Integer orderAvaStu;

    public Integer getOrderStu() {
        return orderStu;
    }

    public void setOrderStu(Integer orderStu) {
        this.orderStu = orderStu;
    }

    public Integer getOrderDetailStu() {
        return orderDetailStu;
    }

    public void setOrderDetailStu(Integer orderDetailStu) {
        this.orderDetailStu = orderDetailStu;
    }

    public Integer getOrderAvaStu() {
        return orderAvaStu;
    }

    public void setOrderAvaStu(Integer orderAvaStu) {
        this.orderAvaStu = orderAvaStu;
    }

    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    public String getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(String totalQty) {
        this.totalQty = totalQty;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCurrentPageQty() {
        return currentPageQty;
    }

    public void setCurrentPageQty(String currentPageQty) {
        this.currentPageQty = currentPageQty;
    }

    public BigDecimal getCurrentPageAmount() {
        return currentPageAmount;
    }

    public void setCurrentPageAmount(BigDecimal currentPageAmount) {
        this.currentPageAmount = currentPageAmount;
    }

    public String getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(String orderQty) {
        this.orderQty = orderQty;
    }

    public String getFrozenGoodsHousekeep() {
        return frozenGoodsHousekeep;
    }

    public void setFrozenGoodsHousekeep(String frozenGoodsHousekeep) {
        this.frozenGoodsHousekeep = frozenGoodsHousekeep;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getBuyersTypeName() {
        return buyersTypeName;
    }

    public void setBuyersTypeName(String buyersTypeName) {
        this.buyersTypeName = buyersTypeName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * Get the buyersCode.
     *
     * @return buyersCode
     *
     * @author rwf
     */
    public java.lang.String getBuyersCode() {
        return this.buyersCode;
    }

    /**
     * Set the buyersCode.
     *
     * @param buyersCode buyersCode
     *
     * @author rwf
     */
    public void setBuyersCode(java.lang.String buyersCode) {
        this.buyersCode = buyersCode;
    }

    /**
     * Get the buyersName.
     *
     * @return buyersName
     *
     * @author rwf
     */
    public java.lang.String getBuyersName() {
        return this.buyersName;
    }

    /**
     * Set the buyersName.
     *
     * @param buyersName buyersName
     *
     * @author rwf
     */
    public void setBuyersName(java.lang.String buyersName) {
        this.buyersName = buyersName;
    }

    /**
     * Get the auxiliaryCode.
     *
     * @return auxiliaryCode
     *
     * @author rwf
     */
    public java.lang.String getAuxiliaryCode() {
        return this.auxiliaryCode;
    }

    /**
     * Set the auxiliaryCode.
     *
     * @param auxiliaryCode auxiliaryCode
     *
     * @author rwf
     */
    public void setAuxiliaryCode(java.lang.String auxiliaryCode) {
        this.auxiliaryCode = auxiliaryCode;
    }

    /**
     * Get the orderType.
     *
     * @return orderType
     *
     * @author rwf
     */
    public java.lang.String getOrderType() {
        return this.orderType;
    }

    /**
     * Set the orderType.
     *
     * @param orderType orderType
     *
     * @author rwf
     */
    public void setOrderType(java.lang.String orderType) {
        this.orderType = orderType;
    }

    /**
     * Get the sendWarehouseName.
     *
     * @return sendWarehouseName
     *
     * @author rwf
     */
    public java.lang.String getSendWarehouseName() {
        return this.sendWarehouseName;
    }

    /**
     * Set the sendWarehouseName.
     *
     * @param sendWarehouseName sendWarehouseName
     *
     * @author rwf
     */
    public void setSendWarehouseName(java.lang.String sendWarehouseName) {
        this.sendWarehouseName = sendWarehouseName;
    }

    /**
     * Get the orderSource.
     *
     * @return orderSource
     *
     * @author rwf
     */
    public java.lang.String getOrderSource() {
        return this.orderSource;
    }

    /**
     * Set the orderSource.
     *
     * @param orderSource orderSource
     *
     * @author rwf
     */
    public void setOrderSource(java.lang.String orderSource) {
        this.orderSource = orderSource;
    }

    /**
     * Get the orderTime.
     *
     * @return orderTime
     *
     * @author rwf
     */

    @JsonFormat(timezone= SystemConst.Default.TIMEZONE, pattern= SystemConst.Default.FORMAT_DATE)
    public java.util.Date getOrderTime() {
        return this.orderTime;
    }

    /**
     * Set the orderTime.
     *
     * @param orderTime orderTime
     *
     * @author rwf
     */
    public void setOrderTime(java.util.Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * Get the orderAmount.
     *
     * @return orderAmount
     *
     * @author rwf
     */
    public java.lang.String getOrderAmount() {
        return this.orderAmount;
    }

    /**
     * Set the orderAmount.
     *
     * @param orderAmount orderAmount
     *
     * @author rwf
     */
    public void setOrderAmount(java.lang.String orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * Get the orderId.
     *
     * @return orderId
     *
     * @author rwf
     */
    public java.lang.String getOrderId() {
        return this.orderId;
    }

    /**
     * Set the orderId.
     *
     * @param orderId orderId
     *
     * @author rwf
     */
    public void setOrderId(java.lang.String orderId) {
        this.orderId = orderId;
    }

    /**
     * Get the orderStatus.
     *
     * @return orderStatus
     *
     * @author rwf
     */
    public java.lang.String getOrderStatus() {
        return this.orderStatus;
    }

    /**
     * Set the orderStatus.
     *
     * @param orderStatus orderStatus
     *
     * @author rwf
     */
    public void setOrderStatus(java.lang.String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Get the orderTimeEnd.
     *
     * @return orderTimeEnd
     *
     * @author rwf
     */

    public java.util.Date getOrderTimeEnd() {
        return this.orderTimeEnd;
    }

    /**
     * Set the orderTimeEnd.
     *
     * @param orderTimeEnd orderTimeEnd
     *
     * @author rwf
     */
    public void setOrderTimeEnd(java.util.Date orderTimeEnd) {
        this.orderTimeEnd = orderTimeEnd;
    }

    /**
     * Get the orderTimeStart.
     *
     * @return orderTimeStart
     *
     * @author rwf
     */
    public java.util.Date getOrderTimeStart() {
        return this.orderTimeStart;
    }

    /**
     * Set the orderTimeStart.
     *
     * @param orderTimeStart orderTimeStart
     *
     * @author rwf
     */
    public void setOrderTimeStart(java.util.Date orderTimeStart) {
        this.orderTimeStart = orderTimeStart;
    }

    /**
     * Get the requireOrderCode.
     *
     * @return requireOrderCode
     *
     * @author Administrator
     */
    public java.lang.String getRequireOrderCode() {
        return this.requireOrderCode;
    }

    /**
     * Set the requireOrderCode.
     * s
     *
     * @param requireOrderCode requireOrderCode
     *
     * @author Administrator
     */
    public void setRequireOrderCode(java.lang.String requireOrderCode) {
        this.requireOrderCode = requireOrderCode;
    }

    /**
     * Get the confirmOrderCode.
     *
     * @return confirmOrderCode
     *
     * @author Administrator
     */
    public java.lang.String getConfirmOrderCode() {
        return this.confirmOrderCode;
    }

    /**
     * Set the confirmOrderCode.
     *
     * @param confirmOrderCode confirmOrderCode
     *
     * @author Administrator
     */
    public void setConfirmOrderCode(java.lang.String confirmOrderCode) {
        this.confirmOrderCode = confirmOrderCode;
    }

    /**
     * Get the deliveryOrderCode.
     *
     * @return deliveryOrderCode
     *
     * @author Administrator
     */
    public java.lang.String getDeliveryOrderCode() {
        return this.deliveryOrderCode;
    }

    /**
     * Set the deliveryOrderCode.
     *
     * @param deliveryOrderCode deliveryOrderCode
     *
     * @author Administrator
     */
    public void setDeliveryOrderCode(java.lang.String deliveryOrderCode) {
        this.deliveryOrderCode = deliveryOrderCode;
    }

    /**
     * Get the returnFlg.
     *
     * @return returnFlg
     *
     * @author Administrator
     */
    public java.lang.String getReturnFlg() {
        return this.returnFlg;
    }

    /**
     * Set the returnFlg.
     *
     * @param returnFlg returnFlg
     *
     * @author Administrator
     */
    public void setReturnFlg(java.lang.String returnFlg) {
        this.returnFlg = returnFlg;
    }

    /**
     * Get the splitDeliveryFlg.
     *
     * @return splitDeliveryFlg
     *
     * @author Administrator
     */
    public java.lang.String getSplitDeliveryFlg() {
        return this.splitDeliveryFlg;
    }

    /**
     * Set the splitDeliveryFlg.
     *
     * @param splitDeliveryFlg splitDeliveryFlg
     *
     * @author Administrator
     */
    public void setSplitDeliveryFlg(java.lang.String splitDeliveryFlg) {
        this.splitDeliveryFlg = splitDeliveryFlg;
    }

    /**
     * Get the needInvoice.
     *
     * @return needInvoice
     *
     * @author Administrator
     */
    public java.lang.String getNeedInvoice() {
        return this.needInvoice;
    }

    /**
     * Set the needInvoice.
     *
     * @param needInvoice needInvoice
     *
     * @author Administrator
     */
    public void setNeedInvoice(java.lang.String needInvoice) {
        this.needInvoice = needInvoice;
    }

    /**
     * Get the buyersType.
     *
     * @return buyersType
     *
     * @author Administrator
     */
    public java.lang.String getBuyersType() {
        return this.buyersType;
    }

    /**
     * Set the buyersType.
     *
     * @param buyersType buyersType
     *
     * @author Administrator
     */
    public void setBuyersType(java.lang.String buyersType) {
        this.buyersType = buyersType;
    }

    /**
     * Get the districtCode.
     *
     * @return districtCode
     *
     * @author Administrator
     */
    public java.lang.String getDistrictCode() {
        return this.districtCode;
    }

    /**
     * Set the districtCode.
     *
     * @param districtCode districtCode
     *
     * @author Administrator
     */
    public void setDistrictCode(java.lang.String districtCode) {
        this.districtCode = districtCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}