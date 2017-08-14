package com.msk.so.bean;

import com.msk.core.bean.BaseBean;
import com.msk.core.entity.SoOrder;
import com.msk.core.entity.SoOrderDetail;
import com.msk.core.entity.SoOrderReceiveDemand;

import java.util.List;

/**
 * SO15140801Bean
 *
 * @author yang_yang
 * @version 1.0
 **/
public class SO15140801Bean extends SoOrderDetail{

    /** 供应商编码 */
    private java.lang.String supplierCode;
    /** 供应商名称 */
    private java.lang.String supplierName;

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
