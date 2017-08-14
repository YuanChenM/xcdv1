package com.msk.sl.logic;

import java.util.ArrayList;
import java.util.List;

import com.msk.sl.bean.ISL231119RsParam;
import com.msk.sl.bean.ISL231119RsResult;
import com.msk.sl.bean.SlLogiAreaPdBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;

/**
 * ISL231119Logic.
 *
 * @author yuan_chen
 */
public class ISL231119Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231119Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_ling
     */
    interface SqlId {
        static final String SQL_ID_COUNT = "count";
    }

    /**
     * (non-Javadoc)
     *
     * @see BaseLogic#setBaseDao(BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    /**
     * 物流区产品信息查询
     *
     * @param param param
     * @return 分页结果
     */
    @Transactional(readOnly = true)
    public ISL231119RsResult findRsResult(ISL231119RsParam param) {
        logger.info("物流区卖家产品信息查询");
        if (param == null){
            param = new ISL231119RsParam();
        }
        ISL231119RsResult rsResult = new ISL231119RsResult();
        List<SlLogiAreaPdBean> logiAreaPdBeans = new ArrayList<SlLogiAreaPdBean>();

        rsResult.setTotalCount(super.getCount(SqlId.SQL_ID_COUNT, param));
        rsResult.setPageNo(param.getPageNo());
        if (rsResult.getTotalCount() != NumberConst.IntDef.INT_ZERO) {
            logiAreaPdBeans = super.findList(param);
            rsResult.setTotalPage(rsResult.getTotalCount(), param.getPageCount());
        }

        rsResult.setSlLogiAreaPdBeanList(logiAreaPdBeans);
        return rsResult;
    }
}
