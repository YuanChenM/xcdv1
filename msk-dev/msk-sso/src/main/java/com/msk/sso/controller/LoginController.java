package com.msk.sso.controller;

import org.springframework.stereotype.Controller;

import com.msk.core.web.base.BaseController;

/**
 * 单点登录login页面的控制器
 *
 * @version 1.0
 **/
@Controller
public class LoginController extends BaseController {

//    /** 日志 */
//    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
//
//    @Autowired
//    private RsClientUtil rsClient;
//
//    /**
//     * 进入登陆页面
//     *
//     * @param request 请求
//     * @return 登陆页面
//     */
//    @RequestMapping(value = "/")
//    public String login(HttpServletRequest request) {
//        if (request != null && "POST".equals(request.getMethod())) {
//            // 进入系统模块选择页面
//            return this.forward("/main");
//        } else {
//            // 进入登陆页面
//            return this.redirect("/login");
//        }
//    }
//
//    /**
//     * 进入登陆页面
//     *
//     * @param param 登录参数
//     * @param flag 标志（timeout表示登录超时）
//     * @param model 数据模型
//     * @param request 请求
//     * @return 登陆页面
//     */
//    @RequestMapping(value = "login",
//        method = RequestMethod.GET)
//    public String login(SsoParam param, String flag, Model model, HttpServletRequest request) {
//
//        // 获取登录用户类型用于初始化选择项
//        // 设置登录用户类型的下拉框
//        List<LoginType> types = getUserTypes(param);
//        model.addAttribute("userTypes", types);
//
//        // 登录id
//        String loginId = param.getLoginId();
//        if (StringUtil.isEmpty(loginId)) {
//            // 参数中没有时，尝试使用cookie中的
//            loginId = CookieUtils.getCookieValue(request, "msk.loginId");
//        }
//        // 登录类型
//        String loginType = param.getUserType();
//        if (StringUtil.isEmpty(loginType)) {
//            // 参数中没有时，尝试使用cookie中的
//            loginType = CookieUtils.getCookieValue(request, "msk.loginType");
//        }
//
//        // 参数的显示
//        SsoResult result = new SsoResult();
//        result.setLoginId(StringUtil.toSafeString(loginId));
//        result.setUserType(StringUtil.toSafeString(loginType));
//        if (param != null) {
//            result.setEnv(StringUtil.toSafeString(param.getEnv()));
//            result.setUrl(StringUtil.toSafeString(param.getUrl()));
//        }
//        // 如果有消息
//        if ("timeout".equals(flag)) {
//            result.setMessage("未登录或登录已超时，请重新登录。");
//        }
//        model.addAttribute("result", result);
//
//        // 系统环境区分
//        model.addAttribute("systemEnv", ConfigManager.getSystemEnvTitle());
//
//        return "sso/login";
//    }
//
//    /**
//     * 获取登录用户类型用于初始化选择项
//     *
//     * @param param 登录参数
//     * @return 登录用户类型
//     */
//    private List<LoginType> getUserTypes(SsoParam param) {
//
//        // 首先判断内存中的登录类型是否需要reload
//        LoginTypeManager manager = LoginTypeManager.getInstance(param.getEnv());
//        if (manager.needReload()) {
//            // 通过接口从客户系统获取用户类型的选项
//            // 注：没有类型或只有一种类型时，页面不显示选择框
//            // TODO
//            String url = StringUtil.formatMessage("{0}/api/v1/org/getLoginType", ConfigManager.getApiServerUrl());
//            RsRequest<SsoParam> rsParam = new RsRequest<>();
//            rsParam.setLoginId("system");
//            rsParam.setAuth("123456");
//            rsParam.setSiteCode("bms");
//            rsParam.setParam(param);
//            RsResponse<LoginTypeResult> rsResult = rsClient.postRsService(url, rsParam, LoginTypeResult.class);
//            if (rsResult != null && rsResult.getResult() != null) {
//                LoginTypeResult loginTypeResult = rsResult.getResult();
//                manager.set(loginTypeResult.getLoginTypes());
//            }
//        }
//        List<LoginType> types = manager.get();
//        if (types == null || types.isEmpty()) {
//            // 如果没有设置，默认只有员工类型
//            types = new ArrayList<>();
//            types.add(new LoginType(BusinessConst.LoginUserType.EMPL, BusinessConst.LoginUserType.EMPL_NAME));
//        }
//        return types;
//    }
//
//    /**
//     * 进入登录页面
//     *
//     * @param param 登录参数
//     * @param model 数据模型
//     * @param response 应答
//     * @return 登陆页面
//     */
//    @RequestMapping(value = "login",
//        method = RequestMethod.POST)
//    @Validator(validatorClass = "com.msk.sso.validator.LoginValidator")
//    public String doLogin(SsoParam param, Model model, HttpServletResponse response) {
//        String viewPath;
//
//        // TODO url从config文件中根据env获取
//        String createUrl = StringUtil.formatMessage("{0}/api/v1/sso/createToken", ConfigManager.getSsoUrlInside());
//        SsoResult result = rsClient.postRsService(createUrl, param, SsoResult.class);
//        model.addAttribute("result", result);
//        if (result != null && !StringUtil.isEmpty(result.getToken())) {
//            if (!StringUtil.isEmpty(param.getUrl())) {
//                result.setUrl(param.getUrl());
//            } else {
//                // 默认页面
//                // TODO 做成配置
//                String defaultPageUrl = StringUtil.formatMessage("{0}/main", ConfigManager.getWebServerUrl());
//                result.setUrl(defaultPageUrl);
//            }
//
//            // 设置cookie，便于记住登录信息
//            CookieUtils.setCookieValue(response, "msk.loginId", param.getLoginId());
//            CookieUtils.setCookieValue(response, "msk.loginType", param.getUserType());
//            CookieUtils.setCookieValue(response, "token", result.getToken());
//
//            viewPath = "sso/redirect";
//        } else {
//            result.setUserType(param.getUserType());
//            result.setLoginId(param.getLoginId());
//
//            // 获取登录用户类型用于初始化选择项
//            // 设置登录用户类型的下拉框
//            List<LoginType> types = getUserTypes(param);
//            model.addAttribute("userTypes", types);
//
//            viewPath = "sso/login";
//        }
//
//        // 系统环境区分
//        model.addAttribute("systemEnv", ConfigManager.getSystemEnvTitle());
//        model.addAttribute("webServerUrl", ConfigManager.getWebServerUrl());
//
//        return viewPath;
//    }
//
//    /**
//     * 退出操作
//     *
//     * @param request 请求
//     * @param response 应答
//     * @return 登陆页面
//     */
//    @RequestMapping(value = "logout",
//        method = RequestMethod.POST)
//    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        // 获取登录信息
//        String loginId = null;
//        String token = null;
//        LoginUser loginUser = this.getLoginUser();
//        if (loginUser != null) {
//            loginId = this.getLoginUser().getEmplNo();
//            token = this.getLoginUser().getToken();
//        }
//        // session中没有token时，从cookie中获取
//        if (StringUtil.isEmpty(token)) {
//            token = CookieUtils.getCookieValue(request, "token");
//        }
//        // session中没有token时，从cookie中获取
//        if (StringUtil.isEmpty(loginId)) {
//            loginId = CookieUtils.getCookieValue(request, "msk.loginId");
//        }
//
//        // 调用sso接口清除token
//        if (!StringUtil.isEmpty(token)) {
//            String logoutUrl = StringUtil.formatMessage("{0}/api/v1/sso/clearToken", ConfigManager.getSsoUrlInside());
//            SsoParam param = new SsoParam();
//            param.setLoginId(loginId);
//            param.setToken(token);
//            rsClient.postRsService(logoutUrl, param, SsoResult.class);
//        }
//
//        // 清除Session值
//        SessionManger.getSessionManger(request).invalidate();
//        // 清除Cookie值
//        CookieUtils.removeCookie(request, response, "token");
//
//        return redirect("/login");
//    }
}
