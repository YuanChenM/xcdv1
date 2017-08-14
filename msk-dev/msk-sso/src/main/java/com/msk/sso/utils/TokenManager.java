package com.msk.sso.utils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msk.core.utils.StringUtil;
import com.msk.sso.bean.LoginInfo;

/**
 * Token管理类
 * 
 * Created by mabo on 2016/5/27.
 */
public class TokenManager {

    /** 日志 */
    private static Logger logger = LoggerFactory.getLogger(TokenManager.class);

    /** Token信息的Map */
    private static Map<String, LoginInfo> tokenMap;
    /** Token管理类的单实例 */
    private static TokenManager instance;

    /**
     * 私有构造方法
     */
    private TokenManager() {
        tokenMap = new HashMap();
    }

    /**
     * 获取Token管理类的单实例
     * 
     * @return Token管理类的单实例
     */
    public static TokenManager getInstance() {
        if (instance == null) {
            instance = new TokenManager();
        }
        return instance;
    }

    /**
     * 创建token
     * 
     * @param loginInfo 登录用户信息
     * @return 登录信息
     */
    public boolean createToken(LoginInfo loginInfo) {
        boolean result = false;
        if (loginInfo != null) {
            // Date now = new Date(System.currentTimeMillis());
            Calendar now = Calendar.getInstance();
            loginInfo.setLoginTime(now); // 登录时间
            loginInfo.setLastAccessTime(now); // 更新最后访问时间
            // 新Token，要确保是之前没有的
            String token;
            do {
                token = TokenUtil.getInstance().generateToken(loginInfo.getLoginId(), true);
            } while (StringUtil.isEmpty(token) || tokenMap.containsKey(token));
            loginInfo.setToken(token);
            tokenMap.put(token, loginInfo);
            logger.debug("token created:{}", token);
            result = true;
        }
        return result;
    }

    /**
     * 检查token是否有效
     *
     * @param token token
     * @return 登录id
     */
    public LoginInfo checkToken(String token) {
        LoginInfo loginInfo = null;
        if (!StringUtil.isEmpty(token)) {
            loginInfo = tokenMap.get(token);
            if (loginInfo != null) {
                // 更新最后访问时间
                loginInfo.setLastAccessTime(Calendar.getInstance());
            }
        }
        return loginInfo;
    }

    /**
     * 检查token是否有效
     *
     * @param token token
     * @return 登录id
     */
    public boolean clearToken(String loginId, String token) {
        boolean result = false;
        if (!StringUtil.isEmpty(token) && !StringUtil.isEmpty(loginId)) {
            if (tokenMap.containsKey(token)) {
                LoginInfo loginInfo = tokenMap.get(token);
                if (loginInfo != null) {
                    if (loginId.equalsIgnoreCase(loginInfo.getLoginId())) {
                        // token有效且用户匹配时，清除token
                        tokenMap.remove(token);
                        logger.debug("token removed:{}", token);
                        result = true;
                    } else {
                        logger.warn("登录id不匹配，未清除token：{}", token);
                    }
                } else {
                    // token中无登录信息，不可能的case
                    tokenMap.remove(token);
                    logger.debug("token removed:{}", token);
                    result = true;
                }
            } else {
                // token 已经失效
                result = true;
            }
        }
        return result;
    }

    /**
     * 清除过期的token.
     * 超过20分钟的
     */
    public void expireToken() {
        // 失效时间 = 当前时间 - 20分钟
        Calendar expiredTime = Calendar.getInstance();
        expiredTime.add(Calendar.MINUTE, -20); // TODO 配置

        String[] keys = tokenMap.keySet().toArray(new String[0]);
        for (String key : keys) {
            LoginInfo loginInfo = tokenMap.get(key);
            // 清除失效时间之前的token信息
            if (loginInfo == null || loginInfo.getLastAccessTime().before(expiredTime)) {
                tokenMap.remove(key);
                logger.debug("token expired:{}", loginInfo.getToken());
            }
        }
    }

}
