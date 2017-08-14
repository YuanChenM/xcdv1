package com.msk.so.bean;


import com.msk.core.bean.BaseBean;

/**卖家-交易记录
 * SO153202Param
 * yang_yang
 */
public class SO153202Param extends BaseBean{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 订单号 */
    private String selectCode;

    /**
     * 金额

     */
    private String money;

    /**

     * 退货数量
     */
    private String returnQty;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 重量
     */
    private String weight;

    /**
     * 单价
     */
    private String pdPrice;

    /**
     * 名称
     */
    private String name ;

    /**
     * 状态
     */
    private String state;

    /**
     * 订单数量
     */
    private String orderQty;

    /**
     * 收货地址
     */
    private String   receiverAddr;

    /**
     * 卖家留言
     */
    private String remark;

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 成交时间
     */
    private String clossTime;

    /**
     * 付款时间
     */
    private String paymentTime;

    /**
     * 发货时间
     */
    private String sendTime;

    /**
     * 完结时间
     */
    private String overTime;

    public String getReceiverAddr() {
        return receiverAddr;
    }

    public void setReceiverAddr(String receiverAddr) {
        this.receiverAddr = receiverAddr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getClossTime() {
        return clossTime;
    }

    public void setClossTime(String clossTime) {
        this.clossTime = clossTime;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    /**
     * <p>默认构造函数。</p>
     */
    public SO153202Param() {

    }
    public String getSelectCode() {
        return selectCode;
    }

    public void setSelectCode(String selectCode) {
        this.selectCode = selectCode;
    }

    public String getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(String returnQty) {
        this.returnQty = returnQty;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPdPrice() {
        return pdPrice;
    }

    public void setPdPrice(String pdPrice) {
        this.pdPrice = pdPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }


    public String getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(String orderQty) {
        this.orderQty = orderQty;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
