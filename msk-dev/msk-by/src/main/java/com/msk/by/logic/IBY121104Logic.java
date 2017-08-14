package com.msk.by.logic;

import com.msk.by.bean.IBY121104Bean;
import com.msk.by.bean.IBY121104RsParam;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * IBY121104Logic.
 *
 * @author yang_yang
 */
@Service
public class IBY121104Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBY121104Logic.class);

    /**
     * SQL Map 中SQL ID定义
     */
    interface SqlId {
        //获取菜场列表
        static String SQL_FIND_MARKER_FOOD_LIST = "findMarkerFoodList";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 获取菜场列表
     * @return
     */
    public List<IBY121104Bean> getMarkerList(IBY121104RsParam param) {

        logger.info("获取菜场列表开始");

        List<IBY121104Bean> markerList = this.findList(SqlId.SQL_FIND_MARKER_FOOD_LIST, param);

        logger.info("获取菜场列表结束");

        return markerList;
    }

}
