package com.msk.by.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.entity.ByMarketFood;
import com.msk.core.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * BY121306Logic.
 *
 * @author zhou_ling
 */
@Service
public class BY121306Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BY121306Logic.class);

    @Autowired
    private CommonLogic commonLogic;


    /**
     * (non-Javadoc)
     *
     * @see BaseLogic#setBaseDao(BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_Ling
     */
    interface SqlId {
        //菜场详细信息获取
        static String SQL_FOOD_MARKET_DETAIL_INFO_FIND = "findFoodMarketInfo";
        //菜场详细信息更新
        static String SQL_FOOD_MARKET_DETAIL_INFO_SAVE = "saveFoodMarketInfo";
        //菜场详细信息增加
        static String SQL_FODMARKET_DETAIL_INFO_ADD = "addFodMarketInfo";
    }

    /**
     * 菜场详细信息查询接口
     *
     * @param fodMarketId fodMarketId
     * @return
     */
    @Transactional(readOnly = true)
    public ByMarketFood findMarketFood(String fodMarketId) {
        BasePageParam inParam = new BasePageParam();
        inParam.setFilter("fodMarketId", fodMarketId);
        ByMarketFood byMarketFood = super.findOne(SqlId.SQL_FOOD_MARKET_DETAIL_INFO_FIND, inParam);
        return byMarketFood;
    }


    /**
     * 菜场详细信息更新
     * @param byMarketFood
     * @return
     */
    public int byMarketFoodModify(ByMarketFood byMarketFood){

        // 更新市场详细信息
        byMarketFood.setUpdId("admin");
        byMarketFood.setUpdTime(DateTimeUtil.getCustomerDate());
        int count = super.save(SqlId.SQL_FOOD_MARKET_DETAIL_INFO_SAVE, byMarketFood);
        return count;
    }

    /**
     * 菜场详细信息增加
     * @param byMarketFood
     * @return
     */
    public int byMarketFodAdd(ByMarketFood byMarketFood){

        // 增加菜场详细信息
        byMarketFood.setCrtId("admin");
        byMarketFood.setCrtTime(DateTimeUtil.getCustomerDate());
        int count = super.save(SqlId.SQL_FODMARKET_DETAIL_INFO_ADD, byMarketFood);
        return count;
    }
}
