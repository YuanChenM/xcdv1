package com.msk.org.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.msk.core.web.base.BaseController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * MainController
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Controller
public class MainController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(MainController.class);
    @RequestMapping(value = "{module}/mainDetail", method = {RequestMethod.POST,RequestMethod.GET})
    public String main(@PathVariable("module") String module,String url, String data, String title, Model model){
        //请求url
        model.addAttribute("url", url);
        //请求数据
        model.addAttribute("data", data);
        //窗口title
        model.addAttribute("title", title);
        return "mainDetail";
    }
//    /**
//     * logger
//     */
//    private static Logger logger = LoggerFactory.getLogger(MainController.class);
//
//    @Autowired
//    private SystemLogic systemLogic;
//    @Autowired
//    private AuthLogic authLogic;
//
//    /**
//     * 各系统的登录url直接转向main页面
//     *
//     * @param sysModule 系统模块
//     * @return 登陆页面
//     */
//    @RequestMapping(value = "{sysModule}/login",
//        method = RequestMethod.GET)
//    public String login(@PathVariable("sysModule") String sysModule) {
//        return this.redirect(StringUtil.formatMessage("/main"));
//    }
//
//    /**
//     * 进入系统模块选择画面
//     *
//     * @param flag 标志（reload表示重新选择）
//     * @return 登陆页面
//     */
//    @RequestMapping(value = "main")
//    public String switchSystem(String flag, Model model) {
//
//        // 获取所有的系统模块
//        List<OrgSysModule> showModules = new ArrayList<>();
//        String userType = this.getLoginUser().getUserType();
//        List<OrgSysModule> allModules = OrgSysManager.getInstance().getSysModulesByUserType(userType);
//        if (allModules != null && !allModules.isEmpty()) {
//            // 从session中获取据用户有权限的系统模块
//            List<OrgSysModule> authModules = this.getLoginUser().getSystemModules();
//            List<String> authSysModules = new ArrayList<>();
//            if (authModules != null && !authModules.isEmpty()) {
//                for (OrgSysModule module : authModules) {
//                    authSysModules.add(module.getSysModule().toLowerCase());
//                }
//            }
//            // 将用户没有全部部分的url清除
//            for (OrgSysModule module : allModules) {
//                OrgSysModule showModule = new OrgSysModule();
//                showModule.setSysCode(module.getSysCode());
//                showModule.setSysModule(module.getSysModule());
//                showModule.setSysShowName(module.getSysShowName());
//                if (authSysModules.contains(module.getSysModule().toLowerCase())) {
//                    showModule.setSysMainUrl(module.getSysMainUrl());
//                }
//                showModules.add(showModule);
//            }
//        }
//        model.addAttribute("modules", showModules);
//
//        // message设置
//        if ("reload".equals(flag)) {
//            model.addAttribute("message", "您在其他窗口再次登录过了，请重新选择需要操作的系统");
//        }
//
//        model.addAttribute("webServerUrl", ConfigManager.getWebServerUrl());
//        // 系统环境区分
//        model.addAttribute("systemEnv", ConfigManager.getSystemEnvTitle());
//        return "main/switch";
//    }
//
//    /**
//     * 显示主页面
//     *
//     * @param sysModule 系统模块
//     * @param model Model
//     * @return
//     */
//    @RequestMapping(value = "{sysModule}/main",
//        method = RequestMethod.POST)
//    public String main(@PathVariable("sysModule") String sysModule, Model model) {
//
//        // 用户类型（员工\卖家\..）
//        LoginUser loginUser = this.getLoginUser();
//        model.addAttribute("loginUser", loginUser);
//
//        // 用户菜单获取
//        String userType = loginUser.getUserType();
//        OrgSysModule module = OrgSysManager.getInstance().getSysModuleByModule(userType, sysModule);
//        if (module == null || StringUtil.isEmpty(module.getSysCode())) {
//            throw new PageNotFoundException();
//        }
//        List<SystemModel> systemList = systemLogic.findSystemList(module.getSysCode());
//        model.addAttribute("systemList", systemList); // TODO 准备改为authLogic
//
//        // 获取用户在该系统中有权限的按钮
//        List<ActionAuthority> actionList = authLogic.findAuthActions(module.getSysCode(), loginUser.getRoles());
//        loginUser.setActionList(actionList);
//
//        // 系统名
//        String sysName = StringUtil.toSafeString(OrgSysManager.getInstance().getSysNameByModule(userType, sysModule));
//        model.addAttribute("sysName", sysName);
//        // String sysModule = StringUtil.toSafeString(SessionManger.getSessionManger(request).getValue("systemModel"))
//        // .toLowerCase();
//        model.addAttribute("sysModule", sysModule.toLowerCase());
//        // 系统版本
//        model.addAttribute("systemVersion", ConfigManager.getSystemVersion());
//        // 系统环境区分
//        model.addAttribute("systemEnv", ConfigManager.getSystemEnvTitle());
//
//        logger.debug("进入Main Controller");
//        return "/main/main";
//    }
}
