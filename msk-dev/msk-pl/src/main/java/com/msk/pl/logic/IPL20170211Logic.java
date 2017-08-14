package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.utils.DateTimeUtil;
import com.msk.pl.bean.IPL20170211Param;
import com.msk.pl.bean.PLInfoPd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@Service
public class IPL20170211Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    interface SqlId {
        static final String SQL_ID_MODIFY_ONE_PL_INFO = "modifyPlInfo";//获取每日任务最大id
        static final String PL_SQL_ID_MODIFY_PL_TASK = "modifyPlTask";

    }

    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public int deletePlPdInfo(IPL20170211Param param) {
        int delete  = super.modify(param);
        List<PLInfoPd> list = super.findList(param);
            if (list.size() == 0) {
                super.modify(SqlId.SQL_ID_MODIFY_ONE_PL_INFO, param);
                super.modify(SqlId.PL_SQL_ID_MODIFY_PL_TASK,param);
        }
        return delete;
    }

}
