package com.msk.so.bean;


import java.util.List;

/**买家-交易记录详情
 * SO153101Bean
 * chen_xin
 */
public class SO153205Bean {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 名称 */
    private String name;
    /** 金额 */
    private String price;
    /** 备注 */
    private String remarks;

    private List<SO153205InfoBean> sO153205InfoBean;

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

    public List<SO153205InfoBean> getsO153205InfoBean() {
        return sO153205InfoBean;
    }

    public void setsO153205InfoBean(List<SO153205InfoBean> sO153205InfoBean) {
        this.sO153205InfoBean = sO153205InfoBean;
    }
}
