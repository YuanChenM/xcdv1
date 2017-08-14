package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PD141133Logic
 * @author pxg
 */
@Service
public class PD141133Logic extends BaseLogic {

    /**
     * SQL Map 中SQL ID定义
     * @author pxg
     */
    interface SqlId {
        String SQL_ID_FIND_FIND_ONE_CLASS = "findOneClass";
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
