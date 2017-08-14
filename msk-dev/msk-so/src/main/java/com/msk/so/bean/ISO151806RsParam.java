package com.msk.so.bean;
import com.msk.core.bean.BaseParam;

import java.util.List;


/**
 * zhang_qaing1 库存调整接口 入参
 */
public class ISO151806RsParam extends BaseParam {
    private String slCode;// 卖家编码，目前为销售平台0000000，对应CONSIGNEE

    private String lgcsCode;//物流区编码

    private String adjustCode;//WMS中调整单号

    private String adjustDate;//调整时间（YYYY-MM-DD HH:mm:ss）

    private String adjustPerson;//调整操作人

    private String reasonCode;//调整原因编码，具体原因编码由美迪福提供

    private List<ISO151806ProductRsParam> productList;//本次收货产品信息

    public String getSlCode() {
        return slCode;
    }

    public void setSlCode(String slCode) {
        this.slCode = slCode;
    }

    public String getLgcsCode() {
        return lgcsCode;
    }

    public void setLgcsCode(String lgcsCode) {
        this.lgcsCode = lgcsCode;
    }

    public String getAdjustCode() {
        return adjustCode;
    }

    public void setAdjustCode(String adjustCode) {
        this.adjustCode = adjustCode;
    }

    public String getAdjustDate() {
        return adjustDate;
    }

    public void setAdjustDate(String adjustDate) {
        this.adjustDate = adjustDate;
    }

    public String getAdjustPerson() {
        return adjustPerson;
    }

    public void setAdjustPerson(String adjustPerson) {
        this.adjustPerson = adjustPerson;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public List<ISO151806ProductRsParam> getProductList() {
        return productList;
    }

    public void setProductList(List<ISO151806ProductRsParam> productList) {
        this.productList = productList;
    }
}
