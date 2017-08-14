package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.so.bean.ISO151428BuyRecord;
import com.msk.so.bean.ISO151428RsParam;
import com.msk.so.bean.ISO151428RsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang_shuai on 2016/6/24.
 */
@Service
public class ISO151428Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151428Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    @Transactional(readOnly = true)
    public ISO151428RsResult findBuyRecord(ISO151428RsParam iso151428RsParam){
        logger.info("查询购买记录分页信息");
        ISO151428RsResult result = new ISO151428RsResult();
        List<ISO151428BuyRecord> resultList = new ArrayList<ISO151428BuyRecord>();
        if(iso151428RsParam.getPageCount() != NumberConst.IntDef.INT_ZERO && iso151428RsParam.getPageNo() != NumberConst.IntDef.INT_ZERO)
        {
            iso151428RsParam.setPaging(true);
        }
        else
        {
            iso151428RsParam.setPaging(false);
        }
        resultList = this.findPageList(iso151428RsParam,result);
        result.setBuyRecordList(resultList);
        return result;
    }

}
