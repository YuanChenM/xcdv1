package com.msk.so.bean;


import java.util.List;

/**买家-交易记录详情
 * SO153101Bean
 * chen_xin
 */
public class SO153104Bean {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** 名称 */
    private String name;
    /** 金额 */
    private String price;
    /** 备注 */
    private String remarks;

    private List<SO153104InfoBean> sO153104InfoBean;

    public List<SO153104InfoBean> getsO153104InfoBean() {
        return sO153104InfoBean;
    }

    public void setsO153104InfoBean(List<SO153104InfoBean> sO153104InfoBean) {
        this.sO153104InfoBean = sO153104InfoBean;
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
