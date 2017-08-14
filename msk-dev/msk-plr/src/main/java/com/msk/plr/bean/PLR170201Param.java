package com.msk.plr.bean;

import com.msk.core.bean.BasePageParam;

/**
 * SL241101Bean
 *
 * @author gyh
 * @version 1.0
 **/
public class PLR170201Param extends BasePageParam {
    //统计单位
    private int selectRule;
    //合伙人
    private Long partnerId;
    //配送站
    private Long terminalId;
    //买手
    private String bsCode;
    //时间
    private String crtDate;

    /**
     * Getter method for property <tt>selectRule</tt>.
     *
     * @return property value of selectRule
     */
    public int getSelectRule() {
        return selectRule;
    }

    /**
     * Setter method for property <tt>selectRule</tt>.
     *
     * @param selectRule value to be assigned to property selectRule
     */
    public void setSelectRule(int selectRule) {
        this.selectRule = selectRule;
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
     * Getter method for property <tt>terminalId</tt>.
     *
     * @return property value of terminalId
     */
    public Long getTerminalId() {
        return terminalId;
    }

    /**
     * Setter method for property <tt>terminalId</tt>.
     *
     * @param terminalId value to be assigned to property terminalId
     */
    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    /**
     * Getter method for property <tt>bsCode</tt>.
     *
     * @return property value of bsCode
     */
    public String getBsCode() {
        return bsCode;
    }

    /**
     * Setter method for property <tt>bsCode</tt>.
     *
     * @param bsCode value to be assigned to property bsCode
     */
    public void setBsCode(String bsCode) {
        this.bsCode = bsCode;
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
