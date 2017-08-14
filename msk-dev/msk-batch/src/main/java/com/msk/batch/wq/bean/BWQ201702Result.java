package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.msk.core.entity.BaseEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BWQ201702Result extends BaseEntity{
    /**id**/
    @JsonProperty("tblId")
    private long tblId;
    /**第三方系统员工唯一标识**/
    @JsonProperty("emp_id")
    private String empId;
    /**外勤 365 的员工唯一标识**/
    private String id;
    /**员工登录帐号**/
    @JsonProperty("emp_code")
    private String empCode;
    /**员工名称**/
    @JsonProperty("emp_name")
    private String empName;
    /**员工性别， F 女性 M 男性**/
    @JsonProperty("emp_sex")
    private String empSex;
    /**员工手机号码**/
    @JsonProperty("emp_mobile")
    private String empMobile;
    /**固定电话**/
    @JsonProperty("emp_tel")
    private String empTel;
    /**身份证号码**/
    @JsonProperty("emp_idcard")
    private String empIdcard;
    /**生日， 格式： yyyy-MM-dd**/
    @JsonProperty("emp_birthday")
    private String empBirthday;
    /**邮箱**/
    @JsonProperty("emp_email")
    private String empEmail;
    /** QQ */
    @JsonProperty("emp_qq")
    private String empQq;
    /** 微信 */
    @JsonProperty("emp_weixin")
    private String empWeixin;
    /**地址**/
    @JsonProperty("emp_addr")
    private String empAddr;
    /**来源第三方系统隶属部门**/
    @JsonProperty("emp_org_id")
    private String empOrgId;
    /**统隶属部门编码**/
    @JsonProperty("emp_org_code")
    private String empOrgCode;
    /**外勤 365 部门唯一标识**/
    @JsonProperty("waiqin365_dept_id")
    private String waiqin365DeptId;
    /**是否机构领导 0 否 1 是，默认值“ 0”**/
    @JsonProperty("emp_is_org_learder")
    private String empIsOrgLearder;
    /**来源第三方系统,员工上级唯一标识**/
    @JsonProperty("emp_parent_id")
    private String empParentId;
    /**员工上级编码**/
    @JsonProperty("parent_code")
    private String parentCode;
    /**外勤 365 员工上级唯一标识**/
    @JsonProperty("waiqin365_parent_id")
    private String waiqin365ParentId;
    /**手机卡绑定， 默认 1 绑定 0 不绑定 1 绑定**/
    @JsonProperty("emp_imsi_binding")
    private String empImsiBinding;
    /**职务名称**/
    @JsonProperty("emp_position")
    private String empPosition;
    /**岗位名称**/
    @JsonProperty("emp_job")
    private String empJob;
    /**员工账号状态
     0 销户 1 正常 2 停用**/
    @JsonProperty("emp_status")
    private String empStatus;
    /**外勤 365 的员工唯一标识**/
    private List<BWQ20170201Result> exts;
    /**管家code**/
    @JsonProperty("houseCode")
    private String houseCode;

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

    /**管家一级分类**/
    @JsonProperty("houseCateGory")

    private String houseCateGory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public String getEmpMobile() {
        return empMobile;
    }

    public void setEmpMobile(String empMobile) {
        this.empMobile = empMobile;
    }

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

    public String getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(String empBirthday) {
        this.empBirthday = empBirthday;
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

    public String getEmpOrgId() {
        return empOrgId;
    }

    public void setEmpOrgId(String empOrgId) {
        this.empOrgId = empOrgId;
    }

    public String getEmpOrgCode() {
        return empOrgCode;
    }

    public void setEmpOrgCode(String empOrgCode) {
        this.empOrgCode = empOrgCode;
    }

    public String getWaiqin365DeptId() {
        return waiqin365DeptId;
    }

    public void setWaiqin365DeptId(String waiqin365DeptId) {
        this.waiqin365DeptId = waiqin365DeptId;
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

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getWaiqin365ParentId() {
        return waiqin365ParentId;
    }

    public void setWaiqin365ParentId(String waiqin365ParentId) {
        this.waiqin365ParentId = waiqin365ParentId;
    }

    public String getEmpImsiBinding() {
        return empImsiBinding;
    }

    public void setEmpImsiBinding(String empImsiBinding) {
        this.empImsiBinding = empImsiBinding;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public List<BWQ20170201Result> getExts() {
        return exts;
    }

    public void setExts(List<BWQ20170201Result> exts) {
        this.exts = exts;
    }

    public long getTblId() {
        return tblId;
    }

    public void setTblId(long tblId) {
        this.tblId = tblId;
    }

    public String getEmpJob() {
        return empJob;
    }

    public void setEmpJob(String empJob) {
        this.empJob = empJob;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    public String getHouseCateGory() {
        return houseCateGory;
    }

    public void setHouseCateGory(String houseCateGory) {
        this.houseCateGory = houseCateGory;
    }
}
