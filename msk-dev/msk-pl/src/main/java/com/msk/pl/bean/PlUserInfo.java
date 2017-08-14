package com.msk.pl.bean;

import com.msk.core.bean.BaseBean;

/**
 * Created by xuhongyang on 2017/2/4.
 * 进货单使用人员账号表
 */
public class PlUserInfo extends BaseBean {


    //表格ID
    private Long tblId;
    //物流区编码
    private String logiareaCode;
    //物流区名称
    private String logiareaName;
    //配送站ID
    private Long terminalId;
    //配送站名称
    private String terminalName;
    //领地ID
    private Long domainId;
    //领地编码
    private String domainCode;
    //领地名称
    private String domainName;
    //用户外勤365实名
    private String userName;
    //用户外勤365账号
    private String wqAccount;
    //手机号码
    private String wqTel;
    //上司外勤365实名
    private String leaderName;
    //上司外勤365账号
    private String leaderWqAccount;
    //上司手机号码
    private String leaderTel;
    //用户角色 合伙人：1；买手：2；财务人员：3
    private int userRole;


    /**
     * Getter method for property <tt>tblId</tt>.
     *
     * @return property value of tblId
     */
    public Long getTblId() {
        return tblId;
    }

    /**
     * Setter method for property <tt>tblId</tt>.
     *
     * @param tblId value to be assigned to property tblId
     */
    public void setTblId(Long tblId) {
        this.tblId = tblId;
    }

    /**
     * Getter method for property <tt>logiareaCode</tt>.
     *
     * @return property value of logiareaCode
     */
    public String getLogiareaCode() {
        return logiareaCode;
    }

    /**
     * Setter method for property <tt>logiareaCode</tt>.
     *
     * @param logiareaCode value to be assigned to property logiareaCode
     */
    public void setLogiareaCode(String logiareaCode) {
        this.logiareaCode = logiareaCode;
    }

    /**
     * Getter method for property <tt>logiareaName</tt>.
     *
     * @return property value of logiareaName
     */
    public String getLogiareaName() {
        return logiareaName;
    }

    /**
     * Setter method for property <tt>logiareaName</tt>.
     *
     * @param logiareaName value to be assigned to property logiareaName
     */
    public void setLogiareaName(String logiareaName) {
        this.logiareaName = logiareaName;
    }

    /**
     * Getter method for property <tt>terminalId</tt>.
     *
     * @return property value of terminalId
     */
    public Long getTerminalId() {
        return terminalId;
    }

    /**
     * Setter method for property <tt>terminalId</tt>.
     *
     * @param terminalId value to be assigned to property terminalId
     */
    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    /**
     * Getter method for property <tt>terminalName</tt>.
     *
     * @return property value of terminalName
     */
    public String getTerminalName() {
        return terminalName;
    }

    /**
     * Setter method for property <tt>terminalName</tt>.
     *
     * @param terminalName value to be assigned to property terminalName
     */
    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    /**
     * Getter method for property <tt>domainId</tt>.
     *
     * @return property value of domainId
     */
    public Long getDomainId() {
        return domainId;
    }

    /**
     * Setter method for property <tt>domainId</tt>.
     *
     * @param domainId value to be assigned to property domainId
     */
    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    /**
     * Getter method for property <tt>domainCode</tt>.
     *
     * @return property value of domainCode
     */
    public String getDomainCode() {
        return domainCode;
    }

    /**
     * Setter method for property <tt>domainCode</tt>.
     *
     * @param domainCode value to be assigned to property domainCode
     */
    public void setDomainCode(String domainCode) {
        this.domainCode = domainCode;
    }

    /**
     * Getter method for property <tt>domainName</tt>.
     *
     * @return property value of domainName
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * Setter method for property <tt>domainName</tt>.
     *
     * @param domainName value to be assigned to property domainName
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    /**
     * Getter method for property <tt>userName</tt>.
     *
     * @return property value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for property <tt>userName</tt>.
     *
     * @param userName value to be assigned to property userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter method for property <tt>wqAccount</tt>.
     *
     * @return property value of wqAccount
     */
    public String getWqAccount() {
        return wqAccount;
    }

    /**
     * Setter method for property <tt>wqAccount</tt>.
     *
     * @param wqAccount value to be assigned to property wqAccount
     */
    public void setWqAccount(String wqAccount) {
        this.wqAccount = wqAccount;
    }

    /**
     * Getter method for property <tt>wqTel</tt>.
     *
     * @return property value of wqTel
     */
    public String getWqTel() {
        return wqTel;
    }

    /**
     * Setter method for property <tt>wqTel</tt>.
     *
     * @param wqTel value to be assigned to property wqTel
     */
    public void setWqTel(String wqTel) {
        this.wqTel = wqTel;
    }

    /**
     * Getter method for property <tt>leaderName</tt>.
     *
     * @return property value of leaderName
     */
    public String getLeaderName() {
        return leaderName;
    }

    /**
     * Setter method for property <tt>leaderName</tt>.
     *
     * @param leaderName value to be assigned to property leaderName
     */
    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    /**
     * Getter method for property <tt>leaderWqAccount</tt>.
     *
     * @return property value of leaderWqAccount
     */
    public String getLeaderWqAccount() {
        return leaderWqAccount;
    }

    /**
     * Setter method for property <tt>leaderWqAccount</tt>.
     *
     * @param leaderWqAccount value to be assigned to property leaderWqAccount
     */
    public void setLeaderWqAccount(String leaderWqAccount) {
        this.leaderWqAccount = leaderWqAccount;
    }

    /**
     * Getter method for property <tt>leaderTel</tt>.
     *
     * @return property value of leaderTel
     */
    public String getLeaderTel() {
        return leaderTel;
    }

    /**
     * Setter method for property <tt>leaderTel</tt>.
     *
     * @param leaderTel value to be assigned to property leaderTel
     */
    public void setLeaderTel(String leaderTel) {
        this.leaderTel = leaderTel;
    }

    /**
     * Getter method for property <tt>userRole</tt>.
     *
     * @return property value of userRole
     */
    public int getUserRole() {
        return userRole;
    }

    /**
     * Setter method for property <tt>userRole</tt>.
     *
     * @param userRole value to be assigned to property userRole
     */
    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
}
