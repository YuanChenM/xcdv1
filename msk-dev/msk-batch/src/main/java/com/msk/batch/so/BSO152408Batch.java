package com.msk.batch.so;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.so.bean.BSO152408Param;
import com.msk.batch.so.logic.BSO152408Logic;
import com.msk.common.consts.StatusConst;
import com.msk.core.bean.BaseParam;
import com.msk.core.exception.BusinessException;
import com.msk.core.exception.SystemException;
import com.msk.so.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * *BSO152408Batch
 * *@author xu_wei
 * *@version 1.0
 **/
@Component("BSO152408")
public class BSO152408Batch extends BaseBatch{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSO152408Batch.class);

    /** 注入Order共通类 */
    @Autowired
    private Order orderComm;
    /** 注入BSO152408Logic */
    @Autowired
    private BSO152408Logic bso152408Logic;

    /**
     * 创建Param
     *
     * @param args String[]
     * @return BSO152408Param
     */
    @Override
    public BaseParam createParam(String[] args) {
        logger.debug("BSO152408Batch创建param");

        BSO152408Param param = new BSO152408Param();
        return param;
    }

    @Override
    public void doOperate(BaseParam param) {
        logger.debug("BSO152408Batch的doOperate");

        BSO152408Param bso152408Param = (BSO152408Param) param;
        try {
            bso152408Logic.findOrderList(bso152408Param);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
