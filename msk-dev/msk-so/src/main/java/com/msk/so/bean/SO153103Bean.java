package com.msk.so.bean;


/**买家-交易记录详情
 * SO153101Bean
 * chen_xin
 */
public class SO153103Bean {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 类型 */
    private String type;
    /** 消费名称 */
    private String name;
    /** 实付金额 */
    private String price;
    /** 优惠 */
    private String discount;
    /** 优惠券 */
    private String coupon;
    /** 服务费 */
    private String serviceCharge;
    /** 总额 */
    private String total;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(String serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
