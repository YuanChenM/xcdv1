package com.msk.so.returnorderstatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msk.common.consts.StatusConst;
import com.msk.so.bean.ReturnOrderStatusParam;
import com.msk.so.logic.ReturnOrderStatusLogic;
import com.msk.so.logic.ReturnStatusLogic;

/**
 * ReturnOrderStatusContext
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Component
public class ReturnOrderStatusContext {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ReturnOrderStatusContext.class);
    private BaseReturnOrderStatus returnOrderStatus;
    @Autowired
    private ReturnOrderStatusLogic returnOrderStatusLogic;
    @Autowired
    private ReturnStatusLogic returnStatusLogic;

    /**
     *
     * @param param param
     */
    public void handle(ReturnOrderStatusParam param){
        logger.debug("退货单变更");
        int status = param.getNewStatus();
        if(StatusConst.ReturnOrderStatusDef.APPLY == status){//申请中
            this.returnOrderStatus = new ReturnOrderStatusApply(returnOrderStatusLogic,param);
        }else if(StatusConst.ReturnOrderStatusDef.PENDING_AUDIT == status){//待审核

        }else if(StatusConst.ReturnOrderStatusDef.HAVE_AUDITED == status){//已审核

        }else if(StatusConst.ReturnOrderStatusDef.WAIT_RECEIPT == status){//待收货
            this.returnOrderStatus = new ReturnOrderStatusWaitReceipt(returnOrderStatusLogic,param);
            ((ReturnOrderStatusWaitReceipt)this.returnOrderStatus).setReturnStatusLogic(returnStatusLogic);
        }else if(StatusConst.ReturnOrderStatusDef.RECEIPT == status){//已收货
            this.returnOrderStatus = new ReturnOrderStatusReceipt(returnOrderStatusLogic,param);
            ((ReturnOrderStatusReceipt)this.returnOrderStatus).setReturnStatusLogic(returnStatusLogic);
        }else if(StatusConst.ReturnOrderStatusDef.STORAGE == status){//入库
            this.returnOrderStatus = new ReturnOrderStatusStorage(returnOrderStatusLogic,param);
            ((ReturnOrderStatusStorage)this.returnOrderStatus).setReturnStatusLogic(returnStatusLogic);
        }else{

        }
        this.returnOrderStatus.handle();
    }
}
