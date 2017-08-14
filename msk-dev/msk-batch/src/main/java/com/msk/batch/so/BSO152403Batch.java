package com.msk.batch.so;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.so.bean.BSO152402Param;
import com.msk.batch.so.bean.BSO152403Param;
import com.msk.batch.so.logic.BSO152402Logic;
import com.msk.batch.so.logic.BSO152403Logic;
import com.msk.common.consts.StatusConst;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SoOrder;
import com.msk.core.exception.BusinessException;
import com.msk.core.exception.SystemException;
import com.msk.so.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * *BSO152403Batch
 * *@author xu_wei
 * *@version 1.0
 **/
@Component("BSO152403")
public class BSO152403Batch extends BaseBatch{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSO152403Batch.class);

    /** 注入Order共通类 */
    @Autowired
    private Order orderComm;
    /** 注入BSO152403Logic */
    @Autowired
    private BSO152403Logic bso152403Logic;

    /**
     * 创建Param
     *
     * @param args String[]
     * @return BSO152403Param
     */
    @Override
    public BaseParam createParam(String[] args) {
        logger.debug("BSO152403Batch创建param");

        BSO152403Param param = new BSO152403Param();
        return param;
    }

    @Override
    public void doOperate(BaseParam param) {
        logger.debug("BSO152403Batch的doOperate");

        BSO152403Param bso152403Param = (BSO152403Param) param;
        bso152403Param.setOrderStatus(StatusConst.OrderStatusDef.CONFIRM);
        try {
            bso152403Logic.findOrderList(bso152403Param);
        } catch (BusinessException be) {
            // TODO 业务异常处理
            // throw new BusinessException(be.getMessage());
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
