package com.msk.so.bean;

import com.msk.core.bean.BaseParam;

import java.util.List;

/**
 * zhang_qiang1
 * 三合一  收货接口入参
 */
public class ISO251413RsParam extends BaseParam {

    private  String orderCode;

    private Long orderId;// 订单id

    private Long shipId;// 发货单id

    private String applyMan;//申请人名称

    private String applyTime;// 申请时间

    private String applyRemark;// 申请备注

    private String buyerId;// 买家id

    private Integer ver;// 版本号

    private Integer returnReasonID;// 迟收/退货明细原因

    private String returnReasonName;// 迟收/退货明细原因名称

    private String receiptDate;// 迟收再发送日期(YYYY-MM-DD)

    private String image1;//迟收/退货原因照片1文件ID（调用方上传文件到文件服务器得到文件服务器返回的文件ID，调用方将文件文件ID传入OMS）

    private String image2;//迟收/退货原因照片2文件

    private String image3;//迟收/退货原因照片3文件

    private String image4;//迟收/退货原因照片4文件

    private String image5;//迟收/退货原因照片5文件

    private  Integer isPaid;//是否已付款，1:已付款;2:未付款

    private  Integer suppStatus ;

    private List<ISO251413PaymentRsParam> paymentList;//买家支付信息List


    public List<ISO251413OrderShipInfoRsParam> getShipList() {
        return shipList;
    }

    public void setShipList(List<ISO251413OrderShipInfoRsParam> shipList) {
        this.shipList = shipList;
    }

    private List<ISO251413OrderShipInfoRsParam> shipList;//配送单信息List

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public String getApplyMan() {
        return applyMan;
    }

    public void setApplyMan(String applyMan) {
        this.applyMan = applyMan;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyRemark() {
        return applyRemark;
    }

    public void setApplyRemark(String applyRemark) {
        this.applyRemark = applyRemark;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    @Override
    public Integer getVer() {
        return ver;
    }

    @Override
    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public Integer getReturnReasonID() {
        return returnReasonID;
    }

    public void setReturnReasonID(Integer returnReasonID) {
        this.returnReasonID = returnReasonID;
    }

    public String getReturnReasonName() {
        return returnReasonName;
    }

    public void setReturnReasonName(String returnReasonName) {
        this.returnReasonName = returnReasonName;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public List<ISO251413PaymentRsParam> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<ISO251413PaymentRsParam> paymentList) {
        this.paymentList = paymentList;
    }

    public Integer getSuppStatus() {
        return suppStatus;
    }

    public void setSuppStatus(Integer suppStatus) {
        this.suppStatus = suppStatus;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}
