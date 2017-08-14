package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.pl.bean.PlPdMst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@Service
public class IPL20170403Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        //查询当前日期之前的12个月的年月
        String SQL_ID_SEARCH_CLASSES = "searchClasses";
    }
    @Transactional(readOnly = true)
    public List<PlPdMst> searchClasses() {
        List<PlPdMst> list =super.findList(SqlId.SQL_ID_SEARCH_CLASSES,null);
        return list;
    }
}
