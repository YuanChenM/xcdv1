/**
 * SO151501Logic.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;

/** 
 * SO151501Logic.
 *
 * @author rwf
 */
@Service
public class MS112101Logic extends BaseLogic {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(MS112101Logic.class);
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        logger.info("调用baseDao");
        super.setBaseDao(baseDao);
    }
}
