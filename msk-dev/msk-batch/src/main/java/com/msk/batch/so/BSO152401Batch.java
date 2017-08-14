package com.msk.batch.so;

import java.util.Date;

import com.msk.batch.base.BaseBatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msk.batch.so.bean.BSO152401Param;
import com.msk.batch.so.logic.BSO152401Logic;
import com.msk.batch.so.logic.BSO152402Logic;
import com.msk.core.bean.BaseParam;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;

/**
 * BSO152401Batch.
 * 
 * @author yuan_chen
 */
@Component("BSO152401")
public class BSO152401Batch extends BaseBatch {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSO152402Logic.class);

    /** 注入BSO152401Logic */
    @Autowired
    private BSO152401Logic bso152401Logic;

    /**
     * 创建Param
     * 
     * @param args String[]
     * @return BSO152401Param
     */
    @Override
    public BaseParam createParam(String[] args) {
        logger.debug("BSO152401Batch创建param");

        BSO152401Param param = new BSO152401Param();

        Date currentDate = DateTimeUtil.getCustomerDate();
        param.setCurrentDate(currentDate);
        return param;
    }

    /**
     * 业务处理
     * 
     * @param param param
     */
    @Override
    public void doOperate(BaseParam param) {
        logger.debug("BSO152401Batch的doOperate");
        bso152401Logic.saveSalesRanking(param);
    }

}
