package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.msk.batch.wq.entity.WqOrderProduct;

/**
 * Created by Administrator on 2017/2/13 0013.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BWQ201705020201Bean extends WqOrderProduct{

    @JsonProperty("id")
    private String id;
    @JsonProperty("source_code")
    private String sourceCode;
    /** 产品编码**/
    @JsonProperty("slfdf_1701180025")
    private String slfdf1701180025;
    /** 产品名称**/
    @JsonProperty("slfdf_1701180026")
    private String slfdf1701180026;
    /** 产品价格**/
    @JsonProperty("slfdf_1701180027")
    private String slfdf1701180027;
    /** 订购数量**/
    @JsonProperty("slfdf_1701180028")
    private String slfdf1701180028;
    /** 产品编码2**/
    private String slfdf1701180029;
    /** 产品名称2**/
    private String slfdf1701180030;
    /** 产品价格2**/
    private String slfdf1701180031;
    /** 订购数量2**/
    private String slfdf1701180032;
    private String childOrderCode;
    private String childOrderId;
    private String mainOrderId;
    private String mainOrderCode;

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getSlfdf1701180025() {
        return slfdf1701180025;
    }

    public void setSlfdf1701180025(String slfdf1701180025) {
        this.slfdf1701180025 = slfdf1701180025;
    }

    public String getSlfdf1701180026() {
        return slfdf1701180026;
    }

    public void setSlfdf1701180026(String slfdf1701180026) {
        this.slfdf1701180026 = slfdf1701180026;
    }

    public String getSlfdf1701180027() {
        return slfdf1701180027;
    }

    public void setSlfdf1701180027(String slfdf1701180027) {
        this.slfdf1701180027 = slfdf1701180027;
    }

    public String getSlfdf1701180028() {
        return slfdf1701180028;
    }

    public void setSlfdf1701180028(String slfdf1701180028) {
        this.slfdf1701180028 = slfdf1701180028;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlfdf1701180029() {
        return slfdf1701180029;
    }

    public void setSlfdf1701180029(String slfdf1701180029) {
        this.slfdf1701180029 = slfdf1701180029;
    }

    public String getSlfdf1701180030() {
        return slfdf1701180030;
    }

    public void setSlfdf1701180030(String slfdf1701180030) {
        this.slfdf1701180030 = slfdf1701180030;
    }

    public String getSlfdf1701180031() {
        return slfdf1701180031;
    }

    public void setSlfdf1701180031(String slfdf1701180031) {
        this.slfdf1701180031 = slfdf1701180031;
    }

    public String getSlfdf1701180032() {
        return slfdf1701180032;
    }

    public void setSlfdf1701180032(String slfdf1701180032) {
        this.slfdf1701180032 = slfdf1701180032;
    }

    public String getChildOrderCode() {
        return childOrderCode;
    }

    public void setChildOrderCode(String childOrderCode) {
        this.childOrderCode = childOrderCode;
    }

    public String getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(String childOrderId) {
        this.childOrderId = childOrderId;
    }

    public String getMainOrderId() {
        return mainOrderId;
    }

    public void setMainOrderId(String mainOrderId) {
        this.mainOrderId = mainOrderId;
    }

    public String getMainOrderCode() {
        return mainOrderCode;
    }

    public void setMainOrderCode(String mainOrderCode) {
        this.mainOrderCode = mainOrderCode;
    }
}
