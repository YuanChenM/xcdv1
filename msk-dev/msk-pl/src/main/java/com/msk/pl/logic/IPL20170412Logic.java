package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.pl.bean.IPL20170412Param;
import com.msk.pl.bean.IPL20170412Result;
import com.msk.pl.bean.IPL20170412RsPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@Service
public class IPL20170412Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        String SQL_ID_SEARCH_TASK = "searchTask";
    }

    @Transactional(readOnly = true)
    public IPL20170412RsPageResult searchTask(IPL20170412Param param) {
        IPL20170412RsPageResult result = new IPL20170412RsPageResult();
        if (param.isPaging()) {
            param.getStartPos();
        }
        List<IPL20170412Result> taskList = super.findPageList(param, result);
        IPL20170412Param taskParam;
        for (IPL20170412Result bean : taskList) {
            taskParam = new IPL20170412Param();
            taskParam.setCrtDate(bean.getCrtDate());
            taskParam.setPartnerId(bean.getPartnerId());
            taskParam.setBsCode(bean.getBsCode());
            taskParam.setTaskId(bean.getTaskId());
            int count = super.getCount(SqlId.SQL_ID_SEARCH_TASK, taskParam);
            if (count > NumberConst.IntDef.INT_ZERO) {
                //0未完成
                bean.setStatus("0");
            } else {
                //1已完成
                bean.setStatus("1");
            }
        }
        result.setDataList(taskList);
        return result;
    }

}
