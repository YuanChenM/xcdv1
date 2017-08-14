package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.PdStandard;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.SL241117Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by gyh on 2016/3/11.
 */
public class SL241122Logic extends BaseLogic{

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(SL241117Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
