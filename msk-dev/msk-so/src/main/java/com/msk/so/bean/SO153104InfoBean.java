package com.msk.so.bean;


/**买家-交易记录详情
 * SO153101Bean
 * chen_xin
 */
public class SO153104InfoBean {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 名称 */
    private String name;
    /** 金额 */
    private String price;
    /** 备注 */
    private String remarks;

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


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
