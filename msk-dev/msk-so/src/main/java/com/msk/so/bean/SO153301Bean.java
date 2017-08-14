package com.msk.so.bean;


/**收支平衡管理
 * SO153301Bean
 * zhou_ling
 */
public class SO153301Bean {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 创建时间 */
    private String createTime;
    /** 名称 */
    private String name;
    /** 商户订单号 */
    private String orderNum;
    /** 重量 */
    private String weight;
    /** 金额 */
    private String money;
    /** 状态 */
    private String state;

    /** 单价 */
    private String price;
    /** 入库时间 */
    private String incomingTime;
    /** 出库时间 */
    private String outcomingTime;

    /** 日期 */
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIncomingTime() {
        return incomingTime;
    }

    public void setIncomingTime(String incomingTime) {
        this.incomingTime = incomingTime;
    }

    public String getOutcomingTime() {
        return outcomingTime;
    }

    public void setOutcomingTime(String outcomingTime) {
        this.outcomingTime = outcomingTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
