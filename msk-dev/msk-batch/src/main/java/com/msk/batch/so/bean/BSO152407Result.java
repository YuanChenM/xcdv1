package com.msk.batch.so.bean;


import com.msk.core.entity.BaseEntity;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * BSO152407Param
 * @author xu_wei
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"shipId","shipCode","orderType","buyersId","buyersType","buyersName","strForecastReceiveTime","strForecastSendTime","ver","paymentType","productDetailList"})
public class BSO152407Result extends BaseEntity {
    /** 发货单号 */
    private Long shipId;
    /** 发货单编码 */
    private String shipCode;
    /** 1:分销,2:第三方,3:大促会 */
    private Integer orderType;
    /** 买家ID */
    private String buyersId;
    /** 1:分销买家,2:菜场买家,3:团膳买家,4:火锅买家,5:中餐买家,6:西餐买家,7:小吃烧烤买家,8:加工厂买家 */
    private Integer buyersType;
    /** 买家名称 */
    private String buyersName;
    /** FORECAST_RECEIVE_TIME */
    private String strForecastReceiveTime;
    /** FORECAST_SEND_TIME */
    private String strForecastSendTime;
    /** 1:在线支付,2:线下支付 */
    private Integer paymentType;
    /**产品信息*/
    private List<BSO152407DetailResult> productDetailList;
    /** 订单号 */
    private Long orderId;
    /** 子订单号 */
    private Long childOrderId;
    /** 订单编码 */
    private String orderCode;
    private Integer shipStatus;
    private Integer orderStatus;
    private String deliveryOrderCode;
    private Integer orderSource;
    private String sellerCode;
    private String districtCode;
    private Date forecastReceiveTime;
    private Date forecastSendTime;
    /** RECEIVER_NAME */
    private String receiverName;
    /** RECEIVER_TEL */
    private String receiverTel;
    /** RECEIVER_QQ */
    private String receiverQq;
    /** RECEIVER_WEIXIN */
    private String receiverWeixin;
    /** RECEIVER_MAIL */
    private String receiverMail;
    /** RECEIVER_PROVINCE */
    private String receiverProvince;
    /** RECEIVER_CITY */
    private String receiverCity;
    /** RECEIVER_DISTRICT */
    private String receiverDistrict;
    /** RECEIVER_ADDR */
    private String receiverAddr;
    /** DELIVERY_TYPE */
    private String receiverDeType;
    /** RECEIVER_ADDR2 */
    private String receiverAddr2;
    /** RECEIVER_ADDR_KEY */
    private String receiverAddrKey;
    private String receiveTime;
    private String receiveEarliest;
    private String receiveLast;
    private String receiverAdTime;
    private Date nowDate;
    /** 订单已支付金额*/
    private BigDecimal payAmount;
    /** 订单是否继续发货标志 1:继续；0：不继续*/
    private Integer shipSubsequent;

    @XmlTransient
    public Integer getShipSubsequent() {
        return shipSubsequent;
    }

    public void setShipSubsequent(Integer shipSubsequent) {
        this.shipSubsequent = shipSubsequent;
    }

