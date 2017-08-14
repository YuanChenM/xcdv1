package com.msk.core.web.interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.TypeReference;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.bean.LoginUser;
import com.msk.core.web.utils.SessionManger;
import com.msk.org.bean.LoginUserType;
import com.msk.sso.client.bean.RestResponse;
import com.msk.sso.client.utils.AssertionUtils;
import com.msk.sso.client.utils.RestClientUtil;
import com.msk.sso.client.utils.UserSessionManger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.RegexUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.utils.AuthorityUtils;

/**
 * Created by jiangnan on 15/11/25.
 */
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

    /** 字符集编码 */
    private static final String CHARACTER_ENCODING = "UTF-8";

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private void initUserSession(HttpServletRequest request){
        RsRequest<HashMap<String,Object>> requestBody = new RsRequest<>();
        requestBody.setLoginId("system");
        requestBody.setAuth("123456");
        requestBody.setSiteCode("bms");
        HashMap<String,Object> param = new HashMap<>();
        Map<String,String> ssoUserInfoMap =  AssertionUtils.getSsoUserInfo(request);
        param.put("token","");
        param.put("loginId",ssoUserInfoMap.get(AssertionUtils.SSO_USER_INFO_MAP_USER_NAME_KEY));
        param.put("userType",ssoUserInfoMap.get(AssertionUtils.SSO_USER_INFO_MAP_USER_TYPE_KEY));
        requestBody.setParam(param);
        String checkUrl = StringUtil.formatMessage("{0}/api/v1/org/getLoginInfo", ConfigManager.getApiServerUrl());
        RestResponse<LoginUser> responseBody = RestClientUtil.post(checkUrl, requestBody, new TypeReference<RestResponse<LoginUser>>(){});
        LoginUser loginUser = responseBody.getResult();
        SessionManger.getSessionManger(request).setLoginUser(loginUser);
    }
    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回FALSE
     * 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     * 如果返回TRUE
     * 执行下一个拦截器,直到所有的拦截器都执行完毕
     * 再执行被拦截的Controller
     * 然后进入拦截器链
     * 从最后一个拦截器往回执行所有的POSTHandle()
     * 接着再从最后一个拦截器往回执行所有的AFTERCOMPLETION()
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        Map<String,String> ssoUserInfoMap =  AssertionUtils.getSsoUserInfo(request);
        String userType = ssoUserInfoMap.get(AssertionUtils.SSO_USER_INFO_MAP_USER_TYPE_KEY);
        if(LoginUserType.getUserTypeBank().equals(userType)){
            return super.preHandle(request, response, handler);
        }

        LoginUser loginUser = SessionManger.getSessionManger(request).getLoginUser();
        if(loginUser == null){
            this.initUserSession(request);
        }
        String requestUri = request.getRequestURI();
        logger.debug("Request URL:" + requestUri);

        if (ConfigManager.needAuthCheck()) {
            // 获取请求元的url
            String fromUrl = request.getHeader("referer");
            if (!StringUtil.isEmpty(fromUrl)) {
                // 判断是否main页面的url
                String sysModule = RegexUtils.find("^.+//.+/.+/(.+)/main$", fromUrl, 1);
                if (!StringUtil.isEmpty(sysModule) && !AuthorityUtils.checkModuleAuth(request, sysModule)) {
                    // session中有登录id，但和token中的不同，说明是别处重登录过了，所以要显示message
                    redirectToMain(response);
                    return false;
                }
            }
        }

        return super.preHandle(request, response, handler);
    }

    /**
     * 跳转到系统模块选择画面
     *
     * @param response 应答
     * @throws IOException
     */
    private void redirectToMain(HttpServletResponse response) throws IOException {

        // 登录后显示系统模块选择页面
        String switchUrl;
        switchUrl = StringUtil.formatMessage("{0}/main?flag=reload", ConfigManager.getWebServerUrl());

        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head><title>reload</title><script type=\"text/javascript\">");
        // sb.append(" document.cookie = '" + COOKIE_BOOKMARK_STORE + "=' + window.location.hash + '; path=/';");
        sb.append("window.location = '" + switchUrl + "' + window.location.hash;");
        sb.append("</script></head>");
        sb.append("<body/></html>");

        // response.setStatus(401);
        response.setContentType("text/html;charset=" + CHARACTER_ENCODING);
        response.setContentLength(sb.toString().getBytes(CHARACTER_ENCODING).length);
        response.getWriter().write(sb.toString());
    }

    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作<br/>
     * 可在modelAndView中加入数据
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

}
