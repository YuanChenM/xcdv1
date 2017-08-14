/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表by_buyer_basic_info对应的ByBuyerBasicInfo。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class ByBuyerBasicInfo extends BaseEntity{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /** 买家ID */
    private java.lang.String buyerId;
    /** 买家编码 */
    private java.lang.String buyerCode;
    /** 买家名称 */
    private java.lang.String buyerName;
    /** 买家地址 */
    private java.lang.String buyerAddr;
    /** 菜场或批发市场的ID */
    private java.lang.String superiorId;
    /** 所属分类定性定级描述 */
    private java.lang.String superiorQua;
    /** 参考CONSTANT表 */
    private java.lang.String superiorType;
    /** 买家分类名称 */
    private java.lang.String superiorName;
    /** 省编码 */
    private java.lang.String provinceCode;
    /** 物流区编码 */
    private java.lang.String lgcsAreaCode;
    /** 地区（城市）编码 */
    private java.lang.String cityCode;
    /** 区（县）编码 */
    private java.lang.String districtCode;
    /** 买家网站 */
    private java.lang.String buyerWebsite;
    /** 买家微信公众号 */
    private java.lang.String buyerWechat;
    /** 店铺号 */
    private java.lang.String storeNo;
    /** 店铺面积 */
    private java.math.BigDecimal storeArea;
    /** 营业电话 */
    private java.lang.String busiTel;
    /** 员工人数 */
    private java.lang.Integer employeesNum;
    /** 参考CONSTANT表，逗号隔开，多选 */
    private java.lang.String paymentType;
    /** 计划订货间隙 */
    private java.lang.String planOrderGap;
    /** 计划订货量 */
    private java.lang.String planOrderNum;
    /** 实际订货间隙 */
    private java.lang.String actualOrderGap;
    /** 实际订货量 */
    private java.lang.String actualOrderNum;
    /** 营销/ 销售状态 */
    private java.lang.String marketingsStatus;
    /** 注册来源 */
    private java.lang.String registerSource;
    /** 参考CONSTANT表 */
    private java.lang.String superiorSubType;
    /** 买家二级分类名称 */
    private java.lang.String superiorSubName;
    /** 是否菜场买家（卤肉买家专用）(1：是菜场买家，0：非菜场买家) */
    private java.lang.String isMarketFlg;
    /** 买家账号电话号码 */
    private java.lang.String buyerTel;
    /**
     * <p>默认构造函数。</p>
     */
    public ByBuyerBasicInfo() {

    }

    /**
     * <p>买家ID。</p>
     *
     * @return the 买家ID
     */
    public java.lang.String getBuyerId() {
        return buyerId;
    }

    /**
     * <p>买家ID。</p>
     *
     * @param buyerId 买家ID。
     */
    public void setBuyerId(java.lang.String buyerId) {
        this.buyerId = buyerId;
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
     * <p>买家地址。</p>
     *
     * @return the 买家地址
     */
    public java.lang.String getBuyerAddr() {
        return buyerAddr;
    }

    /**
     * <p>买家地址。</p>
     *
     * @param buyerAddr 买家地址。
     */
    public void setBuyerAddr(java.lang.String buyerAddr) {
        this.buyerAddr = buyerAddr;
    }

    /**
     * <p>菜场或批发市场的ID。</p>
     *
     * @return the 菜场或批发市场的ID
     */
    public java.lang.String getSuperiorId() {
        return superiorId;
    }

    /**
     * <p>菜场或批发市场的ID。</p>
     *
     * @param superiorId 菜场或批发市场的ID。
     */
    public void setSuperiorId(java.lang.String superiorId) {
        this.superiorId = superiorId;
    }

    /**
     * <p>所属分类定性定级描述。</p>
     *
     * @return the 所属分类定性定级描述
     */
    public java.lang.String getSuperiorQua() {
        return superiorQua;
    }

    /**
     * <p>所属分类定性定级描述。</p>
     *
     * @param superiorQua 所属分类定性定级描述。
     */
    public void setSuperiorQua(java.lang.String superiorQua) {
        this.superiorQua = superiorQua;
    }

    /**
     * <p>参考CONSTANT表。</p>
     *
     * @return the 参考CONSTANT表
     */
    public java.lang.String getSuperiorType() {
        return superiorType;
    }

    /**
     * <p>参考CONSTANT表。</p>
     *
     * @param superiorType 参考CONSTANT表。
     */
    public void setSuperiorType(java.lang.String superiorType) {
        this.superiorType = superiorType;
    }

    /**
     * <p>买家分类名称。</p>
     *
     * @return the 买家分类名称
     */
    public java.lang.String getSuperiorName() {
        return superiorName;
    }

    /**
     * <p>买家分类名称。</p>
     *
     * @param superiorName 买家分类名称。
     */
    public void setSuperiorName(java.lang.String superiorName) {
        this.superiorName = superiorName;
    }

    /**
     * <p>省编码。</p>
     *
     * @return the 省编码
     */
    public java.lang.String getProvinceCode() {
        return provinceCode;
    }

    /**
     * <p>省编码。</p>
     *
     * @param provinceCode 省编码。
     */
    public void setProvinceCode(java.lang.String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @return the 物流区编码
     */
    public java.lang.String getLgcsAreaCode() {
        return lgcsAreaCode;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @param lgcsAreaCode 物流区编码。
     */
    public void setLgcsAreaCode(java.lang.String lgcsAreaCode) {
        this.lgcsAreaCode = lgcsAreaCode;
    }

    /**
     * <p>地区（城市）编码。</p>
     *
     * @return the 地区（城市）编码
     */
    public java.lang.String getCityCode() {
        return cityCode;
    }

    /**
     * <p>地区（城市）编码。</p>
     *
     * @param cityCode 地区（城市）编码。
     */
    public void setCityCode(java.lang.String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * <p>区（县）编码。</p>
     *
     * @return the 区（县）编码
     */
    public java.lang.String getDistrictCode() {
        return districtCode;
    }

    /**
     * <p>区（县）编码。</p>
     *
     * @param districtCode 区（县）编码。
     */
    public void setDistrictCode(java.lang.String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * <p>买家网站。</p>
     *
     * @return the 买家网站
     */
    public java.lang.String getBuyerWebsite() {
        return buyerWebsite;
    }

    /**
     * <p>买家网站。</p>
     *
     * @param buyerWebsite 买家网站。
     */
    public void setBuyerWebsite(java.lang.String buyerWebsite) {
        this.buyerWebsite = buyerWebsite;
    }

    /**
     * <p>买家微信公众号。</p>
     *
     * @return the 买家微信公众号
     */
    public java.lang.String getBuyerWechat() {
        return buyerWechat;
    }

    /**
     * <p>买家微信公众号。</p>
     *
     * @param buyerWechat 买家微信公众号。
     */
    public void setBuyerWechat(java.lang.String buyerWechat) {
        this.buyerWechat = buyerWechat;
    }

    /**
     * <p>店铺号。</p>
     *
     * @return the 店铺号
     */
    public java.lang.String getStoreNo() {
        return storeNo;
    }

    /**
     * <p>店铺号。</p>
     *
     * @param storeNo 店铺号。
     */
    public void setStoreNo(java.lang.String storeNo) {
        this.storeNo = storeNo;
    }

    /**
     * <p>店铺面积。</p>
     *
     * @return the 店铺面积
     */
    public java.math.BigDecimal getStoreArea() {
        return storeArea;
    }

    /**
     * <p>店铺面积。</p>
     *
     * @param storeArea 店铺面积。
     */
    public void setStoreArea(java.math.BigDecimal storeArea) {
        this.storeArea = storeArea;
    }

    /**
     * <p>营业电话。</p>
     *
     * @return the 营业电话
     */
    public java.lang.String getBusiTel() {
        return busiTel;
    }

    /**
     * <p>营业电话。</p>
     *
     * @param busiTel 营业电话。
     */
    public void setBusiTel(java.lang.String busiTel) {
        this.busiTel = busiTel;
    }

    /**
     * <p>员工人数。</p>
     *
     * @return the 员工人数
     */
    public java.lang.Integer getEmployeesNum() {
        return employeesNum;
    }

    /**
     * <p>员工人数。</p>
     *
     * @param employeesNum 员工人数。
     */
    public void setEmployeesNum(java.lang.Integer employeesNum) {
        this.employeesNum = employeesNum;
    }

    /**
     * <p>参考CONSTANT表，逗号隔开，多选。</p>
     *
     * @return the 参考CONSTANT表，逗号隔开，多选
     */
    public java.lang.String getPaymentType() {
        return paymentType;
    }

    /**
     * <p>参考CONSTANT表，逗号隔开，多选。</p>
     *
     * @param paymentType 参考CONSTANT表，逗号隔开，多选。
     */
    public void setPaymentType(java.lang.String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * <p>计划订货间隙。</p>
     *
     * @return the 计划订货间隙
     */
    public java.lang.String getPlanOrderGap() {
        return planOrderGap;
    }

    /**
     * <p>计划订货间隙。</p>
     *
     * @param planOrderGap 计划订货间隙。
     */
    public void setPlanOrderGap(java.lang.String planOrderGap) {
        this.planOrderGap = planOrderGap;
    }

    /**
     * <p>计划订货量。</p>
     *
     * @return the 计划订货量
     */
    public java.lang.String getPlanOrderNum() {
        return planOrderNum;
    }

    /**
     * <p>计划订货量。</p>
     *
     * @param planOrderNum 计划订货量。
     */
    public void setPlanOrderNum(java.lang.String planOrderNum) {
        this.planOrderNum = planOrderNum;
    }

    /**
     * <p>实际订货间隙。</p>
     *
     * @return the 实际订货间隙
     */
    public java.lang.String getActualOrderGap() {
        return actualOrderGap;
    }

    /**
     * <p>实际订货间隙。</p>
     *
     * @param actualOrderGap 实际订货间隙。
     */
    public void setActualOrderGap(java.lang.String actualOrderGap) {
        this.actualOrderGap = actualOrderGap;
    }

    /**
     * <p>实际订货量。</p>
     *
     * @return the 实际订货量
     */
    public java.lang.String getActualOrderNum() {
        return actualOrderNum;
    }

    /**
     * <p>实际订货量。</p>
     *
     * @param actualOrderNum 实际订货量。
     */
    public void setActualOrderNum(java.lang.String actualOrderNum) {
        this.actualOrderNum = actualOrderNum;
    }

    /**
     * <p>营销/ 销售状态。</p>
     *
     * @return the 营销/ 销售状态
     */
    public java.lang.String getMarketingsStatus() {
        return marketingsStatus;
    }

    /**
     * <p>营销/ 销售状态。</p>
     *
     * @param marketingsStatus 营销/ 销售状态。
     */
    public void setMarketingsStatus(java.lang.String marketingsStatus) {
        this.marketingsStatus = marketingsStatus;
    }

    /**
     * <p>注册来源。</p>
     *
     * @return the 注册来源
     */
    public java.lang.String getRegisterSource() {
        return registerSource;
    }

    /**
     * <p>注册来源。</p>
     *
     * @param registerSource 注册来源。
     */
    public void setRegisterSource(java.lang.String registerSource) {
        this.registerSource = registerSource;
    }

    /**
     * <p>参考CONSTANT表。</p>
     *
     * @return the 参考CONSTANT表
     */
    public java.lang.String getSuperiorSubType() {
        return superiorSubType;
    }

    /**
     * <p>参考CONSTANT表。</p>
     *
     * @param superiorSubType 参考CONSTANT表。
     */
    public void setSuperiorSubType(java.lang.String superiorSubType) {
        this.superiorSubType = superiorSubType;
    }

    /**
     * <p>买家二级分类名称。</p>
     *
     * @return the 买家二级分类名称
     */
    public java.lang.String getSuperiorSubName() {
        return superiorSubName;
    }

    /**
     * <p>买家二级分类名称。</p>
     *
     * @param superiorSubName 买家二级分类名称。
     */
    public void setSuperiorSubName(java.lang.String superiorSubName) {
        this.superiorSubName = superiorSubName;
    }

    /**
     * <p>是否菜场买家（卤肉买家专用）(1：是菜场买家，0：非菜场买家)。</p>
     *
     * @return the 是否菜场买家（卤肉买家专用）(1：是菜场买家，0：非菜场买家)
     */
    public java.lang.String getIsMarketFlg() {
        return isMarketFlg;
    }

    /**
     * <p>是否菜场买家（卤肉买家专用）(1：是菜场买家，0：非菜场买家)。</p>
     *
     * @param isMarketFlg 是否菜场买家（卤肉买家专用）(1：是菜场买家，0：非菜场买家)。
     */
    public void setIsMarketFlg(java.lang.String isMarketFlg) {
        this.isMarketFlg = isMarketFlg;
    }

    /**
     * <p>买家账号电话号码。</p>
     *
     * @return the 手机号码
     */
    public java.lang.String getBuyerTel()
    {
        return buyerTel;
    }

    /**
     * <p>买家账号电话号码。</p>
     *
     * @param buyerTel 手机号码。
     */
    public void setBuyerTel(java.lang.String buyerTel)
    {
        this.buyerTel = buyerTel;
    }
}
