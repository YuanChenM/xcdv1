package com.msk.core.web.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.bean.BaseBean;
import com.msk.core.entity.OrgSysModule;

@JsonIgnoreProperties(value = { "delFlg", "crtId", "crtTime", "updId", "updTime", "actId", "actTime" })
public class LoginUser extends BaseBean {
    private static final long serialVersionUID = 1L;

    /** 部门编号 */
    private String deptCode;
    /** 部门名称 */
    private String deptName;
    /** 员工编号(登录名) */
    private String emplNo;
    /** 员工名称 */
    private String emplName;
    /** 员工ID */
    private String emplId;
    /** 登录密码 */
    private String loginPwd;
    /** 邮件地址 */
    private String emialAddr;
    /** 操作List */
    private List<ActionAuthority> actionList;
    // /** 菜单List */
    // private List<PageAuthoritie> menuPageList;
    // /** 页面权限 */
    // private List<PageAuthoritie> pageList;
    /** 状态 */
    private int status;
    /** 用户类型 */
    private String userType;
    /** 用户登录令牌 */
    private String token;
    /** 用户角色 */
    private List<LoginRole> roles;
    /** 有权限的系统模块code */
    private List<OrgSysModule> systemModules;

    /**
     * Getter method for property <tt>deptCode</tt>.
     *
     * @return property value of deptCode
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * Setter method for property <tt>deptCode</tt>.
     *
     * @param deptCode value to be assigned to property deptCode
     */
    public void seteptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * Getter method for property <tt>deptName</tt>.
     *
     * @return property value of deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * Setter method for property <tt>deptName</tt>.
     *
     * @param deptName value to be assigned to property deptName
     */
    public void seteptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * Getter method for property <tt>actionList</tt>.
     *
     * @return property value of actionList
     */
    public List<ActionAuthority> getActionList() {
        return actionList;
    }

    /**
     * Setter method for property <tt>actionList</tt>.
     *
     * @param actionList value to be assigned to property actionList
     */
    public void setActionList(List<ActionAuthority> actionList) {
        this.actionList = actionList;
    }
    //
    // /**
    // * Getter method for property <tt>menuPageList</tt>.
    // *
    // * @return property value of menuPageList
    // */
    // public List<PageAuthoritie> getMenuPageList() {
    // return menuPageList;
    // }
    //
    // /**
    // * Setter method for property <tt>menuPageList</tt>.
    // *
    // * @param menuPageList value to be assigned to property menuPageList
    // */
    // public void setMenuPageList(List<PageAuthoritie> menuPageList) {
    // this.menuPageList = menuPageList;
    // }
    //
    // /**
    // * Getter method for property <tt>pageList</tt>.
    // *
    // * @return property value of pageList
    // */
    // public List<PageAuthoritie> getPageList() {
    // return pageList;
    // }
    //
    // /**
    // * Setter method for property <tt>pageList</tt>.
    // *
    // * @param pageList value to be assigned to property pageList
    // */
    // public void setPageList(List<PageAuthoritie> pageList) {
    // this.pageList = pageList;
    // }

    /**
     * *获得emialAddr
     **/
    public String getEmialAddr() {
        return emialAddr;
    }

    /**
     * *设置emialAddr
     **/
    public void setEmialAddr(String emialAddr) {
        this.emialAddr = emialAddr;
    }

    /**
     * @return the emplNo
     */
    public String getEmplNo() {
        return emplNo;
    }

    /**
     * @param emplNo the emplNo to set
     */
    public void setEmplNo(String emplNo) {
        this.emplNo = emplNo;
    }

    /**
     * @return the emplName
     */
    public String getEmplName() {
        return emplName;
    }

    /**
     * @param emplName the emplName to set
     */
    public void setEmplName(String emplName) {
        this.emplName = emplName;
    }

    /**
     * @return the emplId
     */
    public String getEmplId() {
        return emplId;
    }

    /**
     * @param emplId the emplId to set
     */
    public void setEmplId(String emplId) {
        this.emplId = emplId;
    }

    /**
     * @return the loginPwd
     */
    public String getLoginPwd() {
        return loginPwd;
    }

    /**
     * @param loginPwd the loginPwd to set
     */
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    /**
     * *获得status
     **/
    public int getStatus() {
        return status;
    }

    /**
     * *设置status
     **/
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Getter method for property <tt>userType</tt>.
     *
     * @return property value of userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Setter method for property <tt>userType</tt>.
     *
     * @param userType value to be assigned to property userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Getter method for property <tt>token</tt>.
     *
     * @return property value of token
     */
    public String getToken() {
        return token;
    }

    /**
     * Setter method for property <tt>token</tt>.
     *
     * @param token value to be assigned to property token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Getter method for property <tt>roles</tt>.
     *
     * @return property value of roles
     */
    public List<LoginRole> getRoles() {
        return roles;
    }

    /**
     * Setter method for property <tt>roles</tt>.
     *
     * @param roles value to be assigned to property roles
     */
    public void setRoles(List<LoginRole> roles) {
        this.roles = roles;
    }

    /**
     * Getter method for property <tt>systemModules</tt>.
     *
     * @return property value of systemModules
     */
    public List<OrgSysModule> getSystemModules() {
        return systemModules;
    }

    /**
     * Setter method for property <tt>systemModules</tt>.
     *
     * @param systemModules value to be assigned to property systemModules
     */
    public void setSystemModules(List<OrgSysModule> systemModules) {
        this.systemModules = systemModules;
    }

}
