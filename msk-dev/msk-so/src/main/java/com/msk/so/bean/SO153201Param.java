package com.msk.so.bean;


import com.msk.core.bean.BaseBean;

/**卖家-交易记录
 * SO153201Param
 * yang_yang
 */
public class SO153201Param extends BaseBean{
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    /** 交易日期 */
    private String tranTime;
    /** 收款方 */
    private String businessMain;
    /** 付款方 */
    private String businessAssistant;
    /** 订单号 */
    private String selectCode;
    /** 发生金额 */
    private String orderAmount;
    /** 备注 */
    private String remark;
    /**结算*/
    private String settlement;


    /** 订单编号(直接拿到的) */
    private String orderCode;

    /**
     * <p>默认构造函数。</p>

     */
    public SO153201Param() {

    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    public String getTranTime() {
        return tranTime;
    }

    public void setTranTime(String tranTime) {
        this.tranTime = tranTime;
    }

    public String getBusinessMain() {
        return businessMain;
    }

    public void setBusinessMain(String businessMain) {
        this.businessMain = businessMain;
    }

    public String getBusinessAssistant() {
        return businessAssistant;
    }

    public void setBusinessAssistant(String businessAssistant) {
        this.businessAssistant = businessAssistant;
    }

    public String getSelectCode() {
        return selectCode;
    }

    public void setSelectCode(String selectCode) {
        this.selectCode = selectCode;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }
}
