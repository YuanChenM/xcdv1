package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.PdTcProviderPackage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cx on 2016/3/10.
 */
public class ISL231173Logic extends BaseLogic {


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 卖家申请新产品包装
     * @param pdTcProviderPackage
     * @return
     */
    public int saveSLPdPkg(PdTcProviderPackage pdTcProviderPackage) {
        return super.save(pdTcProviderPackage);
    }
}
