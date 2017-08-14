package com.msk.so.bean;


import java.util.List;

/**买家-交易记录详情
 * SO153101Bean
 * chen_xin
 */
public class SO153105Bean {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 名称 */
    private String name;
    /** 金额 */
    private String price;
    /** 备注 */
    private String remarks;

    private List<SO153105InfoBean> sO153105InfoBean;

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

    public List<SO153105InfoBean> getsO153105InfoBean() {
        return sO153105InfoBean;
    }

    public void setsO153105InfoBean(List<SO153105InfoBean> sO153105InfoBean) {
        this.sO153105InfoBean = sO153105InfoBean;
    }
}
