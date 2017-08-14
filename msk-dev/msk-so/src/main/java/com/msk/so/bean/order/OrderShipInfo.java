package com.msk.so.bean.order;

import com.msk.core.bean.BaseParam;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Created by liu_tao2 on 2016/7/12.
 */
public class OrderShipInfo extends BaseParam {

    private static final long serialVersionUID = 1L;

    /** WMS配送单号 */
    private String deliverCode;

    /** 配送人 */
    private String deliverPerson;

    /** 配送人电话 */
    private String personMobile;

    /** 配送时间 */
    private String deliverDate;

    /** 配送方式 */
    private Integer deliverMode;

    /** 预计到货时间 */
    private String expectReceiveDate;

    /**实际到货时间*/
    private String actualReceiveDate;

    /** 备注 */
    private String remarks;

    /** 发货产品信息 */
    private List<OrderShipProductInfo> productList;

    /** 金额 */
    private BigDecimal shipAmount;

    /** 退货单ID */
    private Long returnId;

    /** 退货单编码 */
    private String returnCode;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    public BigDecimal getShipAmount() {
        return shipAmount;
    }

    public void setShipAmount(BigDecimal shipAmount) {
        this.shipAmount = shipAmount;
    }

    public String getDeliverCode() {
        return deliverCode;
    }

    public void setDeliverCode(String deliverCode) {
        this.deliverCode = deliverCode;
    }

    public String getDeliverPerson() {
        return deliverPerson;
    }

    public void setDeliverPerson(String deliverPerson) {
        this.deliverPerson = deliverPerson;
    }

    public String getPersonMobile() {
        return personMobile;
    }

    public void setPersonMobile(String personMobile) {
        this.personMobile = personMobile;
    }

    public String getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(String deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Integer getDeliverMode() {
        return deliverMode;
    }

    public void setDeliverMode(Integer deliverMode) {
        this.deliverMode = deliverMode;
    }

    public String getExpectReceiveDate() {
        return expectReceiveDate;
    }

    public void setExpectReceiveDate(String expectReceiveDate) {
        this.expectReceiveDate = expectReceiveDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<OrderShipProductInfo> getProductList() {
        return productList;
    }

    public void setProductList(List<OrderShipProductInfo> productList) {
        this.productList = productList;
    }

    public String getActualReceiveDate() {
        return actualReceiveDate;
    }

    public void setActualReceiveDate(String actualReceiveDate) {
        this.actualReceiveDate = actualReceiveDate;
    }
}
