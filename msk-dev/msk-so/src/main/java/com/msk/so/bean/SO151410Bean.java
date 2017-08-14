package com.msk.so.bean;

import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.core.entity.SoOrderShip;

import java.math.BigDecimal;
import java.util.List;

/**
 * 发货单详细
 * SO151410Bean
 *
 * @author sunjiaju
 * @version 1.0
 **/
public class SO151410Bean extends SoOrderShip {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 预计送货时间 */
    private String forecastSendTimeStr;
    /** 预计收货时间 */
    private String forecastReceiveTimeStr;
    /** 付款方式名 */
    private String paymentTypeName;
    /** 运输方式名 */
    private String deliveryTypeName;
    /** 订单发货单状态名 */
    private String shipStatusName;
    /** 判断是否可以取消 */
    private Integer canCancelQty;
    /** 订单明细供应商表 */
    private List<SoOrderDetailAvailability> soOrderDetailAvailabilities;

    public List<SoOrderDetailAvailability> getSoOrderDetailAvailabilities() {
        return soOrderDetailAvailabilities;
    }

    public void setSoOrderDetailAvailabilities(List<SoOrderDetailAvailability> soOrderDetailAvailabilities) {
        this.soOrderDetailAvailabilities = soOrderDetailAvailabilities;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public String getDeliveryTypeName() {
        return deliveryTypeName;
    }

    public void setDeliveryTypeName(String deliveryTypeName) {
        this.deliveryTypeName = deliveryTypeName;
    }

    public String getForecastSendTimeStr() {
        return forecastSendTimeStr;
    }

    public void setForecastSendTimeStr(String forecastSendTimeStr) {
        this.forecastSendTimeStr = forecastSendTimeStr;
    }

    public String getForecastReceiveTimeStr() {
        return forecastReceiveTimeStr;
    }

    public void setForecastReceiveTimeStr(String forecastReceiveTimeStr) {
        this.forecastReceiveTimeStr = forecastReceiveTimeStr;
    }

    public String getShipStatusName() {
        return shipStatusName;
    }

    public void setShipStatusName(String shipStatusName) {
        this.shipStatusName = shipStatusName;
    }

    public Integer getCanCancelQty() {
        return canCancelQty;
    }

    public void setCanCancelQty(Integer canCancelQty) {
        this.canCancelQty = canCancelQty;
    }
}
