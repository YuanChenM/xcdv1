package com.msk.so.bean;

import com.msk.core.bean.BaseBean;

/**
 * OrderBuyersBean
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class ReturnOrderBuyersBean extends BaseBean {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    private Integer returnId;// 退货单id

    private String returnCode; // 退货单编码

    private String returnBuyersId; // 退货单买家id

    private String buyersCode; // 退货买家编码
    
    private String buyersName; // 退货买家名称
    
    private String consignee; // 客户退货联系人
    
    private String consigneeMobile; // 退货联系电话
    
    private String consigneeQq;// 退货买家QQ
    
    private String consigneeWeixin; // 退货联系微信号

    private String consigneeAddrProvince; // 退货地址省份

    private String consigneeAddrCity; // 退货地址市

    private String consigneeAddrArea;// 退货地址区

    private String consigneeAddr; // 退货人详细地址

    /**
     * Get the returnId.
     *
     * @return returnId
     *
     * @author xhy
     */
    public Integer getReturnId() {
        return this.returnId;
    }

    /**
     * Set the returnId.
     *
     * @param returnId returnId
     *
     * @author xhy
     */
    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    /**
     * Get the returnCode.
     *
     * @return returnCode
     *
     * @author xhy
     */
    public String getReturnCode() {
        return this.returnCode;
    }

    /**
     * Set the returnCode.
     *
     * @param returnCode returnCode
     *
     * @author xhy
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    /**
     * Get the returnBuyersId.
     *
     * @return returnBuyersId
     *
     * @author xhy
     */
    public String getReturnBuyersId() {
        return this.returnBuyersId;
    }

    /**
     * Set the returnBuyersId.
     *
     * @param returnBuyersId returnBuyersId
     *
     * @author xhy
     */
    public void setReturnBuyersId(String returnBuyersId) {
        this.returnBuyersId = returnBuyersId;
    }

    /**
     * Get the buyersCode.
     *
     * @return buyersCode
     *
     * @author xhy
     */
    public String getBuyersCode() {
        return this.buyersCode;
    }

    /**
     * Set the buyersCode.
     *
     * @param buyersCode buyersCode
     *
     * @author xhy
     */
    public void setBuyersCode(String buyersCode) {
        this.buyersCode = buyersCode;
    }

    /**
     * Get the buyersName.
     *
     * @return buyersName
     *
     * @author xhy
     */
    public String getBuyersName() {
        return this.buyersName;
    }

    /**
     * Set the buyersName.
     *
     * @param buyersName buyersName
     *
     * @author xhy
     */
    public void setBuyersName(String buyersName) {
        this.buyersName = buyersName;
    }

    /**
     * Get the consignee.
     *
     * @return consignee
     *
     * @author xhy
     */
    public String getConsignee() {
        return this.consignee;
    }

    /**
     * Set the consignee.
     *
     * @param consignee consignee
     *
     * @author xhy
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    /**
     * Get the consigneeMobile.
     *
     * @return consigneeMobile
     *
     * @author xhy
     */
    public String getConsigneeMobile() {
        return this.consigneeMobile;
    }

    /**
     * Set the consigneeMobile.
     *
     * @param consigneeMobile consigneeMobile
     *
     * @author xhy
     */
    public void setConsigneeMobile(String consigneeMobile) {
        this.consigneeMobile = consigneeMobile;
    }

    /**
     * Get the consigneeQq.
     *
     * @return consigneeQq
     *
     * @author xhy
     */
    public String getConsigneeQq() {
        return this.consigneeQq;
    }

    /**
     * Set the consigneeQq.
     *
     * @param consigneeQq consigneeQq
     *
     * @author xhy
     */
    public void setConsigneeQq(String consigneeQq) {
        this.consigneeQq = consigneeQq;
    }

    /**
     * Get the consigneeWeixin.
     *
     * @return consigneeWeixin
     *
     * @author xhy
     */
    public String getConsigneeWeixin() {
        return this.consigneeWeixin;
    }

    /**
     * Set the consigneeWeixin.
     *
     * @param consigneeWeixin consigneeWeixin
     *
     * @author xhy
     */
    public void setConsigneeWeixin(String consigneeWeixin) {
        this.consigneeWeixin = consigneeWeixin;
    }

    /**
     * Get the consigneeAddrProvince.
     *
     * @return consigneeAddrProvince
     *
     * @author xhy
     */
    public String getConsigneeAddrProvince() {
        return this.consigneeAddrProvince;
    }

    /**
     * Set the consigneeAddrProvince.
     *
     * @param consigneeAddrProvince consigneeAddrProvince
     *
     * @author xhy
     */
    public void setConsigneeAddrProvince(String consigneeAddrProvince) {
        this.consigneeAddrProvince = consigneeAddrProvince;
    }

    /**
     * Get the consigneeAddrCity.
     *
     * @return consigneeAddrCity
     *
     * @author xhy
     */
    public String getConsigneeAddrCity() {
        return this.consigneeAddrCity;
    }

    /**
     * Set the consigneeAddrCity.
     *
     * @param consigneeAddrCity consigneeAddrCity
     *
     * @author xhy
     */
    public void setConsigneeAddrCity(String consigneeAddrCity) {
        this.consigneeAddrCity = consigneeAddrCity;
    }

    /**
     * Get the consigneeAddrArea.
     *
     * @return consigneeAddrArea
     *
     * @author xhy
     */
    public String getConsigneeAddrArea() {
        return this.consigneeAddrArea;
    }

    /**
     * Set the consigneeAddrArea.
     *
     * @param consigneeAddrArea consigneeAddrArea
     *
     * @author xhy
     */
    public void setConsigneeAddrArea(String consigneeAddrArea) {
        this.consigneeAddrArea = consigneeAddrArea;
    }

    /**
     * Get the consigneeAddr.
     *
     * @return consigneeAddr
     *
     * @author xhy
     */
    public String getConsigneeAddr() {
        return this.consigneeAddr;
    }

    /**
     * Set the consigneeAddr.
     *
     * @param consigneeAddr consigneeAddr
     *
     * @author xhy
     */
    public void setConsigneeAddr(String consigneeAddr) {
        this.consigneeAddr = consigneeAddr;
    }

   
}
