package com.msk.bs.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by gyh on 2016/4/6.
 */
public class BS2101108Logic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * sql
     */
    interface SqlId {
        /**
         * 查询买家经营产品类别表
         */
        static final String SQL_ID_FIND_BY_BUYER_PD_CLA = "findByBuyerPdCla";
        /**
         * 查询买家产品销售对象表
         */
        static final String SQL_ID_FIND_BYBUYER_SALESTARGET = "findByBuyerSalestarget";
    }
}
