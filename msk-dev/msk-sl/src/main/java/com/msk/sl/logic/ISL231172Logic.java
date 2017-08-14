package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.PdTcProvider;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cx on 2016/3/10.
 */
public class ISL231172Logic extends BaseLogic {


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 卖家申请新产品品种/特征/净重
     * @param pdTcProvider
     * @return
     */
    public int saveSLPdBFW(PdTcProvider pdTcProvider) {
        return super.save(pdTcProvider);
    }
}
