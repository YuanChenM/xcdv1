package com.msk.sso.interceptor;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.msk.common.utils.RsClientUtil;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.StringConst;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.bean.LoginUser;
import com.msk.core.web.consts.BusinessConst;
import com.msk.core.web.utils.CookieUtils;
import com.msk.core.web.utils.SessionManger;
import com.msk.sso.bean.LoginInfo;
import com.msk.sso.bean.SsoParam;
import com.msk.sso.bean.SsoResult;

/**
 * 登录Session信息检查过滤器
 * 
 * @author ma_b
 * 
 */
public class SessionCheckFilter implements Filter {

    /** 字符集编码 */
    private static final String CHARACTER_ENCODING = "UTF-8";
    // /** cookie键值 */
    // private static final String COOKIE_BOOKMARK_STORE = "msk-bms-bk";
    /** token键值 */
    private static final String TOKEN = "token";
    // /** HTTP默认端口 */
    // private static final int PORT_HTTP = 80;
    // /** HTTPS默认端口 */
    // private static final int PORT_HTTPS = 443;
    // /** 页面中保存用户ID的键 */
    // private static final String KEY_PAGE_LOGINID = "MAIN_PAGE_LOGINID";

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(SessionCheckFilter.class);

    /** 无需过滤的url */
    private static List<String> excludeUrlList = new ArrayList<>();
    /** 无需过滤的url前缀 */
    private static List<String> excludePrefixList = new ArrayList<>();
    /** 无需过滤的url后缀 */
    private static List<String> excludeSuffixList = new ArrayList<>();
    /** 需要排除的url */
    private String excludeUrls;
    // Rest Service 客户端
    private RsClientUtil rsClient;

    /**
     * 构造方法
     */
    public SessionCheckFilter() {}

    /**
     * 初始化配置参数
     * 
     * @param filterConfig 配置对象
     * @throws ServletException 处理异常
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初期化上下文
        WebApplicationContext context = WebApplicationContextUtils
            .getWebApplicationContext(filterConfig.getServletContext());
        rsClient = context.getBean(RsClientUtil.class);

        // 排除url
        this.excludeUrls = filterConfig.getInitParameter("excludeUrls");
        if (!StringUtil.isEmpty(this.excludeUrls)) {
            String[] excludeParams = this.excludeUrls.split(StringConst.COMMA);
            for (String excludeParam : excludeParams) {
                if (!StringUtil.isEmpty(excludeParam)) {
                    if (excludeParam.startsWith(StringConst.STAR)) {
                        // 后缀匹配
                        this.excludeSuffixList.add(excludeParam.substring(1));
                    } else if (excludeParam.endsWith(StringConst.STAR)) {
                        // 前缀匹配
                        this.excludePrefixList
                            .add(excludeParam.substring(0, excludeParam.lastIndexOf(StringConst.STAR)));
                    } else {
                        // 全匹配
                        this.excludeUrlList.add(excludeParam);
                    }
                }
            }
        }
    }

    /**
     * 前处理
     * 
     * @param request 请求
     * @param response 应答
     * @return true:检查通过继续后处理, false:检查不通过迁移到login页面
     * @throws IOException IO异常
     * @throws ServletException Servlet异常
     */
    private boolean doBeforeProcessing(ServletRequest request, ServletResponse response)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // 字符集编码设置
        req.setCharacterEncoding(CHARACTER_ENCODING);
        res.setCharacterEncoding(CHARACTER_ENCODING);

        // 判断是否需要进行下面的session检查
        if (_isExcludeUrl(request)) {
            return true;
        }

