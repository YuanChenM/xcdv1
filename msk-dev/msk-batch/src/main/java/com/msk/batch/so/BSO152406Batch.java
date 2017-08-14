package com.msk.batch.so;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.so.bean.BSO152406Param;
import com.msk.batch.so.logic.BSO152406Logic;
import com.msk.common.consts.StatusConst;
import com.msk.core.bean.BaseParam;
import com.msk.core.exception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * *BSO152406Batch
 * *@author sunjiaju
 * *@version 1.0
 **/
@Component("BSO152406")
public class BSO152406Batch extends BaseBatch{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSO152406Batch.class);

    /** 注入BSO152406Logic */
    @Autowired
    private BSO152406Logic bso152406Logic;

    /**
     * 创建Param
     *
     * @param args String[]
     * @return BSO152406Param
     */
    @Override
    public BaseParam createParam(String[] args) {
        logger.debug("BSO152406Batch创建param");

        BSO152406Param param = new BSO152406Param();
        return param;
    }

    @Override
    public void doOperate(BaseParam param) {
        logger.debug("BSO152406Batch的doOperate");
        BSO152406Param bso152406Param = (BSO152406Param) param;
        bso152406Param.setShipStatus(StatusConst.OrderShipStatusDef.WAIT_CANCEL);
        try {
            bso152406Logic.cancelShip(bso152406Param);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
