package com.msk.batch.so.bean;

import com.msk.core.entity.BaseEntity;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by wang_shuai on 2016/4/11.
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"returnId","returnCode","orderId","shipId","buyersCode","buyersType","buyersName","buyersId","sellerCode","ver","returnTime","returnType","returnDetailList"})
public class BSO152405Result extends BaseEntity {
    /** 退货单ID */
    private Long returnId;
    /** 退货单编码 */
    private String returnCode;
    /** 订单ID */
    private Long orderId;
    /** 买家编码冗余 */
    private String buyersCode;
    /** 买家类型*/
    private Integer buyersType;
    /** 买家名称,冗余 */
    private String buyersName;
    /**退货人ID*/
    private String buyersId;
    /** 卖家编码,冗余 */
    private String sellerCode;
    /**退货时间*/
    private String returnTime;
    /** 退货单类型-CodeMaster
     1-迟收；2-拒收；3-退货 */
    private String returnType;
    /** 发货单ID */
    private String shipId;

    /**退货产品信息*/
    private List<BSO152405DetailResult> returnDetailList;

    //Add by wang_jianzhou for bug#3809 at 2016/11/28 Start.
    @XmlElement(name = "SHIPID",defaultValue = "")
    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }
    //Add by wang_jianzhou for bug#3809 at 2016/11/28 end.

    @Override
    @XmlElement(name = "VER",defaultValue = "")
    public Integer getVer() {
        return super.getVer();
    }

    @XmlElement(name = "RETURNID",defaultValue = "")
    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }
    @XmlElement(name = "RETURNCODE",defaultValue = "")
    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    @XmlElement(name = "ORDERID",defaultValue = "")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    @XmlElement(name = "TARGETCOMPANY",defaultValue = "")
    public String getBuyersCode() {
        return buyersCode;
    }

    public void setBuyersCode(String buyersCode) {
        this.buyersCode = buyersCode;
    }
    @XmlElement(name = "COMPANYTYPE",defaultValue = "")
    public Integer getBuyersType() {
        return buyersType;
    }

    public void setBuyersType(Integer buyersType) {
        this.buyersType = buyersType;
    }
    @XmlElement(name = "BUYERSNAME",defaultValue = "")
    public String getBuyersName() {
        return buyersName;
    }

    public void setBuyersName(String buyersName) {
        this.buyersName = buyersName;
    }
    @XmlElement(name = "BUYERSID",defaultValue = "")
    public String getBuyersId() {
        return buyersId;
    }

    public void setBuyersId(String buyersId) {
        this.buyersId = buyersId;
    }
    @XmlElement(name = "CONSIGNEE",defaultValue = "")
    public String getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }
    @XmlElement(name = "REQUESTEDDATE",defaultValue = "")
    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }
    @XmlElement(name = "RETURNTYPE",defaultValue = "")
    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }
    @XmlElementWrapper(name="LINES")
    @XmlElement(name="LINE")
    public List<BSO152405DetailResult> getReturnDetailList() {
        return returnDetailList;
    }

    public void setReturnDetailList(List<BSO152405DetailResult> returnDetailList) {
        this.returnDetailList = returnDetailList;
    }
}
