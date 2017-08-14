package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.pl.bean.IPL20170404Param;
import com.msk.pl.bean.IPL20170404RsPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@Service
public class IPL20170404Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Transactional(readOnly = true)
    public IPL20170404RsPageResult searchPdInfo(IPL20170404Param param) {
        IPL20170404RsPageResult result = new IPL20170404RsPageResult();
        if (param.isPaging()) {
            param.getStartPos();
        }
        List list  =  super.findPageList(param, result);
        result.setDataList(list);
        return result;
    }
}
