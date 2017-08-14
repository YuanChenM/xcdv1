package com.msk.batch.so;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.so.bean.BSO152407Param;
import com.msk.batch.so.logic.BSO152407Logic;
import com.msk.common.consts.StatusConst;
import com.msk.core.bean.BaseParam;
import com.msk.core.exception.SystemException;
import com.msk.so.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * *BSO152407Batch
 * *@author xu_wei
 * *@version 1.0
 */
@Component("BSO152407")
public class BSO152407Batch extends BaseBatch {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSO152407Batch.class);

    /**
     * 注入Order共通类
     */
    @Autowired
    private Order orderComm;
    /**
     * 注入BSO152407Logic
     */
    @Autowired
    private BSO152407Logic bso152407Logic;

    /**
     * 创建Param
     *
     * @param args String[]
     * @return BSO152407Param
     */
    @Override
    public BaseParam createParam(String[] args) {
        logger.debug("BSO152407Batch创建param");

        BSO152407Param param = new BSO152407Param();
        return param;
    }

    @Override
    public void doOperate(BaseParam param) {
        logger.debug("BSO152407Batch的doOperate");

        BSO152407Param bso152407Param = (BSO152407Param) param;
        bso152407Param.setOrderStatus(StatusConst.OrderStatusDef.CONFIRM);
        try {
            bso152407Logic.findOrderList(bso152407Param);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
