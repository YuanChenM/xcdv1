package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DecimalUtil;
import com.msk.pl.bean.IPL20170411Param;
import com.msk.pl.bean.IPL20170411Result;
import com.msk.pl.bean.IPL20170411RsPageResult;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@Service
public class IPL20170411Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        String SQL_ID_SEARCH_TASK_COUNT = "searchTaskCount";
    }

    @Transactional(readOnly = true)
    public IPL20170411RsPageResult searchTaskInfo(IPL20170411Param param) {

        IPL20170411RsPageResult result = new IPL20170411RsPageResult();
        if (param.isPaging()) {
            param.getStartPos();
        }

        List<IPL20170411Result> taskList = super.findPageList(param, result);
        IPL20170411Param totalParam;
        IPL20170411Param alreadyParam;

        if (CollectionUtils.isNotEmpty(taskList)) {
            for (int i = 0; i < taskList.size(); i++) {
                IPL20170411Result bean = taskList.get(i);
                totalParam = new IPL20170411Param();
                alreadyParam = new IPL20170411Param();
                totalParam.setPartnerId(param.getPartnerId());
                //查询每个买家下已完成的数量
                alreadyParam.setCountFlg("1");
                alreadyParam.setSelectRule(param.getSelectRule());
                alreadyParam.setPartnerId(param.getPartnerId());
                alreadyParam.setCrtDate(param.getCrtDate());
                alreadyParam.setTerminalId(bean.getTerminalId());
                alreadyParam.setBsCode(bean.getBsCode());
                int already = super.getCount(SqlId.SQL_ID_SEARCH_TASK_COUNT, alreadyParam);
                taskList.get(i).setAlreadyRecordNumber(already);
                //获取任务数量
                totalParam.setSelectRule(param.getSelectRule());
                totalParam.setPartnerId(param.getPartnerId());
                totalParam.setCrtDate(param.getCrtDate());
                totalParam.setTerminalId(bean.getTerminalId());
                totalParam.setBsCode(bean.getBsCode());
                int total = super.getCount(SqlId.SQL_ID_SEARCH_TASK_COUNT, totalParam);
                taskList.get(i).setNeedRecordNumber(total);
                //无效完成数量
                int invalidInfo = total - already;
                taskList.get(i).setInvalidInfo(invalidInfo);
                //实际完成数量百分比
                BigDecimal number = DecimalUtil.divide(new BigDecimal(already), new BigDecimal(total));
                BigDecimal percent = DecimalUtil.multiplyWithNScale(number, new BigDecimal(NumberConst.IntDef.INT_HUNDRED), 2);
                taskList.get(i).setPercent(percent);
            }

            Collections.sort(taskList, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    IPL20170411Result map1 =(IPL20170411Result)o1;
                    IPL20170411Result map2 =(IPL20170411Result)o2;
                    int compare = DecimalUtil.getBigDecimal(map1.getPercent()).compareTo(DecimalUtil.getBigDecimal(map2.getPercent()));
                    if (compare == -1) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });

        }

        result.setBsTaskList(taskList);
        return result;
    }

}
