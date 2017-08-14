package com.msk.batch.so;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.so.bean.BSO152405Param;
import com.msk.batch.so.logic.BSO152405Logic;
import com.msk.common.consts.StatusConst;
import com.msk.core.bean.BaseParam;
import com.msk.core.exception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wang_shuai on 2016/4/8.
 */
@Component("BSO152405")
public class BSO152405Batch extends BaseBatch {
    /**
     * logger
     */
    @Autowired
    private static Logger logger = LoggerFactory.getLogger(BSO152405Batch.class);
    /** 注入BSO152405Logic */
    @Autowired
    private BSO152405Logic bso152405Logic;

    /**
     * 创建Param
     *
     * @param args String[]
     * @return BSO152405Param
     */
    @Override
    public BaseParam createParam(String[] args){
        logger.debug("BSO152405Batch创建param");
        BSO152405Param param = new BSO152405Param();
        return param;
    }
    @Override
    public void doOperate(BaseParam param){
        logger.debug("BSO152405Batch的doOperate");
        BSO152405Param bso152405Param = (BSO152405Param) param;
        try {
            bso152405Logic.findReturnList(bso152405Param);
        }  catch (Exception e) {
            throw new SystemException(e);
        }


    }
}
