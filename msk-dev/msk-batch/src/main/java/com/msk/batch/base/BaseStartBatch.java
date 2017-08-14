package com.msk.batch.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.msk.core.exception.SystemException;

/**
 * base Start Batch
 * 
 * @author jiang_nan
 */
public abstract class BaseStartBatch {
    /**
     * Check Param
     * 
     * @param args param
     */
    public static void checkParam(String[] args) {
        if (args.length <= 0) {
            throw new SystemException("启动Batch的参数不正常");
        }
    }

    /**
     * 获得ApplicationContext
     * 
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        ApplicationContext context = new FileSystemXmlApplicationContext(
            new String[] { "classpath:/spring/application-context.xml", "classpath:/spring/mybatis-context.xml","classpath:/spring/restclient-context.xml" });
        return context;
    }

    /**
     * 加载Log信息
     */
    public static void loadLog() {

    }

    /**
     * 获得Batch.
     * 
     * @param context
     *        context
     * @param batchId
     *        batchId
     * @return Batch
     * @throws SystemException
     *         如果BatchId不存在的,启动失败
     */
    public static BaseBatch getBaseBatch(ApplicationContext context, String batchId) {
        BaseBatch batch = context.getBean(batchId, BaseBatch.class);
        if (batch == null) {
            throw new SystemException("启动的Batch ID[" + batchId + "]不正确。");
        }
        return batch;
    }

}
