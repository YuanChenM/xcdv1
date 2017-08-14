package com.msk.sso.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * SSO登录结果返回值
 */
@JsonIgnoreProperties(value = {"delFlg", "crtId", "crtTime", "updId", "updTime", "actId", "actTime"})
public class SsoResult extends SsoParam {

    /** 登录结果(0:成功,1:失败) */
    private int result;
    /** 结果消息 */
    private String message;

    /**
     * 构造方法
     */
    public SsoResult() {
        super();
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
