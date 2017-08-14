package com.msk.so.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.bean.BaseBean;
import com.msk.core.entity.BaseEntity;

/**
 * 
 * ISO251409RsReturnInfos.
 *
 * @author pxg
 */
public class ISO251409RsReturnInfos extends BaseBean{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 退货单ID*/
    private Integer returnId;
    /** 退货单编码*/
    private String returnCode;
    /** 退货单状态*/
    private Integer returnStatus;
    /** 退货单来源,1:平台 2:呼叫中心 3:手机客户端*/
    private Integer returnSource;
    /** 退货类型,1:分销,2:第三方,3:大促会*/
    private Integer returnType;
    /** 退货单申请时间*/
    private Date returnTime;
    /** 退货总金额*/
    private BigDecimal returnAmount;
    /** 退货方式*/
    private Integer returnMode;
    /** 退货原因*/
    private String returnReasonCode;
    /** 退货原因问题描述*/
    private String returnReasonDes;
    /** 退货备注*/
    private String applyRemark;
    /** 退货原因照片1（文件服务器绝对路径）*/
    private String image1;
    /** 退货原因照片2（文件服务器绝对路径）*/
    private String image2;
    /** 退货原因照片3（文件服务器绝对路径）*/
    private String image3;
    /** 退货原因照片4（文件服务器绝对路径）*/
    private String image4;
    /** 退货原因照片5（文件服务器绝对路径）*/
    private String image5;
    /** 是否已付款*/
    private Integer iaPaid;
    /** 是否已退款*/
    private Integer iaReturned;
    /** 退款方式*/
    private Integer refundMode;
    /** 原订单ID*/
    private Integer orderId;
    /** 原订单编码*/
    private String orderCode;
    /** 原订单创建时间*/
    private Integer orderTime;
    /**是否已付款，1:已付款*/
    private Integer isPaid;

    /** 退货产品明细列表*/
    private List<ISO251409RsReturnDetails> returnDetails;

