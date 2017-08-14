package com.msk.so.bean.order;

import com.msk.core.entity.SoOrderDetail;
import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.core.exception.SystemException;

import java.math.BigDecimal;
import java.util.List;

/**
 * BaseOrderDetailParam
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class BaseOrderDetailParam extends SoOrderDetail implements Cloneable{
    /**供应商Code*/
    private String supplierCode;
    private String supplierName;
    private List<SoOrderDetailAvailability> orderDetailAvailabilityList;
    private BigDecimal orderPrice;
    private String orderCode;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }


    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }



    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public List<SoOrderDetailAvailability> getOrderDetailAvailabilityList() {
        return orderDetailAvailabilityList;
    }

    public void setOrderDetailAvailabilityList(List<SoOrderDetailAvailability> orderDetailAvailabilityList) {
        this.orderDetailAvailabilityList = orderDetailAvailabilityList;
    }

    /**
     * Getter method for property <tt>supplierCode</tt>.
     *
     * @return property value of supplierCode
     */
    public String getSupplierCode() {
        return supplierCode;
    }

    /**
     * Setter method for property <tt>supplierCode</tt>.
     *
     * @param supplierCode value to be assigned to property supplierCode
     */
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public BaseOrderDetailParam cloneOrderDetail(){
        try {
            return (BaseOrderDetailParam)this.clone();
        }catch (CloneNotSupportedException ex){
            throw new SystemException(ex);
        }
    }
}
