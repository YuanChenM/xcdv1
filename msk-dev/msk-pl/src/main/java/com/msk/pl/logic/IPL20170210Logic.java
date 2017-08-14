package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.utils.DateTimeUtil;
import com.msk.pl.bean.IPL20170206Param;
import com.msk.pl.bean.IPL20170206Result;
import com.msk.pl.bean.IPL20170210Param;
import com.msk.pl.bean.IPL20170210Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@Service
public class IPL20170210Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 进货单产品查询接口
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public IPL20170210Result findPdById(IPL20170210Param param) {
        return super.findOne(param);
    }

}
