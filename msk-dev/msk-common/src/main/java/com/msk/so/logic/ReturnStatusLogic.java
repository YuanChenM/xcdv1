package com.msk.so.logic;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.ReturnOrderStatusParam;

/**
 * ReturnOrderStatusLogic
 *
 * @author zhou_yajun
 * @version 1.0
 **/
public class ReturnStatusLogic extends BaseLogic {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(ReturnStatusLogic.class);
    
    /**
     * 
     * 更新退货单主表状态
     *
     * @param param param
     *
     */
    @Transactional
    public void modifyReturnStatus(ReturnOrderStatusParam param){
        logger.debug("跟新退货单主表");
        Date customerDate = DateTimeUtil.getCustomerDate();
        param.setUpdTime(customerDate);
        super.modify(param);
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
