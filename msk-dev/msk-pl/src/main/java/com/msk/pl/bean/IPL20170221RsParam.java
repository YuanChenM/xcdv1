package com.msk.pl.bean;

import com.msk.core.bean.RsPageParam;

/**
 * Created by gyh on 2017/2/8.
 * 合伙人计费查询结果
 */
public class IPL20170221RsParam extends RsPageParam {
    //合伙人ID
    private Long partnerId;
    //按0：全部 1.配送站 2.买手 统计
    private Integer selectRule;
    //进货单创建时间，格式YYYY-MM
    private String crtDate;
    //1:计费查询 2:进货单统计查询
    private int selectType;

    /**
     * Getter method for property <tt>selectType</tt>.
     *
     * @return property value of selectType
     */
    public int getSelectType() {
        return selectType;
    }

    /**
     * Setter method for property <tt>selectType</tt>.
     *
     * @param selectType value to be assigned to property selectType
     */
    public void setSelectType(int selectType) {
        this.selectType = selectType;
    }

    /**
     * Getter method for property <tt>partnerId</tt>.
     *
     * @return property value of partnerId
     */
    public Long getPartnerId() {
        return partnerId;
    }

    /**
     * Setter method for property <tt>partnerId</tt>.
     *
     * @param partnerId value to be assigned to property partnerId
     */
    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    /**
     * Getter method for property <tt>selectRule</tt>.
     *
     * @return property value of selectRule
     */
    public Integer getSelectRule() {
        return selectRule;
    }

    /**
     * Setter method for property <tt>selectRule</tt>.
     *
     * @param selectRule value to be assigned to property selectRule
     */
    public void setSelectRule(Integer selectRule) {
        this.selectRule = selectRule;
    }

    /**
     * Getter method for property <tt>crtDate</tt>.
     *
     * @return property value of crtDate
     */
    public String getCrtDate() {
        return crtDate;
    }

    /**
     * Setter method for property <tt>crtDate</tt>.
     *
     * @param crtDate value to be assigned to property crtDate
     */
    public void setCrtDate(String crtDate) {
        this.crtDate = crtDate;
    }
}
