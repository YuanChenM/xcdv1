package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.pl.bean.IPL20170224Param;
import com.msk.pl.bean.IPL20170224Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuhongyang on 2017/2/6.
 * 根据任务ID查询对应进货单
 */
@Service
public class IPL20170224Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public List<IPL20170224Result> findPlInfoList(IPL20170224Param param) {
        return super.findList(param);
    }

}
