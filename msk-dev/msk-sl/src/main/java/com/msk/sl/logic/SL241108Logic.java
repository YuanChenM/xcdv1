package com.msk.sl.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.BaseEntity;

/**
 * SL241108Logic
 *
 * @author yuan_chen
 * @version 1.0
 **/
@Service
public class SL241108Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Transactional
    public int modifyExamine(String sqlId, BaseParam param) {
        BaseEntity entity = new BaseEntity();
        return this.modify(sqlId, entity);
    }
}
