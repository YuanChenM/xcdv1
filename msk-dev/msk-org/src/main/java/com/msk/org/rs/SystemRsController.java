package com.msk.org.rs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msk.common.logic.ConfigLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.CommConfig;
import com.msk.core.utils.ConfigManager;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.org.logic.OrgSysPageLogic;
import com.msk.org.utils.OrgSysManager;

/**
 * 系统配置接口控制类
 *
 * @author ma_b
 * @version 1.0
 **/
@RestController
public class SystemRsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SystemRsController.class);

    @Autowired
    private ConfigLogic configLogic;
    @Autowired
    private OrgSysPageLogic orgSysLogic;

    /**
     * 重新读取数据库加载config配置并更新到内存中
     * 
     * @return 创建订单结果
     */
    @RequestMapping(value = "/api/v1/org/reload/config",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<String> reloadConfig() {
        logger.debug("reloadConfig");

        BaseParam param = new BaseParam();
        List<CommConfig> configList = configLogic.findList(param);
        ConfigManager.initConfigValue(configList);

        RsResponse<String> response = new RsResponse<>();
        response.setMessage("Reload Config OK.");
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setResult("Reload Config OK.");
        return response;
    }

    /**
     * 重新读取数据库加载config配置并更新到内存中
     *
     * @return 创建订单结果
     */
    @RequestMapping(value = "/api/v1/org/reload/system",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<String> reloadSystem() {
        logger.debug("reloadSystem");

        // 通过上下文取得系统信息Logic,并加载系统信息的数据
        OrgSysManager.getInstance().initOrgSysModules(orgSysLogic.findSysModules());

        RsResponse<String> response = new RsResponse<>();
        response.setMessage("Reload System Modules OK.");
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setResult("Reload System Modules OK.");
        return response;
    }

    /**
     * 获取系统环境区分和和系统版本号
     *
     * @return
     */
    @RequestMapping(value = "/api/v1/sys/getSysEnvVersion",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<Map<String, Object>> getSysEnvVersion() {
        String sysVersion = ConfigManager.getSystemVersion();
        String sysEnvName = ConfigManager.getSystemEnvTitle();
        String[] sysVersionArray = sysVersion.split("\\.");
        Map<String, Object> sysVersionMap = new HashMap<>();
        sysVersionMap.put("projectVersion", sysVersionArray[0] + "." + sysVersionArray[1]);
        sysVersionMap.put("svnVersion", sysVersionArray[2]);
        sysVersionMap.put("subSvnVersion", sysVersionArray[3]);
        sysVersionMap.put("buildTime", sysVersionArray[4]);
        sysVersionMap.put("sysEnvName", sysEnvName);
        RsResponse<Map<String, Object>> response = new RsResponse<Map<String, Object>>();
        response.setMessage("系统环境和版本获取成功");
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setResult(sysVersionMap);
        return response;
    }
}
