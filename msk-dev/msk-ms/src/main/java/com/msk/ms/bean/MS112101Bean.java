package com.msk.ms.bean;

import com.msk.core.bean.BaseBean;

/**
 * SO151501Bean
 * 会员卡列表list
 * @author jiang_nan
 * @version 1.0
 **/
public class MS112101Bean extends BaseBean {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;
    //会员卡ID
    private String msId;
    /** 会员卡编号 */
    private String msCardno;
    /** 买家编号 */
    private String buyerCode;
    /** 买家名称 */
    private String buyerName;
    /** 是否已激活 */
    private String isActivate;
    /** 是否已发放 */
    private String isProvide;
    /** 发放日期 */
    private String provideDate;
    /**
     * Get the msCardno.
     *
     * @return msCardno
     *
     * @author rwf
     */
    public String getMsCardno() {
        return this.msCardno;
    }
    /**
     * Set the msCardno.
     *
     * @param msCardno msCardno
     *
     * @author rwf
     */
    public void setMsCardno(String msCardno) {
        this.msCardno = msCardno;
    }
    /**
     * Get the buyerCode.
     *
     * @return buyerCode
     *
     * @author rwf
     */
    public String getBuyerCode() {
        return this.buyerCode;
    }
    /**
     * Set the buyerCode.
     *
     * @param buyerCode buyerCode
     *
     * @author rwf
     */
    public void setBuyerCode(String buyerCode) {
        this.buyerCode = buyerCode;
    }
    /**
     * Get the buyerName.
     *
     * @return buyerName
     *
     * @author rwf
     */
    public String getBuyerName() {
        return this.buyerName;
    }
    /**
     * Set the buyerName.
     *
     * @param buyerName buyerName
     *
     * @author rwf
     */
    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
    /**
     * Get the isActivate.
     *
     * @return isActivate
     *
     * @author rwf
     */
    public String getIsActivate() {
        return this.isActivate;
    }
    /**
     * Set the isActivate.
     *
     * @param isActivate isActivate
     *
     * @author rwf
     */
    public void setIsActivate(String isActivate) {
        this.isActivate = isActivate;
    }
    /**
     * Get the isProvide.
     *
     * @return isProvide
     *
     * @author rwf
     */
    public String getIsProvide() {
        return this.isProvide;
    }
    /**
     * Set the isProvide.
     *
     * @param isProvide isProvide
     *
     * @author rwf
     */
    public void setIsProvide(String isProvide) {
        this.isProvide = isProvide;
    }
    /**
     * Get the provideDate.
     *
     * @return provideDate
     *
     * @author rwf
     */
    public String getProvideDate() {
        return this.provideDate;
    }
    /**
     * Set the provideDate.
     *
     * @param provideDate provideDate
     *
     * @author rwf
     */
    public void setProvideDate(String provideDate) {
        this.provideDate = provideDate;
    }
    /**
     * Get the msId.
     *
     * @return msId
     *
     * @author rwf
     */
    public String getMsId() {
        return this.msId;
    }
    /**
     * Set the msId.
     *
     * @param msId msId
     *
     * @author rwf
     */
    public void setMsId(String msId) {
        this.msId = msId;
    }

    
}
