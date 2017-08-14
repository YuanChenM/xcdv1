package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.so.bean.ISO151421ComplainRsResult;
import com.msk.so.bean.ISO151421RsParam;
import com.msk.so.bean.ISO151421RsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 投诉一览查询ISO151421Logic.
 *
 * @author sjj
 */
@Service
public class ISO151421Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151421Logic.class);

    /**
     * 投诉一览查询
     *
     * @param param param
     * @return 返回结果
     * @author sjj
     */
    public ISO151421RsResult findComplainList(ISO151421RsParam param) {
        logger.info("投诉一览查询接口logic");
        ISO151421RsResult result = new ISO151421RsResult();
        List<ISO151421ComplainRsResult> complainRsResults = new ArrayList<ISO151421ComplainRsResult>();
        if (param.getPageCount() != NumberConst.IntDef.INT_ZERO && param.getPageNo() != NumberConst.IntDef.INT_ZERO) {
            param.setPaging(true);
        } else {
            param.setPaging(false);
        }
        complainRsResults = this.findPageList(param, result);
        result.setComplains(complainRsResults);
        return result;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
