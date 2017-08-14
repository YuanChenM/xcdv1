package com.msk.by.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.MdDistrict;

/**
 * 区管理的Logic
 *
 * @author yuan_chen
 **/
@Service
public class BY121105Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BY121105Logic.class);

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
     * @param mdDistrict
     * @return
     */
    @Transactional
    public int abolish(MdDistrict mdDistrict) {
        return super.modify(SqlId.SQLID_UPDATE_ABOLISH, mdDistrict);
    }

    /**
     * 恢复数据
     * 
     * @param mdDistrict
     * @return
     */
    @Transactional
    public int restore(MdDistrict mdDistrict) {
        return super.modify(SqlId.SQLID_UPDATE_RESTORE, mdDistrict);
    }
}
