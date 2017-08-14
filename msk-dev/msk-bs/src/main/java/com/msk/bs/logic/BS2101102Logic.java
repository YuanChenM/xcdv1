package com.msk.bs.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 冻品管家列表
 * @author cx
 */
@Service
public class BS2101102Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
