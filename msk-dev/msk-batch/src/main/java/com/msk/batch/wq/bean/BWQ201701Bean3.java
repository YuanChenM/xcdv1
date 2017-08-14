package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.msk.core.bean.BaseBean;

import java.util.List;

/**
 * Created by air on 2017/1/10.
 */
public class BWQ201701Bean3 extends WqRequest{

    public Integer getTbl_id() {
        return tbl_id;
    }

    public void setTbl_id(Integer tbl_id) {
        this.tbl_id = tbl_id;
    }

    private Integer  tbl_id;
    private String  cm_id;
    private String  cm_name;
    private String  cm_code;
    private String  cm_manager;
    private String  cm_manager_id;
    private String  cm_type;
    private String  cm_type_code;
    private String  cm_district;
    private String  cm_mss_province;
    private String  cm_mss_city;
    private String  cm_mss_area;
    private String  cm_addr;
    private String  cm_delivery_addr;
    private String  cm_cooperate_status;
    private String  cm_uper_customer;
    private String  cm_source;
    private String  cm_trade;
    private String  cm_scale;
    private String  cm_tel;
    private String  cm_fax;
    private String  cm_post;
    private String  cm_remarks;
    private String id;
    private List<BWQ20170101Result> exts;
    /** 客户联系人名称 **/
    @JsonProperty("cm_linkman_name")
    private String  cmLinkmanName;
    /** 客户联系人手机 **/
    @JsonProperty("cm_linkman_mobile")
    private String  cmLinkmanMobile;
    /** 客户联系人固定电话 **/
    @JsonProperty("cm_linkman_office_tel")
    private String  cmLinkmanOfficeTel;
    @Override
    public String toString() {
        return "BWQ201701Bean3{" +
                "cm_id='" + cm_id + '\'' +
                ", cm_name='" + cm_name + '\'' +
                ", cm_code='" + cm_code + '\'' +
                ", cm_type='" + cm_type + '\'' +
                ", cm_type_code='" + cm_type_code + '\'' +
                ", cm_district='" + cm_district + '\'' +
                ", cm_mss_province='" + cm_mss_province + '\'' +
                ", cm_mss_city='" + cm_mss_city + '\'' +
                ", cm_mss_area='" + cm_mss_area + '\'' +
                ", cm_addr='" + cm_addr + '\'' +
                ", cm_delivery_addr='" + cm_delivery_addr + '\'' +
                ", cm_cooperate_status='" + cm_cooperate_status + '\'' +
                ", cm_uper_customer='" + cm_uper_customer + '\'' +
                ", cm_source='" + cm_source + '\'' +
                ", cm_trade='" + cm_trade + '\'' +
                ", cm_scale='" + cm_scale + '\'' +
                ", cm_tel='" + cm_tel + '\'' +
                ", cm_fax='" + cm_fax + '\'' +
                ", cm_post='" + cm_post + '\'' +
                ", cm_remarks='" + cm_remarks + '\'' +
                ", cm_manager='" + cm_manager + '\'' +
                ", cm_manager_id='" + cm_manager_id + '\'' +
                ", return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                '}';
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    private String  return_code;
    private String  return_msg;

    public String getCm_id() {
        return cm_id;
    }

    public void setCm_id(String cm_id) {
        this.cm_id = cm_id;
    }

    public String getCm_name() {
        return cm_name;
    }

    public void setCm_name(String cm_name) {
        this.cm_name = cm_name;
    }

    public String getCm_code() {
        return cm_code;
    }

    public void setCm_code(String cm_code) {
        this.cm_code = cm_code;
    }

    public String getCm_type() {
        return cm_type;
    }

    public void setCm_type(String cm_type) {
        this.cm_type = cm_type;
    }

    public String getCm_type_code() {
        return cm_type_code;
    }

    public void setCm_type_code(String cm_type_code) {
        this.cm_type_code = cm_type_code;
    }

    public String getCm_district() {
        return cm_district;
    }

    public void setCm_district(String cm_district) {
        this.cm_district = cm_district;
    }

    public String getCm_mss_province() {
        return cm_mss_province;
    }

    public void setCm_mss_province(String cm_mss_province) {
        this.cm_mss_province = cm_mss_province;
    }

    public String getCm_mss_city() {
        return cm_mss_city;
    }

    public void setCm_mss_city(String cm_mss_city) {
        this.cm_mss_city = cm_mss_city;
    }

    public String getCm_mss_area() {
        return cm_mss_area;
    }

    public void setCm_mss_area(String cm_mss_area) {
        this.cm_mss_area = cm_mss_area;
    }

    public String getCm_addr() {
        return cm_addr;
    }

    public void setCm_addr(String cm_addr) {
        this.cm_addr = cm_addr;
    }

    public String getCm_delivery_addr() {
        return cm_delivery_addr;
    }

    public void setCm_delivery_addr(String cm_delivery_addr) {
        this.cm_delivery_addr = cm_delivery_addr;
    }

    public String getCm_cooperate_status() {
        return cm_cooperate_status;
    }

    public void setCm_cooperate_status(String cm_cooperate_status) {
        this.cm_cooperate_status = cm_cooperate_status;
    }

    public String getCm_uper_customer() {
        return cm_uper_customer;
    }

    public void setCm_uper_customer(String cm_uper_customer) {
        this.cm_uper_customer = cm_uper_customer;
    }

    public String getCm_source() {
        return cm_source;
    }

    public void setCm_source(String cm_source) {
        this.cm_source = cm_source;
    }

    public String getCm_trade() {
        return cm_trade;
    }

    public void setCm_trade(String cm_trade) {
        this.cm_trade = cm_trade;
    }

    public String getCm_scale() {
        return cm_scale;
    }

    public void setCm_scale(String cm_scale) {
        this.cm_scale = cm_scale;
    }

    public String getCm_tel() {
        return cm_tel;
    }

    public void setCm_tel(String cm_tel) {
        this.cm_tel = cm_tel;
    }

    public String getCm_fax() {
        return cm_fax;
    }

    public void setCm_fax(String cm_fax) {
        this.cm_fax = cm_fax;
    }

    public String getCm_post() {
        return cm_post;
    }

    public void setCm_post(String cm_post) {
        this.cm_post = cm_post;
    }

    public String getCm_remarks() {
        return cm_remarks;
    }

    public void setCm_remarks(String cm_remarks) {
        this.cm_remarks = cm_remarks;
    }

    public String getCm_manager() {
        return cm_manager;
    }

    public void setCm_manager(String cm_manager) {
        this.cm_manager = cm_manager;
    }

    public String getCm_manager_id() {
        return cm_manager_id;
    }

    public void setCm_manager_id(String cm_manager_id) {
        this.cm_manager_id = cm_manager_id;
    }

    public String getCmLinkmanName() {
        return cmLinkmanName;
    }

    public void setCmLinkmanName(String cmLinkmanName) {
        this.cmLinkmanName = cmLinkmanName;
    }

    public String getCmLinkmanMobile() {
        return cmLinkmanMobile;
    }

    public void setCmLinkmanMobile(String cmLinkmanMobile) {
        this.cmLinkmanMobile = cmLinkmanMobile;
    }

    public String getCmLinkmanOfficeTel() {
        return cmLinkmanOfficeTel;
    }

    public void setCmLinkmanOfficeTel(String cmLinkmanOfficeTel) {
        this.cmLinkmanOfficeTel = cmLinkmanOfficeTel;
    }

    public List<BWQ20170101Result> getExts() {
        return exts;
    }

    public void setExts(List<BWQ20170101Result> exts) {
        this.exts = exts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