    /**
     * Get the returnId.
     *
     * @return returnId
     *
     * @author Administrator
     */
    public Integer getReturnId() {
        return this.returnId;
    }
    /**
     * Set the returnId.
     *
     * @param returnId returnId
     *
     * @author Administrator
     */
    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }
    /**
     * Get the returnCode.
     *
     * @return returnCode
     *
     * @author Administrator
     */
    public String getReturnCode() {
        return this.returnCode;
    }
    /**
     * Set the returnCode.
     *
     * @param returnCode returnCode
     *
     * @author Administrator
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    /**
     * Get the returnStatus.
     *
     * @return returnStatus
     *
     * @author Administrator
     */
    public Integer getReturnStatus() {
        return this.returnStatus;
    }
    /**
     * Set the returnStatus.
     *
     * @param returnStatus returnStatus
     *
     * @author Administrator
     */
    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }
    /**
     * Get the returnSource.
     *
     * @return returnSource
     *
     * @author Administrator
     */
    public Integer getReturnSource() {
        return this.returnSource;
    }
    /**
     * Set the returnSource.
     *
     * @param returnSource returnSource
     *
     * @author Administrator
     */
    public void setReturnSource(Integer returnSource) {
        this.returnSource = returnSource;
    }
    /**
     * Get the returnType.
     *
     * @return returnType
     *
     * @author Administrator
     */
    public Integer getReturnType() {
        return this.returnType;
    }
    /**
     * Set the returnType.
     *
     * @param returnType returnType
     *
     * @author Administrator
     */
    public void setReturnType(Integer returnType) {
        this.returnType = returnType;
    }
    /**
     * Get the returnTime.
     *
     * @return returnTime
     *
     * @author Administrator
     */
    public Date getReturnTime() {
        return this.returnTime;
    }
    /**
     * Set the returnTime.
     *
     * @param returnTime returnTime
     *
     * @author Administrator
     */
    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }
    /**
     * Get the returnAmount.
     *
     * @return returnAmount
     *
     * @author Administrator
     */
    public BigDecimal getReturnAmount() {
        return this.returnAmount;
    }
    /**
     * Set the returnAmount.
     *
     * @param returnAmount returnAmount
     *
     * @author Administrator
     */
    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }
    /**
     * Get the returnMode.
     *
     * @return returnMode
     *
     * @author Administrator
     */
    public Integer getReturnMode() {
        return this.returnMode;
    }
    /**
     * Set the returnMode.
     *
     * @param returnMode returnMode
     *
     * @author Administrator
     */
    public void setReturnMode(Integer returnMode) {
        this.returnMode = returnMode;
    }
    /**
     * Get the returnReasonCode.
     *
     * @return returnReasonCode
     *
     * @author Administrator
     */
    public String getReturnReasonCode() {
        return this.returnReasonCode;
    }
    /**
     * Set the returnReasonCode.
     *
     * @param returnReasonCode returnReasonCode
     *
     * @author Administrator
     */
    public void setReturnReasonCode(String returnReasonCode) {
        this.returnReasonCode = returnReasonCode;
    }
    /**
     * Get the returnReasonDes.
     *
     * @return returnReasonDes
     *
     * @author Administrator
     */
    public String getReturnReasonDes() {
        return this.returnReasonDes;
    }
    /**
     * Set the returnReasonDes.
     *
     * @param returnReasonDes returnReasonDes
     *
     * @author Administrator
     */
    public void setReturnReasonDes(String returnReasonDes) {
        this.returnReasonDes = returnReasonDes;
    }
    /**
     * Get the image1.
     *
     * @return image1
     *
     * @author Administrator
     */
    public String getImage1() {
        return this.image1;
    }
    /**
     * Set the image1.
     *
     * @param image1 image1
     *
     * @author Administrator
     */
    public void setImage1(String image1) {
        this.image1 = image1;
    }
    /**
     * Get the image2.
     *
     * @return image2
     *
     * @author Administrator
     */
    public String getImage2() {
        return this.image2;
    }
    /**
     * Set the image2.
     *
     * @param image2 image2
     *
     * @author Administrator
     */
    public void setImage2(String image2) {
        this.image2 = image2;
    }
    /**
     * Get the image3.
     *
     * @return image3
     *
     * @author Administrator
     */
    public String getImage3() {
        return this.image3;
    }
    /**
     * Set the image3.
     *
     * @param image3 image3
     *
     * @author Administrator
     */
    public void setImage3(String image3) {
        this.image3 = image3;
    }
    /**
     * Get the image4.
     *
     * @return image4
     *
     * @author Administrator
     */
    public String getImage4() {
        return this.image4;
    }
    /**
     * Set the image4.
     *
     * @param image4 image4
     *
     * @author Administrator
     */
    public void setImage4(String image4) {
        this.image4 = image4;
    }
    /**
     * Get the image5.
     *
     * @return image5
     *
     * @author Administrator
     */
    public String getImage5() {
        return this.image5;
    }
    /**
     * Set the image5.
     *
     * @param image5 image5
     *
     * @author Administrator
     */
    public void setImage5(String image5) {
        this.image5 = image5;
    }
    /**
     * Get the iaPaid.
     *
     * @return iaPaid
     *
     * @author Administrator
     */
    public Integer getIaPaid() {
        return this.iaPaid;
    }
    /**
     * Set the iaPaid.
     *
     * @param iaPaid iaPaid
     *
     * @author Administrator
     */
    public void setIaPaid(Integer iaPaid) {
        this.iaPaid = iaPaid;
    }
    /**
     * Get the iaReturned.
     *
     * @return iaReturned
     *
     * @author Administrator
     */
    public Integer getIaReturned() {
        return this.iaReturned;
    }
    /**
     * Set the iaReturned.
     *
     * @param iaReturned iaReturned
     *
     * @author Administrator
     */
    public void setIaReturned(Integer iaReturned) {
        this.iaReturned = iaReturned;
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
     * Get the orderId.
     *
     * @return orderId
     *
     * @author Administrator
     */
    public Integer getOrderId() {
        return this.orderId;
    }
    /**
     * Set the orderId.
     *
     * @param orderId orderId
     *
     * @author Administrator
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    /**
     * Get the orderCode.
     *
     * @return orderCode
     *
     * @author Administrator
     */
    public String getOrderCode() {
        return this.orderCode;
    }
    /**
     * Set the orderCode.
     *
     * @param orderCode orderCode
     *
     * @author Administrator
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    /**
     * Get the orderTime.
     *
     * @return orderTime
     *
     * @author Administrator
     */
    public Integer getOrderTime() {
        return this.orderTime;
    }
    /**
     * Set the orderTime.
     *
     * @param orderTime orderTime
     *
     * @author Administrator
     */
    public void setOrderTime(Integer orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    /**
     * Get the returnDetails.
     *
     * @return returnDetails
     *
     * @author Administrator
     */

    public List<ISO251409RsReturnDetails> getReturnDetails() {
        return this.returnDetails;
    }
    /**
     * Set the returnDetails.
     *
     * @param returnDetails returnDetails
     *
     * @author Administrator
     */
    public void setReturnDetails(List<ISO251409RsReturnDetails> returnDetails) {
        this.returnDetails = returnDetails;
    }


    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark;
    }
}
