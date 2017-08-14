package com.msk.org.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msk.core.entity.OrgSysModule;
import com.msk.core.utils.StringUtil;

/**
 * ORG_SYS_MODULE系统模块数据管理类（单实例）
 *
 * Created by mabo on 2016/3/26.
 */
public class OrgSysManager {

    /** 单实例 */
    private static OrgSysManager instance = null;
    /** key:userType-sysCode, value:orgSysModule object */
    private Map<String, Map<String, OrgSysModule>> codeMap;
    /** key:userType-sysModule, value:orgSysModule object */
    private Map<String, Map<String, OrgSysModule>> moduleMap;

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(OrgSysManager.class);

    /**
     * 私有构造方法
     */
    private OrgSysManager() {
        this.codeMap = new HashMap<>();
        this.moduleMap = new HashMap<>();
    }

    /**
     * 获取单实例对象。
     * 
     * @return 单实例对象
     */
    public static OrgSysManager getInstance() {
        if (instance == null) {
            instance = new OrgSysManager();
        }
        return instance;
    }

    /**
     * 初始化系统模块数据。
     *
     * @param modules
     */
    public void initOrgSysModules(List<OrgSysModule> modules) {
        logger.debug("initOrgSysModules begin...");
        if (this.codeMap == null) {
            this.codeMap = new HashMap<>();
        } else {
            this.codeMap.clear();
        }
        if (this.moduleMap == null) {
            this.moduleMap = new HashMap<>();
        } else {
            this.moduleMap.clear();
        }
        if (modules != null && !modules.isEmpty()) {
            for (OrgSysModule module : modules) {
                if (module != null) {
                    // 先按登录用户区分，再按系统编号，构建Map
                    String userType = StringUtil.toSafeString(module.getLoginUserType());
                    if (!StringUtil.isEmpty(userType)) {
                        // 按系统编号的Map
                        Map<String, OrgSysModule> subMap1 = codeMap.get(userType);
                        if (subMap1 == null) {
                            subMap1 = new LinkedHashMap<>();
                            codeMap.put(userType, subMap1);
                            subMap1 = codeMap.get(userType);
                        }
                        if (!StringUtil.isEmpty(module.getSysCode())) {
                            subMap1.put(module.getSysCode(), module);
                        }
                        // 按系统代号的Map
                        Map<String, OrgSysModule> subMap2 = moduleMap.get(userType);
                        if (subMap2 == null) {
                            subMap2 = new LinkedHashMap<>();
                            moduleMap.put(userType, subMap2);
                            subMap2 = moduleMap.get(userType);
                        }
                        if (!StringUtil.isEmpty(module.getSysModule())) {
                            subMap2.put(module.getSysModule().toLowerCase(), module);
                        }
                    }
                }
            }
        }
        logger.debug("initOrgSysModules done.");
    }

    /**
     * 根据系统编码获取系统名称。
     *
     * @param userType 登录用户类型
     * @return 系统名称
     */
    public List<OrgSysModule> getSysModulesByUserType(String userType) {
        List<OrgSysModule> modules = null;

        if (this.moduleMap != null) {
            Map<String, OrgSysModule> subMap = this.moduleMap.get(userType);
            if (subMap != null) {
                modules = new ArrayList<>();
                for (OrgSysModule module : subMap.values()) {
                    modules.add(module);
                }
            }
        }

        return modules;
    }

    /**
     * 根据系统编码获取系统名称。
     *
     * @param userType 登录用户类型
     * @param sysModule 系统代码
     * @return 系统名称
     */
    public OrgSysModule getSysModuleByModule(String userType, String sysModule) {
        OrgSysModule module = null;

        if (this.moduleMap != null && !StringUtil.isEmpty(sysModule)) {
            Map<String, OrgSysModule> subMap = this.moduleMap.get(userType);
            if (subMap != null) {
                module = subMap.get(sysModule.toLowerCase());
            }
        }

        return module;
    }

    /**
     * 根据系统编码获取系统名称。
     * 
     * @param userType 登录用户类型
     * @param sysCode 系统编号
     * @return 系统名称
     */
    public String getSysNameByCode(String userType, String sysCode) {
        String sysName = null;

        if (this.codeMap != null) {
            Map<String, OrgSysModule> subMap = this.codeMap.get(userType);
            if (subMap != null) {
                OrgSysModule module = subMap.get(sysCode);
                if (module != null) {
                    sysName = module.getSysShowName();
                }
            }
        }

        return sysName;
    }

    /**
     * 根据系统编码获取系统名称。
     *
     * @param userType 登录用户类型
     * @param sysModule 系统代码
     * @return 系统名称
     */
    public String getSysNameByModule(String userType, String sysModule) {
        String sysName = null;

        if (this.moduleMap != null && !StringUtil.isEmpty(sysModule)) {
            Map<String, OrgSysModule> subMap = this.moduleMap.get(userType);
            if (subMap != null) {
                OrgSysModule module = subMap.get(sysModule.toLowerCase());
                if (module != null) {
                    sysName = module.getSysShowName();
                }
            }
        }

        return sysName;
    }
}
