package com.msk.by.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.MdCity;

/**
 * 城市地区管理的Logic
 *
 * @author yuan_chen
 **/
@Service
public class BY121104Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BY121104Logic.class);

    /**
     * sqlId
     */
    interface SqlId {
        public String SQLID_UPDATE_ABOLISH = "abolish";
        public String SQLID_UPDATE_RESTORE = "restore";
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

    /**
     * 废除数据
     * 
     * @param mdCity
     * @return
     */
    @Transactional
    public int abolish(MdCity mdCity) {
        return super.modify(SqlId.SQLID_UPDATE_ABOLISH, mdCity);
    }

    /**
     * 恢复数据
     * 
     * @param mdCity
     * @return
     */
    @Transactional
    public int restore(MdCity mdCity) {
        return super.modify(SqlId.SQLID_UPDATE_RESTORE, mdCity);
    }
}
