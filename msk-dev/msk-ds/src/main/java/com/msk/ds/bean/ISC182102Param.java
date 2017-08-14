package com.msk.ds.bean;

/**
 * 发货入库PDF打印param
 * Created by li_kai1 on 2016/8/5.
 */
public class ISC182102Param {
    private static final long serialVersionUID = 1L;
    /** 库存id */
    private String deliveryStockId;
    /** 发货入库明细页面来源 */
    private Boolean isEdit;

    public String getDeliveryStockId() {
        return deliveryStockId;
    }

    public void setDeliveryStockId(String deliveryStockId) {
        this.deliveryStockId = deliveryStockId;
    }

    public Boolean getEdit() {
        return isEdit;
    }

    public void setEdit(Boolean edit) {
        isEdit = edit;
    }
}
