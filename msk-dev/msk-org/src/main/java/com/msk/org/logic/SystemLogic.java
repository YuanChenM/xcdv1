package com.msk.org.logic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.OrgPage;
import com.msk.core.utils.DbUtils;
import com.msk.core.web.consts.BusinessConst;
import com.msk.org.bean.SystemModel;

/**
 * SystemLogic
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Service
public class SystemLogic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SystemLogic.class);

    interface SqlId {
        // String SQL_ID_COUNT_SYSTEM = "countSystem";
        String SQL_ID_GET_SYSTEM_NAME = "findSystemList";
        String SQL_ID_FIND_SUB_PAGE_LIST = "findSubPageList";
    }

    // /**
    // * 根据员工编码和系统编码判断当前用户是否有进入该系统的权限
    // *
    // * @param emplCode 员工编码
    // * @param systemCode 系统编码
    // * @return true:可以进入系统 false:不可以进入系统
    // */
    // @Transactional
    // public boolean checkSystemExists(String emplCode, String systemCode) {
    // logger.debug("根据员工编码和系统编码判断当前用户是否有进入该系统的权限");
    // BaseParam param = new BaseParam();
    // param.setFilter("emplCode", emplCode);
    // param.setFilter("sysCode", systemCode);
    // return super.getCount(SqlId.SQL_ID_COUNT_SYSTEM, param) > 0;
    // }

    @Transactional(readOnly = true)
    public List<SystemModel> findSystemList(String systemCode) {
        BaseParam param = new BaseParam();
        param.setFilter("systemCode", systemCode);
        if (!BusinessConst.Auth.ALL.equalsIgnoreCase(systemCode)) {
            DbUtils.buildLikeCondition(param, "systemCode", DbUtils.LikeMode.FRONT);
        }
        List<SystemModel> systemModelList = super.findList(SqlId.SQL_ID_GET_SYSTEM_NAME, param);
        if (!CollectionUtils.isEmpty(systemModelList)) {
            for (SystemModel systemModel : systemModelList) {
                List<OrgPage> pageList = this.findSubPageList(systemModel.getSysCode());
                systemModel.setPageList(pageList);
            }
        }
        return systemModelList;
    }

    /**
     * 获取指定系统的子页面（二级菜单）
     *
     * @param systemCode 系统编码
     * @return 层次结构的页面信息（一级菜单和二级菜单）
     */
    private List<OrgPage> findSubPageList(String systemCode) {
        BaseParam param = new BaseParam();
        param.setFilter("systemCode", systemCode);
        List<OrgPage> pageList = super.findList(SqlId.SQL_ID_FIND_SUB_PAGE_LIST, param);
        return pageList;
    }

    // /**
    // * 根据员工编码和系统编码判断当前用户是否有进入该系统的权限
    // *
    // * @param emplCode 员工编码
    // * @param systemCode 系统编码
    // * @return true:可以进入系统 false:不可以进入系统
    // */
    // @Transactional(readOnly = true)
    // public List<OrgSysModule> findSystemModules(String emplCode, String systemCode) {
    // return null;
    // }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
