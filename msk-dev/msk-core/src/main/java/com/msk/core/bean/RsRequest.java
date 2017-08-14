package com.msk.core.bean;

/**
 * Web Service 服务接口参数
 * 
 * @param <T> 参数类型
 */
public class RsRequest<T> {
    /** 客户端标识 */
    private String siteCode;
    /** 身份认证密码 */
    private String auth;
    /** 登录人 */
    private String loginId;
    /** 业务参数 */
    private T param;

    /**
     * 构造方法
     */
    public RsRequest() {

    }

    /**
     * Get the siteCode.
     *
     * @return siteCode
     *
     */
    public String getSiteCode() {
        return this.siteCode;
    }

    /**
     * Set the siteCode.
     *
     * @param siteCode siteCode
     *
     */
    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    /**
     * Get the auth.
     *
     * @return auth
     *
     */
    public String getAuth() {
        return this.auth;
    }

    /**
     * Set the auth.
     *
     * @param auth auth
     *
     */
    public void setAuth(String auth) {
        this.auth = auth;
    }

    /**
     * Get the loginId.
     *
     * @return loginId
     *
     */
    public String getLoginId() {
        return this.loginId;
    }

    /**
     * Set the loginId.
     *
     * @param loginId loginId
     *
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Get the param.
     *
     * @return param
     *
     */
    public T getParam() {
        return this.param;
    }

    /**
     * Set the param.
     *
     * @param param param
     *
     */
    public void setParam(T param) {
        this.param = param;
    }
}
