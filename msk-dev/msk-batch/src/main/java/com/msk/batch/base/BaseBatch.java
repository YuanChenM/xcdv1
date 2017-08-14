package com.msk.batch.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.msk.batch.base.logic.BatchRecordLogic;
import com.msk.common.consts.StatusConst.BatchStatusDef;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.utils.DateTimeUtil;

/**
 * base Batch表
 * 
 * @author jiang_nan
 *
 */
public abstract class BaseBatch {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BaseBatch.class);
    @Autowired
    private BatchRecordLogic batchRecordLogic;

    /**
     * Batch执行表
     * 
     * @param args
     *        参数
     */
    public void execution(String[] args) {
        String batchId = args[0];
        long startTime = System.currentTimeMillis();
        logger.info(batchId + " Batch 开始执行");
        int length = args.length;
        String[] data = null;
        if (length > IntDef.INT_ONE) {
            data = new String[length - IntDef.INT_ONE];
            length = data.length;
            for (int i = 0; i < length; i++) {
                data[i] = args[i + 1];
            }
        }
        BaseParam param = this.createParam(data);
        // 更新Batch状态-->执行中
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("batchCode", batchId);
        baseParam.setFilter("batchStatus", String.valueOf(BatchStatusDef.RUN));
        baseParam.setFilter("runStatus", String.valueOf(BatchStatusDef.NEW));
        baseParam.setFilter("updId", "batch");
        baseParam.getFilterMap().put("updTime", DateTimeUtil.getCustomerDate());
        baseParam.setFilter("result", "Batch执行中");
        this.batchRecordLogic.modify(baseParam);
        baseParam.setFilter("runStatus", String.valueOf(BatchStatusDef.RUN));
        try {
            this.before(param);
            this.doOperate(param);
            this.after(param);
            baseParam.getFilterMap().put("updTime", DateTimeUtil.getCustomerDate());
            baseParam.setFilter("result", "Batch执行完成");
            baseParam.setFilter("batchStatus", String.valueOf(BatchStatusDef.END));
        } catch (Exception ex) {
            String exceptionMessage = ex.getMessage();
            if (exceptionMessage == null) {
                exceptionMessage = ex.toString();
                // } else {
                // if (exceptionMessage.length() > 500) {
                // exceptionMessage = exceptionMessage.substring(IntDef.INT_ZERO, IntDef.INT_FIVE_HUNDRED);
                // }
            }
            baseParam.getFilterMap().put("updTime", DateTimeUtil.getCustomerDate());
            baseParam.setFilter("result", "异常结束:" + exceptionMessage);
            baseParam.setFilter("batchStatus", String.valueOf(BatchStatusDef.EXCETION));
            logger.error("批处理实行异常", ex);
            ex.printStackTrace();
        } finally {
            this.batchRecordLogic.modify(baseParam);
            long endTime = System.currentTimeMillis();
            logger.info(batchId + "执行结束。花费时间:{} ms", endTime - startTime);
        }
    }

    /**
     * 创建Param
     * 
     * @param args
     *        参数
     * @return Param
     */
    public abstract BaseParam createParam(String[] args);

    /**
     * 业务处理
     * 
     * @param param
     *        param
     */
    public abstract void doOperate(BaseParam param);

    /**
     * 业务处理之前的操作
     * 
     * @param param
     *        param
     */
    public void before(BaseParam param) {
        // nothing to do in base batch
    }

    /**
     * 整体业务出来完了
     * 
     * @param param
     *        param
     */
    public void after(BaseParam param) {
        // nothing to do in base batch
    }
}
