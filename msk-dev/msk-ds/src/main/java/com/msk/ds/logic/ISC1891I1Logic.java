package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.RsRequest;
import com.msk.ds.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * ISC1891I1Logic.
 *
 * @author yuan_chen
 */
@Service
public class ISC1891I1Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISC1891I1Logic.class);

    /**
     *
     * SqlId.
     *
     * @author pxg
     */
    interface SqlId {
        /** 订单主 */
        static final String SQL_ID_GET_UN_STOCK_NUM = "getUnStockNum";
    }

    /**
     * (non-Javadoc)
     *
     * @see com.msk.core.base.BaseLogic#setBaseDao(com.msk.core.base.BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    /**
     * 查询供应计划尚未入库的供应量
     *
     * @param param param
     * @return 查询供应计划尚未入库的供应量
     */
    @Transactional(readOnly = true)
//    public List<ISC1891I1RsResult> findRsResult(ISC1891I1RsParam param) {
    public ISC1891I1RsResult findAllList(RsRequest<ISC1891I1RsParam> param) {
        logger.info("查询供应计划尚未入库的供应量");

        ISC1891I1RsResult returnRst = new ISC1891I1RsResult();

        List<ISC1891I1RsResultInfo> isc1891I1RsResults = new ArrayList<ISC1891I1RsResultInfo>();
        Map<String, Object> paramMap = new HashMap<String, Object>();

        paramMap.put("distMonth",param.getParam().getDistMonth());
        paramMap.put("lgcsCode",param.getParam().getLgcsCode());
        paramMap.put("suppCode",param.getParam().getSuppCode());
        paramMap.put("pdCode",param.getParam().getPdCode());
        isc1891I1RsResults = super.findList(paramMap, SqlId.SQL_ID_GET_UN_STOCK_NUM);
        returnRst.setReturnInfos(isc1891I1RsResults);
        return returnRst;
    }
}
