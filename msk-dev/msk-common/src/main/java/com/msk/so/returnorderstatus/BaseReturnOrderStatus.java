package com.msk.so.returnorderstatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msk.so.bean.ReturnOrderStatusParam;
import com.msk.so.logic.ReturnOrderStatusLogic;

/**
 * BaseReturnOrderStatus
 *
 * @author jiang_nan
 * @version 1.0
 **/
public abstract class BaseReturnOrderStatus {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BaseReturnOrderStatus.class);
    protected ReturnOrderStatusLogic returnOrderStatusLogic;
    protected ReturnOrderStatusParam returnOrderStatusParam;

    /**
     * 构造函数
     * @param returnOrderStatusLogic 退货单状态Logic
     * @param returnOrderStatusParam 退货单参数
     */
    public BaseReturnOrderStatus(ReturnOrderStatusLogic returnOrderStatusLogic, ReturnOrderStatusParam returnOrderStatusParam) {
        this.returnOrderStatusLogic = returnOrderStatusLogic;
        this.returnOrderStatusParam = returnOrderStatusParam;
    }

    /**
     * 更新退货单主表的数据
     */
    public void save(){

    }

    /**
     * 每种状态需要更新的退货单状态的业务数据
     */
    public abstract void handle();
}
