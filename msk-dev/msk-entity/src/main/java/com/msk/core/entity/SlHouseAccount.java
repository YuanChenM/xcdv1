/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.core.entity;
/**
 * <p>表sl_house_account对应的SlHouseAccount。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class SlHouseAccount extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 区划(6)+顺序码(4) */
    private java.lang.String slCode;
    /** 用于登录的卖家账号 */
    private java.lang.String houseAccount;
    /** 用于登录的卖家账号 */
    private java.lang.String houseCode;
    /** 用于登录的卖家账号 */
    private java.lang.String houseCodeDis;
    /** 也可以用于登录 */
    private java.lang.String houseTel;
    /** 管家显示名称 */
    private java.lang.String houseShowName;
    /** 联系人姓名 */
    private java.lang.String houseContact;
    /** 加密后的值 */
    private java.lang.String accountPsd;
    /** 0:未认证,1:认证中,2:已认证 */
    private java.lang.Integer authStatus;
    /** 管家身份证号 */
    private java.lang.String slIdcard;
    /** 1：国产，2：进口 */
    private java.lang.String slConFlg;
    /** 大区 */
    private java.lang.String areaCode;
    /** 物流区编码 */
    private java.lang.String lgcsAreaCode;
    /** 省编码 */
    private java.lang.String provinceCode;
    /** 地区编码 */
    private java.lang.String cityCode;
    /** 区编码 */
    private java.lang.String districtCode;
    /** 管家地址 */
    private java.lang.String houseAddress;
    /** 大区 */
    private java.lang.String vareaCode;
    /** 物流区编码 */
    private java.lang.String vlgcsAreaCode;
    /** 省编码 */
    private java.lang.String vprovinceCode;
    /** 地区编码 */
    private java.lang.String vcityCode;
    /** 区编码 */
    private java.lang.String vdistrictCode;
    /** 虚拟管家地址 */
    private java.lang.String vhouseAddress;
    /** 维度 */
    private java.lang.String lat;
    /** 精度 */
    private java.lang.String lon;
    /** 虚拟地址维度 */
    private java.lang.String vlat;
    /** 虚拟地址精度 */
    private java.lang.String vlon;
    /** 1:专业冻品管家资格未申请 2:专业冻品管家资格申请中 */
    private java.lang.String licenses;
    /** 买手签署 */
    private java.lang.String buyerAsign;
    /** 微信号码 */
    private java.lang.String wechat;
    /** QQ号码 */
    private java.lang.String qq;
    /** 邮箱 */
    private java.lang.String email;
    /** 1:行业型	2:创业型	3:关系型	4:配送型 */
    private java.lang.String fixedTel;
    /** 传真号 */
    private java.lang.String fax;
    /** 备用20 */
    private java.lang.String flag20;
    /** 备用19 */
    private java.lang.String flag19;
    /** 备用18 */
    private java.lang.String flag18;
    /** 备用17 */
    private java.lang.String flag17;
    /** 备用16 */
    private java.lang.String flag16;
    /** 备用15 */
    private java.lang.String flag15;
    /** 备用14 */
    private java.lang.String flag14;
    /** 备用13 */
    private java.lang.String flag13;
    /** 备用12 */
    private java.lang.String flag12;
    /** 备用11 */
    private java.lang.String flag11;
    /** 备用10 */
    private java.lang.String flag10;
    /** 备用9 */
    private java.lang.String flag9;
    /** 备用8 */
    private java.lang.String flag8;
    /** 备用7 */
    private java.lang.String flag7;
    /** 备用6 */
    private java.lang.String flag6;
    /** 备用5 */
    private java.lang.String flag5;
    /** 备用4 */
    private java.lang.String flag4;
    /** 备用3 */
    private java.lang.String flag3;
    /** 备用2 */
    private java.lang.String flag2;
    /** 备用1 */
    private java.lang.String flag1;
    /** 管家介绍 */
    private java.lang.String houseIntroduce;
    /** 1：店主，2：店员 */
    private java.lang.String houseClass;
    /** 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂 */
    private java.lang.String houseCategory;
    /** 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂 */
    private java.lang.String houseCategory0;
    /** 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂 */
    private java.lang.String houseCategory1;
    /** 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂 */
    private java.lang.String houseCategory2;
    /** 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂 */
    private java.lang.String houseCategory3;
    /** 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂 */
    private java.lang.String houseCategory4;
    /** 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂 */
    private java.lang.String houseCategory5;
    /** 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂 */
    private java.lang.String houseCategory6;
    /** 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂 */
    private java.lang.String houseCategory7;
    /** 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂 */
    private java.lang.String houseCategory8;
    /**
     * <p>默认构造函数。</p>
     */
    public SlHouseAccount() {

    }

    /**
     * <p>区划(6)+顺序码(4)。</p>
     *
     * @return the 区划(6)+顺序码(4)
     */
    public java.lang.String getSlCode() {
        return slCode;
    }

    /**
     * <p>区划(6)+顺序码(4)。</p>
     *
     * @param slCode 区划(6)+顺序码(4)。
     */
    public void setSlCode(java.lang.String slCode) {
        this.slCode = slCode;
    }

    /**
     * <p>用于登录的卖家账号。</p>
     *
     * @return the 用于登录的卖家账号
     */
    public java.lang.String getHouseAccount() {
        return houseAccount;
    }

    /**
     * <p>用于登录的卖家账号。</p>
     *
     * @param houseAccount 用于登录的卖家账号。
     */
    public void setHouseAccount(java.lang.String houseAccount) {
        this.houseAccount = houseAccount;
    }

    /**
     * <p>用于登录的卖家账号。</p>
     *
     * @return the 用于登录的卖家账号
     */
    public java.lang.String getHouseCode() {
        return houseCode;
    }

    /**
     * <p>用于登录的卖家账号。</p>
     *
     * @param houseCode 用于登录的卖家账号。
     */
    public void setHouseCode(java.lang.String houseCode) {
        this.houseCode = houseCode;
    }

    /**
     * <p>用于登录的卖家账号。</p>
     *
     * @return the 用于登录的卖家账号
     */
    public java.lang.String getHouseCodeDis() {
        return houseCodeDis;
    }

    /**
     * <p>用于登录的卖家账号。</p>
     *
     * @param houseCodeDis 用于登录的卖家账号。
     */
    public void setHouseCodeDis(java.lang.String houseCodeDis) {
        this.houseCodeDis = houseCodeDis;
    }

    /**
     * <p>也可以用于登录。</p>
     *
     * @return the 也可以用于登录
     */
    public java.lang.String getHouseTel() {
        return houseTel;
    }

    /**
     * <p>也可以用于登录。</p>
     *
     * @param houseTel 也可以用于登录。
     */
    public void setHouseTel(java.lang.String houseTel) {
        this.houseTel = houseTel;
    }

    /**
     * <p>管家显示名称。</p>
     *
     * @return the 管家显示名称
     */
    public java.lang.String getHouseShowName() {
        return houseShowName;
    }

    /**
     * <p>管家显示名称。</p>
     *
     * @param houseShowName 管家显示名称。
     */
    public void setHouseShowName(java.lang.String houseShowName) {
        this.houseShowName = houseShowName;
    }

    /**
     * <p>联系人姓名。</p>
     *
     * @return the 联系人姓名
     */
    public java.lang.String getHouseContact() {
        return houseContact;
    }

    /**
     * <p>联系人姓名。</p>
     *
     * @param houseContact 联系人姓名。
     */
    public void setHouseContact(java.lang.String houseContact) {
        this.houseContact = houseContact;
    }

    /**
     * <p>加密后的值。</p>
     *
     * @return the 加密后的值
     */
    public java.lang.String getAccountPsd() {
        return accountPsd;
    }

    /**
     * <p>加密后的值。</p>
     *
     * @param accountPsd 加密后的值。
     */
    public void setAccountPsd(java.lang.String accountPsd) {
        this.accountPsd = accountPsd;
    }

    /**
     * <p>0:未认证,1:认证中,2:已认证。</p>
     *
     * @return the 0:未认证,1:认证中,2:已认证
     */
    public java.lang.Integer getAuthStatus() {
        return authStatus;
    }

    /**
     * <p>0:未认证,1:认证中,2:已认证。</p>
     *
     * @param authStatus 0:未认证,1:认证中,2:已认证。
     */
    public void setAuthStatus(java.lang.Integer authStatus) {
        this.authStatus = authStatus;
    }

    /**
     * <p>管家身份证号。</p>
     *
     * @return the 管家身份证号
     */
    public java.lang.String getSlIdcard() {
        return slIdcard;
    }

    /**
     * <p>管家身份证号。</p>
     *
     * @param slIdcard 管家身份证号。
     */
    public void setSlIdcard(java.lang.String slIdcard) {
        this.slIdcard = slIdcard;
    }

    /**
     * <p>1：国产，2：进口。</p>
     *
     * @return the 1：国产，2：进口
     */
    public java.lang.String getSlConFlg() {
        return slConFlg;
    }

    /**
     * <p>1：国产，2：进口。</p>
     *
     * @param slConFlg 1：国产，2：进口。
     */
    public void setSlConFlg(java.lang.String slConFlg) {
        this.slConFlg = slConFlg;
    }

    /**
     * <p>大区。</p>
     *
     * @return the 大区
     */
    public java.lang.String getAreaCode() {
        return areaCode;
    }

    /**
     * <p>大区。</p>
     *
     * @param areaCode 大区。
     */
    public void setAreaCode(java.lang.String areaCode) {
        this.areaCode = areaCode;
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
     * <p>地区编码。</p>
     *
     * @return the 地区编码
     */
    public java.lang.String getCityCode() {
        return cityCode;
    }

    /**
     * <p>地区编码。</p>
     *
     * @param cityCode 地区编码。
     */
    public void setCityCode(java.lang.String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * <p>区编码。</p>
     *
     * @return the 区编码
     */
    public java.lang.String getDistrictCode() {
        return districtCode;
    }

    /**
     * <p>区编码。</p>
     *
     * @param districtCode 区编码。
     */
    public void setDistrictCode(java.lang.String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * <p>管家地址。</p>
     *
     * @return the 管家地址
     */
    public java.lang.String getHouseAddress() {
        return houseAddress;
    }

    /**
     * <p>管家地址。</p>
     *
     * @param houseAddress 管家地址。
     */
    public void setHouseAddress(java.lang.String houseAddress) {
        this.houseAddress = houseAddress;
    }

    /**
     * <p>大区。</p>
     *
     * @return the 大区
     */
    public java.lang.String getVareaCode() {
        return vareaCode;
    }

    /**
     * <p>大区。</p>
     *
     * @param vareaCode 大区。
     */
    public void setVareaCode(java.lang.String vareaCode) {
        this.vareaCode = vareaCode;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @return the 物流区编码
     */
    public java.lang.String getVlgcsAreaCode() {
        return vlgcsAreaCode;
    }

    /**
     * <p>物流区编码。</p>
     *
     * @param vlgcsAreaCode 物流区编码。
     */
    public void setVlgcsAreaCode(java.lang.String vlgcsAreaCode) {
        this.vlgcsAreaCode = vlgcsAreaCode;
    }

    /**
     * <p>省编码。</p>
     *
     * @return the 省编码
     */
    public java.lang.String getVprovinceCode() {
        return vprovinceCode;
    }

    /**
     * <p>省编码。</p>
     *
     * @param vprovinceCode 省编码。
     */
    public void setVprovinceCode(java.lang.String vprovinceCode) {
        this.vprovinceCode = vprovinceCode;
    }

    /**
     * <p>地区编码。</p>
     *
     * @return the 地区编码
     */
    public java.lang.String getVcityCode() {
        return vcityCode;
    }

    /**
     * <p>地区编码。</p>
     *
     * @param vcityCode 地区编码。
     */
    public void setVcityCode(java.lang.String vcityCode) {
        this.vcityCode = vcityCode;
    }

    /**
     * <p>区编码。</p>
     *
     * @return the 区编码
     */
    public java.lang.String getVdistrictCode() {
        return vdistrictCode;
    }

    /**
     * <p>区编码。</p>
     *
     * @param vdistrictCode 区编码。
     */
    public void setVdistrictCode(java.lang.String vdistrictCode) {
        this.vdistrictCode = vdistrictCode;
    }

    /**
     * <p>虚拟管家地址。</p>
     *
     * @return the 虚拟管家地址
     */
    public java.lang.String getVhouseAddress() {
        return vhouseAddress;
    }

    /**
     * <p>虚拟管家地址。</p>
     *
     * @param vhouseAddress 虚拟管家地址。
     */
    public void setVhouseAddress(java.lang.String vhouseAddress) {
        this.vhouseAddress = vhouseAddress;
    }

    /**
     * <p>维度。</p>
     *
     * @return the 维度
     */
    public java.lang.String getLat() {
        return lat;
    }

    /**
     * <p>维度。</p>
     *
     * @param lat 维度。
     */
    public void setLat(java.lang.String lat) {
        this.lat = lat;
    }

    /**
     * <p>精度。</p>
     *
     * @return the 精度
     */
    public java.lang.String getLon() {
        return lon;
    }

    /**
     * <p>精度。</p>
     *
     * @param lon 精度。
     */
    public void setLon(java.lang.String lon) {
        this.lon = lon;
    }

    /**
     * <p>虚拟地址维度。</p>
     *
     * @return the 虚拟地址维度
     */
    public java.lang.String getVlat() {
        return vlat;
    }

    /**
     * <p>虚拟地址维度。</p>
     *
     * @param vlat 虚拟地址维度。
     */
    public void setVlat(java.lang.String vlat) {
        this.vlat = vlat;
    }

    /**
     * <p>虚拟地址精度。</p>
     *
     * @return the 虚拟地址精度
     */
    public java.lang.String getVlon() {
        return vlon;
    }

    /**
     * <p>虚拟地址精度。</p>
     *
     * @param vlon 虚拟地址精度。
     */
    public void setVlon(java.lang.String vlon) {
        this.vlon = vlon;
    }

    /**
     * <p>1:专业冻品管家资格未申请 2:专业冻品管家资格申请中。</p>
     *
     * @return the 1:专业冻品管家资格未申请 2:专业冻品管家资格申请中
     */
    public java.lang.String getLicenses() {
        return licenses;
    }

    /**
     * <p>1:专业冻品管家资格未申请 2:专业冻品管家资格申请中。</p>
     *
     * @param licenses 1:专业冻品管家资格未申请 2:专业冻品管家资格申请中。
     */
    public void setLicenses(java.lang.String licenses) {
        this.licenses = licenses;
    }

    /**
     * <p>买手签署。</p>
     *
     * @return the 买手签署
     */
    public java.lang.String getBuyerAsign() {
        return buyerAsign;
    }

    /**
     * <p>买手签署。</p>
     *
     * @param buyerAsign 买手签署。
     */
    public void setBuyerAsign(java.lang.String buyerAsign) {
        this.buyerAsign = buyerAsign;
    }

    /**
     * <p>微信号码。</p>
     *
     * @return the 微信号码
     */
    public java.lang.String getWechat() {
        return wechat;
    }

    /**
     * <p>微信号码。</p>
     *
     * @param wechat 微信号码。
     */
    public void setWechat(java.lang.String wechat) {
        this.wechat = wechat;
    }

    /**
     * <p>QQ号码。</p>
     *
     * @return the QQ号码
     */
    public java.lang.String getQq() {
        return qq;
    }

    /**
     * <p>QQ号码。</p>
     *
     * @param qq QQ号码。
     */
    public void setQq(java.lang.String qq) {
        this.qq = qq;
    }

    /**
     * <p>邮箱。</p>
     *
     * @return the 邮箱
     */
    public java.lang.String getEmail() {
        return email;
    }

    /**
     * <p>邮箱。</p>
     *
     * @param email 邮箱。
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    /**
     * <p>1:行业型	2:创业型	3:关系型	4:配送型。</p>
     *
     * @return the 1:行业型	2:创业型	3:关系型	4:配送型
     */
    public java.lang.String getFixedTel() {
        return fixedTel;
    }

    /**
     * <p>1:行业型	2:创业型	3:关系型	4:配送型。</p>
     *
     * @param fixedTel 1:行业型	2:创业型	3:关系型	4:配送型。
     */
    public void setFixedTel(java.lang.String fixedTel) {
        this.fixedTel = fixedTel;
    }

    /**
     * <p>传真号。</p>
     *
     * @return the 传真号
     */
    public java.lang.String getFax() {
        return fax;
    }

    /**
     * <p>传真号。</p>
     *
     * @param fax 传真号。
     */
    public void setFax(java.lang.String fax) {
        this.fax = fax;
    }

    /**
     * <p>备用20。</p>
     *
     * @return the 备用20
     */
    public java.lang.String getFlag20() {
        return flag20;
    }

    /**
     * <p>备用20。</p>
     *
     * @param flag20 备用20。
     */
    public void setFlag20(java.lang.String flag20) {
        this.flag20 = flag20;
    }

    /**
     * <p>备用19。</p>
     *
     * @return the 备用19
     */
    public java.lang.String getFlag19() {
        return flag19;
    }

    /**
     * <p>备用19。</p>
     *
     * @param flag19 备用19。
     */
    public void setFlag19(java.lang.String flag19) {
        this.flag19 = flag19;
    }

    /**
     * <p>备用18。</p>
     *
     * @return the 备用18
     */
    public java.lang.String getFlag18() {
        return flag18;
    }

    /**
     * <p>备用18。</p>
     *
     * @param flag18 备用18。
     */
    public void setFlag18(java.lang.String flag18) {
        this.flag18 = flag18;
    }

    /**
     * <p>备用17。</p>
     *
     * @return the 备用17
     */
    public java.lang.String getFlag17() {
        return flag17;
    }

    /**
     * <p>备用17。</p>
     *
     * @param flag17 备用17。
     */
    public void setFlag17(java.lang.String flag17) {
        this.flag17 = flag17;
    }

    /**
     * <p>备用16。</p>
     *
     * @return the 备用16
     */
    public java.lang.String getFlag16() {
        return flag16;
    }

    /**
     * <p>备用16。</p>
     *
     * @param flag16 备用16。
     */
    public void setFlag16(java.lang.String flag16) {
        this.flag16 = flag16;
    }

    /**
     * <p>备用15。</p>
     *
     * @return the 备用15
     */
    public java.lang.String getFlag15() {
        return flag15;
    }

    /**
     * <p>备用15。</p>
     *
     * @param flag15 备用15。
     */
    public void setFlag15(java.lang.String flag15) {
        this.flag15 = flag15;
    }

    /**
     * <p>备用14。</p>
     *
     * @return the 备用14
     */
    public java.lang.String getFlag14() {
        return flag14;
    }

    /**
     * <p>备用14。</p>
     *
     * @param flag14 备用14。
     */
    public void setFlag14(java.lang.String flag14) {
        this.flag14 = flag14;
    }

    /**
     * <p>备用13。</p>
     *
     * @return the 备用13
     */
    public java.lang.String getFlag13() {
        return flag13;
    }

    /**
     * <p>备用13。</p>
     *
     * @param flag13 备用13。
     */
    public void setFlag13(java.lang.String flag13) {
        this.flag13 = flag13;
    }

    /**
     * <p>备用12。</p>
     *
     * @return the 备用12
     */
    public java.lang.String getFlag12() {
        return flag12;
    }

    /**
     * <p>备用12。</p>
     *
     * @param flag12 备用12。
     */
    public void setFlag12(java.lang.String flag12) {
        this.flag12 = flag12;
    }

    /**
     * <p>备用11。</p>
     *
     * @return the 备用11
     */
    public java.lang.String getFlag11() {
        return flag11;
    }

    /**
     * <p>备用11。</p>
     *
     * @param flag11 备用11。
     */
    public void setFlag11(java.lang.String flag11) {
        this.flag11 = flag11;
    }

    /**
     * <p>备用10。</p>
     *
     * @return the 备用10
     */
    public java.lang.String getFlag10() {
        return flag10;
    }

    /**
     * <p>备用10。</p>
     *
     * @param flag10 备用10。
     */
    public void setFlag10(java.lang.String flag10) {
        this.flag10 = flag10;
    }

    /**
     * <p>备用9。</p>
     *
     * @return the 备用9
     */
    public java.lang.String getFlag9() {
        return flag9;
    }

    /**
     * <p>备用9。</p>
     *
     * @param flag9 备用9。
     */
    public void setFlag9(java.lang.String flag9) {
        this.flag9 = flag9;
    }

    /**
     * <p>备用8。</p>
     *
     * @return the 备用8
     */
    public java.lang.String getFlag8() {
        return flag8;
    }

    /**
     * <p>备用8。</p>
     *
     * @param flag8 备用8。
     */
    public void setFlag8(java.lang.String flag8) {
        this.flag8 = flag8;
    }

    /**
     * <p>备用7。</p>
     *
     * @return the 备用7
     */
    public java.lang.String getFlag7() {
        return flag7;
    }

    /**
     * <p>备用7。</p>
     *
     * @param flag7 备用7。
     */
    public void setFlag7(java.lang.String flag7) {
        this.flag7 = flag7;
    }

    /**
     * <p>备用6。</p>
     *
     * @return the 备用6
     */
    public java.lang.String getFlag6() {
        return flag6;
    }

    /**
     * <p>备用6。</p>
     *
     * @param flag6 备用6。
     */
    public void setFlag6(java.lang.String flag6) {
        this.flag6 = flag6;
    }

    /**
     * <p>备用5。</p>
     *
     * @return the 备用5
     */
    public java.lang.String getFlag5() {
        return flag5;
    }

    /**
     * <p>备用5。</p>
     *
     * @param flag5 备用5。
     */
    public void setFlag5(java.lang.String flag5) {
        this.flag5 = flag5;
    }

    /**
     * <p>备用4。</p>
     *
     * @return the 备用4
     */
    public java.lang.String getFlag4() {
        return flag4;
    }

    /**
     * <p>备用4。</p>
     *
     * @param flag4 备用4。
     */
    public void setFlag4(java.lang.String flag4) {
        this.flag4 = flag4;
    }

    /**
     * <p>备用3。</p>
     *
     * @return the 备用3
     */
    public java.lang.String getFlag3() {
        return flag3;
    }

    /**
     * <p>备用3。</p>
     *
     * @param flag3 备用3。
     */
    public void setFlag3(java.lang.String flag3) {
        this.flag3 = flag3;
    }

    /**
     * <p>备用2。</p>
     *
     * @return the 备用2
     */
    public java.lang.String getFlag2() {
        return flag2;
    }

    /**
     * <p>备用2。</p>
     *
     * @param flag2 备用2。
     */
    public void setFlag2(java.lang.String flag2) {
        this.flag2 = flag2;
    }

    /**
     * <p>备用1。</p>
     *
     * @return the 备用1
     */
    public java.lang.String getFlag1() {
        return flag1;
    }

    /**
     * <p>备用1。</p>
     *
     * @param flag1 备用1。
     */
    public void setFlag1(java.lang.String flag1) {
        this.flag1 = flag1;
    }

    /**
     * <p>管家介绍。</p>
     *
     * @return the 管家介绍
     */
    public java.lang.String getHouseIntroduce() {
        return houseIntroduce;
    }

    /**
     * <p>管家介绍。</p>
     *
     * @param houseIntroduce 管家介绍。
     */
    public void setHouseIntroduce(java.lang.String houseIntroduce) {
        this.houseIntroduce = houseIntroduce;
    }

    /**
     * <p>1：店主，2：店员。</p>
     *
     * @return the 1：店主，2：店员
     */
    public java.lang.String getHouseClass() {
        return houseClass;
    }

    /**
     * <p>1：店主，2：店员。</p>
     *
     * @param houseClass 1：店主，2：店员。
     */
    public void setHouseClass(java.lang.String houseClass) {
        this.houseClass = houseClass;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @return the 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂
     */
    public java.lang.String getHouseCategory() {
        return houseCategory;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @param houseCategory 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。
     */
    public void setHouseCategory(java.lang.String houseCategory) {
        this.houseCategory = houseCategory;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @return the 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂
     */
    public java.lang.String getHouseCategory0() {
        return houseCategory0;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @param houseCategory0 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。
     */
    public void setHouseCategory0(java.lang.String houseCategory0) {
        this.houseCategory0 = houseCategory0;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @return the 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂
     */
    public java.lang.String getHouseCategory1() {
        return houseCategory1;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @param houseCategory1 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。
     */
    public void setHouseCategory1(java.lang.String houseCategory1) {
        this.houseCategory1 = houseCategory1;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @return the 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂
     */
    public java.lang.String getHouseCategory2() {
        return houseCategory2;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @param houseCategory2 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。
     */
    public void setHouseCategory2(java.lang.String houseCategory2) {
        this.houseCategory2 = houseCategory2;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @return the 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂
     */
    public java.lang.String getHouseCategory3() {
        return houseCategory3;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @param houseCategory3 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。
     */
    public void setHouseCategory3(java.lang.String houseCategory3) {
        this.houseCategory3 = houseCategory3;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @return the 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂
     */
    public java.lang.String getHouseCategory4() {
        return houseCategory4;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @param houseCategory4 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。
     */
    public void setHouseCategory4(java.lang.String houseCategory4) {
        this.houseCategory4 = houseCategory4;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @return the 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂
     */
    public java.lang.String getHouseCategory5() {
        return houseCategory5;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @param houseCategory5 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。
     */
    public void setHouseCategory5(java.lang.String houseCategory5) {
        this.houseCategory5 = houseCategory5;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @return the 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂
     */
    public java.lang.String getHouseCategory6() {
        return houseCategory6;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @param houseCategory6 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。
     */
    public void setHouseCategory6(java.lang.String houseCategory6) {
        this.houseCategory6 = houseCategory6;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @return the 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂
     */
    public java.lang.String getHouseCategory7() {
        return houseCategory7;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @param houseCategory7 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。
     */
    public void setHouseCategory7(java.lang.String houseCategory7) {
        this.houseCategory7 = houseCategory7;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @return the 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂
     */
    public java.lang.String getHouseCategory8() {
        return houseCategory8;
    }

    /**
     * <p>0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。</p>
     *
     * @param houseCategory8 0基本冻品管家 1分销	2菜场	3团膳	4火锅	5中餐	6西餐	7小吃烧烤	8加工厂。
     */
    public void setHouseCategory8(java.lang.String houseCategory8) {
        this.houseCategory8 = houseCategory8;
    }

}
