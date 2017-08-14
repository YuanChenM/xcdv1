package com.msk.org.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.msk.common.consts.CommCodeMasterConst;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.OrgSysModule;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.Md5Digest;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.bean.ActionAuthority;
import com.msk.core.web.bean.LoginRole;
import com.msk.core.web.bean.LoginUser;
import com.msk.core.web.consts.BusinessConst;
import com.msk.core.web.consts.CodeMasterConst;

/**
 * 权限操作Logic
 * 
 * @author jiang_nan
 * @version 1.0
 */
@Service
public class AuthLogic extends BaseLogic {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(AuthLogic.class);

    /**
     * SQL ID定义
     * 
     * @author jiang_nan
     */
    private interface SqlId {
        String LOGIN_SQL_ID = "authEmployee";
        String FIND_ROLE_LIST_SQL_ID = "findRoleList";
        String LOGIN_FOR_SUPPLIER_SQL_ID = "authSupplier"; // 供应商用户用
        String FIND_AUTH_MODULES = "findAuthModules"; // 有权限的系统模块
        String FIND_AUTH_PAGES = "findAuthPages"; // 有权限的页面和菜单
        String FIND_AUTH_ACTIONS = "findAuthActions"; // 有权限的按钮
    }

    // /**
    // * 权限类型的key
    // */
    // private interface MapKey {
    // String MAP_KEY_ACTION = "ACTION";
    // String MAP_KEY_MENU = "MENU";
    // String MAP_KEY_PAGE = "PAGE";
    // }

    /**
     * 登录用户名密码验证
     *
     * @param loginId 登录ID
     * @param loginPwd 登录密码
     * @param loginType 登录用户类型
     * @return 登录用户信息
     */
    @Transactional(readOnly = true)
    public LoginUser getUserInfo(String loginId, String loginPwd, String loginType) {
        LoginUser loginUser = null;
        // 根据用户类型进行登录验证
        if (CommCodeMasterConst.LoginUserType.EMPL.equals(loginType)) {
            // 员工登录
            loginUser = this.authEmployee(loginId, loginPwd);
        } else if (CommCodeMasterConst.LoginUserType.SELLER.equals(loginType)) {
            // 供应商登录
            loginUser = this.authSupplier(loginId, loginPwd);
        } else {
            // 默认员工登录
            loginUser = this.authEmployee(loginId, loginPwd);
            // loginInfo.setMessage("警告：参数中用户类型未设置，以员工身份进行认证");
        }

        return loginUser;
    }

    /**
     * 登录用户名密码验证
     * 
     * @param loginId 登录ID
     * @return 登陆用户信息
     */
    private LoginUser authEmployee(String loginId, String loginPwd) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("loginId", loginId);
        if (!StringUtil.isEmpty(loginPwd)) {
            paramMap.put("pwd", Md5Digest.digest(loginPwd));
        }
        paramMap.put("status", CodeMasterConst.LoginStatus.AVAILABLE);
        // 登陆验证用户名和密码
        LoginUser loginUser = super.findOne(SqlId.LOGIN_SQL_ID, paramMap);
        if (null == loginUser) {
            return null;
        }

        // 设置员工编码
        paramMap.put("emplId", loginUser.getEmplId());
        // 根据员工编号获得角色列表
        List<LoginRole> roleList = this.findList(paramMap, SqlId.FIND_ROLE_LIST_SQL_ID);
        if (!CollectionUtils.isEmpty(roleList)) {

            // 保存到session
            loginUser.setRoles(roleList);

            // 获取用户能访问的系统模块
            Map<String, Object> sqlParams = new HashMap<>();
            sqlParams.put("userType", BusinessConst.LoginUserType.EMPL); // 登录类型
            sqlParams.put("roleList", roleList); // 用户角色
            List<OrgSysModule> moduleList = this.findList(sqlParams, SqlId.FIND_AUTH_MODULES);
            loginUser.setSystemModules(moduleList);
        }
        return loginUser;
    }

    /**
     * 登录用户名密码验证(供应商用)
     *
     * @param loginId 登录ID
     * @param loginPwd 登陆密码
     * @return 登陆用户信息
     */
    private LoginUser authSupplier(String loginId, String loginPwd) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("loginId", loginId);
        paramMap.put("status", '2'); // 2:已认证
        paramMap.put("pwd", loginPwd);
        paramMap.put("sellerDeptId", ConfigManager.getSupplierDeptId()); // 卖家的部门ID
        // String md5Pwd = Md5Digest.digest(loginPwd);
        // 登陆验证用户名和密码
        LoginUser loginUser = super.findOne(SqlId.LOGIN_FOR_SUPPLIER_SQL_ID, paramMap);
        if (null == loginUser) {
            return null;
        }

        // 获取卖家的角色列表（固定）
        List<LoginRole> roleList = new ArrayList<>();
        LoginRole role = new LoginRole();
        role.setRoleNo(ConfigManager.getSupplierRoleId());
        roleList.add(role);

        // 保存到session
        loginUser.setRoles(roleList);

        // 获取用户能访问的系统模块
        Map<String, Object> sqlParams = new HashMap<>();
        sqlParams.put("userType", loginUser.getUserType()); // 登录类型
        sqlParams.put("roleList", roleList); // 用户角色
        List<OrgSysModule> moduleList = this.findList(sqlParams, SqlId.FIND_AUTH_MODULES);
        loginUser.setSystemModules(moduleList);

        return loginUser;
    }

    /**
     * 根据角色获取指定系统内所有有权限的按钮
     * 
     * @param sysCode 系统code
     * @param roleList 角色列表
     * @return 有权限的按钮列表
     */
    public List<ActionAuthority> findAuthActions(String sysCode, List<LoginRole> roleList) {
        // 获取用户能访问的Action
        Map<String, Object> sqlParams = new HashMap<>();
        sqlParams.put("sysCode", sysCode); // 系统code
        sqlParams.put("sysCodeLike", DbUtils.buildLikeCondition(sysCode)); // 前方一致的系统code
        sqlParams.put("roleList", roleList); // 用户角色
        List<ActionAuthority> actionList = this.findList(sqlParams, SqlId.FIND_AUTH_ACTIONS);
        return actionList;
    }

    /*
     * (non-Javadoc)
     * @see com.snk.core.base.BaseLogic#setBaseDao(com.snk.core.base.BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
