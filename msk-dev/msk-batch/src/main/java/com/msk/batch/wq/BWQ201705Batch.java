package com.msk.batch.wq;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.wq.bean.BWQ201701Bean3;
import com.msk.batch.wq.bean.BWQ201701Param;
import com.msk.batch.wq.bean.BWQ201702Request;
import com.msk.batch.wq.bean.WqResponse;
import com.msk.batch.wq.logic.BWQ201701Logic;
import com.msk.batch.wq.logic.BWQ201705Logic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */

/**
 * BWQ201705Batch.
 *
 * @author pxg
 */
@Component("BWQ201705")
public class BWQ201705Batch extends BaseBatch {
    private static Logger logger = LoggerFactory.getLogger(BWQ201705Batch.class);

    /**
     * 注入BWQ201705Logic
     */
    @Autowired
    private BWQ201705Logic beq201705Logic;

    /**
     * 创建Param
     * @param args String[]
     * @return BWQ201705Param
     */
    @Override
    public BaseParam createParam(String[] args) {
        logger.debug("BWQ201705Batch创建param");
        BWQ201702Request param = new BWQ201702Request();
        return param;
    }

    /**
     * 业务处理
     * @param param param
     */
    @Override
    public void doOperate(BaseParam param) {
        //查询外勤客户表数据，拉取最新
        beq201705Logic.queryWqCustomer();
        logger.debug("BWQ201705Batch的doOperate");
        String url="userDefined/v1/queryUserDefined";
        String msgId="test11";
        beq201705Logic.queryUserDefined(url,msgId);
    }
}

