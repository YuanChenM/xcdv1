package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.so.bean.ISO151404RsParam;
import com.msk.so.bean.ISO151404RsResult;
import com.msk.so.bean.SellerListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * *ISO151404Logic
 * *@author sunjiaju
 * *@version 1.0
 **/
public class ISO151404Logic extends BaseLogic{
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 查询订单卖家详细信息
     * @param param
     */
    @Transactional(readOnly = true)
    public ISO151404RsResult getCount(ISO151404RsParam param){
        return super.findOne(SqlId.SQL_ID_GET_COUNT, param);
    }

    interface SqlId {
        String SQL_ID_GET_COUNT = "getCount";
    }
}
