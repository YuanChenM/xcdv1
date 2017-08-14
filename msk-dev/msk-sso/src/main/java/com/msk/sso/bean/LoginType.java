package com.msk.sso.bean;

/**
 * 登录用户类型
 * Created by mabo on 2016/5/31.
 */
public class LoginType {

    /** 类型编码 */
    private String code;
    /** 类型名称 */
    private String name;

    /**
     * 构造方法
     */
    public LoginType() {}

    /**
     * 构造方法
     * 
     * @param code 类型编码
     * @param name 类型名称
     */
    public LoginType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
