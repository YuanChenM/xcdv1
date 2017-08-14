package com.msk.core.web.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.msk.core.web.bean.LoginUser;

/**
 * Session Manager
 */
public final class SessionManger {
    /** Session Key */
    private static String SESSION_KEY = "SESSION_KEY";
    /** 用户Session Key */
    private static String USER_SESSION_KEY = "LOGIN_USER_KEY";
    /** Http Session */
    private HttpSession session;

    /**
     * 默认构造函数
     */
    private SessionManger() {}

    /**
     * Session Manger获得
     * 
     * @param request Http Request
     * @return SessionManger
     */
    public static SessionManger getSessionManger(HttpServletRequest request) {
        SessionManger sessionManger = new SessionManger();
        sessionManger.session = request.getSession();
        if (sessionManger.session.getAttribute(SESSION_KEY) == null) {
            Map<String, Object> sessionMap = new HashMap<>();
            sessionManger.session.setAttribute(SESSION_KEY, sessionMap);
        }
        return sessionManger;
    }

    /**
     * 设置Session Value
     * 
     * @param key Session key
     * @param value Session Value
     */
    public void setValue(String key, Object value) {
        Map<String, Object> sessionMap = (Map<String, Object>) session.getAttribute(SESSION_KEY);
        sessionMap.put(key, value);
    }

    /**
     * 获得Session Value
     * 
     * @param key Session Key
     * @return Session Value
     */
    public Object getValue(String key) {
        Map<String, Object> sessionMap = (Map<String, Object>) session.getAttribute(SESSION_KEY);
        return sessionMap.get(key);
    }

    /**
     * 删除Session Value
     * 
     * @param key Session Key
     */
    public void remove(String key) {
        Map<String, Object> sessionMap = (Map<String, Object>) session.getAttribute(SESSION_KEY);
        sessionMap.remove(key);
    }

    /**
     * 清空Session里面全部信息
     */
    public void invalidate() {
        if (session != null) {
            session.removeAttribute(SESSION_KEY);
            session.invalidate();
        }
    }

    /**
     * 设置session中的登录用户信息
     *
     * @param loginUser 登录用户信息
     */
    public void setLoginUser(LoginUser loginUser) {
        this.setValue(USER_SESSION_KEY, loginUser);
    }

    /**
     * 获取session中的登录用户信息
     * 
     * @return 登录用户信息
     */
    public LoginUser getLoginUser() {
        LoginUser loginUser = null;
        Object value = this.getValue(USER_SESSION_KEY);
        if (value != null && value instanceof LoginUser) {
            loginUser = (LoginUser) value;
        }
        return loginUser;
    }
}