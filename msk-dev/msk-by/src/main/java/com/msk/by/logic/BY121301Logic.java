package com.msk.by.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.ByMarketTerminal;

/**
 * BY121301Logic.
 *
 * @author yuan_chen
 */
@Service
public class BY121301Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BY121301Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     */
    interface SqlId {
        static String SQL_DELETE_MARKET_TERMINAL = "deleteMarkerTerminal";
    }


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

    @Transactional(readOnly = true)
    public ByMarketTerminal findMarketTerminalById(String marketId) {
        BaseParam param = new BaseParam();
        param.getFilterMap().put("marketId", marketId);
        return super.findOne(param);
    }

    @Transactional
    public int deleteMarketTerminalById(String marketId) {
        BaseParam param = new BaseParam();
        param.getFilterMap().put("marketId", marketId);
        return super.modify(SqlId.SQL_DELETE_MARKET_TERMINAL, param);
    }
}
