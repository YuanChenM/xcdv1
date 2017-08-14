package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by gyh on 2016/3/24.
 */
public class ISL231184Logic extends BaseLogic{

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * SQL ID
     */
    interface SqlId {
        String SQL_ID_FIND_COUNT = "findCount";
    }
}
