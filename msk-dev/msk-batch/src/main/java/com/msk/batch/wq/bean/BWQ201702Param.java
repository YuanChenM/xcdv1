package com.msk.batch.wq.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
public class BWQ201702Param extends WqRequest{
    /**
     * 第三方系统员工唯一标识
     */
    @JsonProperty("emp_id")
    private String emp_id;
    /**
     * 外勤 365 的员工唯一标识
     */
    private String id;
    /**
     * 员工登录帐号
     */
    @JsonProperty("emp_code")
    private String empCode;
    /**
     * 创建日期
     */
    @JsonProperty("create_date")
    private String createDate;
    /**
     * 修改日期
     */
    @JsonProperty("modify_date")
    private String modifyDate;

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }
}
