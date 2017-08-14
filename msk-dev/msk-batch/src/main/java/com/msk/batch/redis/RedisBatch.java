package com.msk.batch.redis;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.redis.logic.RedisLogic;
import com.msk.core.bean.BaseParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * *RedisBatch
 * *@author jiang_nan
 * *@version 1.0
 **/
//@Component("Redis")
public class RedisBatch extends BaseBatch{
   // @Autowired
    private RedisLogic redisLogic;
    @Override
    public BaseParam createParam(String[] args) {
        return new BaseParam();
    }
    @Override
    public void doOperate(BaseParam param) {
        //redisLogic.initConfig();
    }
}
