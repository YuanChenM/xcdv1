package com.msk.batch;

import com.msk.batch.base.logic.BatchRecordLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msk.common.consts.StatusConst.BatchStatusDef;
import com.msk.core.entity.BatchRecord;
import com.msk.core.utils.DateTimeUtil;

/**
 * Batch锁，如果Batch已经执行，无法再次启动Batch
 * 
 * @author jiang_nan
 */
@Component
public class LockBatch {
    /** Batch Record Logic */
    @Autowired
    private BatchRecordLogic batchRecordLogic;
    /**
     * Lock Batch
     * @param batchId Batch Id
     */
    public void lockBatch(String batchId) {
        batchRecordLogic.checkBatchRecord(batchId);
        BatchRecord batchRecord = new BatchRecord();
        batchRecord.setRunId(this.batchRecordLogic.maxBatchId());
        batchRecord.setBatchCode(batchId);
        batchRecord.setStatus(BatchStatusDef.NEW);
        batchRecord.setCrtId("batch");
        batchRecord.setCrtTime(DateTimeUtil.getCustomerDate());
        this.batchRecordLogic.save(batchRecord);
    }
}
