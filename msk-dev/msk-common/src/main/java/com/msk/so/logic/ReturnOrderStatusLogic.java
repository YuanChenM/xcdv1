package com.msk.so.logic;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.entity.SoReturnOrderStatus;
import com.msk.core.exception.SystemException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.BaseReturnOrderParam;
import com.msk.so.bean.ReturnOrderStatusParam;

/**
 * ReturnOrderStatusLogic
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Service
public class ReturnOrderStatusLogic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ReturnOrderStatusLogic.class);

    @Autowired
    private CommonLogic commonlogic;
    
    /**
     * 
     * 订单全部取消操作
     *
     * @param returnOrderParam returnOrderParam
     *
     */
    @Transactional
    public void modifyOrderCancel(BaseReturnOrderParam returnOrderParam){
        logger.info("订单全部取消操作");

    }

    /**
     * 更新退货单状态
     * @param param 参数
     */
    @Transactional
    public void modifyReturnStatus(ReturnOrderStatusParam param){
        Long returnId = param.getReturnId();
        if(null == returnId || 0L == returnId){
            throw new SystemException("退货单状态变更,退货单ID不能为空");
        }
        Date customerDate = DateTimeUtil.getCustomerDate();
        param.setUpdTime(customerDate);
        super.modify(param);
        SoReturnOrderStatus soReturnOderStatus = new SoReturnOrderStatus();
        long id = commonlogic.maxId("SO_RETURN_ORDER_STATUS", "ID");
        soReturnOderStatus.setReturnId(param.getReturnId());
        soReturnOderStatus.setReturnCode(param.getReturnCode());
        soReturnOderStatus.setId(id);
        soReturnOderStatus.setStatus(param.getNewStatus());
        soReturnOderStatus.setCrtId(param.getCrtId());
        soReturnOderStatus.setCrtTime(customerDate);
        soReturnOderStatus.setUpdId(param.getUpdId());
        soReturnOderStatus.setUpdTime(customerDate);
        soReturnOderStatus.setActId(param.getActId());
        soReturnOderStatus.setActTime(customerDate);
        super.save(soReturnOderStatus);
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
