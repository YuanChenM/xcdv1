package com.msk.so.returnorderstatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msk.so.bean.ReturnOrderStatusParam;
import com.msk.so.logic.ReturnOrderStatusLogic;

/**
 * 退货单申请
 * @author jiang_nan
 * @version 1.0
 **/
public class ReturnOrderStatusApply extends BaseReturnOrderStatus{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ReturnOrderStatusApply.class);

    public ReturnOrderStatusApply(ReturnOrderStatusLogic returnOrderStatusLogic, ReturnOrderStatusParam returnOrderStatusParam) {
        super(returnOrderStatusLogic, returnOrderStatusParam);
    }

    @Override
    public void handle() {

    }
}
