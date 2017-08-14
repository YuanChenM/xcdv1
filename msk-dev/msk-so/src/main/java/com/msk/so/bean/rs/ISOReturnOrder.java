package com.msk.so.bean.rs;

import com.msk.core.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhang_qiang1 on 2016/4/8.
 */
public class ISOReturnOrder extends BaseEntity {

    public ISOReturnOrder() {
    }

    private Long returnId;// 退货但id
    private String inboundTime;// 退货入库时间
    private String inboundManId;//入库人ID
    private String inboundManName;//入库人名称

    /** 退货状态 */
    private java.lang.Integer returnStatus;
    private List<Product> productList=new ArrayList<>();// 退货产品列表


    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    public String getInboundTime() {
        return inboundTime;
    }

    public void setInboundTime(String inboundTime) {
        this.inboundTime = inboundTime;
    }

    public String getInboundManId() {
        return inboundManId;
    }

    public void setInboundManId(String inboundManId) {
        this.inboundManId = inboundManId;
    }

    public String getInboundManName() {
        return inboundManName;
    }

    public void setInboundManName(String inboundManName) {
        this.inboundManName = inboundManName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Integer getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }
}
