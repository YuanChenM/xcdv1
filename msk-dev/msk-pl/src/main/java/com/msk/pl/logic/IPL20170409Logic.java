package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.pl.bean.IPL20170409Param;
import com.msk.pl.bean.IPL20170409Result;
import com.msk.pl.bean.PlDeclarePriceperiodMst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@Service
public class IPL20170409Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        String SQL_ID_search_Price_Period = "searchPricePeriod";
        String SQL_ID_search_Price_Period_By_Date = "searchPricePeriodByDate";
    }


    @Transactional(readOnly = true)
    public List<PlDeclarePriceperiodMst> searchPricePeriod(IPL20170409Param param) {
        List<PlDeclarePriceperiodMst> list = super.findList(SqlId.SQL_ID_search_Price_Period, param);
        return list;
    }

    @Transactional(readOnly = true)
    public IPL20170409Result searchPricePeriodByDate(BaseParam param) {
        IPL20170409Result result = super.findOne(SqlId.SQL_ID_search_Price_Period_By_Date, param);
        return result;
    }

}
