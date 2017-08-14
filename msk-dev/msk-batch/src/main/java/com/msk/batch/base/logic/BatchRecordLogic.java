package com.msk.batch.base.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.common.consts.StatusConst;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.exception.SystemException;

/**
 * Batch记录Logic
 * 
 * @author jiang_nan
 */
@Service
public class BatchRecordLogic extends BaseLogic {
    interface SqlId {
        String MAX_BATCH_ID = "maxBatchId";
    }

    /**
     * Check Batch是否存在和Batch是否处于执行中
     * 
     * @param batchId BatchId
     */
    @Transactional(readOnly = true)
    public void checkBatchRecord(String batchId) {
        BaseParam param = new BaseParam();
        param.setFilter("batchCode", batchId);
        param.setFilter("batchStatus", String.valueOf(StatusConst.BatchStatusDef.RUN));
        int count = this.getPageCount(param);
        if (count >= 1) {
            throw new SystemException("Batch ID" + batchId + "正在执行中,无法再次执行");
        }
    }

    public Long maxBatchId() {
        Long maxBatchId = (Long) super.getBaseDao().getSqlSession().selectOne(super.getSqlId(SqlId.MAX_BATCH_ID));
        if (maxBatchId == null) {
            maxBatchId = new Long(IntDef.INT_ZERO);
        }
        return maxBatchId + 1L;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
