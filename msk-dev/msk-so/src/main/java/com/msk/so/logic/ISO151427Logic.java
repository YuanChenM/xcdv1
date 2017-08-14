package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.so.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang_shuai on 2016/6/23.
 */
@Service
public class ISO151427Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151427Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    @Transactional(readOnly = true)
    public ISO151427Result findSettlementDetail(ISO151427RsParam iso151427RsParam){
        ISO151427Result result = new ISO151427Result();
        List<ISO151427SettlementDetail> resultList = new ArrayList<ISO151427SettlementDetail>();

        if(iso151427RsParam.getPageCount() != NumberConst.IntDef.INT_ZERO && iso151427RsParam.getPageNo() != NumberConst.IntDef.INT_ZERO)
        {
            iso151427RsParam.setPaging(true);
        }
        else
        {
            iso151427RsParam.setPaging(false);
        }
        resultList = this.findPageList(iso151427RsParam,result);
        if(!CollectionUtils.isEmpty(resultList))
        {
            for(ISO151427SettlementDetail settlementDetail :resultList){
                BaseParam param  = new BaseParam();
                param.getFilterMap().put("orderId",settlementDetail.getOrderId());
                // Modify for Bug#结算接口修改 at 2016/09/12 by sun_jiaju Start
                param.getFilterMap().put("sellerCode",iso151427RsParam.getSellerId());
                // Modify for Bug#结算接口修改 at 2016/09/12 by sun_jiaju End
                List<ISO151427SoProduct> productsList = this.findList(SqlId.SQL_ID_FIND_PD_INFO,param);
                settlementDetail.setPdList(productsList);

            }
        }
        result.setResultList(resultList);

        return result;
    }
    interface SqlId{
        String SQL_ID_FIND_PD_INFO = "findPdInfo";
    }
}
