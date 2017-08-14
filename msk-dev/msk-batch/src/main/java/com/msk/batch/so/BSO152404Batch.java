package com.msk.batch.so;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.so.logic.BSO152404Logic;
import com.msk.core.bean.BaseParam;
import com.msk.core.exception.BusinessException;
import com.msk.core.exception.SystemException;
import com.msk.so.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * BSO152404Batch.
 * 
 * @author zhang_lingbo
 */
@Component("BSO152404")
public class BSO152404Batch extends BaseBatch {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSO152404Logic.class);

    /** 注入BSO152404Logic */
    @Autowired
    private BSO152404Logic bso152404Logic;


    /**
     * 创建Param
     * 
     * @param args String[]
     * @return BSO152402Param
     */
    @Override
    public BaseParam createParam(String[] args) {
        return new BaseParam();
    }

    /**
     * 业务处理
     * 
     * @param param param
     */
    @Override
    public void doOperate(BaseParam param) {
        logger.debug("BSO152404Batch的doOperate");

        try {
            bso152404Logic.stockTransfer();
        } catch (Exception e) {
            throw new SystemException(e);
        }

    }

}
