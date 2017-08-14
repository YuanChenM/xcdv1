package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SellerProductLogic
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Service
public class SellerProductLogic extends BaseLogic{
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
