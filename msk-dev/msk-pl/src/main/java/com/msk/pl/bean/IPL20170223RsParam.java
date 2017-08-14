package com.msk.pl.bean;

import com.msk.core.bean.RsPageParam;

/**
 * Created by gyh on 2017/2/9.
 * 合伙人任务完成统计结果
 */
public class IPL20170223RsParam extends RsPageParam {
    //合伙人ID
    private Long partnerId;
    //按0：全部 1.配送站 2.买手 统计
    private Integer selectRule;
    //进货单创建时间，格式YYYY-MM
    private String crtDate;

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
