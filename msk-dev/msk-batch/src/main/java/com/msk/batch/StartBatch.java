package com.msk.batch;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.base.BaseStartBatch;
import com.msk.common.logic.ConfigLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.entity.CommConfig;
import com.msk.core.utils.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * 启动主Batch.
 *
 * @author jiang_nan
 */
public class StartBatch extends BaseStartBatch {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BaseBatch.class);

    /**
     * 启动操作
     *
     * @param args args
     */
    public static void main(String[] args) {
        checkParam(args);
        loadLog();
        ApplicationContext context = getApplicationContext();
        String batchId = args[IntDef.INT_ZERO];

        logger.info("正在启动Batch[{}]。Version:{}", batchId, ConfigManager.getSystemVersion());

        try {
            // 加载Config DB数据
            ConfigLogic configLogic = context.getBean("configLogic", ConfigLogic.class);
            List<CommConfig> configList = configLogic.findList(new BaseParam());
            ConfigManager.initConfigValue(configList);

            LockBatch lockBatch = context.getBean("lockBatch", LockBatch.class);
            lockBatch.lockBatch(batchId);
            BaseBatch batch = getBaseBatch(context, batchId);

            batch.execution(args);
        } catch (Exception e) {
            logger.error("异常终了Batch[{}]。", batchId, e);
        }
    }
}
