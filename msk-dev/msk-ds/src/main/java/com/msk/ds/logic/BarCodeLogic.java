package com.msk.ds.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.TempBarcode;

/**
 * BarCodeLogic.
 *
 * @author yuan_chen
 */
@Service
public class BarCodeLogic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BarCodeLogic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     */
    interface SqlId {
        static String SQL_DELETE = "delete";
    }

    /**
     * (non-Javadoc)
     *
     * @see BaseLogic#setBaseDao(BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Transactional
    public int delete(TempBarcode param) {
        return super.modify(SqlId.SQL_DELETE, param);
    }
}
