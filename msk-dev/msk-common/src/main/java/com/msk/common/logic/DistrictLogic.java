package com.msk.common.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DistrictLogic
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Service("districtLogic")
public class DistrictLogic extends BaseLogic{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(DistrictLogic.class);
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
