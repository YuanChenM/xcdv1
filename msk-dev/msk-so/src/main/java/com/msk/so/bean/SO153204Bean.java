package com.msk.so.bean;


import java.util.List;

/**买家-交易记录详情
 * SO153101Bean
 * chen_xin
 */
public class SO153204Bean {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 名称 */
    private String name;
    /** 金额 */
    private String price;
    /** 备注 */
    private String remarks;

    private List<SO153204InfoBean> sO153204InfoBean;

    public List<SO153204InfoBean> getsO153204InfoBean() {
        return sO153204InfoBean;
    }

    public void setsO153204InfoBean(List<SO153204InfoBean> sO153204InfoBean) {
        this.sO153204InfoBean = sO153204InfoBean;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
