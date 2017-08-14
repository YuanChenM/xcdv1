/*
 * 2014/09/23 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.msk.batch.wq.entity;

import com.msk.core.entity.BaseEntity;

/**
 * <p>表wq_employee对应的WqEmployee。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class WqEmployee extends BaseEntity {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /** 表ID */
    private Long tblId;
    /** 员工唯一标识 */
    private String empId;
    /** 员工登录账号 */
    private String empCode;
    /** 员工名称 */
    private String empName;
    /** 员工性别 */
    private String empSex;
    /** 员工手机 */
    private String empMobile;
    /** 员工固话 */
    private String empTel;
    /** 员工身份证 */
    private String empIdcard;
    /** 来源第三方隶属部门 */
    private String empOrgId;
    /** 统隶属部门编码 */
    private String empOrgCode;
    /** 是否机构领导 */
    private String empIsOrgLeader;
    /** 员工上级唯一标识 */
    private String empParentId;
    /** 员工上级编码 */
    private String parentCode;
    /** 外勤365员工上级唯一标识 */
    private String waiqin365ParentId;
    /** 职务名称 */
    private String empPosition;
    /** 外勤365员工唯一标识 */
    private String id;
    /** 员工账号状态 */
    private String empStatus;
    /**
     * <p>默认构造函数。</p>
     */
    public WqEmployee() {

    }

    /**
     * <p>表ID。</p>
     *
     * @return the 表ID
     */
    public Long getTblId() {
        return tblId;
    }

    /**
     * <p>表ID。</p>
     *
     * @param tblId 表ID。
     */
    public void setTblId(Long tblId) {
        this.tblId = tblId;
    }

    /**
     * <p>员工唯一标识。</p>
     *
     * @return the 员工唯一标识
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * <p>员工唯一标识。</p>
     *
     * @param empId 员工唯一标识。
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * <p>员工登录账号。</p>
     *
     * @return the 员工登录账号
     */
    public String getEmpCode() {
        return empCode;
    }

    /**
     * <p>员工登录账号。</p>
     *
     * @param empCode 员工登录账号。
     */
    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    /**
     * <p>员工名称。</p>
     *
     * @return the 员工名称
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * <p>员工名称。</p>
     *
     * @param empName 员工名称。
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * <p>员工性别。</p>
     *
     * @return the 员工性别
     */
    public String getEmpSex() {
        return empSex;
    }

    /**
     * <p>员工性别。</p>
     *
     * @param empSex 员工性别。
     */
    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    /**
     * <p>员工手机。</p>
     *
     * @return the 员工手机
     */
    public String getEmpMobile() {
        return empMobile;
    }

    /**
     * <p>员工手机。</p>
     *
     * @param empMobile 员工手机。
     */
    public void setEmpMobile(String empMobile) {
        this.empMobile = empMobile;
    }

    /**
     * <p>员工固话。</p>
     *
     * @return the 员工固话
     */
    public String getEmpTel() {
        return empTel;
    }

    /**
     * <p>员工固话。</p>
     *
     * @param empTel 员工固话。
     */
    public void setEmpTel(String empTel) {
        this.empTel = empTel;
    }

    /**
     * <p>员工身份证。</p>
     *
     * @return the 员工身份证
     */
    public String getEmpIdcard() {
        return empIdcard;
    }

    /**
     * <p>员工身份证。</p>
     *
     * @param empIdcard 员工身份证。
     */
    public void setEmpIdcard(String empIdcard) {
        this.empIdcard = empIdcard;
    }

    /**
     * <p>来源第三方隶属部门。</p>
     *
     * @return the 来源第三方隶属部门
     */
    public String getEmpOrgId() {
        return empOrgId;
    }

    /**
     * <p>来源第三方隶属部门。</p>
     *
     * @param empOrgId 来源第三方隶属部门。
     */
    public void setEmpOrgId(String empOrgId) {
        this.empOrgId = empOrgId;
    }

    /**
     * <p>统隶属部门编码。</p>
     *
     * @return the 统隶属部门编码
     */
    public String getEmpOrgCode() {
        return empOrgCode;
    }

    /**
     * <p>统隶属部门编码。</p>
     *
     * @param empOrgCode 统隶属部门编码。
     */
    public void setEmpOrgCode(String empOrgCode) {
        this.empOrgCode = empOrgCode;
    }

    /**
     * <p>是否机构领导。</p>
     *
     * @return the 是否机构领导
     */
    public String getEmpIsOrgLeader() {
        return empIsOrgLeader;
    }

    /**
     * <p>是否机构领导。</p>
     *
     * @param empIsOrgLeader 是否机构领导。
     */
    public void setEmpIsOrgLeader(String empIsOrgLeader) {
        this.empIsOrgLeader = empIsOrgLeader;
    }

    /**
     * <p>员工上级唯一标识。</p>
     *
     * @return the 员工上级唯一标识
     */
    public String getEmpParentId() {
        return empParentId;
    }

    /**
     * <p>员工上级唯一标识。</p>
     *
     * @param empParentId 员工上级唯一标识。
     */
    public void setEmpParentId(String empParentId) {
        this.empParentId = empParentId;
    }

    /**
     * <p>员工上级编码。</p>
     *
     * @return the 员工上级编码
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * <p>员工上级编码。</p>
     *
     * @param parentCode 员工上级编码。
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    /**
     * <p>外勤365员工上级唯一标识。</p>
     *
     * @return the 外勤365员工上级唯一标识
     */
    public String getWaiqin365ParentId() {
        return waiqin365ParentId;
    }

    /**
     * <p>外勤365员工上级唯一标识。</p>
     *
     * @param waiqin365ParentId 外勤365员工上级唯一标识。
     */
    public void setWaiqin365ParentId(String waiqin365ParentId) {
        this.waiqin365ParentId = waiqin365ParentId;
    }

    /**
     * <p>职务名称。</p>
     *
     * @return the 职务名称
     */
    public String getEmpPosition() {
        return empPosition;
    }

    /**
     * <p>职务名称。</p>
     *
     * @param empPosition 职务名称。
     */
    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    /**
     * <p>外勤365员工唯一标识。</p>
     *
     * @return the 外勤365员工唯一标识
     */
    public String getId() {
        return id;
    }

    /**
     * <p>外勤365员工唯一标识。</p>
     *
     * @param id 外勤365员工唯一标识。
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * <p>员工账号状态。</p>
     *
     * @return the 员工账号状态
     */
    public String getEmpStatus() {
        return empStatus;
    }

    /**
     * <p>员工账号状态。</p>
     *
     * @param empStatus 员工账号状态。
     */
    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

}