        // 获取目前的token
        String token = getToken(req);
        // 验证token，有效时能得到登录id
        LoginInfo loginUser = checkToken(token);
        if (loginUser != null && !StringUtil.isEmpty(loginUser.getLoginId())) {
            // token有效时，尝试获取session中的登录id
            String loginIdInSession = getLoginIdFromSession(req);
            if (loginUser.getLoginId().equalsIgnoreCase(loginIdInSession)) {
                // 如果有session且session中的登录id与得到的登录id一致时，说明session有效
                // 设置应答中的header信息，然后跳出
                res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                res.setDateHeader("Expires", 0); // Proxies.
                return true;
            } else {
                // 否则session无效，根据得到的登录id获取用户信息并保存到session
                if (doLogin(loginUser.getLoginId(), loginUser.getUserType(), token, req)) {
                    // 用户信息获取成功时, token设置到cookie
                    CookieUtils.setCookieValue(res, TOKEN, token);
                    // 重新跳转到main画面
                    logger.warn("已经重新登录，跳转到系统模块选择页面。{}", loginUser.getLoginId());
                    if (StringUtil.isEmpty(loginIdInSession) || "/main".equals(req.getServletPath())) {
                        // session中没有登录id，说明是正常登录进来的
                        redirectToMain(res, null);
                    } else {
                        // session中有登录id，但和token中的不同，说明是别处重登录过了，所以要显示message
                        redirectToMain(res, "reload");
                    }
                    return false;
                } else {
                    logger.warn("session登录失败，跳转到登录页面。{}", loginUser.getLoginId());
                }
            }
        } else {
            logger.debug("session失效，跳转到登录页面。");
        }

        // token无效时
        // 清除Session
        SessionManger.getSessionManger(req).invalidate();
        // 清除cookie中的token
        CookieUtils.removeCookie(req, res, TOKEN);
        // 跳转到sso登录页面进行登录
        if (req.getServletPath().endsWith("/login")) {
            redirectToSslLogin(req, res, null);
        } else {
            redirectToSslLogin(req, res, "timeout");
        }

