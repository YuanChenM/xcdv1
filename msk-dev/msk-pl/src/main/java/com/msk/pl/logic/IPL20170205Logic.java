package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.pl.bean.IPL20170205Param;
import com.msk.pl.bean.IPL20170205Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xuhongyang on 2017/2/6.
 * 进货单详细信息查询
 */
@Service
public class IPL20170205Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Transactional(readOnly = true)
    public IPL20170205Result findPlInfoById(IPL20170205Param param) {
        return super.findOne(param);
    }
}
