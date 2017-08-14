package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.pl.bean.IPL20170402Param;
import com.msk.pl.bean.IPL20170402Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@Service
public class IPL20170402Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        //查询当前日期之前的12个月的年月
        String SQL_ID_SEARCH_DECLARATIONS = "searchDeclarations";
    }

    @Transactional(readOnly = true)
    public List<IPL20170402Result> searchDeclarations(IPL20170402Param param) {
        List<IPL20170402Result> list = new ArrayList<>();
        list = super.findList(SqlId.SQL_ID_SEARCH_DECLARATIONS, param);
        return list;
    }

}
