package com.msk.sl.logic;

import com.msk.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.utils.DateTimeUtil;
import com.msk.sl.bean.SlEpOemAuth;

@Service
public class SL24110310Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     *
     *
     *
     * @param basePageParam 参数
     * @param slCode 用户编码
     * @return PageResult
     *
     * @author xhy
     */
    public PageResult<SlEpOemAuth> findPages(BasePageParam basePageParam, String slCode) {
        basePageParam.setFilter("slCode", slCode);
        PageResult<SlEpOemAuth> page = super.findPage(basePageParam, SlEpOemAuth.class);
        for (SlEpOemAuth sl : page.getData()) {
            if(!StringUtil.isNullOrEmpty(sl.getAuthTermBeginString()) && !StringUtil.isNullOrEmpty(sl.getAuthTermEndString())){
                sl.setOnTime(sl.getAuthTermBeginString() + "~" +sl.getAuthTermEndString());
            }
            else{
                sl.setOnTime("");
            }
            //sl.setOnTime(DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, sl.getAuthTermBegin()) + "~" + DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, sl.getAuthTermEnd()));
        }
        return page;
    }

}
