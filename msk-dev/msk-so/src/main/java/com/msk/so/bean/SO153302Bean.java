package com.msk.so.bean;


import com.msk.core.bean.BaseBean;

/**收支平衡管理
 * SO153301Bean
 * liu_tao2
 */
public class SO153302Bean extends BaseBean{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 付款时间 */
    private String time;
    /** 类型 */
    private String type;
    /** 说明 */
    private String explain;
    /** 金额  |  明细 */
    private String money;

    /**

     * 退货数量
     */
    private Long returnQty;

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
    private Long pdPrice;

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
    private Long orderQty;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Long getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(Long returnQty) {
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

    public Long getPdPrice() {
        return pdPrice;
    }

    public void setPdPrice(Long pdPrice) {
        this.pdPrice = pdPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReceiverAddr() {
        return receiverAddr;
    }

    public void setReceiverAddr(String receiverAddr) {
        this.receiverAddr = receiverAddr;
    }

    public Long getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Long orderQty) {
        this.orderQty = orderQty;
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
}
