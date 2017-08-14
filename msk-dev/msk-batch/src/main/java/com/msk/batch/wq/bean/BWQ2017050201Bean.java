package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.msk.batch.wq.entity.WqOrder;

/**
 * Created by Administrator on 2017/2/13 0013.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BWQ2017050201Bean extends WqOrder {

    @JsonProperty("id")
    private String id;
    @JsonProperty("source_code")
    private String sourceCode;
    @JsonProperty("creator_id")
    private String creatorId;
    /** 订单编码**/
    @JsonProperty("slfdf_1701180002")
    private String slfdf1701180002;
    /** 订单创建时间**/
    @JsonProperty("slfdf_1701180004")
    private String slfdf1701180004;
    /** 买家编码**/
    @JsonProperty("slfdf_1701180005")
    private String slfdf1701180005;
    /** 买家（买家ID）**/
    @JsonProperty("slfdf_1701180006")
    private String slfdf1701180006;
    /** 买家名称**/
    @JsonProperty("slfdf_1701180006_name")
    private String slfdf1701180006Name;
    /** 上传id**/
    @JsonProperty("slfdf_1701180006_sourcecode")
    private String slfdf1701180006Sourcecode;
    /** 卖家编码**/
    @JsonProperty("slfdf_1701180007")
    private String slfdf1701180007;
    /** 卖家名称**/
    @JsonProperty("slfdf_1701180008")
    private String slfdf1701180008;
    /** 订单状态**/
    @JsonProperty("slfdf_1701180009")
    private String slfdf1701180009;
    /** 订单总金额**/
    @JsonProperty("slfdf_1701180010")
    private String slfdf1701180010;
    /** 订单类型**/
    @JsonProperty("slfdf_1701180011")
    private String slfdf1701180011;
    /** 订单区域**/
    @JsonProperty("slfdf_1701180012")
    private String slfdf1701180012;
    /** 付款类型**/
    @JsonProperty("slfdf_1701180013")
    private String slfdf1701180013;
    /** 已支付金额**/
    @JsonProperty("slfdf_1701180014")
    private String slfdf1701180014;
    /** 支付时间**/
    @JsonProperty("slfdf_1701180015")
    private String slfdf1701180015;
    /** 收货人名称**/
    @JsonProperty("slfdf_1701180016")
    private String slfdf1701180016;
    /** 收货人电话**/
    @JsonProperty("slfdf_1701180017")
    private String slfdf1701180017;
    /** 收货地址省份**/
    @JsonProperty("slfdf_1701180018")
    private String slfdf1701180018;
    /** 收货地址市**/
    @JsonProperty("slfdf_1701180019")
    private String slfdf1701180019;
    /** 收货地址区**/
    @JsonProperty("slfdf_1701180020")
    private String slfdf1701180020;
    /** 收货人详细地址**/
    @JsonProperty("slfdf_1701180021")
    private String slfdf1701180021;
    /** 习惯正常收货时间段**/
    @JsonProperty("slfdf_1701180022")
    private String slfdf1701180022;
    /** 习惯收货最早时间要求**/
    @JsonProperty("slfdf_1701180023")
    private String slfdf1701180023;
    /** 习惯收货最晚时间要求**/
    @JsonProperty("slfdf_1701180024")
    private String slfdf1701180024;
    /** 备注1**/
    @JsonProperty("slfdf_1701190001")
    private String slfdf1701190001;
    /** 备注2**/
    @JsonProperty("slfdf_1701190002")
    private String slfdf1701190002;
    /** 备注3**/
    @JsonProperty("slfdf_1701190003")
    private String slfdf1701190003;
    /** 备注4**/
    @JsonProperty("slfdf_1701190004")
    private String slfdf1701190004;
    /** 备注5**/
    @JsonProperty("slfdf_1701190005")
    private String slfdf1701190005;
    /** 备注6**/
    @JsonProperty("slfdf_1701190006")
    private String slfdf1701190006;
    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getSlfdf1701180002() {
        return slfdf1701180002;
    }

    public void setSlfdf1701180002(String slfdf1701180002) {
        this.slfdf1701180002 = slfdf1701180002;
    }

    public String getSlfdf1701180004() {
        return slfdf1701180004;
    }

    public void setSlfdf1701180004(String slfdf1701180004) {
        this.slfdf1701180004 = slfdf1701180004;
    }

    public String getSlfdf1701180005() {
        return slfdf1701180005;
    }

    public void setSlfdf1701180005(String slfdf1701180005) {
        this.slfdf1701180005 = slfdf1701180005;
    }

    public String getSlfdf1701180006() {
        return slfdf1701180006;
    }

    public void setSlfdf1701180006(String slfdf1701180006) {
        this.slfdf1701180006 = slfdf1701180006;
    }

    public String getSlfdf1701180007() {
        return slfdf1701180007;
    }

    public void setSlfdf1701180007(String slfdf1701180007) {
        this.slfdf1701180007 = slfdf1701180007;
    }

    public String getSlfdf1701180008() {
        return slfdf1701180008;
    }

    public void setSlfdf1701180008(String slfdf1701180008) {
        this.slfdf1701180008 = slfdf1701180008;
    }

    public String getSlfdf1701180009() {
        return slfdf1701180009;
    }

    public void setSlfdf1701180009(String slfdf1701180009) {
        this.slfdf1701180009 = slfdf1701180009;
    }

    public String getSlfdf1701180010() {
        return slfdf1701180010;
    }

    public void setSlfdf1701180010(String slfdf1701180010) {
        this.slfdf1701180010 = slfdf1701180010;
    }

    public String getSlfdf1701180011() {
        return slfdf1701180011;
    }

    public void setSlfdf1701180011(String slfdf1701180011) {
        this.slfdf1701180011 = slfdf1701180011;
    }

    public String getSlfdf1701180012() {
        return slfdf1701180012;
    }

    public void setSlfdf1701180012(String slfdf1701180012) {
        this.slfdf1701180012 = slfdf1701180012;
    }

    public String getSlfdf1701180013() {
        return slfdf1701180013;
    }

    public void setSlfdf1701180013(String slfdf1701180013) {
        this.slfdf1701180013 = slfdf1701180013;
    }

    public String getSlfdf1701180014() {
        return slfdf1701180014;
    }

    public void setSlfdf1701180014(String slfdf1701180014) {
        this.slfdf1701180014 = slfdf1701180014;
    }

    public String getSlfdf1701180015() {
        return slfdf1701180015;
    }

    public void setSlfdf1701180015(String slfdf1701180015) {
        this.slfdf1701180015 = slfdf1701180015;
    }

    public String getSlfdf1701180016() {
        return slfdf1701180016;
    }

    public void setSlfdf1701180016(String slfdf1701180016) {
        this.slfdf1701180016 = slfdf1701180016;
    }

    public String getSlfdf1701180017() {
        return slfdf1701180017;
    }

    public void setSlfdf1701180017(String slfdf1701180017) {
        this.slfdf1701180017 = slfdf1701180017;
    }

    public String getSlfdf1701180018() {
        return slfdf1701180018;
    }

    public void setSlfdf1701180018(String slfdf1701180018) {
        this.slfdf1701180018 = slfdf1701180018;
    }

    public String getSlfdf1701180019() {
        return slfdf1701180019;
    }

    public void setSlfdf1701180019(String slfdf1701180019) {
        this.slfdf1701180019 = slfdf1701180019;
    }

    public String getSlfdf1701180020() {
        return slfdf1701180020;
    }

    public void setSlfdf1701180020(String slfdf1701180020) {
        this.slfdf1701180020 = slfdf1701180020;
    }

    public String getSlfdf1701180021() {
        return slfdf1701180021;
    }

    public void setSlfdf1701180021(String slfdf1701180021) {
        this.slfdf1701180021 = slfdf1701180021;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlfdf1701180022() {
        return slfdf1701180022;
    }

    public void setSlfdf1701180022(String slfdf1701180022) {
        this.slfdf1701180022 = slfdf1701180022;
    }

    public String getSlfdf1701180023() {
        return slfdf1701180023;
    }

    public void setSlfdf1701180023(String slfdf1701180023) {
        this.slfdf1701180023 = slfdf1701180023;
    }

    public String getSlfdf1701180024() {
        return slfdf1701180024;
    }

    public void setSlfdf1701180024(String slfdf1701180024) {
        this.slfdf1701180024 = slfdf1701180024;
    }

    public String getSlfdf1701190001() {
        return slfdf1701190001;
    }

    public void setSlfdf1701190001(String slfdf1701190001) {
        this.slfdf1701190001 = slfdf1701190001;
    }

    public String getSlfdf1701190002() {
        return slfdf1701190002;
    }

    public void setSlfdf1701190002(String slfdf1701190002) {
        this.slfdf1701190002 = slfdf1701190002;
    }

    public String getSlfdf1701190003() {
        return slfdf1701190003;
    }

    public void setSlfdf1701190003(String slfdf1701190003) {
        this.slfdf1701190003 = slfdf1701190003;
    }

    public String getSlfdf1701190004() {
        return slfdf1701190004;
    }

    public void setSlfdf1701190004(String slfdf1701190004) {
        this.slfdf1701190004 = slfdf1701190004;
    }

    public String getSlfdf1701190005() {
        return slfdf1701190005;
    }

    public void setSlfdf1701190005(String slfdf1701190005) {
        this.slfdf1701190005 = slfdf1701190005;
    }

    public String getSlfdf1701190006() {
        return slfdf1701190006;
    }

    public void setSlfdf1701190006(String slfdf1701190006) {
        this.slfdf1701190006 = slfdf1701190006;
    }

    public String getSlfdf1701180006Name() {
        return slfdf1701180006Name;
    }

    public void setSlfdf1701180006Name(String slfdf1701180006Name) {
        this.slfdf1701180006Name = slfdf1701180006Name;
    }

    public String getSlfdf1701180006Sourcecode() {
        return slfdf1701180006Sourcecode;
    }

    public void setSlfdf1701180006Sourcecode(String slfdf1701180006Sourcecode) {
        this.slfdf1701180006Sourcecode = slfdf1701180006Sourcecode;
    }
}
