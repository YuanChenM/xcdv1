package com.msk.so.returnorderstatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msk.so.bean.ReturnOrderStatusParam;
import com.msk.so.logic.ReturnOrderStatusLogic;
import com.msk.so.logic.ReturnStatusLogic;

/**
 * 退货单待收货
 *
 * @author jiang_nan
 * @version 1.0
 **/
public class ReturnOrderStatusWaitReceipt extends BaseReturnOrderStatus{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ReturnOrderStatusWaitReceipt.class);
    //更新退货单主表状态logic
    private ReturnStatusLogic returnStatusLogic;
    
    public ReturnOrderStatusWaitReceipt(ReturnOrderStatusLogic returnOrderStatusLogic, ReturnOrderStatusParam returnOrderStatusParam) {
        super(returnOrderStatusLogic, returnOrderStatusParam);
    }

    @Override
    public void handle() {
        logger.debug("退货单待收货");
        //退货单状态表状态更新
        this.returnOrderStatusLogic.modifyReturnStatus(this.returnOrderStatusParam);
        //退货单主表状态更新
        this.returnStatusLogic.modifyReturnStatus(this.returnOrderStatusParam);
    }
    /**
     * Get the returnStatusLogic.
     *
     * @return returnStatusLogic
     *
     */
    public ReturnStatusLogic getReturnStatusLogic() {
        return this.returnStatusLogic;
    }

    /**
     * Set the returnStatusLogic.
     *
     * @param returnStatusLogic returnStatusLogic
     *
     */
    public void setReturnStatusLogic(ReturnStatusLogic returnStatusLogic) {
        this.returnStatusLogic = returnStatusLogic;
    }
}
