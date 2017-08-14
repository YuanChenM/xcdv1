package com.msk.org.logic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.OrgSys;
import com.msk.core.entity.OrgSysModule;

/**
 * OrgSysPageLogic
 *
 * @author ma_b
 * @version 1.0
 **/
@Service
public class OrgSysPageLogic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrgSysPageLogic.class);

    /**
     * SqlId.
     *
     * @author gyh
     */
    interface SqlId {
        String SQL_ID_FIND_SYS = "findAllSys";
        String SQL_ID_FIND_MODULES = "findSysModules";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 获取全部的系统定义信息。
     *
     * @return 系统定义信息列表
     */
    public List<OrgSys> findAllSys() {
        BaseParam param = new BaseParam();
        return this.findList(SqlId.SQL_ID_FIND_SYS, param);
    }

    /**
     * 获取全部的系统定义信息。
     *
     * @return 系统定义信息列表
     */
    public List<OrgSysModule> findSysModules() {
        BaseParam param = new BaseParam();
        return this.findList(SqlId.SQL_ID_FIND_MODULES, param);
    }
}
