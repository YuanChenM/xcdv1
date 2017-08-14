package com.msk.core.web.interceptor;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.msk.common.logic.ConfigLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.CommConfig;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.SpringContextUtil;
import com.msk.md.logic.DistrictAreaLogic;
import com.msk.org.logic.OrgSysPageLogic;
import com.msk.org.utils.OrgSysManager;
import com.msk.sso.client.constant.PasswordConfigServer;
import com.msk.sso.client.constant.SSORelevanceDefine;

/**
 * Application Listener
 * 
 * @author jiang_nan
 * 
 */
public class InitializerListener implements ServletContextListener {

    /**
     * 服务启动时,加载在内存中的数据
     * 
     * @param sce
     */
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("fileSerUrl", ConfigManager.getFtpHttpUrl());

        // 通过上下文取得行政区域的Logic,并加载全部行政区域的数据
        DistrictAreaLogic districtAreaLogic = SpringContextUtil.getBean("districtAreaLogic", DistrictAreaLogic.class);
        DistrictAreaLogic.setDistrictAreaBeans(districtAreaLogic.findList());

        // 通过上下文取得系统信息Logic,并加载系统信息的数据
        OrgSysPageLogic orgSysPageLogic = SpringContextUtil.getBean("orgSysPageLogic", OrgSysPageLogic.class);
        OrgSysManager.getInstance().initOrgSysModules(orgSysPageLogic.findSysModules());

        // 通过上下文取得配置信息Logic,并加载配置信息的数据
        ConfigLogic configLogic = SpringContextUtil.getBean("configLogic", ConfigLogic.class);
        BaseParam param = new BaseParam();
        List<CommConfig> configList = configLogic.findList(param);
        ConfigManager.initConfigValue(configList);


        SSORelevanceDefine.setServerName(ConfigManager.getServerName());
        sce.getServletContext().setAttribute("serverName", SSORelevanceDefine.getServerName());
        SSORelevanceDefine.setLoginEmployInfoServerUrl(ConfigManager.getOrgServer() + "/api/employ/info/_get");
        SSORelevanceDefine.setLoginSellerInfoServerUrl(ConfigManager.getSellerServer() + "/api/sl/slInfo/slAccount/search");
        //Update 菜单取得URL By jiang_nan Begin
        SSORelevanceDefine.setSearchMenuServerUrl(ConfigManager.getOrgServer()+"/api/org/user/menu/_search");
        //Update 菜单取得URL By jiang_nan End
        SSORelevanceDefine.setCasServerLoginUrl(ConfigManager.getSsoUrlInside()+"/login");
        SSORelevanceDefine.setCasServerLogoutUrl(ConfigManager.getSsoUrlInside()+"/logout");
        SSORelevanceDefine.setCasServerUrlPrefix(ConfigManager.getSsoUrlInside());
        SSORelevanceDefine.setSystemModuleServerUrl(ConfigManager.getOrgServer()+"/api/system/module/_search");
        SSORelevanceDefine.setMainJspPatch("/jsp/main/main.jsp");
        SSORelevanceDefine.setLoginUserInfoServerUrl(ConfigManager.getOrgServer()+"/api/login/user/_get");
        SSORelevanceDefine.setVersion(ConfigManager.getSystemVersion());
        SSORelevanceDefine.setDepartmentRole(ConfigManager.getOrgServer()+"/api/department/role/_search");

        //密码相关常量
        SSORelevanceDefine.setModifyPassword(ConfigManager.getOrgServer() + "/api/employ/password/_modify");
        PasswordConfigServer.setIsForceModifyPassword(Boolean.valueOf(ConfigManager.isForceModifyPassword().trim()));
        PasswordConfigServer.setIsCheckPasswordTimeSeries(Boolean.valueOf(ConfigManager.isCheckPasswordTimeSeries().trim()));
        PasswordConfigServer.setIsInitPassword(Boolean.valueOf(ConfigManager.isInitPassword().trim()));
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

}
