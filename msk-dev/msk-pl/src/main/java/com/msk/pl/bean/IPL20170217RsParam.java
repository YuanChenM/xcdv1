package com.msk.pl.bean;

import com.msk.core.bean.RsPageParam;

/**
 * Created by gyh on 2017/2/7.
 * 合伙人进货单查看参数
 */
public class IPL20170217RsParam extends RsPageParam {
    //合伙人ID
    private Long partnerId;
    //0：全部 1.配送站 2.买手
    private Integer selectRule;
    //配送站ID或买手编码
    private String ruleDetail;
    //填报日期，格式YYYY-MM
    private String crtDate;
    //进货单状态1.有效 0.无效
    private Integer status;

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
     * Getter method for property <tt>ruleDetail</tt>.
     *
     * @return property value of ruleDetail
     */
    public String getRuleDetail() {
        return ruleDetail;
    }

    /**
     * Setter method for property <tt>ruleDetail</tt>.
     *
     * @param ruleDetail value to be assigned to property ruleDetail
     */
    public void setRuleDetail(String ruleDetail) {
        this.ruleDetail = ruleDetail;
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

    /**
     * Getter method for property <tt>status</tt>.
     *
     * @return property value of status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     *
     * @param status value to be assigned to property status
     */
    public void setStatus(Integer status) {
        this.status = status;
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
}
