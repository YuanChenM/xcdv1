package com.msk.common.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/3/30.
 */
@Service
public class ConfigLogic extends BaseLogic{

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
