package com.msk.sso.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.msk.core.bean.BaseParam;

/**
 * SSO登录参数
 */
@JsonIgnoreProperties(value = {"delFlg", "crtId", "crtTime", "updId", "updTime", "actId", "actTime"})
public class SsoParam extends BaseParam {

    /** 用户登录令牌 */
    private String token;
    /** 登录后需要显示的url */
    private String url;
    /** 登录者ID */
    private String loginId;
    // /** 登录者密码 */
    // private String loginPwd;
    /** 用户类型(员工，买家/供应商，买家) */
    private String userType;
    /** 客户端系统环境区分(不同env会对应不同的配置，该值可以让sso同时支持多个环境下多个系统) */
    private String env;
    /** 登录者密码 */
    private String loginPwd;

    /**
     * 构造方法
     */
    public SsoParam() {}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    // public String getLoginPwd() { return loginPwd; }

    // public void setLoginPwd(String loginPwd) { this.loginPwd = loginPwd; }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }
}
