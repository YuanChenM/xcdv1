package com.msk.batch.so;

import java.util.ArrayList;
import java.util.List;

import com.msk.batch.base.BaseBatch;
import com.msk.common.consts.StatusConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msk.batch.so.bean.BSO152402Param;
import com.msk.batch.so.logic.BSO152402Logic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SoOrder;
import com.msk.so.Order;
import org.springframework.util.CollectionUtils;

/**
 * BSO152402Batch.
 * 
 * @author yuan_chen
 */
@Component("BSO152402")
public class BSO152402Batch extends BaseBatch {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSO152402Logic.class);

    /** 注入BSO152402Logic */
    @Autowired
    private BSO152402Logic bso152402Logic;

    /** 注入Order共通类 */
    @Autowired
    private Order orderComm;

    /**
     * 创建Param
     * 
     * @param args String[]
     * @return BSO152402Param
     */
    @Override
    public BaseParam createParam(String[] args) {
        logger.debug("BSO152402Batch创建param");

        BSO152402Param param = new BSO152402Param();
        return param;
    }

    /**
     * 业务处理
     * 
     * @param param param
     */
    @Override
    public void doOperate(BaseParam param) {
        logger.debug("BSO152402Batch的doOperate");

        BSO152402Param bso152402Param = (BSO152402Param) param;
        bso152402Param.setOrderStatus(StatusConst.OrderStatusDef.WAIT_DISTRIBUTION);
        List<SoOrder> orders = orderComm.getOrdersByStatus(bso152402Param);
        List<SoOrder> newOrders = new ArrayList<SoOrder>();
        for (SoOrder soOrder : orders) {
            // Modify by wang_jianzhou for bug#3815 at 2016/11/30 Start.
            try {
                bso152402Param.setOrderId(soOrder.getOrderId());
                bso152402Param.setOrderStatus(soOrder.getOrderStatus());
                soOrder = bso152402Logic.distributionOrder(bso152402Param);
                if(null != soOrder){
                    newOrders.add(soOrder);
                }
            } catch (Exception e) {
                //throw new SystemException(e);
                logger.error(e.getMessage());
                bso152402Logic.updateOrderStatusToFalse(soOrder);
                continue;
            }
            // Modify by wang_jianzhou for bug#3815 at 2016/11/30 end.
        }
        if(!CollectionUtils.isEmpty(newOrders)){
            bso152402Logic.sendMail(newOrders);
        }
    }
}
