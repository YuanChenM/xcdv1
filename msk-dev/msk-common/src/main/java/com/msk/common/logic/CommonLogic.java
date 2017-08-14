package com.msk.common.logic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.common.bean.BaseStatus;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.CommConstant;

/**
 * CommonLogic
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Service("commonLogic")
public class CommonLogic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(CommonLogic.class);

    /**
     * SQL Id
     */
    interface SqlId {
        /** 获得最大Max Id */
        String SQL_ID_MAX_ID = "maxId";
        /** 根据类型获取常量定义 */
        String SQL_ID_FIND_CONSTANT_LIST = "findConstantList";
    }

    /**
     * 获得Max Id
     * 
     * @param tableName 表名
     * @param tableFiled 字段名称
     * @return Max Id
     */
    @Transactional(readOnly = true)
    public Long maxId(String tableName, String tableFiled) {
        logger.debug("获得Max Id");
        BaseParam param = new BaseParam();
        param.setFilter("tableName", tableName);
        param.setFilter("tableFiled", tableFiled);
        return (Long) super.findObject(SqlId.SQL_ID_MAX_ID, param);
    }

    /**
     * 获取指定类型的常量定义结合
     *
     * @param constantType 常量类型
     * @return 定常量定义结合
     */
    public List<CommConstant> findConstantList(String constantType) {
        BaseParam param = new BaseParam();
        param.setFilter("type", constantType);
        return super.findList(SqlId.SQL_ID_FIND_CONSTANT_LIST, param);
    }

    /**
     * 更新共通状态方法
     * 
     * @param status 状态值
     */
    @Transactional
    public void changeStatus(BaseStatus status) {

    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
