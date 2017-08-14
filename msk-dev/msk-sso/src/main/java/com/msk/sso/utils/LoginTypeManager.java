package com.msk.sso.utils;

import java.util.*;

import com.msk.core.utils.StringUtil;
import com.msk.sso.bean.LoginType;

/**
 * 登录类型管理类
 * Created by mabo on 2016/6/2.
 */
public class LoginTypeManager {
    /** 默认环境的KEY */
    private static final String DEFAULT_ENV = "com.msk.sso.utils.LoginTypeManager.DEFAULT";
    /** 单实例(每环境一个) */
    private static Map<String, LoginTypeManager> instanceMap;

    /** 登录类型列表 */
    private List<LoginType> types;
    /** 最后更新时间 */
    private Calendar updatedTime;

    static {
        instanceMap = new HashMap<>();
    }

    /**
     * 构造方法
     */
    private LoginTypeManager() {
        types = new ArrayList<>();
        updatedTime = null;
    }

    /**
     * 获取单实例
     *
     * @return 单实例
     */
    protected static LoginTypeManager getInstance() {
        return getInstance(null);
    }

    /**
     * 获取单实例
     * 
     * @param env 环境区分
     * @return 单实例
     */
    public static LoginTypeManager getInstance(String env) {
        String key = env;
        if (StringUtil.isEmpty(key)) {
            key = DEFAULT_ENV;
        }
        if (!instanceMap.containsKey(key)) {
            LoginTypeManager instance = new LoginTypeManager();
            instanceMap.put(key, instance);
        }
        return instanceMap.get(key);
    }

    /**
     * 重新设置登录类型。
     * 会先清空原有数据，并把新数据保存。
     * 
     * @param types 登录类型
     */
    public void set(List<LoginType> types) {
        this.types.clear();
        if (types != null && !types.isEmpty()) {
            this.types.addAll(types);
        }
        this.updatedTime = Calendar.getInstance();
    }

    /**
     * 获取全部设置登录类型。
     */
    public List<LoginType> get() {
        return this.types;
    }

    /**
     * 判断数据是否需要更新
     * 
     * @return 需要更新时返回true
     */
    public boolean needReload() {
        boolean result = true;

        if (updatedTime != null) {
            // 获取当前时间
            Calendar currentTime = Calendar.getInstance();
            // 如果距最后更新时间超过24小时了，就需要进行更新
            currentTime.add(Calendar.HOUR, -24);
            if (currentTime.before(updatedTime)) {
                result = false;
            }
        }
        return result;
    }
}
