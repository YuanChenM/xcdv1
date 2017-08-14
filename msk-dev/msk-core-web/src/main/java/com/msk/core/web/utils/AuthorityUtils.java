package com.msk.core.web.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.msk.core.entity.OrgSysModule;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.bean.ActionAuthority;
import com.msk.core.web.bean.LoginUser;

/**
 * Created by jiangnan on 15/11/26.
 */
public final class AuthorityUtils {

    /**
     * 检查登录用户是否拥有模块权限
     *
     * @param request 请求
     * @param moduleCode 模块编码
     */
    public static boolean checkModuleAuth(HttpServletRequest request, String moduleCode) {
        boolean result = false;
        SessionManger sessionManger = SessionManger.getSessionManger(request);
        LoginUser loginUser = sessionManger.getLoginUser();
        if (loginUser != null && !StringUtil.isEmpty(moduleCode)) {
            List<OrgSysModule> modules = loginUser.getSystemModules();
            for (OrgSysModule m : modules) {
                if (moduleCode.equalsIgnoreCase(m.getSysModule())) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 检查登录用户是否拥有按钮权限
     * 
     * @param request 请求
     * @param pageCode 页面编码
     * @param actionCode 按钮编码
     */
    public static boolean checkButtonAuth(HttpServletRequest request, String pageCode, String actionCode) {
        boolean result = false;
        SessionManger sessionManger = SessionManger.getSessionManger(request);
        LoginUser loginUser = sessionManger.getLoginUser();
        if (loginUser != null) {
            List<ActionAuthority> list = loginUser.getActionList();
            for (ActionAuthority bean : list) {
                if (pageCode.equals(bean.getPageCode()) && actionCode.equals(bean.getActionCode())) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
