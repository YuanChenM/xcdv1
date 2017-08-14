/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表ms_cardmanager对应的MsCardmanager。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class MsCardmanager extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 会员卡ID */
    private java.lang.Long msId;
    /** 会员卡编码 */
    private java.lang.String msCardno;
    /** 加密后密文 */
    private java.lang.String msInitpw;
    /** 会员卡有效期 */
    private java.util.Date expireDate;
    /** 采购批次 */
    private java.lang.String purchaseLot;
    /** 1:是 */
    private java.lang.String isActivate;
    /** 会员卡前次密码 */
    private java.lang.String msPrevpw;
    /** 会员卡当前密码 */
    private java.lang.String msNowpw;
    /** 买家编码 */
    private java.lang.String buyerCode;
    /** 买家名称 */
    private java.lang.String buyerName;
    /** 会员编码 */
    private java.lang.String msCode;
    /** 1:是 */
    private java.lang.String isProvide;
    /** 发放日期 */
    private java.util.Date provideDate;
    /**
     * <p>默认构造函数。</p>
     */
    public MsCardmanager() {

    }

    /**
     * <p>会员卡ID。</p>
     *
     * @return the 会员卡ID
     */
    public java.lang.Long getMsId() {
        return msId;
    }

    /**
     * <p>会员卡ID。</p>
     *
     * @param msId 会员卡ID。
     */
    public void setMsId(java.lang.Long msId) {
        this.msId = msId;
    }

    /**
     * <p>会员卡编码。</p>
     *
     * @return the 会员卡编码
     */
    public java.lang.String getMsCardno() {
        return msCardno;
    }

    /**
     * <p>会员卡编码。</p>
     *
     * @param msCardno 会员卡编码。
     */
    public void setMsCardno(java.lang.String msCardno) {
        this.msCardno = msCardno;
    }

    /**
     * <p>加密后密文。</p>
     *
     * @return the 加密后密文
     */
    public java.lang.String getMsInitpw() {
        return msInitpw;
    }

    /**
     * <p>加密后密文。</p>
     *
     * @param msInitpw 加密后密文。
     */
    public void setMsInitpw(java.lang.String msInitpw) {
        this.msInitpw = msInitpw;
    }

    /**
     * <p>会员卡有效期。</p>
     *
     * @return the 会员卡有效期
     */
    public java.util.Date getExpireDate() {
        return expireDate;
    }

    /**
     * <p>会员卡有效期。</p>
     *
     * @param expireDate 会员卡有效期。
     */
    public void setExpireDate(java.util.Date expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * <p>采购批次。</p>
     *
     * @return the 采购批次
     */
    public java.lang.String getPurchaseLot() {
        return purchaseLot;
    }

    /**
     * <p>采购批次。</p>
     *
     * @param purchaseLot 采购批次。
     */
    public void setPurchaseLot(java.lang.String purchaseLot) {
        this.purchaseLot = purchaseLot;
    }

    /**
     * <p>1:是。</p>
     *
     * @return the 1:是
     */
    public java.lang.String getIsActivate() {
        return isActivate;
    }

    /**
     * <p>1:是。</p>
     *
     * @param isActivate 1:是。
     */
    public void setIsActivate(java.lang.String isActivate) {
        this.isActivate = isActivate;
    }

    /**
     * <p>会员卡前次密码。</p>
     *
     * @return the 会员卡前次密码
     */
    public java.lang.String getMsPrevpw() {
        return msPrevpw;
    }

    /**
     * <p>会员卡前次密码。</p>
     *
     * @param msPrevpw 会员卡前次密码。
     */
    public void setMsPrevpw(java.lang.String msPrevpw) {
        this.msPrevpw = msPrevpw;
    }

    /**
     * <p>会员卡当前密码。</p>
     *
     * @return the 会员卡当前密码
     */
    public java.lang.String getMsNowpw() {
        return msNowpw;
    }

    /**
     * <p>会员卡当前密码。</p>
     *
     * @param msNowpw 会员卡当前密码。
     */
    public void setMsNowpw(java.lang.String msNowpw) {
        this.msNowpw = msNowpw;
    }

    /**
     * <p>买家编码。</p>
     *
     * @return the 买家编码
     */
    public java.lang.String getBuyerCode() {
        return buyerCode;
    }

    /**
     * <p>买家编码。</p>
     *
     * @param buyerCode 买家编码。
     */
    public void setBuyerCode(java.lang.String buyerCode) {
        this.buyerCode = buyerCode;
    }

    /**
     * <p>买家名称。</p>
     *
     * @return the 买家名称
     */
    public java.lang.String getBuyerName() {
        return buyerName;
    }

    /**
     * <p>买家名称。</p>
     *
     * @param buyerName 买家名称。
     */
    public void setBuyerName(java.lang.String buyerName) {
        this.buyerName = buyerName;
    }

    /**
     * <p>会员编码。</p>
     *
     * @return the 会员编码
     */
    public java.lang.String getMsCode() {
        return msCode;
    }

    /**
     * <p>会员编码。</p>
     *
     * @param msCode 会员编码。
     */
    public void setMsCode(java.lang.String msCode) {
        this.msCode = msCode;
    }

    /**
     * <p>1:是。</p>
     *
     * @return the 1:是
     */
    public java.lang.String getIsProvide() {
        return isProvide;
    }

    /**
     * <p>1:是。</p>
     *
     * @param isProvide 1:是。
     */
    public void setIsProvide(java.lang.String isProvide) {
        this.isProvide = isProvide;
    }

    /**
     * <p>发放日期。</p>
     *
     * @return the 发放日期
     */
    public java.util.Date getProvideDate() {
        return provideDate;
    }

    /**
     * <p>发放日期。</p>
     *
     * @param provideDate 发放日期。
     */
    public void setProvideDate(java.util.Date provideDate) {
        this.provideDate = provideDate;
    }

}
