package com.msk.batch.bp;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.bp.bean.BBP112213Param;
import com.msk.batch.bp.logic.BBP112213Logic;
import com.msk.core.bean.BaseParam;
import com.msk.core.exception.BusinessException;
import com.msk.core.exception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * BBP112213Batch.
 * 
 * @author peng_hao
 */
@Component("BBP112213")
public class BBP112213Batch extends BaseBatch {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BBP112213Batch.class);

    /** 注入BBP112213Logic */
    @Autowired
    private BBP112213Logic bbp112213Logic;

    /**
     * 创建Param
     * 
     * @param args String[]
     * @return baseParam baseParam
     */
    @Override
    public BaseParam createParam(String[] args) {

        BBP112213Param param  = new BBP112213Param();
        return param;
    }

    /**
     * 业务处理
     * 
     * @param baseParam baseParam
     */
    @Override
    public void doOperate(BaseParam baseParam) {
        logger.debug("BBP112213Batch的doOperate");
        try {
            bbp112213Logic.dataResolve(baseParam);
        } catch (BusinessException be) {
            // TODO 业务异常处理
            throw new BusinessException(be.getMessage());
            // continue;
        } catch (Exception e) {
            throw new SystemException(e);
        }

    }

}
