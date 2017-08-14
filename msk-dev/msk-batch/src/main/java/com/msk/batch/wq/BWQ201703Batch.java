package com.msk.batch.wq;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.wq.bean.BWQ201702Request;
import com.msk.batch.wq.logic.BWQ201703Logic;
import com.msk.core.bean.BaseParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/1/9 0009.
 */

/**
 * BWQ201703Batch.
 *
 * @author pxg
 */
@Component("BWQ201703")
public class BWQ201703Batch extends BaseBatch {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BWQ201703Batch.class);

    /**
     * 注入BWQ201703Logic
     */
    @Autowired
    private BWQ201703Logic beq201703Logic;

    /**
     * 创建Param
     *
     * @param args String[]
     * @return BWQ201703Param
     */
    @Override
    public BaseParam createParam(String[] args) {
        logger.debug("BWQ201703Batch创建param");
        BWQ201702Request param = new BWQ201702Request();
        return param;
    }

    /**
     * 业务处理
     *
     * @param param param
     */
    @Override
    public void doOperate(BaseParam param) {
        logger.debug("BWQ201703Batch的doOperate");
        String url="employee/v2/queryEmployee";
        String msgId="test11";
        beq201703Logic.queryEmployee(url,msgId);
    }
}

