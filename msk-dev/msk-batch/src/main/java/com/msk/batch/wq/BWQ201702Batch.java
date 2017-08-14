package com.msk.batch.wq;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.wq.bean.BWQ201702Request;
import com.msk.batch.wq.logic.BWQ201702Logic;
import com.msk.core.bean.BaseParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/1/9 0009.
 */

    /**
     * BWQ201702Batch.
     *
     * @author pxg
     */
    @Component("BWQ201702")
    public class BWQ201702Batch extends BaseBatch {

        /**
         * logger
         */
        private static Logger logger = LoggerFactory.getLogger(BWQ201702Batch.class);

        /**
         * 注入BWQ201702Logic
         */
        @Autowired
        private BWQ201702Logic beq201702Logic;

        /**
         * 创建Param
         *
         * @param args String[]
         * @return BWQ201702Param
         */
        @Override
        public BaseParam createParam(String[] args) {
            logger.debug("BWQ201702Batch创建param");
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
            logger.debug("BWQ201702Batch的doOperate");
            String url="employee/v2/queryEmployee";
            String msgId="test11";
            beq201702Logic.queryEmployee(url,msgId);
        }
}

