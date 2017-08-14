package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.pl.bean.IPL20170207Param;
import com.msk.pl.bean.IPL20170207Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@Service
public class IPL20170207Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        static final String PL_SQL_ID_FIND_BUYER_INFO = "findBuyerInfo";
    }

    @Transactional(readOnly = true)
    public IPL20170207Result findBuyerInfo(IPL20170207Param param) {

        return  super.findOne(SqlId.PL_SQL_ID_FIND_BUYER_INFO, param);

    }
}
