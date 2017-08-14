package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.msk.batch.wq.entity.SlBsAccount;
import com.msk.batch.wq.entity.SlBsBasicInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/1/10 0010.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value={"lgcsAreaCode","lgcsAreaName","provinceCode","provinceName","cityCode","cityName","districtCode","districtName","memo5","memo6","fromFlg"})
public class SlBsAccountParam extends SlBsBasicInfo{
    /** ID */
    private String id;
    /** 账号ID */
    @JsonProperty("emp_id")
    private String empId;
    /** 账号 */
    @JsonProperty("emp_code")
    private String empCode;
    /** 密码 */
    @JsonProperty("emp_password")
    private String empPassword;
    /** 名称 */
    @JsonProperty("emp_name")
    private String empName;
    /** 电话 */
    @JsonProperty("emp_mobile")
    private String empMobile;
    /** 固定电话 */
    @JsonProperty("emp_tel")
    private String empTel;
    /** 身份证 */
    @JsonProperty("emp_idcard")
    private String empIdcard;
    /** 邮箱 */
    @JsonProperty("emp_email")
    private String empEmail;
    /** 地址 */
    @JsonProperty("emp_addr")
    private String empAddr;
    /** QQ */
    @JsonProperty("emp_qq")
    private String empQq;
    /** 微信 */
    @JsonProperty("emp_weixin")
    private String empWeixin;
    /** 隶属部门 */
    @JsonProperty("emp_org_id")
    private String empOrgId;
    /** 是否机构领导 */
    @JsonProperty("emp_is_org_learder")
    private String empIsOrgLearder;
    /** 员工上级唯一标识 */
    @JsonProperty("emp_parent_id")
    private String empParentId;
    /** 手机卡绑定 */
    @JsonProperty("emp_imsi_binding")
    private String empImsiBinding;
    /** 岗位名称 */
    @JsonProperty("emp_job")
    private String empJob;
    /** 员工账号状态 */
    @JsonProperty("emp_status")
    private String empStatus;

    /**外勤 365 的员工唯一标识**/
    private List<BWQ20170201Result> exts;

    /** 注册来源 */
    private String fromFlg;

    public String getEmpTel() {
        return empTel;
    }

    public void setEmpTel(String empTel) {
        this.empTel = empTel;
    }

    public String getEmpIdcard() {
        return empIdcard;
    }

    public void setEmpIdcard(String empIdcard) {
        this.empIdcard = empIdcard;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpAddr() {
        return empAddr;
    }

    public void setEmpAddr(String empAddr) {
        this.empAddr = empAddr;
    }

    public String getEmpQq() {
        return empQq;
    }

    public void setEmpQq(String empQq) {
        this.empQq = empQq;
    }

    public String getEmpWeixin() {
        return empWeixin;
    }

    public void setEmpWeixin(String empWeixin) {
        this.empWeixin = empWeixin;
    }

    public String getEmpOrgId() {
        return empOrgId;
    }

    public void setEmpOrgId(String empOrgId) {
        this.empOrgId = empOrgId;
    }

    public String getEmpIsOrgLearder() {
        return empIsOrgLearder;
    }

    public void setEmpIsOrgLearder(String empIsOrgLearder) {
        this.empIsOrgLearder = empIsOrgLearder;
    }

    public String getEmpParentId() {
        return empParentId;
    }

    public void setEmpParentId(String empParentId) {
        this.empParentId = empParentId;
    }

    public String getEmpImsiBinding() {
        return empImsiBinding;
    }

    public void setEmpImsiBinding(String empImsiBinding) {
        this.empImsiBinding = empImsiBinding;
    }

    public String getEmpJob() {
        return empJob;
    }

    public void setEmpJob(String empJob) {
        this.empJob = empJob;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpMobile() {
        return empMobile;
    }

    public void setEmpMobile(String empMobile) {
        this.empMobile = empMobile;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BWQ20170201Result> getExts() {
        return exts;
    }

    public void setExts(List<BWQ20170201Result> exts) {
        this.exts = exts;
    }

    public String getFromFlg() {
        return fromFlg;
    }

    public void setFromFlg(String fromFlg) {
        this.fromFlg = fromFlg;
    }
}