    @XmlTransient
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    @XmlElement(name = "ORDERID",defaultValue = "")
    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }
    @XmlElement(name = "ORDERCODE",defaultValue = "")
    public String getShipCode() {
        return shipCode;
    }

    public void setShipCode(String shipCode) {
        this.shipCode = shipCode;
    }
    @XmlElement(name = "ORDERTYPE",defaultValue = "")
    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    @XmlElement(name = "COMPANYTYPE",defaultValue = "")
    public Integer getBuyersType() {
        return buyersType;
    }

    public void setBuyersType(Integer buyersType) {
        this.buyersType = buyersType;
    }
    @XmlElement(name = "COMPANYNAME",defaultValue = "")
    public String getBuyersName() {
        return buyersName;
    }

    public void setBuyersName(String buyersName) {
        this.buyersName = buyersName;
    }
    @XmlElement(name = "REQUESTEDDATE",defaultValue = "")
    public String getStrForecastReceiveTime() {
        return strForecastReceiveTime;
    }

    public void setStrForecastReceiveTime(String strForecastReceiveTime) {
        this.strForecastReceiveTime = strForecastReceiveTime;
    }
    @XmlElement(name = "SCHEDULEDDATE",defaultValue = "")
    public String getStrForecastSendTime() {
        return strForecastSendTime;
    }

    public void setStrForecastSendTime(String strForecastSendTime) {
        this.strForecastSendTime = strForecastSendTime;
    }
    @XmlElement(name = "PAYMENTTYPE",defaultValue = "")
    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }
    @XmlElementWrapper(name="LINES")
    @XmlElement(name="LINE")
    public List<BSO152407DetailResult> getProductDetailList() {
        return productDetailList;
    }

    public void setProductDetailList(List<BSO152407DetailResult> productDetailList) {
        this.productDetailList = productDetailList;
    }
    @Override
    @XmlElement(name = "VER",defaultValue = "")
    public Integer getVer() {
        return super.getVer();
    }

    @XmlTransient
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    @XmlTransient
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    @XmlTransient
    public Integer getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(Integer shipStatus) {
        this.shipStatus = shipStatus;
    }
    @XmlTransient
    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
    @XmlTransient
    public String getDeliveryOrderCode() {
        return deliveryOrderCode;
    }

    public void setDeliveryOrderCode(String deliveryOrderCode) {
        this.deliveryOrderCode = deliveryOrderCode;
    }
    @XmlTransient
    public Integer getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Integer orderSource) {
        this.orderSource = orderSource;
    }
    @XmlTransient
    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }
    @XmlTransient
    public Date getForecastReceiveTime() {
        return forecastReceiveTime;
    }

    public void setForecastReceiveTime(Date forecastReceiveTime) {
        this.forecastReceiveTime = forecastReceiveTime;
    }
    @XmlTransient
    public Date getForecastSendTime() {
        return forecastSendTime;
    }

    public void setForecastSendTime(Date forecastSendTime) {
        this.forecastSendTime = forecastSendTime;
    }
    @XmlTransient
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
    @XmlTransient
    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }
    @XmlTransient
    public String getReceiverQq() {
        return receiverQq;
    }

    public void setReceiverQq(String receiverQq) {
        this.receiverQq = receiverQq;
    }
    @XmlTransient
    public String getReceiverWeixin() {
        return receiverWeixin;
    }

    public void setReceiverWeixin(String receiverWeixin) {
        this.receiverWeixin = receiverWeixin;
    }
    @XmlTransient
    public String getReceiverMail() {
        return receiverMail;
    }

    public void setReceiverMail(String receiverMail) {
        this.receiverMail = receiverMail;
    }
    @XmlTransient
    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }
    @XmlTransient
    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }
    @XmlTransient
    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }
    @XmlTransient
    public String getReceiverAddr() {
        return receiverAddr;
    }

    public void setReceiverAddr(String receiverAddr) {
        this.receiverAddr = receiverAddr;
    }
    @XmlTransient
    public String getReceiverDeType() {
        return receiverDeType;
    }

    public void setReceiverDeType(String receiverDeType) {
        this.receiverDeType = receiverDeType;
    }
    @XmlTransient
    public String getReceiverAddr2() {
        return receiverAddr2;
    }

    public void setReceiverAddr2(String receiverAddr2) {
        this.receiverAddr2 = receiverAddr2;
    }
    @XmlTransient
    public String getReceiverAddrKey() {
        return receiverAddrKey;
    }

    public void setReceiverAddrKey(String receiverAddrKey) {
        this.receiverAddrKey = receiverAddrKey;
    }
    @XmlTransient
    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }
    @XmlTransient
    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }
    @XmlTransient
    public String getReceiveEarliest() {
        return receiveEarliest;
    }

    public void setReceiveEarliest(String receiveEarliest) {
        this.receiveEarliest = receiveEarliest;
    }
    @XmlTransient
    public String getReceiveLast() {
        return receiveLast;
    }

    public void setReceiveLast(String receiveLast) {
        this.receiveLast = receiveLast;
    }
    @XmlTransient
    public String getReceiverAdTime() {
        return receiverAdTime;
    }

    public void setReceiverAdTime(String receiverAdTime) {
        this.receiverAdTime = receiverAdTime;
    }
    @XmlTransient
    public Long getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(Long childOrderId) {
        this.childOrderId = childOrderId;
    }
    @XmlTransient
    public Date getNowDate() {
        return nowDate;
    }

    public void setNowDate(Date nowDate) {
        this.nowDate = nowDate;
    }

    @XmlElement(name = "TARGETCOMPANY",defaultValue = "")
    public String getBuyersId() {
        return buyersId;
    }

    public void setBuyersId(String buyersId) {
        this.buyersId = buyersId;
    }
}
