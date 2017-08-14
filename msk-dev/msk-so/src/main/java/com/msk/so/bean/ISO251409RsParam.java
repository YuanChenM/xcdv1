package com.msk.so.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.msk.core.bean.RsPageParam;

/**
 * DistriButionOrder.
 * 创建标准分销退货单
 *
 * @author pxg
 */
public class ISO251409RsParam extends RsPageParam {
    /** serialVersionUID */
    private static final long serialVersionUID = 4217991662303194889L;
    /** 角色 买家，买手 */
   private String roleType;
    /** 买家编码 */
    private String buyersCode;
    /** 买家Id */
    private String buyersId;
    /** 卖家编码 */
    private String sellerCode;
    /** 退货单类型,1:分销,2:第三方,3:大促会，多选时逗号分隔 */
    private String returnType;
    /** 退货单状态 多选时逗号分隔 */
    private String returnStatus;
    /** 退货单申请时间开始 */
    private Date returnTimeFrom;
    /** 退货单申请时间截止 */
    private Date returnTimeTo;
    /** 退货单来源 */
    private String returnSource;
    /** 退货单区域 */
    private String districtCode;
    /** 退款方式 */
    private Integer refundMode;
    /** 退货单金额下限 */
    private BigDecimal returnAmountMin;
    /** 退货单金额上限 */
    private BigDecimal returnAmountMax;
    /** 是否已开发票 */
    private Integer isInvoice;
    /** 是否自配送 */
    private Integer selfDeliveryFlg;
    /** 直销员 */
    private String sellers;
    /** 订单员 */
    private String orderTaker;
    /** 订单明细类型 */
    private String orderDetailType;
    /** 订单等级 */
    private String orderDetailLevel;
    /** 指定退货单列表 */
    private List<ISO251409RsReturnList> returnList;

    /** 角色 买家，买手 */
    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    /**
     * Get the buyersCode.
     *
     * @return buyersCode
     *
     * @author Administrator
     */
    public String getBuyersCode() {
        return this.buyersCode;
    }

    /**
     * Set the buyersCode.
     *
     * @param buyersCode buyersCode
     *
     * @author Administrator
     */
    public void setBuyersCode(String buyersCode) {
        this.buyersCode = buyersCode;
    }

    /**
     * Get the sellerCode.
     *
     * @return sellerCode
     *
     * @author Administrator
     */
    public String getSellerCode() {
        return this.sellerCode;
    }

