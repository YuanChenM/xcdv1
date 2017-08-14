package com.msk.sso.bean;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by mabo on 2016/4/26.
 */
public class LoginInfo {
    /** token */
    private String token;
    /** 登录者ID */
    private String loginId;
    /** 用户类型 */
    private String userType;
    /** 登录时间 */
    private Calendar loginTime;
    /** 最后访问时间 */
    private Calendar lastAccessTime;
//    /** 消息 */
//    private String message;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Calendar getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Calendar loginTime) {
        this.loginTime = loginTime;
    }

    public Calendar getLastAccessTime() {  return lastAccessTime; }

    public void setLastAccessTime(Calendar lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

//    public String getMessage() { return message; }
//
//    public void setMessage(String message) { this.message = message; }
}