        return false;
    }

    /**
     * 后处理
     * 
     * @param request 请求
     * @param response 应答
     * @throws IOException IO异常
     * @throws ServletException Servlet异常
     */
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
        throws IOException, ServletException {
        // 无特别处理
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        // 前处理
        if (doBeforeProcessing(request, response)) {
            try {
                chain.doFilter(request, response);
            } catch (IllegalStateException ex) {
                logger.warn(ex.getMessage());
            }
            // 后处理
            doAfterProcessing(request, response);
        }
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * 检查当前URL是否属于排除URL
     * 
     * @param request 请求
     * @return 属于排除URL时返回true
     */
    private static boolean _isExcludeUrl(ServletRequest request) {
        boolean isExcludeUrl = false;

        // 从request中获取URL的最后部分
        String currentUrl = ((HttpServletRequest) request).getServletPath();

        // 判断是否需要进行下面的session检查
        if (currentUrl != null) {
            // 排除url
            if (excludeUrlList.contains(currentUrl)) {
                return true;
            }
            // 排除前缀开始的url
            for (String urlPrefix : excludePrefixList) {
                if (currentUrl.startsWith(urlPrefix)) {
                    return true;
                }
            }
            // 排除后缀结束的url
            for (String urlSuffix : excludeSuffixList) {
                if (currentUrl.endsWith(urlSuffix)) {
                    return true;
                }
            }
        }

        return isExcludeUrl;
    }

    /**
     * 获取现在的token
     *
     * @param request 请求
     * @return token
     */
    private static String getToken(HttpServletRequest request) {
        String token;

        // 从request参数中获取
        token = request.getParameter(TOKEN);
        // 从cookie中获取
        if (StringUtil.isEmpty(token)) {
            token = CookieUtils.getCookieValue(request, TOKEN);
        }
        // 从session中获取
        if (StringUtil.isEmpty(token)) {
            LoginUser loginUser = SessionManger.getSessionManger(request).getLoginUser();
            if (loginUser != null && !StringUtil.isEmpty(loginUser.getToken())) {
                token = loginUser.getToken();
            }
        }

        return token;
    }

    /**
     * 检查token是否有效
     *
     * @param token token
     * @return token有效时返回登录id
     */
    private LoginInfo checkToken(String token) {
        LoginInfo loginUser = null;
        if (!StringUtil.isEmpty(token)) {
            // session中存在登录用户信息是，连接SSO站点，check 本地session中的token是否还有效，
            // 因为存在其他服务器进行过登出操作的可能
            SsoParam param = new SsoParam();
            param.setToken(token);
            // 调用SSO接口验证token
            String checkUrl = StringUtil.formatMessage("{0}/api/v1/sso/checkToken", ConfigManager.getSsoUrlInside());
            SsoResult result = rsClient.postRsService(checkUrl, param, SsoResult.class);
            if (result != null && !StringUtil.isEmpty(result.getLoginId())) {
                loginUser = new LoginInfo();
                loginUser.setLoginId(result.getLoginId());
                loginUser.setUserType(result.getUserType());
            }
        }
        return loginUser;
    }

    /**
     * 获取session中的登录id
     *
     * @param request 请求
     * @return token
     */
    private static String getLoginIdFromSession(HttpServletRequest request) {
        String loginId = null;

        // 从session中获取
        LoginUser loginUser = SessionManger.getSessionManger(request).getLoginUser();
        if (loginUser != null) {
            loginId = loginUser.getEmplNo();
        }

        return loginId;
    }

    /**
     * 获取用户信息保存到session
     *
     * @param loginId 登录id
     * @param loginType 登录用户类型
     * @param token token
     * @param request 请求
     */
    private boolean doLogin(String loginId, String loginType, String token, HttpServletRequest request) {
        boolean result = false;

        // 登陸之前清除Session
        SessionManger.getSessionManger(request).invalidate();

        // 登录service
        RsRequest<SsoParam> rsParam = new RsRequest<>();
        rsParam.setLoginId("system");
        rsParam.setAuth("123456");
        rsParam.setSiteCode("bms");
        SsoParam param = new SsoParam();
        param.setToken(token);
        param.setLoginId(loginId);
        param.setUserType(loginType);
        rsParam.setParam(param);
        String checkUrl = StringUtil.formatMessage("{0}/api/v1/org/getLoginInfo", ConfigManager.getApiServerUrl());
        RsResponse<LoginUser> res = rsClient.postRsService(checkUrl, rsParam, LoginUser.class);
        LoginUser loginUser = null;
        if (res != null && BusinessConst.RsStatus.SUCCESS.equals(res.getStatus())) {
            loginUser = res.getResult();
        }
        if (loginUser != null) {
            loginUser.setToken(token);
            SessionManger.getSessionManger(request).setLoginUser(loginUser);
            result = true;
        }

        return result;
    }

    /**
     * 跳转到SSO登录画面
     *
     * @param request 请求
     * @param response 应答
     * @param flag 处理标记
     * @throws IOException
     */
    private void redirectToSslLogin(HttpServletRequest request, HttpServletResponse response, String flag)
        throws IOException {

        logger.debug("Identity not found, redirect to SSO.");

        // 本站点的根路径
        String port = "80";
        if (request.getServerPort() > 0) {
            port = StringUtil.toString(request.getServerPort());
        }
        String mainUrl = URLEncoder.encode(StringUtil.formatMessage("{0}://{1}:{2}/{3}/main", request.getScheme(),
            request.getServerName(), port, request.getContextPath()), "utf-8");

        // 跳转到sso登录画面
        String casURL;
        if (!StringUtil.isEmpty(flag)) {
            casURL = StringUtil.formatMessage("{0}/login?url={1}&flag={2}", ConfigManager.getSsoUrlOutside(), mainUrl,
                flag);
        } else {
            casURL = StringUtil.formatMessage("{0}/login?url={1}", ConfigManager.getSsoUrlOutside(), mainUrl);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head><title>timeout</title><script type=\"text/javascript\">");
        // sb.append(" document.cookie = '" + COOKIE_BOOKMARK_STORE + "=' + window.location.hash + '; path=/';");
        sb.append("window.location = '" + casURL + "' + window.location.hash;");
        sb.append("</script></head>");
        sb.append("<body/></html>");

        // response.setStatus(403);
        response.setContentType("text/html;charset=" + CHARACTER_ENCODING);
        response.setContentLength(sb.toString().getBytes(CHARACTER_ENCODING).length);
        response.getWriter().write(sb.toString());
    }

    /**
     * 跳转到系统模块选择画面
     *
     * @param response 应答
     * @param flag 处理标记
     * @throws IOException
     */
    private void redirectToMain(HttpServletResponse response, String flag) throws IOException {

        // 登录后显示系统模块选择页面
        String switchUrl;
        if (!StringUtil.isEmpty(flag)) {
            switchUrl = StringUtil.formatMessage("{0}/main?flag={1}", ConfigManager.getWebServerUrl(), flag);
        } else {
            switchUrl = StringUtil.formatMessage("{0}/main", ConfigManager.getWebServerUrl());
        }

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

}
