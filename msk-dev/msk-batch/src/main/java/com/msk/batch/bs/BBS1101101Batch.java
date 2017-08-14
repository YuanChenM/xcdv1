package com.msk.batch.bs;

import com.msk.batch.base.BaseBatch;
import com.msk.batch.bs.logic.BBS1101101Logic;
import com.msk.batch.so.bean.BSO152401Param;
import com.msk.batch.so.logic.BSO152401Logic;
import com.msk.batch.so.logic.BSO152402Logic;
import com.msk.core.bean.BaseParam;
import com.msk.core.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * BBS1101101Batch.
 * 
 * @author gyh
 */
@Component("BBS1101101")
public class BBS1101101Batch extends BaseBatch {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BBS1101101Batch.class);

    /** 注入BSO152401Logic */
    @Autowired
    private BBS1101101Logic bbs1101101Logic;

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

//        if (args.length > 0) {
//            if (StringUtil.equals(args[0], "test")) {
//                param.setTest(true);
//            }
//        }
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
        logger.debug("BBS1101101Batch的doOperate");
        bbs1101101Logic.removeSlBsBuyer();
    }

}