    /**
     * Set the sellerCode.
     *
     * @param sellerCode sellerCode
     *
     * @author Administrator
     */
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
    }

    /**
     * Get the returnType.
     *
     * @return returnType
     *
     * @author Administrator
     */
    public String getReturnType() {
        return this.returnType;
    }

    /**
     * Set the returnType.
     *
     * @param returnType returnType
     *
     * @author Administrator
     */
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    /**
     * Get the returnStatus.
     *
     * @return returnStatus
     *
     * @author Administrator
     */
    public String getReturnStatus() {
        return this.returnStatus;
    }

    /**
     * Set the returnStatus.
     *
     * @param returnStatus returnStatus
     *
     * @author Administrator
     */
    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    /**
     * Get the returnTimeFrom.
     *
     * @return returnTimeFrom
     *
     * @author Administrator
     */
    public Date getReturnTimeFrom() {
        return this.returnTimeFrom;
    }

    /**
     * Set the returnTimeFrom.
     *
     * @param returnTimeFrom returnTimeFrom
     *
     * @author Administrator
     */
    public void setReturnTimeFrom(Date returnTimeFrom) {
        this.returnTimeFrom = returnTimeFrom;
    }

    /**
     * Get the returnTimeTo.
     *
     * @return returnTimeTo
     *
     * @author Administrator
     */
    public Date getReturnTimeTo() {
        return this.returnTimeTo;
    }

    /**
     * Set the returnTimeTo.
     *
     * @param returnTimeTo returnTimeTo
     *
     * @author Administrator
     */
    public void setReturnTimeTo(Date returnTimeTo) {
        this.returnTimeTo = returnTimeTo;
    }

    /**
     * Get the returnSource.
     *
     * @return returnSource
     *
     * @author Administrator
     */
    public String getReturnSource() {
        return this.returnSource;
    }

    /**
     * Set the returnSource.
     *
     * @param returnSource returnSource
     *
     * @author Administrator
     */
    public void setReturnSource(String returnSource) {
        this.returnSource = returnSource;
    }

    /**
     * Get the districtCode.
     *
     * @return districtCode
     *
     * @author Administrator
     */
    public String getDistrictCode() {
        return this.districtCode;
    }

    /**
     * Set the districtCode.
     *
     * @param districtCode districtCode
     *
     * @author Administrator
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * Get the refundMode.
     *
     * @return refundMode
     *
     * @author Administrator
     */
    public Integer getRefundMode() {
        return this.refundMode;
    }

    /**
     * Set the refundMode.
     *
     * @param refundMode refundMode
     *
     * @author Administrator
     */
    public void setRefundMode(Integer refundMode) {
        this.refundMode = refundMode;
    }

    /**
     * Get the returnAmountMin.
     *
     * @return returnAmountMin
     *
     * @author Administrator
     */
    public BigDecimal getReturnAmountMin() {
        return this.returnAmountMin;
    }

    /**
     * Set the returnAmountMin.
     *
     * @param returnAmountMin returnAmountMin
     *
     * @author Administrator
     */
    public void setReturnAmountMin(BigDecimal returnAmountMin) {
        this.returnAmountMin = returnAmountMin;
    }

    /**
     * Get the returnAmountMax.
     *
     * @return returnAmountMax
     *
     * @author Administrator
     */
    public BigDecimal getReturnAmountMax() {
        return this.returnAmountMax;
    }

    /**
     * Set the returnAmountMax.
     *
     * @param returnAmountMax returnAmountMax
     *
     * @author Administrator
     */
    public void setReturnAmountMax(BigDecimal returnAmountMax) {
        this.returnAmountMax = returnAmountMax;
    }

    /**
     * Get the isInvoice.
     *
     * @return isInvoice
     *
     * @author Administrator
     */
    public Integer getIsInvoice() {
        return this.isInvoice;
    }

    /**
     * Set the isInvoice.
     *
     * @param isInvoice isInvoice
     *
     * @author Administrator
     */
    public void setIsInvoice(Integer isInvoice) {
        this.isInvoice = isInvoice;
    }

    /**
     * Get the selfDeliveryFlg.
     *
     * @return selfDeliveryFlg
     *
     * @author Administrator
     */
    public Integer getSelfDeliveryFlg() {
        return this.selfDeliveryFlg;
    }

    /**
     * Set the selfDeliveryFlg.
     *
     * @param selfDeliveryFlg selfDeliveryFlg
     *
     * @author Administrator
     */
    public void setSelfDeliveryFlg(Integer selfDeliveryFlg) {
        this.selfDeliveryFlg = selfDeliveryFlg;
    }

    /**
     * Get the sellers.
     *
     * @return sellers
     *
     * @author Administrator
     */
    public String getSellers() {
        return this.sellers;
    }

    /**
     * Set the sellers.
     *
     * @param sellers sellers
     *
     * @author Administrator
     */
    public void setSellers(String sellers) {
        this.sellers = sellers;
    }

    /**
     * Get the orderTaker.
     *
     * @return orderTaker
     *
     * @author Administrator
     */
    public String getOrderTaker() {
        return this.orderTaker;
    }

    /**
     * Set the orderTaker.
     *
     * @param orderTaker orderTaker
     *
     * @author Administrator
     */
    public void setOrderTaker(String orderTaker) {
        this.orderTaker = orderTaker;
    }

    /**
     * Get the orderDetailType.
     *
     * @return orderDetailType
     *
     * @author Administrator
     */
    public String getOrderDetailType() {
        return this.orderDetailType;
    }

    /**
     * Set the orderDetailType.
     *
     * @param orderDetailType orderDetailType
     *
     * @author Administrator
     */
    public void setOrderDetailType(String orderDetailType) {
        this.orderDetailType = orderDetailType;
    }

    /**
     * Get the orderDetailLevel.
     *
     * @return orderDetailLevel
     *
     * @author Administrator
     */
    public String getOrderDetailLevel() {
        return this.orderDetailLevel;
    }

    /**
     * Set the orderDetailLevel.
     *
     * @param orderDetailLevel orderDetailLevel
     *
     * @author Administrator
     */
    public void setOrderDetailLevel(String orderDetailLevel) {
        this.orderDetailLevel = orderDetailLevel;
    }

    /**
     * Get the returnList.
     *
     * @return returnList
     *
     * @author Administrator
     */
    public List<ISO251409RsReturnList> getReturnList() {
        return this.returnList;
    }

    /**
     * Set the returnList.
     *
     * @param returnList returnList
     *
     * @author Administrator
     */
    public void setReturnList(List<ISO251409RsReturnList> returnList) {
        this.returnList = returnList;
    }

    /**
     * Get the buyersId.
     *
     * @return buyersId
     *
     * @author Administrator
     */
    public String getBuyersId() {
        return this.buyersId;
    }

    /**
     * Set the buyersId.
     *
     * @param buyersId buyersId
     *
     * @author Administrator
     */
    public void setBuyersId(String buyersId) {
        this.buyersId = buyersId;
    }
}
